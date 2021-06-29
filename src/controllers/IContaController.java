package controllers;

import models.Conta;

public interface IContaController 
{
	public void cadastrarConta(Conta conta);
	public Boolean autenticarConta(String cpf, String senha);
	public Boolean verificarConta(String cpf);
	public Boolean verificarSenha(String senhaAutenticacao, String senha);
	public Conta buscarConta(String cpf);
	public Boolean verificarSeVazio();
	public boolean checarSaldo(Conta conta, double valor);
	public boolean checarSaldoPoupanca(Conta conta, double valor);
	public void depositar(Conta conta, double valor);
	public void sacar(Conta conta, double valor);
	public void transferir(Conta conta, String cpfConta2, double valor);
	public void depositarEmPoupanca(Conta conta, double valor);
	public void realizarResgate(Conta conta, double valor);
	public void realizarAplicacao(Conta conta, double valor);
}
