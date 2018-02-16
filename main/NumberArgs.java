package main;

import java.util.TreeSet;

public class NumberArgs extends CommandLineArgs {

	NumberArgs(String[] args) {
		super(args);
	}

	void printSum() {
		int sum = 0;
		for (String arg : args) {
			sum += Integer.parseInt(arg);
		}
		System.out.println(sum);
	}

	void printEvenOnly() {
		for (String arg : args) {
			if (Integer.parseInt(arg) % 2 == 0) {
				System.out.println(arg);
			}
		}
	}

	void printInNumericalOrder() {
		TreeSet<Integer> numberSet = new TreeSet<>();

		for (String arg : args) {
			numberSet.add(Integer.parseInt(arg));
		}

		for (Integer i : numberSet) {
			System.out.println(i);
		}

	}

	void printDivisorsOfArg() {
		int toCheck = Integer.parseInt(args[0]);
		int range = toCheck / 2;
		for (int i = 1; i < range; i++) {
			if (toCheck % i == 0) {
				System.out.print(i + " ");
			}
		}
		System.out.println(" ");

	}

}
