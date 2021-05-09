package views;
import java.util.Scanner;

import controllers.ClienteController;

import models.Conta;
import models.Cliente;

public class TelaCliente {
	
	static Cliente cliente;
	static Scanner sc = new Scanner(System.in);
	
	public static short mostrarTela(Conta conta) {
	
		short opcao;
		
		do {
			cliente = ClienteController.buscarConta(conta.getNumeroConta());

			System.out.println("\n -- MENU - CLIENTE -- \n");
			
			System.out.println(" ------------------ ");
			System.out.println("CPF: " + conta.getNumeroConta());
			System.out.println("Email: " + cliente.getEmail());
			System.out.println("Endere�o: " + cliente.getEndereco());
			System.out.println("Telefone: " + cliente.getTelefone());
			System.out.println("Saldo em conta: " + conta.getSaldo());
			System.out.println(" ------------------ ");
			
			System.out.println("Escolha uma op��o:");
			System.out.println("(1) Saque");
			System.out.println("(2) Dep�sito");
			System.out.println("(3) Transfer�ncia");
			System.out.println("(4) Extrato");
			System.out.println("(5) Atualiza��o de dados");
			System.out.println("(0) Sair da Conta");
			opcao = sc.nextShort();
			
			switch (opcao) {
			case 1: {
				
				TelaSaque.mostrarTela(conta, "Saque");
				break;
			}
			case 2: {

				TelaDeposito.mostrarTela(conta, "Dep�sito");				
				break;
			}
			case 3: {
				
				TelaTransferencia.mostrarTela(conta);				
				break;
			}
			case 4: {
				
				TelaExtrato.mostrarTela(conta);				
				break;
			}
			case 5: {
				
				TelaAtualizacao.mostrarTela();				
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
