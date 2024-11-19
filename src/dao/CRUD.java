package dao;

import java.sql.ResultSet;
import static dao.Conexao.getConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Set;
import javax.swing.JOptionPane;
import model.Contatos;
/**
* @since 06/11/2024
* @author 2975
* Classe para encapsular as operações referentes ao banco
* CRUD - Create, Read, Update, Delete
*/
public class CRUD {
   // Método para inserir em Contatos
   public void inserirContatos(Contatos pessoa) {
       String sql = "INSERT INTO tb_contatos (nome, endereco, telefone, sexo, email) VALUES (?,?,?,?,?)";
       try (Connection conex = getConnection();
            PreparedStatement ps = conex.prepareStatement(sql)) {
           ps.setString(1, pessoa.getsNome());
           ps.setString(2, pessoa.getsEndereco());
           ps.setString(3, pessoa.getsTelefone());
           ps.setString(4, String.valueOf(pessoa.getcSexo()));
           ps.setString(5, pessoa.getsEmail());
           ps.executeUpdate();
           JOptionPane.showMessageDialog(null, "Inserido com sucesso !!");
       } catch (SQLException e) {
           JOptionPane.showMessageDialog(null, "Erro ao gravar dados: " + e.getMessage());
           e.printStackTrace();
       }
   }
   // Método para deletar um contato
   public void deletarContato(int id) {
       String sql = "DELETE FROM tb_contatos WHERE id = ?"; //  'id' é a chave primária
       try (Connection conex = getConnection();
            PreparedStatement ps = conex.prepareStatement(sql)) {
           ps.setInt(1, id); // Define o ID do contato a ser deletado
           int rowsAffected = ps.executeUpdate(); // Executa a instrução DELETE
           if (rowsAffected > 0) {
               JOptionPane.showMessageDialog(null, "Contato deletado com sucesso !!");
           } else {
               JOptionPane.showMessageDialog(null, "Nenhum contato encontrado com o ID fornecido.");
           }
       } catch (SQLException e) {
           JOptionPane.showMessageDialog(null, "Erro ao deletar contato: " + e.getMessage());
       }
   }
   
   
   
   // Método para editar um contato
public void editarContato(int id, String novoNome, String novoEndereco, String novoTelefone, String novoEmail) {
   String sql = "UPDATE tb_contatos SET nome = ?, endereco = ?, telefone = ?, email = ? WHERE id = ?"; // 'id' é a chave primária
   try (Connection conex = getConnection();
        PreparedStatement ps = conex.prepareStatement(sql)) {
       ps.setString(1, novoNome); // Define o novo nome do contato
       ps.setString(2, novoEndereco); // Define o novo endereço do contato
       ps.setString(3, novoTelefone); // Define o novo telefone do contato
       ps.setString(4, novoEmail); // Define o novo email do contato
       ps.setInt(5, id); // Define o ID do contato a ser editado
       int rowsAffected = ps.executeUpdate(); // Executa a instrução UPDATE
       if (rowsAffected > 0) {
           JOptionPane.showMessageDialog(null, "Contato editado com sucesso !!");
       } else {
           JOptionPane.showMessageDialog(null, "Nenhum contato encontrado com o ID fornecido.");
       }
   } catch (SQLException e) {
       JOptionPane.showMessageDialog(null, "Erro ao editar contato: " + e.getMessage());
   }
}
   
   

    public ArrayList<Contatos> pesquisarContatos(String pesquisa) throws SQLException {
        
        String sql = "SELECT * FROM tb_contatos WHERE nome like ?";
        
        Connection conex = getConnection();
        PreparedStatement ps = null;
        //classe que recupera e amarzena os dados localizados no banco
        ResultSet rs = null;
        
        
        //instancia de um objeto de tipo ArrayList para armazenzar os contatos pesquisados com ResultSet
        
        ArrayList<Contatos> pessoas  = new ArrayList<>();
        
        try {
            //conex = Conexao.criaConexaoMySQL();
            ps = conex.prepareStatement(sql);
            
            //enviar o críterio de pesquisa para sentença SQL   
            ps.setString(1, pesquisa);
            rs = ps.executeQuery();
            //while existir dados na tabela a pesquisa continua
            while (rs.next()){
                Contatos dados = new Contatos();
                
                //recuperando dados e atributos ao objeto dados
                
                dados.setID(rs.getInt("id"));
                dados.setsNome(rs.getNString("nome"));
                dados.setsEndereco(rs.getNString("endereco"));
                dados.setsTelefone(rs.getNString("telefone"));
                dados.setcSexo(rs.getString("sexo").charAt(0));
                dados.setsEmail(rs.getString("email"));
                
                //adiciomar o contato a lista de contatos
                
                pessoas.add(dados);
                
            }
            
        } catch (SQLException e) {
        } finally{
            //fechar as conexao
            
            if (rs != null){
                rs.close();
            }
            if (ps != null){
                ps.close();
            }
            if(conex != null){
                conex.close();
            }
        }
       
       return pessoas;
       
    }

}