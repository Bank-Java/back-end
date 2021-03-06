package views;

import java.util.Scanner;

import controllers.ContaController;
import models.ComprovanteContaPoupanca;
import models.Conta;
import models.Resgate;
import utils.Console;

public class TelaResgatePoupanca 
{
	private static Scanner sc = new Scanner(System.in);
	private static ContaController controller = ContaController.retornarInstancia();
	private static Resgate resgate;
	private static ComprovanteContaPoupanca comprovante;
	
	public static void mostrarTela(Conta conta) 
	{
		resgate = new Resgate();
		int opcao;
		
		do
		{
			Console.imprimirCabecalho("-- CONTA - RESGATE POUPAN?A --\n\n" +
					"Qual o valor do resgate?");
			resgate.setValor(sc.nextDouble());
			
			opcao = Console.lerInteiro("Tem certeza que deseja realizar o resgate para conta corrente?\n" +
					"(1) Sim\n" +
					"(0) N?o");
			
			switch (opcao) 
			{
			case 1: {
				
				if(controller.checarSaldoPoupanca(conta, resgate.getValor()))
				{
					comprovante = new ComprovanteContaPoupanca(resgate);
					conta.setComprovante(comprovante);
//					
					controller.realizarResgate(conta, resgate.getValor());
					System.out.println(comprovante);
					opcao = 0;
				}
				else
				{
					System.out.println("Saldo em conta poupan?a insuficiente.");
				}
				break;
			}
			case 0: {
				
				break;
			}
			default:
				System.out.println("Valor inv?lido: " + opcao);
			}
		}while(opcao!=0);
	}
}
