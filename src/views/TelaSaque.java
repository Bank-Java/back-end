package views;
import java.util.Scanner;

import controllers.ContaController;

import models.Conta;
import models.Comprovante;

public class TelaSaque {
	
	static Conta conta;
	static Comprovante comprovante;
	static Scanner sc = new Scanner(System.in);

	public static short mostrarTela(Conta conta, String saque) {
		
		double valor;
		
		System.out.println("\n -- CLIENTE - SAQUE -- \n");
		
		System.out.println("Qual o valor a ser sacado?");
		valor = sc.nextDouble();
		
		if (ContaController.checarSaldo(conta, valor)) {
			
			System.out.println("Tem certeza que deseja sacar esse valor?");
			System.out.println("(1) Sim, realizar o saque.");
			System.out.println("(0) Não. Voltar para o Menu Cliente.");
			
			sc.nextLine();
			short opcao = sc.nextShort();
			
			switch (opcao) {
			case 1: {
				
				ContaController.sacar(conta, valor);
				
				comprovante = new Comprovante(saque, -valor);
				conta.setExtrato(comprovante);
				
				TelaComprovante.emitirComprovante(comprovante.getTipo(), comprovante.getValor(), comprovante.getData());
				
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
