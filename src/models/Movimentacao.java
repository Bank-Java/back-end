package models;

import java.util.Date;

public abstract class Movimentacao 
{
	public Movimentacao()
	{
		setData(new Date());
	}
	
	private double valor;
	private Date data;
	
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	
	public abstract String retornarTipo();
}
