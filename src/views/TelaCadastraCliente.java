package views;
import java.util.Scanner;
import java.util.Date;

import models.Cliente;
import models.Conta;
import controllers.ClienteController;
import controllers.ContaController;

public class TelaCadastraCliente {
		
	static Scanner sc = new Scanner(System.in);	
	static Cliente cliente;
	static Conta conta;
	
	public static short mostrarTela() {

		cliente = new Cliente();
		conta = new Conta();
		cliente.setData(new Date());
		
		System.out.println("\n-- CADASTRO - CLIENTE --\n");
		
		System.out.println("Digite o nome do cliente:");
		cliente.setNome(sc.nextLine());
		
		System.out.println("Digite o CPF do cliente:");
		cliente.setCpf(sc.nextLine());
		
		System.out.println("Digite o email do cliente:");
		cliente.setEmail(sc.nextLine());
		
		System.out.println("Digite o endereço do cliente:");
		cliente.setEndereco(sc.nextLine());
		
		System.out.println("Digite o telefone do cliente:");
		cliente.setTelefone(sc.nextLine());
		
		System.out.println("Digite a data de nascimento do cliente:");
		cliente.setDataNasc(sc.nextLine());
		
		Conta conta = TelaCadastraConta.renderizar(new Conta());
		
		if(conta != null && ContaController.cadastrar(conta)) {
			cliente.setConta(conta);
			if (ClienteController.cadastrar(cliente)) {
				System.out.println("Cliente cadastrado com sucesso.");
			} else {
				System.out.println("Não foi possível cadastrar esse cliente");
			}
		} else {
			System.out.println("Não foi possível cadastrar esse cliente");
		}
				
		return 1;
	}
	
}
