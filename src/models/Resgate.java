package models;

public class Resgate extends Movimentacao
{
	@Override
	public String retornarTipo() 
	{
		return "Resgate para conta corrente";
	}
}
