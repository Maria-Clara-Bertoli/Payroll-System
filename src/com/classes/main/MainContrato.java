package com.classes.main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.classes.BO.ContratoBO;
import com.classes.DTO.Calculo;
import com.classes.DTO.Contrato;
import com.classes.DTO.Funcionario;

public class MainContrato {

	public static void main(String[] args) throws ParseException {
		
		Contrato contrato = new Contrato();
		Funcionario funcionario = new Funcionario();
		ContratoBO contratoBO = new ContratoBO();
		Calculo calculo = new Calculo();
		
		Scanner valor = new Scanner(System.in);
		
		System.out.println("Informe uma opção: ");
		System.out.println("opção 1: inserir contrato");
		System.out.println("opção 2: alterar local de trabalho");
		System.out.println("opção 3: alterar cargo");
		System.out.println("opção 4: alterar valor da hora");
		System.out.println("opção 5: alterar horas trabalhadas no mês");
		System.out.println("opção 6: excluir contrato");
		System.out.println("opção 7: pesquisar por código");
		System.out.println("opção 8: pesquisar por local de trabalho");
		System.out.println("opção 9: pesquisar por cargo");
		System.out.println("opção 10: pesquisar calculo");
		System.out.println("opção 11: pesquisar todos os registros");
		System.out.println("opção 12: calcular salário base");
		System.out.println("opção 13: calcular duração do cotrato de trabalho");
		int x = valor.nextInt();
		
		switch (x) {
		case 1:
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			String datainicio = "17/04/2057";
			String datafinal = "28/03/2058";
			Date datainicioconvertida = sdf.parse(datainicio);
			Date datafinalconvertida = sdf.parse(datafinal);
			funcionario = new Funcionario();
			funcionario.setId(3);
			
			contrato = new Contrato (datainicioconvertida, datafinalconvertida, "Professora", "IFC", 8, 200, funcionario);
			if (contratoBO.inserir(contrato))
				System.out.println("Inserido com sucesso");
			else
				System.out.println("Erro ao inserir");
			break;
		case 2:
			contrato = new Contrato();
			contrato.setId(6);
			contrato.setLocal_trabalho("Harvard");
			contratoBO.alterarLocalTrabalho(contrato);
			contrato = contratoBO.procurarPorCodigo(contrato);
			System.out.println(contrato.toString());
			break;
		case 3:
			contrato = new Contrato();
			contrato.setId(6);
			contrato.setCargo("Diretora");
			contratoBO.alterarCargo(contrato);
			contrato = contratoBO.procurarPorCodigo(contrato);
			System.out.println(contrato.toString());
			break;
		case 4:
			contrato = new Contrato();
			contrato.setId(6);
			contrato.setValor_hora(18);
			contratoBO.alterarValorHora(contrato);
			contrato = contratoBO.procurarPorCodigo(contrato);
			System.out.println(contrato.toString());
			break;
		case 5:
			contrato = new Contrato();
			contrato.setId(6);
			contrato.setHora_trabalhada_mes(100);
			contratoBO.alterarHoraTrabalhadaMes(contrato);
			contrato = contratoBO.procurarPorCodigo(contrato);
			System.out.println(contrato.toString());
			break;
		case 6: 
			contrato = new Contrato();
			contrato.setId(6);
			if (contratoBO.excluir(contrato))
				System.out.println("Excluido com sucesso.");
			else
				System.out.println("Erro ao excluir.");
			break;
		case 7: 
			contrato = new Contrato();
			contrato.setId(4);
			contrato = contratoBO.procurarPorCodigo(contrato);
			System.out.println(contrato.toString());
			break;
		case 8: 
			contrato = new Contrato();
			List <Contrato> listalocaltrabalho = new ArrayList <Contrato>();
			contrato.setLocal_trabalho("CERN");
			listalocaltrabalho = contratoBO.procurarPorLocalTrabalho(contrato);
			for(Contrato elemento : listalocaltrabalho) {
				System.out.println(elemento.toString());
			}
			break;
		case 9: 
			contrato = new Contrato();
			List <Contrato> listacargo = new ArrayList <Contrato>();
			contrato.setCargo("Desenvolvedora");
			listacargo = contratoBO.procurarPorCargo(contrato);
			for(Contrato elemento : listacargo) {
				System.out.println(elemento.toString());
			}
			break;
		case 10:
			contrato = new Contrato();
			contrato.setId(5);
			calculo = new Calculo();
			calculo = contratoBO.procurarCalculo(contrato);
			System.out.println(calculo.toString());
			break;
		case 11:
			List<Contrato> listatodos = new ArrayList<Contrato>();
			listatodos = contratoBO.pesquisarTodos();	
			for (Contrato elemento : listatodos) {
				System.out.println(elemento.toString());
			}
			break;
		case 12:
			contrato = new Contrato();
			contrato.setId(5);
			System.out.println(contrato.calculaSalarioBase(5));
			break;
		case 13:
			contrato = new Contrato();
			contrato.setId(5);
			System.out.println(contrato.calculaDuracaoContrato(5));
			break;
		default:
			System.out.println("Opção inválida. Tente novamente!");
		}
		
		valor.close();
	}
}
