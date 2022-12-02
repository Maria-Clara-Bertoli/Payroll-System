package com.classes.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.classes.Conexao.Conexao;
import com.classes.DTO.Contrato;

public class ContratoDAO {

    final String NOMEDATABELA = "Contrato";
    public boolean inserir(Contrato contrato) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "INSERT INTO " + NOMEDATABELA + " (numero_contrato, inicio_contrato, termino_contrato, cargo, local_trabalho, valor_hora, hora_trabalhada_mes) VALUES (?,?,?,?,?,?,?);";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, contrato.getNumero_contrato());
            ps.setDate(2, new java.sql.Date(contrato.getInicio_contrato().getTime()));
            ps.setDate(3, new java.sql.Date(contrato.getTermino_contrato().getTime()));
            ps.setString(4, contrato.getCargo());
            ps.setString(5, contrato.getLocal_trabalho());
            ps.setDouble(6, contrato.getValor_hora());
            ps.setInt(7, contrato.getHora_trabalhada_mes());
            ps.executeUpdate();
            ps.close();
            conn.close();
            return true;
        } catch (Exception e) {
        	System.out.println("aaaaaaaaa");
            System.out.println(e.getMessage());
            return false;
        }
    }
    public boolean alterarLocalTrabalho(Contrato contrato) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "UPDATE " + NOMEDATABELA + " SET local_trabalho = (?) WHERE id = (?);";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, contrato.getLocal_trabalho());
            ps.setInt(2, contrato.getId());
            ps.executeUpdate();
            ps.close();
            conn.close();
            return true;
        } catch (Exception e) {
        	 e.printStackTrace();
             return false;
        }
    }
    public boolean excluir(Contrato contrato) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "DELETE FROM " + NOMEDATABELA + " WHERE id = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, contrato.getId());
            ps.executeUpdate();
            ps.close();
            conn.close();
            return true;
        } catch (Exception e) {
        	 e.printStackTrace();
             return false;
        }
    }
    public Contrato procurarPorCodigo(Contrato contrato) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE id = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, contrato.getId());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Contrato obj = new Contrato();
                obj.setId(rs.getInt(1));
                obj.setNumero_contrato(rs.getInt(2));
                obj.setInicio_contrato(rs.getDate(3));
                obj.setTermino_contrato(rs.getDate(4));
                obj.setCargo(rs.getString(5));
                obj.setLocal_trabalho(rs.getString(6));
                obj.setValor_hora(rs.getDouble(7));
                obj.setHora_trabalhada_mes(rs.getInt(8));
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
    public Contrato procurarLocalTrabalho(Contrato contrato) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE local_trabalho = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(2, contrato.getNumero_contrato());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Contrato obj = new Contrato();
                obj.setId(rs.getInt(1));
                obj.setNumero_contrato(rs.getInt(2));
                obj.setInicio_contrato(rs.getDate(3));
                obj.setTermino_contrato(rs.getDate(4));
                obj.setCargo(rs.getString(5));
                obj.setLocal_trabalho(rs.getString(6));
                obj.setValor_hora(rs.getDouble(7));
                obj.setHora_trabalhada_mes(rs.getInt(8));
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
    public boolean existe(Contrato contrato) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE local_trabalho = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, contrato.getLocal_trabalho());
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
    
    public List<Contrato> pesquisarTodos() {
        try {
            Connection conn = Conexao.conectar();
            String sql = "SELECT * FROM " + NOMEDATABELA + ";";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<Contrato> listObj = montarLista(rs);
            return listObj;
        } catch (Exception e) {
            //System.err.println("Erro: " + e.toString());
            //e.printStackTrace();
            return null;
        }
    }
    public List<Contrato> montarLista(ResultSet rs) {
        List<Contrato> listObj = new ArrayList<Contrato>();
        try {
            while (rs.next()) {
                Contrato obj = new Contrato();
                obj.setId(rs.getInt(1));
                obj.setNumero_contrato(rs.getInt(2));
                obj.setInicio_contrato(rs.getDate(3));
                obj.setTermino_contrato(rs.getDate(4));
                obj.setCargo(rs.getString(5));
                obj.setLocal_trabalho(rs.getString(6));
                obj.setValor_hora(rs.getDouble(7));
                obj.setHora_trabalhada_mes(rs.getInt(8));
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