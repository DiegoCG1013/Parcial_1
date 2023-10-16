package org.example;

import java.util.ArrayList;

public class FabricaCampanas {
    private static ArrayList<Componente> componentesFabricados;
    private static EstacionTrabajo[] estacionesTrabajo = new EstacionTrabajo[3];


    public static void colocarComponente(Componente componente) {
        synchronized (componentesFabricados){
            componentesFabricados.add(componente);
        }
    }
}
