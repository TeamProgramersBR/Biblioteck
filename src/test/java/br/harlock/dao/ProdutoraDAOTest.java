/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.harlock.dao;

import br.harlock.model.ProdutoraConteudo;
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
public class ProdutoraDAOTest {
    
    public ProdutoraDAOTest() {
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
     * Test of Inserir method, of class ProdutoraDAO.
     */
    @Test
    public void testInserir() {
        System.out.println("Inserir");
        ProdutoraConteudo produtora = null;
        ProdutoraDAO instance = new ProdutoraDAO();
        instance.Inserir(produtora);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of Remover method, of class ProdutoraDAO.
     */
    @Test
    public void testRemover() {
        System.out.println("Remover");
        ProdutoraConteudo produtora = null;
        ProdutoraDAO instance = new ProdutoraDAO();
        instance.Remover(produtora);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of Update method, of class ProdutoraDAO.
     */
    @Test
    public void testUpdate() {
        System.out.println("Update");
        ProdutoraConteudo produtora = null;
        ProdutoraDAO instance = new ProdutoraDAO();
        instance.Update(produtora);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ConsultarTodos method, of class ProdutoraDAO.
     */
    @Test
    public void testConsultarTodos() {
        System.out.println("ConsultarTodos");
        ProdutoraDAO instance = new ProdutoraDAO();
        Iterator<ProdutoraConteudo> expResult = null;
        Iterator<ProdutoraConteudo> result = instance.ConsultarTodos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of Pesquisar method, of class ProdutoraDAO.
     */
    @Test
    public void testPesquisar() {
        System.out.println("Pesquisar");
        String ID_PDC = "";
        ProdutoraDAO instance = new ProdutoraDAO();
        ProdutoraConteudo expResult = null;
        ProdutoraConteudo result = instance.Pesquisar(ID_PDC);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
