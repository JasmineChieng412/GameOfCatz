/* FILE:	DSAQueue.java
   AUTHOR:	Jasmine Aanstasha Chieng Kiu Ying
   USERNAME:	jasmine_chieng
   UNIT:	COMP1002 Data Structures and Algorithm
   PURPOSE:	This .java file contains all the methods needed to run in DSAQueueTestHarness.java
   REFERENCE:	Curtin University of Technology. 2020."Lecture 3: STACKS, QUEUES AND OBJECTS." PDF format.
   LAST MOD:	
   COMMENTS:	-
*/

import java.util.*;

public class DSAQueue implements Iterable
{
	int count;
	DSALinkedList list;

    /************************************************************
    * Default constructor: DSAShufflingQueue()
    * IMPORT: none
    * EXPORT: none
    * ASSERTION: set default values for the queue
    ************************************************************/
    public DSAQueue()
    {
		list = new DSALinkedList();
		count = 0;//counter starts from zero means queue is empty
    }


    /************************************************************
    * ACCESSOR: getCount()
    * IMPORT: none (Object)
    * EXPORT: count (Object)
    * ASSERTION: gets count's value
    ************************************************************/
    public int getCount()
    {
        return count;
		//counts the number of elements in the queue and 
		//returns the value to check if it is EMPTY or FULL
    }
    
    /************************************************************
    * ACCESSOR: iterator()
    * IMPORT: none
    * EXPORT: list
    * ASSERTION: iterates through the list
    ************************************************************/
	public Iterator iterator() //Return a new Iterator of internal type DSALinkedListIterator
	{
		return list.iterator();//Hook the iterator to this DSALinkedList object
	}

	/************************************************************
    * ACCESSOR: isEmpty()
    * IMPORT: none
    * EXPORT: list.isEmpty() (boolean)
    * ASSERTION: check if stack is empty (will return true if it is empty)
    ************************************************************/
    public boolean isEmpty()
    {
		return (list.isEmpty());
    }

    /************************************************************
    * ACCESSOR: peek()
    * IMPORT: none
    * EXPORT: topVal
    * ASSERTION: Looks at the top of the stack and returns the top-most value 
    ************************************************************/
	public Object peek()
	{
	    Object top = null;
        
        try
        {
        	if(isEmpty())
        	{
        		throw new ArrayIndexOutOfBoundsException("Queue IS EMPTY!\n");
        	}
        	else
        	{
        		top = list.peekFirst();
			}
        }
        catch(ArrayIndexOutOfBoundsException e)
        {
        	System.out.print(e.getMessage());
        }
        return top;
    }
    
    /************************************************************
    * ACCESSOR: enqueue()
    * IMPORT: value (Object)
    * EXPORT: queue (Object)
    * ASSERTION: adds a value to the rear of the queue
    ************************************************************/
    public void enqueue(Object value)
    {	 
		list.insertLast(value);
		count++;
    }

    /************************************************************
    * ACCESSOR: theQueue()
    * IMPORT: none
    * EXPORT: none 
    * ASSERTION: to print out the elements in the queue 
    ************************************************************/
    public String theQueue()
    {
		Object s;
		String stringQ = "";
		Iterator iter = list.iterator();
		
		while(iter.hasNext())
		{
			s = (Object)iter.next();
			stringQ = stringQ + "\n" + s.toString();
		}
		return stringQ;
    }

    /************************************************************
    * ACCESSOR: dequeue()
    * IMPORT: value (Object)
    * EXPORT: queue (Object)
    * ASSERTION: adds a value to the top of the queue
    ************************************************************/
    public Object dequeue()
    {
    	Object topVal = null;
        try
        {
        	if(isEmpty())
        	{
        		throw new ArrayIndexOutOfBoundsException("Queue IS EMPTY!\n");
        	}
        	else
        	{
        		topVal = list.peekFirst();
        		list.removeFirst();
        		count--;
        	}
        }
        catch(ArrayIndexOutOfBoundsException e)
        {
        	System.out.print(e.getMessage());
        }
        return topVal;
    }
}//end of class




