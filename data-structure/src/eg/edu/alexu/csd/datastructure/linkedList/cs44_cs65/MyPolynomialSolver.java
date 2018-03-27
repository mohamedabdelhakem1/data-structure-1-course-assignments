
package eg.edu.alexu.csd.datastructure.linkedList.cs44_cs65;

import java.awt.Point;

import eg.edu.alexu.csd.datastructure.linkedList.IPolynomialSolver;

public class MyPolynomialSolver implements IPolynomialSolver {
	SingleLinkedList A = new SingleLinkedList();
	SingleLinkedList B = new SingleLinkedList();
	SingleLinkedList C = new SingleLinkedList();
	SingleLinkedList R = new SingleLinkedList();

	public boolean ISEmpty(char poly) {
		if (poly == 'A') {
			return (A.isEmpty());
		} else if (poly == 'B') {
			return (B.isEmpty());
		} else if (poly == 'C') {
			return (C.isEmpty());
		}
		return false;
	}

	private void multiplication(SingleLinkedList s1, SingleLinkedList s2) {
		R.clear();
		for (int i = 0; i < s1.size(); i++) {
			for (int j = 0; j < s2.size(); j++) {
				Point p1 = (Point) s1.get(i);
				Point p2 = (Point) s2.get(j);

				Point pr = new Point();
				pr.x = p1.x * p2.x;
				pr.y = p1.y + p2.y;

				R = sort(R, R.size(), pr);
			}
		}
	}

	private void subtraction(SingleLinkedList s1, SingleLinkedList s2) {
		R.clear();
		SingleLinkedList visited = new SingleLinkedList();
		for (int i = 0; i < s1.size(); i++) {
			for (int j = 0; j < s2.size(); j++) {
				Point p1 = (Point) s1.get(i);
				Point p2 = (Point) s2.get(j);

				if (p1.y == p2.y) {
					Point pr = new Point();
					pr.x = p1.x - p2.x;
					pr.y = p1.y;
					R = sort(R, R.size(), pr);
					visited.add(p1.y);
				}

			}
		}
		for (int i = 0; i < s1.size(); i++) {
			Point p1 = (Point) s1.get(i);
			if (visited.contains(p1.y) == false) {
				R = sort(R, R.size(), p1);
			}
		}
		for (int i = 0; i < s2.size(); i++) {
			Point p2 = (Point) s2.get(i);
			int x = p2.x;
			x = -1 * x;

			if (visited.contains(p2.y) == false) {
				R = sort(R, R.size(), new Point(x, p2.y));
			}

		}

	}

	private void addition(SingleLinkedList s1, SingleLinkedList s2) {
		R.clear();
		SingleLinkedList visited = new SingleLinkedList();
		for (int i = 0; i < s1.size(); i++) {
			for (int j = 0; j < s2.size(); j++) {
				Point p1 = (Point) s1.get(i);
				Point p2 = (Point) s2.get(j);

				if (p1.y == p2.y) {
					Point pr = new Point();
					pr.x = p1.x + p2.x;
					pr.y = p1.y;
					R = sort(R, R.size(), pr);
					visited.add(p1.y);
				}

			}
		}
		for (int i = 0; i < s1.size(); i++) {
			Point p1 = (Point) s1.get(i);
			if (visited.contains(p1.y) == false) {
				R = sort(R, R.size(), p1);
			}
		}
		for (int i = 0; i < s2.size(); i++) {
			Point p1 = (Point) s2.get(i);
			if (visited.contains(p1.y) == false) {
				R = sort(R, R.size(), p1);
			}
		}

	}

	private SingleLinkedList sort(SingleLinkedList s, int i, Point p1) {
		boolean added = false;
		if (i > 0) {
			for (int j = 0; j < s.size(); j++) {
				Point p = (Point) s.get(j);

			/**	 if(p.x == 0) {
					 return s; }
*/
				if (p1.y > p.y) {
					s.add(j, p1);
					added = true;
					break;
				} else if (p1.y == p.y) {
					p.x += p1.x;
					s.remove(j);
					s.add(j, p);
					added = true;
					break;
				}
			}
		} else {
			s.add(p1);
		}
		if (added == false && i > 0) {
			s.add(p1);
		}
		return s;
	}

