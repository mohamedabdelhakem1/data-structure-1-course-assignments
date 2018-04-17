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

	static class node {

		Object element;

		node next;

		public node() {
			this(null, null);
		}

		public node(final Object x, final node n) {
			element = x;
			next = n;
		}

		public void setElement(final Object x) {
			element = x;
		}

		public Object getElement() {
			return element;
		}

		public void setNext(final node n) {
			next = n;
		}

		public node getnext() {
			return next;
		}

	}

	private node front;
	private node rear;
	int size;

	@Override
	public void enqueue(Object item) {
		if (size == 0) {
			rear = new node(item, null);
			front = rear;
			size++;
		} else {
			node addedNode = new node(item, null);
			rear.setNext(addedNode);
			rear = addedNode;
			size++;
		}
	}

	@Override
	public Object dequeue() {
		if (size == 0) {
			throw new RuntimeException();
		}else if(size==1) {
			Object element = front.getElement();
			front = front.getnext();
			rear = front ;
			return element;
			size--;
		}
			Object element = front.getElement();
			front = front.getnext();
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
