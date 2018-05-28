/*
 * Copyright (C) 2017 Szysz
 */
package main;

import java.util.Random;

/**
 *
 * @author Szysz
 */
public class Perceptron {

    private final int rozmiar;
    private final double wage[];

    public Perceptron(int n) {
        rozmiar = n;
        wage = new double[n];
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            wage[i] = rand.nextDouble();
           // wage[i] = 0.1;
        }

    }

    private int activate(double y) {
        if (y < 0) {
            return 0;
        } else {
            return 1;
        }
    }

    public int process(int[] x) {
        double y = 0;
        for (int i = 0; i < rozmiar; i++) {
            y += x[i] * wage[i];
        }

        return activate(y);
    }

    public double learn(int x1[], double d, double learnRate) {
        double y = process(x1);
        double error = 0;
        for (int i = 0; i < rozmiar; i++) {
            wage[i] += (d - y) * learnRate * x1[i];
            error+=Math.abs(d-y);
        }
        return error;
    }

    public void showWages(){
        for (int i = 0 ; i<rozmiar; i++)
            System.out.println("w"+i+": "+wage[i]);
    }
    
}
