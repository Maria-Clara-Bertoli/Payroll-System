package com.classes.main;

import com.classes.DTO.Contrato;
import com.classes.DTO.Funcionario;
import com.classes.BO.ContratoBO;
import com.classes.BO.FuncionarioBO;


public class MainProcurarPorCodigo {

	public static void main(String[] args) {
			
		// Teste Procurar por Codigo
		/*ContratoBO contratoBO = new ContratoBO();
		Contrato contrato = new Contrato(1);
		contrato = contratoBO.procurarPorCodigo(contrato);
		System.out.println(contrato);*/
		
		FuncionarioBO funcionarioBO = new FuncionarioBO();
		Funcionario funcionario = new Funcionario(3);
		funcionario = funcionarioBO.procurarPorCodigo(funcionario);
		if(funcionario != null) {
		System.out.println("Funcionário encontrado!");
		System.out.println(funcionario);
		}
		else {
			System.out.println("Funcionário não encontrado!");
		}	
	}
}