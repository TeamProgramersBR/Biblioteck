/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.harlock.dao;

import br.harlock.model.Emprestimo;
import java.util.Iterator;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author kai
 */
public class EmprestimoDAOTest {
    
    public EmprestimoDAOTest() {
    }

    /**
     * Test of Inserir method, of class EmprestimoDAO.
     */
    @Test
    public void testInserir() throws Exception {
        System.out.println("Inserir");
        Emprestimo emprestimo = null;
        EmprestimoDAO instance = new EmprestimoDAO();
        instance.Inserir(emprestimo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of Remover method, of class EmprestimoDAO.
     */
    @Test
    public void testRemover() throws Exception {
        System.out.println("Remover");
        Emprestimo emprestimo = null;
        EmprestimoDAO instance = new EmprestimoDAO();
        instance.Remover(emprestimo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of Update method, of class EmprestimoDAO.
     */
    @Test
    public void testUpdate() throws Exception {
        System.out.println("Update");
        Emprestimo emprestimo = null;
        EmprestimoDAO instance = new EmprestimoDAO();
        instance.Update(emprestimo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of Pesquisar method, of class EmprestimoDAO.
     */
    @Test
    public void testPesquisar() throws Exception {
        System.out.println("Pesquisar");
        Emprestimo emprestimo = null;
        EmprestimoDAO instance = new EmprestimoDAO();
        Emprestimo expResult = null;
        Emprestimo result = instance.Pesquisar(emprestimo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ConsultarTodos method, of class EmprestimoDAO.
     */
    @Test
    public void testConsultarTodos() throws Exception {
        System.out.println("ConsultarTodos");
        EmprestimoDAO instance = new EmprestimoDAO();
        Iterator<Emprestimo> expResult = null;
        Iterator<Emprestimo> result = instance.ConsultarTodos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
