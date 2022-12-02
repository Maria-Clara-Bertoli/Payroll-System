package com.classes.main;

import com.classes.BO.ContratoBO;
import com.classes.DTO.Contrato;
import com.classes.BO.FuncionarioBO;
import com.classes.DTO.Funcionario;

public class MainExclusao {

	public static void main(String[] args) {

		// Teste Excluir
		/*ContratoBO contratoBO = new ContratoBO();
		Contrato contrato = new Contrato(1);
		if (contratoBO.excluir(contrato))
			System.out.println("Excluido com Sucesso");
		else
			System.out.println("Erro ao Excluir");*/

		
		FuncionarioBO funcionarioBO = new FuncionarioBO();
		Funcionario funcionario = new Funcionario(1);
		if (funcionarioBO.excluir(funcionario))
			System.out.println("Excluido com Sucesso");
		else
			System.out.println("Erro ao Excluir");

	}
}