import static org.junit.jupiter.api.Assertions.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import contracts.LinkedListADT;
import managers.SLL;
import problemdomain.User;

/**
 * @author Jaeyoung Kim
 * @version 03-04-2020
 */
class SerializationPassTests
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

			linkedList.append(new User(1, "Joe Blow", "jblow@gmail.com", "password"));
			linkedList.append(new User(2, "Joe Schmoe", "joe.schmoe@outlook.com", "abcdef"));
			linkedList.append(new User(3, "Colonel Sanders", "chickenlover1890@gmail.com", "kfc5555"));
			linkedList.append(new User(4, "Ronald McDonald", "burgers4life63@outlook.com", "mcdonalds999"));

			/**
			 * Linked list should now be:
			 * 
			 * 1 -> 2 -> 3 -> 4
			 */
		} catch (NotSerializableException e)
		{
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Test the Serialization.
	 * 
	 */
	@Test // test-to-pass
	void testSerialization()
	{
		// Test the linked list is not empty.
		assertFalse(linkedList.isEmpty());

		// Test the size is 4
		assertEquals(4, linkedList.size());
		
		// 
		ObjectOutputStream oof;
		try
		{
			oof = new ObjectOutputStream(new FileOutputStream("res/UserObjects.dat"));
			
			// Write the serialized objects to the file.
			for (int i = 0; i < linkedList.size(); i++)
			{
				oof.writeObject(linkedList.retrieve(i));
			}

			// Close the objects.
			oof.close();
		} catch (IOException e)
		{ 
			e.printStackTrace();
		}		
	}

	/**
	 * Test the Deserialization.
	 * 
	 */
	@Test // test-to-pass
	void testDeserialization()
	{
		ObjectInputStream oif;
		try
		{
			oif = new ObjectInputStream(new FileInputStream("res/UserObjects.dat"));
			
			LinkedListADT newLinkedList = new SLL();

			// Read the serialized objects from the file.
			for (int i = 0; i < linkedList.size(); i++)
			{
				newLinkedList.append((User) oif.readObject());
			}

			for (int i = 0; i < linkedList.size(); i++)
			{
				assertEquals(newLinkedList.retrieve(i), linkedList.retrieve(i));				
			}

			// Close the object stream.
			oif.close();		
		} catch (IOException e)
		{
			e.printStackTrace();
		} catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}		
	}

	@AfterEach
	void tearDown()
	{
		linkedList.clear();
	}

}
