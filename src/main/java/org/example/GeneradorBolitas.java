package org.example;

import java.util.concurrent.Callable;

public class GeneradorBolitas implements Callable<Integer[]> {

    int bolitas;
    public GeneradorBolitas(int x) {
        bolitas = x;
    }

    @Override
    public Integer[] call() throws Exception {
        return null;
    }
}
