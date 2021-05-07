package controllers;
import java.util.ArrayList;

import models.Cliente;

public class ClienteController {
	static ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	
	public static Boolean cadastrar(Cliente cliente) {

		if (clientes.isEmpty()) {
			
			clientes.add(cliente);
			return true;
		} 

		if(validar(cliente)) {
			clientes.add(cliente);
			return true;			
		} else {
			return false;
		}
		
	}
	
	public static boolean validar(Cliente cliente) {
		for(Cliente clienteCadastrado : clientes){
			if(clienteCadastrado.getCpf().equals(cliente.getCpf())) {
				return false;
			} 
		}
		
		return true;
	}
	
	
//	METODO AUTENTICACAO CPF
	public static Boolean autenticarCpf(Cliente cliente) {
		for (int i = 0; i < clientes.size(); i++) {
			if (clientes.get(i).getCpf().equals(cliente.getCpf())) {
				
				return false;
			}
		}
		
		return true;
	}
	
	public static boolean atualizar(String nome, String cpf, String email, String endereco, String telefone,
			String dataNascimento) {
		for (int i = 0; i < clientes.size(); i++){
			if(clientes.get(i).getCpf().equals(cpf)){
				clientes.set(i, new Cliente(nome, clientes.get(i).getCpf(), email, endereco, telefone, dataNascimento, clientes.get(i).getConta())); 
				return true;
			}
		}
		return false;
	}
	
	static Cliente cliente;
	public static Cliente buscarConta(String numeroConta) {
		for (int i = 0; i < clientes.size(); i++) {
			if (clientes.get(i).getConta().getNumeroConta().equals(numeroConta)) {
				
				return clientes.get(i);
			}
		}
		
		return cliente;
	}
	
}
