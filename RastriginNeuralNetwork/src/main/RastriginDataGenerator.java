/*
 * Copyright (C) 2017 Szysz
 */
package main;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author Szysz
 */
public class RastriginDataGenerator {

    public void generateNormalizedData(String fileName, int size) throws IOException {

        double x[] = new double[size];
        double y[] = new double[size];
        double z[] = new double[size];

        File file = new File(fileName);
        if (!file.exists()) {
            file.createNewFile();
        }

        PrintWriter printWriter = new PrintWriter(file);
        for (int i = 0; i < size; i++) {
            x[i] = ThreadLocalRandom.current().nextDouble(-2, 2);
            y[i] = ThreadLocalRandom.current().nextDouble(-2, 2);
            z[i] = rastriginFunction(x[i], y[i]);

            normalizeData(x, y, z);

            printWriter.println(x[i] + "," + y[i] + "," + z[i]);
        }
        printWriter.close();
    }

    private double rastriginFunction(double x, double y) {
        return 20 + Math.pow(x, 2) - 10 * Math.cos(2 * Math.PI * x) + Math.pow(y, 2) - 10 * Math.cos(2 * Math.PI * y);
    }

    private void normalizeData(double x[], double y[], double z[]) {

        for (int i = 0; i < x.length; i++) {
            x[i] = (x[i] + 2.0) / 4.0;
            y[i] = (y[i] + 2.0) / 4.0;
            z[i] = z[i] / 44.5;
        }
    }

}
