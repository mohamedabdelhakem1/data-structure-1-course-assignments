package eg.edu.alexu.csd.datastructure.linkedList.cs44_cs65;

import eg.edu.alexu.csd.datastructure.linkedList.ILinkedList;

public class DoubleLinkedList implements ILinkedList {
	static class dnode {
		Object newElement;
		dnode nextElement;
		dnode prevElement;

		dnode(final Object x, final dnode next, final dnode prev) {
			newElement = x;
			nextElement = next;
			prevElement = prev;

		}
	}

	dnode head = null;
	dnode tail = null;

	int numberOfelements = 0;

	@Override
	public void add(final int index, final Object element) {
		dnode node;

		int counter;
		// index before the middle
		if (index <= (numberOfelements / 2)) {

			node = head;
			counter = 0;
			if (index == 0) {

				if (numberOfelements != 0) {

					dnode addednode = new dnode(element, head, null);
					head.prevElement = addednode;
					head = addednode;

				} else {

					head = new dnode(element, null, null);
					tail = head;

				}
				numberOfelements++;
				return;
			} else if (index < numberOfelements && index > 0) {

				while (counter < index) {
					node = node.nextElement;
					counter++;
				}
				dnode addedNode = new dnode(element, node, node.prevElement);
				node.prevElement = addedNode;
				(addedNode.prevElement).nextElement = addedNode;
				numberOfelements++;
				return;
			}

		} else {
			node = tail;
			counter = numberOfelements - 1;
			if (index == numberOfelements) {
				dnode addedNode = new dnode(element, null, tail);
				tail.nextElement = addedNode;
				tail = addedNode;
				numberOfelements++;
				return;
			} else if (index <= numberOfelements && index > 0) {

				while (counter != index) {
					node = node.prevElement;
					counter--;
				}
				dnode addedNode = new dnode(element, node, node.prevElement);
				node.prevElement = addedNode;
				(addedNode.prevElement).nextElement = addedNode;
				numberOfelements++;
				return;

			}

		}
		throw new RuntimeException();

	}

	@Override
	public void add(final Object element) {

		dnode node;
		if (element != null) {
			if (head == null && tail == null) {

				head = new dnode(element, null, null);
				tail = head;
				numberOfelements++;
			} else {
				node = tail;
				node.nextElement = new dnode(element, null, node);
				tail = node.nextElement;
				node.nextElement = tail;
				numberOfelements++;

			}

		}

	}

	@Override
	public Object get(final int index) {
		dnode node;
		int counter;
		if (index <= (numberOfelements / 2)) {
			node = head;
			counter = 0;
			if (index < numberOfelements && index >= 0) {
				while (counter < index) {
					node = node.nextElement;
					counter++;
				}
				return (node.newElement);
			}

		} else {
			node = tail;
			counter = numberOfelements - 1;
			if (index < numberOfelements && index >= 0) {
				while (counter != index) {
					node = node.prevElement;
					counter--;
				}
				return (node.newElement);

			}
		}

		throw new RuntimeException();
	}

	@Override
	public void set(final int index, final Object element) {
		dnode node;
		int counter;
		if (index <= (numberOfelements / 2) && index >= 0) {
			node = head;
			counter = 0;
			while (counter < index) {
				node = node.nextElement;
				counter++;
			}
			node.newElement = element;
			return;

		} else if (index < numberOfelements && index >= 0) {
			node = tail;
			counter = numberOfelements - 1;

			while (counter != index) {
				node = node.prevElement;
				counter--;
			}
			node.newElement = element;
			return;

		}

		throw new RuntimeException();

	}

	@Override
	public void clear() {
		head = null;
		tail = null;
		numberOfelements = 0;
		return;

	}

	@Override
	public boolean isEmpty() {

		return (numberOfelements == 0);
	}

	@Override
	public void remove(final int index) {
		dnode node;
		int counter;
		if (index == 0) {
			head = head.nextElement;
			node = head.nextElement;
			node.prevElement = null;
			numberOfelements--;
			return;
		} else if (index == numberOfelements - 1) {
			tail = tail.prevElement;
			node = tail.prevElement;
			node.nextElement = null;
			numberOfelements--;
			return;

		} else if (index <= (numberOfelements / 2) && index > 0) {
			node = head;
			counter = 0;

			while (counter < index) {
				node = node.nextElement;
				counter++;
			}
			node.nextElement.prevElement = node.prevElement;
			node.prevElement.nextElement = node.nextElement;
			numberOfelements--;
			return;

		} else if (index < numberOfelements && index >= 0) {
			node = tail;
			counter = numberOfelements - 1;

			while (counter != index) {
				node = node.prevElement;
				counter--;
			}
			node.prevElement.nextElement = node.nextElement;
			node.nextElement.prevElement = node.prevElement;
			numberOfelements--;

			return;
		}
		throw new RuntimeException();

	}

	@Override
	public int size() {
		return numberOfelements;
	}

	@Override
	public ILinkedList sublist(final int fromIndex, final int toIndex) {
		DoubleLinkedList list1 = new DoubleLinkedList();
		dnode node = head;
		int counter = 0;
		if (head != null && fromIndex >= 0 && toIndex < numberOfelements && toIndex >= fromIndex) {
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
		dnode node;

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
