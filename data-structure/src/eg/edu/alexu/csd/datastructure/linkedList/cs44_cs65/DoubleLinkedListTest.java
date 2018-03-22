package eg.edu.alexu.csd.datastructure.linkedList.cs44_cs65;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import eg.edu.alexu.csd.datastructure.linkedList.ILinkedList;

public class DoubleLinkedListTest {

	@Test
	public void cs65TestSet() {
		DoubleLinkedList instance = new DoubleLinkedList();
		instance.add(1);
		instance.add(3);
		instance.add(5);
		instance.set(1, 'F');
		assertEquals('F', instance.get(1));
	}

	@Test
	public void cs65TestSetError() {
		DoubleLinkedList instance = new DoubleLinkedList();
		try {
			instance.add(1);
			instance.add(2);
			instance.set(4, 'F');
			fail("You should throw an exception when trying to set in a wrong index");
		} catch (RuntimeException f) {
		}
	}

	@Test
	public void cs65TestSubList() {
		DoubleLinkedList instance = new DoubleLinkedList();
		instance.add('a');
		instance.add('b');
		instance.add('c');
		instance.add('d');
		ILinkedList temp = instance.sublist(1, 2);
		assertEquals(temp.get(0), instance.get(1));
		assertEquals(temp.get(1), instance.get(2));

	}

	@Test
	public void cs56TestContains() {
		DoubleLinkedList c = new DoubleLinkedList();
		for (int i = 0; i < 3; i++) {
			c.add(i);
		}
		c.add(0, 3);
		c.add(4, 4);

		assertTrue(c.contains(4));
		assertTrue(c.contains(0));
		assertTrue(c.contains(1));
		assertTrue(c.contains(2));
		assertTrue(c.contains(3));
		assertFalse(c.contains(9));
		assertFalse(c.contains(7));
	}

	@Test
	public void cs56TestAddRemoveTwoLists5() {
		DoubleLinkedList c = new DoubleLinkedList();
		for (int i = 0; i < 3; i++) {
			c.add(i);
		}
		c.add(0, 3);
		c.add(4, 4);
		c.set(1, 7);
		c.set(4, 9);
		DoubleLinkedList d = new DoubleLinkedList();
		d.add(3);
		d.add(7);
		d.add(1);
		d.add(2);
		d.add(9);
		for (int i = 0; i < 5; i++) {
			assertEquals(c.get(i), d.get(i));
		}
	}

	@Test
	public void test1() {
		DoubleLinkedList instance = new DoubleLinkedList();
		instance.add(0, 0);
		instance.add(1, 1);
		instance.add(2, 2);
		instance.add(3, 3);
		for (int i = 0; i < 4; i++) {
			assertEquals(instance.get(i), i);
		}
	}

	@Test
	public void test2() {
		DoubleLinkedList instance = new DoubleLinkedList();
		instance.add(0);
		instance.add(1);
		instance.add(2);
		instance.add(3);
		for (int i = 0; i < 4; i++) {
			assertEquals(instance.get(i), i);
		}
		boolean c = false;
		try {
			instance.add(5, 4);
		} catch (RuntimeException e) {
			c = true;
		}
		assertTrue(c);

	}

	@Test
	public void test3() {
		DoubleLinkedList instance = new DoubleLinkedList();

		boolean c = false;
		try {
			instance.set(0, 4);
		} catch (RuntimeException e) {
			c = true;
		}
		assertTrue(c);

	}

	@Test
	public void test4() {
		DoubleLinkedList instance = new DoubleLinkedList();

		boolean c = false;
		try {
			instance.remove(4);
		} catch (RuntimeException e) {
			c = true;
		}
		assertTrue(c);

	}

}
