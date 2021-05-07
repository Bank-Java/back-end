package views;
import java.util.Scanner;

import controllers.ContaController;

import models.Conta;
import models.Deposito;

public class TelaDeposito {

	static Deposito deposito;
	static Scanner sc = new Scanner(System.in);
	
	public static short mostrarTela(Conta conta) {
	
		deposito = new Deposito();
		
		System.out.println("\n -- CLIENTE - DEPÓSITO -- \n");
		
		System.out.println("Qual o valor a ser depositado:");
		deposito.setValorDeposito(sc.nextDouble());
		
		System.out.println("Tem certeza que deseja depositar esse valor?");
		System.out.println("(1) Sim");
		System.out.println("(0) Não");
		
		sc.nextLine();
		short opcao = sc.nextShort();
		switch (opcao) {
		case 1: {
			
			ContaController.depositar(conta, deposito.getValorDeposito());
			TelaComprovante.emitirComprovante("Depósito", deposito.getValorDeposito());
			System.out.println("Depósito realizado com sucesso!");
			return 1;
		}
		case 0: {
			
			break;
		}
		default:
			System.out.println("Valor inválido: " + opcao);
		}
		
		
		return 0;
	}
}
