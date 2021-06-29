package views;

import java.util.Scanner;

import controllers.ContaController;
import models.ComprovanteContaPoupanca;
import models.Conta;
import models.DepositoEmPoupanca;
import utils.Console;

public class TelaDepositoPoupanca 
{
	private static Scanner sc = new Scanner(System.in);
	private static ContaController controller = ContaController.retornarInstancia();
	private static ComprovanteContaPoupanca comprovante;
	private static DepositoEmPoupanca deposito;
	
	public static void mostrarTela(Conta conta) 
	{
		deposito = new DepositoEmPoupanca();
		int opcao;
		int opcao2;
		
		Console.imprimirCabecalho("-- CONTA - DEPÓSITO POUPANÇA --\n\n" +
				"Qual o valor a ser depositado?");
		deposito.setValor(sc.nextDouble()); 
		
		opcao = Console.lerInteiro("Tem certeza que deseja depositar esse valor?\n" +
				"(1) Sim. Realizar o depósito.\n" +
				"(0) Não. Voltar para o Menu Cliente.");
		
		switch (opcao) 
		{
		case 1: {
			
			do 
			{
				opcao2 = Console.lerInteiro("Gostaria de realizar o depósito por:\n" +
						"(1) Espécie\n" +
						"(2) Cartão\n" +
						"(3) Cheque");
				
				if(opcao2 == 1)
					deposito.setMetodo("Espécie");
				
				if(opcao2 == 2)
					deposito.setMetodo("Cartão");
				
				if(opcao2 == 3)
					deposito.setMetodo("Cheque");
			} while(opcao<1 || opcao>3);
			
			comprovante = new ComprovanteContaPoupanca(deposito);
			conta.setComprovante(comprovante);
			
			controller.depositarEmPoupanca(conta, deposito.getValor());
			
			System.out.println(comprovante);
			break;
		}
		case 0: {
			
			break;
		}
		default:
			System.out.println("Valor inválido: " + opcao);
		}
	}

}
