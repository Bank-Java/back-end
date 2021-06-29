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
			
			opcao = Console.lerInteiro("Escolha uma opção:\n" +
					"(1) Saque\n" +
					"(2) Depósito\n" + 
					"(3) Transferência\n" +
					"(4) Comprovantes\n" +
					"(5) Depósito em conta poupança\n" +
					"(6) Resgatar saldo da poupança\n" +
					"(7) Aplicar em conta poupança\n" +
					"(8) Atualização de dados\n" +
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
				System.out.println("Valor inválido: " + opcao);
			}
		} while (opcao != 0);
		
	}
	
}
