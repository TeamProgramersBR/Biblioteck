/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.harlock.dao;

import br.harlock.model.Emprestimo;
import br.harlock.model.Exemplar;
import br.harlock.model.Usuario;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
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
//    @Test
//    public void testInserir() throws Exception {
//        String date1 ="2016-11-24";
//        String date2 = "2016-12-03";
//        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//        Date myDate1 = formatter.parse(date1);
//        Date myDate2 = formatter.parse(date1);
//        java.sql.Date sqlDate1 = new java.sql.Date(myDate1.getTime());
//        java.sql.Date sqlDate2 = new java.sql.Date(myDate1.getTime());
//        System.out.println("Inserir");
//        Emprestimo emprestimo = new Emprestimo(2,1, 1,sqlDate1, sqlDate2, sqlDate2, new Long(123) , "1", Boolean.FALSE);
//        EmprestimoDAO instance = new EmprestimoDAO();
//        instance.Inserir(emprestimo);
//        Emprestimo resul = instance.Pesquisar(emprestimo);
//        assertEquals(emprestimo, resul);
//        
//    }


    /**
     * Test of Update method, of class EmprestimoDAO.
     */
//    @Test
//    public void testUpdate() throws Exception {
//        try{
//        System.out.println("Update");
//        String date1 ="2016-11-24";
//        String date2 = "2016-12-03";
//        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//        Date myDate1 = formatter.parse(date1);
//        Date myDate2 = formatter.parse(date1);
//        java.sql.Date sqlDate1 = new java.sql.Date(myDate1.getTime());
//        java.sql.Date sqlDate2 = new java.sql.Date(myDate1.getTime());
//        
//        Emprestimo emprestimo = new Emprestimo(3,1, 1,sqlDate1,sqlDate2,sqlDate2 , new Long(123) , "2", Boolean.TRUE);
//        EmprestimoDAO instance = new EmprestimoDAO();
//        instance.Update(emprestimo);
//        Emprestimo resul = instance.Pesquisar(emprestimo);
//            assertEquals(emprestimo.getReserva(), resul.getReserva());
//        }catch(Exception e){
//        e.printStackTrace();
//        }}

    /**
     * Test of Pesquisar method, of class EmprestimoDAO.
     */
//    @Test
//    public void testPesquisar() throws Exception {
//        System.out.println("Pesquisar");
//        System.out.println("Update");
//        String date1 ="2016-11-24";
//        String date2 = "2016-12-03";
//        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//        Date myDate1 = formatter.parse(date1);
//        Date myDate2 = formatter.parse(date1);
//        java.sql.Date sqlDate1 = new java.sql.Date(myDate1.getTime());
//        java.sql.Date sqlDate2 = new java.sql.Date(myDate1.getTime());
//        
//        Emprestimo emprestimo = new Emprestimo(3,1, 1,sqlDate1,sqlDate2,sqlDate2 , new Long(123) , "2", Boolean.FALSE);
//        EmprestimoDAO instance = new EmprestimoDAO();
//        
//        Emprestimo result = instance.Pesquisar(emprestimo);
//        assertEquals(emprestimo.getIdEmp(), result.getIdEmp());
//        
//    }
//
        @Test
        public void testLiberadoParaEmrpestimo() throws Exception{
            System.out.println("Teste liberado para emprestimo");
            Exemplar exemplar = new Exemplar();
            Usuario usuario = new Usuario();
            String tipoDeEmprestimo = "Emprestimo";
            EmprestimoDAO instance = new EmprestimoDAO();
            String[] resultadoEsperado = new String[2];
            resultadoEsperado[0] = "true";
            resultadoEsperado[1] = null;
            exemplar.setIdExe(1);
            usuario.setNivelDeAcesso("Aluno");
            String[] resultadoObtido = instance.exemplarLiberado(exemplar, usuario, tipoDeEmprestimo);
            Assert.assertArrayEquals(resultadoEsperado, resultadoObtido);
        }
         @Test
        public void testNAOLiberadoParaEmrpestimo() throws Exception{
            System.out.println("Teste Nao liberado para emprestimo");
            Exemplar exemplar = new Exemplar();
            Usuario usuario = new Usuario();
            String tipoDeEmprestimo = "Emprestimo";
            EmprestimoDAO instance = new EmprestimoDAO();
            String[] resultadoEsperado = new String[2];
            resultadoEsperado[0] = "true";
            resultadoEsperado[1] = null;
            exemplar.setIdExe(1);
            usuario.setNivelDeAcesso("Aluno");
            String[] resultadoObtido = instance.exemplarLiberado(exemplar, usuario, tipoDeEmprestimo);
            Assert.assertArrayEquals(resultadoEsperado, resultadoObtido);
        }
        @Test
        public void testFaltandoExemplarLiberadoParaEmrpestimo() throws Exception{
            System.out.println("Teste sem exemplar liberado para emprestimo");
            Exemplar exemplar = new Exemplar();
            Usuario usuario = new Usuario();
            String tipoDeEmprestimo = "Emprestimo";
            EmprestimoDAO instance = new EmprestimoDAO();
            String[] resultadoEsperado = new String[2];
            resultadoEsperado[0] = "true";
            resultadoEsperado[1] = null;
            exemplar.setIdExe(1);
            usuario.setNivelDeAcesso("Aluno");
            String[] resultadoObtido = instance.exemplarLiberado(exemplar, usuario, tipoDeEmprestimo);
            Assert.assertArrayEquals(resultadoEsperado, resultadoObtido);
        }
        @Test
        public void LiberarCasoSejaProfessorELivroEstejaEmReserva() throws Exception{
            System.out.println("Teste liberado caso quem requisita seja professor para emprestimo");
            Exemplar exemplar = new Exemplar();
            Usuario usuario = new Usuario();
            String tipoDeEmprestimo = "Emprestimo";
            EmprestimoDAO instance = new EmprestimoDAO();
            String[] resultadoEsperado = new String[2];
            resultadoEsperado[0] = "true";
            resultadoEsperado[1] = null;
            exemplar.setIdExe(1);
            usuario.setNivelDeAcesso("Professor");
            String[] resultadoObtido = instance.exemplarLiberado(exemplar, usuario, tipoDeEmprestimo);
            Assert.assertArrayEquals(resultadoEsperado, resultadoObtido);
        }
           @Test
        public void LiberarCasoSejaExemplarNaoExistaELivroEstejaEmReserva() throws Exception{
            System.out.println("Teste liberado para emprestimo");
            Exemplar exemplar = new Exemplar();
            Usuario usuario = new Usuario();
            String tipoDeEmprestimo = "Emprestimo";
            EmprestimoDAO instance = new EmprestimoDAO();
            String[] resultadoEsperado = new String[2];
            resultadoEsperado[0] = "false";
            resultadoEsperado[1] = null;
            exemplar.setIdExe(111);
            usuario.setNivelDeAcesso("Aluno");
            String[] resultadoObtido = instance.exemplarLiberado(exemplar, usuario, tipoDeEmprestimo);
            Assert.assertArrayEquals(resultadoEsperado, resultadoObtido);
        }


}

