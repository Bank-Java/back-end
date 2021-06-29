package utils;

import java.util.Scanner;

import models.Cliente;
import models.Conta;

public class Console 
{
	private static Scanner sc = new Scanner(System.in);
	
	public static int lerInteiro(String msg) 
	{
		boolean continuarLoop = true;
		int valor = 0;
		
		do 
		{
			try 
			{
				System.out.println(msg);
				valor = Integer.parseInt(sc.next());
				continuarLoop = false;
			} 
			catch (NumberFormatException e) 
			{
				System.out.printf("Exception: %s%n%n", e);
				System.out.println("Por favor, tente novamente!");
			}
		} while (continuarLoop);
		return valor;
	}	
	
	public static void imprimirInfosCliente(Cliente cliente)
	{
		Conta conta = cliente.getConta();
		
		System.out.println(" ------------------ ");
		System.out.println("Nome: " + cliente.getNome());
		System.out.println("CPF: " + cliente.getCpf());
		System.out.println("Email: " + cliente.getEmail());
		System.out.println("Endere�o: " + cliente.getEndereco());
		System.out.println("Telefone: " + cliente.getTelefone());
		System.out.println("Saldo em conta corrente: " + conta.getSaldoCorrente());
		System.out.println("Saldo em conta poupan�a: " + conta.getSaldoPoupanca());
		System.out.println(" ------------------ \n");	
	}
	
	public static void imprimirCabecalho(String cabecalho)
	{
		System.out.println("\n==========================\n");
		System.out.println(cabecalho);
	}
}
