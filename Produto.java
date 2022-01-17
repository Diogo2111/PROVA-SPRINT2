import java.util.Scanner;
import java.sql.SQLException;

public class Produto {
	  

	public static void main(String[] args )  throws SQLException {
		int id;
	    String nome;
		String descricao;
		int desconto;
	   	String data;
	   	
	   	int numero=0;
	   	Scanner ler = new Scanner(System.in);
	   
         
		while (numero!=5) {

			System.out.println ("Digite a opção desejada:\n");
			System.out.println("1 para INSERIR uma nova oferta");
			System.out.println("2 para ATUALIZAR uma oferta");
			System.out.println("3 para DELETAR uma oferta");
			System.out.println("4 para LISTAR os produtos que contém ");
			System.out.println("0 para SAIR");

			numero = ler.nextInt();
			ler.nextLine();
			
			if (numero == 0) {
				System.out.println("Sistema encerrado.");
				break;
			} else if (numero < 0 || numero > 4)  {
				System.out.println("Opção inválida. Digite um número de 0 a 4.");
				continue;
			}
					
			ControlaOfertas oferta = new ControlaOfertas();
			
			switch(numero) {
			
			case 1:
				for (int i = 1; i <4; i++) {
					System.out.println("Inclusão da Oferta : " + i);
					System.out.println("Digite o id:");
					id = ler.nextInt();
					ler.nextLine();
					if (oferta.validaId(id)) {
						System.out.println("O id informado já existe.");	
					} else {

						System.out.println("Digite o nome:");
						nome = ler.nextLine();

						System.out.println("Digite o descrição:");
						descricao = ler.nextLine();

						System.out.println("Digite o desconto:");
						desconto = ler.nextInt();
						ler.nextLine();
		
						System.out.println("Digite a data AAAA-MM-DD :");
						data = ler.nextLine();

						oferta.inserirOferta(id,nome,descricao,desconto,data);
					}	
				}
				break;
			case 2:
				System.out.println("Atualização da Oferta");
				System.out.println("Digite o id:");
				id = ler.nextInt();
				ler.nextLine();
				if (oferta.validaId(id)) {
					System.out.println("Digite o nome:");
					nome = ler.nextLine();
					System.out.println("Digite o descrição:");
					descricao = ler.nextLine();
					System.out.println("Digite o desconto:");
					desconto = ler.nextInt();
					ler.nextLine();
					System.out.println("Digite a data AAAA-MM-DD :");
					data = ler.nextLine();
					oferta.atualizaOferta(id,nome,descricao,desconto,data);
				} else {
					System.out.println("O Id informado não existe. Para inserí-lo selecione a opção 1 do menu.");
				} 	
				break;
			case 3:
				System.out.println("Exclusão de ofertas");
				System.out.println("Digite o id:");
				id = ler.nextInt();
				if (oferta.validaId(id)) {
					oferta.excluiOferta(id);
				} else {
					System.out.println("O id informado não existe.");
				}
				
				break;
			case 4:
				System.out.println("*** Lista de ofertas ***");
				System.out.println("Digite o nome do produto ou % para todos:");
				nome = ler.nextLine();
				oferta.selectProduto(nome);
				break;
			}
			
		}
	}
}


