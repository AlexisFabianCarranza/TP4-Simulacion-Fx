/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp4.simulacion.fx.Class;

import java.util.ArrayList;

/**
 *
 * @author nicolastomassi
 */
public class main {

    public static void main(String[] args) {

        double probabilidades[] = new double[4];
        probabilidades[0] = 0.5;
        probabilidades[1] = 0.15;
        probabilidades[2] = 0.25;
        probabilidades[3] = 0.1;

        ArrayList rs = new ArrayList();
        rs.add(0);
        rs.add(1);
        rs.add(2);
        rs.add(3);

        Evento demanda = new Evento(probabilidades, rs);

        probabilidades = new double[3];
        probabilidades[0] = 0.3;
        probabilidades[1] = 0.4;
        probabilidades[2] = 0.3;

        rs = new ArrayList();
        rs.add(1);
        rs.add(2);
        rs.add(3);

        Evento demora = new Evento(probabilidades, rs);

        probabilidades = new double[2];
        probabilidades[0] = 0.7;
        probabilidades[1] = 0.3;

        rs = new ArrayList();
        rs.add(0);
        rs.add(1);

        Evento biciDañada = new Evento(probabilidades, rs);

        Simulador sim = new Simulador(demanda, demora, biciDañada, 10, 50);

        for (int i = 0; i < 100; i++) {
            sim.simular();
        }

    }

}
