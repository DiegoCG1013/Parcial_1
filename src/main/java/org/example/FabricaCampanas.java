package org.example;

import java.util.ArrayList;

public class FabricaCampanas {
    private ArrayList<Componente> componentesFabricados;
    private EstacionTrabajo[] estacionesTrabajo = new EstacionTrabajo[3];


    public void colocarComponente(Componente componente) {
        synchronized (this){
            componentesFabricados.add(componente);
        }
    }
}
