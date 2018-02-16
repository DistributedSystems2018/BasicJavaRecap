package main;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {

		String[] strArgs = { "car", "cat", "house", "dog", "car" };
		String[] intArgs = { "40", "5", "15", "45", "500" };

		// For string args
		CommandLineArgs clArgs = new CommandLineArgs(strArgs);
		clArgs.printArgsCnt();
		clArgs.printAllArgs();
		clArgs.printAllArgsSeq();
		clArgs.printRevOrder();
		clArgs.printAllArgsLength();
		// For integer args
		NumberArgs numArgs = new NumberArgs(intArgs);
		numArgs.printSum();
		numArgs.printEvenOnly();
		numArgs.printInNumericalOrder();

		// Fibonacci sequences
		System.out.println(Fibonacci.fibRecursive(7));
		System.out.println(Fibonacci.fibIterative(7));

		ArrayList<Integer> fibNums = Fibonacci.allFibNumbers(7);

		for (Integer i : fibNums) {
			System.out.print(i + " ");
		}
		System.out.println();

		numArgs.printDivisorsOfArg();

		// Square root estimation
		Solver.findSquareroot(612);

		PolishNotationParser p = new PolishNotationParser();

		p.parseInput("- * / 15 - 7 + 1 1 3 + 2 + 1 1");
		p.parseInputReverse("1 2 3 * +");

		p.printResult();
		p.printResultRev();

	}

}
