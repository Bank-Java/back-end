package views;

import java.util.Objects;
import java.util.Scanner;

import controllers.ExtratoController;
import models.Conta;
import models.Extrato;

public class TelaExtrato {
	static Scanner sc = new Scanner(System.in);
	
	public static void mostrarTela(Conta conta) {
		System.out.println("\n-- Extrato --\n");
		
		for(Extrato ext : ExtratoController.listar()){
			if(Objects.equals(ext.getConta(), conta)) {
				System.out.println(ext.toString());				
			}
		}
	}
}
