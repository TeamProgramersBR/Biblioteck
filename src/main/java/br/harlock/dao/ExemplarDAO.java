/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.harlock.dao;

import br.harlock.model.Exemplar;
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
public class ExemplarDAO {

    private Connection connection = null;

    public ExemplarDAO() {
        connection = Conexao.getConexao();
    }

    public void Inserir(Exemplar exemplar) {
        try {
            String sql;
            sql = "INSERT INTO exemplar(ID_EXE, LiberadoParaEmprestimo, Duracao, QuantidadePaginas, FK_TITULO)"
                    + " VALUES (?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setInt(1, exemplar.getIdExe());
            ps.setBoolean(2, exemplar.getLiberadoParaEmprestimo());
            ps.setString(3, exemplar.getDuracao());
            ps.setString(4, exemplar.getQuantidadePaginas());
            ps.setInt(5, exemplar.getFkTitulo());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void Remover(Exemplar exemplar) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("DELETE FROM exemplar WHERE ID_EXE = ?");
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
                    .prepareStatement("UPDATE exemplar SET ID_EXE=?,LiberadoParaEmprestimo=?,Duracao=?,QuantidadePaginas=?,FK_TITULO=? WHERE ID_EXE=?");
            // Parameters start with 1
            preparedStatement.setInt(1, exemplar.getIdExe());
            preparedStatement.setBoolean(2, exemplar.getLiberadoParaEmprestimo());
            preparedStatement.setString(3, exemplar.getDuracao());
            preparedStatement.setString(4, exemplar.getQuantidadePaginas());
            preparedStatement.setInt(5, exemplar.getFkTitulo());
            preparedStatement.setInt(6, exemplar.getIdExe());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    
    public Iterator<Exemplar> ConsultarTodos() throws Exception {
		
		try {
                        List<Exemplar> exemplars = new ArrayList<Exemplar>();
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from exemplar");
			while (rs.next()) {
				Exemplar exemplar = new Exemplar();
				exemplar.setIdExe(rs.getInt("ID_EXE"));
                                exemplar.setLiberadoParaEmprestimo(rs.getBoolean("LiberadoParaEmprestimo"));
                                exemplar.setDuracao(rs.getString("Duracao"));
                                exemplar.setQuantidadePaginas(rs.getString("QuantidadePaginas"));
                                exemplar.setFkTitulo(rs.getInt("FK_TITULO"));
				exemplars.add(exemplar);
			}
                        return exemplars.iterator();
		} catch (SQLException e) {
			 throw new Exception("Erro ao consultar todos os exemplares"+e);
		}

		
	}
    
    public Exemplar Pesquisar(Exemplar exemplar) throws Exception{
        
        try {
            String sql ="SELECT ID_EXE, LiberadoParaEmprestimo, Duracao, QuantidadePaginas, FK_TITULO FROM exemplar WHERE ID_EXE = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, exemplar.getIdExe());
	    ResultSet rs = ps.executeQuery(sql);
                                
                                rs.next();
				exemplar.setIdExe(rs.getInt("ID_EXE"));
                                exemplar.setLiberadoParaEmprestimo(rs.getBoolean("LiberadoParaEmprestimo"));
                                exemplar.setDuracao(rs.getString("Duracao"));
                                exemplar.setQuantidadePaginas(rs.getString("QuantidadePaginas"));
                                exemplar.setFkTitulo(rs.getInt("FK_TITULO"));
                                return exemplar;
                                
                    
        } catch (Exception e) {
            throw new Exception("Erro ao pesquisar pelo exemplar");
        }
        
    }
}
