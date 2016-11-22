/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.harlock.dao;

import br.harlock.model.Titulo;
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
public class TituloDAOTest {
    
    public TituloDAOTest() {
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
     * Test of Inserir method, of class TituloDAO.
     */
    @Test
    public void testInserir() {
        System.out.println("Inserir");
        Titulo titulo = null;
        TituloDAO instance = new TituloDAO();
        instance.Inserir(titulo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of Remover method, of class TituloDAO.
     */
    @Test
    public void testRemover() {
        System.out.println("Remover");
        Titulo titulo = null;
        TituloDAO instance = new TituloDAO();
        instance.Remover(titulo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of Update method, of class TituloDAO.
     */
    @Test
    public void testUpdate() {
        System.out.println("Update");
        Titulo titulo = null;
        TituloDAO instance = new TituloDAO();
        instance.Update(titulo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ConsultarTodos method, of class TituloDAO.
     */
    @Test
    public void testConsultarTodos() {
        System.out.println("ConsultarTodos");
        TituloDAO instance = new TituloDAO();
        Iterator<Titulo> expResult = null;
        Iterator<Titulo> result = instance.ConsultarTodos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of Pesquisar method, of class TituloDAO.
     */
    @Test
    public void testPesquisar() {
        System.out.println("Pesquisar");
        String ID_TITU = "";
        TituloDAO instance = new TituloDAO();
        Titulo expResult = null;
        Titulo result = instance.Pesquisar(ID_TITU);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
