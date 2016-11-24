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
//        Usuario usuario = new Usuario(1, "1", "Administrador", "234567890", "robervalda", "rerere", "afajgdadsds", "5656566645", "4554545453", "fdhdhhh", "24535323532532532", "45445346644747", "768875532552353", "565466549769769676", "5645689989", "fudido");
//        UsuarioDAO instance = new UsuarioDAO();
//        instance.Inserir(usuario);
//        
//    }

    /**
     * Test of Remover method, of class UsuarioDAO.
     */
//    @Test
//    public void testRemover() {
//        System.out.println("Remover");
//        Usuario usuario = new Usuario(1, "1", "Administrador", "234567890", "robervalda", "rerere", "afajgdadsds", "5656566645", "4554545453", "fdhdhhh", "24535323532532532", "45445346644747", "768875532552353", "565466549769769676", "5645689989", "fudido");
//        UsuarioDAO instance = new UsuarioDAO();
//        instance.Remover(usuario);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of Update method, of class UsuarioDAO.
     */
//    @Test
//    public void testUpdate() {
//        System.out.println("Update");
//        Usuario usuario = new Usuario (1,"2", "Administrador", "234567890", "robervalda", "rerere", "afajgdadsds", "5656566645", "4554545453", "fdhdhhh", "24535323532532532", "45445346644747", "768875532552353", "565466549769769676", "5645689989", "fudido");
//        UsuarioDAO instance = new UsuarioDAO();
//        instance.Update(usuario);
//        // TODO review the generated test code and remove the default call to fail.
//        
//    }

    /**
     * Test of ConsultarTodos method, of class UsuarioDAO.
     */
//    @Test
//    public void testConsultarTodos() {
//        System.out.println("ConsultarTodos");
//        UsuarioDAO instance = new UsuarioDAO();
//        Iterator<Usuario> expResult = null;
//        Iterator<Usuario> result = instance.ConsultarTodos();
//        assertEquals(expResult, result);
//        
//    }

    /**
     * Test of Pesquisar method, of class UsuarioDAO.
     */
    @Test
    public void testPesquisar() throws Exception {
        System.out.println("Pesquisar");
        String ID_USU = "1";
        UsuarioDAO instance = new UsuarioDAO();
        Usuario expResult =new Usuario(1, "Funcionario", "Administrador", "234567890", "robervalda", "rerere", "afajgdadsds", "5656566645", "4554545453", "fdhdhhh", "24535323532532532", "45445346644747", "768875532552353", "565466549769769676", "5645689989", "fudido");
        Usuario u = new Usuario();
        u.setIdUsu(1);
        Usuario result = instance.Pesquisar(u);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }
    
}
