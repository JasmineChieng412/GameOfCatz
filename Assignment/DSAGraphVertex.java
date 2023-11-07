/* FILE:		DSAGraphVertex.java
   AUTHOR:		Jasmine Aanstasha Chieng Kiu Ying
   USERNAME:	jasmine_chieng
   UNIT:		COMP1002 Data Structures and Algorithm
   PURPOSE:		To create and graph vertices
   REFERENCE:	Curtin University of Technology. 2020."Lecture 6: Graphs.", 
   				Singhal,Rajat, Kanal Malhotra, av_sharma01, Viru_UIC, techno2mahi,
   				nailwalhimanshu & Akanksha_Rai. 2020. "Graph and Its Representations." GeeksforGeeks.
   				https://www.geeksforgeeks.org/graph-and-its-representations/
   LAST MOD:	29/09/2021
   COMMENTS:	-
*/

import java.util.*;
import java.io.FileInputStream; 
import java.io.FileOutputStream; 
import java.io.ObjectInputStream; 
import java.io.ObjectOutputStream; 
import java.io.Serializable;

public class DSAGraphVertex
{
	//CLASS FIELDS
	public String label;
	public Object value;
	public DSALinkedList vertexList;//DSALinkedList class object
	public boolean visited;
	
	//CONSTRUCTOR DSAGraphVertex IMPORTS inLabel, inValue
	public DSAGraphVertex(String inLabel, Object inValue)
	{
		label = inLabel;
		vertexList = new DSALinkedList();
		visited = false;
		value = inValue;
	}
	
	//ACCESSOR getLabel IMPORTS NONE EXPORTS label
	public String getLabel()
	{
		return label;
	}
		
	//ACCESSOR getValue IMPORTS NONE EXPORTS value
	public Object getValue()
	{
		return value;
	}
		
	//ACCESSOR getAdjacent IMPORTS NONE EXPORTS vertexList
	public DSALinkedList getAdjacent( )
	{
		return vertexList;
	}
		
	//MUTATOR addEdge IMPORTS vertex EXPORTS NONE
	public void addEdge(DSAGraphVertex vertex)
	{
		vertexList.insertLast(vertex);
	}
		
	//MUTATOR setVisited IMPORTS NONE EXPORTS NONE
	public void setVisited()
	{
		visited = true;
	}
			
	//MUTATOR clearVisited IMPORTS NONE EXPORTS NONE
	public void clearVisited()
	{
		visited = false;
	}
		
	//ACCESSOR getVisited IMPORTS NONE EXPORTS Boolean
	public boolean getVisited()
	{
		return visited;
	}
		
	//ACCESSOR toString IMPORTS NONE EXPORTS string
	public String toString()
	{
		return label+"\nvalue: "+ value+"\n";
	}
	

	
}//end of class
