/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp4.simulacion.fx.Class;

/**
 *
 * @author nicolastomassi
 */
public class Simulador {
    
    private VectorEstadoCalculo vectorEstadoActual;
    private VectorEstadoCalculo vectorEstadoAnterior;
    private double kmu; //costom mantenimiento por unidad 
    private double ko; //costo de pedido
    private double ksu; //costo de stock out por unidad
    private int so; //stock inicial
    private int q;
    private int r;
    
    private Evento demanda;
    private Evento demora;
    private Evento biciDañada;
    
    
    public Simulador(){
        this.vectorEstadoActual = new VectorEstadoCalculo();
    }
    
    
    
    
    
}
