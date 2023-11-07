/* FILE:		DSAGraphEdge.java
   AUTHOR:		Jasmine Aanstasha Chieng Kiu Ying
   USERNAME:	jasmine_chieng
   UNIT:		COMP1002 Data Structures and Algorithm
   PURPOSE:		To create and graph edges
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

public class DSAGraphEdge 
{

	//CLASS FIELDS: 
	public String label;
	public Object value; 
	public DSAGraphVertex from, to;
	
	
	//CONSTRUCTOR DSAGraphEdge IMPORTS fromVertex, toVertex, inLabel, inValue
	public DSAGraphEdge(DSAGraphVertex fromVertex, DSAGraphVertex toVertex, String inLabel, Object inValue)
	{
		  label = inLabel;
		  value = inValue;
          from = fromVertex;
          to = toVertex;
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
		
	//ACCESSOR getTo IMPORTS NONE EXPORTS vertex
	public DSAGraphVertex getFrom()
	{
		return from;
	}
		
	//ACCESSOR getTo IMPORTS NONE EXPORTS vertex
	public DSAGraphVertex getTo()
	{
		return to;
	}
		
	//ACCESSOR isDirected IMPORTS NONE EXPORTS boolean
	public boolean isDirected()
	{
		return false; 
	}
		
	//ACCESSOR toString IMPORTS NONE EXPORTS string
	public String toString()
	{
		return "EdgeLabel: " + label+"\nEdgeValue: "+value+"\nFrom :"+from+"To:"+to+"\n";
	}
	

}//end of class
