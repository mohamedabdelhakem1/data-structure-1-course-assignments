package eg.edu.alexu.csd.datastructure.stack.cs44;

import eg.edu.alexu.csd.datastructure.stack.IExpressionEvaluator;

public class ExpressionEvaluator implements IExpressionEvaluator {

	@Override
	public String infixToPostfix(String expression) {
		if (expression.equals("")) {
			throw new RuntimeException();
		}
		String result = "";
		MyStack operators = new MyStack();
		String s[] = expression.split(" ");
		for (int i = 0; i < s.length; i++) {
			if (Character.isDigit(s[i].charAt(0)) || Character.isAlphabetic(s[i].charAt(0))) {
				result += s[i];
				result += " ";

			} else if (s[i].equals("*") || s[i].equals("/")) {

				if (operators.isEmpty() || operators.peek().equals("-") || operators.peek().equals("+")) {
					operators.push(s[i]);

				} else {
					try {
						while (operators.peek().equals("*") || operators.peek().equals("/")) {
							result += operators.pop();
							result += " ";

						}

					} catch (Exception e) {

					}
					operators.push(s[i]);
				}

			} else if (s[i].equals("-") || s[i].equals("+")) {
				if (operators.isEmpty()) {
					operators.push(s[i]);
				} else {
					while (operators.peek().equals("+") || operators.peek().equals("-") || operators.peek().equals("/")
							|| operators.peek().equals("*")) {
						result += operators.pop();
					}
					operators.push(s[i]);
				}

			} else if (s[i].charAt(0) == '(') {

				operators.push(s[i]);
			} else if (s[i].charAt(0) == ')') {

				try {
					while (!operators.peek().equals("(")) {
						result += operators.pop();
						result += " ";
					}
					operators.pop();
				} catch (Exception e) {

				}

			}

		}

	while(!operators.isEmpty())

	{
		result += operators.pop();
		if(!operators.isEmpty()) {
		result += " ";
		}
	}

	return result;
	}

	@Override
	public int evaluate(String expression) {
		if (expression.equals(null) || expression.equals("")) {
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

		float result = (float) numbers.peek();
		return Math.round(result);
	}

}
