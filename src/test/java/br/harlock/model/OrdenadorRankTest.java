/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.harlock.model;

import br.harlock.dao.TituloDAO;
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
public class OrdenadorRankTest {
    
    public OrdenadorRankTest() {
    }
    
    

    /**
     * Test of isPrimeiro method, of class OrdenadorRank.
     */
    @Test
    public void testIsPrimeiro() throws Exception {
        System.out.println("isPrimeiro");
        TituloDAO DAO = new TituloDAO();
        
        OrdenadorRank ord = new OrdenadorRank(DAO.ConsultarTodos());
        ord.ordenarTela();
        
        
        
        
    }
    
}
