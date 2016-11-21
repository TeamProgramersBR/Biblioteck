/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.harlock.dao;

import br.harlock.bll.Titulo;
import br.harlock.conn.Conexao;
import java.sql.Connection;
import java.sql.Date;
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
public class tituloDAO {

    Connection connection = null;

    public tituloDAO() {
        connection = Conexao.getConexao();
    }

    public void Inserir(Titulo titulo) {
        try {
            String sql;
            sql = "INSERT INTO `titulo`(`ID_TITU`, `ISBN`, `ISSN`, `obra`, `Descricao`, `DataDePublicacao`, `CidadePublicacao`, `EstadoPublicacao`, `Edicao`, `Idioma`, `Traducao`, `Capa`, `FK_PRODUTORA_ID`, `FK_ITEM_PDC`, `Categoria_item_acervo_ID_CAT`)\n"
                    + " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setInt(1, titulo.getIdTitu());
            ps.setString(2, titulo.getIsbn());
            ps.setString(3, titulo.getIssn());
            ps.setString(4, titulo.getObra());
            ps.setString(5, titulo.getDescricao());
            ps.setDate(6, (Date) titulo.getDataDePublicacao());
            ps.setString(7, titulo.getCidadePublicacao());
            ps.setString(8, titulo.getEstadoPublicacao());
            ps.setString(9, titulo.getEdicao());
            ps.setString(10, titulo.getIdioma());
            ps.setString(11, titulo.getTraducao());
            ps.setString(12, titulo.getCapa());
            ps.setInt(13, titulo.getFkProdutoraId());
            ps.setInt(14, titulo.getFkItemPdc());
            ps.setInt(15, titulo.getCategoriaitemacervo().getIdCat());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void Remover(Titulo titulo) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("DELETE FROM `titulo` WHERE `ID_TITU` = ?");
            // Parameters start with 1
            preparedStatement.setInt(1, titulo.getIdTitu());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void Update(Titulo titulo) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("UPDATE\n"
                            + "  `titulo`\n"
                            + "SET\n"
                            + "  `ID_TITU` = ?,\n"
                            + "  `ISBN` = ?,\n"
                            + "  `ISSN` = ?,\n"
                            + "  `obra` = ?,\n"
                            + "  `Descricao` = ?,\n"
                            + "  `DataDePublicacao` = ?,\n"
                            + "  `CidadePublicacao` = ?,\n"
                            + "  `EstadoPublicacao` = ?,\n"
                            + "  `Edicao` = ?,\n"
                            + "  `Idioma` = ?,\n"
                            + "  `Traducao` = ?,\n"
                            + "  `Capa` = ?,\n"
                            + "  `FK_PRODUTORA_ID` = ?,\n"
                            + "  `FK_ITEM_PDC` = ?,\n"
                            + "  `Categoria_item_acervo_ID_CAT` = ?\n"
                            + "WHERE\n"
                            + "   `ID_TITU` = ?");
            // Parameters start with 1
            preparedStatement.setInt(1, titulo.getIdTitu());
            preparedStatement.setString(2, titulo.getIsbn());
            preparedStatement.setString(3, titulo.getIssn());
            preparedStatement.setString(4, titulo.getObra());
            preparedStatement.setString(5, titulo.getDescricao());
            preparedStatement.setDate(6, (Date) titulo.getDataDePublicacao());
            preparedStatement.setString(7, titulo.getCidadePublicacao());
            preparedStatement.setString(8, titulo.getEstadoPublicacao());
            preparedStatement.setString(9, titulo.getEdicao());
            preparedStatement.setString(10, titulo.getIdioma());
            preparedStatement.setString(11, titulo.getTraducao());
            preparedStatement.setString(12, titulo.getCapa());
            preparedStatement.setInt(13, titulo.getFkProdutoraId());
            preparedStatement.setInt(14, titulo.getFkItemPdc());
            preparedStatement.setInt(15, titulo.getCategoriaitemacervo().getIdCat());
            preparedStatement.setInt(16, titulo.getIdTitu());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public Iterator<Titulo> ConsultarTodos() {
        List<Titulo> titulos = new ArrayList<Titulo>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM `titulo`");
            while (rs.next()) {
                Titulo titulo = new Titulo();
                titulo.setIdTitu(rs.getInt("ID_TITU"));
                titulo.setIsbn(rs.getString("ISBN"));
                titulo.setIssn(rs.getString("ISSN"));
                titulo.setObra(rs.getString("obra"));
                titulo.setDescricao(rs.getString("Descricao"));
                titulo.setDataDePublicacao(rs.getDate("DataDePublicacao"));
                titulo.setCidadePublicacao(rs.getString("CidadePublicacao"));
                titulo.setEstadoPublicacao(rs.getString("EstadoPublicacao"));
                titulo.setEdicao(rs.getString("Edicao"));
                titulo.setIdioma(rs.getString("Idioma"));
                titulo.setTraducao(rs.getString("Traducao"));
                titulo.setCapa(rs.getString("Capa"));
                titulo.setFkProdutoraId(rs.getInt("FK_PRODUTORA_ID"));
                titulo.setFkItemPdc(rs.getInt("FK_ITEM_PDC"));
                titulo.getCategoriaitemacervo().setIdCat(rs.getInt("Categoria_item_acervo_ID_CAT"));
                titulos.add(titulo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return titulos.iterator();
    }

    public Titulo Pesquisar(String ID_TITU) {
        Titulo titulo = new Titulo();
        try {
            PreparedStatement ps = (PreparedStatement) connection.createStatement();
            ResultSet rs = ps.executeQuery("SELECT `ID_TITU`, `ISBN`, `ISSN`, `obra`, `Descricao`, `DataDePublicacao`, `CidadePublicacao`, `EstadoPublicacao`, `Edicao`, `Idioma`, `Traducao`, `Capa`, `FK_PRODUTORA_ID`, `FK_ITEM_PDC`, `Categoria_item_acervo_ID_CAT` FROM `titulo` WHERE `ID_TITU` = ? ");
            
            ps.setString(1, ID_TITU);
            rs.next();
            
                titulo.setIdTitu(rs.getInt("ID_TITU"));
                titulo.setIsbn(rs.getString("ISBN"));
                titulo.setIssn(rs.getString("ISSN"));
                titulo.setObra(rs.getString("obra"));
                titulo.setDescricao(rs.getString("Descricao"));
                titulo.setDataDePublicacao(rs.getDate("DataDePublicacao"));
                titulo.setCidadePublicacao(rs.getString("CidadePublicacao"));
                titulo.setEstadoPublicacao(rs.getString("EstadoPublicacao"));
                titulo.setEdicao(rs.getString("Edicao"));
                titulo.setIdioma(rs.getString("Idioma"));
                titulo.setTraducao(rs.getString("Traducao"));
                titulo.setCapa(rs.getString("Capa"));
                titulo.setFkProdutoraId(rs.getInt("FK_PRODUTORA_ID"));
                titulo.setFkItemPdc(rs.getInt("FK_ITEM_PDC"));
                titulo.getCategoriaitemacervo().setIdCat(rs.getInt("Categoria_item_acervo_ID_CAT"));

        } catch (Exception e) {
        }
        return titulo;
    }
}
