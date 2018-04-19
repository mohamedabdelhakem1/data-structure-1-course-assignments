package eg.edu.alexu.csd.datastructure.linkedList.cs44_cs65;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import eg.edu.alexu.csd.datastructure.linkedList.ILinkedList;
/**
 *
 * @author SHIKO
 *
 */
public class SingleLinkedListTest {
	/**
	*
	*/
	public final int n0 = 0;
	/**
	*
	*/
	public final int n1 = 1;
	/**
	*
	*/
	public final int n2 = 2;
	/**
	*
	*/
	public final int n3 = 3;
	/**
	*
	*/
	public final int n4 = 4;
	/**
	*
	*/
	public final int n5 = 5;
	/**
	*
	*/
	public final int n6 = 6;
	/**
	*
	*/
	public final int n7 = 7;
	/**
	*
	*/
	public final int n8 = 8;
	/**
	*
	*/
	public final int n9 = 9;
	/**
	*
	*/
	public final int n10 = 10;
	/**
	*
	*/
	public final int n11 = 11;
	/**
	*
	*/
	public final int n12 = 12;
	/**
	*
	*/
	public final int n13 = 13;
	/**
	*
	*/
	public final int n14 = 14;
	/**
	*
	*/
	public final int n15 = 15;
	/**
	*
	*/
	public final int n16 = 16;
	/**
	*
	*/
	public final int n17 = 17;
	/**
	*
	*/
	public final int n18 = 18;
	/**
	*
	*/
	public final int n19 = 19;
	/**
	*
	*/
	public final int n20 = 20;
	/**
	*
	*/
	public final int n21 = 21;
	/**
	*
	*/
	public final int n22 = 22;
	/**
	*
	*/
	public final int n23 = 23;
	/**
	*
	*/
	public final int n24 = 24;
	/**
	*
	*/
	public final int n25 = 25;
	/**
	*
	*/
	public final int n26 = 26;
	/**
	*
	*/
	public final int n27 = 27;
	/**
	*
	*/
	public final int n28 = 28;
	/**
	*
	*/
	public final int n29 = 29;
	/**
	*
	*/
	public final int n30 = 30;
	/**
	*
	*/
	public final int n31 = 31;
	/**
	*
	*/
	public final int n32 = 32;
	/**
	*
	*/
	public final int n33 = 33;
	/**
	*
	*/
	public final int n34 = 34;
	/**
	*
	*/
	public final int n35 = 35;
	/**
	*
	*/
	public final int n36 = 36;
	/**
	*
	*/
	public final int n37 = 37;
	/**
	*
	*/
	public final int n38 = 38;
	/**
	*
	*/
	public final int n39 = 39;
	/**
	*
	*/
	public final int n40 = 40;
	/**
	*
	*/
	public final int n41 = 41;
	/**
	*
	*/
	public final int n42 = 42;
	/**
	*
	*/
	public final int n43 = 43;
	/**
	*
	*/
	public final int n44 = 44;
	/**
	*
	*/
	public final int n45 = 45;
	/**
	*
	*/
	public final int n46 = 46;
	/**
	*
	*/
	public final int n47 = 47;
	/**
	*
	*/
	public final int n48 = 48;
	/**
	*
	*/
	public final int n49 = 49;
	/**
	*
	*/
	public final int n50 = 50;
	/**
	*
	*/
	public final int n51 = 51;
	/**
	*
	*/
	public final int n52 = 52;
	/**
	*
	*/
	public final int n53 = 53;
	/**
	*
	*/
	public final int n54 = 54;
	/**
	*
	*/
	public final int n55 = 55;
	/**
	*
	*/
	public final int n56 = 56;
	/**
	*
	*/
	public final int n57 = 57;
	/**
	*
	*/
	public final int n58 = 58;
	/**
	*
	*/
	public final int n59 = 59;
	/**
	*
	*/
	public final int n60 = 60;
	/**
	*
	*/
	public final int n61 = 61;
	/**
	*
	*/
	public final int n62 = 62;
	/**
	*
	*/
	public final int n63 = 63;
	/**
	*
	*/
	public final int n64 = 64;
	/**
	*
	*/
	public final int n65 = 65;
	/**
	*
	*/
	public final int n66 = 66;
	/**
	*
	*/
	public final int n67 = 67;
	/**
	*
	*/
	public final int n68 = 68;
	/**
	*
	*/
	public final int n69 = 69;
	/**
	*
	*/
	public final int n70 = 70;
	/**
	*
	*/
	public final int n71 = 71;
	/**
	*
	*/
	public final int n72 = 72;
	/**
	*
	*/
	public final int n73 = 73;
	/**
	*
	*/
	public final int n74 = 74;
	/**
	*
	*/
	public final int n75 = 75;
	/**
	*
	*/
	public final int n76 = 76;
	/**
	*
	*/
	public final int n77 = 77;
	/**
	*
	*/
	public final int n78 = 78;
	/**
	*
	*/
	public final int n79 = 79;
	/**
	*
	*/
	public final int n80 = 80;
	/**
	*
	*/
	public final int n81 = 81;
	/**
	*
	*/
	public final int n82 = 82;
	/**
	*
	*/
	public final int n83 = 83;
	/**
	*
	*/
	public final int n84 = 84;
	/**
	*
	*/
	public final int n85 = 85;
	/**
	*
	*/
	public final int n86 = 86;
	/**
	*
	*/
	public final int n87 = 87;
	/**
	*
	*/
	public final int n88 = 88;
	/**
	*
	*/
	public final int n89 = 89;
	/**
	*
	*/
	public final int n90 = 90;
	/**
	*
	*/
	public final int n91 = 91;
	/**
	*
	*/
	public final int n92 = 92;
	/**
	*
	*/
	public final int n93 = 93;
	/**
	*
	*/
	public final int n94 = 94;
	/**
	*
	*/
	public final int n95 = 95;
	/**
	*
	*/
	public final int n96 = 96;
	/**
	*
	*/
	public final int n97 = 97;
	/**
	*
	*/
	public final int n98 = 98;
	/**
	*
	*/
	public final int n99 = 99;

