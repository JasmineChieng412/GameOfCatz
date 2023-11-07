/* FILE		:	DSAStack.java
   AUTHOR	:	Jasmine Aanstasha Chieng Kiu Ying
   USERNAME	:	jasmine_chieng
   UNIT		:	COMP1002 Data Structures and Algorithm
   PURPOSE	:	This .java file contains all the methods needed to run in DSAStackTestHarness.java
   REFERENCE:	Curtin University of Technology. 2020."Lecture 3: STACKS, QUEUES AND OBJECTS." PDF format.
   LAST MOD	:	29/09/2021
   COMMENTS	:	-
*/

import java.util.*;
import java.util.Iterator;

public class DSAStack implements Iterable
{
    //Class fields (Global Variable) 
    public int count; // variable declaration to store counter of elements being stored
    DSALinkedList list;
	
    //Class constant (value of this variable is never changed)
    public int DEFAULT_CAPACITY = 100;// default capacity for the stack

    /************************************************************
    * Default constructor: DSAStack()
    * IMPORT: none
    * EXPORT: none
    * ASSERTION: sets default values for the stack and counter
    ************************************************************/
    public DSAStack()
    {
		count = 0;//counter starts from zero
		list = new DSALinkedList();
    }

    /************************************************************
    * ACCESSOR: getCount()
    * IMPORT: none
    * EXPORT: count (int)
    * ASSERTION: get and returns count's capacity
    ************************************************************/
    public int getCount()
    {
        return count;//counts the number of stacks and returns the value to check if it is EMPTY
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
    * ACCESSOR: push()
    * IMPORT: value
    * EXPORT: none
    * ASSERTION: adds values to the stack
    ************************************************************/
    public void push(Object value)
    {
		count = getCount();
		list.insertFirst(value);
		count++;
    }

	/************************************************************
    * ACCESSOR: getStack()
    * IMPORT: none
    * EXPORT: none
    * ASSERTION: displays the stack on the terminal
    ************************************************************/
    public String getStack()
    {	
		Object s;
		String stringS = "";
		Iterator iter = list.iterator();
		
		while(iter.hasNext())
		{
			s = (Object)iter.next();
			stringS = stringS + "\n" + s.toString();//converts s to String
		}
		return stringS;
	}

    /************************************************************
    * ACCESSOR: pop()
    * IMPORT: none
    * EXPORT: topVal(Object)
    * ASSERTION: deletes/removes a value from the stack
    ************************************************************/
    public Object pop()
    {
    	Object top = null;
        try
        {
        	if(isEmpty())
        	{
        		throw new ArrayIndexOutOfBoundsException("Nothing to pop: Stack is empty!\n");
        	}
        	else
        	{
        		top = list.peekFirst();
        		list.removeFirst();
        		count--;
        	}
        }
        catch(ArrayIndexOutOfBoundsException e)
        {
        	System.out.print(e.getMessage());
        }
        return top;
    }

    /************************************************************
    * ACCESSOR: top()
    * IMPORT: none
    * EXPORT: topVal
    * ASSERTION: Looks at the top of the stack and returns the top-most value 
    ************************************************************/
    public Object top()
    {
        Object peek = null;
        
        try
        {
        	if(isEmpty())
        	{
        		throw new ArrayIndexOutOfBoundsException("Nothing to pop: Stack is empty!\n");
        	}
        	else
        	{
        		peek = list.peekFirst();
			}
        }
        catch(ArrayIndexOutOfBoundsException e)
        {
        	System.out.print(e.getMessage());
        }
        return peek;
    }
}//end of class
