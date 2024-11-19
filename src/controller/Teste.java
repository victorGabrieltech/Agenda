
package controller;
import dao.Conexao;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.SQLException;

/**
 *04/11/24
 * @author 999829
 */

   


public class Teste {
 
    public static void main(String[] args) throws SQLException {
        // recupera uma conexão com o mysql
        Connection conex = Conexao.getConnection();
        // verifica se a conexão é válida ou nula
        if (conex != null) {
            String teste = "Conexão obtida com Sucesso!\n\n";
            JOptionPane.showMessageDialog(null, teste + conex);
            // fecha a conexão após teste
            JOptionPane.showMessageDialog(null, "Conexão Finalizada");
            conex.close();
        }
        else {
            String errus = "Não foi possível realizar a conexão";
            JOptionPane.showMessageDialog(null, errus, 
                                                                     "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
}