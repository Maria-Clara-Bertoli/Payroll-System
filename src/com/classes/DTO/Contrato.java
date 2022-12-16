package com.classes.DTO;

import java.util.Date;
import com.classes.BO.ContratoBO;

public class Contrato {
	private int id;
	private Date inicio_contrato;
	private Date termino_contrato;
	private String cargo;
	private String local_trabalho;
	private double valor_hora;
	private int hora_trabalhada_mes;
	private Funcionario funcionario;
	
	public Contrato() {
		
	}
	
	public Contrato(Date inicio_contrato, Date termino_contrato, String cargo, String local_trabalho,
			double valor_hora, int hora_trabalhada_mes, Funcionario funcionario) {
		this.inicio_contrato = inicio_contrato;
		this.termino_contrato = termino_contrato;
		this.cargo = cargo;
		this.local_trabalho = local_trabalho;
		this.valor_hora = valor_hora;
		this.hora_trabalhada_mes = hora_trabalhada_mes;
		this.funcionario = funcionario;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
	
	public String calculaDuracaoContrato(int id) {
		ContratoBO contratoBO = new ContratoBO();
		Contrato contrato = new Contrato();
		contrato.setId(id);
		contrato = contratoBO.procurarPorCodigo(contrato);
		Date inicio = contrato.getInicio_contrato();
		Date fim = contrato.getTermino_contrato();
		long iniciolong = inicio.getTime();
		long fimlong = fim.getTime();
		long diferenca = ((((fimlong - iniciolong)/1000)/60)/60)/24;
		int anos = (int) diferenca/365;
		int dias = (int) diferenca % 365;
		String stringanos = Integer.toString(anos);
		String stringdias = Integer.toString(dias);
		return stringanos + " ano(s) e " + stringdias + " dia(s).";
	}
	
	public double calculaSalarioBase(int id) {
		ContratoBO contratoBO = new ContratoBO();
		Contrato contrato = new Contrato();
		contrato.setId(id);
		contrato = contratoBO.procurarPorCodigo(contrato);
		double salario = contrato.getValor_hora() * (double) contrato.getHora_trabalhada_mes();
		return salario;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Contrato [id=");
		builder.append(id);
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
		builder.append(", funcionario=");
		builder.append(funcionario);
		builder.append("]");
		return builder.toString();
	}
}