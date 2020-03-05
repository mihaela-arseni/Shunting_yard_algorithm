package postfixNotation;

public class Test {

	public static void main(String[] args) {

		EvaluationPostfixExpression evaluatedExpression = new EvaluationPostfixExpression();
		ConversionPostfixNotationArray convers = new ConversionPostfixNotationArray();

		String[] arrayEx = { "3", "+", "(", "2", "+", "1", ")", "*", "2", "^", "3", "^", "2", "-", "8", "/", "(",
				"5", "-", "1", "*", "2", "/", "2", ")" };
		String[] postfixExpre = convers.convertToPostfix(arrayEx);
		for(String s : postfixExpre) {
			System.out.print(s + " ");
		}
		System.out.println();
		
		System.out.println(evaluatedExpression.evaluatePostFixExpression(postfixExpre));
		
//		String[] arr1 = { "4", "13", "5", "/", "+" };
//
//		System.out.println(evaluatedExpression.evalRPN(arr1));
	}

}
