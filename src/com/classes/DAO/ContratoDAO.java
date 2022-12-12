package com.classes.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.classes.Conexao.Conexao;
import com.classes.DTO.Calculo;
import com.classes.DTO.Contrato;
import com.classes.DTO.Funcionario;

public class ContratoDAO {

    final String NOMEDATABELA = "Contrato";
    public boolean inserir(Contrato contrato) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "INSERT INTO " + NOMEDATABELA + " (inicio_contrato, termino_contrato, cargo, local_trabalho, valor_hora, hora_trabalhada_mes, id_funcionario) VALUES (?,?,?,?,?,?,?);";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setDate(1, new java.sql.Date(contrato.getInicio_contrato().getTime()));
            ps.setDate(2, new java.sql.Date(contrato.getTermino_contrato().getTime()));
            ps.setString(3, contrato.getCargo());
            ps.setString(4, contrato.getLocal_trabalho());
            ps.setDouble(5, contrato.getValor_hora());
            ps.setInt(6, contrato.getHora_trabalhada_mes());
            ps.setInt(7, contrato.getFuncionario().getId());
            ps.executeUpdate();
            ps.close();
            conn.close();
            return true;
        } catch (Exception e) {
        	e.printStackTrace();
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
    public boolean alterarCargo(Contrato contrato) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "UPDATE " + NOMEDATABELA + " SET cargo = (?) WHERE id = (?);";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, contrato.getCargo());
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
                obj.setInicio_contrato(rs.getDate(2));
                obj.setTermino_contrato(rs.getDate(3));
                obj.setCargo(rs.getString(4));
                obj.setLocal_trabalho(rs.getString(5));
                obj.setValor_hora(rs.getDouble(6));
                obj.setHora_trabalhada_mes(rs.getInt(7));
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
    public Contrato procurarPorLocalTrabalho(Contrato contrato) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE local_trabalho = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, contrato.getLocal_trabalho());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Contrato obj = new Contrato();
                obj.setId(rs.getInt(1));
                obj.setInicio_contrato(rs.getDate(2));
                obj.setTermino_contrato(rs.getDate(3));
                obj.setCargo(rs.getString(4));
                obj.setLocal_trabalho(rs.getString(5));
                obj.setValor_hora(rs.getDouble(6));
                obj.setHora_trabalhada_mes(rs.getInt(7));
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
    public Contrato procurarPorCargo(Contrato contrato) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE cargo = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, contrato.getCargo());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Contrato obj = new Contrato();
                obj.setId(rs.getInt(1));
                obj.setInicio_contrato(rs.getDate(2));
                obj.setTermino_contrato(rs.getDate(3));
                obj.setCargo(rs.getString(4));
                obj.setLocal_trabalho(rs.getString(5));
                obj.setValor_hora(rs.getDouble(6));
                obj.setHora_trabalhada_mes(rs.getInt(7));
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
    public Calculo procurarCalculo(Contrato contrato) {
        try {
        Connection conn = Conexao.conectar();
        String sql = "SELECT * FROM " + "calculo" + " WHERE id_contrato = ?;";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, contrato.getId());
        ResultSet rs = ps.executeQuery();
        Calculo obj = new Calculo();
            if (rs.next()) {
                obj.setId(rs.getInt(1));
                obj.setInss(rs.getDouble(2));
                obj.setIrrf(rs.getDouble(3));
                obj.setFgts(rs.getDouble(4));
                obj.setVale_transporte(rs.getDouble(5));
                obj.setVale_alimentacao(rs.getDouble(6));
            }
            return obj;
        } catch (Exception e) {
            //System.err.println("Erro: " + e.toString());
            //e.printStackTrace();
            return null;
        }
    }
    
    public boolean existe(Contrato contrato) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE id = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, contrato.getId());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                ps.close();
                rs.close();
                conn.close();
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
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
                obj.setInicio_contrato(rs.getDate(2));
                obj.setTermino_contrato(rs.getDate(3));
                obj.setCargo(rs.getString(4));
                obj.setLocal_trabalho(rs.getString(5));
                obj.setValor_hora(rs.getDouble(6));
                obj.setHora_trabalhada_mes(rs.getInt(7));
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