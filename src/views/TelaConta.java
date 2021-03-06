package views;

import controllers.ClienteController;
import models.Cliente;
import models.Conta;
import utils.Console;

public class TelaConta 
{
	private static ClienteController controller = ClienteController.retornarInstacia();
	private static Cliente cliente;
	
	public static void mostrarTela(Conta conta) 
	{
		int opcao;
		
		do 
		{
			cliente = controller.buscarCliente(conta.getNumeroConta());
			Console.imprimirCabecalho("-- MENU - CLIENTE --\n");
			Console.imprimirInfosCliente(cliente);
			
			opcao = Console.lerInteiro("Escolha uma op??o:\n" +
					"(1) Saque\n" +
					"(2) Dep?sito\n" + 
					"(3) Transfer?ncia\n" +
					"(4) Comprovantes\n" +
					"(5) Dep?sito em conta poupan?a\n" +
					"(6) Resgatar saldo da poupan?a\n" +
					"(7) Aplicar em conta poupan?a\n" +
					"(8) Atualiza??o de dados\n" +
					"(0) Sair da Conta");
			
			switch (opcao) 
			{
			case 1: {
				
				TelaSaque.mostrarTela(conta);
				break;
			}
			case 2: {

				TelaDeposito.mostrarTela(conta);				
				break;
			}
			case 3: {
				
				TelaTransferencia.mostrarTela(conta);				
				break;
			}
			case 4: {
				
				TelaComprovantes.mostrarTela(conta);				
				break;
			}
			case 5: {
				
				TelaDepositoPoupanca.mostrarTela(conta);
				break;
			}
			case 6: {
				
				TelaResgatePoupanca.mostrarTela(conta);
				break;
			}
			case 7: {
				
				TelaAplicarPoupanca.mostratTela(conta);
				break;
			}
			case 8: {
				
				TelaAtualizacao.mostrarTela(conta);				
				break;
			}
			case 0: {
				
				System.out.println("Voltando para o Menu Principal...");
				break;
			}
			default:
				System.out.println("Valor inv?lido: " + opcao);
			}
		} while (opcao != 0);
		
	}
	
}
