package models;

public class Transferencia extends Operacao
{
	private String transferenciaDe;
	private String transferenciaPara;
	
	public String getTransferenciaDe() {
		return transferenciaDe;
	}
	public void setTransferenciaDe(String cpf) {
		this.transferenciaDe = cpf;
	}
	
	public String getTransferenciaPara() {
		return transferenciaPara;
	}
	public void setTransferenciaPara(String cpf) {
		this.transferenciaPara = cpf;
	}
	
	@Override
	public String retornarTipo() {
		return "Transferência de: " + getTransferenciaDe() 
				+ "\n\tPara conta: " + getTransferenciaPara();
	}
	
}
