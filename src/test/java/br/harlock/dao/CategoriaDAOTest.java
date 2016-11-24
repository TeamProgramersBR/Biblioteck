/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.harlock.dao;

import br.harlock.model.Categoriaitemacervo;
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
public class CategoriaDAOTest {
    
    public CategoriaDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of Inserir method, of class CategoriaDAO.
     */
    @Test
    public void testInserir() throws Exception {
        System.out.println("Inserir");
        Categoriaitemacervo categoria = null;
        CategoriaDAO instance = new CategoriaDAO();
        instance.Inserir(categoria);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of Remover method, of class CategoriaDAO.
     */
    @Test
    public void testRemover() throws Exception {
        System.out.println("Remover");
        Categoriaitemacervo categoria = null;
        CategoriaDAO instance = new CategoriaDAO();
        instance.Remover(categoria);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of Update method, of class CategoriaDAO.
     */
    @Test
    public void testUpdate() throws Exception {
        System.out.println("Update");
        Categoriaitemacervo categoria = null;
        CategoriaDAO instance = new CategoriaDAO();
        instance.Update(categoria);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of Pesquisar method, of class CategoriaDAO.
     */
    @Test
    public void testPesquisar() throws Exception {
        System.out.println("Pesquisar");
        Categoriaitemacervo categoria = null;
        CategoriaDAO instance = new CategoriaDAO();
        Categoriaitemacervo expResult = null;
        Categoriaitemacervo result = instance.Pesquisar(categoria);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ConsultarTodos method, of class CategoriaDAO.
     */
    @Test
    public void testConsultarTodos() throws Exception {
        System.out.println("ConsultarTodos");
        CategoriaDAO instance = new CategoriaDAO();
        Iterator<Categoriaitemacervo> expResult = null;
        Iterator<Categoriaitemacervo> result = instance.ConsultarTodos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
