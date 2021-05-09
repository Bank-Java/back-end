package views;
import java.util.Scanner;

import controllers.ContaController;
import controllers.TransferenciaController;

import models.Conta;
import models.Comprovante;

public class TelaTransferencia {

	static Scanner sc = new Scanner(System.in);
	static Comprovante comprovante;
	
	public static short mostrarTela(Conta conta) {
		
		double valor;
		String cpf;

		System.out.println("\n -- CLIENTE - TRANSFERÊNCIA -- \n");
		
		System.out.println("Digite o valor da transferência:");
		valor = sc.nextDouble();
		sc.nextLine();
		
		if (ContaController.checarSaldo(conta, valor)) { 
//		CHECAR SE SALDO É SUFICIENTE
			
			System.out.println("Para qual conta deseja transferir (CPF):");
			cpf = sc.nextLine();
						
			if (ContaController.buscarConta(cpf) != null) {
//			CHECA SE A CONTA PARA QUAL VAI SER TRANSFERIDA EXISTE

				System.out.println("Deseja mesmo realizar a tranferência?");
				System.out.println("(1) Sim, desejo realizar a tranferência.");
				System.out.println("(0) Não. Voltar para o Menu Cliente.");
				
				short opcao = sc.nextShort();
				
				switch (opcao) {
				case 1: {
					
					TransferenciaController.transferir(conta, ContaController.buscarConta(cpf), valor);
					
					comprovante = new Comprovante(String.format("Transferência para %s", cpf), -valor);
					conta.setExtrato(comprovante);
					
					TelaComprovante.emitirComprovante(
							String.format("Transferência para %s", cpf), -valor
					);
					
					System.out.println("Transferência realizada com sucesso!");
					return 1;
				}
				case 0: {
					
					break;
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
