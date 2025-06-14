/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectofinal;

import java.io.Serializable;

/**
 *
 * @author vivi-barrios
 */
public class Direcciones implements Serializable {
    private String Calle;
    private String Avenida;
    private String DireCompleta;
    private String Zona;

    /**
     * @return the Calle
     */
    public String getCalle() {
        return Calle;
    }

    /**
     * @param Calle the Calle to set
     */
    public void setCalle(String Calle) {
        this.Calle = Calle;
    }

    /**
     * @return the Avenida
     */
    public String getAvenida() {
        return Avenida;
    }

    /**
     * @param Avenida the Avenida to set
     */
    public void setAvenida(String Avenida) {
        this.Avenida = Avenida;
    }

    /**
     * @return the DireCompleta
     */
    public String getDireCompleta() {
        return DireCompleta;
    }

    /**
     * @param DireCompleta the DireCompleta to set
     */
    public void setDireCompleta(String DireCompleta) {
        this.DireCompleta = DireCompleta;
    }

    /**
     * @return the Zona
     */
    public String getZona() {
        return Zona;
    }

    /**
     * @param Zona the Zona to set
     */
    public void setZona(String Zona) {
        this.Zona = Zona;
    }
            
    
}
