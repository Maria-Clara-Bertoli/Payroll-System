package com.classes.BO;

import com.classes.DTO.Funcionario;
import com.classes.DAO.FuncionarioDAO;
import java.util.List;

public class FuncionarioBO {
	
	public FuncionarioBO() {
		
	}
	
	public boolean inserir(Funcionario funcionario){
        if (existe(funcionario) != true) {
            FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
            return funcionarioDAO.inserir(funcionario);
        }
        return false;
    }
    public boolean alterarNome(Funcionario funcionario){
        FuncionarioDAO contratoDAO = new FuncionarioDAO();
        return contratoDAO.alterarNome(funcionario);
    }
    public boolean excluir(Funcionario contrato){
        FuncionarioDAO contratoDAO = new FuncionarioDAO();
        return contratoDAO.excluir(contrato);
    }
    public Funcionario procurarPorCodigo(Funcionario contrato){
        FuncionarioDAO contratoDAO = new FuncionarioDAO();
        return contratoDAO.procurarPorCodigo(contrato);
    }
    public Funcionario procurarPorNome(Funcionario funcionario){
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        return funcionarioDAO.procurarPorNome(funcionario);
    }
    public boolean existe(Funcionario funcionario){
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        return funcionarioDAO.existe(funcionario);
    }
    public List<Funcionario> pesquisarTodos(){
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        return funcionarioDAO.pesquisarTodos();
    }

}
