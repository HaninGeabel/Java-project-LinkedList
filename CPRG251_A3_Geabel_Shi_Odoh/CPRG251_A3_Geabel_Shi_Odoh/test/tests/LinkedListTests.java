package tests;

import static org.junit.jupiter.api.Assertions.*;

import javax.print.attribute.standard.Sides;

import org.junit.jupiter.api.*;

import sait.sll.problemdomain.User;
import sait.sll.utility.*;


/**
 * @author Hanin Geabel
 * @author Deborah Odoh
 * @author Henry Shi
 * @version 2022-04-02
 *
 */
class LinkedListTests {
	/**
	 * Contains the linked list that is manipulated in each test.
	 */
	private LinkedListADT linkedList;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		// Create your concrete linked list class and assign to to linkedList.
		this.linkedList = new SLL();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		this.linkedList.clear();
	}

	/**
	 * Test the linked list is empty.
	 */
	@Test
	void testIsEmpty() {
		assertTrue(this.linkedList.isEmpty());
		assertEquals(0, this.linkedList.size());
	}
	
	/**
	 * Tests appending elements to the linked list.
	 */
	@Test
	void testAppendNode() {
		this.linkedList.append("a");
		this.linkedList.append("b");
		this.linkedList.append("c");
		this.linkedList.append("d");
		
		/**
		 * Linked list should now be:
		 * 
		 * a -> b -> c -> d
		 */
		
		// Test the linked list is not empty.
		assertFalse(this.linkedList.isEmpty());
		
		// Test the size is 4
		assertEquals(4, this.linkedList.size());

		// Test the first node value is a
		
		assertEquals("a", this.linkedList.retrieve(0));

		// Test the second node value is b
		assertEquals("b", this.linkedList.retrieve(1));
		
		// Test the third node value is c
		assertEquals("c", this.linkedList.retrieve(2));
		
		// Test the fourth node value is d
		assertEquals("d", this.linkedList.retrieve(3));
	}

	/**
	 * Tests prepending nodes to linked list.
	 */
	@Test
	void testPrependNodes() {
		this.linkedList.prepend("a");
		this.linkedList.prepend("b");
		this.linkedList.prepend("c");
		this.linkedList.prepend("d");
		
		/**
		 * Linked list should now be:
		 * 
		 * d -> c -> b -> a
		 */
		
		// Test the linked list is not empty.
		assertFalse(this.linkedList.isEmpty());
		
		// Test the size is 4
		assertEquals(4, this.linkedList.size());

		// Test the first node value is a
		assertEquals("d", this.linkedList.retrieve(0));

		// Test the second node value is b
		assertEquals("c", this.linkedList.retrieve(1));
		
		// Test the third node value is c
		assertEquals("b", this.linkedList.retrieve(2));
		
		// Test the fourth node value is d
		assertEquals("a", this.linkedList.retrieve(3));
	}
	
	/**
	 * Tests inserting node at valid index.
	 */
	@Test
	void testInsertNode() {
		this.linkedList.append("a");
		this.linkedList.append("b");
		this.linkedList.append("c");
		this.linkedList.append("d");
		
		this.linkedList.insert("e", 2);
		
		/**
		 * Linked list should now be:
		 * 
		 * a -> b -> e -> c -> d
		 */
		
		// Test the linked list is not empty.
		assertFalse(this.linkedList.isEmpty());
		
		// Test the size is 4
		assertEquals(5, this.linkedList.size());

		// Test the first node value is a
		assertEquals("a", this.linkedList.retrieve(0));

		// Test the second node value is b
		assertEquals("b", this.linkedList.retrieve(1));
		
		// Test the third node value is e
		assertEquals("e", this.linkedList.retrieve(2));
		
		// Test the third node value is c
		assertEquals("c", this.linkedList.retrieve(3));
		
		// Test the fourth node value is d
		assertEquals("d", this.linkedList.retrieve(4));
	}
	
	/**
	 * Tests replacing existing nodes data.
	 */
	@Test
	void testReplaceNode() {
		this.linkedList.append("a");
		this.linkedList.append("b");
		this.linkedList.append("c");
		this.linkedList.append("d");
		
		this.linkedList.replace("e", 2);
		
		/**
		 * Linked list should now be:
		 * 
		 * a -> b -> e -> d
		 */
		
		// Test the linked list is not empty.
		assertFalse(this.linkedList.isEmpty());
		
		// Test the size is 4
		assertEquals(4, this.linkedList.size());

		// Test the first node value is a
		assertEquals("a", this.linkedList.retrieve(0));

		// Test the second node value is b
		assertEquals("b", this.linkedList.retrieve(1));
		
		// Test the third node value is e
		assertEquals("e", this.linkedList.retrieve(2));
		
		// Test the fourth node value is d
		assertEquals("d", this.linkedList.retrieve(3));
	}
	
	/**
	 * Tests deleting node from linked list.
	 */
	@Test
	void testDeleteNode() {
		this.linkedList.append("a");
		this.linkedList.append("b");
		this.linkedList.append("c");
		this.linkedList.append("d");
		
		this.linkedList.delete(2);
		
		/**
		 * Linked list should now be:
		 * 
		 * a -> b -> d
		 */
		
		// Test the linked list is not empty.
		assertFalse(this.linkedList.isEmpty());
		
		// Test the size is 4
		assertEquals(3, this.linkedList.size());

		// Test the first node value is a
		assertEquals("a", this.linkedList.retrieve(0));

		// Test the second node value is b
		assertEquals("b", this.linkedList.retrieve(1));
		
		// Test the fourth node value is d
		assertEquals("d", this.linkedList.retrieve(2));
	}
	
	/**
	 * Tests finding and retrieving node in linked list.
	 */
	@Test
	void testFindNode() {
		this.linkedList.append("a");
		this.linkedList.append("b");
		this.linkedList.append("c");
		this.linkedList.append("d");
		
		/**
		 * Linked list should now be:
		 * 
		 * a -> b -> c -> d
		 */
		
		boolean contains = this.linkedList.contains("b");
		assertTrue(contains);
		
		int index = this.linkedList.indexOf("b");
		assertEquals(1, index);
		
		String value = (String) this.linkedList.retrieve(1);
		assertEquals("b", value);
	}
	/**
	 * Linked list should now be: 
	 * a -> b -> c -> d
	 * and size =4
	 */
	@Test
	void testSize() {
		this.linkedList.append("a");
		this.linkedList.append("b");
		this.linkedList.append("c");
		this.linkedList.append("d");
		//test the size of the linkdlist
		assertEquals(4, this.linkedList.size());	
	}
	/**
	 * check the not exist obj
	 */
	@Test
	void testNodeNotExist() {
		this.linkedList.append("a");
		this.linkedList.append("b");
		this.linkedList.append("c");
		this.linkedList.append("d");
		
		boolean contains = this.linkedList.contains("x");
		assertFalse(contains);
			//assertNotEquals("z", this.linkedList.retrieve(0));
			//assertEquals("b", this.linkedList.retrieve(1));
			//assertEquals("c", this.linkedList.retrieve(2));
		//	assertEquals("d", this.linkedList.retrieve(3));
		
		
	}
	
	/**
	 * insert obj in index> size
	 */
	@Test
	void testInsertOutOfBounds() {
		this.linkedList.append("a");
		this.linkedList.append("b");
		this.linkedList.append("c");
		this.linkedList.append("d");
		org.junit.jupiter.api.Assertions.assertThrows(IndexOutOfBoundsException.class, () -> linkedList.insert("z",7));	}
	
