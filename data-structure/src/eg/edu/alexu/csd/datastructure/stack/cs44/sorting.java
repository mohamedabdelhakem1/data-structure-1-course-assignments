/**
 *
 */
package eg.edu.alexu.csd.datastructure.stack.cs44;

/**
 * @author SHIKO
 *
 */
public class sorting {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MyStack x = new MyStack();
		MyStack sorted = new MyStack();

		MyStack reversed = new MyStack();
		x.push(3);
		x.push(10);
		x.push(2);
		x.push(1);
		x.push(5);
		x.push(4);
		x.push(11);
		x.push(15);
		x.push(7);
		x.push(8);
		x.push(6);
		while (!x.isEmpty()) {
			int a = (int) x.pop();
			reversed.push(a);
			if (!sorted.isEmpty()) {
				int b = (int) sorted.peek();

				if (a <= b) {
					sorted.push(a);

				} else {
					int z=0;
					while (a > b) {
						x.push(sorted.pop());
						z++;
						if (!sorted.isEmpty()) {
							b = (int) sorted.peek();
						} else {
							break;
						}
					}
					sorted.push(a);
					while (z > 0) {
						sorted.push(x.pop());
						z--;
					}
				}

			} else {
				sorted.push(a);
			}

		}
		while (!reversed.isEmpty()) {
			x.push(reversed.pop());

		}
		while (!sorted.isEmpty()) {
			System.out.println(sorted.pop());
		}

	}

}
