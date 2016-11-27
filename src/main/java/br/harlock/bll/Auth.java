/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.harlock.bll;

import br.harlock.dao.UsuarioDAO;
import br.harlock.model.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sun.security.provider.MD5;

/**
 *
 * @author minerthal
 */
@WebServlet("/Auth.do")
public class Auth extends HttpServlet {

    private UsuarioDAO usuDAO;
    private String acao = "";

    public Auth() throws Exception {
        usuDAO = new UsuarioDAO();
        acao = "";
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        HttpSession sessao = request.getSession();
        String pagina = "index.jsp";
        acao = request.getParameter("acao");
        
        if (acao.equals("entrar")) {
            Usuario usuario = new Usuario();
            // Aplica MD5
            br.harlock.model.MD5 md5 = new br.harlock.model.MD5();
            usuario.setEmail(request.getParameter("email"));
            usuario.setSenha(md5.toMD5(request.getParameter("senha")));
            usuario = usuDAO.Pesquisar(usuario);
            if (usuario != null) {
                if (usuario.getStatusDoUsuario().equals("liberado")) {
                // setando um atributo da sessao
                sessao.setAttribute("login", usuario);
                }
                // como obtive sucesso, chamo a página principal
                pagina = "index.jsp";
            }else{
                pagina = "index.jsp";
            }
        }
        if (acao.equals("sair")) {
            sessao.setAttribute("login", null);
            sessao.invalidate();
            pagina = "index.jsp";
        }
        response.sendRedirect(pagina);
                
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
        } catch (Exception ex) {
            Logger.getLogger(Auth.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (Exception ex) {
            Logger.getLogger(Auth.class.getName()).log(Level.SEVERE, null, ex);
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
