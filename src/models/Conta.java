package models;

import java.util.ArrayList;

public class Conta {

	private String numeroConta;
	private String senha;
	private Double saldo;
	private ArrayList<Comprovante> extrato = new ArrayList<Comprovante>();
	
	public Conta() {
		
		this.saldo = 0.0;
	}
	
//	GETTERS AND SETTERS

//		SETTERS
		public void setSenha(String senha) {
			this.senha = senha;
		}
		
		public void setNumeroConta(String numeroConta) {
			this.numeroConta = numeroConta;
		}
		
		public void setSaldo(double saldo) {
			this.saldo = saldo;
		}
		
		public void setExtrato(Comprovante comprovante) {
			this.extrato.add(comprovante);
		}
		
//		GETTERS	
		public String getNumeroConta() {
			return numeroConta;
		}
		
		public String getSenha() {
			return senha;
		}
		
		public Double getSaldo() {
			return saldo;
		}
		
		public ArrayList<Comprovante> getExtrato() {
			return extrato;
		}
		
}
