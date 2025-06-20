/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.proyectofinal;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author vivi-barrios
 */
public class ConsultaVentas extends javax.swing.JFrame {

    /**
     * Creates new form ConsultaVentas
     */
    public ConsultaVentas() {
        initComponents();
        setLocationRelativeTo(this);
        Actualizar();

    }

    private void Actualizar() {

        String[] Encabezado = {"VENDEDOR", "NOMRBE CLIENTE", "NIT CLIENTE", "DIRECCION CLIENTE", "FECHA EMISION", "DESCRIPCION PRODUCTOS", "TOTAL SIN IVA", 
            "TOTAL SIN DESCUENTO" , "DESCUENTO", "TOTAL CON DESCUENTO"};
        DefaultTableModel t = new DefaultTableModel(Encabezado, ProyectoFinal.CrearVentasAdmin.size());
        jTable1.setModel(t);
        TableModel tabla = jTable1.getModel();

        for (int i = 0; i < ProyectoFinal.CrearVentasAdmin.size(); i++) {
            L_VENTAS l = ProyectoFinal.CrearVentasAdmin.get(i);
            tabla.setValueAt(l.getVendedor(), i, 0);
            tabla.setValueAt(l.getNombre(), i, 1);
            tabla.setValueAt(l.getNIT(), i, 2);
            tabla.setValueAt(l.getDireccion(), i, 3);
            tabla.setValueAt(l.getFecha(), i, 4);
            tabla.setValueAt(l.getTitulo(), i, 5);
            tabla.setValueAt(l.getIVA(), i, 6);
            tabla.setValueAt(l.getTotal(), i, 7);
            tabla.setValueAt(l.getDescuent(), i, 8);
            tabla.setValueAt(l.getTotalSinDesc(), i, 9);
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

        jLabel1 = new javax.swing.JLabel();
        SALIR = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        ventas_detalladas = new javax.swing.JButton();
        REPORTE_VENTAS = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Liberation Sans", 0, 36)); // NOI18N
        jLabel1.setText("CONSULTA VENTAS");

        SALIR.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        SALIR.setText("SALIR");
        SALIR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SALIRActionPerformed(evt);
            }
        });

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

        ventas_detalladas.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        ventas_detalladas.setText("VENTAS DETALLADAS");
        ventas_detalladas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ventas_detalladasActionPerformed(evt);
            }
        });

        REPORTE_VENTAS.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        REPORTE_VENTAS.setText("REPORTE VENTAS");
        REPORTE_VENTAS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                REPORTE_VENTASActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1021, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(REPORTE_VENTAS, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ventas_detalladas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SALIR)
                        .addGap(26, 26, 26))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(323, 323, 323))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(76, 76, 76)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SALIR)
                    .addComponent(ventas_detalladas)
                    .addComponent(REPORTE_VENTAS))
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SALIRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SALIRActionPerformed
        // TODO add your handling code here:
        this.dispose();

    }//GEN-LAST:event_SALIRActionPerformed

    private void ventas_detalladasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ventas_detalladasActionPerformed
        File file = new File("ReporteDetallado.csv");
        boolean archivoExiste = file.exists();

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))) {
            if (!archivoExiste) {
                bw.write("VENDEDOR, FECHA, TITULO, CANTIDAD, PRECIO");
                bw.newLine();
            }

            for (L_VENTAS li : ProyectoFinal.VentasDetalladas) {
                bw.write(
                        li.getVendedor() + ","
                        + li.getFecha() + ","
                        + li.getVentasDet() + ","
                        + li.getCantidad() + ","
                        + li.getPrecio()
                );
                bw.newLine();
            }

            JOptionPane.showMessageDialog(this, "¡Listo! Ya puede visualizar su reporte detallado");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al cargar los datos: " + e.getMessage());
        }


    }//GEN-LAST:event_ventas_detalladasActionPerformed

    private void REPORTE_VENTASActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_REPORTE_VENTASActionPerformed
        // TODO add your handling code here:
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("ReporteVentas.csv", true))) {
            bw.write("VENDEDRO, NOMBRE CLIENTE, NIT, DIRECCION, FECHA, DESCRIPCION, IVA, TOTAL, DESCUENTO APLICADO, TOTAL CON DESCUENTO");
            bw.newLine();
                
            for (L_VENTAS l : ProyectoFinal.CrearVentasAdmin) {
                bw.write(l.getVendedor() + "," + l.getNombre() + "," + l.getNIT() + "," + l.getDireccion() + "," + l.getFecha()
                        + "," + l.getTitulo() + "," + l.getIVA() + "," + l.getTotal() + "," + l.getDescuent() + "," + l.getTotalSinDesc());
                bw.newLine();
            }
            JOptionPane.showMessageDialog(this, "Ya puede abrir el archivo");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_REPORTE_VENTASActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton REPORTE_VENTAS;
    private javax.swing.JButton SALIR;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton ventas_detalladas;
    // End of variables declaration//GEN-END:variables
}
