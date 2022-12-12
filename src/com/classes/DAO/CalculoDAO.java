package com.classes.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.classes.DTO.Calculo;
import com.classes.DTO.Contrato;
import com.classes.DTO.Funcionario;
import com.classes.Conexao.Conexao;

public class CalculoDAO {

	    final String NOMEDATABELA = "calculo";
	    public boolean inserir(Calculo calculo) {
	        try {
	            Connection conn = Conexao.conectar();
	            String sql = "INSERT INTO " + NOMEDATABELA + " (inss, irrf, fgts, vale_transporte, vale_alimentacao, id_contrato) VALUES (?,?,?,?,?,?,);";
	            PreparedStatement ps = conn.prepareStatement(sql);
	            ps.setDouble(1, calculo.getInss());
	            ps.setDouble(2, calculo.getIrrf());
	            ps.setDouble(3, calculo.getFgts());
	            ps.setDouble(4, calculo.getVale_transporte());
	            ps.setDouble(5, calculo.getVale_alimentacao());
	            ps.setDouble(6, calculo.getContrato().getId());
	            ps.executeUpdate();
	            ps.close();
	            conn.close();
	            return true;
	        } catch (Exception e) {
	            e.printStackTrace();
	            return false;
	        }
	    }
	    public boolean alterarInss(Calculo calculo) {
	        try {
	            Connection conn = Conexao.conectar();
	            String sql = "UPDATE " + NOMEDATABELA + " SET inss = ? WHERE id = ?;";
	            PreparedStatement ps = conn.prepareStatement(sql);
	            ps.setDouble(1, calculo.getInss());
	            ps.setInt(2, calculo.getId());
	            ps.executeUpdate();
	            ps.close();
	            conn.close();
	            return true;
	        } catch (Exception e) {
	        	 e.printStackTrace();
	             return false;
	        }
	    }
	    public boolean excluir(Calculo calculo) {
	        try {
	            Connection conn = Conexao.conectar();
	            String sql = "DELETE FROM " + NOMEDATABELA + " WHERE id = ?;";
	            PreparedStatement ps = conn.prepareStatement(sql);
	            ps.setInt(1, calculo.getId());
	            ps.executeUpdate();
	            ps.close();
	            conn.close();
	            return true;
	        } catch (Exception e) {
	        	 e.printStackTrace();
	             return false;
	        }
	    }
	    public Calculo procurarPorCodigo(Calculo calculo) {
	        try {
	            Connection conn = Conexao.conectar();
	            String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE id = ?;";
	            PreparedStatement ps = conn.prepareStatement(sql);
	            ps.setInt(1, calculo.getId());
	            ResultSet rs = ps.executeQuery();
	            if (rs.next()) {
	                Calculo obj = new Calculo();
	                obj.setId(rs.getInt(1));
	                obj.setInss(rs.getDouble(2));
	                obj.setIrrf(rs.getDouble(3));
	                obj.setFgts(rs.getDouble(4));
	                obj.setVale_transporte(rs.getDouble(5));
	                obj.setVale_alimentacao(rs.getDouble(6));
	                obj.getContrato().setId(rs.getInt(7));
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
	    public Calculo procurarCalculoEContratoPorCodigo(Calculo calculo) {
	        try {
	            Connection conn = Conexao.conectar();
	            String sql = "SELECT * FROM " + NOMEDATABELA + " JOIN" + " contrato" + " ON NOMEDATABELA.id = ?" + " AND" + " contrato.id = NOMEDATABELA.id_contrato;";
	            PreparedStatement ps = conn.prepareStatement(sql);
	            ps.setInt(1, calculo.getId());
	            ResultSet rs = ps.executeQuery();
	            if (rs.next()) {
	                Calculo obj = new Calculo();
	                obj.setId(rs.getInt(1));
	                obj.setInss(rs.getDouble(2));
	                obj.setIrrf(rs.getDouble(3));
	                obj.setFgts(rs.getDouble(4));
	                obj.setVale_transporte(rs.getDouble(5));
	                obj.setVale_alimentacao(rs.getDouble(6));
	                obj.getContrato().setId(rs.getInt(7));
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
	    public boolean existe(Calculo calculo) {
	        try {
	            Connection conn = Conexao.conectar();
	            String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE id = ?;";
	            PreparedStatement ps = conn.prepareStatement(sql);
	            ps.setInt(1, calculo.getId());
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
	    public List<Calculo> pesquisarTodos() {
	        try {
	            Connection conn = Conexao.conectar();
	            String sql = "SELECT * FROM " + NOMEDATABELA + ";";
	            PreparedStatement ps = conn.prepareStatement(sql);
	            ResultSet rs = ps.executeQuery();
	            List<Calculo> listObj = montarLista(rs);
	            return listObj;
	        } catch (Exception e) {
	            //System.err.println("Erro: " + e.toString());
	            //e.printStackTrace();
	            return null;
	        }
	    }
	    public List<Calculo> montarLista(ResultSet rs) {
	        List<Calculo> listObj = new ArrayList<Calculo>();
	        try {
	            while (rs.next()) {
	                Calculo obj = new Calculo();
	                obj.setId(rs.getInt(1));
	                obj.setInss(rs.getDouble(2));
	                obj.setIrrf(rs.getDouble(3));
	                obj.setFgts(rs.getDouble(4));
	                obj.setVale_transporte(rs.getDouble(5));
	                obj.setVale_alimentacao(6);
	                obj.getContrato().setId(7);
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
