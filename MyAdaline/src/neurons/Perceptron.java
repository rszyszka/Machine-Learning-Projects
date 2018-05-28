/*
 * Copyright (C) 2017 Szysz
 */
package neurons;

import java.util.Random;

/**
 *
 * @author Szysz
 */
public class Perceptron {

    private final int rozmiar; //liczba wejsc
    private final double wage[]; //wagi

    public Perceptron(int n) {
        rozmiar = n;
        wage = new double[n];
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            wage[i] = rand.nextDouble();
            // wage[i] = 0.1;
        }

    }

    private int activate(double y) { //funkcja aktywacji
        if (y < 0) {
            return 0;
        } else {
            return 1;
        }
    }

    public int process(int[] x) { //funkcja sumujaca
        double y = 0;
        for (int i = 0; i < rozmiar; i++) {
            y += x[i] * wage[i];
        }

        return activate(y);
    }

    public double learn(int x1[], double d, double learnRate) { //funkcja uczaca
        double y = process(x1);
        double error = 0;
        for (int i = 0; i < rozmiar; i++) {
            wage[i] += (d - y) * learnRate * x1[i];
            error += Math.abs(d - y); //blad == |wartosc oczekiwana - wartosc otrzymana|
        }
        return error;
    }

    public void showWages() {
        for (int i = 0; i < rozmiar; i++) {
            System.out.println("w" + i + ": " + wage[i]);
        }
    }
}
