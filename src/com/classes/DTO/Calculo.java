package com.classes.DTO;

import com.classes.BO.CalculoBO;
import com.classes.BO.ContratoBO;

public class Calculo {
	
	private int id;
	private double inss;
	private double irrf;
	private double fgts;
	private double vale_transporte;
	private double vale_alimentacao;
	private Contrato contrato;
	
	public Calculo() {
		
	}
	
	public Calculo(int id, double inss, double irrf, double fgts, double vale_transporte, double vale_alimentacao,
			Contrato contrato) {
		this.id = id;
		this.inss = inss;
		this.irrf = irrf;
		this.fgts = fgts;
		this.vale_transporte = vale_transporte;
		this.vale_alimentacao = vale_alimentacao;
		this.contrato = contrato;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getInss() {
		return inss;
	}

	public void setInss(double inss) {
		this.inss = inss;
	}

	public double getIrrf() {
		return irrf;
	}

	public void setIrrf(double irrf) {
		this.irrf = irrf;
	}

	public double getFgts() {
		return fgts;
	}

	public void setFgts(double fgts) {
		this.fgts = fgts;
	}

	public double getVale_transporte() {
		return vale_transporte;
	}

	public void setVale_transporte(double vale_transporte) {
		this.vale_transporte = vale_transporte;
	}

	public double getVale_alimentacao() {
		return vale_alimentacao;
	}

	public void setVale_alimentacao(double vale_alimentacao) {
		this.vale_alimentacao = vale_alimentacao;
	}

	public Contrato getContrato() {
		return contrato;
	}

	public void setContrato(Contrato contrato) {
		this.contrato = contrato;
	}
	
	public double descontoInss(int codigo) {
		return 0;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Calculo [id=");
		builder.append(id);
		builder.append(", inss=");
		builder.append(inss);
		builder.append(", irrf=");
		builder.append(irrf);
		builder.append(", fgts=");
		builder.append(fgts);
		builder.append(", vale_transporte=");
		builder.append(vale_transporte);
		builder.append(", vale_alimentacao=");
		builder.append(vale_alimentacao);
		builder.append(", contrato=");
		builder.append(contrato);
		builder.append("]");
		return builder.toString();
	}
}
