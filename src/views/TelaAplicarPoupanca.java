package views;

import java.util.Scanner;

import controllers.ContaController;
import models.Aplicacao;
import models.ComprovanteContaPoupanca;
import models.Conta;
import utils.Console;

public class TelaAplicarPoupanca 
{
	private static Scanner sc = new Scanner(System.in);
	private static ContaController controller = ContaController.retornarInstancia();
	private static Aplicacao aplicacao;
	private static ComprovanteContaPoupanca comprovante;
	
	public static void mostratTela(Conta conta) 
	{
		aplicacao = new Aplicacao();
		int opcao;
		
		do
		{
			Console.imprimirCabecalho("-- CONTA - APLICA??O EM POUPAN?A --\n\n" +
					"Qual o valor a ser aplicado?");
			aplicacao.setValor(sc.nextDouble());
		
			opcao = Console.lerInteiro("Tem certeza que deseja aplicar esse valor na conta poupan?a?\n" +
					"(1) Sim\n" +
					"(0) N?o");
			
			switch (opcao) {
			case 1: {
				
				if(controller.checarSaldo(conta, aplicacao.getValor()))
				{
					comprovante = new ComprovanteContaPoupanca(aplicacao);
					conta.setComprovante(comprovante);
//					
					controller.realizarAplicacao(conta, aplicacao.getValor());
					System.out.println(comprovante);
					opcao = 0;
				}
				else
				{
					System.out.println("Saldo em conta corrente insuficiente.");
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
