/*
 * Copyright (C) 2017 Szysz
 */
package main;

import java.io.IOException;

/**
 *
 * @author Szysz
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        
        RastriginDataGenerator generator = new RastriginDataGenerator();
        try {
            generator.generateNormalizedData("learningData.csv", 3500);
            generator.generateNormalizedData("testingData.csv", 1500);
        } catch (IOException ex) {
            System.err.println("IOException cought!");
        }
        finally{
            System.out.println("Generation completed!");
        }
    }

}
