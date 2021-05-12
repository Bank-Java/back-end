package controllers;
import java.util.ArrayList;

import models.Cliente;
import models.Conta;

public class ContaController {
	
	static ArrayList<Cliente> clientes = ClienteController.clientes;
	
//	VERIFICA SE AS SENHAS SAO IGUAIS
	public static Boolean verificarSenha(String senha2, String senha) {
		
		if (senha2.equals(senha)) {
			
			return true;
		}	
		
		return false;
	}

//	RETORNA UM OBJETO CONTA PARA TelaLogin
	public static Conta buscarConta(String cpf) {
		
		for (int i = 0; i < clientes.size(); i++) {
			
			if (clientes.get(i).getConta().getNumeroConta().equals(cpf)) {
				
				return clientes.get(i).getConta();
			}
		}
		
		return null;
	}
	
//	CHECA SE A CONTA QUE VAI RECEBER A TRANSFERENCIA EXISTE
	public static Boolean checarConta(String numeroConta) {
		
		for(int i = 0; i < clientes.size(); i++) {
			
			if (clientes.get(i).getConta().getNumeroConta().equals(numeroConta) ) {
				
				return true;
			}
		}
		
		return false;
	}
	
//	CHECA O SALDO DA CONTA
	public static Boolean checarSaldo(Conta conta, double valor) {
		
		if (conta.getSaldo() >= valor) {
			
			return true;
		}
		
		return false;
	}
	
//	SACA O DINHEIRO DA CONTA
	public static void sacar(Conta conta, double valor) {

		conta.setSaldo(conta.getSaldo() - valor);
	}

//	REALIZA O DEPOSITO NA CONTA
	public static void depositar(Conta conta, double valorDeposito) {

		conta.setSaldo(conta.getSaldo() + valorDeposito);
	}
	
}
