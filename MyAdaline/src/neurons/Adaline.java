/*
 * Copyright (C) 2017 Szysz
 */
package neurons;

import java.util.Random;

/**
 *
 * @author Szysz
 */
public class Adaline {

    private final int liczbaWejsc; //liczba wejsc
    private final double[] w; //wagi

    public Adaline(int liczbaWejsc) {
        this.liczbaWejsc = liczbaWejsc;
        w = new double[this.liczbaWejsc];

        for (int i = 0; i < this.liczbaWejsc; i++) {
            w[i] = new Random().nextDouble(); //wagi początkowe sa losowane
        }
    }

    //funkcja aktywacji
    public int f(double s) {
        if (s > 0) {
            return 1;
        } else {
            return -1;
        }
    }

    //funkcja sumujaca
    public double process(int[] x) {

        double y = 0;
        for (int i = 0; i < liczbaWejsc; i++) {
            y += x[i] * w[i];
        }

        return y;
    }

    //funkcja uczaca
    public void learn(int[] x, double d, double learnRate) {

        double y = process(x);
        for (int i = 0; i < liczbaWejsc; i++) {
            w[i] += (d - y) * learnRate * x[i]; //modyfikacja wag
        }
    }

    //funkcja testujaca
    public int test(int[] x) {
        double result = process(x);
        return f(result);
    }

}
