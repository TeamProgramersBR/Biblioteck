/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.harlock.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author kai
 */
public class Conexao {
    

    private static Connection conexao = null;
    public static Connection getConexao(){
        if (conexao != null){
            return conexao;
        }
        else{
            try{
                
                String driver = "org.mysql.Driver";
                String url = "jdbc:mysql://localhost/bancodb";
                String user = "localhost";
                String password = "";
                Class.forName(driver);
                conexao = DriverManager.getConnection(url, user, password);
            }
            catch(ClassNotFoundException e){
                e.printStackTrace();
            }
            catch(SQLException e){
                e.printStackTrace();
            }
            return conexao;
        }
    }   
}

