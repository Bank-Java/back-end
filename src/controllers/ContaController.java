package controllers;
import java.util.ArrayList;

import models.Conta;
import models.Extrato;

public class ContaController {

	static Conta conta;
	public static ArrayList<Conta> contas = new ArrayList<Conta>();
	
	public static ArrayList<Conta> listaConta() {
		
		return contas;
	}
	
	public static boolean cadastrar(Conta conta) {
		if(contas.isEmpty()) {
			contas.add(conta);
			return true;
		}
				
		if(ContaController.validar(conta)) {
			contas.add(conta);
			return true;			
		} else {
			return false;
		}
	}
	
	public static boolean validar(Conta conta) {
		for(Conta contaCadastrado : contas){
			if(contaCadastrado.getNumeroConta().equals(conta.getNumeroConta())) {
				return false;
			} 
		}
		
		return true;
	}
	
//	AUTENTICACAO DA CONTA - TELA DE LOGIN
	public static Boolean autenticarConta(Conta contaLogin) {
		
		for (int i = 0; i < contas.size(); i++) {
			if (contas.get(i).getNumeroConta().equals(contaLogin.getNumeroConta()) ) {
				
				return true;
			}
		}
		
		return false;
	}
	
//	RETORNA UM OBJETO CONTA PARA TelaLogin
	public static Conta buscarConta(String numeroConta) {
		for (int i = 0; i < contas.size(); i++) {
			if (contas.get(i).getNumeroConta().equals(numeroConta)) {
				
				return contas.get(i);
			}
		}
		
		return null;
	}
	
//	CHECA SE A CONTA QUE VAI RECEBER A TRANSFERENCIA EXISTE
	public static Boolean checarConta(String numeroConta) {
		
		for(int i = 0; i < contas.size(); i++) {
			if (contas.get(i).getNumeroConta().equals(numeroConta) ) {
				
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
		
//		Extrato extrato = new Extrato("Saque", - valor, conta);		
//		ExtratoController.cadastrar(extrato, conta);
		conta.setSaldo(conta.getSaldo() - valor);
	}

//	REALIZA O DEPOSITO NA CONTA
	public static void depositar(Conta conta, double valorDeposito) {
		
//		Extrato extrato = new Extrato("Depósito", + valorDeposito, conta);
//		ExtratoController.cadastrar(extrato, conta);
		conta.setSaldo(conta.getSaldo() + valorDeposito);
	}
	
}
