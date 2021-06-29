package views;

import java.util.ArrayList;

import models.Comprovante;
import models.Conta;
import utils.Console;

public class TelaComprovantes 
{
	public static void mostrarTela(Conta conta) 
	{
		ArrayList<Comprovante> comprovantes = conta.getComprovantes();
	
		Console.imprimirCabecalho("-- CONTA - COMPROVANTES --\n");
		
		for (Comprovante comprovante : comprovantes) 
		{
			System.out.println(comprovante + "\n");
		}
	}
}
