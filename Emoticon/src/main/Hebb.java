package main;

import java.util.Random;

public class Hebb {

	private int noi;    //ilość wejść
	private double[] w; //wagi
	public static boolean HEBB_WITH_FORGETTIN = true; //flagi okreslajace jaki typ modyfikacji wag wybieramy
	public static boolean HEBB_WITHOUT_FORGETTIN = false;

	public Hebb ( int numbers_of_inputs ) {
		noi = numbers_of_inputs;
		w = new double[noi];

		for ( int i = 0; i < noi; i++ )
			w[i] = new Random().nextDouble(); //wagi początkowe sa losowane

		normalizeWeights();
	}

	//funkcja aktywacji
	private double activate ( double y_p ) {
		//return y_p; //funkcja liniowa
		return ( 1.0 / ( 1 + Math.pow( Math.E, - y_p ) ) );		//unipolarna sigmoidalna
	}

	//zwraca sumę iloczynów wag i sygnałów wejściowych
	private double sumator ( double[] x ) {
		double y_p = 0.0;
		for ( int i = 0; i < noi; i++ )
			y_p += x[i] * w[i];

		return y_p;
	}

	//uczenie
	public double learn ( double[] x, double lr, double fr, boolean version ) {
		double y = activate( sumator( x ) );

		//w zależności od podanej wersji, nauka będzie z lub bez współczynnika zapominania
		for ( int i = 0; i < noi; i++ )
			if ( version ) w[i] = ( 1 - fr ) * w[i] + lr * x[i] * y;	//ze współczynnikiem zapominania
			else w[i] += lr * x[i] * y;					//bez współczynnika zapominania

		normalizeWeights(); // normalizujemy wagi

		return activate( sumator( x ) );
	}

	//zwraca output neuronu
	public double test ( double[] x ) {
		return activate( sumator( x ) );
	}

	//normalizuje wagi
	private void normalizeWeights () {
		double dl = 0.0;
		for ( int i = 0; i < w.length; i++ )
			dl += Math.pow( w[i], 2 );

		dl = Math.sqrt( dl );

		for ( int i = 0; i < w.length; i++ )
			if ( w[i] > 0 && dl != 0 )
				w[i] = w[i] / dl;
	}

}