package org.example;

import java.util.concurrent.*;

public class CampanaGauss {

    int tamanyoContenedor = 20;
    Boolean[][] contenedor = new Boolean[tamanyoContenedor][tamanyoContenedor];

    public CampanaGauss() {
        for (int i = 0; i < contenedor.length; i++) {
            for (int j = 0; j < contenedor.length; j++) {
                contenedor[i][j] = false;
            }
        }
    }

    public void lanzarBolitas() {
        int numeroHilos = 5;
        Future<Integer[]>[] resultados = new Future[numeroHilos];
        ExecutorService executor = Executors.newCachedThreadPool();
        for (int i = 0; i < numeroHilos; i++) {
            Future<Integer[]> future = executor.submit(new GeneradorBolitas(30));
        }
        for (int i = 0; i < numeroHilos; i++) {
            try {
                Integer[] resultado = resultados[i].get();
                executor.shutdown();
                for (int j = 0; j < resultado.length; j++) {
                    colocarEnColumna(resultado[j]);
                }
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
    }


    private void colocarEnColumna(int columna) {
        int fila = tamanyoContenedor;
        // Buscamos la primera fila vacía desde abajo
        while (fila > 0 && contenedor[fila - 1][columna]) {
            fila--;
        }
        if (fila > 0) {
            contenedor[fila - 1][columna] = true;
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
