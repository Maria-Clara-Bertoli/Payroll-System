package com.classes.DTO;

import java.util.Date;

public class Funcionario {

	private int id;
	private String nome;
	private String cpf;
	private Date data_nascimento;
	
	public Funcionario() {
		
	}
	
	public Funcionario(String nome, String cpf, Date data_nascimento) {
		this.nome = nome;
		this.cpf = cpf;
		this.data_nascimento = data_nascimento;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getData_nascimento() {
		return data_nascimento;
	}

	public void setData_nascimento(Date data_nascimento) {
		this.data_nascimento = data_nascimento;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Funcionario [id=");
		builder.append(id);
		builder.append(", nome=");
		builder.append(nome);
		builder.append(", cpf=");
		builder.append(cpf);
		builder.append(", data_nascimento=");
		builder.append(data_nascimento);
		builder.append("]");
		return builder.toString();
	}
}
