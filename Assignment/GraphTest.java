import java.util.*;
import java.io.FileInputStream; 
import java.io.FileOutputStream; 
import java.io.ObjectInputStream; 
import java.io.ObjectOutputStream; 
import java.io.Serializable; 

public class GraphTest 
{
	public static void main(String[] args)
	{
		DSAGraph graphing = new DSAGraph();
		DSAGraphVertex vertex = new DSAGraphVertex("BN", "BIA");
		//DSAGraphEdge edge = new DSAGraphEdge();
		DSALinkedList adjacentList;
		Iterator graph_Iter;
		
		System.out.print("\nTESTING DSAGraphVertex \n");
		System.out.print("Label = "+vertex.getLabel()+"\n");
		System.out.print("Value = "+vertex.getValue()+"\n");
		vertex.addEdge(vertex);
		System.out.print("Vertex List = "+vertex.getAdjacent()+"\n");
		System.out.print(vertex.toString()+"\n");
		
		
		//System.out.print("\nTESTING DSAGraphEdge \n");
	
	
		System.out.print("\nTESTING addVertex() : \n");
		graphing.addVertex("KL", "KLIA");
		graphing.addVertex("SG", "CHANGI");
		graphing.addVertex("KL", "KLIA");
		graphing.addVertex("BN", "BIA");
		graphing.addVertex("MIRI", "MA");
		System.out.print("//----------------------------------------------------------------------");
		System.out.print("\nTESTING addEdge():\n");
		graphing.addEdge("KL", "SG", "KLSG", "1hours" );
		graphing.addEdge("KL", "KL", "KLKL", "0hours");
		graphing.addEdge("MIRI", "KL", "MIRIKL", "2hours");
		graphing.addEdge("BN", "SG", "BNSG", "2hours");
		graphing.addEdge("BN", "SG", "BNSG", "2hours");
		System.out.print("//----------------------------------------------------------------------");
		System.out.print("\nTESTING getVertexCount():\n");
		System.out.print("vertex count: "+graphing.getVertexCount()+"\n");
		System.out.print("//----------------------------------------------------------------------");
		System.out.print("\nTESTING getEdgeCount():\n");
		System.out.print("vertex count: "+graphing.getEdgeCount()+"\n");
		System.out.print("//----------------------------------------------------------------------");
		System.out.print("\nTESTING getAdjacent():\n");
		System.out.print("Vertex that is adjacent to KL\n");
		 adjacentList = graphing.getAdjacent("KL");
            graph_Iter = adjacentList.iterator();
            while(graph_Iter.hasNext())
            {
                System.out.println(graph_Iter.next());
            }
		System.out.print("Vertex that is adjacent to SG\n");
		 adjacentList = graphing.getAdjacent("SG");
            graph_Iter = adjacentList.iterator();
            while(graph_Iter.hasNext())
            {
                System.out.println(graph_Iter.next());
            }
		System.out.print("//----------------------------------------------------------------------");
		System.out.print("\nTESTING getVertex():\n");
		System.out.print("Vertex "+graphing.getVertex("KL"));
		System.out.print("Vertex "+graphing.getVertex("BN"));
		System.out.print("//----------------------------------------------------------------------");
		System.out.print("\nTESTING getEdge():\n");
		System.out.print(graphing.getEdge("KLSG"));
		System.out.print(graphing.getEdge("BNSG"));
		System.out.print("//----------------------------------------------------------------------");
		System.out.print("\nTESTING updateVertex():\n");
		graphing.updateVertex("BN", "BSB" );
		System.out.print("//----------------------------------------------------------------------");
		System.out.print("\nTESTING displayAsList():\n");
		graphing.displayAsList();
    }//end of main
}//end of class


