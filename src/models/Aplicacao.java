package models;

public class Aplicacao extends Movimentacao
{
	@Override
	public String retornarTipo() 
	{
		return "Aplicação na conta poupança";
	}

}