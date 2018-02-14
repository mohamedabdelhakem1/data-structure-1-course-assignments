package eg.edu.alexu.csd.datastructure.calculator.cs44;

import eg.edu.alexu.csd.datastructure.calculator.ICalculator;
/**
 *
 * @author SHiko
 *
 */

public class Calculator implements ICalculator {

	@Override
	public int add(int x, int y) {
		return 	(x + y);
	}

	@Override
	public float divide(int x, int y) throws RuntimeException  {
		if (y == 0) {
			throw new RuntimeException("'Division by zero!'!");
			}
		return (float) x / (float) y;
	}
}

