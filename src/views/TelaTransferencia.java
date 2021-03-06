package views;

import java.util.Scanner;

import controllers.ContaController;
import models.ComprovanteContaCorrente;
import models.Conta;
import models.Transferencia;
import utils.Console;

public class TelaTransferencia 
{
	private static Scanner sc = new Scanner(System.in);
	private static ContaController controller = ContaController.retornarInstancia();
	private static Transferencia transferencia;
	private static ComprovanteContaCorrente comprovante;
	
	public static void mostrarTela(Conta conta) 
	{
		transferencia = new Transferencia();
		int opcao;
		
		do
		{
			Console.imprimirCabecalho("-- CONTA - TRANFER?NCIA --\n" +
					"Para realizar a transfer?ncia, preencha as informa??es abaixo.\n" +
					"N?mero da conta: ");
			transferencia.setTransferenciaPara(sc.next());
			transferencia.setTransferenciaDe(conta.getNumeroConta());
			
			System.out.println("Qual o valor da transfer?ncia?");
			transferencia.setValor(sc.nextDouble());
			
			opcao = Console.lerInteiro("Tem certeza que deseja realizar a transfer?ncia?\n" +
					"(1) Sim, realizar transfer?ncia.\n" +
					"(0) N?o, voltar para o Mene Cliente.");
			
			switch (opcao) 
			{
			case 1: {
				if(controller.verificarConta(transferencia.getTransferenciaPara()) && 
						controller.checarSaldo(conta, transferencia.getValor()))
				{
					comprovante = new ComprovanteContaCorrente(transferencia);
					conta.setComprovante(comprovante);
					
					controller.transferir(conta, transferencia.getTransferenciaPara(), transferencia.getValor());
					
					System.out.println(comprovante);
					opcao = 0;
				}
				else
				{
					System.out.println("Problemas com o n?mero da conta ou com o valor da transfer?ncia." +
							"Verifique se existe uma conta com esse n?mero e se o saldo ? suficiente.");
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
