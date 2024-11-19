package com.mycompany.coracaopet;

import database.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;


public class Admin {
    private boolean isAdmin;
    private int idADM;
    private String nomeADM;
    private String loginADM;
    private String senhaADM;

    public Admin(boolean isAdmin, int idADM, String nomeADM, String loginADM, String senhaADM) {
        this.isAdmin = isAdmin;
        this.idADM = idADM;
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
        return idADM;
    }

    public void setCodigoADM(int codigoADM) {
        this.idADM = codigoADM;
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
    public void criarFunc(Funcionario func) throws SQLException{
        String sql = "insert into tb_funcionarios(nomeFunc, org, loginFunc, senhaFunc) values (?, ?, ?, ?)";
        ConnectionFactory cf = new ConnectionFactory();
        try (Connection conn = cf.getConnection(); PreparedStatement ps = conn.prepareStatement(sql);){
            ps.setString(1, func.getNomeFunc());
            ps.setString(2, func.getOrg());
            ps.setString(3, func.getLoginFunc());
            ps.setString(4, func.getSenhaFunc());
            ps.execute();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    public void atualizarFunc(Funcionario func) throws SQLException{
        String sql = "update tb_funcionarios set nomeFunc = ?, org = ?, loginFunc = ?, senhaFunc = ? where idFuncionario = ?";
        ConnectionFactory cf = new ConnectionFactory();
        try (Connection conn = cf.getConnection(); PreparedStatement ps = conn.prepareStatement(sql);){
            ps.setString(1, func.getNomeFunc());
            ps.setString(2, func.getOrg());
            ps.setString(3, func.getLoginFunc());
            ps.setString(4, func.getSenhaFunc());
            ps.setInt(5, func.getCodigoFunc());
            ps.execute();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    public void apagarFunc(Funcionario func) throws SQLException{
        String sql = "delete from tb_funcionarios where idFuncionario = ?";
        ConnectionFactory cf = new ConnectionFactory();
        try (Connection conn = cf.getConnection(); PreparedStatement ps = conn.prepareStatement(sql);){
            ps.setInt(1, func.getCodigoFunc());
            ps.executeUpdate();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    public DefaultTableModel buscarFunc() throws SQLException{
        String sql = "select idFuncionario, nomeFunc, org, loginFunc, senhaFunc from tb_funcionarios";
        ConnectionFactory cf = new ConnectionFactory();
        DefaultTableModel model = new DefaultTableModel(new String[]{"ID", "Nome", "Organização", "Login", "Senha"}, 0);
        
        try (Connection conn = cf.getConnection(); PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                String codigo = rs.getString("idFuncionario");
                String nome = rs.getString("nomeFunc");
                String org = rs.getString("org");
                String login = rs.getString("loginFunc");
                String senha = rs.getString("senhaFunc");
                model.addRow(new Object[]{codigo, nome, org, login, senha});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return model;
    }
    public void registrarAnimal(Animal anm) throws SQLException{
        String sql = "insert into tb_animais(nomeAnimal, tipoAnimal, racaAnimal, cor, local, idade, castrado) values (?, ?, ?, ?, ?, ?, ?)";
        ConnectionFactory cf = new ConnectionFactory();
        try (Connection conn = cf.getConnection(); PreparedStatement ps = conn.prepareStatement(sql);){
            ps.setString(1, anm.getNomeAnimal());
            ps.setString(2, anm.getTipoAnimal());
            ps.setString(3, anm.getRacaAnimal());
            ps.setString(4, anm.getCor());
            ps.setString(5, anm.getLocal());
            ps.setInt(6, anm.getIdade());
            ps.setBoolean(7, anm.isCastrado());
            ps.execute();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    public void atualizarAnimal(Animal anm) throws SQLException{
        String sql = "update tb_animais set nomeAnimal = ?, tipoAnimal = ?, racaAnimal = ?, cor = ?, local = ?, idade = ?, castrado = ? where idAnimal = ?";
        ConnectionFactory cf = new ConnectionFactory();
        try (Connection conn = cf.getConnection(); PreparedStatement ps = conn.prepareStatement(sql);){
            ps.setString(1, anm.getNomeAnimal());
            ps.setString(2, anm.getTipoAnimal());
            ps.setString(3, anm.getRacaAnimal());
            ps.setString(4, anm.getCor());
            ps.setString(5, anm.getLocal());
            ps.setInt(6, anm.getIdade());
            ps.setBoolean(7, anm.isCastrado());
            ps.setInt(8, anm.getIdAnimal());
            ps.execute();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    public void apagarAnimal(Animal anm) throws SQLException{
        String sql = "delete from tb_animais where idAnimal = ?";
        ConnectionFactory cf = new ConnectionFactory();
        try (Connection conn = cf.getConnection(); PreparedStatement ps = conn.prepareStatement(sql);){
            ps.setInt(1, anm.getIdAnimal());
            ps.executeUpdate();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    public DefaultTableModel buscarAnimal() throws SQLException{
        String sql = "select * from tb_animais";
        ConnectionFactory cf = new ConnectionFactory();
        DefaultTableModel model = new DefaultTableModel(new String[]{"ID do Animal", "Nome", "Tipo", "Raça", "Cor", "Local", "Idade", "É Castrado?"}, 0);
        
        try (Connection conn = cf.getConnection(); PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                String idAnimal = rs.getString("idAnimal");
                String nomeAnimal = rs.getString("nomeAnimal");
                String tipoAnimal = rs.getString("tipoAnimal");
                String racaAnimal = rs.getString("racaAnimal");
                String cor = rs.getString("cor");
                String local = rs.getString("local");
                String idade = rs.getString("idade");
                String castrado = rs.getString("castrado");
                model.addRow(new Object[]{idAnimal, nomeAnimal, tipoAnimal, racaAnimal, cor, local, idade, castrado});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return model;
    }
}
