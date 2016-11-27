/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.harlock.bll;

import br.harlock.dao.UsuarioDAO;
import br.harlock.model.MD5;
import br.harlock.model.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
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
@WebServlet("/Usuario.do")
public class UsuarioServ extends HttpServlet {

    private String acao = "";
    private UsuarioDAO DAO;
    private MD5 pss;

    public UsuarioServ() throws Exception {
        DAO = new UsuarioDAO();

        pss = new MD5();

    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, NoSuchAlgorithmException {
        String pagina = "cadastrousu.html";
        acao = request.getParameter("acao");
        Usuario u = new Usuario();

        u.setNivelDeAcesso(request.getParameter("acesso"));
        u.setNome(request.getParameter("nome"));
        u.setCpf(request.getParameter("CPF"));
        u.setEmail(request.getParameter("email"));
        u.setSenha(pss.toMD5(request.getParameter("senha")));
        u.setNumeroResidencial(request.getParameter("telres"));
        u.setNumeroCelular(request.getParameter("telcel"));
        u.setNumeroComercial(request.getParameter("telcom"));
        u.setMatriculaEducacional(request.getParameter("matricula"));
        u.setEnderecoLogadouro(request.getParameter("logr"));
        u.setEnderecoCEP(request.getParameter("CEP"));
        u.setEnderecoCidade(request.getParameter("cidade"));
        u.setEnderecoEstado(request.getParameter("estado"));
        u.setEnderecoPais(request.getParameter("pais"));
        u.setStatusDoUsuario(request.getParameter("sts"));
        if (acao.equalsIgnoreCase("cadastrar")) {

            u.setStatusDoUsuario("Pendente");
            DAO.Inserir(u);
            pagina = "index.jsp?acao=logar";
        } else if (acao.equals("atualizar")) {
            u.setIdUsu(Integer.parseInt(request.getParameter("ID")));
            DAO.Update(u);
            pagina = "index.jsp?acao=logar";
        } else if (acao.equals("remover")) {
            u.setIdUsu(Integer.parseInt(request.getParameter("ID")));
            DAO.Remover(u);
            pagina = "index.jsp?acao=logar";
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
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(UsuarioServ.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(UsuarioServ.class.getName()).log(Level.SEVERE, null, ex);
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
