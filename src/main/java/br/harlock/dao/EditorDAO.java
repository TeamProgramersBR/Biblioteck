/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.harlock.dao;

import java.sql.Connection;
import br.harlock.conn.Conexao;
import br.harlock.model.Editor;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EditorDAO {

    private Connection connection = null;

    public EditorDAO() {
        connection = Conexao.getConexao();
    }

    public void Inserir(Editor editor) throws SQLException {
        String sql;
        sql = "";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.executeUpdate();

    }

    public void Remover(Editor editor) throws SQLException {
        String sql;
        sql = "";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.executeUpdate();
    }

    public void Update(Editor editor) throws SQLException {
        String sql;
        sql = "";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.executeUpdate();
    }

    public Editor Pesquisar() throws SQLException {
        Editor retorno = new Editor();
        String sql;
        sql = "";
        PreparedStatement ps = connection.prepareStatement(sql);
        return retorno;
    }

    public Iterator<Editor> ConsultarTodos() throws SQLException {
        List lista = new ArrayList();

        String sql;
        sql = "";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.executeUpdate();

        return lista.iterator();
    }
}
