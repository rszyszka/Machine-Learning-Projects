/*
 * Copyright (C) 2017 Szysz
 */
package main;

/**
 *
 * @author Szysz
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int n = 3;
        Perceptron perc = new Perceptron(n);

        perc.showWages();

        int inputSize = 4;
        double learnRate = 0.1;

        int bias = 1;

        int x1[] = {1, 0, 1, 0};
        int x2[] = {0, 0, 1, 1};

        int d[] = {0, 0, 1, 0};

        double error;
        do {
            error = 0;
            for (int j = 0; j < inputSize; j++) {
                error += perc.learn(new int[]{bias, x1[j], x2[j]}, d[j], learnRate);
            }
            System.out.println("error: " + error);
        } while (error != 0);

            System.out.println(perc.process(new int[]{bias, 1, 0}));
            System.out.println(perc.process(new int[]{bias, 0, 1}));
            System.out.println(perc.process(new int[]{bias, 1, 0}));
            System.out.println(perc.process(new int[]{bias, 1, 1}));
            System.out.println("");
        
    }
}
