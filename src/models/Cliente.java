package models;

public class Cliente 
{
//	CONSTRUTOR USADO PARA ATUALIZAR CLIENTE
	public Cliente(String nome, String cpf, String email, String endereco, String telefone,
			String dataNascimento, Conta conta) 
	{
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.endereco = endereco;
		this.telefone = telefone;
		this.dataNasc = dataNascimento;
		this.conta = conta;
	}
	
	public Cliente() {
		
	}
	
	private String nome;
	private String cpf;
	private String email;
	private String endereco;
	private String telefone;
	private String dataNasc;
	private Conta conta;
	
	
//	GETTERS AND SETTERS

//		SETTERS
		public void setConta(Conta conta) {
			this.conta = conta;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}
		
		public void setCpf(String cpf) {
			this.cpf = cpf;
		}
		
		public void setEmail(String email) {
			this.email = email;
		}
		
		public void setEndereco(String endereco) {
			this.endereco = endereco;
		}
		
		public void setTelefone(String telefone) {
			this.telefone = telefone;
		}
		
		public void setDataNasc(String dataNasc) {
			this.dataNasc = dataNasc;
		}
		
//		GETTERS
		public Conta getConta() {
			return conta;
		}

		public String getNome() {
			return nome;
		}
		
		public String getCpf() {
			return cpf;
		}
		
		public String getEmail() {
			return email;
		}
		
		public String getEndereco() {
			return endereco;
		}
		
		public String getTelefone() {
			return telefone;
		}
		
		public String getDataNasc() {
			return dataNasc;
		}
		
		@Override
		public String toString() {
			return "Cliente: " + nome + ", cpf: " + cpf + ", email: " + email + ", endereco: " + endereco
					+ ", telefone: " + telefone + ", dataNasc: " + dataNasc;
		}
}
