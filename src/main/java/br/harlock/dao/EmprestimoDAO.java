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
import br.harlock.model.dataParseToSQL;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.ZoneId;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EmprestimoDAO {
    private dataParseToSQL datapase;
    private Connection connection = null;

    public EmprestimoDAO() throws Exception {
        connection = Conexao.getConexao();
        datapase = new dataParseToSQL();
    }

    public void Inserir(Emprestimo emprestimo, ArrayList<Exemplar> exemplares) throws SQLException {
        try {
            String insertKey = null;
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
            PreparedStatement ps = connection.prepareStatement(sql ,Statement.RETURN_GENERATED_KEYS);
            int i = 1;
            ps.setDate(i++, datapase.convertJavaDateToSqlDate(emprestimo.getDataEmprestimo()));
            ps.setDate(i++, datapase.convertJavaDateToSqlDate(emprestimo.getDataPrevDevolucao()));
            if(emprestimo.getDataDevolucao() != null){
            ps.setDate(i++, datapase.convertJavaDateToSqlDate(emprestimo.getDataDevolucao()));
            }else{
            ps.setDate(i++, null);    
            }
            ps.setFloat(i++, emprestimo.getValorMulta());
            ps.setString(i++, emprestimo.getSituacao());
            ps.setBoolean(i++, emprestimo.getReserva());
            ps.setInt(i++, emprestimo.getfKFuncionario());
            ps.setInt(i++, emprestimo.getFkUsu());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                insertKey = rs.getString(1);
            }
            sql = "INSERT INTO exemplar_contem_emprestimo" +
            "(FK_exemplar_ID_EXE, FK_emprestimo_ID_EMP, status_exemplar)" +
            "VALUES (?, ?, ?)";
            
            ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            boolean inserir = false;
            for (Exemplar exemplare : exemplares) {
                ps.setInt(1, exemplare.getIdExe());
                ps.setInt(2, Integer.valueOf(insertKey));
                ps.setString(3, exemplare.getStatusDeEmprestimo());
                ps.addBatch();
                inserir = true;
            }
            if (inserir) {
                ps.executeBatch();
            }
        } catch (NumberFormatException | SQLException e) {
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

    public void Update(Emprestimo emprestimo, Iterator exemplares) throws SQLException {
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
            ps.setDate(i++, datapase.convertJavaDateToSqlDate(emprestimo.getDataEmprestimo()));
            ps.setDate(i++, datapase.convertJavaDateToSqlDate(emprestimo.getDataPrevDevolucao()));
            if(emprestimo.getDataDevolucao() != null){
            ps.setDate(i++, datapase.convertJavaDateToSqlDate(emprestimo.getDataDevolucao()));
            }else {
            ps.setDate(i++, null);    
            }
            ps.setFloat(i++, emprestimo.getValorMulta());
            ps.setString(i++, emprestimo.getSituacao());
            ps.setBoolean(i++, emprestimo.getReserva());
            ps.setInt(i++, emprestimo.getfKFuncionario());
            ps.setInt(i++, emprestimo.getFkUsu());
            ps.setInt(i++, emprestimo.getIdEmp());
            ps.executeUpdate();
            
            if (emprestimo.getSituacao().equals("2") || emprestimo.getSituacao().equals("6")) {
                sql = "UPDATE exemplar_contem_emprestimo SET status_exemplar='1' where  FK_emprestimo_ID_EMP = ?";
                ps = connection.prepareStatement(sql); 
                ps.setInt(1, emprestimo.getIdEmp());
                ps.execute();
                ps.close();
            }
            if (exemplares.hasNext()) {
                sql = "UPDATE exemplar_contem_emprestimo  " +
                          "SET status_exemplar= ? " +
                          "where  FK_emprestimo_ID_EMP = ? AND FK_exemplar_ID_EXE = ?";
                ps = connection.prepareStatement(sql); 
                while (exemplares.hasNext()) {
                    Exemplar next = (Exemplar) exemplares.next();
                    ps.setString(1, next.getStatusDeEmprestimo());
                    ps.setInt(2, emprestimo.getIdEmp());
                    ps.setInt(3, next.getIdExe());
                    ps.addBatch();
                }
                ps.executeBatch();
            }
            
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
        sql = "SELECT * FROM emprestimo emp INNER JOIN usuario usu ON emp.FK_USU = usu.ID_USU";
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Emprestimo emprestimo = new Emprestimo();
            emprestimo.setIdEmp(rs.getInt("ID_EMP"));
            emprestimo.setDataEmprestimo(rs.getString("DataEmprestimo"));
            emprestimo.setDataPrevDevolucao(rs.getString("DataPrevDevolucao"));
            emprestimo.setDataDevolucao(rs.getString("DataDevolucao"));
            emprestimo.setValorMulta(rs.getLong("ValorMulta"));
            emprestimo.setSituacao(rs.getString("Situacao"));
            emprestimo.setReserva(rs.getBoolean("Reserva"));
            emprestimo.setfKFuncionario(rs.getInt("FK_Funcionario"));
            emprestimo.setFkUsu(rs.getInt("FK_USU"));
            Usuario usuario = new Usuario();
            usuario.setIdUsu(rs.getInt("ID_USU"));
                usuario.setNivelDeAcesso(rs.getString("Nivel_De_Acesso"));
                usuario.setNome(rs.getString("Nome"));
                usuario.setCpf(rs.getString("CPF"));
                usuario.setEmail(rs.getString("email"));
                usuario.setNumeroResidencial(rs.getString("NumeroResidencial"));
                usuario.setNumeroCelular(rs.getString("NumeroCelular"));
                usuario.setNumeroComercial(rs.getString("NumeroComercial"));
                usuario.setMatriculaEducacional(rs.getString("MatriculaEducacional"));
                usuario.setSenha(rs.getString("Senha"));
                usuario.setEnderecoLogadouro(rs.getString("endereco_Logadouro"));
                usuario.setEnderecoCEP(rs.getString("endereco_CEP"));
                usuario.setEnderecoCidade(rs.getString("endereco_Cidade"));
                usuario.setEnderecoEstado(rs.getString("endereco_Estado"));
                usuario.setEnderecoPais(rs.getString("endereco_Pais"));
                usuario.setStatusDoUsuario(rs.getString("StatusDoUsuario"));
            emprestimo.setUsuarioDoSistema(usuario);
            lista.add(emprestimo);
        }
        
        return lista.iterator();
    }

    public Exemplar PesquisarExemplarParamprestimo(Exemplar exemplar) throws Exception {

        try {
            String sql = "SELECT  "
                    + "ti.ISBN, ti.ISSN, ti.obra ,ti.tipoDeObra, ti.quatidadepaginas, ti.duracao, ti.Edicao,  "
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
                exemplar.setIdExe(exemplar.getIdExe());
                titulo.setObra(rs.getString("obra"));
                titulo.setIsbn(rs.getString("ISBN"));
                titulo.setIssn(rs.getString("ISSN"));
                titulo.setTipoDeObra(rs.getString("ISSN"));
                titulo.setTipoDeObra(rs.getString("tipoDeObra"));
                titulo.setIdTitu(exemplar.getFkTitulo());
                exemplar.setLiberadoParaEmprestimo(rs.getBoolean("LiberadoParaEmprestimo"));
                exemplar.setDuracao(rs.getString("Duracao"));
                exemplar.setQuantidadePaginas(rs.getString("quatidadepaginas"));
                exemplar.setFkTitulo(exemplar.getFkTitulo());
                exemplar.setTitulo(titulo);

                return exemplar;
            } else {
                return null;
            }
        } catch (Exception e) {
            throw new Exception("Erro ao pesquisar pelo exemplar" + e);
        }

    }

    public String[] exemplarLiberado(Exemplar exp, Usuario usu,String tipoDeEmprestimo) throws Exception {
        try {
            String[] liberar = new String[2];
            liberar[0] = "false";
            liberar[1] = null;
            String sql = "SELECT emp.situacao,emp.DataEmprestimo,emp.reserva, emp.DataDevolucao,  "
                    + "ece.status_exemplar, usu.Nivel_De_Acesso,  emp.id_emp  "
                    + "FROM exemplar_contem_emprestimo ece "
                    + "INNER JOIN emprestimo emp "
                    + "ON ece.fk_emprestimo_id_emp = emp.ID_EMP "
                    + "INNER JOIN usuario usu "
                    + "ON usu.id_usu = emp.fk_funcionario where FK_exemplar_ID_EXE = ?  "
                    + "ORDER BY emp.DataEmprestimo Limit 1";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, exp.getIdExe());
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String situacao = rs.getString("situacao");
                Date dataEmprestimo = rs.getDate("DataEmprestimo");
                Date dataDevolucao = rs.getDate("DataDevolucao");
                String statusExemplar = rs.getString("status_exemplar");
                String nivelDeAcesso = rs.getString("Nivel_De_Acesso");
                int idEmprestimo = rs.getInt("id_emp");
                int reserva = rs.getInt("reserva");
                if (statusExemplar.equals("Devolvido")) {
                    liberar[0] = "true";
                } else if (usu.getNivelDeAcesso().equals("Professor") && nivelDeAcesso.equals("Aluno") && situacao.equals("Reserva") && statusExemplar.equals("Em Reserva") && tipoDeEmprestimo.equals("Reserva")) {
                    liberar[0] = "true";
                    liberar[1] = String.valueOf(idEmprestimo);
                }
            } else {
                liberar[0] = "true";
            }
            return liberar;
        } catch (SQLException e) {
            throw new Exception("Erro ao pesquisar pelo exemplar" + e);
        }
    }

    public Iterator<Exemplar> listaExemplaresEmprestimo(Emprestimo p) throws Exception {
        try {
            ArrayList<Exemplar> exemplares = new ArrayList();
            String sql = "SELECT FK_exemplar_ID_EXE as eceIDEXE, FK_emprestimo_ID_EMP as aceIDEMP, status_exemplar, ID_TITU, ISBN, ISSN, obra, Descricao, DataDePublicacao, CidadePublicacao, EstadoPublicacao, Edicao, Idioma, Traducao, Capa, FK_ITEM_PDC, FK_CAT_ARCE, tipoDeObra, duracao, volume, quatidadepaginas "
                    + "FROM exemplar_contem_emprestimo  ece "
                    + "INNER JOIN titulo ti ON "
                    + "ti.ID_TITU = ece.FK_exemplar_ID_EXE "
                    + "where FK_emprestimo_ID_EMP = ? AND FK_exemplar_ID_EXE  = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
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
 //               titulo.setCapa(rs.getString("Capa"));
                titulo.setFkItemPdc(rs.getInt("FK_ITEM_PDC"));
                titulo.setFkItemAcervo(rs.getInt("FK_CAT_ARCE"));
                titulo.setTipoDeObra(rs.getString("tipoDeObra"));
                titulo.setDuracao(rs.getFloat("duracao"));
                titulo.setVolume(rs.getString("volume"));
                titulo.setQuantidadePaginas(rs.getInt("quatidadepaginas"));
                Exemplar exemplar = new Exemplar();
                exemplar.setFkEmprestimo(rs.getInt(sql));
                exemplar.setIdExe(rs.getInt(sql));
                exemplar.setStatusDeEmprestimo(rs.getString("status_exemplar"));
                exemplar.setTitulo(titulo);
                exemplares.add(exemplar);
            }
            return exemplares.iterator();
        } catch (SQLException e) {
            throw new Exception("Erro ao fazer update no statys de exemplar" + e);
        }
    }

    public void updateStatusExemplares(ArrayList<Emprestimo> exemplar) throws Exception {
        try {
            String sql = "UPDATE exemplar_contem_emprestimo  "
                    + "SET status_exemplar= ?  "
                    + "WHERE FK_exemplar_ID_EXE = ? and FK_emprestimo_ID_EMP = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            for (Emprestimo emp : exemplar) {
                ps.setString(1, emp.getExemplar().getStatusDeEmprestimo());
                ps.setInt(2, emp.getExemplar().getIdExe());
                ps.setInt(3, emp.getExemplar().getFkEmprestimo());
                ps.addBatch();
            }
            ps.executeBatch();

        } catch (SQLException e) {
            throw new Exception("Erro ao fazer update no statys de exemplar" + e);
        }
    }
}
