/* FILE:	DSALinkedList.java
   AUTHOR:	Jasmine Aanstasha Chieng Kiu Ying
   USERNAME:	jasmine_chieng
   UNIT:	COMP1002 Data Structures and Algorithm
   PURPOSE:	To create a doubly linked list 
   REFERENCE:	Curtin University of Technology. 2020."Lecture 4: Linked Lists", 
   		jatinreaper, 29AjayKumar, Murali Krishna Marimekala, rathbhupendra, 
   		Akanksha_Rai. 2020. "Doubly Linked List | Set 1 (Introduction and Insertion)." GeeksforGeeks.
   		https://www.geeksforgeeks.org/doubly-linked-list/
   LAST MOD:	
   COMMENTS:	-
*/

import java.util.*;

public class DSALinkedList implements Iterable
{
    //Class fields 
    public DSAListNode head, tail, newNd, prevNd, lastNd;
    public Object nodeValue;
	
	
    //Default constructor
    public DSALinkedList()
    {
	head = null;//start with an empty list
	tail = null;//since there is no new node, tail points to nothing yet
    }
	
    //MUTATOR insertFirst IMPORT newValue(Object) EXPORT none
    //insert new node infront of head
    public void insertFirst (Object newValue)
    {	
	newNd = new DSAListNode(newValue);//set the value of the new node 
	newNd.next = head; //set new node's next to head node
        newNd.prev = null; //set previous of new node to null

	if(!(isEmpty()))
	{
	    //head = newNd;//point head to the first node
	    head.prev = newNd; //heads previous points to new node
	}
	    head = newNd;//head points to new node
    }
		
    //MUTATOR insertLast IMPORT newValue (Object) EXPORT none
    //insert new node at the end
    public void insertLast(Object newValue)
    {
	newNd = new DSAListNode(newValue);
	lastNd = head;
	newNd.next = null; 
		
	if(isEmpty())
	{
	    newNd.prev = null; //new node's previous is null
            head = newNd;//head points to new node        
	}
	else
	{	
	    while( lastNd.getNext() != null )//last node's next does not equal to null
	    {
		// Traverse to last node 
		lastNd = lastNd.getNext();
	    }
			
	    lastNd.setNext(newNd);//set last node's next to new node's next
	    newNd.prev = lastNd;//set new node's previous to point to last node
	}
    }

    //ACCESSOR isEmpty IMPORT none EXPORT empty (boolean)
    public boolean isEmpty()
    {
	boolean empty;//declaring variable
	//System.out.print("EMPTY\n");
	return empty = (head == null);//return a T if list is empty and F if it is not
    }
	
    //ACCESSOR peekFirst IMPORT none EXPORT nodeValue (Object)
    public Object peekFirst()
    {
	if(isEmpty()) 
	{
	    //if list id empty, it will output error message
	    System.out.print("List is EMPTY!!");
	}
	else
	{
	    //if list is not empty, node's value is updated
	    nodeValue = head.getValue();
	}
	return nodeValue;
    }
	
    //ACCESSOR peekLast IMPORT none EXPORT nodeValue (Object)
    public Object peekLast()
    {
	if (isEmpty())
	{
	    //if list is empty, it will output error message
	    throw new IllegalArgumentException("List is EMPTY!!");  //System.out.print("List is EMPTY!!");
	}
	else
	{
	    lastNd = head;
	    while( lastNd.getNext() != null)
	    { 
		// Traverse to last node
		lastNd = lastNd.getNext();
	    }
	    nodeValue = lastNd.getValue();
	}
	return nodeValue;
    }

    //MUTATOR removeFirst IMPORT none EXPORT nodeValue (Object)
    public Object removeFirst()
    {
	if(isEmpty()) 
	{
	    throw new IllegalArgumentException("List is EMPTY!!");//System.out.print("List is EMPTY!!");
	}
	else
	{
	    nodeValue = head.getValue();
	    head = head.getNext();
	}
	return nodeValue;
    }
	
    //MUTATOR removeLast IMPORT none EXPORT nodeValue (Object)
    public Object removeLast()
	{
	    if( isEmpty())
	    {
		throw new IllegalArgumentException("List is EMPTY!!");//System.out.print("List is EMPTY!!");
	    }	
	    else if(head.getNext() == null) 
	    {
		nodeValue = head.getValue();
		head = null;
	    }
	    else
	    {
		prevNd = null;
		lastNd = head;
		while( lastNd.getNext() != null)
		{
		    prevNd = lastNd;//traversing to the last node
		    lastNd = lastNd.getNext();//going to the second-last node
		    //to remove the last node from the list
		}
		prevNd.setNext(null);
		// Remove lastNd from list
		nodeValue = lastNd.getValue();
		// Return value of node that is being removed
	    }
	    return nodeValue;
	}
	
	public void printlist(DSAListNode node) 
    	{ 
	    DSAListNode lastNd = null; 
	    System.out.println("Traversal in forward Direction: "); 
	    while (node != null) 
	    { 
		System.out.print(node.value + " "); 
          	lastNd = node; 
         	node = node.next; 
            } 
            
	    System.out.println("\nTraversal in reverse direction: "); 
            while (lastNd != null) 
            { 	
            	System.out.print(lastNd.value + " "); 
            	lastNd = lastNd.prev; 
            } 	
            System.out.print("\n\n");
    	}


	//ITERATOR
	public Iterator iterator() //← Return a new Iterator of internal type DSALinkedListIterator
	{
		return new DSALinkedListIterator(this);//← Hook the iterator to this DSALinkedList object
	}
		
	private class DSALinkedListIterator implements Iterator //← Private class inside DSALinkedList
	{
		private DSAListNode iterNext;//← Cursor (assuming DSAListNode is the node class of DSALinkedList)
		
		public DSALinkedListIterator(DSALinkedList theList) 
		{
			iterNext = theList.head;//← NOTE: Able to access private field of DSALinkedList
		}

		// Iterator interface implementation
		public boolean hasNext() 
		{ 
			return (iterNext != null);//checks whether there are more values in the list
		}
		
		//aids to iterate through the list and returns the values to the main caller
		public Object next() 
		{
			Object value;
			if (iterNext == null)//check for null because last tail(next) will always points to null
			{
				value = null;//tells you the value is null
			}
			else 
			{
				value = iterNext.getValue();//← Get the value in the node
				iterNext = iterNext.getNext();//← Ready for subsequent calls to next()
			}
			return value;
		}
		
		public void remove() 
		{ 
			throw new UnsupportedOperationException("Not supported"); 
		}
	}	
	

}//end of class
