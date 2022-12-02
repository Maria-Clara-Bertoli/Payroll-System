package com.classes.BO;

import com.classes.DTO.Contrato;
import com.classes.DAO.ContratoDAO;
import java.util.List;

public class ContratoBO {

    public boolean inserir(Contrato contrato){
        if (existe(contrato) != true) {
            ContratoDAO contratoDAO = new ContratoDAO();
            return contratoDAO.inserir(contrato);
        }
        return false;
    }
    public boolean alterarLocalTrabalho(Contrato contrato){
        ContratoDAO contratoDAO = new ContratoDAO();
        return contratoDAO.alterarLocalTrabalho(contrato);
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
        return contratoDAO.procurarLocalTrabalho(contrato);
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