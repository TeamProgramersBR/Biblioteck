/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.harlock.bll;

import br.harlock.dao.EmprestimoDAO;
import br.harlock.dao.ExemplarDAO;
import br.harlock.dao.UsuarioDAO;
import br.harlock.model.Emprestimo;
import br.harlock.model.Exemplar;
import br.harlock.model.Usuario;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author minerthal
 */
@WebServlet("/Emprestimo.do")
public class EmprestimoServ extends HttpServlet {

    private EmprestimoDAO emprestimoDAO;
    private UsuarioDAO usuarioDAO;
    private ExemplarDAO exemplarDAO;
    private String acao = "";

    public EmprestimoServ() throws Exception {
        emprestimoDAO = new EmprestimoDAO();
        usuarioDAO = new UsuarioDAO();
        exemplarDAO = new ExemplarDAO();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ParseException, Exception {
        HttpSession sessao = request.getSession();
        String pagina = "index.jsp";
        acao = request.getParameter("acao");
        Usuario usuarioRequere = new Usuario();
        ArrayList listaDeExemplares = new ArrayList();
        ArrayList emprestimosACancelar = new ArrayList();

        if (acao.equals("emprestimos")) {
            request.setAttribute("emprestimos", emprestimoDAO.ConsultarTodos());
            pagina = "index.jsp?pagina=emprestimosCTRL";
        }

        if (acao.equals("pesquisaExemplar")) {
            Exemplar consultarExemplar = new Exemplar();

            if (sessao == null) {
                sessao = request.getSession();
            } else {
                if (sessao.getAttribute("carrinho") != null) {
                    listaDeExemplares = (ArrayList) sessao.getAttribute("carrinho");
                }
                if (sessao.getAttribute("usuarioRequere") != null) {
                    usuarioRequere = (Usuario) sessao.getAttribute("usuarioRequere");
                }
                if (sessao.getAttribute("cancelarEmprestimos") != null) {
                    emprestimosACancelar = (ArrayList) sessao.getAttribute("cancelarEmprestimos");
                }

            }

            consultarExemplar.setFkTitulo(Integer.parseInt(request.getParameter("idT")));
            consultarExemplar.setIdExe(Integer.parseInt(request.getParameter("idE")));
            Exemplar exemplar = emprestimoDAO.PesquisarExemplarParamprestimo(consultarExemplar);
            if (exemplar == null) {
                pagina = "index.jsp?pagina=novoemprestimo&como=ExemplarNaoExiste";
            } else {
                String[] liberado = emprestimoDAO.exemplarLiberado(exemplar, usuarioRequere, (String) sessao.getAttribute("tipoDeEmprestimo"));
                boolean barrado = false;
                if (liberado[0].equals("true")) {
                    for (Object e : listaDeExemplares) {
                        Exemplar ep = (Exemplar) e;
                        if (exemplar.getIdExe() == ep.getIdExe()) {
                            barrado = true;
                            pagina = "index.jsp?pagina=novoemprestimo&como=jaestanacesta";
                        }
                    }
                    if (!barrado) {
                        String t = (String) sessao.getAttribute("tipoDeEmprestimo");
                        if (t.equals("Emprestimo")) {
                            exemplar.setStatusDeEmprestimo("2");
                        }else{
                            exemplar.setStatusDeEmprestimo("4");
                        }
                        listaDeExemplares.add(exemplar);
                        pagina = "index.jsp?pagina=novoemprestimo";
                    };
                    if (liberado[1] != null) {
                        Emprestimo emp = new Emprestimo();
                        exemplar.setStatusDeEmprestimo("3");
                        emp.setExemplar(exemplar);
                        emp.setIdEmp(Integer.parseInt(liberado[1]));
                        emp = emprestimoDAO.Pesquisar(emp);
                        emprestimosACancelar.add(emp);
                    }

                } else {
                    pagina = "index.jsp?pagina=novoemprestimo&como=indisponivel";
                }
                sessao.setAttribute("carrinho", listaDeExemplares);
            }
        }
        if (acao.equals("verificarUsuario")) {
            String cpf = request.getParameter("cpfR");
            usuarioRequere.setCpf(cpf);
            usuarioRequere = usuarioDAO.Pesquisar(usuarioRequere);
            sessao.setAttribute("usuarioRequere", usuarioRequere);
            if (usuarioRequere != null) {
                pagina = "index.jsp?pagina=novoemprestimo";
            } else {
                pagina = "index.jsp?pagina=novoemprestimo&usur=indisponivel";
            }
            if (sessao.getAttribute("tipoDeEmprestimoA") == null) {
                String y = request.getParameter("tipoDeEmprestimoA");
                sessao.setAttribute("tipoDeEmprestimo", request.getParameter("tipoDeEmprestimoA"));
            }
        }
        if (acao.equals("cancelar")) {
            sessao.setAttribute("usuarioRequere", null);
            sessao.setAttribute("usuarioRequere", null);
            sessao.setAttribute("carrinho", null);
            pagina = "index.jsp?pagina=novoemprestimo&usur=indisponivel";
        }

        if (acao.equals("concluirEmprestimo")) {

            if (sessao.getAttribute("carrinho") != null && sessao.getAttribute("usuarioRequere") != null) {
                listaDeExemplares = (ArrayList) sessao.getAttribute("carrinho");
                usuarioRequere = (Usuario) sessao.getAttribute("usuarioRequere");
                if (sessao.getAttribute("cancelarEmprestimos") != null) {
                    emprestimosACancelar = (ArrayList) sessao.getAttribute("cancelarEmprestimos");
                    emprestimoDAO.updateStatusExemplares(emprestimosACancelar);
                }
                Emprestimo novoEmprestimo = new Emprestimo();
                novoEmprestimo.setDataEmprestimo(request.getParameter("dataLocacao"));
                novoEmprestimo.setDataPrevDevolucao(request.getParameter("dataPrevisaoDevolucao"));
                novoEmprestimo.setUsuarioDoSistema(usuarioRequere);
                novoEmprestimo.setFkUsu(usuarioRequere.getIdUsu());
                novoEmprestimo.setSituacao(request.getParameter("statusEmprestimo"));
                emprestimoDAO.Inserir(novoEmprestimo, listaDeExemplares);
                sessao.setAttribute("carrinho", null);
                sessao.setAttribute("usuarioRequere", null);
                sessao.setAttribute("cancelarEmprestimos", null);
            }

            
        }
        if (acao.equals("detalhes")) {
            Emprestimo detalhes = new Emprestimo();
            detalhes.setIdEmp(Integer.parseInt(request.getParameter("ID")));
            detalhes = emprestimoDAO.Pesquisar(detalhes);
            request.setAttribute("emprestimo", detalhes);
            request.setAttribute("exemplares", exemplarDAO.listarExemplaresEmprestimo(detalhes));
            pagina = "index.jsp?pagina=empdetalhes";
        }
        if (acao.equals("mudarStatusEmprestimo")) {
            Emprestimo emprestimo = new Emprestimo();
            int idEmprestimo = Integer.valueOf(request.getParameter("IDEMP"));
            emprestimo.setIdEmp(idEmprestimo);
            emprestimo = emprestimoDAO.Pesquisar(emprestimo);
            String statusGeral =  request.getParameter("status");
            emprestimo.setSituacao(statusGeral);
            String[] exemplares = request.getParameterValues("statusExemplar");
            if (statusGeral.equals("6") || statusGeral.equals("2")) {
                    Date date = new Date();
                    String modifiedDate= new SimpleDateFormat("yyyy-MM-dd").format(date);
                    emprestimo.setDataDevolucao(modifiedDate);
                    emprestimoDAO.Update(emprestimo, null);
                    
            }else{
            ArrayList<Exemplar> exemps = new ArrayList();
            for (String exemplarUP: exemplares) {
                Exemplar exp = new Exemplar();
                String[] temp = exemplarUP.split("#");
                exp.setStatusDeEmprestimo(temp[0]);
                exp.setIdExe(Integer.parseInt(temp[1]));
                exp.setFkEmprestimo(idEmprestimo);
                
            }
            emprestimoDAO.Update(emprestimo, exemps.iterator());
          }
            
        }
        request.getRequestDispatcher(pagina).forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException | ParseException ex) {
            Logger.getLogger(EmprestimoServ.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(EmprestimoServ.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException | ParseException ex) {
            Logger.getLogger(EmprestimoServ.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {

            Logger.getLogger(EmprestimoServ.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
