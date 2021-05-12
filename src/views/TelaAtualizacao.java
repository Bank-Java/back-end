package views;

import java.util.Scanner;

import controllers.ClienteController;

import models.Conta;

public class TelaAtualizacao {
	
	static Scanner sc = new Scanner(System.in);
	
	public static Boolean mostrarTela(Conta conta) {
		
		short opcao; 
		
		System.out.println("\n-- ATUALIZAR CLIENTE --\n");
		
		do {

			System.out.println("Tem certeza que deseja atualizar os dados cadastrados?");
			System.out.println("(1) Sim. Atualizar!");
			System.out.println("(0) N�o. Voltar para o Menu Cliente.");
			
			opcao = sc.nextShort();
			sc.nextLine();
		
			switch (opcao) {
			case 1: {
				
				System.out.println("Digite o seu CPF para realizar a verifica��o:");
				String cpf = (sc.nextLine());
				
				if (conta.getNumeroConta().equals(cpf)) {
					
					System.out.println("Digite o nome para atualizar:");
					String nome = sc.nextLine();
					
					System.out.println("Digite o email para atualizar:");
					String email = sc.nextLine();
					
					System.out.println("Digite o endere�o para atualizar:");
					String endereco = sc.nextLine();
					
					System.out.println("Digite o telefone para atualizar:");
					String telefone = sc.nextLine();
					
					System.out.println("Digite a data de nascimento para atualizar:");
					String dataNascimento = sc.nextLine();
					
					if(ClienteController.atualizar(nome, cpf, email, endereco, telefone, dataNascimento)) {
						
						System.out.println("Cliente atualizado com sucesso.");
					} else {
						
						System.out.println("N�o foi poss�vel atualizar esse cliente.");
					}
				} else {
					
					System.out.println("CPF inv�lido.");
					return false;
				}
				
				return true;
			}
			case 0: {
				
				break;
			}
			default:
				System.out.println("Valor inv�lido: " + opcao);
			}
			
		} while(opcao != 0);
		
		return false;
	}
}