	@Override
	public void setPolynomial(char poly, int[][] terms) {
		if (poly == 'A') {
			if (!A.isEmpty()) {
				A.clear();
			}
			for (int i = 0; i < terms.length; i++) {
				Point p = new Point(terms[i][0], terms[i][1]);
				A = sort(A, i, p);
			}
		} else if (poly == 'B') {
			if (!B.isEmpty()) {
				B.clear();
			}
			for (int i = 0; i < terms.length; i++) {
				Point p = new Point(terms[i][0], terms[i][1]);
				B = sort(B, i, p);
			}
		} else if (poly == 'C') {
			if (!C.isEmpty()) {
				C.clear();
			}
			for (int i = 0; i < terms.length; i++) {
				Point p = new Point(terms[i][0], terms[i][1]);
				C = sort(C, i, p);
			}
		} else {
			throw new RuntimeException();

		}
	}

	@Override
	public String print(char poly) {
		String s = "";

		if (poly == 'A') {
			if (A.isEmpty()) {
				return null;
			}
			for (int i = 0; i < A.size(); i++) {
				Point p = (Point) A.get(i);
				if (p.x == 0) {
					/*
					 * if(A.size() == 1) { return "0"; }
					 */
					continue;
				} else if (p.x == -1) {
					s += '-';
				} else if (p.x != 1) {
					s += p.x;
				}

				if (p.y != 0) {
					if (p.y == 1) {
						s += "x";
					} else {
						s += "x^";
						s += p.y;
					}
				} else if (p.x == 1 || p.x == -1) {
					s += "1";

				}

				if (i != A.size() - 1) {
					Point p1 = (Point) A.get(i + 1);
					if (p1.x > 0) {
						s += "+";
					}
				}

			}
		} else if (poly == 'B') {
			if (B.isEmpty()) {
				return null;
			}

			for (int i = 0; i < B.size(); i++) {

				Point p = (Point) B.get(i);
				if (p.x == 0) {
					/*
					 * if(A.size() == 1) { return "0"; }
					 */
					continue;
				} else if (p.x == -1) {
					s += '-';
				} else if (p.x != 1) {
					s += p.x;
				}

				if (p.y != 0) {
					if (p.y == 1) {
						s += "x";
					} else {
						s += "x^";
						s += p.y;
					}
				} else if (p.x == 1 || p.x == -1) {
					s += "1";

				}

				if (i != B.size() - 1) {
					Point p1 = (Point) B.get(i + 1);
					if (p1.x > 0) {
						s += "+";
					}
				}
			}
		}

		else if (poly == 'C') {
			if (C.isEmpty()) {
				return null;
			}
			for (int i = 0; i < C.size(); i++) {
				Point p = (Point) C.get(i);
				if (p.x == 0) {
					/*
					 * if(A.size() == 1) { return "0"; }
					 */
					continue;
				} else if (p.x == -1) {
					s += '-';
				} else if (p.x != 1) {
					s += p.x;
				}

				if (p.y != 0) {
					if (p.y == 1) {
						s += "x";
					} else {
						s += "x^";
						s += p.y;
					}
				} else if (p.x == 1 || p.x == -1) {
					s += "1";

				}

				if (i != C.size() - 1) {
					Point p1 = (Point) C.get(i + 1);
					if (p1.x > 0) {
						s += "+";
					}
				}

			}
		}

		else if (poly == 'R') {
			if (R.isEmpty()) {
				return null;
			}
			for (int i = 0; i < R.size(); i++) {
				Point p = (Point) R.get(i);
				if (p.x == 0) {
					/*
					 * if(A.size() == 1) { return "0"; }
					 */
					continue;
				} else if (p.x == -1) {
					s += '-';
				} else if (p.x != 1) {
					s += p.x;
				}

				if (p.y != 0) {
					if (p.y == 1) {
						s += "x";
					} else {
						s += "x^";
						s += p.y;
					}
				} else if (p.x == 1 || p.x == -1) {
					s += "1";

				}

				if (i != R.size() - 1) {
					Point p1 = (Point) R.get(i + 1);
					if (p1.x > 0) {
						s += "+";
					}
				}

			}

		}  else {
			throw new RuntimeException();

		}
		return s;
	}

