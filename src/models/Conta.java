package models;

public class Conta {

	private String numeroConta;
	private String senha;
	private Double saldo;
	
//	GETTERS AND SETTERS
	
	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

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
		
}
