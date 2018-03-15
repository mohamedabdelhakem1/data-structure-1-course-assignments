package eg.edu.alexu.csd.datastructure.linkedList.cs44_cs65;

import eg.edu.alexu.csd.datastructure.linkedList.ILinkedList;

public class SingleLinkedList implements ILinkedList {

	static class sNode {
		Object newElement;
		sNode nextElement;

		sNode(Object x,sNode n) {
			newElement = x;
			nextElement = n;

		}
	}



	int numberOfElements = 0;
	sNode head = null	;

	@Override
	public void add(int index, Object element) {
		sNode node;
		node = head;
		int counter = 0;
		if(index == 0) {
			if(numberOfElements != 0) {
			head.newElement = element;
			}else {
				head = new sNode (element,null);
			}

		}
		else if (index <= numberOfElements && index > 0) {

			while (counter < (index-1)) {
				node = node.nextElement;
				counter++;
			}
			sNode temp = node.nextElement;
			sNode addedNode = new sNode(element,temp);
			node.nextElement = addedNode;
			numberOfElements++;




		}else {
			throw new RuntimeException();
		}

	}

	@Override
	public void add(Object element) {
		sNode node;
		if (head == null) {

			head = new sNode(element,null);
			numberOfElements++;
		} else {
			node = head;
			while (node.nextElement != null) {
				node = node.nextElement;
			}
			node.nextElement = new sNode(element,null);
			numberOfElements++;


		}

	}

	@Override
	public Object get(int index) {
		sNode node = head;
		int counter = 0;
		
		 if (index < numberOfElements && index >= 0) {
			while (counter < index) {
				node = node.nextElement;
				counter++;
			}
			return (node.newElement);
		}
		 else {
		 throw new RuntimeException();
		 }
		 
		 }

	@Override
	public void set(int index, Object element) {
		sNode node = head;
		int counter = 0;
		if (index < numberOfElements && index >= 0) {
			while (counter < index) {
				node = node.nextElement;
				counter++;
			}
			node.newElement = element;
		} else {
			throw new RuntimeException();
		}

	}

	@Override
	public void clear() {
		if(numberOfElements!=0) {
			head = null;
			numberOfElements = 0;
		}else {
			throw new RuntimeException();
		}

	}

	@Override
	public boolean isEmpty() {

			return (numberOfElements == 0) ;

	}

	@Override
	public void remove(int index) {
		sNode node;
		node = head;
		int counter = 0;
		if(index == 0) {
			head = head.nextElement;
			numberOfElements--;
		}
		else if (index < numberOfElements && index >= 0) {

			while (counter < index - 1 ) {
				node = node.nextElement;
				counter++;
			}
			node.nextElement = node.nextElement.nextElement;

			numberOfElements--;
		}	else {
			throw new RuntimeException();
		}


	}

	@Override
	public int size() {
		return numberOfElements;
	}

	@Override
	public ILinkedList sublist(int fromIndex, int toIndex) {
		SingleLinkedList list1 = new SingleLinkedList();
		sNode node = head;
		int counter = 0;
		if (head != null && fromIndex >= 0 && toIndex < numberOfElements  && toIndex >= fromIndex ) {
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
	public boolean contains(Object o) {
		sNode node;



			node = head;
			while (node != null) {
				if (node.newElement == o) {
					return true;
				}
				node = node.nextElement;
			}
			return false;

		}

	}


