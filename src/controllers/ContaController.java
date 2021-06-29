package controllers;

import java.util.ArrayList;

import models.ComprovanteContaCorrente;
import models.Conta;
import models.Transferencia;

public class ContaController implements IContaController
{
	private static ContaController controller;
	
	public static ContaController retornarInstancia()
	{
		if(controller == null)
			return controller = new ContaController();
		return controller;
	}
	
	private ArrayList<Conta> contas = new ArrayList<Conta>();
	private ComprovanteContaCorrente comprovante;
	private Transferencia transferencia;
	
	public void cadastrarConta(Conta conta)
	{
		contas.add(conta);
	}
	
	public Boolean autenticarConta(String cpf, String senha)
	{
		if(verificarSeVazio())			
			return false;
		
		for (Conta conta : contas) 
		{
			if(conta.getNumeroConta().equals(cpf) 
					&& conta.getSenha().equals(senha))
			{
				return true;
			}
		}
		return false;
	}
	
	public Boolean verificarConta(String cpf)
	{
		for (Conta conta : contas) {
			if(conta.getNumeroConta().equals(cpf))
				return true;
		}
		return false;
	}
	
	public Boolean verificarSenha(String senhaAutenticacao, String senha) 
	{	
		if (senhaAutenticacao.equals(senha)) {
			
			return true;
		}	
		
		return false;
	}
	
	public Conta buscarConta(String cpf)
	{
		for (Conta conta : contas) 
		{
			if(conta.getNumeroConta().equals(cpf))
				return conta;
		}
		return null;
	}
	
	public Boolean verificarSeVazio()
	{
		if(contas.isEmpty())
		{
			return true;
		}
		return false;
	}
	
	public boolean checarSaldo(Conta conta, double valor)
	{
		if(conta.getSaldoCorrente() >= valor)
			return true;
		return false;
	}
	
	public boolean checarSaldoPoupanca(Conta conta, double valor)
	{
		if(conta.getSaldoPoupanca() >= valor)
			return true;
		return false;
	}
	
	public void depositar(Conta conta, double valor) 
	{
		conta.setSaldoCorrente(conta.getSaldoCorrente() + valor);
	}

	public void sacar(Conta conta, double valor)
	{
		conta.setSaldoCorrente(conta.getSaldoCorrente() - valor);
	}

	public void transferir(Conta conta, String cpfConta2, double valor) 
	{
		Conta conta2 = buscarConta(cpfConta2);
		transferencia = new Transferencia();
		
		transferencia.setTransferenciaDe(conta.getNumeroConta());
		transferencia.setTransferenciaPara(cpfConta2);
		transferencia.setValor(valor);
		
		comprovante = new ComprovanteContaCorrente(transferencia);
		
		conta2.setComprovante(comprovante);
		conta.setSaldoCorrente(conta.getSaldoCorrente() - valor);
		conta2.setSaldoCorrente(conta2.getSaldoCorrente() + valor);
	}
	
	public void depositarEmPoupanca(Conta conta, double valor)
	{
		conta.setSaldoPoupanca((conta.getSaldoPoupanca() + valor) * 1.11);
	}
	
	public void realizarResgate(Conta conta, double valor)
	{
		conta.setSaldoPoupanca(conta.getSaldoPoupanca() - valor);
		conta.setSaldoCorrente(conta.getSaldoCorrente() + valor);
	}
	
	public void realizarAplicacao(Conta conta, double valor)
	{
		conta.setSaldoCorrente(conta.getSaldoCorrente() - valor);
		conta.setSaldoPoupanca((conta.getSaldoPoupanca() + valor) * 1.11);
	}
}
