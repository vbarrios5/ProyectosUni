/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.proyectofinal;


import java.util.ArrayList;


/**
 *
 * @author vivi-barrios
 */

public class ProyectoFinal {
    // <> referencia diamante
    public static ArrayList <USUARIO> usuario = new ArrayList <> (); 
    public static USUARIO usuarios;
    public static String nombreVendedor;
    public static ArrayList <LIBROS > libros = new ArrayList <> ();
    public static ArrayList <CUPONES > cupones = new ArrayList <> ();
    public static ArrayList <TELEFONO> telefonos = new ArrayList<>(); 
    public static ArrayList <L_VENTAS> librosVentas = new ArrayList<>(); 
    public static ArrayList <L_VENTAS> CrearVentas = new ArrayList<>(); 
    public static ArrayList <L_VENTAS> CrearVentasAdmin = new ArrayList<>(); 
    public static ArrayList <Direcciones> direccion = new ArrayList<>(); 
    
    
    
    public static void main(String[] args) {
        
        LOGIN inicio = new LOGIN();
        inicio.setVisible(true);
                
    }
    
}


