/* FILE			:	 	DSAGraph.java
   AUTHOR		:		Jasmine Aanstasha Chieng Kiu Ying
   USERNAME		:		jasmine_chieng
   UNIT			:		COMP1002 Data Structures and Algorithm
   PURPOSE		:		
   REFERENCE		:		Curtin University of Technology. 2020."Lecture 6: Graphs.", 
   					    Singhal,Rajat, Kanal Malhotra, av_sharma01, Viru_UIC, techno2mahi,
   					    nailwalhimanshu & Akanksha_Rai. 2020. "Graph and Its Representations." GeeksforGeeks.
   					    https://www.geeksforgeeks.org/graph-and-its-representations/
   LAST MOD		:		19/10/2021
   COMMENTS		:		-
*/

import java.util.*;
import java.io.Serializable;
import java.util.Iterator;


public class DSAGraph 
{	
    //FIELDS: 
    public DSALinkedList verticesList, edgesList;
    public DSAGraphVertex vertex, vertex1, vertex2;
    public boolean visited;
    public int countV, countE;
    public DSAGraphEdge edges;
	
    /************************************************************
    * Alternative Constructor:DSAGraph
    * IMPORT: none
    * EXPORT: address of new DSAGraphVertex object
    * ASSERTION: initialise to add a vertex
    ************************************************************/
    public DSAGraph()
    {
    	countV = 0;
    	countE = 0;
    	visited = false;
    	verticesList = new DSALinkedList();//points to a list node
    	edgesList = new DSALinkedList();//points to a list node
    }	
	
	/************************************************************
    * MUTATOR: addVertex
    * IMPORT: label[, value]
    * EXPORT: NONE
    * ASSERTION: to add a vertex and its value into the linked list
    ************************************************************/
    public void addVertex(String label, Object value)
    {
       if (hasVertex(label)) //check for potential duplicate
        {
            System.out.print("Vertex exist, use a unique name\n");         
        }
        else
        {
        	DSAGraphVertex newVertex = new DSAGraphVertex(label, value);
            verticesList.insertLast(newVertex);//insert new vertex into verticesList
            countV++;
        }
    }	
	
    /************************************************************
    * MUTATOR:addEdge
    * IMPORT: label1, label2, inLabel, inValue
    * EXPORT: NONE
    * ASSERTION: to create an edge between 2 labels(vertices)
    ************************************************************/
    public void addEdge(String label1, String label2, String inLabel, Object inValue)
    {
    	boolean existingEdge = false;
        Iterator edge_Iter;
    	DSALinkedList v1 = getAdjacent(label1);
        DSALinkedList v2 = getAdjacent(label2);

        edge_Iter = v1.iterator();
        while(edge_Iter.hasNext())
        {
            vertex = (DSAGraphVertex)(edge_Iter.next());

            if((vertex.getLabel()).equals(label2))
            {
                existingEdge = true;
            }
        }

        edge_Iter = v2.iterator();
        while(edge_Iter.hasNext())
        {
            vertex = (DSAGraphVertex)(edge_Iter.next());

            if((vertex.getLabel()).equals(label1))
            {
                existingEdge = true;
            }
        }
            
    	if (verticesList == null)//vertex list is empty
        {
            System.out.print("You need to create a vertex first\n");
        }
        else if (label1.equals(label2))//checking if the labels(vertices) have the same name
        {
            System.out.print("Same vertex name is not allow to add edge\n");
        }
        else if(existingEdge)
        {
        	System.out.print("This edge already exist!\n");
        }
        else
        {
            //find the vertex position first, create undirected link
             vertex1 = getVertex(label1);
             vertex2 = getVertex(label2);
            if (vertex1 == null || vertex2 == null)
            {
                System.out.print("Vertex don't exist, first create vertex\n");
            }
            else 
            {
                vertex1.addEdge(vertex2);
                vertex2.addEdge(vertex1);
                countE++;
                DSAGraphEdge newEdge = new DSAGraphEdge(vertex1, vertex2, inLabel, inValue);
                edgesList.insertLast(newEdge);//insert edge to edge list
            }
        }
	}
	
