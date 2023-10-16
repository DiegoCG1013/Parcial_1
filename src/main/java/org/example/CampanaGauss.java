package org.example;

public class CampanaGauss {

    int tamanyoContenedor = 10;
    Boolean[][] contenedor = new Boolean[tamanyoContenedor][tamanyoContenedor];

    public CampanaGauss() {
        for (int i = 0; i < contenedor.length; i++) {
            for (int j = 0; j < contenedor.length; j++) {
                contenedor[i][j] = false;
            }
        }
    }

    @Override
    public String toString() {
        String aux = "";
        for (int i = 0; i < contenedor.length; i++) {
            for (int j = 0; j < contenedor.length; j++) {
                if (contenedor[i][j]) {
                    aux += " o ";
                } else {
                    aux += "   ";
                }
            }
            aux += "\n";
        }
        return aux;
    }
}
