/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.harlock.model;

import br.harlock.conn.Conexao;
import br.harlock.dao.EmprestimoDAO;
import br.harlock.dao.TituloDAO;
import java.util.Iterator;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kai
 */
public class TelaRank {
    private int idTi;
    private String nomeT;
    private String cImg;
    private int qnt;

    public int getQnt() {
        return qnt;
    }

    public void setQnt(int qnt) {
        this.qnt = qnt;
    }
    private Connection connection = null;
    public TelaRank() throws Exception {
        connection = Conexao.getConexao();
    }

    public TelaRank(int idTi, String nomeT, String cImg, int qnt) {
        this.idTi = idTi;
        this.nomeT = nomeT;
        this.cImg = cImg;
        this.qnt=qnt;
    }

    public int getIdTi() {
        return idTi;
    }

    public void setIdTi(int idTi) {
        this.idTi = idTi;
    }

    public String getNomeT() {
        return nomeT;
    }

    public void setNomeT(String nomeT) {
        this.nomeT = nomeT;
    }

    public String getcImg() {
        return cImg;
    }

    public void setcImg(String cImg) {
        this.cImg = cImg;
    }
    public enum ModoDeOrde{
        rank,nome
    }
    public void preencher() throws SQLException, Exception{
        Titulo t;
        TituloDAO tDAO;
        Emprestimo e;
        EmprestimoDAO eDAO;
        List lista = new ArrayList();
        
        String sql;
        // SELECT FK_TITULO FROM exemplar where ID_EXE = FK_exemplar_ID_EXE IN (SELECT FK_exemplar_ID_EXE, count(*) as quant from exemplar_contem_emprestimo group by FK_exemplar_ID_EXE);
        sql ="SELECT FK_exemplar_ID_EXE, count(*) as quant from exemplar_contem_emprestimo group by FK_exemplar_ID_EXE";        
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
        TelaRank tR = new TelaRank();
       
        
        
        }
        
    }
    
}
