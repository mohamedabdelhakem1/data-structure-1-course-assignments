package eg.edu.alexu.csd.datastructure.stack.cs44;

import eg.edu.alexu.csd.datastructure.stack.IExpressionEvaluator;

public class ExpressionEvaluator implements IExpressionEvaluator {

	@Override
	public String infixToPostfix(String expression) {

		return null;
	}

	@Override
	public int evaluate(String expression) {
		if(expression.equals(null)||expression.equals("")) {
			throw new RuntimeException();
		}
		String s[] = expression.split(" ");
		MyStack numbers = new MyStack();
		float num;
		float firstOperand;
		float secondOperand;
		for (int i = 0; i < s.length; i++) {
			if (Character.isDigit(s[i].charAt(0))) {
				num = Float.parseFloat(s[i]);
				numbers.push(num);
			} else if (s[i].charAt(0) == '*') {
				secondOperand = (float) numbers.pop();
				firstOperand = (float) numbers.pop();
				numbers.push(firstOperand * secondOperand);
			} else if (s[i].charAt(0) == '+') {
				secondOperand = (float) numbers.pop();
				firstOperand = (float) numbers.pop();
				numbers.push(firstOperand + secondOperand);
			} else if (s[i].charAt(0) == '-') {
				secondOperand = (float) numbers.pop();
				firstOperand = (float) numbers.pop();
				numbers.push(firstOperand - secondOperand);

			} else if (s[i].charAt(0) == '/') {
				secondOperand = (float) numbers.pop();
				firstOperand = (float) numbers.pop();
				numbers.push(firstOperand / secondOperand);
			}

		}
		float result =(float) numbers.peek();
		return Math.round(result);
	}

}
