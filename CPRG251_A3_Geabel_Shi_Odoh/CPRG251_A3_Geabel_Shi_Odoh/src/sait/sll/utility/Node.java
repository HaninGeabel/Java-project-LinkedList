/**
 * 
 */
package sait.sll.utility;

import java.io.Serializable;


/**
 * @author Hanin Geabel
 * @author Deborah Odoh
 * @author Henry Shi
 * @version 2022-04-02
 *
 */

public class Node implements Serializable{

  private Object data;
  private Node next;

    /**
	 * User-defined constructor to create a new node.
	 * @param data Data in node.
	 */
	public Node(Object data) 
	{
		this.data = data;
	}
	
	/**
	 * Gets the data in the node.
	 * @return data
	 */
	public Object getData() 
	{
		return data;
	}
	
	/**
	 * Sets the data in the node.
	 * @param data New data
	 */
	public void setData(Object data) 
	{
		this.data = data;
	}
	
	/**
	 * Gets the next node or null (if there is no next node).
	 * @return Next node.
	 */
	public Node getNext() 
	{
		return next;
	}
	
	/**
	 * Sets the next node.
	 * @param next New next node.
	 */
	public void setNext(Node next) 
	{
		this.next = next;
	}
}