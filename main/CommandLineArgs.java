package main;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;

public class CommandLineArgs {

	String[] args;

	CommandLineArgs(String[] args) {
		this.args = args;
	}

	void printArgsCnt() {
		System.out.println(args.length);
	}

	void printAllArgs() {
		for (String arg : args) {
			System.out.println(arg);
		}
	}

	void printAllArgsSeq() {
		int num = 1;
		for (String arg : args) {
			System.out.println(num + " : " + arg);
			num++;
		}
	}

	void printRevOrder() {
		for (int i = args.length - 1; i >= 0; i--) {
			System.out.println(args[i]);
		}
	}

	void printAllArgsLength() {
		for (String arg : args) {
			System.out.println(arg.length());
		}
	}

	void printAllAlphabeticalOrder() {
		String[] sorted = args;
		Arrays.sort(sorted);

		for (String arg : sorted) {
			System.out.println(arg);
		}
	}

	void printMultipleOcc() {
		HashMap<String, Integer> occurences = new HashMap<>();

		for (String arg : args) {
			if (occurences.containsKey(arg)) {
				occurences.put(arg, occurences.get(arg) + 1);
			} else {
				occurences.put(arg, 1);
			}
		}

		for (Entry<String, Integer> e : occurences.entrySet()) {
			if (e.getValue() > 1) {
				System.out.println(e.getKey());
			}
		}

	}

}
