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
public class VectorEstadoView {

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
    
    
    public VectorEstadoView(){
    }
    
    public VectorEstadoView(VectorEstado v){
        
        this.reloj = new SimpleIntegerProperty(v.getReloj());
        this.rndDemanda = new SimpleDoubleProperty(v.getRndDemanda());
        this.demanda = new SimpleIntegerProperty(v.getDemanda());
        this.rndDemora = new SimpleDoubleProperty(v.getRndDemora());
        this.demora = new SimpleIntegerProperty(v.getDemora());
        this.rndBiciDañada = new SimpleDoubleProperty(v.getRndBiciDañada());
        this.biciDañada = new SimpleIntegerProperty(v.getBiciDañada());
        this.orden = new SimpleIntegerProperty(v.getOrden());
        this.llegadaPedido = new SimpleIntegerProperty(v.getLlegadaPedido());
        this.stock = new SimpleIntegerProperty(v.getStock());
        this.km = new SimpleDoubleProperty(v.getKm());
        this.ks = new SimpleDoubleProperty(v.getKs());
        this.ko = new SimpleDoubleProperty(v.getKo());
        this.kt = new SimpleDoubleProperty(v.getCt());
        this.kta = new SimpleDoubleProperty(v.getCta());
        this.bda = new SimpleIntegerProperty(v.getBda());
    }

    public Integer getReloj() {
        return reloj.get();
    }

    public void setReloj(SimpleIntegerProperty reloj) {
        this.reloj = reloj;
    }

    public double getRndDemanda() {
        return rndDemanda.get();
    }

    public void setRndDemanda(SimpleDoubleProperty rndDemanda) {
        this.rndDemanda = rndDemanda;
    }

    public int getDemanda() {
        return demanda.get();
    }

    public void setDemanda(SimpleIntegerProperty demanda) {
        this.demanda = demanda;
    }

    public String getRndDemora() {
        if (this.rndDemora.get() == -1) {
            return "";
        }
        return String.valueOf(rndDemora.get());
    }
//    public double getRndDemora() {
//        return rndDemora.get();
//    }

    public void setRndDemora(SimpleDoubleProperty rndDemora) {
        this.rndDemora = rndDemora;
    }

    public String getDemora() {
        if (this.demora.get() == -1) {
            return "";
        }
        return String.valueOf(demora.get());
    }
//    public int getDemora() {
//        return demora.get();
//    }

    public void setDemora(SimpleIntegerProperty demora) {
        this.demora = demora;
    }

    public String getRndBiciDañada() {
        if (this.rndBiciDañada.get() == -1) {
            return "";
        }
        return String.valueOf(rndBiciDañada.get());
    }
//    public double getRndBiciDañada() {
//        return rndBiciDañada.get();
//    }

    public void setRndBiciDañada(SimpleDoubleProperty rndBiciDañada) {
        this.rndBiciDañada = rndBiciDañada;
    }

    public String getBiciDañada() {
        if (this.rndBiciDañada.get() == -1) {
            return "";
        }
        return String.valueOf(biciDañada.get());
    }
//    public int getBiciDañada() {
//        return biciDañada.get();
//    }

    public void setBiciDañada(SimpleIntegerProperty biciDañada) {
        this.biciDañada = biciDañada;
    }

    public String getOrden() {
        if (this.orden.get() == -1) {
            return "";
        }
        
        return String.valueOf(orden.get());
    }
//    public int getOrden() {
//        return orden.get();
//    }

    public void setOrden(SimpleIntegerProperty orden) {
        this.orden = orden;
    }

    public String getLlegadaPedido() {
        if (this.llegadaPedido.get() == -1) {
            return "";
        }
        
        return String.valueOf(llegadaPedido.get());
    }
//    public int getLlegadaPedido() {
//        return llegadaPedido.get();
//    }

    public void setLlegadaPedido(SimpleIntegerProperty llegadaPedido) {
        this.llegadaPedido = llegadaPedido;
    }

    public int getStock() {
        return stock.get();
    }

    public void setStock(SimpleIntegerProperty stock) {
        this.stock = stock;
    }

    public double getKm() {
        return km.get();
    }

    public void setKm(SimpleDoubleProperty km) {
        this.km = km;
    }

    public double getKo() {
        return ko.get();
    }

    public void setKo(SimpleDoubleProperty ko) {
        this.ko = ko;
    }

    public double getKs() {
        return ks.get();
    }

    public void setKs(SimpleDoubleProperty ks) {
        this.ks = ks;
    }

    public double getKt() {
        return kt.get();
    }

    public void setKt(SimpleDoubleProperty kt) {
        this.kt = kt;
    }

    public double getKta() {
        return kta.get();
    }

    public void setKta(SimpleDoubleProperty kta) {
        this.kta = kta;
    }

    public int getBda() {
        return bda.get();
    }

    public void setBda(SimpleIntegerProperty bda) {
        this.bda = bda;
    }
    
    
    
    
}
    
    