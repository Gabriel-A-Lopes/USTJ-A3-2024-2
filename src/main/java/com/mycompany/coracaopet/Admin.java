package com.mycompany.coracaopet;

import database.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Admin {
    private boolean isAdmin;
    private String name;
    private String login;
    private String senha;

    public Admin(boolean isAdmin, String name, String login, String senha) {
        this.isAdmin = isAdmin;
        this.name = name;
        this.login = login;
        this.senha = senha;
    }

    public Admin() {
    }

    
    

    public boolean isIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
        public boolean validaUser() throws SQLException{
        String sql = "Select * FROM tb_pessoa WHERE login = ? AND senha = ?";
        
        ConnectionFactory cf = new ConnectionFactory();
        
        try (Connection conn = cf.getConnection(); PreparedStatement ps = conn.prepareStatement(sql);){
            ps.setString(1, getLogin());
            ps.setString(2, getSenha());
            
            ResultSet rs = ps.executeQuery();
            
            System.out.println("Lido com sucesso.");
            return rs.next();
        } catch (Exception e){
            e.printStackTrace();
            System.out.println("Não localizado.");
            return false;
        }
    }
}
