package com.classes.DTO;

import com.classes.BO.ContratoBO;

public class Calculo {
	
	private int id;
	private double vale_transporte;
	private double vale_alimentacao;
	private Contrato contrato;
	
	public Calculo() {
		
	}
	
	public Calculo(double vale_transporte, double vale_alimentacao, Contrato contrato) {
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
	
	public double descontoInss(int id) {
		Contrato contrato = new Contrato();
		Calculo calculo = new Calculo();
		ContratoBO contratoBO = new ContratoBO();
		contrato.setId(id);
		calculo = contratoBO.procurarCalculo(contrato);
		if(calculo.getContrato().calculaSalarioBase(id) < 1212) {
			System.out.println("O funcionário é isento de contribuição para o INSS.");
		}
		else if(calculo.getContrato().calculaSalarioBase(id) == 1212) {
			double faixa1 = (1212/100) * 7.5;
			return faixa1;
		}
		if(calculo.getContrato().calculaSalarioBase(id) > 1212 && calculo.getContrato().calculaSalarioBase(id) <= 2427.35){
			double faixa1 = (1212/100) * 7.5;
			double faixa2 = ((calculo.getContrato().calculaSalarioBase(id) - 1212)/100) * 9;
			return faixa1 + faixa2;
		}
		else if(calculo.getContrato().calculaSalarioBase(id) > 2427.35 && calculo.getContrato().calculaSalarioBase(id) <= 3641.03){
			double faixa1 = (1212/100) * 7.5;
			double faixa2 = ((2427.35 - 1212/100)) * 9;
			double faixa3 = ((calculo.getContrato().calculaSalarioBase(id) - 2427.35)/100) * 12;
			return faixa1 + faixa2 + faixa3;
		}
		else if(calculo.getContrato().calculaSalarioBase(id) > 3641.03) {
			double faixa1 = (1212/100) * 7.5;
			double faixa2 = ((2427.35 - 1212)/100) * 9;
			double faixa3 = ((3641.03 - 2427.35)/100) * 12;
			double faixa4 = ((calculo.getContrato().calculaSalarioBase(id) - 3641.03)/100) * 14;
			return faixa1 + faixa2 + faixa3 + faixa4;
		}
		else {
			System.out.println("O salário do funcionário extrapolou o teto das faixas de contribuição para o INSS.");
		}
		return 0;
	}
	
	public double descontoIrrf(int id) {
		Contrato contrato = new Contrato();
		Calculo calculo = new Calculo();
		ContratoBO contratoBO = new ContratoBO();
		contrato.setId(id);
		calculo = contratoBO.procurarCalculo(contrato);
		double descontoinss = calculo.getContrato().calculaSalarioBase(id) - calculo.descontoInss(id);
		if(descontoinss < 1903.98) {
			System.out.println("O funcionário é isento de contribuição para o IRRF");
		}
		else if(descontoinss >= 1903.99 && descontoinss <= 2826.65) {
			double descontopercentual = (descontoinss/100) * 7.5;
			double descontoirrf = descontopercentual - 142.80;
			return descontoirrf;
		}
		else if(descontoinss >= 2826.66 && descontoinss <= 3751.05) {
			double descontopercentual = (descontoinss/100) * 15;
			double descontoirrf = descontopercentual - 354.80;
			return descontoirrf;
		}
		else if(descontoinss >= 3751.06 && descontoinss <= 4664.68) {
			double descontopercentual = (descontoinss/100) * 22.5;
			double descontoirrf = descontopercentual - 636.13;
			return descontoirrf;
		}
		else {
			double descontopercentual = (descontoinss/100) * 27.5;
			double descontoirrf = descontopercentual - 869.36;
			return descontoirrf;
		}
		return 0;
	}
	
	public double descontoValeTransporte(int id) {
		Contrato contrato = new Contrato();
		Calculo calculo = new Calculo();
		ContratoBO contratoBO = new ContratoBO();
		contrato.setId(id);
		calculo = contratoBO.procurarCalculo(contrato);
		double descontovaletransporte = (calculo.getContrato().calculaSalarioBase(id)/100) * 6;
		return descontovaletransporte;
	}
	
	public double descontoValeAlimentacao(int id) {
		Contrato contrato = new Contrato();
		Calculo calculo = new Calculo();
		ContratoBO contratoBO = new ContratoBO();
		contrato.setId(id);
		calculo = contratoBO.procurarCalculo(contrato);
		double descontovalealimentacao = (calculo.getContrato().calculaSalarioBase(id)/100) * 20;
		return descontovalealimentacao;
	}
	
	public double folhaMensal(int id) {
		Contrato contrato = new Contrato();
		Calculo calculo = new Calculo();
		ContratoBO contratoBO = new ContratoBO();
		contrato.setId(id);
		calculo = contratoBO.procurarCalculo(contrato);
		double folhamensal = (((((calculo.getContrato().calculaSalarioBase(id) - calculo.descontoInss(id)) - calculo.descontoIrrf(id)) - calculo.descontoValeTransporte(id)) - calculo.descontoValeAlimentacao(id)) + calculo.getVale_alimentacao()) + calculo.getVale_transporte();
		return folhamensal;
	}
	
	public double folhaFerias(int id) {
		Contrato contrato = new Contrato();
		Calculo calculo = new Calculo();
		ContratoBO contratoBO = new ContratoBO();
		contrato.setId(id);
		calculo = contratoBO.procurarCalculo(contrato);
		double folhaferias = (calculo.getContrato().calculaSalarioBase(id) + (calculo.getContrato().calculaSalarioBase(id)/3) - calculo.descontoInss(id)) - calculo.descontoIrrf(id);
		return folhaferias;
	}
	
	public double decimoTerceiroPrimeira(int mesestrabalhados, int id) {
		Contrato contrato = new Contrato();
		Calculo calculo = new Calculo();
		ContratoBO contratoBO = new ContratoBO();
		contrato.setId(id);
		calculo = contratoBO.procurarCalculo(contrato);
		
		double primeiraparcela = ((calculo.getContrato().calculaSalarioBase(id)/12) * mesestrabalhados)/2;
		return primeiraparcela;
	}
	
	public double decimoTerceiroSegunda(int mesestrabalhados, int id) {
		Contrato contrato = new Contrato();
		Calculo calculo = new Calculo();
		ContratoBO contratoBO = new ContratoBO();
		contrato.setId(id);
		calculo = contratoBO.procurarCalculo(contrato);

		double segundaparcela = ((calculo.getContrato().calculaSalarioBase(id)) - calculo.descontoInss(id)) - calculo.descontoIrrf(id);
		double descontoprimeiraparcela = segundaparcela - calculo.decimoTerceiroPrimeira(mesestrabalhados, id);
		return descontoprimeiraparcela;
	}
	
	public double saldoSalario(int diastrabalhados, int id) {
		Contrato contrato = new Contrato();
		Calculo calculo = new Calculo();
		ContratoBO contratoBO = new ContratoBO();
		contrato.setId(id);
		calculo = contratoBO.procurarCalculo(contrato);
		
		double saldosalario = (calculo.getContrato().calculaSalarioBase(id)/30) * diastrabalhados;
		
		return saldosalario;
	}
	
	public double feriasProporcionais(int mesestrabalhados, int id) {
		Contrato contrato = new Contrato();
		Calculo calculo = new Calculo();
		ContratoBO contratoBO = new ContratoBO();
		contrato.setId(id);
		calculo = contratoBO.procurarCalculo(contrato);
		
		double feriasproporcionais = (calculo.getContrato().calculaSalarioBase(id)/12) * mesestrabalhados;
		double feriasproporcionaistotal = feriasproporcionais + (feriasproporcionais/3);
		
		return feriasproporcionaistotal;
	}
	
	public double decimoProporcional(int mesestrabalhados, int id) {
		Contrato contrato = new Contrato();
		Calculo calculo = new Calculo();
		ContratoBO contratoBO = new ContratoBO();
		contrato.setId(id);
		calculo = contratoBO.procurarCalculo(contrato);
		
		double decimoproporcional = (calculo.getContrato().calculaSalarioBase(id)/12) * mesestrabalhados;
		
		return decimoproporcional;
		
	}
	
	public double folhaRescisao(int diastrabalhados, int mesestrabalhados, int id) {
		Contrato contrato = new Contrato();
		Calculo calculo = new Calculo();
		ContratoBO contratoBO = new ContratoBO();
		contrato.setId(id);
		calculo = contratoBO.procurarCalculo(contrato);
		
		return calculo.getContrato().calculaSalarioBase(id) + calculo.saldoSalario(diastrabalhados, id) + calculo.feriasProporcionais(mesestrabalhados, id) + calculo.decimoProporcional(mesestrabalhados, id);
	}
	
	public String imprimeMensal(int id) {
		Contrato contrato = new Contrato();
		Calculo calculo = new Calculo();
		ContratoBO contratoBO = new ContratoBO();
		contrato.setId(id);
		calculo = contratoBO.procurarCalculo(contrato);
		StringBuilder builder = new StringBuilder();
		builder.append("------------MENSAL--------------").append('\n').append('\n');
		builder.append("* SALÁRIO BRUTO").append('\n');
		builder.append(calculo.getContrato().calculaSalarioBase(id)).append('\n').append('\n');
		builder.append("* PROVENTOS").append('\n');
		builder.append("Vale alimentação: " + calculo.getVale_alimentacao()).append('\n');
		builder.append("Vale transporte: " + calculo.getVale_transporte()).append('\n').append('\n');
		builder.append("* DESCONTOS").append('\n');
		builder.append("Inss: " + calculo.descontoInss(id)).append('\n');
		builder.append("Irrf: " + calculo.descontoIrrf(id)).append('\n');
		builder.append("Vale alimentação: " + calculo.descontoValeAlimentacao(id)).append('\n');
		builder.append("Vale transporte: " + calculo.descontoValeTransporte(id)).append('\n').append('\n');
		builder.append("* SALÁRIO LÍQUIDO").append('\n');
		builder.append(calculo.folhaMensal(id)).append('\n');
		return builder.toString();
	}
	
	public String imprimeFerias(int id) {
		Contrato contrato = new Contrato();
		Calculo calculo = new Calculo();
		ContratoBO contratoBO = new ContratoBO();
		contrato.setId(id);
		calculo = contratoBO.procurarCalculo(contrato);
		StringBuilder builder = new StringBuilder();
		builder.append("------------FÉRIAS--------------").append('\n').append('\n');
		builder.append("* SALÁRIO BRUTO").append('\n');
		builder.append(calculo.getContrato().calculaSalarioBase(id)).append('\n').append('\n');
		builder.append("* PROVENTOS").append('\n');
		builder.append("-").append('\n');
		builder.append("* DESCONTOS").append('\n');
		builder.append("Inss: " + calculo.descontoInss(id)).append('\n');
		builder.append("Irrf: " + calculo.descontoIrrf(id)).append('\n').append('\n');
		builder.append("* SALÁRIO LÍQUIDO").append('\n');
		builder.append(calculo.folhaFerias(id)).append('\n');
		return builder.toString();
	}
	
	public String imprimeDecimo(int mesestrabalhados, int id) {
		Contrato contrato = new Contrato();
		Calculo calculo = new Calculo();
		ContratoBO contratoBO = new ContratoBO();
		contrato.setId(id);
		calculo = contratoBO.procurarCalculo(contrato);
		StringBuilder builder = new StringBuilder();
		builder.append("------------DÉCIMO TERCEIRO--------------").append('\n').append('\n');
		builder.append("* SALÁRIO BRUTO").append('\n');
		builder.append(calculo.getContrato().calculaSalarioBase(id)).append('\n').append('\n');
		builder.append("* PROVENTOS").append('\n');
		builder.append("-").append('\n');
		builder.append("* DESCONTOS").append('\n');
		builder.append("Inss: " + calculo.descontoInss(id)).append('\n');
		builder.append("Irrf: " + calculo.descontoIrrf(id)).append('\n').append('\n');
		builder.append("* SALÁRIO LÍQUIDO").append('\n');
		builder.append("Primeira parcela: " + calculo.decimoTerceiroPrimeira(mesestrabalhados, id)).append('\n');
		builder.append("Segunda parcela: " + calculo.decimoTerceiroSegunda(mesestrabalhados, id)).append('\n');
		return builder.toString();
	}
	
	public String imprimeRescisao(int diastrabalhados, int mesestrabalhados, int id) {
		Contrato contrato = new Contrato();
		Calculo calculo = new Calculo();
		ContratoBO contratoBO = new ContratoBO();
		contrato.setId(id);
		calculo = contratoBO.procurarCalculo(contrato);
		StringBuilder builder = new StringBuilder();
		builder.append("------------RESCISÃO--------------").append('\n').append('\n');
		builder.append("* SALÁRIO BRUTO").append('\n');
		builder.append(calculo.getContrato().calculaSalarioBase(id)).append('\n').append('\n');
		builder.append("* PROVENTOS").append('\n');
		builder.append("Aviso prévio: " + calculo.getContrato().calculaSalarioBase(id)).append('\n');
		builder.append("Saldo salário: " + calculo.saldoSalario(diastrabalhados, id)).append('\n');
		builder.append("Férias proporcionais: " + calculo.feriasProporcionais(mesestrabalhados, id)).append('\n');
		builder.append("Décimo terceiro proporcional: " + calculo.decimoProporcional(mesestrabalhados, id)).append('\n').append('\n');
		builder.append("* DESCONTOS").append('\n');
		builder.append("-").append('\n');
		builder.append("* SALÁRIO LÍQUIDO").append('\n');
		builder.append(calculo.folhaRescisao(diastrabalhados, mesestrabalhados, id)).append('\n');
		return builder.toString();
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Calculo [id=");
		builder.append(id);
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
