package org.example;

import java.util.ArrayList;

public class CadenaEnsamblaje {
    private ArrayList<Componente> componentesFabricados = new ArrayList<>();


    public CampanaGauss setComponentesFabricados(ArrayList<Componente> componentesFabricados) {
        this.componentesFabricados = componentesFabricados;
        try{
            return ensamblarCampana();
        } catch (Exception e){
            System.out.println("Faltan componentes");
        }
    }

    private CampanaGauss ensamblarCampana() throws Exception{
        if (componentesFabricados.size() == 5 && !componentesFabricados.contains(null)) {
            System.out.println("Campana ensamblada");
            return new CampanaGauss();
        }
        throw new Exception();
    }
}
