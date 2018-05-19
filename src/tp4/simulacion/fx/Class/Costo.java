/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP4.Simulacion.Clases;

/**
 *
 * @author aleex
 */
public class Costo {
    private String nombre;
    private int precioCosto;

    public String getNombre() {
        return nombre;
    }

    public int getPrecioCosto() {
        return precioCosto;
    }

    public Costo(String nombre, int precioCosto) {
        this.nombre = nombre;
        this.precioCosto = precioCosto;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecioCosto(int precioCosto) {
        this.precioCosto = precioCosto;
    }
}