	@Test
	public void cs65TestSet() {
		SingleLinkedList instance = new SingleLinkedList();
		instance.add(n1);
		instance.add(n3);
		instance.add(n5);
		instance.set(n1, 'F');
		assertEquals('F', instance.get(1));
	}

	@Test
	public void cs65TestSetError() {
		SingleLinkedList instance = new SingleLinkedList();
		try {
			instance.add(n1);
			instance.add(n2);
			instance.set(n4, 'F');
			fail("You should throw an exception"
			+ " when trying to set in a wrong index");
		} catch (RuntimeException f) {
		}
	}

	@Test
	public void cs65TestSubList() {
		SingleLinkedList instance = new SingleLinkedList();
		instance.add('a');
		instance.add('b');
		instance.add('c');
		instance.add('d');
		ILinkedList temp = instance.sublist(n1, n2);
		assertEquals(temp.get(0), instance.get(n1));
		assertEquals(temp.get(1), instance.get(n2));

	}

	@Test
	public void cs56TestContains() {
		SingleLinkedList c = new SingleLinkedList();
		for (int i = 0; i < n3; i++) {
			c.add(i);
		}
		c.add(n0, n3);
		c.add(n4, n4);

		assertTrue(c.contains(n4));
		assertTrue(c.contains(n0));
		assertTrue(c.contains(n1));
		assertTrue(c.contains(n2));
		assertTrue(c.contains(n3));
		assertFalse(c.contains(n9));
		assertFalse(c.contains(n7));
	}

	@Test
	public void cs56TestAddRemoveTwoLists5() {
		SingleLinkedList c = new SingleLinkedList();
		for (int i = 0; i < n3; i++) {
			c.add(i);
		}
		c.add(n0, n3);
		c.add(n4, n4);
		c.set(n1, n7);
		c.set(n4, n9);
		SingleLinkedList d = new SingleLinkedList();
		d.add(n3);
		d.add(n7);
		d.add(n1);
		d.add(n2);
		d.add(n9);
		for (int i = 0; i < n5; i++) {
			assertEquals(c.get(i), d.get(i));
		}
	}

	@Test
	public void test1() {
		SingleLinkedList instance = new SingleLinkedList();
		instance.add(n0, n0);
		instance.add(n1, n1);
		instance.add(n2, n2);
		instance.add(n3, n3);
		for (int i = 0; i < n4; i++) {
			assertEquals(instance.get(i), i);
		}
	}

	@Test
	public void test2() {
		SingleLinkedList instance = new SingleLinkedList();
		instance.add(n0);
		instance.add(n1);
		instance.add(n2);
		instance.add(n3);
		for (int i = 0; i < n4; i++) {
			assertEquals(instance.get(i), i);
		}
		boolean c = false;
		try {
			instance.add(n5, n4);
		} catch (RuntimeException e) {
			c = true;
		}
		assertTrue(c);

	}

	@Test
	public void test3() {
		SingleLinkedList instance = new SingleLinkedList();

		boolean c = false;
		try {
			instance.set(n0, n4);
		} catch (RuntimeException e) {
			c = true;
		}
		assertTrue(c);

	}

	@Test
	public void test4() {
		SingleLinkedList instance = new SingleLinkedList();

		boolean c = false;
		try {
			instance.remove(n4);
		} catch (RuntimeException e) {
			c = true;
		}
		assertTrue(c);

	}

}
