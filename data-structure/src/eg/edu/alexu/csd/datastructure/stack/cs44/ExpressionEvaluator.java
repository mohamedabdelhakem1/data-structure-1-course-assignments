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

		for (int i = 0; i < expression.length(); i++) {
			if (Character.isDigit(expression.charAt(i))) {
				String number = "";
				number += expression.charAt(i);
				i++;
				int len = 0;
				while (i < expression.length() && Character.isDigit(expression.charAt(i))) {
					number += expression.charAt(i);
					i++;
				}
				i--;
				result += number;
				result += " ";

			} else if (Character.isAlphabetic(expression.charAt(i))) {
				result += expression.charAt(i);
				result += " ";
			} else if (expression.charAt(i) == '*' || expression.charAt(i) == '/') {

				if (operators.isEmpty() || operators.peek().equals('-') || operators.peek().equals('+')) {
					operators.push(expression.charAt(i));

				} else {
					try {
						while (operators.peek().equals('*') || operators.peek().equals('/')) {
							result += operators.pop();
							result += " ";

						}

					} catch (Exception e) {

					}
					operators.push(expression.charAt(i));
				}

			} else if (expression.charAt(i) == '-' || expression.charAt(i) == '+') {
				if (operators.isEmpty()) {
					operators.push(expression.charAt(i));
				} else {
					try {
						while (operators.peek().equals('+') || operators.peek().equals('-')
								|| operators.peek().equals('/') || operators.peek().equals('*')) {
							result += operators.pop();
							result += " ";
						}

					} catch (Exception e) {
						// TODO: handle exception
					}

					operators.push(expression.charAt(i));
				}

			} else if (expression.charAt(i) == '(') {

				operators.push(expression.charAt(i));
			} else if (expression.charAt(i) == ')') {

				try {
					while (!operators.peek().equals('(')) {
						result += operators.pop();
						result += " ";
					}
					operators.pop();
				} catch (Exception e) {

				}

			}

		}

		while (!operators.isEmpty())

		{
			result += operators.pop();
			if (!operators.isEmpty()) {
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
