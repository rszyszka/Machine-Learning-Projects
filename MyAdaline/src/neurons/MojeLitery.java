/*
 * Copyright (C) 2017 Szysz
 */
package neurons;

import java.util.Arrays;

/**
 *
 * @author Szysz
 */
public class MojeLitery {

    private final Litera[] litery;

    public MojeLitery() { //wektory wejsciowe liter

        litery = new Litera[20];

        //wielkie litery
        litery[0] = new Litera(true, new int[][]{ //A
            {0, 0, 1, 0, 0}, {0, 1, 0, 1, 0}, {1, 0, 0, 0, 1}, {1, 1, 1, 1, 1}, {1, 0, 0, 0, 1}, {1, 0, 0, 0, 1}, {1, 0, 0, 0, 1}
        });

        litery[1] = new Litera(true, new int[][]{ //B
            {1, 1, 1, 1, 0}, {1, 0, 0, 0, 1}, {1, 0, 0, 0, 1}, {1, 1, 1, 1, 0}, {1, 0, 0, 0, 1}, {1, 0, 0, 0, 1}, {1, 1, 1, 1, 0}
        });

        litery[2] = new Litera(true, new int[][]{ //C
            {0, 1, 1, 1, 1}, {1, 0, 0, 0, 0}, {1, 0, 0, 0, 0}, {1, 0, 0, 0, 0}, {1, 0, 0, 0, 0}, {1, 0, 0, 0, 0}, {0, 1, 1, 1, 1}
        });

        litery[3] = new Litera(true, new int[][]{ //D
            {1, 1, 1, 1, 0}, {1, 0, 0, 0, 1}, {1, 0, 0, 0, 1}, {1, 0, 0, 0, 1}, {1, 0, 0, 0, 1}, {1, 0, 0, 0, 1}, {1, 1, 1, 1, 0}
        });

        litery[4] = new Litera(true, new int[][]{ //E
            {1, 1, 1, 1, 1}, {1, 0, 0, 0, 0}, {1, 0, 0, 0, 0}, {1, 1, 1, 1, 1}, {1, 0, 0, 0, 0}, {1, 0, 0, 0, 0}, {1, 1, 1, 1, 1}
        });

        litery[5] = new Litera(true, new int[][]{//F
            {1, 1, 1, 1, 1}, {1, 0, 0, 0, 0}, {1, 0, 0, 0, 0}, {1, 1, 1, 1, 1}, {1, 0, 0, 0, 0}, {1, 0, 0, 0, 0}, {1, 0, 0, 0, 0}
        });

        litery[6] = new Litera(true, new int[][]{//G
            {0, 1, 1, 1, 1}, {1, 0, 0, 0, 0}, {1, 0, 0, 0, 0}, {1, 0, 0, 1, 1}, {1, 0, 0, 0, 1}, {1, 0, 0, 0, 1}, {0, 1, 1, 1, 1}
        });

        litery[7] = new Litera(true, new int[][]{//H
            {1, 0, 0, 0, 1}, {1, 0, 0, 0, 1}, {1, 0, 0, 0, 1}, {1, 1, 1, 1, 1}, {1, 0, 0, 0, 1}, {1, 0, 0, 0, 1}, {1, 0, 0, 0, 1}
        });

        litery[8] = new Litera(true, new int[][]{//I
            {0, 0, 1, 0, 1}, {0, 0, 1, 0, 0}, {0, 0, 1, 0, 0}, {0, 0, 1, 0, 0}, {0, 0, 1, 0, 0}, {0, 0, 1, 0, 0}, {0, 0, 1, 0, 0}
        });

        litery[9] = new Litera(true, new int[][]{//J
            {0, 1, 1, 1, 0}, {0, 0, 0, 1, 0}, {0, 0, 0, 1, 0}, {0, 0, 0, 1, 1}, {0, 0, 1, 1, 0}, {0, 1, 0, 1, 0}, {0, 0, 1, 0, 0}
        });

        //male litery
        litery[10] = new Litera(false, new int[][]{//a
            {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 1, 1, 1, 0}, {1, 0, 0, 1, 0}, {1, 0, 0, 1, 0}, {0, 1, 1, 1, 1}
        });

        litery[11] = new Litera(false, new int[][]{//b
            {1, 0, 0, 0, 0}, {1, 0, 0, 0, 0}, {1, 0, 0, 0, 0}, {1, 1, 1, 0, 0}, {1, 0, 0, 1, 0}, {1, 0, 0, 1, 0}, {1, 1, 1, 0, 0}
        });

        litery[12] = new Litera(false, new int[][]{//c
            {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 1, 1, 1, 0}, {1, 0, 0, 0, 0}, {1, 0, 0, 0, 0}, {0, 1, 1, 1, 0}
        });

        litery[13] = new Litera(false, new int[][]{//d
            {0, 0, 0, 1, 0}, {0, 0, 0, 1, 0}, {0, 0, 0, 1, 0}, {0, 1, 1, 1, 0}, {1, 0, 0, 1, 0}, {1, 0, 0, 1, 0}, {0, 1, 1, 1, 0}
        });

        litery[14] = new Litera(false, new int[][]{//e
            {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 1, 1, 0, 0}, {1, 0, 1, 0, 0}, {1, 1, 0, 0, 0}, {0, 1, 1, 1, 0}
        });

        litery[15] = new Litera(false, new int[][]{//f
            {0, 0, 0, 0, 0}, {0, 1, 1, 0, 0}, {1, 0, 0, 0, 0}, {1, 1, 1, 0, 0}, {1, 0, 0, 0, 0}, {1, 0, 0, 0, 0}, {1, 0, 0, 0, 0}
        });

        litery[16] = new Litera(false, new int[][]{//g
            {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 1, 0, 0}, {0, 1, 0, 1, 0}, {0, 0, 1, 1, 0}, {0, 0, 0, 1, 0}, {0, 1, 1, 0, 0}
        });

        litery[17] = new Litera(false, new int[][]{//h
            {1, 0, 0, 0, 0}, {1, 0, 0, 0, 0}, {1, 0, 0, 0, 0}, {1, 1, 1, 0, 0}, {1, 0, 1, 0, 0}, {1, 0, 1, 0, 0}, {1, 0, 1, 0, 0}
        });

        litery[18] = new Litera(false, new int[][]{//i
            {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 1, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 1, 0, 0}, {0, 0, 1, 0, 0}
        });
        litery[19] = new Litera(false, new int[][]{//j
            {0, 0, 0, 0, 0}, {0, 0, 1, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 1, 0, 0}, {0, 0, 1, 0, 0}, {0, 0, 1, 0, 0}, {0, 1, 1, 0, 0}
        });

    }

