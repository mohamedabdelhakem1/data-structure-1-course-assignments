package eg.edu.alexu.csd.datastructure.stack.cs44;

import eg.edu.alexu.csd.datastructure.linkedList.cs44_cs65.DoubleLinkedList;
import eg.edu.alexu.csd.datastructure.stack.IStack;
public class MyStack implements IStack {
	 DoubleLinkedList stack = new DoubleLinkedList();

	@Override
	public Object pop() {
		if (stack.size() == 0) {
			throw new RuntimeException();
		} else {
			Object element = stack.get(stack.size()-1);
			stack.remove(stack.size()-1);
			return element;
		}

	}

	@Override
	public Object peek() {
		if (stack.size() == 0) {
			throw new RuntimeException();
		} else {
			return  stack.get(stack.size()-1);
		}

	}

	@Override
	public void push(Object element) {
		stack.add(element);
	}

	@Override
	public boolean isEmpty() {

		return (stack.size() == 0);
	}

	@Override
	public int size() {
		return stack.size();
	}

}