	@Override
	public void clearPolynomial(char poly) {
		if (poly == 'A') {
			A.clear();
		} else if (poly == 'B') {
			B.clear();
		} else if (poly == 'C') {
			C.clear();
		} else if (poly == 'R') {
			R.clear();
		} else {
				throw new RuntimeException();

			}

	}

	@Override
	public float evaluatePolynomial(char poly, float value) {

		float result = 0;
		if (poly == 'A') {
			if (A.isEmpty()) {
				throw new RuntimeException();
			} else {
				for (int i = 0; i < A.size(); i++) {
					Point p = (Point) A.get(i);
					result += (p.getX() * java.lang.Math.pow(value, p.getY()));
				}
			}
		} else if (poly == 'B') {
			if (B.isEmpty()) {
				throw new RuntimeException();
			} else {
				for (int i = 0; i < B.size(); i++) {
					Point p = (Point) B.get(i);
					result += (p.getX() * java.lang.Math.pow(value, p.getY()));

				}
			}
		} else if (poly == 'C') {
			if (C.isEmpty()) {
				throw new RuntimeException();
			} else {
				for (int i = 0; i < C.size(); i++) {
					Point p = (Point) C.get(i);
					result += (p.getX() * java.lang.Math.pow(value, p.getY()));
				}
			}
		} else if (poly == 'R') {
			if (R.isEmpty()) {
				throw new RuntimeException();
			} else {
				for (int i = 0; i < R.size(); i++) {
					Point p = (Point) R.get(i);
					result += (p.getX() * java.lang.Math.pow(value, p.getY()));

				}
			}
		}
	 else {
		throw new RuntimeException();

	}

		return result;
	}

	@Override
	public int[][] add(char poly1, char poly2) {

		if ((poly1 == 'A' && poly2 == 'B') || (poly1 == 'B' && poly2 == 'A')) {
			if (A.isEmpty() || B.isEmpty()) {
				throw new RuntimeException();
			} else {
				addition(A, B);
			}
		} else if ((poly1 == 'A' && poly2 == 'C') || (poly1 == 'C' && poly2 == 'A')) {
			if (A.isEmpty() || C.isEmpty()) {
				throw new RuntimeException();
			} else {
				addition(A, C);
			}
		} else if ((poly1 == 'C' && poly2 == 'B') || (poly1 == 'B' && poly2 == 'C')) {
			if (B.isEmpty() || C.isEmpty()) {
				throw new RuntimeException();
			} else {
				addition(C, B);
			}
		}  else if(poly1 == 'A' && poly2 == 'A'){
			if (A.isEmpty()) {

				throw new RuntimeException();
			} else {
				addition(A, A);
			}
		}  else if(poly1 == 'B' && poly2 == 'B'){
			if (B.isEmpty() ) {

				throw new RuntimeException();
			} else {
				addition(B, B);
			}
		}  else if(poly1 == 'C' && poly2 == 'C'){
			if (C.isEmpty() ) {

				throw new RuntimeException();
			} else {
				addition(C, C);
			}
		} else {

			throw new RuntimeException();

		}
		int[][] result = new int[R.size()][2];
		for (int i = 0; i < R.size(); i++) {
			Point p = (Point) R.get(i);
			result[i][0] = p.x;
			result[i][1] = p.y;
		}

		return result;
	}

