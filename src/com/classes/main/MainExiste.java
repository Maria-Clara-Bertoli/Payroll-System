package com.classes.main;

import com.classes.BO.ContratoBO;
import com.classes.DTO.Contrato;
import com.classes.BO.FuncionarioBO;
import com.classes.DTO.Funcionario;

public class MainExiste {

	public static void main(String[] args) {

		// Teste Existe
		// Verifica se existe outro item com a mesma descricao
		/*ContratoBO contratoBO = new ContratoBO();
		Contrato contrato = new Contrato("GG Net");
		if (contratoBO.existe(contrato))
			System.out.println("Local de trabalho encontrado");
		else
			System.out.println("Local de trabalho não encontrado");*/
		
		FuncionarioBO funcionarioBO = new FuncionarioBO();
		Funcionario funcionario = new Funcionario(1);
		if (funcionarioBO.existe(funcionario))
			System.out.println("Funcionário encontrado");
		else
			System.out.println("Funcionário não encontrado");

	}
}