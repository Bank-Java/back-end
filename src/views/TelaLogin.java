package views;

import java.util.Scanner;

import controllers.ContaController;
import models.Conta;
import utils.Console;

public class TelaLogin 
{
	private static Scanner sc = new Scanner(System.in);
	private static ContaController controller = ContaController.retornarInstancia();
	private static Conta conta;
	
	public static void mostrarTela() 
	{
		String cpfLogin;
		String senhaLogin;
		
		Console.imprimirCabecalho("-- LOG IN --\n");
		System.out.println("Digite o CPF: ");
		cpfLogin = sc.next();
		
		System.out.println("Digite a senha: ");
		senhaLogin = sc.next();
		
		if(controller.autenticarConta(cpfLogin, senhaLogin)) 
		{
			conta = controller.buscarConta(cpfLogin);
			
			TelaConta.mostrarTela(conta);
		}
		else
		{
			System.out.println("A conta não existe. Por favor, tente novamente!\n");
		}
		
	}

}
