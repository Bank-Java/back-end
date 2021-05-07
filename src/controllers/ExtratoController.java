package controllers;

import java.util.ArrayList;

import models.Conta;
import models.Extrato;

public class ExtratoController {
	private static ArrayList<Extrato> extratos = new ArrayList<Extrato>(); 

	public static ArrayList<Extrato> listar() {
		return extratos;
	}

	public static boolean cadastrar(Extrato extrato, Conta conta) {
		extratos.add(extrato);

		return true;
	}	
}
