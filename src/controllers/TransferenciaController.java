package controllers;

import models.Comprovante;
import models.Conta;

public class TransferenciaController {

	static Comprovante comprovante;
	
	public static void transferir(Conta conta, Conta conta2, double valorTransferencia) {
		
		conta.setSaldo(conta.getSaldo() - valorTransferencia);
		conta2.setSaldo(conta2.getSaldo() + valorTransferencia);
		
		comprovante = new Comprovante(String.format("Transferido de %s", conta.getNumeroConta()), valorTransferencia);
		conta2.setExtrato(comprovante);
	}
	
}
