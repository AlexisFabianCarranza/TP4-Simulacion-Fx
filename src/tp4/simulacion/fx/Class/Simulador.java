/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp4.simulacion.fx.Class;

import java.util.Random;

/**
 *
 * @author nicolastomassi
 */
public class Simulador {
    
    private int reloj = 0;
    private VectorEstado vectorEstadoActual;
    private VectorEstado vectorEstadoAnterior;
    private double kmu; //costom mantenimiento por unidad 
    private double ko; //costo de pedido
    private double ksu; //costo de stock out por unidad
    private int so; //stock inicial
    private int q;
    private int r;
    
    private Evento demanda;
    private Evento demora;
    private Evento biciDañada;
    
    
    public Simulador(Evento demanda, Evento demora, Evento biciDañada){
        this.vectorEstadoActual = new VectorEstado();
        this.vectorEstadoAnterior = new VectorEstado();
        this.kmu = 3;
        this.ko = 20;
        this.ksu = 5;
        this.so = 7;
        this.q = 6;
        this.r = 2;
        this.demanda = demanda;
        this.demora = demora;
        this.biciDañada = biciDañada;
        this.vectorEstadoActual.setReloj(reloj);
        this.vectorEstadoActual.setStock(this.so);
        this.vectorEstadoActual.setCta(0);
    }
    
    public Simulador(double kmu, double ksu, double ko, int so, int q, int r){
        this.vectorEstadoActual = new VectorEstado();
        this.vectorEstadoAnterior = new VectorEstado();
        this.kmu = kmu;
        this.ko = ko;
        this.ksu = ksu;
        this.so = so;
        this.q = q;
        this.r = r;
        this.demanda = demanda;
        this.demora = demora;
        this.biciDañada = biciDañada;
        this.vectorEstadoActual.setReloj(reloj);
        this.vectorEstadoActual.setStock(so);
        this.vectorEstadoActual.setCta(0);
    }
    
    public void simular(){
        
        this.reloj = this.vectorEstadoActual.getReloj() + 1; //nueva posicion del reloj
        int stock = this.vectorEstadoActual.getStock(); 
        
        
        
        if (this.vectorEstadoActual.getLlegadaPedido() == this.reloj) {
            stock += q - this.vectorEstadoActual.getBiciDañada();
        }
        
        
        Random generador = new Random();
        
        double rndDemanda = Math.round(generador.nextDouble()*100.0) / 100.0;
        int demanda = this.demanda.getResultado(rndDemanda); // genera demanda
        
        
        double km, ks = 0, ko = 0, ct;
        
        
        if (demanda <= stock) {
            stock = stock - demanda;
        }
        else {
            ks = (demanda-stock) * ksu;
            stock = 0;
        }
        
        km = stock * this.kmu;
        
        int demora = -1, biciDañada = 0, orden = -1, llegadaPedido = -1;
        double rndDemora = -1, rndBiciDañada = -1;
        
        if (stock <= r) {
            rndDemora = Math.round(generador.nextDouble() * 100.0) / 100.0;
            demora = this.demora.getResultado(rndDemora);
            rndBiciDañada = Math.round(generador.nextDouble()*100.0)/100.0;
            biciDañada = this.biciDañada.getResultado(rndBiciDañada);
            orden = reloj;
            llegadaPedido = reloj + demora;
            if (biciDañada == 1) {
                ko = this.ko - (this.ko * (1) / q); 
            }
            else {
                ko = this.ko;
            }
        }
        
        ct = ks + km + ko;
        
        double cta = this.vectorEstadoActual.getCta() + ct;
        int bda = this.vectorEstadoActual.getBda() + biciDañada;
        
        this.vectorEstadoAnterior = this.vectorEstadoActual;
        this.vectorEstadoActual = new VectorEstado(reloj, rndDemanda, demanda, rndDemora, demora, rndBiciDañada, biciDañada, orden, llegadaPedido, stock, ko, km, ks, ct, cta, bda);
            
        System.out.println(this.vectorEstadoActual.toString());
        
        
    }
    
    public double costoPromedio(){
        double cta = this.vectorEstadoActual.getCta();
        return (cta/ (double) this.reloj);
    }
    
    public int cantidadBicisDañadas(){
        return this.vectorEstadoActual.getBda();
    }
    
    
    
}
