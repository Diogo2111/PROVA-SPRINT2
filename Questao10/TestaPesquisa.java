package Questao10;

import java.util.Scanner;
import java.sql.SQLException;

public class TestaPesquisa {

	public static void main(String[] args)throws SQLException {
		String mensagem;
		
		Scanner ler = new Scanner(System.in);
		System.out.println ("Digite sua mensagem");
		mensagem = ler.nextLine();
		
		Pesquisa pesq = new Pesquisa();
		String resultado = pesq.verificaSentimento(mensagem);
		
		pesq.InserirPesquisa(mensagem, resultado);
		System.out.println(resultado);
		
	}
	
	

}
