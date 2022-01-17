package Questao10;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Pesquisa {
	
	
	public String verificaSentimento(String msg) {
		int feliz;
		int triste;
		String result;
		
		feliz  = contaSentimento(msg, ":-)");
		triste = contaSentimento(msg, ":-(");
		
		if (feliz == triste) {
			result = "Neutro";
		} else if (feliz > triste) {
			result = "Divertido";
		} else {
			result = "Chateado";
		}
		
		return result;
	}
	
	public int contaSentimento(String msg, String sentimento) {	
		int c = 0;
		int pos = 0;
		while ( true ) {
			pos =  msg.indexOf(sentimento, c + pos );
			if (pos >= 0) {
				c++;
			} else {
				break;
			} 
		}
		return c;
	}	
	
    private Connection abrirConexao() throws SQLException{
       	ConnectionFactory factory = new ConnectionFactory ();
    	Connection connection = factory.recuperarConexao();
    	return connection;
    }
	
    public void InserirPesquisa ( String mensagem, String resultado)  throws SQLException{
    	Connection connection =  abrirConexao();
    	try {
	    	PreparedStatement stm = connection.prepareStatement("Insert into TB_pesquisa (mensagem,resultado) values (?,?)");
	    	stm.setString(1,mensagem);
	    	stm.setString(2,resultado);
	    	stm.execute();
			System.out.println("Cadastrado com sucesso");
    	} catch (Exception ex) {
    		System.out.println("Erro na inclusão :" + ex);
    	} finally {
    		connection.close();
    	}
    }
}
