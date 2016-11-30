/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.harlock.bll;

import br.harlock.dao.EmprestimoDAO;
import br.harlock.model.Emprestimo;
import br.harlock.model.Exemplar;
import br.harlock.model.Usuario;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
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
    private String acao = "";

    public EmprestimoServ() throws Exception {
        emprestimoDAO = new EmprestimoDAO();

    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ParseException, Exception {

        String pagina = "index.jsp";
        acao = request.getParameter("acao");
        
        
        if (acao.equals("emprestimos")) {
            Iterator lista = emprestimoDAO.ConsultarTodos();
            request.setAttribute("autor", lista);
            pagina = "index.jsp?pagina=emprestimosCTRL";
        }
        if (!response.isCommitted()) {
            RequestDispatcher dispatcher = request.getRequestDispatcher(pagina);
            dispatcher.forward(request, response);
        }
        if (acao.equals("pesquisaExemplar")) {
            HttpSession sessao = request.getSession();
            Exemplar consultarExemplar = new Exemplar();
            ArrayList listaDeExemplares = null;
            if (sessao == null) {
                listaDeExemplares = new ArrayList();
                sessao = request.getSession();
            } else {
               listaDeExemplares = (ArrayList) sessao.getAttribute("carrinho");
            }
            consultarExemplar.setFkTitulo(Integer.parseInt(request.getParameter("idT")));
            consultarExemplar.setIdExe(Integer.parseInt(request.getParameter("idE")));
            Exemplar exemplar = emprestimoDAO.PesquisarExemplarParamprestimo(consultarExemplar);
            if (exemplar == null) {
                pagina = "";
            }else{
                Emprestimo e = emprestimoDAO.exemplarLiberado(exemplar);
                
                listaDeExemplares.add(exemplar);
            }
        }
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
