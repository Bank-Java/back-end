package views;

import java.util.Scanner;

import controllers.ClienteController;
import models.Conta;
import utils.Console;

public class TelaAtualizacao 
{
	private static Scanner sc = new Scanner(System.in);
	private static ClienteController controller = ClienteController.retornarInstacia();
	
	public static void mostrarTela(Conta conta) 
	{
		int opcao; 
		
		do 
		{
			Console.imprimirCabecalho("-- ATUALIZAR CLIENTE --\n");
			
			opcao = Console.lerInteiro("Tem certeza que deseja atualizar os dados cadastrados?\n" +
					"(1) Sim.\n" +
					"(0) N?o. Voltar para o Menu Cliente.");
		
			switch (opcao) 
			{
			case 1: {
				
				System.out.println("Digite o seu CPF para realizar a verifica??o:");
				String cpf = sc.nextLine();
				
				if (conta.getNumeroConta().equals(cpf)) 
				{
					System.out.println("\nDigite o nome para atualizar:");
					String nome = sc.nextLine();
					
					System.out.println("\nDigite o email para atualizar:");
					String email = sc.nextLine();
					
					System.out.println("\nDigite o endere?o para atualizar:");
					String endereco = sc.nextLine();
					
					System.out.println("\nDigite o telefone para atualizar:");
					String telefone = sc.nextLine();
					
					System.out.println("\nDigite a data de nascimento para atualizar:");
					String dataNascimento = sc.nextLine();
					
					if(controller.atualizar(nome, cpf, email, endereco, telefone, dataNascimento)) 
					{
						System.out.println("Cliente atualizado com sucesso!");
						opcao = 0;
					} 
					else 
					{
						System.out.println("N?o foi poss?vel atualizar esse cliente.");
					}
				} 
				else 
				{
					System.out.println("CPF inv?lido.");
				}
				
				break;
			}
			case 0: {
				
				break;
			}
			default:
				System.out.println("Valor inv?lido: " + opcao);
			}
			
		} while(opcao != 0);
	}
}