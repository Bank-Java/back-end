package views;

import java.util.Scanner;

import controllers.ContaController;
import models.ComprovanteContaCorrente;
import models.Conta;
import models.Deposito;
import utils.Console;

public class TelaDeposito 
{
	private static Scanner sc = new Scanner(System.in);
	private static ContaController controller = ContaController.retornarInstancia();
	private static Deposito deposito;
	private static ComprovanteContaCorrente comprovante;
	
	public static void mostrarTela(Conta conta) 
	{
		deposito = new Deposito();
		int opcao;
		int opcao2;
		
		Console.imprimirCabecalho("-- CONTA - DEP?SITO --\n\n" +
				"Qual o valor a ser depositado?");
		deposito.setValor(sc.nextDouble()); 
		
		opcao = Console.lerInteiro("Tem certeza que deseja depositar esse valor?\n" +
				"(1) Sim. Realizar o dep?sito.\n" +
				"(0) N?o. Voltar para o Menu Cliente.");
		
		switch (opcao) 
		{
		case 1: {
			
			do 
			{
				opcao2 = Console.lerInteiro("Gostaria de realizar o dep?sito por:\n" +
						"(1) Esp?cie\n" +
						"(2) Cart?o\n" +
						"(3) Cheque");
				
				if(opcao2 == 1)
					deposito.setMetodo("Esp?cie");
				
				if(opcao2 == 2)
					deposito.setMetodo("Cart?o");
				
				if(opcao2 == 3)
					deposito.setMetodo("Cheque");
			} while(opcao<1 || opcao>3);
			
			comprovante = new ComprovanteContaCorrente(deposito);
			conta.setComprovante(comprovante);
			
			controller.depositar(conta, deposito.getValor());
			
			System.out.println(comprovante);
			break;
		}
		case 0: {
			
			break;
		}
		default:
			System.out.println("Valor inv?lido: " + opcao);
		}
	}
}
