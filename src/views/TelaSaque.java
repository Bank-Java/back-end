package views;

import java.util.Scanner;

import controllers.ContaController;
import models.ComprovanteContaCorrente;
import models.Conta;
import models.Saque;
import utils.Console;

public class TelaSaque 
{
	private static Scanner sc = new Scanner(System.in);
	private static ContaController controller = ContaController.retornarInstancia();
	private static Saque saque;
	private static ComprovanteContaCorrente comprovante;
	
	public static void mostrarTela(Conta conta) 
	{
		saque = new Saque();
		int opcao;
		
		Console.imprimirCabecalho("-- CONTA - SAQUE --\n\n" +
				"Qual o valor a ser sacado?");
		saque.setValor(sc.nextDouble()); 
			
		opcao = Console.lerInteiro("Tem certeza que deseja sacar esse valor?\n" +
				"(1) Sim. Realizar o saque.\n" +
				"(0) Não. Voltar para o Menu Cliente.");
		
		switch (opcao) {
		case 1: {
			
			if (controller.checarSaldo(conta, saque.getValor())) 
			{
				comprovante = new ComprovanteContaCorrente(saque);
				conta.setComprovante(comprovante);
				
				controller.sacar(conta, saque.getValor());
				System.out.println(comprovante);
			} 
			else 
			{
				System.out.println("Saldo em conta insuficiente");
			}
			
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
