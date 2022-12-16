package com.classes.BO;

import java.util.ArrayList;
import java.util.List;

import com.classes.DAO.CalculoDAO;
import com.classes.DTO.Calculo;

public class CalculoBO {

	    public boolean inserir(Calculo calculo){
	        if (existe(calculo) != true) {
	        	boolean validacao = false;
	        	List<Calculo> lista = new ArrayList <Calculo>();
	            CalculoDAO calculoDAO = new CalculoDAO();
	            lista = calculoDAO.pesquisarTodos();
	            for(Calculo elemento : lista) {
	            	if(elemento.getContrato().getId() == calculo.getContrato().getId()) {
	            		validacao = true;
	            		break;
	            	}
	            	else {
	            		validacao = false;
	            	}
	            }
	            if(validacao == false) {
	            return calculoDAO.inserir(calculo);
	            }
	            else {
	            	System.out.println("O contrato informado já foi relacionado a um cálculo.");
	            }
	        }
	        return false;
	    }
	    public boolean alterarValeTransporte(Calculo calculo){
	    	if(existe(calculo) == true) {
	        CalculoDAO calculoDAO = new CalculoDAO();
	        return calculoDAO.alterarValeTransporte(calculo);
	    	}
	    	return false;
	    }
	    public boolean alterarValeAlimentacao(Calculo calculo){
	    	if(existe(calculo) == true) {
	        CalculoDAO calculoDAO = new CalculoDAO();
	        return calculoDAO.alterarValeAlimentacao(calculo);
	    	}
	    	return false;
	    }
	    public boolean excluir(Calculo calculo){
	        CalculoDAO calculoDAO = new CalculoDAO();
	        return calculoDAO.excluir(calculo);
	    }
	    public Calculo procurarPorCodigo(Calculo calculo){
	        CalculoDAO calculoDAO = new CalculoDAO();
	        return calculoDAO.procurarPorCodigo(calculo);
	    }
	 
	    public boolean existe(Calculo calculo){
	        CalculoDAO calculoDAO = new CalculoDAO();
	        return calculoDAO.existe(calculo);
	    }
	    public List<Calculo> pesquisarTodos(){
	        CalculoDAO calculoDAO = new CalculoDAO();
	        return calculoDAO.pesquisarTodos();
	    }
	}
