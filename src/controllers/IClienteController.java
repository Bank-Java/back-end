package controllers;

import models.Cliente;

public interface IClienteController 
{
	public void cadastrarCliente(Cliente cliente);
	public boolean checarSeVazio();
	public boolean autenticarCpf(String cpf);
	public Cliente buscarCliente(String cpf);
	public boolean atualizar(String nome, String cpf, String email, String endereco, 
									String telefone, String dataNascimento);
}
