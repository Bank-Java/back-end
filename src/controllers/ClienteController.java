package controllers;
import java.util.ArrayList;

import models.Cliente;

public class ClienteController {
	
	static ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	
//	CADASTRAR CLIENTE NO ARRAY CLIENTES
	public static void cadastrar(Cliente cliente) {

		clientes.add(cliente);
	}

// EXCLUIR CADASTRO DO CLIENTE
	public static boolean excluir(String cpf) {
		for(int i = 0; i < clientes.size(); i++){
	        if(cpf.equals(clientes.get(i).getCpf()) && clientes.get(i).getConta().getSaldo() == 0){
	            clientes.remove(clientes.get(i));
	            return true;
	        }
	    }
		
		return false;
	}
	
//	AUTENTICACAO DO CPF, PARA QUE NAO EXISTA OUTRO CLIENTE IGUAL
	public static Boolean autenticarCpf(String cpf) {
		
		if (clientes.isEmpty()) {
			
			return true;
		} else if (validar(cpf)) {
			
			return true;
		}
		
		return false;
	}
	
//	VERIFICA SE EXISTE UM CPF IGUAL NO ARRAY CLIENTES
	public static boolean validar(String cpf) {
		
		for(Cliente clienteCadastrado : clientes){
			
			if(clienteCadastrado.getCpf().equals(cpf)) {
				
				return false;
			} 
		}
		
		return true;
	}
	
//	AUTENTICACAO, PARA CHECAR SE OS DADOS ESTAO CORRETOS
	public static Boolean autenticarContaCliente(String cpf, String senha) {
		
		for(int i = 0; i < clientes.size(); i++) {
			
			if (clientes.get(i).getConta().getNumeroConta().equals(cpf) &&
				clientes.get(i).getConta().getSenha().equals(senha)) {
				
				return true;
			}
		}
		
		return false;
	}
	
//	ATUALIZA OS DADOS DO CLIENTE
	public static boolean atualizar(String nome, String cpf, String email, String endereco, 
									String telefone, String dataNascimento) 
	{
		
		for (int i = 0; i < clientes.size(); i++){
			
			if(clientes.get(i).getCpf().equals(cpf)){
				
				clientes.set(i, new Cliente(nome, clientes.get(i).getCpf(), 
											email, endereco, telefone, dataNascimento, 
											clientes.get(i).getConta())
							);
				
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
		
		return null;
	}
	
}
