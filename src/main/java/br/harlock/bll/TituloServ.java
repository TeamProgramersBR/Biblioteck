/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.harlock.bll;

import br.harlock.conn.Conexao;
import br.harlock.dao.AutorDAO;
import br.harlock.dao.CategoriaDAO;
import br.harlock.dao.ExemplarDAO;
import br.harlock.dao.ProdutoraDAO;
import br.harlock.dao.TituloDAO;
import br.harlock.model.Autor;
import br.harlock.model.Categoriaitemacervo;
import br.harlock.model.Exemplar;
import br.harlock.model.ProdutoraConteudo;
import br.harlock.model.Titulo;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialBlob;

/**
 *
 * @author minerthal
 */
@WebServlet("/Titulo.do")
public class TituloServ extends HttpServlet {

    private Connection connection = null;
    private String acao = "";
    private TituloDAO tituloDAO;
    private ProdutoraDAO produtoraDAO;
    private AutorDAO autorDAO;
    private Autor autor;
    private CategoriaDAO categoriaDAO;
    private ExemplarDAO exemplarDAO;
    private Exemplar exemplarMod;

    public TituloServ() throws Exception {
        categoriaDAO = new CategoriaDAO();
        tituloDAO = new TituloDAO();
        produtoraDAO = new ProdutoraDAO();
        autorDAO = new AutorDAO();
        connection = Conexao.getConexao();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ParseException, Exception {
        String pagina = "index.jsp";
        acao = request.getParameter("acao");

        Titulo ti = new Titulo(" ");
        ProdutoraConteudo produtoraConteudo = new ProdutoraConteudo();

        if (acao.equals("tituloui")) {
            Iterator iteratorAutores = autorDAO.ConsultarTodos();
            Iterator iteratorProdutoraDeConteudo = produtoraDAO.ConsultarTodos();
            Iterator iteratorCategoria = categoriaDAO.ConsultarTodos();
            request.setAttribute("autores", iteratorAutores);
            request.setAttribute("prdoutoras", iteratorProdutoraDeConteudo);
            request.setAttribute("categorias", iteratorCategoria);
            pagina = "index.jsp?pagina=tituloui";
        }
        if (acao.equals("salvar")) {

            produtoraConteudo.setIdPdc(Integer.parseInt(request.getParameter("produtora")));
            ti.setProdutoraConteudo(produtoraConteudo);
            ti.setObra(request.getParameter("obra"));
            ti.setIssn(request.getParameter("ISSN"));
            ti.setIsbn(request.getParameter("ISBN"));
            ti.setTipoDeObra(request.getParameter("tipoObra"));
            ti.setIdioma(request.getParameter("idiomaObra"));
            String DAOact = "insert";
            if (request.getParameter("idTitulo") != null) {
                ti.setIdTitu(Integer.parseInt(request.getParameter("idTitulo")));
                DAOact = "update";
            }

            ti.setVolume(request.getParameter("Volume"));
            ti.setFkItemPdc(Integer.parseInt(request.getParameter("produtora")));
//                ti.setEdicao(request.getParameter(""));
            String f = request.getParameter("duracao");
            if (f == null) {
                ti.setDuracao(0);
            } else {
                ti.setDuracao(Float.parseFloat(request.getParameter("duracao")));
            }
            String PG = request.getParameter("numeropaginas");
            if (PG == null) {
                ti.setQuantidadePaginas(0);
            } else {
                ti.setQuantidadePaginas(Float.parseFloat(request.getParameter("numeropaginas")));
            }
            ti.setDescricao(request.getParameter("descricao"));
            ti.setDataDePublicacao(request.getParameter("datapublicacao"));
            ti.setEstadoPublicacao(request.getParameter("estado"));
            ti.setCidadePublicacao(request.getParameter("cidade"));
            Categoriaitemacervo categoriaitemacervo = new Categoriaitemacervo();
            categoriaitemacervo.setIdCat(Integer.parseInt(request.getParameter("categoria")));
            ti.setFkItemAcervo(categoriaitemacervo.getIdCat());
            String stt = request.getParameter("base64img");
            Blob blob = new SerialBlob(stt.getBytes());
            ti.setCapa(blob);
            ti.setTraducao(request.getParameter("traducao"));
            if (DAOact.equalsIgnoreCase("insert")) {
                tituloDAO.Inserir(ti);
            }else if(DAOact.equalsIgnoreCase("update")){
                tituloDAO.Update(ti);
            }
            ti = tituloDAO.Pesquisar(ti);
            String[] autres = request.getParameterValues("autores");
            String[] idAutores = request.getParameterValues("idAutor");
            String[] exemplares = request.getParameterValues("exemplar");
            String[] liberadoEmp = request.getParameterValues("liberadoParaEmprestimo");
            String nul = null;
            String sql = "";
            if(DAOact.equalsIgnoreCase("update")){
                sql = "UPDATE titulo_tem_autor SET Titulo_idTitulo  = ?,Autor_idAutor = ?,TipoDeAutor = ? WHERE Titulo_idTitulo = ? AND Autor_idAutor = ?";
            }else if(DAOact.equalsIgnoreCase("insert")){
                sql = "INSERT INTO titulo_tem_autor (Titulo_idTitulo, Autor_idAutor, TipoDeAutor) VALUES ( ? , ? , ? )";
            }
            PreparedStatement ps = connection.prepareStatement(sql);
            for (int i = 0; i < autres.length; i++) {

                ps.setInt(1, ti.getIdTitu());
                ps.setInt(2, Integer.parseInt(idAutores[i]));
                ps.setString(3, autres[i]);
                if(DAOact.equals("update")){
                ps.setInt(4, ti.getIdTitu());
                ps.setInt(5, Integer.parseInt(idAutores[i]));
                }
                ps.addBatch();
                if (i == autres.length - 1) {
                    ps.executeBatch();
                }

            }

            int liberado = exemplares.length - liberadoEmp.length;
            int nliberado = liberadoEmp.length;
            String sql1="";
//            if(DAOact.equals("update")){
//                sql1 = "UPDATE exemplar SET ID_EXE  = ?, LiberadoParaEmprestimo = ?, Duracao = ?, QuantidadePaginas = ?, FK_TITULO = ? WHERE ID_EXE = ?";
//            }else 
                if(DAOact.equals("insert")){
                sql1 = "INSERT INTO exemplar(LiberadoParaEmprestimo, Duracao, QuantidadePaginas, FK_TITULO)"
                    + " VALUES (?,?,?,?)";
            }
            ps = connection.prepareStatement(sql1);
            for (int i = 0; i < liberado; i++) {
                exemplarMod = new Exemplar(0, ti.getIdTitu(), Boolean.TRUE, String.valueOf(ti.getDuracao()), String.valueOf(ti.getQuantidadePaginas()));
                ps.setBoolean(1, exemplarMod.getLiberadoParaEmprestimo());
                ps.setString(2, exemplarMod.getDuracao());
                ps.setString(3, exemplarMod.getQuantidadePaginas());
                ps.setInt(4, exemplarMod.getFkTitulo());
                ps.addBatch();
                if (i == liberado - 1) {
                    for (int j = 0; j < nliberado; j++) {
                        exemplarMod = new Exemplar(0, ti.getIdTitu(), Boolean.FALSE, String.valueOf(ti.getDuracao()), String.valueOf(ti.getQuantidadePaginas()));
                        ps.setBoolean(1, exemplarMod.getLiberadoParaEmprestimo());
                        ps.setString(2, exemplarMod.getDuracao());
                        ps.setString(3, exemplarMod.getQuantidadePaginas());
                        ps.setInt(4, exemplarMod.getFkTitulo());
                        ps.addBatch();
                        if (j == nliberado - 1) {
                            ps.executeBatch();
                        }
                    }

                }
            }

        } else if (acao.equals("update")) {
            Iterator iteratorAutores = autorDAO.ConsultarTodos();
            Iterator iteratorProdutoraDeConteudo = produtoraDAO.ConsultarTodos();
            Iterator iteratorCategoria = categoriaDAO.ConsultarTodos();
            request.setAttribute("autores", iteratorAutores);
            request.setAttribute("prdoutoras", iteratorProdutoraDeConteudo);
            request.setAttribute("categorias", iteratorCategoria);
            ti.setIdTitu(Integer.parseInt(request.getParameter("ID")));
            request.setAttribute("titulo",tituloDAO.Pesquisar(ti));
            pagina = "index.jsp?pagina=tituloui"; 
            //nao exibe tudo na tela,olhar o titulo retornado e o preenchemento da mesma

        } else if (acao.equals("titulos")) {
            Iterator titulos = tituloDAO.ConsultarTodos();
            request.setAttribute("titulos", titulos);
            Iterator categorias = categoriaDAO.ConsultarTodos();
            request.setAttribute("categorias", categorias);
            pagina = "index.jsp?pagina=titulosCTRL";
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
        } catch (SQLException ex) {
            Logger.getLogger(TituloServ.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(TituloServ.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(TituloServ.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (SQLException ex) {
            Logger.getLogger(TituloServ.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(TituloServ.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(TituloServ.class.getName()).log(Level.SEVERE, null, ex);
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
