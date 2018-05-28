/*
 * Copyright (C) 2017 Szysz
 */
package main;

import java.util.Arrays;
import neurons.Adaline;
import neurons.MojeLitery;

/**
 *
 * @author Szysz
 */
public class AdalineMain {

    public static void main(String[] args) {
        int liczbaWejsc = 7;        //ilość wejść
        int liczbaLiter = 20;   //liczba liter
        int epochCounter = 0;    //licznik ilości epok uczenia się
        double learnRate = 0.01;    //współczynnik uczenia

        Adaline[] adaline = new Adaline[liczbaWejsc];
        for (int i = 0; i < liczbaWejsc; i++) {
            adaline[i] = new Adaline(liczbaWejsc);
        }

        int[] y = new int[liczbaLiter]; //przygotowanie tablicy wartosci oczekiwanej
        Arrays.fill(y, 0, liczbaLiter / 2, -1);        // -1 duza litera, 1 mala litera
        Arrays.fill(y, liczbaLiter / 2, liczbaLiter, 1);

        int[] result = new int[liczbaLiter];   //tablica przechowująca wyniki testowania adaline
        Arrays.fill(result, 0, liczbaLiter, 0);

        while (!Arrays.equals(y, result)) { //dopoki wynik jest rozny od wartosci oczekiwanej ucz siec

            for (int i = 0; i < liczbaLiter; i++) {
                learn(adaline, liczbaWejsc, learnRate, i);
            }

            result = test(adaline, liczbaLiter, liczbaWejsc);
            epochCounter++;
        }

        System.out.println("Ilość kroków do nauczenia się = " + epochCounter);
    }

    private static void learn(Adaline[] adaline, int liczbaWejsc, double learnRate, int i) {

        MojeLitery mojeLitery = new MojeLitery();
        int[] wektor;                   //tablica przechowująca wektor sygnałów wejściowych do uczenia pierwszej warstwy sieci
        wektor = mojeLitery.getLearningVektorOfLitera(i); //pobierz wektor uczacy itej litery
        format(wektor); //zamien w wektorze 0 na -1

        int[] outputWektor = new int[liczbaWejsc];  //tablica przechowująca wektor sygnałów wyjściowych pierwszej warstwy sieci
        outputWektor[0] = 1; //bias

        int isDuza; //zmienna przechowujaca wartosc oczekiwana
        if (mojeLitery.getLitery()[i].isDuza) {
            isDuza = -1;
        } else {
            isDuza = 1;
        }

        for (int k = 0; k < liczbaWejsc - 1; k++) {               //uczenie pierwszej warstwy
            adaline[k].learn(wektor, isDuza, learnRate);
            outputWektor[k + 1] = adaline[k].test(wektor);        //pobranie sygnału wyjściowego
        }
        adaline[liczbaWejsc - 1].learn(outputWektor, isDuza, learnRate);    //uczenie neuronu wynikowego na podstawie sygnałów wyjściowych pierwszej warstwy
    }

    private static int[] test(Adaline[] adaline, int liczbaLiter, int liczbaWejsc) {

        MojeLitery mojeLitery = new MojeLitery();
        int[] result = new int[liczbaLiter];
        int[] wektor;                   //tablica przechowująca wektor sygnałów wejściowych do testowania pierwszej warstwy sieci
        int[] wektorWyjsciowy = new int[liczbaWejsc];  //tablica przechowująca wektor sygnałów wyjściowych pierwszej warstwy sieci
        wektorWyjsciowy[0] = 1;                //bias

        for (int i = 0; i < liczbaLiter; i++) { //testowanie, celem upewnienia się, czy sieć już nauczona

            wektor = mojeLitery.getLearningVektorOfLitera(i);
            format(wektor);

            for (int k = 0; k < liczbaWejsc - 1; k++) {
                wektorWyjsciowy[k + 1] = adaline[k].test(wektor);
            }

            result[i] = adaline[liczbaWejsc - 1].test(wektorWyjsciowy);

        }
        return result;
    }

    //w przypadku adaline sygnały wejściowe = 0 muszą być zamienione na sygnały -1
    private static void format(int[] wektor) {
        for (int k = 0; k < wektor.length; k++) {
            if (wektor[k] == 0) {
                wektor[k] = -1;
            }
        }
    }
}
