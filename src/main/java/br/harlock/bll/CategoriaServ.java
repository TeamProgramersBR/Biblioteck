/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.harlock.bll;

import br.harlock.dao.CategoriaDAO;
import br.harlock.model.Categoriaitemacervo;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestWrapper;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author minerthal
 */
@WebServlet("/Categoria.do")
public class CategoriaServ extends HttpServlet {
    private CategoriaDAO DAO;
    private String acao = "";
    public CategoriaServ() throws Exception{
        DAO = new CategoriaDAO();
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, Exception {
            String pagina = "cadastrocategoria";
            
            Categoriaitemacervo c = new Categoriaitemacervo();
            
            c.setNomeCategoria(request.getParameter("nome"));
            c.setDescricao(request.getParameter("desc"));
            
        acao = request.getParameter("acao");
        
        if(acao.equals("salvar")){
            if (Integer.parseInt(request.getParameter("ID")) == 0) {
                DAO.Inserir(c);
            }else{
                c.setIdCat(Integer.parseInt(request.getParameter("ID")));
                DAO.Update(c);
            }           
            pagina = "Categoria.do?acao=categorias";
            
        }else if(acao.equals("update")){
            c.setIdCat(Integer.parseInt(request.getParameter("ID")));
            request.setAttribute("cat", DAO.Pesquisar(c));
            pagina =  "Categoria.do?acao=categorias";
        }else if(acao.equals("remover")){
            c.setIdCat(Integer.parseInt(request.getParameter("ID")));
            DAO.Remover(c);
            pagina =  "Categoria.do?acao=categorias";
        }else if(acao.equals("categorias")) {
            Iterator categorias = DAO.ConsultarTodos();
            request.setAttribute("categorias", categorias);
            pagina = "index.jsp?pagina=categoriasCTRL";
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
        } catch (Exception ex) {
            Logger.getLogger(CategoriaServ.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(CategoriaServ.class.getName()).log(Level.SEVERE, null, ex);
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
    
    public Iterator listarCategorias() throws SQLException{
        Iterator e = DAO.ConsultarTodos();
        return e;
    }
    public Categoriaitemacervo pesquisar(Categoriaitemacervo c) throws Exception{
        c = DAO.Pesquisar(c);
        return c;
    }
}
