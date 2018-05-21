/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp4.simulacion.fx.Class;

import java.util.HashSet;
import java.util.Random;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

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
    private int mostrarDesde;
    private int mostrarHasta;
    
    private Evento demanda;
    private Evento demora;
    private Evento biciDañada;
    
    private ObservableList<VectorEstadoView> estados;
    
    
    public Simulador(Evento demanda, Evento demora, Evento biciDañada, int desde, int hasta){
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
        this.vectorEstadoActual.setOrden(-1);
        this.vectorEstadoActual.setLlegadaPedido(-1);
        this.estados = FXCollections.observableArrayList();
        this.mostrarDesde = desde;
        this.mostrarHasta = hasta;
        
        
    }
    
    public Simulador(Evento demanda, Evento demora, Evento biciDañada, int desde, int hasta, double kmu, double ksu, double ko, int so, int q, int r){
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
        this.vectorEstadoActual.setOrden(-1);
        this.vectorEstadoActual.setLlegadaPedido(-1);
        this.mostrarDesde = desde;
        this.mostrarHasta = hasta;
        this.estados = FXCollections.observableArrayList();


    }
    
    public void simular(){
        
        this.reloj = this.vectorEstadoActual.getReloj() + 1; //nueva posicion del reloj
        
        
        
        
        int stock = this.vectorEstadoActual.getStock(); 
        int orden = this.vectorEstadoActual.getOrden();
        int llegadaPedido = this.vectorEstadoActual.getLlegadaPedido();
        
        
        if (llegadaPedido == this.reloj) {
            stock += q - this.vectorEstadoActual.getBiciDañada();
            llegadaPedido = -1;
            orden = -1;
        }
        
        
        Random generador = new Random();
        
        double rndDemanda = Math.round(generador.nextDouble()*100.0) / 100.0;
        if (rndDemanda == 1) { rndDemanda = 0.99;}
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
        
        int demora = -1, biciDañada = 0;
        double rndDemora = -1, rndBiciDañada = -1;
        
        if (stock <= r && orden == -1) {
            rndDemora = Math.round(generador.nextDouble() * 100.0) / 100.0;
            if (rndDemora == 1) { rndDemora = 0.99;}
            demora = this.demora.getResultado(rndDemora);
            rndBiciDañada = Math.round(generador.nextDouble()*100.0)/100.0;
            if (rndBiciDañada == 1) { rndBiciDañada = 0.99;}
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
        
        ko = Math.round(ko*100.0)/100.0;
        ks = Math.round(ks*100.0)/100.0;
        km = Math.round(km*100.0)/100.0;
        
        
        ct = Math.round(ct*100.0) / 100.0;
        
        double cta = this.vectorEstadoActual.getCta() + ct;
        cta = Math.round(cta * 100.0) /100.0;
        
        int bda = this.vectorEstadoActual.getBda() + biciDañada;
        
        this.vectorEstadoAnterior = this.vectorEstadoActual;
        this.vectorEstadoActual = new VectorEstado(reloj, rndDemanda, demanda, rndDemora, demora, rndBiciDañada, biciDañada, orden, llegadaPedido, stock, ko, km, ks, ct, cta, bda);
        
        if (this.reloj >= this.mostrarDesde && this.reloj <= this.mostrarHasta) {
            VectorEstadoView v = new VectorEstadoView(this.vectorEstadoActual);
            this.estados.add(v);
        }
        
        
        
    }
    
    public double costoPromedio(){
        double cta = this.vectorEstadoActual.getCta();
        double promedio = cta / (double) this.reloj;
        promedio = Math.round(promedio*100.0) /100.0;
        return promedio;
    }
    
    public int cantidadBicisDañadas(){
        return this.vectorEstadoActual.getBda();
    }
    
    public ObservableList<VectorEstadoView> estadosDeseados(){
        return this.estados;
    }
    
}