    public Litera[] getLitery() {
        return litery;
    }

    //funkcja zmieniajaca litere na wektor uczacy i zwracajaca go
    public int[] getLearningVektorOfLitera(int index) {

        int[] wektor = new int[7];
        Arrays.fill(wektor, 1, 6, 0);
        wektor[0] = 1; //bias

        //reprezentacja litery jest dzielona na 6 obszarow
        //obszar 1
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 2; j++) {
                if (litery[index].macierz[i][j] == 1) {
                    wektor[1] = 1;
                    //break;
                }
            }
        }
        //obszar 2
        for (int i = 0; i < 3; i++) {
            for (int j = 2; j < 3; j++) {
                if (litery[index].macierz[i][j] == 1) {
                    wektor[2] = 1;
                    //break;
                }
            }
        }
        //obszar 3
        for (int i = 0; i < 3; i++) {
            for (int j = 3; j < 5; j++) {
                if (litery[index].macierz[i][j] == 1) {
                    wektor[3] = 1;
                    //break;
                }
            }
        }
        //obszar 4
        for (int i = 3; i < 7; i++) {
            for (int j = 0; j < 2; j++) {
                if (litery[index].macierz[i][j] == 1) {
                    wektor[4] = 1;
                    //break;
                }
            }
        }
        //obszar 5
        for (int i = 3; i < 7; i++) {
            for (int j = 2; j < 3; j++) {
                if (litery[index].macierz[i][j] == 1) {
                    wektor[5] = 1;
                    //break;
                }
            }
        }
        //obszar 6
        for (int i = 3; i < 7; i++) {
            for (int j = 3; j < 5; j++) {
                if (litery[index].macierz[i][j] == 1) {
                    wektor[6] = 1;
                    //break;
                }
            }
        }

        return wektor;
    }

}
