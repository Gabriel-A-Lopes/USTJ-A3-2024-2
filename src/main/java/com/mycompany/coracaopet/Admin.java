package com.mycompany.coracaopet;

import database.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Admin {
    private boolean isAdmin;
    private int codigoADM;
    private String nomeADM;
    private String loginADM;
    private String senhaADM;

    public Admin(boolean isAdmin, int codigoADM, String nomeADM, String loginADM, String senhaADM) {
        this.isAdmin = isAdmin;
        this.codigoADM = codigoADM;
        this.nomeADM = nomeADM;
        this.loginADM = loginADM;
        this.senhaADM = senhaADM;
    }

    public Admin() {
    }
    
    

    public boolean isIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public int getCodigoADM() {
        return codigoADM;
    }

    public void setCodigoADM(int codigoADM) {
        this.codigoADM = codigoADM;
    }

    public String getNomeADM() {
        return nomeADM;
    }

    public void setNomeADM(String nomeADM) {
        this.nomeADM = nomeADM;
    }

    public String getLoginADM() {
        return loginADM;
    }

    public void setLoginADM(String loginADM) {
        this.loginADM = loginADM;
    }

    public String getSenhaADM() {
        return senhaADM;
    }

    public void setSenhaADM(String senhaADM) {
        this.senhaADM = senhaADM;
    }
    
        public boolean validaADM() throws SQLException{
        String sql = "Select nomeADM FROM tb_admin WHERE loginADM = ? AND senhaADM = ?";
        
        ConnectionFactory cf = new ConnectionFactory();
        
        try (Connection conn = cf.getConnection(); PreparedStatement ps = conn.prepareStatement(sql);){
            ps.setString(1, getLoginADM());
            ps.setString(2, getSenhaADM());
            
            ResultSet rs = ps.executeQuery();
            
            System.out.println("Lido com sucesso.");
            if(rs.next()){
                nomeADM = rs.getString("nomeADM");
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