	@Override
	public int[][] subtract(char poly1, char poly2) {
		if (poly1 == 'A' && poly2 == 'B') {
			if (A.isEmpty() || B.isEmpty()) {
				throw new RuntimeException();
			} else {
				subtraction(A, B);
			}
		} else if (poly1 == 'B' && poly2 == 'A') {
			if (A.isEmpty() || B.isEmpty()) {
				throw new RuntimeException();
			} else {
				subtraction(B, A);
			}
		} else if (poly1 == 'A' && poly2 == 'C') {
			if (A.isEmpty() || C.isEmpty()) {
				throw new RuntimeException();
			} else {
				subtraction(A, C);
			}
		} else if (poly1 == 'C' && poly2 == 'A') {
			if (A.isEmpty() || C.isEmpty()) {
				throw new RuntimeException();
			} else {
				subtraction(C, A);
			}
		} else if (poly1 == 'C' && poly2 == 'B') {
			if (B.isEmpty() || C.isEmpty()) {
				throw new RuntimeException();
			} else {
				subtraction(C, B);
			}
		} else if (poly1 == 'B' && poly2 == 'C') {
			if (C.isEmpty() || B.isEmpty()) {
				throw new RuntimeException();
			} else {
				subtraction(B, C);
			}
		} else if(poly1 == 'A' && poly2 == 'A'){
			if (A.isEmpty()) {

				throw new RuntimeException();
			} else {
				//subtraction(A, A);
				int[][] result = new int[1][2];
				result[0][0] = 0;
				result[0][1] = 0;
				return result;

			}
		} else if(poly1 == 'B' && poly2 == 'B'){
			if (B.isEmpty() ) {

				throw new RuntimeException();
			} else {
				//subtraction(B,B);
				int[][] result = new int[1][2];
				result[0][0] = 0;
				result[0][1] = 0;
				return result;
			}
		} else if(poly1 == 'C' && poly2 == 'C'){
			if (C.isEmpty() ) {

				throw new RuntimeException();
			} else {
				//subtraction(C, C);
				int[][] result = new int[1][2];
				result[0][0] = 0;
				result[0][1] = 0;
				return result;
			}
		} else {
			throw new RuntimeException();

		}
		int[][] result = new int[R.size()][2];
		for (int i = 0; i < R.size(); i++) {
			Point p = (Point) R.get(i);
			result[i][0] = p.x;
			result[i][1] = p.y;
		}
		return result;
	}

	@Override
	public int[][] multiply(char poly1, char poly2) {
		if ((poly1 == 'A' && poly2 == 'B') || (poly1 == 'B' && poly2 == 'A')) {
			if (A.isEmpty() || B.isEmpty()) {
				throw new RuntimeException();
			} else {
				multiplication(A, B);
			}
		} else if ((poly1 == 'A' && poly2 == 'C') || (poly1 == 'C' && poly2 == 'A')) {
			if (A.isEmpty() || C.isEmpty()) {
				throw new RuntimeException();
			} else {
				multiplication(A, C);
			}
		} else if ((poly1 == 'C' && poly2 == 'B') || (poly1 == 'B' && poly2 == 'C')) {
			if (C.isEmpty() || B.isEmpty()) {
				throw new RuntimeException();
			} else {
				multiplication(B, C);
			}
		} else if(poly1 == 'A' && poly2 == 'A'){
			if (A.isEmpty()) {

				throw new RuntimeException();
			} else {
				multiplication(A, A);
			}
		} else if(poly1 == 'B' && poly2 == 'B'){
			if (B.isEmpty() ) {

				throw new RuntimeException();
			} else {
				multiplication(B,B);
			}
		} else if(poly1 == 'C' && poly2 == 'C'){
			if (C.isEmpty() ) {

				throw new RuntimeException();
			} else {
				multiplication(C, C);
			}
		}
		else {
			throw new RuntimeException();

		}
		int[][] result = new int[R.size()][2];
		for (int i = 0; i < R.size(); i++) {
			Point p = (Point) R.get(i);
			result[i][0] = p.x;
			result[i][1] = p.y;
		}
		return result;
	}

}
