package com.mycompany.coracaopet;
import database.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

public class Animal {
    private int idAnimal;
    private String nomeAnimal;
    private String tipoAnimal;
    private String racaAnimal;
    private String cor;
    private String local;
    private int idade;
    private boolean castrado;

    public Animal(int idAnimal, String nomeAnimal, String tipoAnimal, String racaAnimal, String cor, String local, int idade, boolean castrado) {
        this.idAnimal = idAnimal;
        this.nomeAnimal = nomeAnimal;
        this.tipoAnimal = tipoAnimal;
        this.racaAnimal = racaAnimal;
        this.cor = cor;
        this.local = local;
        this.idade = idade;
        this.castrado = castrado;
    }

    public Animal() {
    }
    
    

    public int getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(int idAnimal) {
        this.idAnimal = idAnimal;
    }

    public String getNomeAnimal() {
        return nomeAnimal;
    }

    public void setNomeAnimal(String nomeAnimal) {
        this.nomeAnimal = nomeAnimal;
    }

    public String getTipoAnimal() {
        return tipoAnimal;
    }

    public void setTipoAnimal(String tipoAnimal) {
        this.tipoAnimal = tipoAnimal;
    }

    public String getRacaAnimal() {
        return racaAnimal;
    }

    public void setRacaAnimal(String racaAnimal) {
        this.racaAnimal = racaAnimal;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public boolean isCastrado() {
        return castrado;
    }

    public void setCastrado(boolean castrado) {
        this.castrado = castrado;
    }
    
    
}
