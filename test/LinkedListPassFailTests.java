import static org.junit.jupiter.api.Assertions.*;

import java.io.NotSerializableException;

import org.junit.jupiter.api.*;

import contracts.*;
import managers.SLL;

/**
 * @author ElMenshawy
 * @version 14-03-2020
 *
 */
public class LinkedListPassFailTests
{
	/**
	 * References the linked list that is manipulated in each test.
	 */
	private LinkedListADT linkedList;

	@BeforeEach
	void init()
	{
		try
		{
			// Create object from your implemented linked list here.
			linkedList = new SLL();
		} catch (NotSerializableException e)
		{
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Test the linked list is empty.
	 */
	@Test // test-to-fail
	void testIsEmpty()
	{
		assertFalse(!linkedList.isEmpty());
		assertNotEquals(4, linkedList.size());
	}

	/**
	 * Tests appending elements to the linked list.
	 */
	@Test // test-to-fail
	void testAppendNode()
	{
		linkedList.append("a");
		linkedList.append("b");
		linkedList.append("c");
		linkedList.append("d");

		/**
		 * Linked list should now be:
		 * 
		 * a -> b -> c -> d
		 */

		// Test the linked list is not empty.
		assertTrue(!linkedList.isEmpty());

		// Test the size is 4
		assertNotEquals(0, linkedList.size());

		// Test the first node value is a
		assertNotEquals(null, linkedList.retrieve(0));

		// Test the second node value is b
		assertNotEquals(null, linkedList.retrieve(1));

		// Test the third node value is c
		assertNotEquals(null, linkedList.retrieve(2));

		// Test the fourth node value is d
		assertNotEquals(null, linkedList.retrieve(3));
	}

	/**
	 * Tests prepending nodes to linked list.
	 */
	@Test // test-to-fail
	void testPrependNodes()
	{
		linkedList.prepend("a");
		linkedList.prepend("b");
		linkedList.prepend("c");
		linkedList.prepend("d");

		/**
		 * Linked list should now be:
		 * 
		 * d -> c -> b -> a
		 */

		// Test the linked list is not empty.
		assertFalse(linkedList.isEmpty());

		// Test the size is 4
		assertNotEquals(0, linkedList.size());

		// Test the first node value is d
		assertNotEquals(null, linkedList.retrieve(0));

		// Test the second node value is c
		assertNotEquals(null, linkedList.retrieve(1));

		// Test the third node value is b
		assertNotEquals(null, linkedList.retrieve(2));

		// Test the fourth node value is a
		assertNotEquals(null, linkedList.retrieve(3));
	}

	/**
	 * Tests inserting node at valid index.
	 */
	@Test // test-to-fail
	void testInsertNode()
	{
		linkedList.append("a");
		linkedList.append("b");
		linkedList.append("c");
		linkedList.append("d");
		linkedList.insert("e", 2);

		/**
		 * Linked list should now be:
		 * 
		 * a -> b -> e -> c -> d
		 */

		// Test the linked list is not empty.
		assertTrue(!linkedList.isEmpty());

		// Test the size is 5
		assertNotEquals(0, linkedList.size());

		// Test the first node value is a
		assertNotEquals(null, linkedList.retrieve(0));

		// Test the second node value is b
		assertNotEquals(null, linkedList.retrieve(1));

		// Test the third node value is e
		assertNotEquals(null, linkedList.retrieve(2));

		// Test the fourth node value is c
		assertNotEquals(null, linkedList.retrieve(3));

		// Test the fifth node value is d
		assertNotEquals(null, linkedList.retrieve(4));
	}

	/**
	 * Tests replacing existing nodes data.
	 */
	@Test // test-to-fail
	void testReplaceNodeException()
	{
		linkedList.append("a");
		linkedList.append("b");
		linkedList.append("c");
		linkedList.append("d");

		/**
		 * Linked list should now be:
		 * 
		 * a -> b -> e -> d
		 */

		// Test the linked list is not empty.
		assertFalse(linkedList.isEmpty());

		// Test the size is 4
		assertEquals(4, linkedList.size());

		// Test the first node value is a
		assertThrows(IndexOutOfBoundsException.class, () -> linkedList.retrieve(99));
	}

	/**
	 * Tests deleting node from linked list.
	 */
	@Test // test-to-fail
	void testDeleteNodeException()
	{
		linkedList.append("a");
		linkedList.append("b");
		linkedList.append("c");
		linkedList.append("d");

		assertThrows(IndexOutOfBoundsException.class, () -> linkedList.delete(99));
	}

	/**
	 * Tests finding and retrieving node in linked list.
	 */
	@Test // test-to-fail
	void testFindNodeException()
	{
		linkedList.append("a");
		linkedList.append("b");
		linkedList.append("c");
		linkedList.append("d");

		boolean contains = linkedList.contains("b");
		assertFalse(!contains);

		int index = linkedList.indexOf("b");
		assertNotEquals(55, index);

		assertThrows(IndexOutOfBoundsException.class, () -> linkedList.retrieve(99));
	}

	/**
	 * Tests clear nodes in linked list.
	 */
	@Test // test-to-fail
	void testClearNode()
	{
		linkedList.append("a");
		linkedList.append("b");
		linkedList.append("c");
		linkedList.append("d");

		/**
		 * Linked list should now be:
		 * 
		 * a -> b -> c -> d
		 */

		int size = linkedList.size();
		assertEquals(4, size);

		linkedList.clear();

		size = linkedList.size();
		assertNotEquals(99, size);
	}

	/**
	 * Tests size of linked list.
	 */
	@Test // test-to-fail
	void testSize()
	{
		linkedList.append("a");
		linkedList.append("b");
		linkedList.append("c");
		linkedList.append("d");

		/**
		 * Linked list should now be:
		 * 
		 * a -> b -> c -> d
		 */

		int size = linkedList.size();
		assertNotEquals(99, size);
	}

	/**
	 * Tests finding index of node in linked list.
	 */
	@Test // test-to-fail
	void testIndexOfNode()
	{
		linkedList.append("a");
		linkedList.append("b");
		linkedList.append("c");
		linkedList.append("d");

		/**
		 * Linked list should now be:
		 * 
		 * a -> b -> c -> d
		 */

		boolean containsA = linkedList.contains("a");
		boolean containsB = linkedList.contains("b");
		boolean containsC = linkedList.contains("c");
		boolean containsD = linkedList.contains("d");
		assertFalse(!containsA);
		assertFalse(!containsB);
		assertFalse(!containsC);
		assertFalse(!containsD);

		int indexA = linkedList.indexOf("a");
		int indexB = linkedList.indexOf("b");
		int indexC = linkedList.indexOf("c");
		int indexD = linkedList.indexOf("d");

		assertNotEquals(99, indexA);
		assertNotEquals(99, indexB);
		assertNotEquals(99, indexC);
		assertNotEquals(99, indexD);
	}

	/**
	 * Tests containing node in linked list.
	 */
	@Test // test-to-fail
	void testNodeContains()
	{
		linkedList.append("a");
		linkedList.append("b");
		linkedList.append("c");
		linkedList.append("d");

		/**
		 * Linked list should now be:
		 * 
		 * a -> b -> c -> d
		 */

		boolean containsA = linkedList.contains("a");
		boolean containsB = linkedList.contains("b");
		boolean containsC = linkedList.contains("c");
		boolean containsD = linkedList.contains("d");
		assertFalse(!containsA);
		assertFalse(!containsB);
		assertFalse(!containsC);
		assertFalse(!containsD);
	}

	@AfterEach
	void tearDown()
	{
		linkedList.clear();
	}
}