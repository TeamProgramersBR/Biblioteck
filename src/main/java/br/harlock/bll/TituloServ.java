/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.harlock.bll;

import br.harlock.dao.AutorDAO;
import br.harlock.dao.ProdutoraDAO;
import br.harlock.dao.TituloDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author minerthal
 */
@WebServlet("/Titulo.do")
public class TituloServ extends HttpServlet {

    private String acao = "";
    private TituloDAO tituloDAO;
    private ProdutoraDAO produtoraDAO;
    private AutorDAO autorDAO;
    public TituloServ() throws Exception{
        tituloDAO = new TituloDAO();
        produtoraDAO = new ProdutoraDAO();
        autorDAO = new AutorDAO();
    }
     
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
            String pagina = "index.jsp";
            acao = request.getParameter("acao");
            if (acao.equals("tituloui")) {
                Iterator iteratorAutores = autorDAO.ConsultarTodos();
                Iterator iteratorProdutoraDeConteudo = produtoraDAO.ConsultarTodos();
                request.setAttribute("autores", iteratorAutores);
                request.setAttribute("prdoutoras", iteratorProdutoraDeConteudo);
                pagina = "index.jsp?pagina=tituloui";
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
