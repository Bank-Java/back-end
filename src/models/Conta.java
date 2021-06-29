package models;

import java.util.ArrayList;
import java.util.Date;

public class Conta 
{
	public Conta(String cpf)
	{
		setData(new Date());
		setNumeroConta(cpf);
		setSaldoCorrente(0.0);
		setSaldoPoupanca(0.0);
	}
	
	private String numeroConta;
	private String senha;
	private Date data;
	private Operacao operacao;
	private ArrayList<Comprovante> comprovantes = new ArrayList<Comprovante>();
	private double saldoCorrente;
	private double saldoPoupanca;
	
	public String getNumeroConta() {
		return numeroConta;
	}
	public void setNumeroConta(String numeroConta) {
		this.numeroConta = numeroConta;
	}
	
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	
	public Operacao getOperacao() {
		return operacao;
	}
	public void setOperacao(Operacao operacao) {
		this.operacao = operacao;
	}
	
	public ArrayList<Comprovante> getComprovantes() {
		return comprovantes;
	}
	public void setComprovante(Comprovante comprovante) {
		this.comprovantes.add(comprovante);
	}

	public double getSaldoCorrente() {
		return saldoCorrente;
	}
	public void setSaldoCorrente(double saldoCorrente) {
		this.saldoCorrente = saldoCorrente;
	}
	
	public double getSaldoPoupanca() {
		return saldoPoupanca;
	}
	public void setSaldoPoupanca(double saldoPoupanca) {
		this.saldoPoupanca = saldoPoupanca;
	}		
}
