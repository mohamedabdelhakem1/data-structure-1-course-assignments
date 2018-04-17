/**
 *
 */
package eg.edu.alexu.csd.datastructure.queue.cs44_cs42_cs65;

import eg.edu.alexu.csd.datastructure.queue.ILinkedBased;
import eg.edu.alexu.csd.datastructure.queue.IQueue;

/**
 * @author SHIKO
 *
 */
public class LinkedListBasedQueue implements IQueue, ILinkedBased {

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

		public Node getnext() {
			return next;
		}

	}

	private Node front;
	private Node rear;
	int size = 0;

	@Override
	public void enqueue(Object item) {
		if (size == 0) {
			rear = new Node(item, null);
			front = rear;
			size++;

		} else {
			Node addedNode = new Node(item, null);
			rear.setNext(addedNode);
			rear = addedNode;
			size++;
		}
	}

	@Override
	public Object dequeue() {
		if (size == 0) {
			throw new RuntimeException();
		} else if (size == 1) {
			Object element = front.getElement();
			front = front.getnext();
			rear = front;
			size--;
			return element;

		}
		Object element = front.getElement();
		front = front.getnext();
		size--;
		return element;


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
