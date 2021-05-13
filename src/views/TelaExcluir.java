package views;

import java.util.Scanner;

import controllers.ClienteController;

public class TelaExcluir {
	
	static Scanner sc = new Scanner(System.in);
	
	public static Boolean mostrarTela() {
		
		short opcao; 
		
		System.out.println("\n-- EXCLUIR CADASTRO --\n");
		
		do {

			System.out.println("Tem certeza que deseja excluir o cadastro?");
			System.out.println("(1) Sim. Excluir!");
			System.out.println("(0) Não. Voltar para o Menu Principal.");
			
			opcao = sc.nextShort();
			sc.nextLine();
		
			switch (opcao) {
			case 1: {

				System.out.println("Digite seu CPF para confirmar a exclusão do cadastro:");
				String cpf = (sc.nextLine());
				System.out.println("Digite sua senha para confirmar a exclusão do cadastro:");
				String senha = (sc.nextLine());
				
				if (ClienteController.autenticarContaCliente(cpf, senha)) {
					if(ClienteController.excluir(cpf)) {						
						System.out.println("Cadastro deletado com sucesso.");
					} else {
						
						System.out.println("Não foi possível deletar este cadastro, o saldo da conta precisa estar zerado.");
					}
				} else {
					
					System.out.println("Autenticação inválida.");
					return false;
				}
				
				return true;
			}
			case 0: {
				
				break;
			}
			default:
				System.out.println("Valor inválido: " + opcao);
			}
			
		} while(opcao != 0);
		
		return false;
	}
}
