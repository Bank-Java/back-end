package models;

import java.util.Date;

public class Extrato {

	public Extrato() {
		setCriadoEm(new Date());
	}
	
	public Extrato(String tipo, double valor, Conta conta) {
		this.tipo = tipo;
		this.valor = valor;
		this.criadoEm = new Date();
		this.conta = conta;
	}
	
	private String tipo;
	private double valor;
	private Date criadoEm;
	private Conta conta;

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Date getCriadoEm() {
		return criadoEm;
	}
	
	public void setCriadoEm(Date criadoEm) {
		this.criadoEm = criadoEm;
	}

	@Override
	public String toString() {
		return "Extrato tipo = " + tipo + ", valor = " + valor + ", criadoEm = " + criadoEm;
	}
	
	
}