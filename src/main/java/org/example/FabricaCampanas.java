package org.example;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FabricaCampanas {
    private ArrayList<Componente> componentesFabricados = new ArrayList<>();
    private EstacionTrabajo[] estacionesTrabajo = new EstacionTrabajo[5];
    private CadenaEnsamblaje cadenaEnsamblaje = new CadenaEnsamblaje();
    private CampanaGauss campanaGauss;

    public CampanaGauss getCampanaGauss() {
        return campanaGauss;
    }

    public void colocarComponente(Componente componente) {
        synchronized (this){
            componentesFabricados.add(componente);
        }
    }

    public FabricaCampanas() {}

    public void ensamblarCampana() {
        try {
            campanaGauss = cadenaEnsamblaje.setComponentesFabricados(componentesFabricados);
        } catch (Exception e) {
            System.out.println("Componentes insuficientes");
        }
    }

    public void producirComponentes() {

        for (int i = 0; i < estacionesTrabajo.length; i++) {
            estacionesTrabajo[i] = new EstacionTrabajo();
        }

        ExecutorService executor = Executors.newFixedThreadPool(5);
        Future<Componente>[] componentes = new Future[5];
        for (int i = 0; i < estacionesTrabajo.length; i++) {
            componentes[i] = executor.submit(estacionesTrabajo[i]);
        }
        //colocar los componentes en la cadena de ensamblaje
        for (int i = 0; i < componentes.length; i++) {
            try {
                colocarComponente(componentes[i].get());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        executor.shutdown();
    }
}
