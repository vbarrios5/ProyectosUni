/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.proyectofinal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author vivi-barrios
 */
public class CrearVentasStock extends javax.swing.JFrame {

    /**
     * Creates new form CrearVentasStock
     */
    public CrearVentasStock() {
        initComponents();
        setLocationRelativeTo(this);
        CargarLibros();
        datos();
        CargarTabla();

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String fechaActual = sdf.format(new Date());
        fecha.setText(fechaActual);

        tit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                datos();
            }
        });
    }

    private void CargarLibros() {
        tit.removeAllItems();

        for (L_VENTAS libro : ProyectoFinal.librosVentas) {
            tit.addItem(libro.getTitulo());
        }
        for (CUPONES cupon : ProyectoFinal.cupones) {
            cupones.addItem(cupon.getDescuento() + cupon.getTipoDescuento());
        }
        datos();
    }

    private void datos() {
        String TitSelec = (String) tit.getSelectedItem();
        for (L_VENTAS libro : ProyectoFinal.librosVentas) {
            if (libro.getTitulo().equals(TitSelec)) {
                precios.setText(String.valueOf(libro.getPrecio()));
                break;
            }
        }

    }

    private void Limpiar() {
        cant.setText("");
    }

    public static void actualizarArchivoInventario() {
        try (PrintWriter pw = new PrintWriter("Inventario.txt")) {
            for (L_VENTAS libro : ProyectoFinal.librosVentas) {
                pw.println(libro.getTitulo() + "|" + libro.getCantidad() + "|" + libro.getPrecio());
            }
        } catch (Exception e) {
            System.out.println("Error al guardar inventario: " + e.getMessage());
        }
    }

    private void CargarTabla() {

        String[] Encabezado = {"TITULO", "CANTIDAD", " PRODUCTO SIN IVA", "SUB-TOTAL"};
        DefaultTableModel t = new DefaultTableModel(Encabezado, ProyectoFinal.CrearVentas.size());
        jTable1.setModel(t);
        TableModel tabla = jTable1.getModel();
        double totalFactura = 0.00;
        double totalsinIva = 0.00;

        for (int i = 0; i < ProyectoFinal.CrearVentas.size(); i++) {
            L_VENTAS l = ProyectoFinal.CrearVentas.get(i);
            tabla.setValueAt(l.getTitulo(), i, 0);
            tabla.setValueAt(l.getCantidad(), i, 1);

            double cant = Integer.parseInt(l.getCantidad());
            double Iva1 = l.getPrecio() / 1.12;
            double Iva = Iva1 * cant;
            double IvaAprox = Math.round(Iva * 100.0) / 100.0;
            tabla.setValueAt(IvaAprox, i, 2);

            double subtotal = cant * l.getPrecio();
            double subtotalFinal = subtotal;

            tabla.setValueAt(String.format("%.2f", subtotalFinal), i, 3);

            totalFactura += subtotalFinal;
            totalsinIva += IvaAprox;

        }

        String seleccionado = (String) cupones.getSelectedItem();
        double descuento = 0;
        boolean esPorcentaje = false;

        if (seleccionado != null && !seleccionado.isEmpty()) {
            if (seleccionado.endsWith("%")) {
                descuento = Double.parseDouble(seleccionado.replace("%", ""));
                esPorcentaje = true;
            } else if (seleccionado.endsWith("Q")) {
                descuento = Double.parseDouble(seleccionado.replace("Q", ""));
            }
        }

        double totalConDescuento = totalFactura;

        if (esPorcentaje) {
            totalConDescuento = totalFactura - (totalFactura * descuento / 100.0);
        } else {
            totalConDescuento = totalFactura - descuento;
            if (totalConDescuento < 0) {
                totalConDescuento = 0;
            }
        }
        totalVentas.setText(String.format("%.2f", totalFactura));
        totalVentas1.setText(String.format("%.2f", totalConDescuento));
        TotalIva.setText(String.format("%.2f", totalsinIva));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        SALIR = new javax.swing.JButton();
        precios = new javax.swing.JTextField();
        cant = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        AGREGARVENTAS = new javax.swing.JButton();
        tit = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        VALIDAR_VENTA = new javax.swing.JButton();
        NIT = new javax.swing.JLabel();
        direccion = new javax.swing.JTextField();
        nit = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        fecha = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        nom = new javax.swing.JTextField();
        totalVentas = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        LIMPIAR = new javax.swing.JButton();
        TotalIva = new javax.swing.JTextField();
        total = new javax.swing.JLabel();
        cupones = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        totalVentas1 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Liberation Sans", 0, 36)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("REGISTRAR VENTAS");

        SALIR.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        SALIR.setText("SALIR");
        SALIR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SALIRActionPerformed(evt);
            }
        });

        precios.setEditable(false);
        precios.setBackground(new java.awt.Color(255, 255, 255));
        precios.setFont(new java.awt.Font("Liberation Sans", 0, 16)); // NOI18N

        cant.setFont(new java.awt.Font("Liberation Sans", 0, 16)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("TITULO:");

        jLabel6.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("PRECIO:");

        jLabel7.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("CANTIDAD:");

        AGREGARVENTAS.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        AGREGARVENTAS.setText("AGREGAR");
        AGREGARVENTAS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AGREGARVENTASActionPerformed(evt);
            }
        });

        tit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

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

        VALIDAR_VENTA.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        VALIDAR_VENTA.setText("VALIDAR VENTA");
        VALIDAR_VENTA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VALIDAR_VENTAActionPerformed(evt);
            }
        });

        NIT.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        NIT.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        NIT.setText("NIT:");

        direccion.setFont(new java.awt.Font("Liberation Sans", 0, 16)); // NOI18N

        nit.setFont(new java.awt.Font("Liberation Sans", 0, 16)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("FECHA:");

        fecha.setEditable(false);
        fecha.setBackground(new java.awt.Color(255, 255, 255));
        fecha.setFont(new java.awt.Font("Liberation Sans", 0, 16)); // NOI18N

        jLabel12.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("DIRECCION:");

        jLabel13.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13.setText("NOMBRE:");

        nom.setFont(new java.awt.Font("Liberation Sans", 0, 16)); // NOI18N

        totalVentas.setEditable(false);
        totalVentas.setBackground(new java.awt.Color(255, 255, 255));

        jLabel8.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("TOTAL SIN DESCUENTO:");

        LIMPIAR.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        LIMPIAR.setText("LIMPIAR");
        LIMPIAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LIMPIARActionPerformed(evt);
            }
        });

        TotalIva.setEditable(false);
        TotalIva.setBackground(new java.awt.Color(255, 255, 255));

        total.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        total.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        total.setText("TOTAL SIN IVA:");

        cupones.setFont(new java.awt.Font("Liberation Sans", 0, 15)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("DESCUENTO:");

        totalVentas1.setEditable(false);
        totalVentas1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel11.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("TOTAL CON DESCUENTO:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 698, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(LIMPIAR, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(VALIDAR_VENTA)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(SALIR)
                        .addGap(39, 39, 39))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tit, 0, 220, Short.MAX_VALUE)
                            .addComponent(cant, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(precios, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fecha))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nom, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59)
                        .addComponent(NIT)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nit))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(direccion)))
                .addGap(27, 27, 27))
            .addGroup(layout.createSequentialGroup()
                .addGap(326, 326, 326)
                .addComponent(AGREGARVENTAS, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addComponent(cupones, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 226, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TotalIva, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(464, 464, 464)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(totalVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(440, 440, 440)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(totalVentas1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NIT)
                    .addComponent(nom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(direccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(precios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(cant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(AGREGARVENTAS)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TotalIva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(total)
                    .addComponent(cupones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(totalVentas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(totalVentas1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SALIR)
                    .addComponent(VALIDAR_VENTA)
                    .addComponent(LIMPIAR))
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SALIRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SALIRActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_SALIRActionPerformed

    private void AGREGARVENTASActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AGREGARVENTASActionPerformed
        // TODO add your handling code here:
        try {
            String tituloSeleccionado = (String) tit.getSelectedItem();
            int cantidadVendida = Integer.parseInt(cant.getText());

            boolean libroEncontrado = false;

            for (L_VENTAS libro : ProyectoFinal.librosVentas) {
                if (libro.getTitulo().equals(tituloSeleccionado)) {
                    libroEncontrado = true;
                    int stockCantidad = Integer.parseInt(libro.getCantidad());

                    if (stockCantidad >= cantidadVendida) {
                        libro.setCantidad(String.valueOf(stockCantidad - cantidadVendida));

                        actualizarArchivoInventario();
                    } else {
                        JOptionPane.showMessageDialog(this, "Stock insuficiente. Solo hay " + stockCantidad + " unidades.");
                        return; 
                    }
                }
            }

            if (!libroEncontrado) {
                JOptionPane.showMessageDialog(this, "Libro no encontrado en el inventario.");
                return;
            }

            L_VENTAS v = new L_VENTAS();
            v.setVendedor(ProyectoFinal.nombreVendedor);
            v.setNombre(nom.getText());
            v.setNIT(nit.getText());
            v.setDireccion(direccion.getText());
            v.setFecha(java.time.LocalDate.now().toString());
            v.setTitulo((String) tit.getSelectedItem());
            v.setCantidad(cant.getText());
            v.setDescuent(cupones.getSelectedItem().toString());
            v.setPrecio(Double.parseDouble(precios.getText()));
            v.setIVA(TotalIva.getText());
            v.setTotal(totalVentas.getText());
            v.setTotalSinDesc(totalVentas1.getText());

            ProyectoFinal.CrearVentas.add(v);
            ProyectoFinal.guardarDatos(); 
            Limpiar();
            CargarTabla();

            JOptionPane.showMessageDialog(this, "Venta agregada");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Por favor ingrese todos los campos");
        }


    }//GEN-LAST:event_AGREGARVENTASActionPerformed

    private void VALIDAR_VENTAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VALIDAR_VENTAActionPerformed
        // TODO add your handling code here:
        try {

            L_VENTAS v = new L_VENTAS();
            v.setVendedor(ProyectoFinal.nombreVendedor);
            v.setNombre(nom.getText());
            v.setNIT(nit.getText());
            v.setDireccion(direccion.getText());
            v.setFecha(java.time.LocalDate.now().toString());
            v.setDescuent(cupones.getSelectedItem().toString());
            v.setTitulo("Compra de Libros");
            v.setVentasDet(tit.getSelectedItem().toString());
            v.setIVA(TotalIva.getText());
            v.setTotal(totalVentas.getText());
            v.setCantidad(cant.getText());
            v.setPrecio(Double.parseDouble(precios.getText()));
            v.setTotalSinDesc(totalVentas1.getText());

            ProyectoFinal.CrearVentasAdmin.add(v);
            ProyectoFinal.guardarDatos(); 
            JOptionPane.showMessageDialog(this, "GRACIAS POR VALIDAR "
                    + "SU VENTA");

        } catch (Exception e) {

        }

        for (int i = 0; i < jTable1.getRowCount(); i++) {
            L_VENTAS detalle = new L_VENTAS();
            detalle.setVendedor(ProyectoFinal.nombreVendedor);
            detalle.setNombre(nom.getText());
            detalle.setNIT(nit.getText());
            detalle.setDireccion(direccion.getText());
            detalle.setFecha(java.time.LocalDate.now().toString());
            detalle.setDescuent(cupones.getSelectedItem().toString());
            detalle.setIVA(TotalIva.getText());
            detalle.setTotal(totalVentas.getText());
            detalle.setTotalSinDesc(totalVentas1.getText());

            String tituloFila = jTable1.getValueAt(i, 0).toString(); 
            detalle.setVentasDet(tituloFila);
            detalle.setCantidad(jTable1.getValueAt(i, 1).toString());

            
            for (L_VENTAS libro : ProyectoFinal.librosVentas) {
                if (libro.getTitulo().equals(tituloFila)) {
                    detalle.setPrecio(libro.getPrecio());
                    break;
                }
            }

            ProyectoFinal.VentasDetalladas.add(detalle);
            ProyectoFinal.guardarDatos(); 
        }

    }//GEN-LAST:event_VALIDAR_VENTAActionPerformed

    private void LIMPIARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LIMPIARActionPerformed
        // TODO add your handling code here:
        ProyectoFinal.CrearVentas.clear();
        nom.setText("");
        nit.setText("");
        direccion.setText("");
        fecha.setText("");
        cant.setText("");
        precios.setText("");
        totalVentas.setText("");
        TotalIva.setText("");
        String[] Encabezado = {"TITULO", "CANTIDAD", "SUB-TOTAL"};
        DefaultTableModel t = new DefaultTableModel(Encabezado, 0);
        jTable1.setModel(t);
    }//GEN-LAST:event_LIMPIARActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AGREGARVENTAS;
    private javax.swing.JButton LIMPIAR;
    private javax.swing.JLabel NIT;
    private javax.swing.JButton SALIR;
    private javax.swing.JTextField TotalIva;
    private javax.swing.JButton VALIDAR_VENTA;
    private javax.swing.JTextField cant;
    private javax.swing.JComboBox<String> cupones;
    private javax.swing.JTextField direccion;
    private javax.swing.JTextField fecha;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField nit;
    private javax.swing.JTextField nom;
    private javax.swing.JTextField precios;
    private javax.swing.JComboBox<String> tit;
    private javax.swing.JLabel total;
    private javax.swing.JTextField totalVentas;
    private javax.swing.JTextField totalVentas1;
    // End of variables declaration//GEN-END:variables
}
