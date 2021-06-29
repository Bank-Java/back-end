package models;

public class Deposito extends Operacao
{
	private String metodo;

	public String getMetodo() {
		return metodo;
	}
	public void setMetodo(String metodo) {
		this.metodo = metodo;
	}
	
	@Override
	public String retornarTipo() {
		return "Depósito em " + getMetodo();
	}
	
}
