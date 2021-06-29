package models;

public class ComprovanteContaPoupanca extends Comprovante 
{
	public ComprovanteContaPoupanca(Movimentacao movimentacao)
	{
		StringBuilder messageComprovante = new StringBuilder();
		setMovimentacao(movimentacao);
		
		messageComprovante.append("***********************************************\n");
		messageComprovante.append("        <COMPROVANTE DE MOVIMENTAÇÃO>          \n");
		messageComprovante.append("***********************************************\n");
		messageComprovante.append("   Título do comprovante                       \n");
		messageComprovante.append("   " + movimentacao.retornarTipo() + "         \n");
		messageComprovante.append("   Valor                                       \n");
		messageComprovante.append("   " + movimentacao.getValor() + "             \n");
		messageComprovante.append("***********************************************\n");
		messageComprovante.append("        " + movimentacao.getData() + "         \n");
		messageComprovante.append("***********************************************\n");
		
		setMsg(messageComprovante);
	}
	
	private Movimentacao movimentacao;

	public Movimentacao getMovimentacao() {
		return movimentacao;
	}
	public void setMovimentacao(Movimentacao movimentacao) {
		this.movimentacao = movimentacao;
	}

	@Override
	public String toString() {
		
		return getMsg();
	}
}
