package controllers;

import java.util.ArrayList;

import models.Cliente;

public class ClienteController implements IClienteController
{
	private static ClienteController controller;
	
	public static ClienteController retornarInstacia()
	{
		if(controller == null)
			controller = new ClienteController();
		return controller;
	}
	
	private ArrayList<Cliente> clientes = new ArrayList<Cliente>(); 
	
	public void cadastrarCliente(Cliente cliente) 
	{
		clientes.add(cliente);
	}
	
	public boolean checarSeVazio() 
	{
		if(clientes.isEmpty()) 
		{
			return true;
		}
		return false;
	}
	
	public boolean autenticarCpf(String cpf) 
	{
		if(checarSeVazio())
		{
			return true;
		}
		for (Cliente cliente : clientes) 
		{
			if(cliente.getCpf().equals(cpf))
				return false;
		}
		
		return true;
	}
	
	public Cliente buscarCliente(String cpf)
	{
		for (Cliente cliente : clientes) 
		{
			if(cliente.getCpf().equals(cpf))
				return cliente;
		}
		return null;
	}

	public boolean atualizar(String nome, String cpf, String email, String endereco, 
									String telefone, String dataNascimento) 
	{
		
		for (int i = 0; i <= clientes.size(); i++)
		{
			if(clientes.get(i).getCpf().equals(cpf))
			{
				clientes.set(i, new Cliente(nome, clientes.get(i).getCpf(), 
											email, endereco, telefone, dataNascimento, 
											clientes.get(i).getConta()));
				return true;
			}
		}
		
		return false;
	}
}
