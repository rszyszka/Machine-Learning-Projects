package main;

public class Main {

    static int numberOfInputs = 64 + 1;					//ilość wejść
    static double learnRate = 0.05;					//współczynnik uczenia się
    static double forgetRate = 0.000033;                                //współczynnik zapominania
    static int numberOfEmotes = 4;					//liczba emotikonów
    static int numberOfNeurons = 5;					//liczba nauronów

    public static void main(String[] args) {

        int winner;
        Hebb[] hebbs = new Hebb[numberOfNeurons]; // tworzymy siec o okreslonym rozmiarze
        for (int i = 0; i < numberOfNeurons; i++) {
            hebbs[i] = new Hebb(numberOfInputs);
        }

        System.out.println("PRZED UCZENIEM"); // emotikony przypisane do neuronow przed uczeniem
        for (int i = 0; i < numberOfEmotes; i++) {
            winner = testHebb(hebbs, Emotes.learnData[i]);
            System.out.println("Winner Hebb = " + winner);
        }

        int ages = learn(hebbs);

        System.out.println("\n\nPO UCZENIU"); //emotikony przypsane do neuronow po uczeniu
        for (int i = 0; i < numberOfEmotes; i++) {
            winner = testHebb(hebbs, Emotes.learnData[i]);
            System.out.println("Winner Hebb = " + winner);
        }

        System.out.println("\n\nIlość epok = " + ages);

        System.out.println("\n\nTESTOWANIE"); //wypisanie wynikow testowania 

            for (int i = 0; i < numberOfEmotes; i++) {
                winner = testHebb(hebbs, Emotes.testingData[i]);
                System.out.println("Winner Hebb = " + winner);
            }

    }

    //uczenie neuronów
    public static int learn(Hebb[] hebbs) {

        int counter = 0; //licznik iteracji
        int limit = 10000; // limit iteracji
        int[] winners = new int[numberOfNeurons];
        for (int i = 0; i < numberOfNeurons; i++) {
            winners[i] = - 1;
        }

        while (!isUnique(winners)) { // uczymy dopoki jedna emotka nie bedzie miala przypisanego jednego neuronu

            for (int i = 0; i < numberOfNeurons; i++) {

                //uczenie neuronów każdej emotikony
                for (int j = 0; j < numberOfEmotes; j++) {
                    hebbs[i].learn(Emotes.learnData[j], learnRate, forgetRate, Hebb.HEBB_WITH_FORGETTIN); 
                }

                //tesotowanie sieci celem sprawdzenia, czy sieć jest już nauczona
                for (int k = 0; k < numberOfEmotes; k++) {
                    winners[k] = testHebb(hebbs, Emotes.learnData[k]);
                }
            }

            if (++counter == limit) { // jesli licznik osiagnie limit - koniec
                break;
            }
        }

        return counter; //zwracamy w ktorej epoce siec zostala wyuczona
    }

    //funkcja pomocnicza w procesie uczenie
    //zwraca true jeśli każdy element w tablicy jest unikalny
    public static boolean isUnique(int[] winners) {

        for (int i = 0; i < numberOfNeurons; i++) {
            for (int j = 0; j < numberOfNeurons; j++) {
                if (i != j) {
                    if (winners[i] == winners[j]) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    //zwraca wartość zwycięzkiego neuronu dla podanej emotikony
    public static int testHebb(Hebb[] hebbs, double[] emoji) {

        double max = hebbs[0].test(emoji);
        int winner = 0;

        for (int i = 1; i < numberOfNeurons; i++) {
            if (hebbs[i].test(emoji) > max) {
                max = hebbs[i].test(emoji);
                winner = i;
            }
        }

        return winner;
    }

}