    //ACCESSOR hasVertex IMPORTS label EXPORTS boolean
    /************************************************************
    * ACCESSOR:hasVertex
    * IMPORT: label (String)
    * EXPORT: (boolean)
    * ASSERTION: check if the label(vertex) already existed
    ************************************************************/
    public boolean hasVertex(String label)
    {	
       	boolean hasV = false; // set to false because the vertex does not exist
        Iterator iterator = verticesList.iterator();

        while(iterator.hasNext())
        {
            DSAGraphVertex currentVertex = (DSAGraphVertex)(iterator.next());
            if((currentVertex.getLabel()).equals(label))
            {
                hasV = true;//if vertex already exist then set hasV to true
            }
        }

        return hasV;
    }	

    /************************************************************
    * ACCESSOR:getVertexCount
    * IMPORT: NONE
    * EXPORT: (int)
    * ASSERTION: 
    ************************************************************/
    public int getVertexCount()
    {
    	return countV;
    }	

    /************************************************************
    * ACCESSOR:getEdgeCount
    * IMPORT: NONE
    * EXPORT: (int)
    * ASSERTION: 
    ************************************************************/
    public int getEdgeCount()
    {
    	return countE;
    }	

    /***********************************************************
    * ACCESSOR:getVertex
    * IMPORT: labelSearch(String)
    * EXPORT: (DSAGraphVertex)
    * ASSERTION: to fine a vetex in the vertex list
    ************************************************************/
    public DSAGraphVertex getVertex(String labelSearch)
    {
        Iterator verticesListIter = verticesList.iterator();
        DSAGraphVertex graphVertex = null;
        DSAGraphVertex temp = null;//to store

	//iterate through vertex list
        while (verticesListIter.hasNext() && graphVertex == null) 
        { //once found immediately stop
            temp = (DSAGraphVertex)verticesListIter.next();//temporarily store the vertex into temp
            if (labelSearch.equals(temp.getLabel()))//
            {
                graphVertex = temp;
            }
        }
        return graphVertex;
    }

    /************************************************************
    * ACCESSOR:getEdge
    * IMPORT:labelSearch
    * EXPORT: DSAGraphEdge
    * ASSERTION: find the edges in the edge list 
    ************************************************************/
    public DSAGraphEdge getEdge(String labelSearch)
    {
        Iterator edgesListIter = edgesList.iterator();
        DSAGraphEdge graphEdge = null;
        DSAGraphEdge vertexTemp = null;

	//iterate through the edge List
        while (edgesListIter.hasNext()) 
        {
            vertexTemp = (DSAGraphEdge)edgesListIter.next();
            if (labelSearch.equals(vertexTemp.getLabel()))
            {
                graphEdge = vertexTemp;
            }
        }

        return graphEdge;
    } 
		
    /************************************************************
    * ACCESSOR:getAdjacent
    * IMPORT: label (String)
    * EXPORT: vertexList
    * ASSERTION:find the adjacent vertices of a vertex 
    ************************************************************/
    public DSALinkedList getAdjacent(String label)
    {
        DSALinkedList list = new DSALinkedList();
        Iterator vertex_Iter; 
        DSAGraphVertex adjacentVertexList; 
        
        adjacentVertexList = getVertex(label);//find the vertex

        // creating adjacent vertex list
        if(adjacentVertexList != null)
        {
            vertex_Iter = edgesList.iterator();

	    //iterate through edge list to find the adjacent vertices
            while(vertex_Iter.hasNext())
            {
                DSAGraphEdge tempEdge = (DSAGraphEdge)(vertex_Iter.next());

		//if edge is found, check the start and end vertex
                if(tempEdge.getFrom() == adjacentVertexList)
                {
                    list.insertLast(tempEdge.getTo());
                }

                if(tempEdge.getTo() == adjacentVertexList)
                {
                    list.insertLast(tempEdge.getFrom());
                }
            }
        }
        return list;
    }		
	
