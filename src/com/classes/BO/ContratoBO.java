package com.classes.BO;

import java.util.List;

import com.classes.DAO.ContratoDAO;
import com.classes.DTO.Calculo;
import com.classes.DTO.Contrato;

public class ContratoBO {

    public boolean inserir(Contrato contrato){
        if (existe(contrato) != true) {
            ContratoDAO contratoDAO = new ContratoDAO();
            return contratoDAO.inserir(contrato);
        }
        return false;
    }
    public boolean alterarLocalTrabalho(Contrato contrato){
    	if (existe(contrato) == true) {
        ContratoDAO contratoDAO = new ContratoDAO();
        return contratoDAO.alterarLocalTrabalho(contrato);
    	}
    	return false;
    }
    public boolean alterarCargo(Contrato contrato){
    	if(existe(contrato) == true) {
        ContratoDAO contratoDAO = new ContratoDAO();
        return contratoDAO.alterarCargo(contrato);
    	}
    	return false;
    }
    public boolean excluir(Contrato contrato){
        ContratoDAO contratoDAO = new ContratoDAO();
        return contratoDAO.excluir(contrato);
    }
    public Contrato procurarPorCodigo(Contrato contrato){
        ContratoDAO contratoDAO = new ContratoDAO();
        return contratoDAO.procurarPorCodigo(contrato);
    }
    public Contrato procurarPorLocalTrabalho(Contrato contrato){
        ContratoDAO contratoDAO = new ContratoDAO();
        return contratoDAO.procurarPorLocalTrabalho(contrato);
    }
    public Contrato procurarPorCargo(Contrato contrato){
        ContratoDAO contratoDAO = new ContratoDAO();
        return contratoDAO.procurarPorCargo(contrato);
    }
    public Calculo procurarCalculo(Contrato contrato){
        ContratoDAO contratoDAO = new ContratoDAO();
        return contratoDAO.procurarCalculo(contrato);
    }
    public boolean existe(Contrato contrato){
        ContratoDAO contratoDAO = new ContratoDAO();
        return contratoDAO.existe(contrato);
    }
    public List<Contrato> pesquisarTodos(){
        ContratoDAO contratoDAO = new ContratoDAO();
        return contratoDAO.pesquisarTodos();
    }
}