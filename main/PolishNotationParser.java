package main;

import java.util.ArrayList;
import java.util.Stack;

public class PolishNotationParser {
	// For regular polish notation
	Stack<Integer> numbers;
	Stack<Character> operators;
	// For reverse polish notation
	Stack<Integer> revNumbers;
	//For input validation
	ArrayList<Character> operator;

	public PolishNotationParser() {
		numbers = new Stack<>();
		operators = new Stack<>();
		operator = new ArrayList<>();
		operator.add('+');
		operator.add('-');
		operator.add('*');
		operator.add('/');
		revNumbers = new Stack<>();
	}

	void parseInput(String formula) {
		String[] tokens = formula.split(" ");
		boolean pendingOp = false;

		for (String token : tokens) {

			if (isNum(token)) {
				int operand = Integer.parseInt(token);
				if (pendingOp) {
					while (!numbers.isEmpty()) {
						int operand1 = numbers.pop();
						char currentOperator = operators.pop();

						operand = evalExpr(operand1, operand, currentOperator);
					}

				}
				numbers.push(operand);
				pendingOp = true;

			} else {
				if (token.length() == 1 && operator.contains(token.charAt(0))) {
					operators.push(token.charAt(0));
					pendingOp = false;
				}
			}
		}

	}

	void parseInputReverse(String formula) {
		String[] tokens = formula.split(" ");
		for (String token : tokens) {
			if (isNum(token)) {
				revNumbers.push(Integer.parseInt(token));
			} else if (token.length() == 1 && operator.contains(token.charAt(0))) {
				int operand1 = revNumbers.pop();
				int operand2 = revNumbers.pop();
				int result = evalExpr(operand1, operand2, token.charAt(0));
				revNumbers.push(result);
			}
		}
	}

	boolean isNum(String asStr) {
		try {
			Integer.parseInt(asStr);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}

	int evalExpr(int op1, int op2, char sign) {
		if (sign == '*') {
			return op1 * op2;
		} else if (sign == '+') {
			return op1 + op2;
		} else if (sign == '-') {
			return op1 - op2;
		} else if (sign == '/') {
			return op1 / op2;
		}
		System.out.println("Unexpected operator");
		return -1;
	}

	void printNumberstack() {
		for (Integer i : numbers) {
			System.out.print(i + " ");
		}
		System.out.println("");
	}

	void printOperatorstack() {
		for (Character c : operators) {
			System.out.print(c + " ");
		}
		System.out.println("");
	}

	void printResult() {
		if (numbers.size() > 0)
			System.out.println(numbers.peek());
		else
			System.out.println("Error: No numbers in stack");
	}

	void printResultRev() {
		if (revNumbers.size() > 0)
			System.out.println(revNumbers.peek());
		else
			System.out.println("Error: no numbers in reverse stack");
	}

}
