package eg.edu.alexu.csd.datastructure.calculator.cs44;

import eg.edu.alexu.csd.datastructure.calculator.ICalculator;
/**
 *
 * @author SHiko
 *
 */

public class Calculator implements ICalculator {

	@Override
	public int add(final int x, final int y) {
		return 	(x + y);
	}

	@Override
	public float divide(final int x, final int y)  {
		if (y == 0) {
			throw new RuntimeException("Division by zero!");
			}
		return (float) x / (float) y;
	}
}

