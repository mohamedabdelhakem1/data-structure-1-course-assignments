/**
 *
 */
package eg.edu.alexu.csd.datastructure.stack.cs44;

/**
 * @author SHIKO
 *
 */
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ExpressionEvaluator x = new ExpressionEvaluator();

		System.out.println(x.infixToPostfix("( 300 + 23 ) * ( 43 - 21 ) / ( 84 + 7 )"));
    	System.out.println(x.infixToPostfix("3 + 4 * 5 / 6"));
		System.out.println(x.infixToPostfix("( 4 + 8 ) * ( 6 - 5 ) / ( ( 3 - 2 ) * ( 2 + 2 ) )"));
		System.out.println(x.infixToPostfix("1 2 + 7 *"));

		System.out.println(x.infixToPostfix("( a / (b - c + d) * (e - a) * c )"));
		System.out.println(x.infixToPostfix("a * ( b + c ) * d"));

	}

}
