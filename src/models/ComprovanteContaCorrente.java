package models;

public class ComprovanteContaCorrente extends Comprovante
{
	public ComprovanteContaCorrente(Operacao operacao)
	{
		StringBuilder messageComprovante = new StringBuilder();
		setOperacao(operacao);
		
		messageComprovante.append("***********************************************\n");
		messageComprovante.append("        <COMPROVANTE DE OPERAÇÃO>              \n");
		messageComprovante.append("***********************************************\n");
		messageComprovante.append("   Título do comprovante                       \n");
		messageComprovante.append("   " + operacao.retornarTipo() + "             \n");
		messageComprovante.append("   Valor                                       \n");
		messageComprovante.append("   " + operacao.getValor() + "                 \n");
		messageComprovante.append("***********************************************\n");
		messageComprovante.append("        " + operacao.getData() + "             \n");
		messageComprovante.append("***********************************************\n");
		
		setMsg(messageComprovante);
	}
	
	private Operacao operacao;

	public Operacao getOperacao() {
		return operacao;
	}
	public void setOperacao(Operacao operacao) {
		this.operacao = operacao;
	}

	@Override
	public String toString() {
		
		return getMsg();
	}
}
