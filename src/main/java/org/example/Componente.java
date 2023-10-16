package org.example;

public class Componente {
    private static int contador = 0;
    private int id;

    public Componente() {
        this.id = ++contador;
    }

    @Override
    public String toString() {
        return "Componente{" +
                "id=" + id +
                '}';
    }
}
