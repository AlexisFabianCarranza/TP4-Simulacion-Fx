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
public class VectorEstado {
    
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
    
    public VectorEstado(int reloj, double rndDemanda, int demanda, double rndDemora, int demora, double rndDañada, int dañada, int orden, int llPedido, int stock, double ko, double km, double ks, double ct, double cta, int contDañada){
        this.reloj = reloj;
        this.rndBiciDañada = rndDañada;
        this.rndDemanda = rndDemanda;
        this.rndDemora = rndDemora;
        this.biciDañada = dañada;
        this.demanda = demanda;
        this.demora = demora;
        this.orden = orden;
        this.llegadaPedido = llPedido;
        this.stock = stock;
        this.ko = ko;
        this.km = km;
        this.ks = ks;
        this.ct = ct;
        this.cta = cta;
        this.bda = contDañada;
    }
    
    public VectorEstadoView vista(){
        VectorEstadoView v = new VectorEstadoView(this);
        return v;
    }
    
    public VectorEstado(){
        this.reloj = 0;
    }
    
    public VectorEstado(int reloj){
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
    
    
    @Override
    public String toString(){
        
        double rnd1 = Math.round(this.rndDemanda*100.0) / 100.0;
        double rnd2 = Math.round(this.rndDemora*100.0) / 100.0;
        double rnd3 = Math.round(this.rndBiciDañada*100.0) / 100.0;
        double kta = Math.round(this.cta*100.0) / 100.0;
        
        
        
        String s = "Reloj: " + this.reloj + " - RND: " + rnd1 + " Demanda: " + this.demanda;
        s += " - RND: " + rnd2 + " Demora: " + this.demora +  " - RND: " + rnd3 + " BiciDañada: " + this.biciDañada;
        s += " - Orden: " + this.orden + " LLegadaPedido: " + this.llegadaPedido + " Stock: " + this.stock + " - ko: ";
        s +=  this.ko + " km: " + this.km + " ks: " + this.ks + " CT: " + this.ct + " CTA: " + kta + " BDA: " + this.bda;
        return s;
    }
    
}
