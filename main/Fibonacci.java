package main;

import java.util.ArrayList;

public class Fibonacci {

	static int fibRecursive(int n) {
		if (n <= 1) {
			return n;
		} else {
			return (fibRecursive(n - 1) + fibRecursive(n - 2));
		}

	}

	static int fibIterative(int n) {
		int n1 = 1;
		int n2 = 1;

		for (int i = 1; i < n; i++) {
			int t = n2;
			n2 = n2 + n1;
			n1 = t;

		}
		return n1;
	}

	static ArrayList<Integer> allFibNumbers(int n) {
		ArrayList<Integer> listOfFib = new ArrayList<>();
		int n1 = 1;
		int n2 = 1;
		listOfFib.add(n1);
		for (int i = 1; i < n; i++) {
			int t = n2;
			n2 = n2 + n1;
			n1 = t;
			listOfFib.add(n1);
		}
		return listOfFib;
	}

}
