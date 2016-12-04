/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.harlock.bll;

import br.harlock.dao.ExemplarDAO;
import br.harlock.model.Exemplar;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author minerthal
 */
@WebServlet("/Exemplar.do")
public class ExemplarServ extends HttpServlet {
    private ExemplarDAO exemplarDAO;
    private String acao = "";
    public ExemplarServ() throws Exception{
        exemplarDAO = new ExemplarDAO();
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String pagina = "listarExemplares";
        String idadd = request.getParameter("IDt");
        Exemplar exemplar = new Exemplar(" ");
        acao = request.getParameter("acao");
        if(acao.equals("delete")){
        if(request.getParameter("ID") != null){
            String idel = request.getParameter("ID");
            exemplar.setIdExe(Integer.parseInt(idel));
            exemplarDAO.Remover(exemplar);
            pagina = "Titulo.do?acao=exemplar&ID="+idadd;
        }}else if(acao.equals("insert")){
        if(request.getParameter("Disp") != null){
            
            String Dispo = request.getParameter("Disp");
            if(Dispo.equals("s")){
                //1
                exemplar.setFkTitulo(Integer.parseInt(idadd));
                exemplar.setLiberadoParaEmprestimo(Boolean.TRUE);
                exemplarDAO.Inserir(exemplar);
            }else if(Dispo.equals("n")){
                //0
                exemplar.setFkTitulo(Integer.parseInt(idadd));
                exemplar.setLiberadoParaEmprestimo(Boolean.FALSE);
                exemplarDAO.Inserir(exemplar);
            }}
            pagina = "Titulo.do?acao=exemplar&ID="+idadd;
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
        processRequest(request, response);
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
        processRequest(request, response);
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
