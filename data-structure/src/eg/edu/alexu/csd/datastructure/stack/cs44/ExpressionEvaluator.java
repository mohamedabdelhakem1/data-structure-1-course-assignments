package eg.edu.alexu.csd.datastructure.stack.cs44;

import eg.edu.alexu.csd.datastructure.stack.IExpressionEvaluator;

public class ExpressionEvaluator implements IExpressionEvaluator {

	@Override
	public String infixToPostfix(String expression) {

		return null;
	}

	@Override
	public int evaluate(String expression) {
		String s[] = expression.split(" ");
		MyStack numbers = new MyStack();
		int num;
		int firstOperand;
		int secondOperand;
		for (int i = 0; i < s.length; i++) {
			if (Character.isDigit(s[i].charAt(0))) {
				num = Integer.parseInt(s[i]);
				numbers.push(num);
			} else if (s[i].charAt(0) == '*') {
				secondOperand = (int) numbers.pop();
				firstOperand = (int) numbers.pop();
				numbers.push(firstOperand * secondOperand);
			} else if (s[i].charAt(0) == '+') {
				secondOperand = (int) numbers.pop();
				firstOperand = (int) numbers.pop();
				numbers.push(firstOperand + secondOperand);
			} else if (s[i].charAt(0) == '-') {
				secondOperand = (int) numbers.pop();
				firstOperand = (int) numbers.pop();
				numbers.push(firstOperand - secondOperand);

			} else if (s[i].charAt(0) == '/') {
				secondOperand = (int) numbers.pop();
				firstOperand = (int) numbers.pop();
				numbers.push(firstOperand / secondOperand);
			}

		}
		return (int)numbers.peek();
	}

}
