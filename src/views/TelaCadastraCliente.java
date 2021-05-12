package views;
import java.util.Scanner;
import java.util.Date;

import models.Cliente;
import controllers.ClienteController;

public class TelaCadastraCliente {
		
	static Scanner sc = new Scanner(System.in);	
	static Cliente cliente;
	
	public static short mostrarTela() {

		cliente = new Cliente();
		cliente.setData(new Date());
		
		System.out.println("\n-- CADASTRO - CLIENTE --\n");
		
		System.out.println("Digite o nome do cliente:");
		cliente.setNome(sc.nextLine());
		
		System.out.println("Digite o CPF do cliente:");
		cliente.setCpf(sc.nextLine());
		
		if (ClienteController.autenticarCpf(cliente.getCpf())) {
			
			System.out.println("Digite o email do cliente:");
			cliente.setEmail(sc.nextLine());
			
			System.out.println("Digite o endereço do cliente:");
			cliente.setEndereco(sc.nextLine());
			
			System.out.println("Digite o telefone do cliente:");
			cliente.setTelefone(sc.nextLine());
			
			System.out.println("Digite a data de nascimento do cliente:");
			cliente.setDataNasc(sc.nextLine());
			
			if (TelaCadastraConta.mostrarTela(cliente, cliente.getCpf())) {
				
				ClienteController.cadastrar(cliente);
				
				System.out.println("Cliente cadastrado com sucesso!");
			} else {
				
				System.out.println("Não foi possível cadastrar o cliente");
			}
		} else {
			
			System.out.println("CPF de cliente já cadastrado.");
		}
				
		return 1;
	}
}
