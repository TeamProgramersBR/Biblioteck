/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.harlock.dao;

import br.harlock.model.ProdutoraConteudo;
import br.harlock.conn.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author kai
 */
public class ProdutoraDAO {

    Connection connection = null;

    public ProdutoraDAO() {
        connection = Conexao.getConexao();
    }

    public void Inserir(ProdutoraConteudo produtora) {
        try {
            String sql;
            sql = "INSERT INTO produtoraconteudo(ID_PDC, Nome_Produtora, Descricao, CNPJ)"
                    + " VALUES (?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setInt(1, produtora.getIdPdc());
            ps.setString(2, produtora.getNomeProdutora());
            ps.setString(3, produtora.getDescricao());
            ps.setString(4, produtora.getCnpj());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void Remover(ProdutoraConteudo produtora) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("DELETE FROM produtoraconteudo WHERE ID_PDC = ?");
            // Parameters start with 1
            preparedStatement.setInt(1, produtora.getIdPdc());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void Update(ProdutoraConteudo produtora) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("UPDATE produtoraconteudo SET ID_PDC=?,Nome_Produtora=?,Descricao=?,CNPJ=? WHERE ID_PDC=?");
            // Parameters start with 1
            preparedStatement.setInt(1, produtora.getIdPdc());
            preparedStatement.setString(2, produtora.getNomeProdutora());
            preparedStatement.setString(3, produtora.getDescricao());
            preparedStatement.setString(4, produtora.getCnpj());
            preparedStatement.setInt(5, produtora.getIdPdc());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public Iterator<ProdutoraConteudo> ConsultarTodos() {
        List<ProdutoraConteudo> produtoras = new ArrayList<ProdutoraConteudo>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM produtoraconteudo");
            while (rs.next()) {
                ProdutoraConteudo produtora = new ProdutoraConteudo();
                produtora.setIdPdc(rs.getInt("ID_PDC"));
                produtora.setNomeProdutora(rs.getString("Nome_Produtora"));
                produtora.setDescricao(rs.getString("Descricao"));
                produtora.setCnpj(rs.getString("CNPJ"));
                produtoras.add(produtora);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return produtoras.iterator();
    }

    public ProdutoraConteudo Pesquisar(ProdutoraConteudo produtora) {
        
        try {
            String sql="SELECT ID_PDC, Nome_Produtora, Descricao, CNPJ FROM produtoraconteudo WHERE ID_PDC = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, produtora.getIdPdc());
            ResultSet rs = ps.executeQuery(sql);
            rs.next();
            produtora.setIdPdc(rs.getInt("ID_PDC"));
            produtora.setNomeProdutora(rs.getString("Nome_Produtora"));
            produtora.setDescricao(rs.getString("Descricao"));
            produtora.setCnpj(rs.getString("CNPJ"));

        } catch (Exception e) {
        }
        return produtora;
    }

}
