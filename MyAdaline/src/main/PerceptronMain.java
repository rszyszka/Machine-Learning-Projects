/*
 * Copyright (C) 2017 Szysz
 */
package main;

import java.util.Arrays;
import neurons.MojeLitery;
import neurons.Perceptron;

/**
 *
 * @author Szysz
 */
public class PerceptronMain {

    public static void main(String[] args) {

        int liczbaWejsc = 7;        //ilość wejść
        int liczbaLiter = 20;
        int epochCounter = 0;    //licznik ilości epok uczenia się
        double learnRate = 0.01;    //współczynnik uczenia

        Perceptron[] perceptrons = new Perceptron[liczbaWejsc];
        for (int i = 0; i < liczbaWejsc; i++) {
            perceptrons[i] = new Perceptron(liczbaWejsc);
        }

        int[] y = new int[liczbaLiter];
        Arrays.fill(y, 0, liczbaLiter / 2, 0); //przygotowanie tablicy wartosci oczekiwanej
        Arrays.fill(y, liczbaLiter / 2, liczbaLiter, 1); // 0 duza litera, 1 mala litera

        int[] result = new int[liczbaLiter];   //tablica przechowująca wyniki testowania perceptronow
        Arrays.fill(result, 0, liczbaLiter, 0);

        while (!Arrays.equals(y, result)) { //dopoki wynik jest rozny od wartosci oczekiwanej ucz siec

            for (int i = 0; i < liczbaLiter; i++) {
                learn(perceptrons, liczbaWejsc, learnRate, i);
            }

            result = test(perceptrons, liczbaLiter, liczbaWejsc);
            epochCounter++;
        }

        System.out.println("Ilość kroków do nauczenia się = " + epochCounter);
    }

    public static double learn(Perceptron[] perceptrons, int liczbaWejsc, double learnRate, int i) { //zwraca ilosc bledow 

        MojeLitery mojeLitery = new MojeLitery();
        int[] wektor;                   //tablica przechowująca wektor sygnałów wejściowych do uczenia pierwszej warstwy sieci
        wektor = mojeLitery.getLearningVektorOfLitera(i);

        int[] outputWektor = new int[liczbaWejsc];  //tablica przechowująca wektor sygnałów wyjściowych pierwszej warstwy sieci
        outputWektor[0] = 1; //bias

        int isDuza; //zmienna przechowujaca wartosc oczekiwana
        if (mojeLitery.getLitery()[i].isDuza) {
            isDuza = 0;
        } else {
            isDuza = 1;
        }

        for (int k = 0; k < liczbaWejsc - 1; k++) {               //uczenie pierwszej warstwy
            perceptrons[k].learn(wektor, isDuza, learnRate);
            outputWektor[k + 1] = perceptrons[k].process(wektor);        //pobranie sygnału wyjściowego
        }
        double blad = perceptrons[liczbaWejsc - 1].learn(outputWektor, isDuza, learnRate);    //uczenie neuronu wynikowego na podstawie sygnałów wyjściowych pierwszej warstwy
        return blad;
    }

    private static int[] test(Perceptron[] adaline, int liczbaLiter, int liczbaWejsc) {

        MojeLitery mojeLitery = new MojeLitery();
        int[] result = new int[liczbaLiter];
        int[] wektor;                   //tablica przechowująca wektor sygnałów wejściowych do testowania pierwszej warstwy sieci
        int[] wektorWyjsciowy = new int[liczbaWejsc];  //tablica przechowująca wektor sygnałów wyjściowych pierwszej warstwy sieci
        wektorWyjsciowy[0] = 1;                //bias

        for (int i = 0; i < liczbaLiter; i++) { //testowanie, celem upewnienia się, czy sieć już nauczona

            wektor = mojeLitery.getLearningVektorOfLitera(i); //pobierz wektor uczacy itej litery

            for (int k = 0; k < liczbaWejsc - 1; k++) {
                wektorWyjsciowy[k + 1] = adaline[k].process(wektor);
            }

            result[i] = adaline[liczbaWejsc - 1].process(wektorWyjsciowy); //wpisz otrzymany wynik do tablicy wyniku

        }
        return result;
    }
}
