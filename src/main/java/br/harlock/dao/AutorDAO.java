/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.harlock.dao;

import java.sql.Connection;
import br.harlock.conn.Conexao;
import br.harlock.model.Autor;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AutorDAO {

    private Connection connection = null;

    public AutorDAO() throws Exception {
        connection = Conexao.getConexao();
    }

    public void Inserir(Autor autor) throws SQLException {
        try {
            
        
        String sql;
        sql = "INSERT"
                + " INTO"
                + "  autor("
 //               + "    ID_AUTOR,"
                + "    Nome,"
                + "    NomeFantasia,"
                + "    Nacionalidade"
                + "  )"
                + " VALUES("
 //               + "  ?,"
                + "  ?,"
                + "  ?,"
                + "  ?"
                + ")";
        PreparedStatement ps = connection.prepareStatement(sql);
        int i = 1;
//        ps.setInt(i++, autor.getIdAutor()); // 
        ps.setString(i++, autor.getNome()); // 
        ps.setString(i++, autor.getNomeFantasia());
        ps.setString(i++, autor.getNacionalidade());
        ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void Remover(Autor autor) throws SQLException {
        try {
        String sql;
        sql = "DELETE FROM autor WHERE ID_AUTOR = ? ";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, autor.getIdAutor());
        ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void Update(Autor autor) throws SQLException {
        try{
        String sql;
        sql = "UPDATE"
                + "  autor"
                + " SET"
                + "  ID_AUTOR = ?,"
                + "  Nome = ?,"
                + "  NomeFantasia = ?,"
                + "  Nacionalidade = ?"
                + " WHERE"                                                                                
                + "  ID_AUTOR = ?";
        int i = 1;
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(i++, autor.getIdAutor());
        ps.setString(i++, autor.getNome());
        ps.setString(i++, autor.getNomeFantasia());
        ps.setString(i++, autor.getNacionalidade());
        ps.setInt(i++, autor.getIdAutor());
        ps.execute();
        }catch(Exception e){
            e.printStackTrace();
        }
        }

    public Autor Pesquisar(Autor autor) throws SQLException {
        String sql = "";
        PreparedStatement ps = null;
        if (!autor.getNome().equals("")) {
            sql = "SELECT ID_AUTOR, Nome, NomeFantasia, Nacionalidade FROM autor WHERE Nome = ?";
            ps = connection.prepareStatement(sql);
            ps.setString(1, autor.getNome());
        }else{
            sql = "SELECT ID_AUTOR, Nome, NomeFantasia, Nacionalidade FROM autor WHERE ID_AUTOR = ?";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, autor.getIdAutor());
        }
         
        
        
        ResultSet rs = ps.executeQuery();
        rs.next();
        autor.setIdAutor(rs.getInt("ID_AUTOR"));
        autor.setNome(rs.getString("Nome"));
        autor.setNomeFantasia(rs.getString("NomeFantasia"));
        autor.setNacionalidade(rs.getString("Nacionalidade"));
        return autor;
    }

    public Iterator<Autor> ConsultarTodos() throws SQLException {
        List lista = new ArrayList();
        String sql;
        sql = "SELECT ID_AUTOR, Nome, NomeFantasia, Nacionalidade FROM autor";
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Autor autor = new Autor();
            autor.setIdAutor(rs.getInt("ID_AUTOR"));
            autor.setNome(rs.getString("Nome"));
            autor.setNomeFantasia(rs.getString("NomeFantasia"));
            autor.setNacionalidade(rs.getString("Nacionalidade"));
            lista.add(autor);
        }

        return lista.iterator();
    }
}
