package eg.edu.alexu.csd.datastructure.stack.cs44;

import java.util.Scanner;
/**
 *
 * @author SHIKO
 *
 */
public class MainTest {
	/**
	 *
	 * @param args .
	 */
	public static void main(final String[] args) {
		/**
		 *
		 */
		ExpressionEvaluator x = new ExpressionEvaluator();
		/**
		 *
		 */
		Scanner s = new Scanner(System.in);

		System.out.println("enter the expression");
		String str = s.nextLine();
		System.out.println("enter 1 to evaluate the expression");
		System.out.println("enter 2 to convert the expression");
		/**
		 *
		 */
		int input = s.nextInt();
		if (input == 1) {
			try {
				System.out.println(x.evaluate(str));
			} catch (Exception e) {
				System.out.println("invalid expression");
			}
		} else if (input == 2) {
			try {
				System.out.println(x.infixToPostfix(str));
			} catch (Exception e) {
				System.out.println("invalid expression");
			}
		}



	}




}
