package tp4.simulacion.fx.Class;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.ArrayList;

/**
 *
 * @author aleex
 */
public class Evento {
    private ArrayList intervalos;
    private double[] probabilidades;
    private ArrayList resultado;

    public Evento(double[] probabilidades, ArrayList resultado) {
        this.intervalos = new ArrayList();
        this.resultado = resultado;
        this.probabilidades = probabilidades;
        this.generarIntervalos();
    }
    
    public int getResultado(double random){
        for (int i = 0; i <  this.intervalos.size(); i++){
            double[] inter = (double[]) this.intervalos.get(i);
            if(random >= inter[0] & random <= inter[1]){
                return (int) this.resultado.get(i);
            }
        }
        return -1;
    }
    
    private void generarIntervalos(){
        double interIzq = 0;
        double interDer = -0.01;
        for (int i = 0 ; i < this.probabilidades.length ; i++){
            double intervalo[] = new double[2];
            interDer += this.probabilidades[i];
            intervalo[0] = interIzq;
            intervalo[1] = interDer;
            this.intervalos.add(intervalo);
            interIzq += this.probabilidades[i];
        }
    }
    
    public ArrayList getIntervalos() {
        return intervalos;
    }
    
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.intervalos.size() ; i++){
            double aux[] = (double[]) this.intervalos.get(i);
            sb.append("Intervalo ").append(i).append(": ").append(aux[0]).append(" - ").append(aux[1]).append("\n");
        }
        return sb.toString();
    }
    
}
