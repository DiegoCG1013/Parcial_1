package org.example;

public class EstacionTrabajo implements Runnable {

    @Override
    public void run() {
        while (true) {
            try {
                Componente comp = producirComponente();
                colocarComponente(comp);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    private void colocarComponente(Componente componente) {
        FabricaCampanas.colocarComponente(componente);
    }

    private Componente producirComponente() throws InterruptedException{
        Componente componente = new Componente();
        Thread.sleep(3000);
        return componente;
    }
}
