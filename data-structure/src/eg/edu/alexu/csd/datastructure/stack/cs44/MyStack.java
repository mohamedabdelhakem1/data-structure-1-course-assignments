package eg.edu.alexu.csd.datastructure.stack.cs44;

import eg.edu.alexu.csd.datastructure.stack.IStack;

public class MyStack implements IStack {
	private int size = 0;

	static class Node {
		Object element;
		Node next;

		public Node() {
			this(null, null);
		}

		public Node(final Object x, final Node n) {
			element = x;
			next = n;
		}

		public void setElement(final Object x) {
			element = x;
		}

		public Object getElement() {
			return element;
		}

		public void setNext(final Node n) {
			next = n;
		}

		public Object getnext() {
			return next;
		}

	}

	private Node top;

	@Override
	public Object pop() {
		if (size == 0) {
			throw new RuntimeException();
		} else {
			Object element = top.element;
			top = top.next;
			size--;
			return element;
		}

	}

	@Override
	public Object peek() {
		if (size == 0) {
			throw new RuntimeException();
		} else {
			return top.element;
		}

	}

	@Override
	public void push(final Object element) {
		if (size == 0) {
			top = new Node(element, null);
		} else {
			Node newNode = new Node(element, top);
			top = newNode;
		}
		size++;
	}

	@Override
	public boolean isEmpty() {

		return (size == 0);
	}

	@Override
	public int size() {
		return size;
	}

}