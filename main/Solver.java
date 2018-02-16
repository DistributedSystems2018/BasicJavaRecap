package main;

public class Solver {

	static double findSquareroot(int x) {
		double initialGuess = 10.0;

		double it1 = initialGuess - (Math.pow(initialGuess, 2) - (double) x) / (2 * initialGuess);
		double it2 = it1 - (Math.pow(it1, 2) - (double) x) / (2 * it1);

		double prev = it1;

		// For more precise approximation change difference to lower value
		while (Math.abs(it2 - prev) > 0.01) {
			prev = it2;
			it2 = prev - (Math.pow(prev, 2) - (double) x) / (2 * prev);
		}

		System.out.println("Approximate square root of " + x + ": " + it2);

		return it2;
	}

}
