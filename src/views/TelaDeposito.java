package views;
import java.util.Scanner;

import controllers.ContaController;

import models.Conta;
//import models.Deposito;
import models.Comprovante;

public class TelaDeposito {

	static Comprovante comprovante;
	static Scanner sc = new Scanner(System.in);
	
	public static short mostrarTela(Conta conta, String deposito) {
	
		
		short opcao; 
		double valor; 
		
		System.out.println("\n -- CLIENTE - DEP�SITO -- \n");

		do {

			System.out.println("Qual o valor a ser depositado:");
			valor = sc.nextDouble();
			
			System.out.println("Tem certeza que deseja realizar o dep�sito nesse valor?");
			System.out.println("(1) Sim, desejo realizar o dep�sito.");
			System.out.println("(2) N�o, desejo depositar outro valor.");
			System.out.println("(0) N�o. Voltar para Menu Cliente.");
			
			sc.nextLine();
			opcao = sc.nextShort();
			
			switch (opcao) {
			case 1: {
				
				ContaController.depositar(conta, valor);
				
				comprovante = new Comprovante(deposito, valor);
				conta.setExtrato(comprovante);
				
				TelaComprovante.emitirComprovante(comprovante.getTipo(), comprovante.getValor());
				return 1;
			}
			case 2: {
				
				break;
			}
			case 0: {
				
				break;
			}
			default:
				System.out.println("Valor inv�lido: " + opcao);
			}
		} while (opcao != 0);
		
		return 0;
	}
}
