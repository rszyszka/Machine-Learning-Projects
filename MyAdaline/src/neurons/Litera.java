/*
 * Copyright (C) 2017 Szysz
 */
package neurons;

/**
 *
 * @author Szysz
 */
public class Litera {

    public boolean isDuza; //flaga oznaczajaca czy litera jest duza
    public int[][] macierz; //macierz z sygnalami litery

    public Litera(boolean isDuza, int[][] macierz) {

        this.isDuza = isDuza;
        this.macierz = macierz;
    }

}
