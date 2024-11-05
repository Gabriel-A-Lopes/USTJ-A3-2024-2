package com.mycompany.coracaopet;
import database.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Funcionario {
    private String org;
    private String nomeFunc;
    private String loginFunc;
    private String senhaFunc;
    private int codigoFunc;

    public Funcionario(String org, String nomeFunc, String loginFunc, String senhaFunc, int codigoFunc) {
        this.org = org;
        this.nomeFunc = nomeFunc;
        this.loginFunc = loginFunc;
        this.senhaFunc = senhaFunc;
        this.codigoFunc = codigoFunc;
    }

    public Funcionario() {
    }
    
    

    public String getOrg() {
        return org;
    }

    public void setOrg(String org) {
        this.org = org;
    }

    public String getNomeFunc() {
        return nomeFunc;
    }

    public void setNomeFunc(String nomeFunc) {
        this.nomeFunc = nomeFunc;
    }

    public String getLoginFunc() {
        return loginFunc;
    }

    public void setLoginFunc(String loginFunc) {
        this.loginFunc = loginFunc;
    }

    public String getSenhaFunc() {
        return senhaFunc;
    }

    public void setSenhaFunc(String senhaFunc) {
        this.senhaFunc = senhaFunc;
    }

    public int getCodigoFunc() {
        return codigoFunc;
    }

    public void setCodigoFunc(int codigoFunc) {
        this.codigoFunc = codigoFunc;
    }
    public boolean validaUser() throws SQLException{
        String sql = "Select nomeFunc FROM tb_funcionarios WHERE loginFunc = ? AND senhaFunc = ?";
        
        ConnectionFactory cf = new ConnectionFactory();
        
        try (Connection conn = cf.getConnection(); PreparedStatement ps = conn.prepareStatement(sql);){
            ps.setString(1, getLoginFunc());
            ps.setString(2, getSenhaFunc());
            
            ResultSet rs = ps.executeQuery();
            
            System.out.println("Lido com sucesso.");
            if(rs.next()){
                nomeFunc = rs.getString("nomeFunc");
                return true;
            } else {
                return false;
            }
        } catch (Exception e){
            e.printStackTrace();
            System.out.println("Não localizado.");
            return false;
        }
    }
}
