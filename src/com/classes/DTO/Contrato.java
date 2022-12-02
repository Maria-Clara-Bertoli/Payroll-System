package com.classes.DTO;

import java.util.Date;

public class Contrato {
	private int id;
	private int numero_contrato;
	private Date inicio_contrato;
	private Date termino_contrato;
	private String cargo;
	private String local_trabalho;
	private double valor_hora;
	private int hora_trabalhada_mes;
	
	public Contrato() {
		
	}
	
	public Contrato(int id, String local_trabalho) {
		this.id = id;
		this.local_trabalho = local_trabalho;	
	}
	
	public Contrato(String local_trabalho) {
		this.local_trabalho = local_trabalho;
	}

	public Contrato(int id) {
		this.id = id;
	}
	
	public Contrato(int numero_contrato, Date inicio_contrato, Date termino_contrato, String cargo,
			String local_trabalho, double valor_hora, int hora_trabalhada_mes) {
		super();
		this.numero_contrato = numero_contrato;
		this.inicio_contrato = inicio_contrato;
		this.termino_contrato = termino_contrato;
		this.cargo = cargo;
		this.local_trabalho = local_trabalho;
		this.valor_hora = valor_hora;
		this.hora_trabalhada_mes = hora_trabalhada_mes;
		this.inicio_contrato = inicio_contrato;
		this.termino_contrato = termino_contrato;
	}

	public Contrato(int id, int numero_contrato, Date inicio_contrato, Date termino_contrato, String cargo,
			String local_trabalho, double valor_hora, int hora_trabalhada_mes) {
		super();
		this.id = id;
		this.numero_contrato = numero_contrato;
		this.inicio_contrato = inicio_contrato;
		this.termino_contrato = termino_contrato;
		this.cargo = cargo;
		this.local_trabalho = local_trabalho;
		this.valor_hora = valor_hora;
		this.hora_trabalhada_mes = hora_trabalhada_mes;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumero_contrato() {
		return numero_contrato;
	}

	public void setNumero_contrato(int numero_contrato) {
		this.numero_contrato = numero_contrato;
	}

	public Date getInicio_contrato() {
		return inicio_contrato;
	}

	public void setInicio_contrato(Date inicio_contrato) {
		this.inicio_contrato = inicio_contrato;
	}

	public Date getTermino_contrato() {
		return termino_contrato;
	}

	public void setTermino_contrato(Date termino_contrato) {
		this.termino_contrato = termino_contrato;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getLocal_trabalho() {
		return local_trabalho;
	}

	public void setLocal_trabalho(String local_trabalho) {
		this.local_trabalho = local_trabalho;
	}

	public double getValor_hora() {
		return valor_hora;
	}

	public void setValor_hora(double valor_hora) {
		this.valor_hora = valor_hora;
	}

	public int getHora_trabalhada_mes() {
		return hora_trabalhada_mes;
	}

	public void setHora_trabalhada_mes(int hora_trabalhada_mes) {
		this.hora_trabalhada_mes = hora_trabalhada_mes;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Contrato [id=");
		builder.append(id);
		builder.append(", numero_contrato=");
		builder.append(numero_contrato);
		builder.append(", inicio_contrato=");
		builder.append(inicio_contrato);
		builder.append(", termino_contrato=");
		builder.append(termino_contrato);
		builder.append(", cargo=");
		builder.append(cargo);
		builder.append(", local_trabalho=");
		builder.append(local_trabalho);
		builder.append(", valor_hora=");
		builder.append(valor_hora);
		builder.append(", hora_trabalhada_mes=");
		builder.append(hora_trabalhada_mes);
		builder.append("]");
		return builder.toString();
	}
}