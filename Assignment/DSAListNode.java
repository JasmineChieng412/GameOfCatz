import java.util.*;

public class DSAListNode
{
    //Class fields  
    public Object value;
    public DSAListNode next, prev;
	
    /************************************************************
    * Alternate constructor: DSAListNode()
    * IMPORT: inValue (Object)
    * EXPORT: noone 
    * ASSERTION: sets alternate values for the following varaibles
    ************************************************************/
    public DSAListNode(Object inValue)
    {
	value = inValue;
	next = null;
	prev = null;
    }

    /************************************************************
    * ACCESSOR : getValue()
    * IMPORT: none 
    * EXPORT: value (Object)
    * ASSERTION: gets value's value
    ************************************************************/
    public Object getValue()
    {
	return value;
    }

    /************************************************************
    * MUTATOR : setValue()
    * IMPORT: inValue (Object)
    * EXPORT: none
    * ASSERTION: sets value
    ************************************************************/
    public void setValue(Object inValue)
    {
	value = inValue;
    }
	 
    /************************************************************
    * ACCESSOR : getNext()
    * IMPORT: none 
    * EXPORT: next (DSAListNode)
    * ASSERTION: gets next's value
    ************************************************************/
    public DSAListNode getNext()
    {
	return next;
    }
	
    /************************************************************
    * MUTATOR : setNext()
    * IMPORT: newNext  (DSAListNode)
    * EXPORT: none
    * ASSERTION: set one node's next to next node's next
    ************************************************************/
    public void setNext (DSAListNode newNext)
    {
	next = newNext;
    }

}//end of class