/**
 * delete the first obj from the list
 */

@Test

void testDeleteNodeFromStart() {
	this.linkedList.append("a");
	this.linkedList.append("b");
	this.linkedList.append("c");
	this.linkedList.append("d");
	linkedList.delete(0);
	assertEquals("b", this.linkedList.retrieve(0));

}
/**
 *check if there is  an obj in the -1 index 
 */

@Test
void testInputIndexMinusOne() {
	this.linkedList.append("a");
	this.linkedList.append("b");
	this.linkedList.append("c");
	this.linkedList.append("d");
	org.junit.jupiter.api.Assertions.assertThrows(IndexOutOfBoundsException.class, () -> linkedList.retrieve(-1));	}

/**
 * check if there is an obj before appending 
 */

@Test
void testStartNodeBeforeAppending() {
	boolean contains = this.linkedList.contains("x");
	assertFalse(contains);
	
}
/**
 * check the first node
 */

@Test
void testNodeAtStart() {
	this.linkedList.append("a");
	this.linkedList.append("b");
	this.linkedList.append("c");
	this.linkedList.append("d");
	
	assertEquals("a", this.linkedList.retrieve(0));
}
/**
 * test not exist code
 */

@Test
void testFindNodeNotExist() {
	
	this.linkedList.append("a");
	this.linkedList.append("b");
	this.linkedList.append("c");
	this.linkedList.append("d");
	
	boolean contains = this.linkedList.contains("x");
	assertFalse(contains);
}

/**
 * throwing exception when deleting object from empty list
 */


@Test
void testdeleteEmptyList() {
	org.junit.jupiter.api.Assertions.assertThrows(IndexOutOfBoundsException.class, () -> linkedList.delete(0));	}
	
/**
 * test if can replace object in index 8 while we have just until 4	
 */

@Test
void testreplaceOutOfBounds() {
	this.linkedList.append("a");
	this.linkedList.append("b");
	this.linkedList.append("c");
	this.linkedList.append("d");
	org.junit.jupiter.api.Assertions.assertThrows(IndexOutOfBoundsException.class, () -> linkedList.replace("w", 8));	}



}


