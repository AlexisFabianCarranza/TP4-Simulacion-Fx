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
public class VectorEstadoCalculo {
    
    private int reloj;
    private double rndDemanda;
    private int demanda;
    private double rndDemora;
    private int demora;
    private double rndBiciDañada;
    private int biciDañada;
    private int orden;
    private int llegadaPedido;
    private int stock;
    private double ko;
    private double km;
    private double ks;
    private double ct;
    private double cta;
    private int bda;
    
    public VectorEstadoCalculo(){
        this.reloj = 0;
    }
    
    public VectorEstadoCalculo(int reloj){
        this.reloj = reloj;
    }

    public int getReloj() {
        return reloj;
    }

    public void setReloj(int reloj) {
        this.reloj = reloj;
    }

    public double getRndDemanda() {
        return rndDemanda;
    }

    public void setRndDemanda(double rndDemanda) {
        this.rndDemanda = rndDemanda;
    }

    public int getDemanda() {
        return demanda;
    }

    public void setDemanda(int demanda) {
        this.demanda = demanda;
    }

    public double getRndDemora() {
        return rndDemora;
    }

    public void setRndDemora(double rndDemora) {
        this.rndDemora = rndDemora;
    }

    public int getDemora() {
        return demora;
    }

    public void setDemora(int demora) {
        this.demora = demora;
    }

    public double getRndBiciDañada() {
        return rndBiciDañada;
    }

    public void setRndBiciDañada(double rndBiciDañada) {
        this.rndBiciDañada = rndBiciDañada;
    }

    public int getBiciDañada() {
        return biciDañada;
    }

    public void setBiciDañada(int biciDañada) {
        this.biciDañada = biciDañada;
    }

    public int getOrden() {
        return orden;
    }

    public void setOrden(int orden) {
        this.orden = orden;
    }

    public int getLlegadaPedido() {
        return llegadaPedido;
    }

    public void setLlegadaPedido(int llegadaPedido) {
        this.llegadaPedido = llegadaPedido;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getKo() {
        return ko;
    }

    public void setKo(double ko) {
        this.ko = ko;
    }

    public double getKm() {
        return km;
    }

    public void setKm(double km) {
        this.km = km;
    }

    public double getKs() {
        return ks;
    }

    public void setKs(double ks) {
        this.ks = ks;
    }

    public double getCt() {
        return ct;
    }

    public void setCt(double ct) {
        this.ct = ct;
    }

    public double getCta() {
        return cta;
    }

    public void setCta(double cta) {
        this.cta = cta;
    }

    public int getBda() {
        return bda;
    }

    public void setBda(int bda) {
        this.bda = bda;
    }
    
    
    
    
}
