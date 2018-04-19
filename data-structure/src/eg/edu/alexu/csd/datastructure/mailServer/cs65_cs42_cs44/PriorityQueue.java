package eg.edu.alexu.csd.datastructure.mailServer.cs65_cs42_cs44;

import eg.edu.alexu.csd.datastructure.mailServer.IPriorityQueue;

public class PriorityQueue implements IPriorityQueue {
	/**
	 * @author Abdelrahman Youssef
	 *
	 */
	private int size = 0;
	private dNode head = new dNode(null, null, null, 0);
	private dNode tail = new dNode(null, head, null, 0);

	public PriorityQueue() {
		head.setnextLink(tail);
	}

	private class dNode {
		/**
		 *
		 */
		private Object element;
		/**
		 *
		 */
		private dNode previousLink;
		/**
		 *
		 */
		private dNode nextLink;
		/**
		 *
		 */
		private int key = 0;

		/**
		 * @param e
		 *            obj
		 * @param p
		 *            p
		 * @param n
		 *            n
		 */
		public dNode(Object e, dNode p, dNode n, int k) {
			key = k;
			element = e;
			previousLink = p;
			nextLink = n;
		}

		/**
		 * @param x
		 *            d
		 */
		public void setObject(Object x) {
			element = x;
		}

		/**
		 * @param n
		 * 
		 */
		public void setPreviousLink(dNode n) {
			previousLink = n;
		}

		/**
		 * @param n
		 *            hhj
		 */
		public void setnextLink(dNode n) {
			nextLink = n;
		}

		/**
		 * @return jjj
		 */
		public Object getObject() {
			return element;
		}

		/**
		 * @return gg
		 */
		public dNode getPreviousLink() {
			return previousLink;
		}

		/**
		 * @return ggg
		 */
		public dNode getNextLink() {
			return nextLink;
		}
	}

	/**
	 *
	 */
	@Override
	public void insert(Object item, int key) {
		if (key <= 0) {
			throw new RuntimeException();
		}
		dNode i = head.nextLink;
		dNode j = tail.previousLink;
		while (i.key <= key && i.key != 0 && j.key != 0 && j.key > key) {
			i = i.nextLink;
			j = j.previousLink;

		}
		if (i.key > key) {
			dNode addednode = new dNode(item, i.previousLink, i, key);
			i.previousLink.setnextLink(addednode);
			i.previousLink = addednode;
		}
		if (j.key <= key) {
			dNode addednode = new dNode(item, j, j.nextLink, key);
			j.nextLink.setPreviousLink(addednode);
			j.setnextLink(addednode);
		}

			size++;
	}

	/**
	 *
	 */
	@Override
	public Object removeMin() {
		if (size == 0) {
			throw new RuntimeException();
		}
		dNode i = head.nextLink;
		i.nextLink.setPreviousLink(head);
		head.setnextLink(i.nextLink);
		size--;
		return i.getObject();
	}

	/**
	 *
	 */
	@Override
	public Object min() {
		dNode i = head.nextLink;
		if (size == 0) {
			throw new RuntimeException();
		}
		return i.getObject();
	}

	/**
	 *
	 */
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return (size == 0);
	}

	/**
	 *
	 */
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

}
