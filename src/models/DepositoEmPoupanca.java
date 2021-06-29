package models;

public class DepositoEmPoupanca extends Movimentacao 
{
	private String metodo;
	
	public String getMetodo() {
		return metodo;
	}
	public void setMetodo(String metodo) {
		this.metodo = metodo;
	}
	
	@Override
	public String retornarTipo() 
	{
		return "Depósito conta poupança em " + getMetodo();
	}
}
