package org.example;

public class Main {
    public static void main(String[] args) {
        inicio();
    }

    public static void inicio() {
        FabricaCampanas fabrica = new FabricaCampanas();
        fabrica.producirComponentes();
        CampanaGauss campana = fabrica.ensamblarCampana();
        campana.lanzarBolitas();
        System.out.println(campana);
    }
}