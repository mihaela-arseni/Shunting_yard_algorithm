package postfixNotation;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class ConversionPostfixNotationArray {
	public int precedence(String operator) {
		switch (operator) {
		case "+":
		case "-":
			return 1;
		case "*":
		case "/":
			return 2;
		case "^":
			return 3;
		}
		return -1;
	}

	public String[] convertToPostfix(String[] expression) {
		String[] result = new String[expression.length];
		int position = 0;
		Deque<String> stackOperators = new ArrayDeque<>();

		for (int i = 0; i < expression.length; i++) {
			String value = expression[i];
			char op = value.charAt(0);	

			if (value == "(") {
				stackOperators.push(value);
			} else if (value == ")") {

				while (!stackOperators.isEmpty() && stackOperators.peek() != "(") {
					result[position++] = stackOperators.pop();
				}

				if (!stackOperators.isEmpty() && stackOperators.peek() != "(") {
					System.out.println("Error, invalid expression");
					return null;
				} else {
					stackOperators.pop();
				}
			} else if (!Character.isDigit(op)) {

				while (!stackOperators.isEmpty() && precedence(value) <= precedence(stackOperators.peek())
						&& value != "^") {
					result[position++] = stackOperators.pop();

				}
				stackOperators.push(value);
			} else {
				result[position++] = value;
			}
		}

		while (!stackOperators.isEmpty()) {
			if (stackOperators.peek() == "(") {
				System.out.println("Error, invalid expression");
				return null;
			}
			result[position++] = stackOperators.pop();
		}

		return Arrays.copyOf(result, position);
	}
}
