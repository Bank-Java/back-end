package views;
import java.util.Scanner;

import controllers.ClienteController;
import controllers.ContaController;

import models.Conta;

public class TelaLogin {
	
	static Conta conta;
	static Scanner sc = new Scanner(System.in);
	
	public static short mostrarTela() {
		
		String cpf;
		String senha;
		short opcao;
		
		do {
			
			System.out.println("\n -- LOG IN -- \n");
			
			System.out.println("Deseja:");
			System.out.println("(1) Entrar em uma Conta");
			System.out.println("(0) Voltar para Menu Principal");
			
			opcao = sc.nextShort();
			sc.nextLine();
			
			switch (opcao) {
			case 1: {
				
				System.out.println("Digite o número da sua conta (CPF):");
				cpf = sc.nextLine();
				
				System.out.println("Digite sua senha:");
				senha = sc.nextLine();
				
				if (ClienteController.autenticarContaCliente(cpf, senha)) {
//				CHECA SE EXISTE UM CLIENTE COM ESSA CONTA
					
					conta = ContaController.buscarConta(cpf);
					
					TelaCliente.mostrarTela(conta);
					return 1;
				} else {
					
					System.out.println("Essa conta não existe. Por favor, tente novamente!");
				}
				break;
			}
			case 0: {
				
				break;
			}
			
			default:
				System.out.println("Valor inválido: " + opcao);
			}
			
		} while (opcao != 0);
			
		return 0;
	}
	
}
