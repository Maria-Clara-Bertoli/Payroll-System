package com.classes.main;

import com.classes.BO.FuncionarioBO;
import com.classes.DTO.Funcionario;
import com.classes.BO.ContratoBO;
import com.classes.DTO.Contrato;

public class MainAlteracao {

	public static void main(String[] args) {
			
		/*ContratoBO contratoBO = new ContratoBO();
		Contrato contrato = new Contrato(1, "GG Net");
		contratoBO.alterarLocalTrabalho(contrato);
		contrato = contratoBO.procurarPorCodigo(contrato);
		System.out.println(contrato);*/
		
		FuncionarioBO funcionarioBO = new FuncionarioBO();
		Funcionario funcionario = new Funcionario(1, "Ricardo");
		funcionarioBO.alterarNome(funcionario);
		funcionario = funcionarioBO.procurarPorCodigo(funcionario);
		System.out.println(funcionario);
	}
}