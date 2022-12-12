package com.classes.BO;

import com.classes.DTO.Contrato;
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
    public boolean excluir(Funcionario funcionario){
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        return funcionarioDAO.excluir(funcionario);
    }
    public Funcionario procurarPorCodigo(Funcionario funcionario){
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        return funcionarioDAO.procurarPorCodigo(funcionario);
    }
    public Funcionario procurarPorNome(Funcionario funcionario){
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        return funcionarioDAO.procurarPorNome(funcionario);
    }
    public List<Contrato> procurarContratos(Funcionario funcionario) {
    	FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
    	return funcionarioDAO.procurarContratos(funcionario);
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
