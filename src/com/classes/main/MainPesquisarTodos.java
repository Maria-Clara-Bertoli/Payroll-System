package com.classes.main;

import java.util.ArrayList;
import java.util.List;
import com.classes.BO.FuncionarioBO;
import com.classes.DTO.Funcionario;

public class MainPesquisarTodos {

	public static void main(String[] args) {
		
		/*ContratoBO contratoBO = new ContratoBO();
		List<Contrato> lista = new ArrayList<Contrato>();
		lista = contratoBO.pesquisarTodos();	
		for (Contrato contrato : lista) {
			System.out.println(contrato.toString());
		}*/
		
		FuncionarioBO funcionarioBO = new FuncionarioBO();
		List<Funcionario> lista = new ArrayList<Funcionario>();
		lista = funcionarioBO.pesquisarTodos();	
		for (Funcionario funcionario : lista) {
			System.out.println(funcionario.toString());
		}
	
	}
}