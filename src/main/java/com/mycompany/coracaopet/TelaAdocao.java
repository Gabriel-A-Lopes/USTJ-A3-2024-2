/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.coracaopet;

import database.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane; 
import javax.swing.JTextField;


   



/**
 *
 * @author ACER
 */
public class TelaAdocao extends javax.swing.JFrame { 
    /**
     * Creates new form TelaAdocao
     */
    public TelaAdocao() throws SQLException {        
        initComponents();
        configurarTabela();
        carregarAnimaisAdocao();
        jButton2.addActionListener(new java.awt.event.ActionListener() {
           public void actionPerformed(java.awt.event.ActionEvent evt) {
             int selectedRow = jTable1.getSelectedRow();
               if (selectedRow != -1) {
                 JTextField nomeField = new JTextField();
                 JTextField cpfField = new JTextField();
                 JTextField telefoneField = new JTextField();
                 
                    Object[] message ={
                    "Nome:", nomeField,
                    "CPF:", cpfField,
                    "Telefone:", telefoneField,
                    
                    };
                    int option = JOptionPane.showConfirmDialog(null, message, "Informações do Adotante", JOptionPane.OK_CANCEL_OPTION);
                    if (option == JOptionPane.OK_OPTION) {
                      JTextField ruaField = new JTextField();
                      JTextField numeroField = new JTextField();
                      JTextField complementoField = new JTextField();
                      JTextField cidadeField = new JTextField();
                      Object[] addressInfo = {
                          "Rua:", ruaField,
                          "Número:", numeroField,
                          "Complemento:", complementoField,
                          "Cidade:", cidadeField,
                      };
                      int addressInfoOption = JOptionPane.showConfirmDialog(null, addressInfo, "Informações de Endereço", JOptionPane.OK_CANCEL_OPTION);
                      if (addressInfoOption == JOptionPane.OK_OPTION) {
                    String nome = nomeField.getText();
                    
                    int  cpf = 0;
                    int numero = 0;
                    try{
                        cpf = Integer.parseInt(cpfField.getText());
                        numero = Integer.parseInt(numeroField.getText());
                    }catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Por favor, insira um número válido para CPF e Número.");
                        return;
                    }
                    String telefone = telefoneField.getText();
                    String rua = ruaField.getText();
                    String complemento = complementoField.getText();
                    String cidade = cidadeField.getText(); 
                    
                    int enderecoID = inserirEndereco(rua, numero, complemento, cidade);
                    if (enderecoID != -1) {
                        inserirAdotante(nome, cpf, telefone, enderecoID);
                    }
                   } 
                 }
               }else{
                   JOptionPane.showMessageDialog(null, "Por favor, selecione um animal para adotar.");
                }
               }
            });
     }
    private void configurarTabela(){
        jTable1.setModel(new DefaultTableModel(
                new Object [][] {},
                new String [] {
                    "Nome do Animal", 
                    "Tipo do Animal", 
                    "Raça do Animal", 
                    "Cor", 
                    "Local", 
                    "Idade", 
                    "Castrado"
                }
             ){             
            boolean[] canEdit = new boolean [] {
                    false, false, false, false, false, false, false
        };
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return canEdit [columnIndex];
        }
     });                                
  }
    private int inserirEndereco(String rua, int numero, String complemento, String cidade) {
        String sql = "INSERT INTO tb_endereco (rua, numero, complemento, cidade) VALUES (?, ?, ?, ?)";
        ConnectionFactory cf = new ConnectionFactory();
        int enderecoID = -1;
        
        try (Connection conn = cf.getConnection(); PreparedStatement ps = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, rua);
            ps.setInt(2, numero);
            ps.setString(3, complemento);
            ps.setString(4, cidade);
            ps.executeUpdate();
            
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    enderecoID = rs.getInt(1);
                }
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return enderecoID;
    }
    private void inserirAdotante(String nome, int cpf, String telefone, int enderecoID) {
        String sql = "INSERT INTO tb_adotante (nome, cpf, telefone, enderecoID) VALUES (?, ?, ?, ?)";
        ConnectionFactory cf = new ConnectionFactory();
        
        try (Connection conn = cf.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, nome);
            ps.setInt(2, cpf);
            ps.setString(3, telefone);
            ps.setInt(4, enderecoID);
            ps.executeUpdate();
            System.out.println("Dados do adotante inseridos com sucesso!");
            } catch (SQLException e) {
                e.printStackTrace();
        }
        
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Coração Pet");
        setMinimumSize(new java.awt.Dimension(800, 600));
        setPreferredSize(new java.awt.Dimension(800, 600));
        setResizable(false);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(21, 198, 148));
        jPanel1.setPreferredSize(new java.awt.Dimension(100, 96));
        jPanel1.setLayout(null);

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/asd.png"))); // NOI18N
        jPanel1.add(jLabel18);
        jLabel18.setBounds(350, -10, 90, 100);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 800, 96);

        jButton2.setBackground(new java.awt.Color(46, 150, 235));
        jButton2.setText("ADOTAR");
        jButton2.setActionCommand("adoptButton");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(360, 500, 80, 23);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(170, 100, 452, 402);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jButton2ActionPerformed
    public DefaultTableModel buscarAnimalAdocao() throws SQLException{
        String sql = "select * from tb_animais";
        ConnectionFactory cf = new ConnectionFactory();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel(); 
        model.setRowCount(0);
        
        try (Connection conn = cf.getConnection(); PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                String nomeAnimal = rs.getString("nomeAnimal");
                String tipoAnimal = rs.getString("tipoAnimal");
                String racaAnimal = rs.getString("racaAnimal");
                String cor = rs.getString("cor");
                String local = rs.getString("local");
                String idade = rs.getString("idade");
                String castrado = rs.getString("castrado");
                model.addRow(new Object[]{nomeAnimal, tipoAnimal, racaAnimal, cor, local, idade, castrado});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return model;
    }
   private void carregarAnimaisAdocao() throws SQLException {
       buscarAnimalAdocao();
   }
    
    
    

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaAdocao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaAdocao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaAdocao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaAdocao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new TelaAdocao().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(TelaAdocao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

    private void setTittle(String adoção_de_Pets) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
