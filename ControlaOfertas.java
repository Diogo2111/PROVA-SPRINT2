import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ControlaOfertas {
      
    private Connection abrirConexao() throws SQLException{
       	ConnectionFactory factory = new ConnectionFactory ();
    	Connection connection = factory.recuperarConexao();
    	return connection;
    }
    
    public void selectProduto(String pnome) throws SQLException{
       	Connection connection =  abrirConexao();
       	try {
	    	PreparedStatement stm = connection.prepareStatement("SELECT id,nome,descricao, desconto, dataa FROM TB_Produto where nome like ? ");
	       	stm.setString(1, "%" + pnome + "%");
    	   	stm.execute();
    		ResultSet rst = stm.getResultSet();
	  		while (rst.next()) {
				Integer id = rst.getInt("id");
				System.out.println("\nId: " + id);
				String nome = rst.getString("nome");
				System.out.println("Nome: " + nome);
				String descricao = rst.getString("descricao");
				System.out.println("Descrição: " + descricao);
				String desconto = rst.getString("desconto");
				System.out.println("Desconto: " + desconto);
				String data = rst.getString("dataa");
				System.out.println("Data: " + data);
	  		} 
       	} catch (Exception ex) {
       		System.out.println("Erro na consulta :" + ex);
       	} finally {
       		connection.close();
       	}
    }
 
    public void inserirOferta (int id, String nome, String descricao, int desconto, String data)  throws SQLException{
    	Connection connection =  abrirConexao();
    	try {
	    	PreparedStatement stm = connection.prepareStatement("Insert into TB_Produto (id,nome,descricao,desconto,dataa) values (?,?,?,?,?)");
	    	stm.setInt(1,id);
	    	stm.setString(2,nome);
	    	stm.setString(3,descricao);
	    	stm.setInt(4,desconto);
	    	stm.setString(5,data);
	       	stm.execute();
	       	System.out.println("A oferta inserida com sucesso.");
	    } catch (Exception ex) {
	    	System.out.println("Erro na inclusão :" + ex);
	    } finally {
	       	connection.close();
	    } 
    }
    
    public void atualizaOferta (int id, String nome, String descricao, int desconto, String data)  throws SQLException{
    	Connection connection =  abrirConexao();
    	try {
	     	PreparedStatement stm = connection.prepareStatement("UPDATE TB_Produto set nome = ?, descricao = ?, desconto = ?, dataa = ?  where id= ? ");
	    	stm.setString(1,nome);
	    	stm.setString(2,descricao);
	    	stm.setInt(3,desconto);
	    	stm.setString(4,data);
	    	stm.setInt(5,id);
	       	stm.execute();
	    	System.out.println("Oferta atualizada com sucesso.\n");
    	} catch (Exception ex) {
   	    	System.out.println("Erro na atualização :" + ex);
   	    } finally {
   	    	connection.close();   	    	
   	    }
    }  
    
    public void excluiOferta (int id)  throws SQLException{
    	Connection connection =  abrirConexao();
    	try {
	     	PreparedStatement stm = connection.prepareStatement("Delete from TB_Produto where id = ?");
	    	stm.setInt(1,id);
	    	stm.execute();
			System.out.println("A oferta foi excluída com sucesso.");
    	} catch (Exception ex) {
    		System.out.println("Erro na exclusão :" + ex);
    	} finally {
    		connection.close();
    	}
    }  
    
    public boolean validaId(int id) throws SQLException{
    	boolean resposta = false;
       	Connection connection =  abrirConexao();    	
    	try {
	       	PreparedStatement stm = connection.prepareStatement("SELECT id FROM TB_Produto where id = ?");
	       	stm.setInt(1,id);
	       	stm.execute();
			ResultSet rst = stm.getResultSet();
			if (rst.next()) {
				resposta = true;
			}	
    	} catch (Exception ex) {
    		System.out.println("Erro na validação do ID :" + ex);
    	} finally {
    		connection.close();
    	}
    	return resposta;
    }
}
