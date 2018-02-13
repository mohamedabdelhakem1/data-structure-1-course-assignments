package eg.edu.alexu.csd.datastructure.calculator.cs44;

import eg.edu.alexu.csd.datastructure.calculator.ICalculator;


public class Calculator implements ICalculator{

	public int add(int x, int y) {
		return x + y;
	}

	
	public float divide(int x, int y) throws RuntimeException {
		return x / y;
	}

}
