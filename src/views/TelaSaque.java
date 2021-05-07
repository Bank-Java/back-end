package views;
import java.util.Scanner;

import controllers.ContaController;

import models.Conta;
import models.Saque;

public class TelaSaque {
	
	static Conta conta;
	static Saque saque;
	static Scanner sc = new Scanner(System.in);

	public static short mostrarTela(Conta conta) {
		
		saque = new Saque();
		
		System.out.println("\n -- CLIENTE - SAQUE -- \n");
		
		System.out.println("Qual o valor a ser sacado?");
		saque.setValor(sc.nextDouble());
		
		if (ContaController.checarSaldo(conta, saque.getValor())) {
			
			System.out.println("Tem certeza que deseja sacar esse valor?");
			System.out.println("(1) Sim");
			System.out.println("(0) Não");
			
			sc.nextLine();
			short opcao = sc.nextShort();
			switch (opcao) {
			case 1: {
				
				ContaController.sacar(conta, saque.getValor());
				TelaComprovante.emitirComprovante("Saque", saque.getValor());
				System.out.println("Saque realizado com sucesso!");
				return 1;
			}
			case 0: {
				
				break;
			}
			default:
				System.out.println("Valor inválido: " + opcao);
			}
		} else {
			
			System.out.println("Saldo em conta insuficiente");
		}
		return 0;
	}
}
