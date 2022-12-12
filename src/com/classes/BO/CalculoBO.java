package com.classes.BO;

import java.util.List;

import com.classes.DAO.CalculoDAO;
import com.classes.DTO.Calculo;

public class CalculoBO {

	    public boolean inserir(Calculo calculo){
	        if (existe(calculo) != true) {
	            CalculoDAO calculoDAO = new CalculoDAO();
	            return calculoDAO.inserir(calculo);
	        }
	        return false;
	    }
	    public boolean alterar(Calculo calculo){
	        CalculoDAO calculoDAO = new CalculoDAO();
	        return calculoDAO.alterarInss(calculo);
	    }
	    public boolean excluir(Calculo marca){
	        CalculoDAO marcasDAO = new CalculoDAO();
	        return marcasDAO.excluir(marca);
	    }
	    public Calculo procurarPorCodigo(Calculo marca){
	        CalculoDAO marcasDAO = new CalculoDAO();
	        return marcasDAO.procurarPorCodigo(marca);
	    }
	 
	    public boolean existe(Calculo calculo){
	        CalculoDAO marcasDAO = new CalculoDAO();
	        return marcasDAO.existe(calculo);
	    }
	    public List<Calculo> pesquisarTodos(){
	        CalculoDAO calculoDAO = new CalculoDAO();
	        return calculoDAO.pesquisarTodos();
	    }
	}
