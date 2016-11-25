/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.harlock.dao;

import br.harlock.model.Autor;
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
public class AutorDAOTest {
    
    public AutorDAOTest() {
    }

    /**
     * Test of Inserir method, of class AutorDAO.
     */
    @Test
    public void testInserir() throws Exception {
        System.out.println("Inserir");
        Autor autor = new Autor(5, "mechamarorn", "pratal", "dsurub");
        AutorDAO instance = new AutorDAO();
        instance.Inserir(autor);
        Autor autor2 =instance.Pesquisar(autor);
        assertEquals(autor.getIdAutor(), autor2.getIdAutor());
    }

    /**
     * Test of Remover method, of class AutorDAO.
     */
//    @Test
//    public void testRemover() throws Exception {
//        System.out.println("Remover");
//        Autor autor = new Autor(4, "mechamarorn", "pratal", "dsurub");
//        AutorDAO instance = new AutorDAO();
//        instance.Remover(autor);
//        Autor autor2 =instance.Pesquisar(autor);
//        assertNotEquals(autor.getIdAutor(), autor2.getIdAutor());
//    }
//
//    /**
//     * Test of Update method, of class AutorDAO.
//     */
//    @Test
//    public void testUpdate() throws Exception {
//        System.out.println("Update");
//        Autor autor = new Autor(3, "mechamarorn", "pratal", "dsurub");
//        AutorDAO instance = new AutorDAO();
//        instance.Update(autor);
//        Autor autor2 =instance.Pesquisar(autor);
//        assertNotEquals(autor.getIdAutor(), autor2.getIdAutor());
//    }
//
//    /**
//     * Test of Pesquisar method, of class AutorDAO.
//     */
//    @Test
//    public void testPesquisar() throws Exception {
//        System.out.println("Pesquisar");
//        Autor autor = null;
//        AutorDAO instance = new AutorDAO();
//        Autor expResult = new Autor(3, "mechamarorn", "pratal", "dsurub");
//        Autor result = instance.Pesquisar(autor);
//        Autor autor2 =instance.Pesquisar(autor);
//        assertNotEquals(autor.getIdAutor(), autor2.getIdAutor());
//
//    }

    
    
}
