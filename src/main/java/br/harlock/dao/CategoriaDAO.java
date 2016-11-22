/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.harlock.dao;

import java.sql.Connection;
import br.harlock.conn.Conexao;
import br.harlock.model.Categoriaitemacervo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CategoriaDAO {

    private Connection connection = null;

    public CategoriaDAO() {
        connection = Conexao.getConexao();
    }

    public void Inserir(Categoriaitemacervo categoria) throws SQLException {
        String sql;
        sql = "";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.executeUpdate();

    }

    public void Remover(Categoriaitemacervo categoria) throws SQLException {
        String sql;
        sql = "";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.executeUpdate();
    }

    public void Update(Categoriaitemacervo categoria) throws SQLException {
        String sql;
        sql = "";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.executeUpdate();
    }

    public Categoriaitemacervo Pesquisar() throws SQLException {
        Categoriaitemacervo retorno = new Categoriaitemacervo();
        String sql;
        sql = "";
        PreparedStatement ps = connection.prepareStatement(sql);
        return retorno;
    }

    public Iterator<Categoriaitemacervo> ConsultarTodos() throws SQLException {
        List lista = new ArrayList();

        String sql;
        sql = "";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.executeUpdate();

        return lista.iterator();
    }
}
