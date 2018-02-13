package eg.edu.alexu.csd.datastructure.calculator.cs44;

import eg.edu.alexu.csd.datastructure.calculator.ICalculator;


public class Calculator implements ICalculator {

	@Override
	public int add(int x, int y) {
		// TODO Auto-generated method stub
		return x + y;
	}

	@Override
	public float divide(int x, int y) throws RuntimeException {
		// TODO Auto-generated method stub
		if (y==0)
		{ throw new RuntimeException("Division by zero!");}
		return (float)x / (float)y;
	
		
	}
	
	
}

