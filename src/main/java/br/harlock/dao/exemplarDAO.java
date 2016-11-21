/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.harlock.dao;

import br.harlock.bll.Exemplar;
import java.sql.Connection;
import br.harlock.conn.Conexao;
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
public class exemplarDAO {

    private Connection connection = null;

    public exemplarDAO() {
        connection = Conexao.getConexao();
    }

    public void Inserir(Exemplar exemplar) {
        try {
            String sql;
            sql = "INSERT INTO `exemplar`(`ID_EXE`, `ISBN`, `LiberadoParaEmprestimo`, `Duracao`, `QuantidadePaginas`, `FK_TITULO`)\n"
                    + " VALUES (?,?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setInt(1, exemplar.getIdExe());
            ps.setString(2, exemplar.getIsbn());
            ps.setBoolean(3, exemplar.getLiberadoParaEmprestimo());
            ps.setString(4, exemplar.getDuracao());
            ps.setString(5, exemplar.getQuantidadePaginas());
            ps.setInt(6, exemplar.getFkTitulo());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void Remover(Exemplar exemplar) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("DELETE FROM `exemplar` WHERE ID_EXE = ?");
            // Parameters start with 1
            preparedStatement.setInt(1, exemplar.getIdExe());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void Update(Exemplar exemplar) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("UPDATE `exemplar` SET `ID_EXE`=?,`ISBN`=?,`LiberadoParaEmprestimo`=?,`Duracao`=?,`QuantidadePaginas`=?,`FK_TITULO`=? WHERE `ID_EXE`=?");
            // Parameters start with 1
            preparedStatement.setInt(1, exemplar.getIdExe());
            preparedStatement.setString(2, exemplar.getIsbn());
            preparedStatement.setBoolean(3, exemplar.getLiberadoParaEmprestimo());
            preparedStatement.setString(4, exemplar.getDuracao());
            preparedStatement.setString(5, exemplar.getQuantidadePaginas());
            preparedStatement.setInt(6, exemplar.getFkTitulo());
            preparedStatement.setInt(7, exemplar.getIdExe());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    
    public Iterator<Exemplar> ConsultarTodos() {
		List<Exemplar> exemplars = new ArrayList<Exemplar>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from exemplar");
			while (rs.next()) {
				Exemplar exemplar = new Exemplar();
				exemplar.setIdExe(rs.getInt("ID_EXE"));
                                exemplar.setIsbn(rs.getString("ISBN"));
                                exemplar.setLiberadoParaEmprestimo(rs.getBoolean("LiberadoParaEmprestimo"));
                                exemplar.setDuracao(rs.getString("Duracao"));
                                exemplar.setQuantidadePaginas(rs.getString("QuantidadePaginas"));
                                exemplar.setFkTitulo(rs.getInt("FK_TITULO"));
				exemplars.add(exemplar);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return exemplars.iterator();
	}
    
    public Exemplar Pesquisar(String ISBN){
        Exemplar exemplar = new Exemplar();
        try {
            PreparedStatement ps = (PreparedStatement) connection.createStatement();
                    ResultSet rs = ps.executeQuery("SELECT `ID_EXE`, `ISBN`, `LiberadoParaEmprestimo`, `Duracao`, `QuantidadePaginas`, `FK_TITULO` FROM `exemplar` WHERE `ISBN`= ?");
                                ps.setString(1, ISBN);
                                rs.next();
				exemplar.setIdExe(rs.getInt("ID_EXE"));
                                exemplar.setIsbn(rs.getString("ISBN"));
                                exemplar.setLiberadoParaEmprestimo(rs.getBoolean("LiberadoParaEmprestimo"));
                                exemplar.setDuracao(rs.getString("Duracao"));
                                exemplar.setQuantidadePaginas(rs.getString("QuantidadePaginas"));
                                exemplar.setFkTitulo(rs.getInt("FK_TITULO"));
                                
                                
                    
        } catch (Exception e) {
        }
        return exemplar;
    }
}
