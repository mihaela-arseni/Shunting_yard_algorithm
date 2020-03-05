package postfixNotation;

import java.util.ArrayDeque;
import java.util.Deque;

public class EvaluationPostfixExpression {

	public int evaluatePostFixExpression(String[] tokens) {
		Deque<Integer> stack = new ArrayDeque<>();

		for (int i = 0; i < tokens.length; i++) {
			String value = tokens[i];
			char ch = value.charAt(0);

			if (value.length() == 1 && !Character.isDigit(ch)) {
				if (stack.size() < 2) {
					return -1;
				}

				int val1 = stack.pop();
				int val2 = stack.pop();
				int result = evaluateResult(val1, val2, ch);
				
				stack.push(result);
			} else {
				stack.push(Integer.parseInt(value));
			}
		}
		return stack.pop();
	}

	private int evaluateResult(int val1, int val2, char ch) {
		int result = 0;
		switch (ch) {
		case '+':
			result = val1 + val2;
			break;
		case '-':
			result = val2 - val1;
			break;
		case '*':
			result = val1 * val2;
			break;
		case '/':
			if (val2 == 0)
				break;
			result = val2 / val1;
			break;
		case '^':
			result = (int) Math.pow(val2, val1);
			
		}
		return result;
	}
}
