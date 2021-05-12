package views;

import java.util.Scanner;

import controllers.ContaController;

import models.Conta;
import models.Cliente;

public class TelaCadastraConta {
	
	static Scanner sc = new Scanner(System.in);
	static Conta conta;
	
	public static Boolean mostrarTela(Cliente cliente, String cpf) {
		
		conta = new Conta();
		conta.setNumeroConta(cpf);
		short opcao;
		
		System.out.println("\n-- CADASTRAR CONTA --\n");
		
		do {
			
			System.out.println("Continuar o cadastro da conta do cliente?");
			System.out.println("(1) Sim");
			System.out.println("(0) Não");
			System.out.println("Digite a opção que deseja:");
			
			opcao = sc.nextShort();
			sc.nextLine();
			
			switch (opcao) {
			case 1: {
				
				System.out.println("Digite uma senha para a conta:");
				conta.setSenha(sc.nextLine());
				
				System.out.println("Digite a senha novamente:");
				  
				if (ContaController.verificarSenha(sc.nextLine(), conta.getSenha())) {
					
					cliente.setConta(conta);
					
					System.out.println("Senha válida!");
					return true;
				} else {
					
					System.out.println("As senhas devem ser iguais. Tente novamente.");
				}
				
				break;
			}
			case 0: {
				
				break;
			}
			default:
				System.out.println("Valor inesperado: " + opcao);
			}
		} while(opcao != 0);
		
		return false;
	}
}