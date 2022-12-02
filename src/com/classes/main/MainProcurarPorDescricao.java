package com.classes.main;

import com.classes.BO.ContratoBO;
import com.classes.DTO.Contrato;

public class MainProcurarPorDescricao {

	public static void main(String[] args) {

		// Teste Procurar por Descricao
		// retorna o primeiro encontrado
		ContratoBO contratoBO = new ContratoBO();
		Contrato contrato = new Contrato("IPM Sistemas");
		contrato = contratoBO.procurarPorLocalTrabalho(contrato);
		System.out.println(contrato);

	}
}