package views;

import java.util.Scanner;

import controllers.ClienteController;
import models.Cliente;
import utils.Console;

public class TelaCadastraCliente 
{
	private static Scanner sc = new Scanner(System.in);
	private static ClienteController controller = ClienteController.retornarInstacia();
	private static Cliente cliente;
	
	public static void mostrarTela()
	{
		cliente = new Cliente();
		
		Console.imprimirCabecalho("-- CADASTRO - CLIENTE --\n\n" + "Complete as informações abaixo.");
		
		System.out.println("Nome do cliente:");
		cliente.setNome(sc.nextLine());
		
		System.out.println("CPF do cliente:");
		cliente.setCpf(sc.nextLine());
		
		if (controller.autenticarCpf(cliente.getCpf())) 
		{	
			System.out.println("Email do cliente:");
			cliente.setEmail(sc.nextLine());
			
			System.out.println("Endereço do cliente:");
			cliente.setEndereco(sc.nextLine());
			
			System.out.println("Telefone do cliente:");
			cliente.setTelefone(sc.nextLine());
			
			System.out.println("Data de nascimento do cliente:");
			cliente.setDataNasc(sc.nextLine());
			
			if (TelaCadastraConta.mostrarTela(cliente, cliente.getCpf())) {
				
				controller.cadastrarCliente(cliente);
				
				System.out.println("Cliente cadastrado com sucesso!");
			} else {
				
				System.out.println("Não foi possível cadastrar o cliente.");
			}
		} else {
			
			System.out.println("CPF de cliente já cadastrado.");
		}
	}
}
