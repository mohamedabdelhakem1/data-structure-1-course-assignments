package eg.edu.alexu.csd.datastructure.linkedList.cs44_cs65;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class MyPolynomialSolverTest {

	@Test
	public void testSolveSubtracte() {
		MyPolynomialSolver instance = new MyPolynomialSolver();
		instance.setPolynomial('C', new int[][] { { 3, 7 }, { 45, 5 }, { 176, 3 }, { 128, 1 } });
		instance.setPolynomial('B', new int[][] { { -120, 5 }, { -1, 3 }, { 27, 2 }, { 1, 1 }, { -1, 0 } });

		assertNull("Polynomial R is not set yet", instance.print('R'));
		int[][] result1 = instance.subtract('C', 'B');
		assertNotNull("Polynomial R must be set after evaluation", instance.print('R'));
		int[][] expected = new int[][] { { 3, 7 }, { 165, 5 }, { 177, 3 }, { -27, 2 }, { 127, 1 }, { 1, 0 } };
		assertArrayEquals(expected, result1);
	}

	@Test
	public void testprint1() {
		MyPolynomialSolver instance = new MyPolynomialSolver();
		instance.setPolynomial('C', new int[][] { { 3, 7 }, { 45, 5 }, { 176, 3 }, { 128, 1 } });
		assertEquals(instance.print('C'), "3x^7+45x^5+176x^3+128x");

	}

	@Test
	public void testprint2() {
		MyPolynomialSolver instance = new MyPolynomialSolver();
		instance.setPolynomial('C', new int[][] { { -120, 5 }, { -1, 3 }, { 27, 2 }, { 1, 1 }, { -1, 0 } });
		assertEquals(instance.print('C'), "-120x^5-x^3+27x^2+x-1");

	}

	@Test
	public void testprint3() {
		MyPolynomialSolver instance = new MyPolynomialSolver();
		instance.setPolynomial('C', new int[][] {});
		assertEquals(instance.print('C'), null);

	}

	@Test
	public void testmultiply() {
		MyPolynomialSolver instance = new MyPolynomialSolver();
		instance.setPolynomial('C', new int[][] { { 3, 7 }, { 45, 5 } });
		instance.setPolynomial('B', new int[][] { { -120, 5 }, { -1, 3 } });
		int[][] result1 = instance.multiply('B', 'C');
		int[][] expected = new int[][] { { -360, 12 }, { -5403, 10 }, { -45, 8 } };
		assertEquals(instance.print('R'), "-360x^12-5403x^10-45x^8");
		assertArrayEquals(result1, expected);
	}

	@Test
	public void testSolveAdd() {
		MyPolynomialSolver instance = new MyPolynomialSolver();
		instance.setPolynomial('C', new int[][] { { 3, 7 }, { 45, 5 }, { 176, 3 }, { 128, 1 } });
		instance.setPolynomial('B', new int[][] { { -120, 5 }, { -1, 3 }, { 27, 2 }, { 1, 1 }, { -1, 0 } });
		assertNull("Polynomial R is not set yet", instance.print('R'));
		int[][] result1 = instance.add('B', 'C');
		assertNotNull("Polynomial R must be set after evaluation", instance.print('R'));
		int[][] expected = new int[][] { { 3, 7 }, { -75, 5 }, { 175, 3 }, { 27, 2 }, { 129, 1 }, { -1, 0 } };
		assertArrayEquals(expected, result1);
	}
/*	@Test
	public void testSolveAdd2() {
		MyPolynomialSolver instance = new MyPolynomialSolver();
		instance.setPolynomial('C', new int[][] { { 3, 7 }, { 45, 5 }, { 176, 3 }, { 128, 1 } });
		instance.setPolynomial('B', new int[][] {{ 3, 7 }, { 45, 5 }, { 176, 3 }, { 128, 1 } });
		assertNull("Polynomial R is not set yet", instance.print('R'));
		int[][] result1 = instance.subtract('B', 'C');
		assertNotNull("Polynomial R must be set after evaluation", instance.print('R'));
		int[][] expected = new int[][] { {0,0}};
		assertArrayEquals(expected, result1);
	}*/
}
