package models;

import java.util.Date;

public class Comprovante {

	private String tipo;
	private double valor;
	private Date data;
	
	public Comprovante(String tipo, double valor) {
		this.tipo = tipo;
		this.valor = valor;
		this.data = new Date();
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public double getValor() {
		return valor;
	}
	
	public Date getData() {
		return data;
	}
	
}
