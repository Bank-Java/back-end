package views;

import java.util.Scanner;

import utils.Console;

public class Principal 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int opcao;
		
		do 
		{
			Console.imprimirCabecalho(" --------------------\n"
									+ " - SISTEMA BANCÁRIO -\n"
									+ " --------------------");
			opcao = Console.lerInteiro("\n -- MENU - PRINCIPAL -- \n" +
									"(1) Cadastrar Cliente\r\n" +
									"(2) Entrar na Conta\r\n" + 
									"(0) Sair\r\n" +
									"Digite a opção desejada: ");
			
			switch (opcao) 
			{
			case 1:
				
				TelaCadastraCliente.mostrarTela();
				break;
			case 2:
				
				TelaLogin.mostrarTela();
				break;
			case 0:
				
				System.out.println("\nEncerrando sistema.");
				break;
			default:
				System.err.printf("Você deve digitar um valor entre 0-2.%n");
			}	
		} while (opcao != 0);
		sc.close();
	}
}
