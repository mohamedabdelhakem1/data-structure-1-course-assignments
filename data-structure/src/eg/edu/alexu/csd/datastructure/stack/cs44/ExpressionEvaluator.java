package eg.edu.alexu.csd.datastructure.stack.cs44;

import eg.edu.alexu.csd.datastructure.stack.IExpressionEvaluator;

/**
 * The Class ExpressionEvaluator.
 *
 * @author MOHAMED
 */
public class ExpressionEvaluator implements IExpressionEvaluator {

	/**
	 * this method converts infix to postfix
	 *
	 * @param expression
	 *            String to be converted from infix to postfix
	 * @return Result postfix string
	 * @throws RuntimeException
	 *             if the string is empty or the number of operators is not
	 *             equal to (the number of operand - 1)
	 */
	@Override
	public String infixToPostfix(final String expression) {
		if (expression.equals("") || expression.equals(null)) {
			throw new RuntimeException();
		}
		/**
		 * StringBuilder result append the characters of the postfix expression
		 */
		StringBuilder result = new StringBuilder();
		/**
		 * MyStack operators used to store the operators during conversion
		 */
		MyStack operators = new MyStack();
		/**
		 * int value of the number of operands
		 */
		int numofoperands = 0;
		/**
		 * int value of the number of operators
		 */
		int numofoperators = 0;
		/**
		 * int number of right parentheses
		 */
		int numbOfLeft = 0;
		/**
		 * int number of left parentheses
		 */
		int numOfRight = 0;

		for (int i = 0; i < expression.length(); i++) {
			if (Character.isDigit(expression.charAt(i))) {
				numofoperands++;
				/**
				 * String value store each operands
				 */
				String number = "";

				number += expression.charAt(i);
				i++;

				while (i < expression.length()
				&& Character.isDigit(expression.charAt(i))) {

					number += expression.charAt(i);
					i++;
				}
				i--;

				result.append(number);
				result.append(" ");

			} else if (Character.isAlphabetic(
			expression.charAt(i))) {
				numofoperands++;
				result.append(expression.charAt(i));
				result.append(" ");

			} else if (expression.charAt(i) == '*'
			|| expression.charAt(i) == '/') {
				numofoperators++;
				if (operators.isEmpty()
				|| operators.peek().equals('-')
				|| operators.peek().equals('+')) {
					operators.push(expression.charAt(i));

				} else {
					try {
						while (operators.peek().equals('*')
						|| operators.peek().equals('/')) {
							result.append(operators.pop());
							result.append(" ");

						}

					} catch (Exception e) {
						// TODO: handle exception
					}
					operators.push(expression.charAt(i));
				}

			} else if (expression.charAt(i) == '-'
			|| expression.charAt(i) == '+') {
				numofoperators++;
				if (operators.isEmpty()) {
					operators.push(expression.charAt(i));
				} else {
					try {
						while (operators.peek().equals('+')
						|| operators.peek().equals('-')
						|| operators.peek().equals('/')
						|| operators.peek().equals('*')) {
							result.append(operators.pop());
							result.append(" ");

						}

					} catch (Exception e) {
						// TODO: handle exception
					}

					operators.push(expression.charAt(i));
				}

			} else if (expression.charAt(i) == '(') {
				numbOfLeft++;
				operators.push(expression.charAt(i));
			} else if (expression.charAt(i) == ')') {
				numOfRight++;
				try {
					while (!operators.peek().equals('(')) {
						result.append(operators.pop());
						result.append(" ");

					}
					operators.pop();
				} catch (Exception e) {
					// TODO: handle exception
				}

			}

		}

		while (!operators.isEmpty()) {
			result.append(operators.pop());

			if (!operators.isEmpty()) {
				result.append(" ");
			}
		}
		if (numofoperands - 1 != numofoperators) {
			throw new RuntimeException();
		}
		if (numbOfLeft != numOfRight) {
			throw new RuntimeException();
		}
		return result.toString();
	}

	/**
	 * this method evaluate postfix operations
	 *
	 * @param expression
	 * @return result after rounding the value
	 * @throws RuntimeException
	 *             if the string is empty
	 */
	@Override
	public int evaluate(final String expression) {
		if (expression.equals(null) || expression.equals("")) {
			throw new RuntimeException();
		}
		/**
		 * array of strings of numbers and operators
		 */
		String[] s = expression.split(" ");
		/**
		 * MyStack stores the operands before evaluation
		 */
		MyStack numbers = new MyStack();
		/**
		 * float value of string number
		 */
		float num;
		/**
		 * float value of first operand
		 */
		float firstOperand;
		/**
		 * float value of second operand
		 */
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
		/**
		 * float value of the expression result
		 */
		float result = (float) numbers.peek();
		return Math.round(result);
	}

}
