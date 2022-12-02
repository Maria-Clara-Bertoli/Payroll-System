package com.classes.main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.classes.BO.ContratoBO;
import com.classes.DTO.Contrato;
import com.classes.BO.FuncionarioBO;
import com.classes.DTO.Funcionario;

public class MainInsercao {
	public static void main(String[] args) throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		/*String datainicio = "30/11/2022";
		String datafinal = "31/12/2023";
		Date datainicioconvertida = sdf.parse(datainicio);
		Date datafinalconvertida = sdf.parse(datafinal);
		
		ContratoBO contratoBO = new ContratoBO();
		Contrato contrato = new Contrato();
		
		contrato = new Contrato(1, datainicioconvertida, datafinalconvertida, "Analista de Testes", "IBM", 59.00, 200);
		if (contratoBO.inserir(contrato))
			System.out.println("Inserido com Sucesso");
		else
			System.out.println("Erro ao Inserir");*/
		
		String datanascimento = "26/09/2008";
		Date datanascimentoconvertida = sdf.parse(datanascimento);
		
		FuncionarioBO funcionarioBO = new FuncionarioBO();
		Funcionario funcionario = new Funcionario();
		
		funcionario = new Funcionario("Rogerio", "907.034.987-56", datanascimentoconvertida);
		if (funcionarioBO.inserir(funcionario))
			System.out.println("Inserido com Sucesso");
		else
			System.out.println("Erro ao Inserir");
	}	
}