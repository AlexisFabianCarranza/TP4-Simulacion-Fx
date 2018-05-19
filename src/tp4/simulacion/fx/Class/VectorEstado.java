/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp4.simulacion.fx.Class;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import javafx.beans.property.*;

/**
 *
 * @author nicolastomassi
 */
public class VectorEstado {

    private SimpleIntegerProperty reloj; //reloj de simulacion
    private SimpleDoubleProperty rndDemanda; //rnd para generar demanda
    private SimpleIntegerProperty demanda; // demanda generada
    private SimpleDoubleProperty rndDemora; //rnd para generar tiempo de demora de un pedido
    private SimpleIntegerProperty demora; // tiempo de demora de un pedido
    private SimpleDoubleProperty rndBiciDañada; // rnd para saber si viene una bici dañada en el pedido
    private SimpleIntegerProperty biciDañada; // viene o no bici dañaada en pedido
    private SimpleIntegerProperty orden; // tiempo en que se genero un pedido
    private SimpleIntegerProperty llegadaPedido; // tiempo en que llegará el pedido
    private SimpleIntegerProperty stock; // stock actual
    private SimpleDoubleProperty km; // costo de mantenimiento por bici
    private SimpleDoubleProperty ko; // costo de pedido
    private SimpleDoubleProperty ks; // costo de stock out
    private SimpleDoubleProperty kt; // costo total de una simulacion (ks+km+ko)
    private SimpleDoubleProperty kta; // costo total acumulado de todas las simulaciones
    private SimpleIntegerProperty bda; // acumulador de bicis dañadas
    private SimpleIntegerProperty so; // stock inicial
    private SimpleIntegerProperty q; // cantidad de bicis solicitadas en un pedido
    private SimpleIntegerProperty r; // punto de reposicion
    
    private Evento demandaEvento;
    private Evento demoraEvento;
    private Evento biciDañadaEvento;
    
    private VectorEstado estadoAnterior;
    
    
    
    public VectorEstado(){
        this.biciDañadaEvento = new Evento();
        this.demandaEvento = new Evento();
        this.demoraEvento = new Evento();
        this.reloj = new SimpleIntegerProperty(0);
        this.so = new SimpleIntegerProperty(7);
        this.q = new SimpleIntegerProperty(6);
        this.r = new SimpleIntegerProperty(2);
        this.km = new SimpleDoubleProperty(3);
        this.ks = new SimpleDoubleProperty(5);
        this.ko = new SimpleDoubleProperty(20);
        this.stock = new SimpleIntegerProperty(7);
    }
    
    public VectorEstado(VectorEstado viejo){
        this.biciDañadaEvento = viejo.biciDañadaEvento;
        this.demoraEvento = viejo.demoraEvento;
        this.demandaEvento = viejo.demandaEvento;
        this.q = viejo.getQ();
        this.r = viejo.getR();
        this.bda = viejo.getBda();
        this.km = viejo.getKm();
        this.ko = viejo.getKo();
        this.ks = 
        
    }
    
    public VectorEstado(int so, int q, int r, double km, double ks, double ko){
        
        this.biciDañadaEvento = new Evento();
        this.demandaEvento = new Evento();
        this.demoraEvento = new Evento();
        this.reloj = new SimpleIntegerProperty(0);
        this.so = new SimpleIntegerProperty(so);
        this.q = new SimpleIntegerProperty(q);
        this.r = new SimpleIntegerProperty(r);
        this.km = new SimpleDoubleProperty(km);
        this.ks = new SimpleDoubleProperty(ks);
        this.ko = new SimpleDoubleProperty(ko);
        this.stock = new SimpleIntegerProperty(so);
    }
    
    public void simular(){
        Random rnd = new Random();
        double random = rnd.nextDouble();
        
        this.setRndDemanda(random);
        this.setDemanda(this.demandaEvento.getResultado(random));
        
        
        if (this.demanda.get() < this.stock.get()) {
            
        }
        else {
            
        }
                
        
        
    }

    
        
    

    
    
    
    
    
    public Evento getDemandaEvento() {
        return demandaEvento;
    }

