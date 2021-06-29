package views;

import java.util.Scanner;

import controllers.ContaController;
import models.Cliente;
import models.Conta;
import utils.Console;

public class TelaCadastraConta 
{
	private static Scanner sc = new Scanner(System.in);
	private static ContaController controller = ContaController.retornarInstancia();
	private static Conta conta; 
	
	public static boolean mostrarTela(Cliente cliente, String cpf) 
	{
		conta = new Conta(cpf);
		int opcao;
		
		Console.imprimirCabecalho("-- CADASTRAR CONTA --\n");
		
		do {
			
			opcao = Console.lerInteiro("Para continuar o cadastro, uma conta corrente deve ser criada.\n" + 
											"Tem certeza que deseja continuar o cadastro?\n" + 
											"(1) Sim\n" + 
											"(0) Não");
			
			switch (opcao) 
			{
			case 1: {
				
				System.out.println("Digite uma senha para a conta:");
				conta.setSenha(sc.nextLine());
				
				System.out.println("Digite a senha novamente:");
				  
				if (controller.verificarSenha(sc.nextLine(), conta.getSenha())) {
					
					System.out.println("Senha válida!");
					
					cliente.setConta(conta);
					controller.cadastrarConta(cliente.getConta());
					
					return true;
				} else {
					
					System.out.println("As senhas devem ser iguais. Tente novamente.");
				}
				
				break;
			}
			case 0: {
				
				System.out.println("Voltando para o Menu Principal...");
				break;
			}
			default:
				System.out.println("Valor inesperado: " + opcao);
			}
		} while(opcao != 0);
		
		return false;
	}

}
