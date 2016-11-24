/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.harlock.dao;

import java.sql.Connection;
import br.harlock.conn.Conexao;
import br.harlock.model.Emprestimo;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EmprestimoDAO {

    private Connection connection = null;

    public EmprestimoDAO() throws Exception {
        connection = Conexao.getConexao();
    }

    public void Inserir(Emprestimo emprestimo) throws SQLException {
        String sql;
        sql = "INSERT INTO emprestimo"
                + "("
                + "DataEmprestimo,"
                + "DataPrevDevolucao,"
                + "DataDevolucao,"
                + "ValorMulta,"
                + "Situacao,"
                + "Reserva,"
                + "FK_Funcionario,"
                + "FK_USU)"
                + "VALUES"
                + "("
                + "?,"
                + "?,"
                + "?,"
                + "?,"
                + "?,"
                + "?,"
                + "?,"
                + "?);";
        PreparedStatement ps = connection.prepareStatement(sql);
        int i = 1;
        ps.setDate(i, (Date) emprestimo.getDataEmprestimo());
        ps.setDate(i++, (Date) emprestimo.getDataDevolucao());
        ps.setFloat(i++, emprestimo.getValorMulta());
        ps.setString(i++, emprestimo.getSituacao());
        ps.setBoolean(i++, emprestimo.getReserva());
        ps.setInt(i++, emprestimo.getfKFuncionario());
        ps.setInt(i++, emprestimo.getFkUsu());
        ps.executeUpdate();

    }

    public void Remover(Emprestimo emprestimo) throws SQLException {
        String sql;
        sql = "DELETE FROM emprestimo WHERE ID_EMP = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, emprestimo.getIdEmp());
        ps.executeUpdate();
    }

    public void Update(Emprestimo emprestimo) throws SQLException {
        String sql;
        sql = "UPDATE"
                + "  emprestimo"
                + "SET"
                + "  ID_EMP = ?,"
                + "  DataEmprestimo = ?,"
                + "  DataPrevDevolucao = ?,"
                + "  DataDevolucao = ?,"
                + "  ValorMulta = ?,"
                + "  Situacao = ?,"
                + "  Reserva = ?,"
                + "  FK_Funcionario = ?,"
                + "  FK_USU = ?"
                + "WHERE"
                + "  ID_EMP = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        int i = 1;
        ps.setDate(i, (Date) emprestimo.getDataEmprestimo());
        ps.setDate(i++, (Date) emprestimo.getDataDevolucao());
        ps.setFloat(i++, emprestimo.getValorMulta());
        ps.setString(i++, emprestimo.getSituacao());
        ps.setBoolean(i++, emprestimo.getReserva());
        ps.setInt(i++, emprestimo.getfKFuncionario());
        ps.setInt(i++, emprestimo.getFkUsu());
        ps.setInt(i++, emprestimo.getIdEmp());
        ps.executeUpdate();
    }

    public Emprestimo Pesquisar(Emprestimo emprestimo) throws SQLException {
        Emprestimo retorno = new Emprestimo();
        String sql;
            sql = "SELECT ID_EMP, DataEmprestimo, DataPrevDevolucao, DataDevolucao, ValorMulta, Situacao, Reserva, FK_Funcionario, FK_USU FROM emprestimo WHERE ID_EMP = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            emprestimo.setDataEmprestimo(rs.getDate("DataEmprestimo"));
            emprestimo.setDataPrevDevolucao(rs.getDate("DataPrevDevolucao"));
            emprestimo.setDataDevolucao(rs.getDate("DataDevolucao"));
            emprestimo.setValorMulta(rs.getLong("ValorMulta"));
            emprestimo.setSituacao(rs.getString("Situacao"));
            emprestimo.setReserva(rs.getBoolean("Reserva"));
            emprestimo.setfKFuncionario(rs.getInt("FK_Funcionario"));
            emprestimo.setFkUsu(rs.getInt("FK_USU"));
        }
        return retorno;
    }

    public Iterator<Emprestimo> ConsultarTodos() throws SQLException {
        List lista = new ArrayList();

        String sql;
        sql = "SELECT * FROM emprestimo";
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Emprestimo emprestimo = new Emprestimo();
            emprestimo.setDataEmprestimo(rs.getDate("DataEmprestimo"));
            emprestimo.setDataPrevDevolucao(rs.getDate("DataPrevDevolucao"));
            emprestimo.setDataDevolucao(rs.getDate("DataDevolucao"));
            emprestimo.setValorMulta(rs.getLong("ValorMulta"));
            emprestimo.setSituacao(rs.getString("Situacao"));
            emprestimo.setReserva(rs.getBoolean("Reserva"));
            emprestimo.setfKFuncionario(rs.getInt("FK_Funcionario"));
            emprestimo.setFkUsu(rs.getInt("FK_USU"));
            lista.add(emprestimo);
        }
        return lista.iterator();
    }
}
