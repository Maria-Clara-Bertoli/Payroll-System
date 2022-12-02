package com.classes.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.classes.Conexao.Conexao;
import com.classes.DTO.Funcionario;

public class FuncionarioDAO {
	
	 final String NOMEDATABELA = "Funcionario";
	    public boolean inserir(Funcionario funcionario) {
	        try {
	            Connection conn = Conexao.conectar();
	            String sql = "INSERT INTO " + NOMEDATABELA + " (nome, cpf, data_nascimento) VALUES (?,?,?);";
	            PreparedStatement ps = conn.prepareStatement(sql);
	            ps.setString(1, funcionario.getNome());
	            ps.setString(2, funcionario.getCpf());
	            ps.setDate(3, new java.sql.Date(funcionario.getData_nascimento().getTime()));
	            ps.executeUpdate();
	            ps.close();
	            conn.close();
	            return true;
	        } catch (Exception e) {
	        	e.printStackTrace();
	            return false;
	        }
	    }
	    public boolean alterarNome(Funcionario funcionario) {
	        try {
	            Connection conn = Conexao.conectar();
	            String sql = "UPDATE " + NOMEDATABELA + " SET nome = ? WHERE id = ?;";
	            PreparedStatement ps = conn.prepareStatement(sql);
	            ps.setString(1, funcionario.getNome());
	            ps.setInt(2, funcionario.getId());
	            ps.executeUpdate();
	            ps.close();
	            conn.close();
	            return true;
	        } catch (Exception e) {
	        	 e.printStackTrace();
	             return false;
	        }
	    }
	    public boolean excluir(Funcionario funcionario) {
	        try {
	            Connection conn = Conexao.conectar();
	            String sql = "DELETE FROM " + NOMEDATABELA + " WHERE id = ?;";
	            PreparedStatement ps = conn.prepareStatement(sql);
	            ps.setInt(1, funcionario.getId());
	            ps.executeUpdate();
	            ps.close();
	            conn.close();
	            return true;
	        } catch (Exception e) {
	        	 e.printStackTrace();
	             return false;
	        }
	    }
	    public Funcionario procurarPorCodigo(Funcionario funcionario) {
	        try {
	            Connection conn = Conexao.conectar();
	            String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE id = ?;";
	            PreparedStatement ps = conn.prepareStatement(sql);
	            ps.setInt(1, funcionario.getId());
	            ResultSet rs = ps.executeQuery();
	            if (rs.next()) {
	                Funcionario obj = new Funcionario();
	                obj.setId(rs.getInt(1));
	                obj.setNome(rs.getString(2));
	                obj.setCpf(rs.getString(3));
	                obj.setData_nascimento(rs.getDate(4));
	                ps.close();
	                rs.close();
	                conn.close();
	                return obj;
	            } else {
	                ps.close();
	                rs.close();
	                conn.close();
	                return null;
	            }
	        } catch (Exception e) {
	        	 e.printStackTrace();
	             return null;
	        }
	    }
	    public Funcionario procurarPorNome(Funcionario funcionario) {
	        try {
	            Connection conn = Conexao.conectar();
	            String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE nome = ?;";
	            PreparedStatement ps = conn.prepareStatement(sql);
	            ps.setString(1, funcionario.getNome());
	            ResultSet rs = ps.executeQuery();
	            if (rs.next()) {
	                Funcionario obj = new Funcionario();
	                obj.setId(rs.getInt(1));
	                obj.setNome(rs.getString(2));
	                obj.setCpf(rs.getString(3));
	                obj.setData_nascimento(rs.getDate(4));
	                ps.close();
	                rs.close();
	                conn.close();
	                return obj;
	            } else {
	                ps.close();
	                rs.close();
	                conn.close();
	                return null;
	            }
	        } catch (Exception e) {
	            return null;
	        }
	    }
	    public boolean existe(Funcionario funcionario) {
	        try {
	            Connection conn = Conexao.conectar();
	            String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE id = ?;";
	            PreparedStatement ps = conn.prepareStatement(sql);
	            ps.setInt(1, funcionario.getId());
	            ResultSet rs = ps.executeQuery();
	            if (rs.next()) {
	                ps.close();
	                rs.close();
	                conn.close();
	                return true;
	            }
	        } catch (Exception e) {
	            //System.err.println("Erro: " + e.toString());
	            //e.printStackTrace();
	            return false;
	        }
	        return false;
	    }
	    
	    public List<Funcionario> pesquisarTodos() {
	        try {
	            Connection conn = Conexao.conectar();
	            String sql = "SELECT * FROM " + NOMEDATABELA + ";";
	            PreparedStatement ps = conn.prepareStatement(sql);
	            ResultSet rs = ps.executeQuery();
	            List<Funcionario> listObj = montarLista(rs);
	            return listObj;
	        } catch (Exception e) {
	            //System.err.println("Erro: " + e.toString());
	            //e.printStackTrace();
	            return null;
	        }
	    }
	    public List<Funcionario> montarLista(ResultSet rs) {
	        List<Funcionario> listObj = new ArrayList<Funcionario>();
	        try {
	            while (rs.next()) {
	                Funcionario obj = new Funcionario();
	                obj.setId(rs.getInt(1));
	                obj.setNome(rs.getString(2));
	                obj.setCpf(rs.getString(3));
	                obj.setData_nascimento(rs.getDate(4));
	                listObj.add(obj);
	            }
	            return listObj;
	        } catch (Exception e) {
	            //System.err.println("Erro: " + e.toString());
	            //e.printStackTrace();
	            return null;
	        }
	    }
}
