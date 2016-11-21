/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.harlock.dao;

import br.harlock.bll.Usuario;
import br.harlock.conn.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author kai
 */
public class usuarioDAO {

    Connection connection = null;

    public usuarioDAO() {
        connection = Conexao.getConexao();
    }

    public void Inserir(Usuario usuario) {
        try {
            String sql;
            sql = "INSERT INTO `usuario`(`ID_USU`, `Nivel_De_Acesso`, `Nome`, `CPF`, `email`, `NumeroResidencial`, `NumeroCelular`, `NumeroComercial`, `MatriculaEducacional`, `Senha`, `endereco_Logadouro`, `endereco_CEP`, `endereco_Cidade`, `endereco_Estado`, `endereco_Pais`, `StatusDoUsuario`, `FK_TIPO_USU`)\n"
                    + " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setInt(1, usuario.getIdUsu());
            ps.setString(2, usuario.getNivelDeAcesso());
            ps.setString(3, usuario.getNome());
            ps.setString(4, usuario.getCpf());
            ps.setString(5, usuario.getEmail());
            ps.setString(6, usuario.getNumeroResidencial());
            ps.setString(7, usuario.getNumeroCelular());
            ps.setString(8, usuario.getNumeroComercial());
            ps.setString(9, usuario.getMatriculaEducacional());
            ps.setString(10, usuario.getSenha());
            ps.setString(11, usuario.getEnderecoLogadouro());
            ps.setString(12, usuario.getEnderecoCEP());
            ps.setString(13, usuario.getEnderecoCidade());
            ps.setString(14, usuario.getEnderecoEstado());
            ps.setString(15, usuario.getEnderecoPais());
            ps.setString(16, usuario.getStatusDoUsuario());
            ps.setInt(17, usuario.getFkTipoUsu());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void Remover(Usuario usuario) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("DELETE FROM `usuario` WHERE `ID_USU` = ?");
            // Parameters start with 1
            preparedStatement.setInt(1, usuario.getIdUsu());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void Update(Usuario usuario) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("UPDATE\n"
                            + "  `usuario`\n"
                            + "SET\n"
                            + "  `ID_USU` = ?,\n"
                            + "  `Nivel_De_Acesso` = ?,\n"
                            + "  `Nome` = ?,\n"
                            + "  `CPF` = ?,\n"
                            + "  `email` = ?,\n"
                            + "  `NumeroResidencial` = ?,\n"
                            + "  `NumeroCelular` = ?,\n"
                            + "  `NumeroComercial` = ?,\n"
                            + "  `MatriculaEducacional` = ?,\n"
                            + "  `Senha` = ?,\n"
                            + "  `endereco_Logadouro` = ?,\n"
                            + "  `endereco_CEP` = ?,\n"
                            + "  `endereco_Cidade` = ?,\n"
                            + "  `endereco_Estado` = ?,\n"
                            + "  `endereco_Pais` = ?,\n"
                            + "  `StatusDoUsuario` = ?,\n"
                            + "  `FK_TIPO_USU` = ?\n"
                            + "WHERE\n"
                            + " `ID_USU` = ?");
            // Parameters start with 1
            preparedStatement.setInt(1, usuario.getIdUsu());
            preparedStatement.setString(2, usuario.getNivelDeAcesso());
            preparedStatement.setString(3, usuario.getNome());
            preparedStatement.setString(4, usuario.getCpf());
            preparedStatement.setString(5, usuario.getEmail());
            preparedStatement.setString(6, usuario.getNumeroResidencial());
            preparedStatement.setString(7, usuario.getNumeroCelular());
            preparedStatement.setString(8, usuario.getNumeroComercial());
            preparedStatement.setString(9, usuario.getMatriculaEducacional());
            preparedStatement.setString(10, usuario.getSenha());
            preparedStatement.setString(11, usuario.getEnderecoLogadouro());
            preparedStatement.setString(12, usuario.getEnderecoCEP());
            preparedStatement.setString(13, usuario.getEnderecoCidade());
            preparedStatement.setString(14, usuario.getEnderecoEstado());
            preparedStatement.setString(15, usuario.getEnderecoPais());
            preparedStatement.setString(16, usuario.getStatusDoUsuario());
            preparedStatement.setInt(17, usuario.getFkTipoUsu());
            preparedStatement.setInt(18, usuario.getIdUsu());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public Iterator<Usuario> ConsultarTodos() {
        List<Usuario> usuarios = new ArrayList<Usuario>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM `usuario`");
            while (rs.next()) {
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
                usuario.setFkTipoUsu(rs.getInt("FK_TIPO_USU"));
                usuarios.add(usuario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return usuarios.iterator();
    }

    public Usuario Pesquisar(String ID_USU) {
        Usuario usuario = new Usuario();
        try {
            PreparedStatement ps = (PreparedStatement) connection.createStatement();
            ResultSet rs = ps.executeQuery("SELECT `ID_USU`, `Nivel_De_Acesso`, `Nome`, `CPF`, `email`, `NumeroResidencial`, `NumeroCelular`, `NumeroComercial`, `MatriculaEducacional`, `Senha`, `endereco_Logadouro`, `endereco_CEP`, `endereco_Cidade`, `endereco_Estado`, `endereco_Pais`, `StatusDoUsuario`, `FK_TIPO_USU` FROM `usuario` WHERE `ID_USU` = ?");
            ps.setString(1, ID_USU);
            rs.next();
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
                usuario.setFkTipoUsu(rs.getInt("FK_TIPO_USU"));

        } catch (Exception e) {
        }
        return usuario;
    }

}
