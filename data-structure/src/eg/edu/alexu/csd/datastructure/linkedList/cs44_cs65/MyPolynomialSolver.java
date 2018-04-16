
package eg.edu.alexu.csd.datastructure.linkedList.cs44_cs65;

import java.awt.Point;

import eg.edu.alexu.csd.datastructure.linkedList.IPolynomialSolver;

public class MyPolynomialSolver implements IPolynomialSolver {
	SingleLinkedList a = new SingleLinkedList();
	SingleLinkedList b = new SingleLinkedList();
	SingleLinkedList c = new SingleLinkedList();
	SingleLinkedList r = new SingleLinkedList();

	public boolean ISEmpty(final char poly) {
		if (poly == 'A') {
			return (a.isEmpty());
		} else if (poly == 'B') {
			return (b.isEmpty());
		} else if (poly == 'C') {
			return (c.isEmpty());
		}
		return false;
	}

	private void multiplication(final SingleLinkedList s1,
	final SingleLinkedList s2) {
		r.clear();
		for (int i = 0; i < s1.size(); i++) {
			for (int j = 0; j < s2.size(); j++) {
				Point p1 = (Point) s1.get(i);
				Point p2 = (Point) s2.get(j);

				Point pr = new Point();
				pr.x = p1.x * p2.x;
				pr.y = p1.y + p2.y;

				r = sort(r, r.size(), pr);
			}
		}
	}

	private void subtraction(final SingleLinkedList s1,
	final SingleLinkedList s2) {
		r.clear();

		SingleLinkedList visited = new SingleLinkedList();
		for (int i = 0; i < s1.size(); i++) {
			for (int j = 0; j < s2.size(); j++) {
				Point p1 = (Point) s1.get(i);
				Point p2 = (Point) s2.get(j);

				if (p1.y == p2.y) {
					Point pr = new Point();
					pr.x = p1.x - p2.x;
					if (pr.x == 0) {
						pr.y = 0;
					} else {

						pr.y = p1.y;
					}
					r = sort(r, r.size(), pr);
					visited.add(p1.y);
				}

			}
		}
		for (int i = 0; i < s1.size(); i++) {
			Point p1 = (Point) s1.get(i);
			if (visited.contains(p1.y) == false) {
				r = sort(r, r.size(), p1);
			}
		}
		for (int i = 0; i < s2.size(); i++) {
			Point p2 = (Point) s2.get(i);
			int x = p2.x;
			x = -1 * x;

			if (visited.contains(p2.y) == false) {
				r = sort(r, r.size(), new Point(x, p2.y));
			}

		}

		for (int f = 0; f < r.size(); f++) {
			Point pon = (Point) r.get(f);
			if (pon.x == 0) {
				r.remove(f);
			}

		}
		if (r.size() == 0) {
			Point pr = new Point(0, 0);
			r.add(pr);

		}
	}

	private void addition(final SingleLinkedList s1,
	final SingleLinkedList s2) {
		r.clear();

		SingleLinkedList visited = new SingleLinkedList();
		for (int i = 0; i < s1.size(); i++) {
			for (int j = 0; j < s2.size(); j++) {
				Point p1 = (Point) s1.get(i);
				Point p2 = (Point) s2.get(j);

				if (p1.y == p2.y) {
					Point pr = new Point();
					pr.x = p1.x + p2.x;
					pr.y = p1.y;
					if (pr.x == 0) {
						pr.y = 0;
					} else {

						pr.y = p1.y;
					}
					r = sort(r, r.size(), pr);
					visited.add(p1.y);
				}

			}
		}
		for (int i = 0; i < s1.size(); i++) {
			Point p1 = (Point) s1.get(i);
			if (visited.contains(p1.y) == false) {
				r = sort(r, r.size(), p1);
			}
		}
		for (int i = 0; i < s2.size(); i++) {
			Point p1 = (Point) s2.get(i);
			if (visited.contains(p1.y) == false) {
				r = sort(r, r.size(), p1);
			}
		}
		for (int f = 0; f < r.size(); f++) {
			Point pon = (Point) r.get(f);
			if (pon.x == 0) {
				r.remove(f);
			}

		}
		if (r.size() == 0) {
			Point pr = new Point(0, 0);
			r.add(pr);

		}
	}

