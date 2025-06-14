/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.proyectofinal;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author vivi-barrios
 */
public class ProyectoFinal {

    public static ArrayList<USUARIO> usuario = new ArrayList<>();
    public static USUARIO usuarios;
    public static String nombreVendedor;
    public static ArrayList<CUPONES> cupones = new ArrayList<>();
    public static ArrayList<TELEFONO> telefonos = new ArrayList<>();
    public static ArrayList<L_VENTAS> librosVentas = new ArrayList<>();
    public static ArrayList<L_VENTAS> CrearVentas = new ArrayList<>();
    public static ArrayList<L_VENTAS> CrearVentasAdmin = new ArrayList<>();
    public static ArrayList<L_VENTAS> VentasDetalladas = new ArrayList<>();
    public static ArrayList<Direcciones> direccion = new ArrayList<>();

    public static void main(String[] args) {

        LOGIN inicio = new LOGIN();
        inicio.setVisible(true);

        guardarObjeto(usuario, "usuarios.progra");
        guardarObjeto(cupones, "cupones.progra");
        guardarObjeto(telefonos, "telefonos.progra");
        guardarObjeto(librosVentas, "librosVentas.progra");
        guardarObjeto(CrearVentas, "crearVentas.progra");
        guardarObjeto(CrearVentasAdmin, "crearVentasAdmin.progra");
        guardarObjeto(VentasDetalladas, "ventasDetalladas.progra");
        guardarObjeto(direccion, "direcciones.progra");
        
        leerObjeto("usuarios.progra");
        leerObjeto("cupones.progra");
        leerObjeto("telefonos.progra");
        leerObjeto("librosVentas.progra");
        leerObjeto("crearVentas.progra");
        leerObjeto("crearVentasAdmin.progra");
        leerObjeto("ventasDetalladas.progra");
        leerObjeto("direcciones.progra");

    }

    public static void guardarDatos() {
        guardarObjeto(usuario, "usuarios.progra");
        guardarObjeto(cupones, "cupones.progra");
        guardarObjeto(telefonos, "telefonos.progra");
        guardarObjeto(librosVentas, "librosVentas.progra");
        guardarObjeto(CrearVentas, "crearVentas.progra");
        guardarObjeto(CrearVentasAdmin, "crearVentasAdmin.progra");
        guardarObjeto(VentasDetalladas, "ventasDetalladas.progra");
        guardarObjeto(direccion, "direcciones.progra");
    }

    public static void guardarObjeto(Object o, String ruta) {
        try {
            FileOutputStream archivo = new FileOutputStream(ruta);
            ObjectOutputStream escribe = new ObjectOutputStream(archivo);
            escribe.writeObject(o);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Object leerObjeto(String ruta) {
        try {
            FileInputStream archivo = new FileInputStream(ruta);
            ObjectInputStream leer = new ObjectInputStream(archivo);
            return leer.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