    public Evento getDemoraEvento() {
        return demoraEvento;
    }

    public Evento getBiciDañadaEvento() {
        return biciDañadaEvento;
    }

    public VectorEstado getEstadoAnterior() {
        return estadoAnterior;
    }
    
    public SimpleIntegerProperty getReloj() {
        return reloj;
    }

    public void setReloj(int reloj) {
        this.reloj = new SimpleIntegerProperty(reloj);
    }

    public SimpleDoubleProperty getRndDemanda() {
        return rndDemanda;
    }

    public void setRndDemanda(double rndDemanda) {
        this.rndDemanda = new SimpleDoubleProperty(rndDemanda);
    }

    public SimpleIntegerProperty getDemanda() {
        return demanda;
    }

    public void setDemanda(int demanda) {
        this.demanda = new SimpleIntegerProperty(demanda);
    }

    public SimpleDoubleProperty getRndDemora() {
        return rndDemora;
    }

    public void setRndDemora(double rndDemora) {
        this.rndDemora = new SimpleDoubleProperty(rndDemora);
    }

    public SimpleIntegerProperty getDemora() {
        return demora;
    }

    public void setDemora(int demora) {
        this.demora = new SimpleIntegerProperty(demora);
    }

    public SimpleDoubleProperty getRndBiciDañada() {
        return rndBiciDañada;
    }

    public void setRndBiciDañada(double rndBiciDañada) {
        this.rndBiciDañada = new SimpleDoubleProperty(rndBiciDañada);
    }

    public SimpleIntegerProperty getBiciDañada() {
        return biciDañada;
    }

    public void setBiciDañada(int biciDañada) {
        this.biciDañada = new SimpleIntegerProperty(biciDañada);
    }

    public SimpleIntegerProperty getOrden() {
        return orden;
    }

    public void setOrden(int orden) {
        this.orden = new SimpleIntegerProperty(orden);
    }

    public SimpleIntegerProperty getLlegadaPedido() {
        return llegadaPedido;
    }

    public void setLlegadaPedido(int llegadaPedido) {
        this.llegadaPedido = new SimpleIntegerProperty(llegadaPedido);
    }

    public SimpleIntegerProperty getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = new SimpleIntegerProperty(stock);
    }

    public SimpleDoubleProperty getKm() {
        return km;
    }

    public void setKm(SimpleDoubleProperty km) {
        this.km = km;
    }

    public SimpleDoubleProperty getKo() {
        return ko;
    }

    public void setKo(SimpleDoubleProperty ko) {
        this.ko = ko;
    }

    public SimpleDoubleProperty getKs() {
        return ks;
    }

    public void setKs(SimpleDoubleProperty ks) {
        this.ks = ks;
    }

    public SimpleDoubleProperty getKt() {
        return kt;
    }

    public void setKt(SimpleDoubleProperty kt) {
        this.kt = kt;
    }

    public SimpleDoubleProperty getKta() {
        return kta;
    }

    public void setKta(double kta) {
        this.kta = new SimpleDoubleProperty(kta);
    }

    public SimpleIntegerProperty getBda() {
        return bda;
    }

    public void setBda(int bda) {
        this.bda = new SimpleIntegerProperty(bda);
    }

    public SimpleIntegerProperty getSo() {
        return so;
    }

    public void setSo(int so) {
        this.so = new SimpleIntegerProperty(so);
    }

    public SimpleIntegerProperty getQ() {
        return q;
    }

    public void setQ(int q) {
        this.q = new SimpleIntegerProperty(q);
    }

    public SimpleIntegerProperty getR() {
        return r;
    }

    public void setR(int r) {
        this.r = new SimpleIntegerProperty(r);
    }
    
    
    
}
