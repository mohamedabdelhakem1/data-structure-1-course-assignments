package eg.edu.alexu.csd.datastructure.linkedList.cs44_cs65;

import eg.edu.alexu.csd.datastructure.linkedList.ILinkedList;

/**
 *
 * @author SHIKO
 *
 */
public class SingleLinkedList implements ILinkedList {
	/**
	 *
	 * @author SHIKO
	 *
	 */
	static class Snode {
		/**
		 *
		 */
		Object newElement;
		/**
		 *
		 */
		Snode nextElement;

		/**
		 *
		 * @param x .
		 * @param n .
		 */
		Snode(final Object x, final Snode n) {
			newElement = x;
			nextElement = n;

		}
	}

	/**
	 *
	 */
	int numberOfElements = 0;
	/**
	 *
	 */
	Snode head = null;

	@Override
	public void add(final int index, final Object element) {
		Snode node;
		node = head;
		int counter = 0;
		if (index == 0) {
			if (numberOfElements != 0) {
				Snode addedNode = new Snode(element, head);
				head = addedNode;
			} else {
				head = new Snode(element, null);
			}
			numberOfElements++;
		} else if (index <= numberOfElements && index > 0) {

			while (counter < (index - 1)) {
				node = node.nextElement;
				counter++;
			}
			Snode temp = node.nextElement;
			Snode addedNode = new Snode(element, temp);
			node.nextElement = addedNode;
			numberOfElements++;

		} else {
			throw new RuntimeException();
		}

	}

	@Override
	public void add(final Object element) {
		Snode node;
		if (element != null) {
			if (head == null) {

				head = new Snode(element, null);
				numberOfElements++;
			} else {
				node = head;
				while (node.nextElement != null) {
					node = node.nextElement;
				}
				node.nextElement = new Snode(element, null);
				numberOfElements++;

			}

		}
	}

	@Override
	public Object get(final int index) {
		Snode node = head;
		int counter = 0;

		if (index < numberOfElements && index >= 0) {
			while (counter < index) {
				node = node.nextElement;
				counter++;
			}
			return (node.newElement);
		}

		throw new RuntimeException();

	}

	@Override
	public void set(final int index, final Object element) {
		Snode node = head;
		int counter = 0;
		if (index < numberOfElements && index >= 0) {
			while (counter < index) {
				node = node.nextElement;
				counter++;
			}
			node.newElement = element;
			return;
		}
		throw new RuntimeException();

	}

	@Override
	public void clear() {

		head = null;
		numberOfElements = 0;
		return;

	}

	@Override
	public boolean isEmpty() {

		return (numberOfElements == 0);

	}

	@Override
	public void remove(final int index) {
		Snode node;
		node = head;
		int counter = 0;
		if (index == 0) {
			head = head.nextElement;
			numberOfElements--;
		} else if (index < numberOfElements && index >= 0) {

			while (counter < index - 1) {
				node = node.nextElement;
				counter++;
			}
			node.nextElement = node.nextElement.nextElement;

			numberOfElements--;
		} else {
			throw new RuntimeException();
		}

	}

	@Override
	public int size() {
		return numberOfElements;
	}

	@Override
	public ILinkedList sublist(final int fromIndex, final int toIndex) {
		SingleLinkedList list1 = new SingleLinkedList();
		Snode node = head;
		int counter = 0;
		if (head != null && fromIndex >= 0 && toIndex < numberOfElements
		&& toIndex >= fromIndex) {
			while (counter < fromIndex) {
				counter++;
				node = node.nextElement;
			}
			while (counter <= toIndex) {
				list1.add(node.newElement);
				node = node.nextElement;
				counter++;
			}
			return list1;
		}
		throw new RuntimeException();

	}

	@Override
	public boolean contains(final Object o) {
		Snode node;

		node = head;
		while (node != null) {
			if (node.newElement.equals(o)) {
				return true;
			}
			node = node.nextElement;
		}
		return false;

	}

}
