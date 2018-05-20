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

    public SimpleIntegerProperty getReloj() {
        return reloj;
    }

    public void setReloj(SimpleIntegerProperty reloj) {
        this.reloj = reloj;
    }

    public SimpleDoubleProperty getRndDemanda() {
        return rndDemanda;
    }

    public void setRndDemanda(SimpleDoubleProperty rndDemanda) {
        this.rndDemanda = rndDemanda;
    }

    public SimpleIntegerProperty getDemanda() {
        return demanda;
    }

    public void setDemanda(SimpleIntegerProperty demanda) {
        this.demanda = demanda;
    }

    public SimpleDoubleProperty getRndDemora() {
        return rndDemora;
    }

    public void setRndDemora(SimpleDoubleProperty rndDemora) {
        this.rndDemora = rndDemora;
    }

    public SimpleIntegerProperty getDemora() {
        return demora;
    }

    public void setDemora(SimpleIntegerProperty demora) {
        this.demora = demora;
    }

    public SimpleDoubleProperty getRndBiciDañada() {
        return rndBiciDañada;
    }

    public void setRndBiciDañada(SimpleDoubleProperty rndBiciDañada) {
        this.rndBiciDañada = rndBiciDañada;
    }

    public SimpleIntegerProperty getBiciDañada() {
        return biciDañada;
    }

    public void setBiciDañada(SimpleIntegerProperty biciDañada) {
        this.biciDañada = biciDañada;
    }

    public SimpleIntegerProperty getOrden() {
        return orden;
    }

    public void setOrden(SimpleIntegerProperty orden) {
        this.orden = orden;
    }

    public SimpleIntegerProperty getLlegadaPedido() {
        return llegadaPedido;
    }

    public void setLlegadaPedido(SimpleIntegerProperty llegadaPedido) {
        this.llegadaPedido = llegadaPedido;
    }

    public SimpleIntegerProperty getStock() {
        return stock;
    }

    public void setStock(SimpleIntegerProperty stock) {
        this.stock = stock;
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

    public void setKta(SimpleDoubleProperty kta) {
        this.kta = kta;
    }

    public SimpleIntegerProperty getBda() {
        return bda;
    }

    public void setBda(SimpleIntegerProperty bda) {
        this.bda = bda;
    }
    
    
    
    
}
    
    