	private SingleLinkedList sort(final SingleLinkedList s, final int i,
	final Point p1) {
		boolean added = false;
		if (i > 0) {
			for (int j = 0; j < s.size(); j++) {
				Point p = (Point) s.get(j);

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
	public void setPolynomial(final char poly, final int[][] terms) {
		if (poly == 'A') {
			if (!a.isEmpty()) {
				a.clear();
			}
			for (int i = 0; i < terms.length; i++) {
				Point p = new Point(terms[i][0], terms[i][1]);
				a = sort(a, i, p);
			}
		} else if (poly == 'B') {
			if (!b.isEmpty()) {
				b.clear();
			}
			for (int i = 0; i < terms.length; i++) {
				Point p = new Point(terms[i][0], terms[i][1]);
				b = sort(b, i, p);
			}
		} else if (poly == 'C') {
			if (!c.isEmpty()) {
				c.clear();
			}
			for (int i = 0; i < terms.length; i++) {
				Point p = new Point(terms[i][0], terms[i][1]);
				c = sort(c, i, p);
			}
		} else {
			throw new RuntimeException();

		}
	}

	@Override
	public String print(final char poly) {
		String s = "";

		if (poly == 'A') {
			if (a.isEmpty()) {
				return null;
			}
			for (int i = 0; i < a.size(); i++) {
				Point p = (Point) a.get(i);
				if (p.x == 0) {

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

				if (i != a.size() - 1) {
					Point p1 = (Point) a.get(i + 1);
					if (p1.x > 0) {
						s += "+";
					}
				}

			}
		} else if (poly == 'B') {
			if (b.isEmpty()) {
				return null;
			}

			for (int i = 0; i < b.size(); i++) {

				Point p = (Point) b.get(i);
				if (p.x == 0) {

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

				if (i != b.size() - 1) {
					Point p1 = (Point) b.get(i + 1);
					if (p1.x > 0) {
						s += "+";
					}
				}
			}
		}

		else if (poly == 'C') {
			if (c.isEmpty()) {
				return null;
			}
			for (int i = 0; i < c.size(); i++) {
				Point p = (Point) c.get(i);
				if (p.x == 0) {

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

				if (i != c.size() - 1) {
					Point p1 = (Point) c.get(i + 1);
					if (p1.x > 0) {
						s += "+";
					}
				}

			}
		}

		else if (poly == 'R') {
			if (r.isEmpty()) {
				return null;
			}
			for (int i = 0; i < r.size(); i++) {
				Point p = (Point) r.get(i);
				if (p.x == 0) {

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

				if (i != r.size() - 1) {
					Point p1 = (Point) r.get(i + 1);
					if (p1.x > 0) {
						s += "+";
					}
				}

			}

		} else {
			throw new RuntimeException();

		}
		return s;
	}

	@Override
	public void clearPolynomial(final char poly) {
		if (poly == 'A') {
			a.clear();
		} else if (poly == 'B') {
			b.clear();
		} else if (poly == 'C') {
			c.clear();
		} else if (poly == 'R') {
			r.clear();
		} else {
			throw new RuntimeException();

		}

	}

	@Override
	public float evaluatePolynomial(final char poly, final float value) {

		float result = 0;
		if (poly == 'A') {
			if (a.isEmpty()) {
				throw new RuntimeException();
			} else {
				for (int i = 0; i < a.size(); i++) {
					Point p = (Point) a.get(i);
					result += (p.getX() * java.lang.Math.pow(value, p.getY()));
				}
			}
		} else if (poly == 'B') {
			if (b.isEmpty()) {
				throw new RuntimeException();
			} else {
				for (int i = 0; i < b.size(); i++) {
					Point p = (Point) b.get(i);
					result += (p.getX() * java.lang.Math.pow(value, p.getY()));

				}
			}
		} else if (poly == 'C') {
			if (c.isEmpty()) {
				throw new RuntimeException();
			} else {
				for (int i = 0; i < c.size(); i++) {
					Point p = (Point) c.get(i);
					result += (p.getX() * java.lang.Math.pow(value, p.getY()));
				}
			}
		} else if (poly == 'R') {
			if (r.isEmpty()) {
				throw new RuntimeException();
			} else {
				for (int i = 0; i < r.size(); i++) {
					Point p = (Point) r.get(i);
					result += (p.getX() * java.lang.Math.pow(value, p.getY()));

				}
			}
		} else {
			throw new RuntimeException();

		}

		return result;
	}

	@Override
	public int[][] add(final char poly1, final char poly2) {

		if ((poly1 == 'A' && poly2 == 'B') || (poly1 == 'B' && poly2 == 'A')) {
			if (a.isEmpty() || b.isEmpty()) {
				throw new RuntimeException();
			} else {
				addition(a, b);
			}
		} else if ((poly1 == 'A' && poly2 == 'C')
		|| (poly1 == 'C' && poly2 == 'A')) {
			if (a.isEmpty() || c.isEmpty()) {
				throw new RuntimeException();
			} else {
				addition(a, c);
			}
		} else if ((poly1 == 'C' && poly2 == 'B')
		|| (poly1 == 'B' && poly2 == 'C')) {
			if (b.isEmpty() || c.isEmpty()) {
				throw new RuntimeException();
			} else {
				addition(c, b);
			}
		} else if (poly1 == 'A' && poly2 == 'A') {
			if (a.isEmpty()) {

				throw new RuntimeException();
			} else {
				addition(a, a);
			}
		} else if (poly1 == 'B' && poly2 == 'B') {
			if (b.isEmpty()) {

				throw new RuntimeException();
			} else {
				addition(b, b);
			}
		} else if (poly1 == 'C' && poly2 == 'C') {
			if (c.isEmpty()) {

				throw new RuntimeException();
			} else {
				addition(c, c);
			}
		} else {

			throw new RuntimeException();

		}
		int[][] result = new int[r.size()][2];
		for (int i = 0; i < r.size(); i++) {
			Point p = (Point) r.get(i);
			result[i][0] = p.x;
			result[i][1] = p.y;
		}

		return result;
	}

	@Override
	public int[][] subtract(final char poly1, final char poly2) {
		if (poly1 == 'A' && poly2 == 'B') {
			if (a.isEmpty() || b.isEmpty()) {
				throw new RuntimeException();
			} else {
				subtraction(a, b);
			}
		} else if (poly1 == 'B' && poly2 == 'A') {
			if (a.isEmpty() || b.isEmpty()) {
				throw new RuntimeException();
			} else {
				subtraction(b, a);
			}
		} else if (poly1 == 'A' && poly2 == 'C') {
			if (a.isEmpty() || c.isEmpty()) {
				throw new RuntimeException();
			} else {
				subtraction(a, c);
			}
		} else if (poly1 == 'C' && poly2 == 'A') {
			if (a.isEmpty() || c.isEmpty()) {
				throw new RuntimeException();
			} else {
				subtraction(c, a);
			}
		} else if (poly1 == 'C' && poly2 == 'B') {
			if (b.isEmpty() || c.isEmpty()) {
				throw new RuntimeException();
			} else {
				subtraction(c, b);
			}
		} else if (poly1 == 'B' && poly2 == 'C') {
			if (c.isEmpty() || b.isEmpty()) {
				throw new RuntimeException();
			} else {
				subtraction(b, c);
			}
		} else if (poly1 == 'A' && poly2 == 'A') {
			if (a.isEmpty()) {

				throw new RuntimeException();
			} else {
				subtraction(a, a);

			}
		} else if (poly1 == 'B' && poly2 == 'B') {
			if (b.isEmpty()) {

				throw new RuntimeException();
			} else {
				subtraction(b, b);

			}
		} else if (poly1 == 'C' && poly2 == 'C') {
			if (c.isEmpty()) {

				throw new RuntimeException();
			} else {
				subtraction(c, c);

			}
		} else {
			throw new RuntimeException();

		}
		int[][] result = new int[r.size()][2];
		for (int i = 0; i < r.size(); i++) {
			Point p = (Point) r.get(i);
			result[i][0] = p.x;
			result[i][1] = p.y;
		}
		return result;
	}

	@Override
	public int[][] multiply(final char poly1, final char poly2) {
		if ((poly1 == 'A' && poly2 == 'B') || (poly1 == 'B' && poly2 == 'A')) {
			if (a.isEmpty() || b.isEmpty()) {
				throw new RuntimeException();
			} else {
				multiplication(a, b);
			}
		} else if ((poly1 == 'A' && poly2 == 'C')
		|| (poly1 == 'C' && poly2 == 'A')) {
			if (a.isEmpty() || c.isEmpty()) {
				throw new RuntimeException();
			} else {
				multiplication(a, c);
			}
		} else if ((poly1 == 'C' && poly2 == 'B')
		|| (poly1 == 'B' && poly2 == 'C')) {
			if (c.isEmpty() || b.isEmpty()) {
				throw new RuntimeException();
			} else {
				multiplication(b, c);
			}
		} else if (poly1 == 'A' && poly2 == 'A') {
			if (a.isEmpty()) {

				throw new RuntimeException();
			} else {
				multiplication(a, a);
			}
		} else if (poly1 == 'B' && poly2 == 'B') {
			if (b.isEmpty()) {

				throw new RuntimeException();
			} else {
				multiplication(b, b);
			}
		} else if (poly1 == 'C' && poly2 == 'C') {
			if (c.isEmpty()) {

				throw new RuntimeException();
			} else {
				multiplication(c, c);
			}
		} else {
			throw new RuntimeException();

		}
		int[][] result = new int[r.size()][2];
		for (int i = 0; i < r.size(); i++) {
			Point p = (Point) r.get(i);
			result[i][0] = p.x;
			result[i][1] = p.y;
		}
		return result;
	}

}
