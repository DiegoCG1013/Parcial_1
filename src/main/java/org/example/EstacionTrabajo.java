package org.example;

import java.util.concurrent.Callable;

public class EstacionTrabajo implements Callable<Componente> {

    @Override
    public Componente call() throws Exception{
        Componente comp = producirComponente();
        return comp;
    }

    private Componente producirComponente() throws InterruptedException{
        Componente componente = new Componente();
        Thread.sleep(5000);
        return componente;
    }
}
