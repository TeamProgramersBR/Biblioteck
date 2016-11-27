/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.harlock.dao;

import br.harlock.model.Titulo;
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
public class TituloDAO {

    Connection connection = null;

    public TituloDAO() throws Exception {
        connection = Conexao.getConexao();
    }

    public void Inserir(Titulo titulo) {
        try {
            String sql;
                sql = "INSERT INTO titulo(ISBN, ISSN, obra, Descricao, DataDePublicacao, CidadePublicacao, EstadoPublicacao, Edicao, Idioma, Traducao, Capa, FK_ITEM_PDC,FK_CAT_ARCE)"
                    + " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, titulo.getIsbn());
            ps.setString(2, titulo.getIssn());
            ps.setString(3, titulo.getObra());
            ps.setString(4, titulo.getDescricao());
            ps.setDate(5, (Date) titulo.getDataDePublicacao());
            ps.setString(6, titulo.getCidadePublicacao());
            ps.setString(7, titulo.getEstadoPublicacao());
            ps.setString(8, titulo.getEdicao());
            ps.setString(9, titulo.getIdioma());
            ps.setString(10, titulo.getTraducao());
            ps.setString(11, titulo.getCapa());
            ps.setInt(12, titulo.getFkItemPdc());
            ps.setInt(13, titulo.getFkItemAcervo());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void Remover(Titulo titulo) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("DELETE FROM titulo WHERE ID_TITU = ?");
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
                    .prepareStatement("UPDATE"
                            + "  titulo"
                            + " SET"
                            + "  ID_TITU = ?,"
                            + "  ISBN = ?,"
                            + "  ISSN = ?,"
                            + "  obra = ?,"
                            + "  Descricao = ?,"
                            + "  DataDePublicacao = ?,"
                            + "  CidadePublicacao = ?,"
                            + "  EstadoPublicacao = ?,"
                            + "  Edicao = ?,"
                            + "  Idioma = ?,"
                            + "  Traducao = ?,"
                            + "  Capa = ?,"
                            + "  FK_ITEM_PDC = ?,"
                            + "  FK_CAT_ARCE = ?"
                            + " WHERE"
                            + "   ID_TITU = ?");
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
            preparedStatement.setInt(13, titulo.getFkItemPdc());
            preparedStatement.setInt(14, titulo.getFkItemAcervo());
            preparedStatement.setInt(15, titulo.getIdTitu());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public Iterator<Titulo> ConsultarTodos() {
        List<Titulo> titulos = new ArrayList<Titulo>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM titulo");
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
                titulo.setFkItemPdc(rs.getInt("FK_ITEM_PDC"));
                titulo.getCategoriaitemacervo().setIdCat(rs.getInt("Categoria_item_acervo_ID_CAT"));
                titulos.add(titulo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return titulos.iterator();
    }

    public Titulo Pesquisar(Titulo titulo) {
        try {
            PreparedStatement ps = (PreparedStatement) connection.createStatement();
            String sql = "";
            String where="";
            if (titulo.getIdTitu() != 0) {
                where=titulo.getIdTitu()+"";
                sql = "SELECT ID_TITU, ISBN, ISSN, obra, Descricao, DataDePublicacao, CidadePublicacao, EstadoPublicacao, Edicao, Idioma, Traducao, Capa, FK_ITEM_PDC, FK_CAT_ARCE FROM titulo WHERE ID_TITU = "+where;
            }else if (!titulo.getIdioma().equals(null)) {
                where=titulo.getObra();
                sql = "SELECT ID_TITU, ISBN, ISSN, obra, Descricao, DataDePublicacao, CidadePublicacao, EstadoPublicacao, Edicao, Idioma, Traducao, Capa, FK_ITEM_PDC, FK_CAT_ARCE FROM titulo WHERE obra = "+where;
                
                
            }
            ResultSet rs = ps.executeQuery(sql);
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
                titulo.setFkItemPdc(rs.getInt("FK_ITEM_PDC"));
                titulo.setFkItemAcervo(rs.getInt("FK_CAT_ARCE"));

        } catch (Exception e) {
        }
        return titulo;
    }
}
