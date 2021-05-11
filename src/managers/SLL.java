package managers;

import contracts.*;
import problemdomain.*;

import java.io.*;

/**
 * @author Jaeyoung Kim
 * @version 03-04-2020
 */
public class SLL implements LinkedListADT
{
	/**
	 * The first node in the linked list.
	 */
	private Node head;

	/**
	 * The number of nodes in the linked list.
	 */
	private int size;

	public SLL() throws NotSerializableException
	{
		this.head = null;
		this.size = 0;
	}

	@Override
	public void prepend(Object data)
	{
		// Create a new node object to prepend.
		Node newNode = new Node(data);

		// Set next of new node to head
		// This must be done before we change the head.
		newNode.setNext(head);

		// Set head to new node
		head = newNode;

		// Increment the size
		size++;
	}

	@Override
	public boolean isEmpty()
	{
		// check there is node in SLL class or not.
		boolean empty = (size() == 0) ? true : false;
		return empty;
	}

	@Override
	public void clear()
	{
		head = null;
		size = 0;
		/*
		 * if (size > 0) { int count = size();
		 * 
		 * // Set the current position node to head. Node currentPositionNode = head;
		 * 
		 * // Set the next position node to nextPositionNode. Node nextPositionNode =
		 * currentPositionNode.getNext();
		 * 
		 * for (int i = 0; i < count - 1; i++) { // Set the current position node to
		 * null. currentPositionNode = null;
		 * 
		 * // Set the current position node to it's position node. currentPositionNode =
		 * nextPositionNode;
		 * 
		 * // Set the next position node to nextPositionNode. nextPositionNode =
		 * currentPositionNode.getNext(); size--; } // Set the next position node to
		 * null. nextPositionNode = null;
		 * 
		 * // Decrement the size size--; }
		 */
	}

	@Override
	public void append(Object data)
	{
		if (isEmpty())
		{
			// If there is no node, then run prepend method.
			prepend(data);
		} else
		{
			Node newNode = new Node(data);
			
			// Set the last node to head.
			Node lastNode = head;
			for (int i = 0; i < size() - 1; i++)
			{
				lastNode = lastNode.getNext();
			}
			lastNode.setNext(newNode);

			// Increment the size
			size++;
		}
	}

	@Override
	public void insert(Object data, int index) throws IndexOutOfBoundsException
	{
		if (index == 0)
		{
			// If index is 0, then run prepend method.
			prepend(data);
		} else if (index == size)
		{
			append(data);
		} else
		{
			Node newNode = new Node(data);
			Node findPositionNode = head;
			Node nextPositionNode = findPositionNode.getNext();
			for (int i = 0; i < index - 1; i++)
			{
				findPositionNode = findPositionNode.getNext();
				nextPositionNode = findPositionNode.getNext();
			}
			// set the previous index Node's next to the new Node
			findPositionNode.setNext(newNode);

			// set the new Node's next to the next index Node.
			newNode.setNext(nextPositionNode);

			// Increment the size
			size++;
		}
	}

	@Override
	public void replace(Object data, int index) throws IndexOutOfBoundsException
	{
		if (index >= size)
		{
			throw new IndexOutOfBoundsException();
		}
		
		Node newNode = new Node(data);
		Node findPositionNode = head;
		Node nextPositionNode = findPositionNode.getNext();
		for (int i = 0; i < index - 1; i++)
		{
			findPositionNode = findPositionNode.getNext();
			nextPositionNode = findPositionNode.getNext();
		}
		// set the previous index Node's next to the new Node
		findPositionNode.setNext(newNode);

		// set the new Node's next to the replaced Node's next.
		newNode.setNext(nextPositionNode.getNext());

		// set the placed Node's next which isn't in use anymore to null.
		nextPositionNode.setNext(null);
	}

	@Override
	public int size()
	{
		return this.size;
	}

	@Override
	public void delete(int index) throws IndexOutOfBoundsException
	{
		if (index >= size)
		{
			throw new IndexOutOfBoundsException();
		}
		
		if (index == 0)
		{
			Node temp = head;

			// Set head to new node.
			head = temp.getNext();

			// Set the deleted one's next to null.
			temp.setNext(null);

		} else
		{
			Node previousNode = head;
			Node targetNode = previousNode.getNext();
			for (int i = 0; i < index - 1; i++)
			{
				previousNode = previousNode.getNext();
				targetNode = previousNode.getNext();
			}
			// set the previous index Node's next to the Node(to be deleted)' next Node
			previousNode.setNext(targetNode.getNext());

			// set the target Node which isn't in use anymore to null for the next.
			targetNode.setNext(null);
		}

		// Decrement the size
		size--;

	}

	@Override
	public Object retrieve(int index) throws IndexOutOfBoundsException
	{
		Node temp = head;

		if (index >= size)
		{
			throw new IndexOutOfBoundsException();
		}
		
		for (int i = 0; i < index; i++)
		{
			temp = temp.getNext();			
		}

		return temp.getData();
	}

	@Override
	public int indexOf(Object data) throws IndexOutOfBoundsException
	{			
		Node temp = head;

		int index = 0;

		while (temp.getData() != data)
		{
			temp = temp.getNext();
			index++;

			if (temp == null)
			{
				return -1;
			}
		}
		return index;
	}

	@Override
	public boolean contains(Object data)
	{
		boolean isContain = false;

		Node currentNode = head;

		for (int i = 0; i < size && !isContain; i++)
		{
			if (currentNode.getData().equals(data))
			{
				isContain = true;
			}
			currentNode = currentNode.getNext();
		}
		return isContain;
	}
}