    /************************************************************
    * ACCESSOR:getAdjacentE
    * IMPORT: label (String)
    * EXPORT: vertexList
    * ASSERTION: 
    ************************************************************/
    public DSALinkedList getAdjacentE(String label)
    {   
        DSALinkedList list = new DSALinkedList();  
        Iterator iterator;
	DSAGraphEdge adjacentEdge = getEdge(label);//find edge

        // store adjacent edge into a list
        if(adjacentEdge != null)
        {
            vertex1 = adjacentEdge.getFrom();
            vertex2 = adjacentEdge.getTo();

            iterator = edgesList.iterator();

	    //iterate through edge list
            while(iterator.hasNext())
            {
                adjacentEdge = (DSAGraphEdge)(iterator.next());

                if(adjacentEdge.getFrom() == vertex1 && adjacentEdge.getTo() != vertex2)
                {
                    list.insertLast(adjacentEdge);
                }

                if(adjacentEdge.getFrom() == vertex2 && adjacentEdge.getTo() != vertex1)
                {
                    list.insertLast(adjacentEdge);
                }

                if(adjacentEdge.getTo() == vertex1 && adjacentEdge.getFrom() != vertex2)
                {
                    list.insertLast(adjacentEdge);
                }

                if(adjacentEdge.getTo() == vertex2 && adjacentEdge.getFrom() != vertex1)
                {
                    list.insertLast(adjacentEdge);
                }
            }
        }

        return list;
    }					
    
    public void updateVertex(String label, Object newValue)
    {
    	DSAGraphVertex theUpdate = new DSAGraphVertex(label, newValue);//store in new vertex data
    	DSAGraphVertex updatedVertex;
    	updatedVertex=theUpdate;
    	System.out.print(updatedVertex);
    }
    			
	/************************************************************
    * ACCESSOR:displayAsList
    * IMPORT: NONE
    * EXPORT: NONE
    * ASSERTION: to display the vertices and edges as list
    ************************************************************/
    public void displayAsList()
    {
        String[][] list = new String[getVertexCount()][getVertexCount() + 1];
        Iterator display_Iter; 
        int i,j;
        Iterator mainList = verticesList.iterator(); 
        DSAGraphVertex current; 
        DSALinkedList adjacent;

        for(i = 0; i < getVertexCount(); i++)
        {
            current = (DSAGraphVertex)mainList.next();
            list[i][0] = current.getLabel();
            list[i][1] = ":";
            adjacent = getAdjacent(current.getLabel());
            display_Iter = adjacent.iterator();
            j = 2; 

            while(display_Iter.hasNext())
            {
                list[i][j] = ((DSAGraphVertex)display_Iter.next()).getLabel();
                j++;
            }

            while(j <= getVertexCount())
            {
                list[i][j] = "";
                j++;
            }
        }

        for(i = 0; i < getVertexCount(); i++)
        {
            for(j = 0; j < getVertexCount() + 1; j++)
            {
                System.out.print(list[i][j] + " ");
            }

            System.out.println();
        }
    }
    
    public DSABinarySearchTree DFS()
    {
    	DSAStack S = new DSAStack();
    	DSABinarySearchTree T = new DSABinarySearchTree();//set T={}
    	DSALinkedList newVerticesList = new DSALinkedList();
    	DSAGraphVertex setNewV;
    	DSAGraphVertex setOldV;
    	DSAGraphVertex w=null;
    	DSAGraphVertex checkVisit;
    	
    	//1. set all vertices to new    	
    	 DSALinkedList list = new DSALinkedList(); // store return value
        Iterator vertex_Iter; 

        if(verticesList != null)
        {
            vertex_Iter = verticesList.iterator();

            while(vertex_Iter.hasNext())
            {
                setNewV = (DSAGraphVertex)(vertex_Iter.next());
                setNewV.clearVisited();
             }
        }

    	
    	// 2. set any vertex to old
        setOldV = (DSAGraphVertex)(verticesList.removeFirst());
        setOldV.setVisited();
        verticesList.insertFirst(setOldV);
        
        // 3. push vertex onto stack S
        S.push(setOldV);
        
        // 4. while stack S is not empty 
        while(!S.isEmpty())
        {
        	list = getAdjacent(setOldV.getLabel());
        	vertex_Iter = list.iterator();
        	
        	while(w == null && vertex_Iter.hasNext())
            {
                checkVisit = (DSAGraphVertex)(vertex_Iter.next());
                if(!checkVisit.getVisited())
                {
                    w = checkVisit;
                }
            }

            // while an adjacent vertex is new
            while(w != null)
            {
                System.out.print(setOldV.getLabel() + w.getLabel() + " ");
                T.insert(setOldV.getLabel(), setOldV.getValue());
                T.insert(w.getLabel(), w.getValue());

                // set next vertex as visited
                while(!verticesList.isEmpty())
                {
                    setNewV = (DSAGraphVertex)(verticesList.removeFirst());

                    if((setNewV.getLabel()).equals(w.getLabel()))
                    {
                        setNewV.setVisited();
                        w = setNewV;
                    }

                    newVerticesList.insertLast(setNewV);
                }

                // empty modify vertices and put in vertices
                while(!newVerticesList.isEmpty())
                {
                    setNewV = (DSAGraphVertex)(newVerticesList.removeFirst());
                    verticesList.insertLast(setNewV);
                }

                S.push(w);
                setOldV = w;

                // set adjacent list for current vertex
                list = getAdjacent(setOldV.getLabel());
                vertex_Iter = list.iterator();

                w = null;

                // true if no adjacent is new
                while(w == null && vertex_Iter.hasNext())
                {
                    checkVisit = (DSAGraphVertex)(vertex_Iter.next());
                    if(!checkVisit.getVisited())
                    {
                        w = checkVisit;
                    }
                }
            }
            setOldV = (DSAGraphVertex)(S.pop());
        }
        return T;
    }
    
