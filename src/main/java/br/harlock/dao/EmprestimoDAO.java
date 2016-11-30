/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.harlock.dao;

import java.sql.Connection;
import br.harlock.conn.Conexao;
import br.harlock.model.Emprestimo;
import br.harlock.model.Exemplar;
import br.harlock.model.Titulo;
import br.harlock.model.Usuario;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.ZoneId;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EmprestimoDAO {

    private Connection connection = null;

    public EmprestimoDAO() throws Exception {
        connection = Conexao.getConexao();
    }

    public void Inserir(Emprestimo emprestimo) throws SQLException {
        try {

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
                    + "?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            int i = 1;
            ps.setDate(i++, (Date) emprestimo.getDataEmprestimo());
            ps.setDate(i++, (Date) emprestimo.getDataPrevDevolucao());
            ps.setDate(i++, (Date) emprestimo.getDataDevolucao());
            ps.setFloat(i++, emprestimo.getValorMulta());
            ps.setString(i++, emprestimo.getSituacao());
            ps.setBoolean(i++, emprestimo.getReserva());
            ps.setInt(i++, emprestimo.getfKFuncionario());
            ps.setInt(i++, emprestimo.getFkUsu());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void Remover(Emprestimo emprestimo) throws SQLException {
        String sql;
        sql = "DELETE FROM emprestimo WHERE ID_EMP = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, emprestimo.getIdEmp());
        ps.executeUpdate();
    }

    public void Update(Emprestimo emprestimo) throws SQLException {
        try {

            String sql;
            sql = "UPDATE"
                    + "  emprestimo"
                    + " SET"
                    + "  ID_EMP = ?,"
                    + "  DataEmprestimo = ?,"
                    + "  DataPrevDevolucao = ?,"
                    + "  DataDevolucao = ?,"
                    + "  ValorMulta = ?,"
                    + "  Situacao = ?,"
                    + "  Reserva = ?,"
                    + "  FK_Funcionario = ?,"
                    + "  FK_USU = ?"
                    + " WHERE"
                    + "  ID_EMP = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            int i = 1;
            ps.setInt(i++, emprestimo.getIdEmp());
            ps.setDate(i++, (Date) emprestimo.getDataEmprestimo());
            ps.setDate(i++, (Date) emprestimo.getDataPrevDevolucao());
            ps.setDate(i++, (Date) emprestimo.getDataDevolucao());
            ps.setFloat(i++, emprestimo.getValorMulta());
            ps.setString(i++, emprestimo.getSituacao());
            ps.setBoolean(i++, emprestimo.getReserva());
            ps.setInt(i++, emprestimo.getfKFuncionario());
            ps.setInt(i++, emprestimo.getFkUsu());
            ps.setInt(i++, emprestimo.getIdEmp());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public Emprestimo Pesquisar(Emprestimo emprestimo) throws SQLException, ParseException {

        String sql;
        sql = "SELECT ID_EMP, DataEmprestimo, DataPrevDevolucao, DataDevolucao, ValorMulta, Situacao, Reserva, FK_Funcionario, FK_USU FROM emprestimo WHERE ID_EMP = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, emprestimo.getIdEmp());
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            emprestimo.setDataEmprestimo(rs.getString("DataEmprestimo"));
            emprestimo.setDataPrevDevolucao(rs.getString("DataPrevDevolucao"));
            emprestimo.setDataDevolucao(rs.getString("DataDevolucao"));
            emprestimo.setValorMulta(rs.getLong("ValorMulta"));
            emprestimo.setSituacao(rs.getString("Situacao"));
            emprestimo.setReserva(rs.getBoolean("Reserva"));
            emprestimo.setFkUsu(rs.getInt("FK_USU"));
            emprestimo.setfKFuncionario(rs.getInt("FK_Funcionario"));
        }
        return emprestimo;
    }

    public Iterator<Emprestimo> ConsultarTodos() throws SQLException, ParseException {
        List lista = new ArrayList();

        String sql;
        sql = "SELECT * FROM emprestimo";
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Emprestimo emprestimo = new Emprestimo();
            emprestimo.setDataEmprestimo(rs.getString("DataEmprestimo"));
            emprestimo.setDataPrevDevolucao(rs.getString("DataPrevDevolucao"));
            emprestimo.setDataDevolucao(rs.getString("DataDevolucao"));
            emprestimo.setValorMulta(rs.getLong("ValorMulta"));
            emprestimo.setSituacao(rs.getString("Situacao"));
            emprestimo.setReserva(rs.getBoolean("Reserva"));
            emprestimo.setfKFuncionario(rs.getInt("FK_Funcionario"));
            emprestimo.setFkUsu(rs.getInt("FK_USU"));
            lista.add(emprestimo);
        }
        return lista.iterator();
    }

    public Exemplar PesquisarExemplarParamprestimo(Exemplar exemplar) throws Exception {

        try {
            String sql = "SELECT  "
                    + "ti.ISBN, ti.ISSN, ti.obra , ti.Edicao, ti.Edicao,  "
                    + "c.NomeCategoria, exe.LiberadoParaEmprestimo  "
                    + "FROM titulo ti "
                    + "INNER JOIN exemplar exe "
                    + "ON ti.ID_TITU = exe.FK_TITULO "
                    + "INNER JOIN categoria_item_acervo c  "
                    + "ON c.ID_CAT = ti.FK_CAT_ARCE "
                    + "WHERE ti.ID_TITU = ? AND exe.ID_EXE = ?";

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, exemplar.getFkTitulo());
            ps.setInt(2, exemplar.getIdExe());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Titulo titulo = new Titulo();
                exemplar.setIdExe(rs.getInt("ID_EXE"));
                exemplar.setLiberadoParaEmprestimo(rs.getBoolean("LiberadoParaEmprestimo"));
                exemplar.setDuracao(rs.getString("Duracao"));
                exemplar.setQuantidadePaginas(rs.getString("QuantidadePaginas"));
                exemplar.setFkTitulo(rs.getInt("FK_TITULO"));
                
                return exemplar;
            } else {
                return null;
            }
        } catch (Exception e) {
            throw new Exception("Erro ao pesquisar pelo exemplar");
        }

    }
    public Emprestimo exemplarLiberado(Exemplar exp) throws Exception{
        try {
            Emprestimo emp = new Emprestimo();
            boolean liberado = false;
            String sql = "SELECT emp.DataEmprestimo, emp.DataDevolucao, emp.DataPrevDevolucao, " +
                        "emp.Situacao, u.Nivel_De_Acesso " +
                        "FROM emprestimo emp INNER JOIN " +
                        "exemplar_contem_emprestimo exp " +
                        "ON exp.FK_emprestimo_ID_EMP = ID_EMP " +
                        "INNER JOIN usuario u  " +
                        "ON u.ID_USU = emp.FK_USU  " +
                        "WHERE exp.FK_exemplar_ID_EXE = ? " +
                        "ORDER  BY emp.DataEmprestimo DESC limit 1";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            ps.setInt(1, exp.getIdExe());
            if (rs.next()) {
                emp.setDataDevolucao(rs.getString("DataDevolucao"));
                emp.setDataPrevDevolucao(rs.getString("DataPrevDevolucao"));
                emp.setDataEmprestimo(rs.getString("DataEmprestimo"));
                emp.setSituacao(rs.getString("Situacao"));
                Usuario u = new Usuario();
                emp.setUsuarioDoSistema(u);
                emp.getUsuarioDoSistema().setNivelDeAcesso(rs.getString("Nivel_De_Acesso"));
                if (emp.getDataDevolucao() != null ) {
                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
                    LocalDate localDate = LocalDate.now();
                    java.util.Date date = java.sql.Date.valueOf(localDate);
                    if (emp.getDataDevolucao().before(date)) {
                        emp.setLocado(true);
                    }else{
                       emp.setLocado(false);
                    }
                }
            }else{
                emp.setLocado(false);   
            }
            return emp;
        } catch (SQLException | ParseException e) {
            throw new Exception("Erro ao pesquisar pelo exemplar"+e);
        }
    }
}
