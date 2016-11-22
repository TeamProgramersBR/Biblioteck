/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.harlock.dao;

import br.harlock.model.Usuario;
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
public class UsuarioDAOTest {
    
    public UsuarioDAOTest() {
    }
    
    

    /**
     * 0, 1, "1", "root", "123456789", "ahadoro@hotmail", "32135465", "321321321", "265465465465", "5665654", "haleluja", "aaaaaaaaahahahaha", "789464513", "guiana", "do", "sul", "ativao"
     */
//    @Test
//    public void testInserir() {
//        System.out.println("Inserir");
//        Usuario usuario = new Usuario(0, 0, "1", "reginaldo", "9868758558", "ahadoro@hotmail", "39847298", "0694808255", "0238559850", "halelujah", "pegueiopiriquito", "ruasarau", "papapa", "papatibun", "butao", "cu", "ativao");
//        UsuarioDAO instance = new UsuarioDAO();
//        instance.Inserir(usuario);
//        
//    }

    /**
     * Test of Remover method, of class UsuarioDAO.
     */
    @Test
    public void testRemover() {
        System.out.println("Remover");
        Usuario usuario = new Usuario(0, 0, "1", "reginaldo", "9868758558", "ahadoro@hotmail", "39847298", "0694808255", "0238559850", "halelujah", "pegueiopiriquito", "ruasarau", "papapa", "papatibun", "butao", "cu", "ativao");
        UsuarioDAO instance = new UsuarioDAO();
        instance.Remover(usuario);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of Update method, of class UsuarioDAO.
     */
    @Test
    public void testUpdate() {
        System.out.println("Update");
        Usuario usuario = null;
        UsuarioDAO instance = new UsuarioDAO();
        instance.Update(usuario);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ConsultarTodos method, of class UsuarioDAO.
     */
    @Test
    public void testConsultarTodos() {
        System.out.println("ConsultarTodos");
        UsuarioDAO instance = new UsuarioDAO();
        Iterator<Usuario> expResult = null;
        Iterator<Usuario> result = instance.ConsultarTodos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of Pesquisar method, of class UsuarioDAO.
     */
    @Test
    public void testPesquisar() {
        System.out.println("Pesquisar");
        String ID_USU = "";
        UsuarioDAO instance = new UsuarioDAO();
        Usuario expResult = null;
        Usuario result = instance.Pesquisar(ID_USU);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
