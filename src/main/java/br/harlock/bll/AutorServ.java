/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.harlock.bll;

import br.harlock.dao.AutorDAO;
import br.harlock.model.Autor;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author kai
 */
@WebServlet("/Autor.do")
public class AutorServ extends HttpServlet {

    private String acao = "";
    public AutorDAO DAO;

    public AutorServ() throws Exception {
        DAO = new AutorDAO();
        acao = "";
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        String pagina = "cadastroautor";
        Autor a = new Autor();

        a.setNome(request.getParameter("nome"));
        a.setNomeFantasia(request.getParameter("fantasia"));
        a.setNacionalidade(request.getParameter("nacio"));
        acao = request.getParameter("acao");
        if (acao.equalsIgnoreCase("cadastrar")) {
            DAO.Inserir(a);
        } else if (acao.equals("atualizar")) {
            a.setIdAutor(Integer.parseInt(request.getParameter("ID")));
            DAO.Update(a);
        } else if (acao.equals("remover")) {
            a.setIdAutor(Integer.parseInt(request.getParameter("ID")));
            DAO.Remover(a);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            processRequest(request, response); //To change body of generated methods, choose Tools | Templates.
        } catch (SQLException ex) {
            Logger.getLogger(AutorServ.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(AutorServ.class.getName()).log(Level.SEVERE, null, ex);
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