  public DSABinarySearchTree BFS()
    {
        DSAQueue Q = new DSAQueue(); // stack
    	DSABinarySearchTree T = new DSABinarySearchTree();//set T={}
    	DSALinkedList newVerticesList = new DSALinkedList();
    	DSAGraphVertex setNewV=null;
    	DSAGraphVertex setOldV;
    	DSAGraphVertex w=null;
    	DSAGraphVertex checkVisit;

        //1. set all vertices to new    	
    	 DSALinkedList list = new DSALinkedList(); // store return value
        Iterator vertex_Iter; 

        if(verticesList != null)
        {
            vertex_Iter = verticesList.iterator();

            while(vertex_Iter.hasNext())
            {
                setNewV = (DSAGraphVertex)(vertex_Iter.next());
                setNewV.clearVisited();
             }
        }

    	
    	// 2. set the start vertex to old
        setOldV = (DSAGraphVertex)(verticesList.removeFirst());
        setOldV.setVisited();
        verticesList.insertFirst(setOldV);
        
        // 3. enqueue vertex into the queue
        Q.enqueue(setOldV);

        while(!Q.isEmpty())
        {
            setOldV = (DSAGraphVertex)(Q.dequeue());

            list = getAdjacent(setOldV.getLabel());
        	vertex_Iter = list.iterator();
        	
        	while(w == null && vertex_Iter.hasNext())
            {
                checkVisit = (DSAGraphVertex)(vertex_Iter.next());
                if(!checkVisit.getVisited())
                {
                    w = checkVisit;
                }
            }

            // while an adjacent vertex is new
            while(w != null)
            {
                System.out.print(setOldV.getLabel() + w.getLabel() + " ");
                T.insert(setOldV.getLabel(), setOldV.getValue());
                T.insert(w.getLabel(), w.getValue());

                // set next vertex as visited
                while(!verticesList.isEmpty())
                {
                    setNewV = (DSAGraphVertex)(verticesList.removeFirst());

                    if((setNewV.getLabel()).equals(w.getLabel()))
                    {
                        setNewV.setVisited();
                        w = setNewV;
                    }

                    newVerticesList.insertLast(setNewV);
                }

                // empty modify vertices and put in vertices
                while(!newVerticesList.isEmpty())
                {
                    setNewV = (DSAGraphVertex)(newVerticesList.removeFirst());
                    verticesList.insertLast(setNewV);
                }

                Q.enqueue(w);

                w = null;

                // sets w
                while(w == null && vertex_Iter.hasNext())
                {
                    checkVisit = (DSAGraphVertex)(vertex_Iter.next());
                    if(!checkVisit.getVisited())
                    {
                        w = checkVisit;
                    }
                }
         	}
        }
        return T;
    }
}//end of class	
