
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *@since 04/11/24
 * @author 999829
 * 
 * esta classe cria conexao com o banco de dados Mysql utilizando dados
 * do usuario
 */



public class Conexao {
   private static final String URL = "jdbc:mysql://localhost:3306/agenda"; // 
   private static final String USER = "root"; //  seu usuário
   private static final String PASSWORD = ""; //  sua senha
   public static Connection getConnection() {
       Connection connection = null;
       try {
           connection = DriverManager.getConnection(URL, USER, PASSWORD);
           System.out.println("Conexão estabelecida com sucesso!");
       } catch (SQLException e) {
           System.err.println("Erro ao conectar: " + e.getMessage());
       }
       return connection;
   }
   
}