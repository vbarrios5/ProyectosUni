/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.proyectofinal;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;


/**
 *
 * @author vivi-barrios
 */
public class Crear_Usuario extends javax.swing.JFrame {

    /**
     * Creates new form Crear_Usuario
     */
    public Crear_Usuario() {
        initComponents();
        setLocationRelativeTo(this);
        
        roles.removeAllItems();
        roles.addItem("Administrador");
        roles.addItem("Vendedor");
        
    }

    private void Limpiar (){
        nombres.setText("");
        usua.setText("");
        password.setText("");
    }
    
    private boolean ValidarDatos(){
        USUARIO u = new USUARIO ();
        u.setNombre(nombres.getText());
        if (!u.getNombre().matches("(.*[A-Z])[a-zA-Z\\s]+")){ 
            JOptionPane.showMessageDialog(this, "El nombre no puede contener numeros \n"
                    + "El nombre debe iniciar con Mayuscula");
            return false;
        }
        
        u.setUsuario(usua.getText());
        if (!u.getUsuario().matches("(.*[A-Z])[a-zA-Z]+")){
            JOptionPane.showMessageDialog(this, "El Usuario debe contener una letra Mayuscula \n"
                    + "El usuario no puede llevar espacios");
            return false;
        }
        
        u.setPassword(password.getText());
        if (!u.getPassword().matches("(?=.*[A-Z])(?=.*[a-z])(?=.*\\d).{6,10}")){
            JOptionPane.showMessageDialog(this, "La contraseña debe contener: \n"
                    + "Entre 6-10 caracteres \n"
                    + "Al menos una letra Mayuscula \n"
                    + "Al menos una letra Minuscula \n"
                    + "Al menos un numero");
            return false;
        }   
        
        return true;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        password = new javax.swing.JTextField();
        nombres = new javax.swing.JTextField();
        usua = new javax.swing.JTextField();
        guardar = new javax.swing.JButton();
        salir = new javax.swing.JButton();
        roles = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Liberation Sans", 0, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("NUEVO USUARIO");

        jLabel2.setText("NOMBRE:");

        jLabel3.setText("USUARIO:");

        jLabel4.setText("ROL:");

        jLabel5.setText("PASSWORD:");

        guardar.setText("GUARDAR");
        guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarActionPerformed(evt);
            }
        });

        salir.setText("REGRESAR");
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });

        roles.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrador", "Vendedor", "" }));
        roles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rolesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(189, 189, 189)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(password)
                                    .addComponent(nombres)
                                    .addComponent(usua)
                                    .addComponent(roles, 0, 223, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(jLabel1))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(230, 230, 230)
                        .addComponent(guardar)
                        .addGap(37, 37, 37)
                        .addComponent(salir)))
                .addContainerGap(216, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addComponent(jLabel1)
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(nombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(usua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(roles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(guardar)
                    .addComponent(salir))
                .addContainerGap(122, Short.MAX_VALUE))
        );

        roles.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarActionPerformed
        // TODO add your handling code here:
        if (ValidarDatos()){
            try{
            
        USUARIO u = new USUARIO ();
        u.setNombre(nombres.getText());
        u.setUsuario(usua.getText());
        u.setRol((String)roles.getSelectedItem()); 
        u.setPassword(password.getText());
        
        ProyectoFinal.usuario.add(u);  
        ProyectoFinal.guardarDatos(); 
        
        try (BufferedWriter bw = new BufferedWriter (new FileWriter("Usuario.txt", true))){
                bw.write(u.getNombre() + "," + u.getUsuario() + "," + u.getRol() + "," + u.getPassword());
                bw.newLine();
                
        }catch (IOException e){
            e.printStackTrace();
        }
        JOptionPane.showMessageDialog(this, "Usuario creado exitosamente");
        Limpiar();
        }catch (Exception e){
            JOptionPane.showMessageDialog(this, "LLENE TODOS LOS CAMPOS");
        }
        }
    }//GEN-LAST:event_guardarActionPerformed

    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_salirActionPerformed

    private void rolesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rolesActionPerformed
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_rolesActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton guardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField nombres;
    private javax.swing.JTextField password;
    private javax.swing.JComboBox<String> roles;
    private javax.swing.JButton salir;
    private javax.swing.JTextField usua;
    // End of variables declaration//GEN-END:variables
}
