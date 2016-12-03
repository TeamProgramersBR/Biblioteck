/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.harlock.dao;

import br.harlock.model.Exemplar;
import java.sql.Connection;
import br.harlock.conn.Conexao;
import br.harlock.model.Emprestimo;
import br.harlock.model.Titulo;
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

    public ExemplarDAO() throws Exception {
        connection = Conexao.getConexao();
    }

    public void Inserir(Exemplar exemplar) {
        try {
            String sql;
            sql = "INSERT INTO exemplar(LiberadoParaEmprestimo, Duracao, QuantidadePaginas, FK_TITULO)"
                    + " VALUES (?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);


            ps.setBoolean(1, exemplar.getLiberadoParaEmprestimo());
            ps.setString(2, exemplar.getDuracao());
            ps.setString(3, exemplar.getQuantidadePaginas());
            ps.setInt(4, exemplar.getFkTitulo());

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
	    ResultSet rs = ps.executeQuery();
                                
                                rs.next();
				exemplar.setIdExe(rs.getInt("ID_EXE"));
                                exemplar.setLiberadoParaEmprestimo(rs.getBoolean("LiberadoParaEmprestimo"));
                                exemplar.setDuracao(rs.getString("Duracao"));
                                exemplar.setQuantidadePaginas(rs.getString("QuantidadePaginas"));
                                exemplar.setFkTitulo(rs.getInt("FK_TITULO"));
                                return exemplar;
                                
                    
        } catch (SQLException e) {
            throw new Exception("Erro ao pesquisar pelo exemplar");
        }
        
    }
    public Iterator listarExemplaresEmprestimo(Emprestimo emprestimo) throws Exception{
        try {
            ArrayList<Exemplar> listar = new ArrayList();
            String sql =    "SELECT * FROM exemplar_contem_emprestimo ece  " +
                            "INNER JOIN emprestimo emp ON emp.ID_EMP = ece.FK_emprestimo_ID_EMP  " +
                            "INNER JOIN exemplar ex ON ex.FK_TITULO = ece.FK_exemplar_ID_EXE " +
                            "INNER JOIN titulo titu ON titu.ID_TITU = ex.FK_TITULO " +
                            "where ece.FK_emprestimo_ID_EMP = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, emprestimo.getIdEmp());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                Exemplar exemplar = new Exemplar();
                exemplar.setIdExe(rs.getInt("ID_EXE"));
                exemplar.setLiberadoParaEmprestimo(rs.getBoolean("LiberadoParaEmprestimo"));
                exemplar.setDuracao(rs.getString("Duracao"));
                exemplar.setQuantidadePaginas(rs.getString("QuantidadePaginas"));
                exemplar.setFkTitulo(rs.getInt("FK_TITULO"));
                exemplar.setStatusDeEmprestimo(rs.getString("status_exemplar"));
                Titulo titulo = new Titulo();
                titulo.setIdTitu(rs.getInt("ID_TITU"));
                titulo.setIsbn(rs.getString("ISBN"));
                titulo.setIssn(rs.getString("ISSN"));
                titulo.setObra(rs.getString("obra"));
                titulo.setDescricao(rs.getString("Descricao"));
                titulo.setDataDePublicacao(rs.getString("DataDePublicacao"));
                titulo.setCidadePublicacao(rs.getString("CidadePublicacao"));
                titulo.setEstadoPublicacao(rs.getString("EstadoPublicacao"));
                titulo.setEdicao(rs.getString("Edicao"));
                titulo.setIdioma(rs.getString("Idioma"));
                titulo.setTraducao(rs.getString("Traducao"));
                titulo.setCapa(rs.getBlob("Capa"));
                titulo.setFkItemPdc(rs.getInt("FK_ITEM_PDC"));
                titulo.setFkItemAcervo(rs.getInt("FK_CAT_ARCE"));
                titulo.setTipoDeObra(rs.getString("tipoDeObra"));
                titulo.setDuracao(rs.getFloat("duracao"));
                titulo.setVolume(rs.getString("volume"));
                titulo.setQuantidadePaginas(rs.getInt("quatidadepaginas"));
                exemplar.setTitulo(titulo);
                listar.add(exemplar);
            }
            return listar.iterator();
        } catch (SQLException e) {
            throw new Exception("Erro ao pesquisar pelo exemplar");
        }
    }
}
