package views;
import java.util.Scanner;

import controllers.ContaController;
import models.Conta;
import models.Transferencia;
import controllers.TransferenciaController;

public class TelaTransferencia {

	static Scanner sc = new Scanner(System.in);
	static Transferencia transferencia;
	static Conta conta2;
	
	public static short mostrarTela(Conta conta) {
		
		transferencia = new Transferencia();
		conta2 = new Conta();

		System.out.println("\n -- CLIENTE - TRANSFERÊNCIA -- \n");
		System.out.println("Digite o valor da transferência:");
		transferencia.setValor(sc.nextDouble());
		
		sc.nextLine();
		if (ContaController.checarSaldo(conta, transferencia.getValor())) { 
//		CHECAR SE SALDO É SUFICIENTE
			
			System.out.println("Para qual conta deseja transferir:");
			conta2.setNumeroConta(sc.nextLine());
						
			if (ContaController.buscarConta(conta2.getNumeroConta()) != null) {
//			CHECA SE A CONTA PARA QUAL VAI SER TRANSFERIDA EXISTE

				
				System.out.println("Deseja mesmo realizar a tranferência?");
				System.out.println("(1) Sim, desejo realizar a tranferência.");
				System.out.println("(0) Não. Voltar para o 'Menu Cliente'.");
				
				short opcao = sc.nextShort();
				switch (opcao) {
				case 1: {
					TransferenciaController.transferir(conta, ContaController.buscarConta(conta2.getNumeroConta()), transferencia.getValor());
					
					TelaComprovante.emitirComprovante(
						String.format("Transferência para %s", conta.getNumeroConta()),
						transferencia.getValor()
					);
					
					System.out.println("Transferência realizada com sucesso!");
					break;
				}
				case 0: {
					
					System.out.println("Voltando para 'Menu Cliente'...");
					return 1;
				}
				default:
					System.out.println("Valor inválido: " + opcao);
				}
				
			} else {
				
				System.out.println("A conta digitada não existe.");
			}
			
		} else {
			
			System.out.println("Saldo em conta insuficiente.");
		}
		
		return 0;
	}
}
