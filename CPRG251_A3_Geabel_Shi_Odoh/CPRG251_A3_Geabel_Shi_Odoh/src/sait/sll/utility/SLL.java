/**
 * 
 */
package sait.sll.utility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import sait.sll.problemdomain.User;
/**
 * @author Hanin Geabel
 * @author Deborah Odoh
 * @author Henry Shi
 * @version 2022-04-02
 *
 */

public class SLL implements LinkedListADT, Serializable {
	/**
	 * The first node in the linked list.
	 */
	private Node head;
	
	/**
	 * The number of nodes in the linked list.
	 */
	private int size;

	@Override
	public boolean isEmpty() {
		return head == null ? true : false;
	}


	@Override
	public void append(Object data) {
		Node newNode = new Node(data);
		
		if (head == null) 
		{
			head = newNode;
		} 
		else {
			Node currentNode = head;
			
			while (currentNode.getNext() != null) 
			{
				currentNode = currentNode.getNext();
			}
			
			currentNode.setNext(newNode);
		}
		
		size++;
	}

	@Override
	public void prepend(Object data) {

		Node newNode = new Node(data);
		newNode.setNext(head);
		head = newNode;
		size++;		
	}

	@Override
	public void insert(Object data, int index) throws IndexOutOfBoundsException {

		if (index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException();
		}
		
		Node newNode = new Node(data);
		
		
		if (index == 0) {
			newNode.setNext(head);
			head = newNode;
		} 
		else {
			Node currentNode = head;
			int currentIndex = 0; 
			while (currentNode != null && currentIndex < index - 1) 
			{
				currentNode = currentNode.getNext();
				currentIndex++;
			}
			Node prevNode = currentNode;
			
			Node nextNode = currentNode.getNext();
			
			prevNode.setNext(newNode);
			
			newNode.setNext(nextNode);
		}
 
		size++;
			
	}

	@Override
	public void replace(Object data, int index) throws IndexOutOfBoundsException {

		if (index < 0 || index >= this.size()) {
			throw new IndexOutOfBoundsException();
		}
 
		Node currentNode = head;
		int currentIndex = 0;
		
		while (currentNode != null && currentIndex < index) {
			currentIndex++;
			currentNode = currentNode.getNext();
		}
		
		currentNode.setData(data);		
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public void delete(int index) throws IndexOutOfBoundsException {

		// Throw IndexOutOfBoundsException if index is negative or index is greater than the size - 1.
		if (index < 0 || index > size() - 1)
			throw new IndexOutOfBoundsException();
		
		Node prevNode = head;
		int currentIndex = 0;
		Node nodeToDelete;
		
		// If index to delete from is 0
		if (index == 0) 
		{
			// Get the existing node at head.
			nodeToDelete = head;
			
			// Set head to node after head
			this.head = head.getNext();
			
			// Set node next of head to null.
			nodeToDelete.setNext(null);
		} 
		else 
		{
			// Otherwise, loop until we reach to node at index - 1.
			while (prevNode != null && currentIndex < index - 1) 
			{
				prevNode = prevNode.getNext();
				currentIndex++;
			}
			// prevNode is before the one to delete.
			// nodeToDelete is the node being deleted.
			nodeToDelete = prevNode.getNext();
			
			// Set next of prevNode to node after the next one (at index + 1)
			prevNode.setNext(nodeToDelete.getNext());
		
			// Set next of nodeToDelete to null.
			nodeToDelete.setNext(null);
		}
		
		// Decrement the size
		size--;
			
	}

	@Override
	public Object retrieve(int index) throws IndexOutOfBoundsException 
	{
			if (index < 0 || index >= size())
				throw new IndexOutOfBoundsException();
			
			Node currentNode = head;
			
			for (int currentIndex = 0; currentIndex < index && currentNode != null; currentIndex++) 
			{
				currentNode = currentNode.getNext();
			}
			return currentNode.getData();
		}

	@Override
	public int indexOf(Object data) 
	{
		int index = 0;
		Node currentNode = head;
		
		while (currentNode != null) 
		{
			if (currentNode.getData().equals(data))
				return index;
			index++;
			currentNode = currentNode.getNext();
		}
		
		return -1;
	}

	@Override
	 public boolean contains(Object data) 
	  {
			int index = indexOf(data);
			if (index >= 0) {
			return true;
			}else {
				return false;
			}

		}
	
	public void clear() 
	{
		this.head = null;
		this.size = 0;
	}

	
}