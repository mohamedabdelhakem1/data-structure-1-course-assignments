package eg.edu.alexu.csd.datastructure.stack.cs44;

import eg.edu.alexu.csd.datastructure.stack.IStack;
/**
 *
 * @author SHIKO
 *
 */
public class MyStack implements IStack {
	/**
	 * size of the stack
	 */
	private int size = 0;
   /**
    *
    * @author SHIKO
    * class node of the stack
    */
	static class Node {
		/**
		 * value of the element
		 */
		Object element;
		/**
		 * a pointer to the next element in the stack
		 */
		Node next;
		/**
		 *  for the node
		 */
		public Node() {
			this(null, null);
		}
		/**
		 *  for the node
		 */
		public Node(final Object x, final Node n) {
			element = x;
			next = n;
		}
		/**
		 * method set the value of the element
		 * @param x
		 */
		public void setElement(final Object x) {
			element = x;
		}
		/**
		 *
		 * @return the value of the element
		 */
		public Object getElement() {
			return element;
		}
		/**
		 *
		 * @param n pointer to the next element
		 */
		public void setNext(final Node n) {
			next = n;
		}
		/**
		 *
		 * @return the pointer to the next element
		 */
		public Object getnext() {
			return next;
		}

	}
	/**
	 * pointer to the top of the stack
	 */
	private Node top;
	/**
	 *@return the element in the top of the stack and removes it
	 */
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
	/**
	 *@return the the element in the top of the stack
	 */
	@Override
	public Object peek() {
		if (size == 0) {
			throw new RuntimeException();
		} else {
			return top.element;
		}

	}
	/**
	 * @param element to be added at the top of the stack
	 */
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
	/**
	 * @return boolean if the stack is empty of not
	 */
	@Override
	public boolean isEmpty() {

		return (size == 0);
	}
	/**
	 * @return the size of the stack
	 */
	@Override
	public int size() {
		return size;
	}

}