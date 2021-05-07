package controllers;
import java.util.List;

import models.Conta;
import models.Extrato;

public class TransferenciaController {

	static List<Conta> contas = ContaController.listaConta();
	
	public static void transferir(Conta conta, Conta conta2, double valorTransferencia) {
		
		conta2.setSaldo(conta2.getSaldo() + valorTransferencia);
		conta.setSaldo(conta.getSaldo() - valorTransferencia);
		
		salvar(conta, conta2, valorTransferencia);
		
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
