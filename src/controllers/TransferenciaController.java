package controllers;
import java.util.List;

import models.Comprovante;
import models.Conta;
import models.Extrato;

public class TransferenciaController {

	static List<Conta> contas = ContaController.listaConta();
	static Comprovante comprovante;
	
	public static void transferir(Conta conta, Conta conta2, double valorTransferencia) {
		
		conta.setSaldo(conta.getSaldo() - valorTransferencia);
		conta2.setSaldo(conta2.getSaldo() + valorTransferencia);
		
		comprovante = new Comprovante(String.format("Transferido de %s", conta.getNumeroConta()), valorTransferencia);
		conta2.setExtrato(comprovante);
	}
	
	public static void salvar(Conta conta, Conta conta2, double valorTransferencia) {
		
		Extrato extratoOrigem = new Extrato("Tranferência", - valorTransferencia, conta);
		Extrato extratoDestino = new Extrato("Tranferência", + valorTransferencia, conta2);
		
		ExtratoController.cadastrar(extratoOrigem, conta);
		ExtratoController.cadastrar(extratoDestino, conta2);
		
		conta2.setSaldo(conta2.getSaldo() + valorTransferencia);
		conta.setSaldo(conta.getSaldo() - valorTransferencia);

	}
	
}
