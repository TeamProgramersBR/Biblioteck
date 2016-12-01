/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.harlock.dao;

import br.harlock.model.Titulo;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import junit.framework.Assert;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 *
 * @author kai
 */
public class TituloDAOTest {
    
    public TituloDAOTest() {
    }
    
    /**
     * Test of Inserir method, of class TituloDAO.
     */
//    @Test
//    public void testInserir() throws Exception {
//        String date1 ="2016-11-25";    
//        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//        Date myDate1 =  formatter.parse(date1);
//        java.sql.Date sqlDate1 = new java.sql.Date(myDate1.getTime());
//        
//        System.out.println("Inserir");
//        Titulo titulo = new Titulo(3, 1, 2, "vamo", "s", "la", "adv", sqlDate1 , "ola", "q isso", "nova", "charmosa", "cheia", "mel");
//        TituloDAO instance = new TituloDAO();
//        instance.Inserir(titulo);
//        Titulo resul = instance.Pesquisar(titulo);
//         assertEquals(titulo.getIdTitu(), resul.getIdTitu());
//    }



//    /**
//     * Test of Update method, of class TituloDAO.
//     */
//    @Test
//    public void testUpdate() throws Exception {
//        String date1 ="2016-11-25";    
//        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//        Date myDate1 =  formatter.parse(date1);
//        java.sql.Date sqlDate1 = new java.sql.Date(myDate1.getTime());
//        
//        System.out.println("Update");
//        Titulo titulo = new Titulo(3, 1, 2, "nao vamo", "s", "la", "adv", sqlDate1 , "ola", "q isso", "nova", "charmosa", "cheia", "mel");
//        TituloDAO instance = new TituloDAO();
//        instance.Update(titulo);
//        Titulo resul = instance.Pesquisar(titulo);
//        assertEquals(titulo.getIsbn(), resul.getIsbn());
//        
//    }



    /**
     * Test of Pesquisar method, of class TituloDAO.
//     */
//    @Test
//    public void testPesquisar() throws Exception {
//        String date1 ="2016-11-25";    
//        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//        Date myDate1 =  formatter.parse(date1);
//        java.sql.Date sqlDate1 = new java.sql.Date(myDate1.getTime());
//        System.out.println("Pesquisar");
//        TituloDAO instance = new TituloDAO();
//        Titulo expResult = new Titulo(3, 1, 2, "nao vamo", "s", "la", "adv", sqlDate1 , "ola", "q isso", "nova", "charmosa", "cheia", "mel");
//        Titulo result = instance.Pesquisar(expResult);
//        assertEquals(expResult.getIdTitu(), result.getIdTitu());
//        
//    }
//    @Test
//    public void testConsultarTodos() throws Exception{
//        TituloDAO instance = new TituloDAO();
//        ArrayList<Titulo> result = new ArrayList();
//        result = (ArrayList<Titulo>) instance.ConsultarTodos();
//        String s = null;
//    }
//    
}
