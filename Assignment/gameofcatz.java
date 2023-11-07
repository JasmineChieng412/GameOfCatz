/* FILE		:	gameofcatz.java
   AUTHOR	:	Jasmine Aanstasha Chieng Kiu Ying
   USERNAME	:	jasmine_chieng
   UNIT		:	COMP1002 Data Structures and Algorithm
   PURPOSE	:	Contains the main() to call all the other functions from other files and implement methods
   REFERENCE	:	Chieng, Jasmine. 2021. "Lab 4: Linked Lists", Curtin University of Technology. 2019. COMP1002 DATA STRUCTURES AND 					ALGORITHMS. "LECTURE 4:Linked Lists and Iterators"
   				Chieng, Jasmine. 2021. "Lab 5: Trees", Curtin University of Technology. 2019. COMP1002 DATA STRUCTURES AND 					ALGORITHMS."LECTURE 5:Trees"
   				Chieng, Jasmine. 2021. "Lab 6: Graph", Curtin University of Technology. 2019. COMP1002 DATA STRUCTURES AND 					ALGORITHMS."LECTURE 6:Graphs"  				
   LAST MOD:	19/10/2021
   COMMENTS:	-
*/

import java.util.*;
import java.io.*;//for FileIO
import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.IOException;

public class gameofcatz
{
    //Turpin, Andrew & Patrick Peursum. 2009. SortsTestHarness.java.
    //https://lms.curtin.edu.au/bbcswebdav/pid-8165630-dt-content-rid-46951068_1/xid-46951068_1
    private static void usage() 
    {
		System.out.println(" \nUsage: java gameofcatz x");
		System.out.println("        where");
		System.out.println("        x is one of:");
		System.out.println("           -i -> Interacting testing environment");
		System.out.println("           -s -> simulation mode (usage: gameofcatz -s infile savefile)\n");
    }

    public static void main(String args[])
    {
    	Scanner sc = new Scanner(System.in);//scan for user input
    	String fileName = "gameofcatz.txt";//initialize fileName to be gameofcatz.txt
    	boolean stop = true;//to stop/continue the menu loop
    	int ans, options, value=0, route;//user inputs
    	readGraph load = new readGraph();//creating class object	
    	DSABinarySearchTree trees = new DSABinarySearchTree();//creating class object 
    	DSAGraph loadedFile=null; 
    	String saveFile, node=null, edge, newNode, newNode2;
    	
    	if(args.length < 1)
    	{
	    usage();//prints out message to user on how to input the correct arguments
    	}
    	else if(args[0].equals("-s")&&args.length < 4)
	{   
	    System.out.print("SIMULATION MODE HAS NOT YET BEEN IMPLEMENTED!\n");	
	}	
    	else if(args[0].equals("-i"))//testing which argument is stored in which args array
    	{
	   if(args.length == 1)
	   {
		do
	    	{
		    System.out.print("\nPlease select one of the following options:\n");
		    System.out.print("1) Load input file\n");
		    System.out.print("2) Node Operations\n");
		    System.out.print("3) Edge Operations\n");
		    System.out.print("4) Parameter Tweaks\n");
		    System.out.print("5) Display Graph\n");
		    System.out.print("6) Display World\n");
		    System.out.print("7) Generate Routes\n");
		    System.out.print("8) Display Routes\n");
		    System.out.print("9) Save Network\n");
		    System.out.print("10) EXIT\n");
		    System.out.print("\nAnswer: ");
				
		    ans = sc.nextInt();//user inputs an integer from 1-10
		
		    switch(ans)
		    {	
		   	case 1:
			//prompts user to select which data they want to load
			try
			{
			    sc.nextLine();//to scan next line 
			    System.out.print("Please enter the file name: \n");	
			    fileName = sc.nextLine();
			    loadedFile=load.readFile(fileName);
			}		
			catch(Exception e)
        		{
			    System.out.print("error: IOException\n");
        		}		 
		    	break;
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		    	case 2:
		    	try 
		    	{
		    	if(loadedFile!=null)
		    	{
				do
				{
				    System.out.print("\nPlease select one of the following options:\n");
				    System.out.print("1) Find a node\n");
				    System.out.print("2) Add a node\n");
				    System.out.print("3) remove a node\n");
				    System.out.print("4) update a node's value\n");
				    System.out.print("5) EXIT\n");
				    System.out.print("\nAnswer: ");
				
				    options = sc.nextInt();
						
				    switch(options)
				    {
					case 1:
					    node = sc.nextLine();
					    System.out.print("\nPlease enter the node you wish to find: ");
					    node = sc.nextLine();
								
					    System.out.print("Found:"+loadedFile.getVertex(node));
					break;
								
					case 2:
					    newNode = sc.nextLine();
					    System.out.print("\nPlease enter the node you wish to add: ");
					    newNode = sc.nextLine();
								
					    System.out.print("\nPlease enter the value for the nodefrom the 4 options: ");
					    System.out.print("\n[0 / 1 / -1 / 100]\n");
					    value = sc.nextInt();
								
					    if(value==0 || value==1 || value==-1 || value==100 )
					    {
						loadedFile.addVertex(newNode, value);
						System.out.print("New node added!\n");
					    }
					break;
								
					case 3:
						newNode = sc.nextLine();
					    System.out.print("\nPlease enter the node you wish to add: ");
					    newNode = sc.nextLine();
					    
					    loadedFile.updateVertex(newNode, value);
					    System.out.print("\nUPDATED!\n");
					break;
					case 4:
					    System.out.print("MENU OPTION HAS NOT YET BEEN IMPLEMENTED!\n");
					break;
					case 5:
					    stop = false;//when condition is false, the loop will stop
					break;
				    }
				}while(stop);
			    stop=true;//set to true again so that the main menu can loop again until the user wants to exit	
		    	}
		    	else
		    	{
		    		System.out.print("PLEASE LOAD A FILE FIRST!\n");
		    	}
		    	}
		    	catch(Exception e)
		    	{
			    System.out.print("ERROR\n");
		    	}
		    break;
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		    case 3:
		    try
		    {
		    	if(loadedFile!=null)
				{
				do
				{
				    System.out.print("\nPlease select one of the following options:\n");
				    System.out.print("1) Find an edge\n");
				    System.out.print("2) Add an edge\n");
				    System.out.print("3) remove an edge\n");
				    System.out.print("4) update an edge\n");
				    System.out.print("5) EXIT\n");
				    System.out.print("\nAnswer: ");
				
				    options = sc.nextInt();
						
				    switch(options)
				    {
					case 1:
					    node = sc.nextLine();
					    System.out.print("\nPlease enter the edge you wish to find: ");
					    node = sc.nextLine();
								
					    System.out.print("Found:"+loadedFile.getEdge(node));
					break;
								
					case 2:
					    newNode = sc.nextLine();
					    System.out.print("\nPlease enter the edge: \n");
					    System.out.print("\nFrom: ");
					    newNode = sc.nextLine();
					    System.out.print("\nTo: ");
					    newNode2 = sc.nextLine();
								
						loadedFile.addEdge(newNode, newNode2, newNode+newNode2, 0);
						System.out.print("New edge added!\n");
					break;
								
					case 3:
						System.out.print("MENU OPTION HAS NOT YET BEEN IMPLEMENTED!\n");
					break;
					case 4:
					    System.out.print("MENU OPTION HAS NOT YET BEEN IMPLEMENTED!\n");
					break;
					case 5:
					    stop = false;//when condition is false, the loop will stop
					break;
				    }
				}while(stop);
					
			    stop=true;//set to true again so that the main menu can loop again until the user wants to exit	
		    	}
		    	else
		    	{
		    		System.out.print("PLEASE LOAD A FILE FIRST!\n");
		    	}
		    	}
		    	catch(Exception e)
		    	{
			    System.out.print("ERROR\n");
		    	}
		    break;
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		    case 4:
			System.out.print("MENU OPTION HAS NOT YET BEEN IMPLEMENTED!\n");
		    break;
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		    case 5:
			System.out.print("MENU OPTION HAS NOT YET BEEN IMPLEMENTED!\n");			
		    break;
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		    case 6:
			System.out.print("MENU OPTION HAS NOT YET BEEN IMPLEMENTED!\n");
		    break;
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	    	    case 7:
			System.out.print("Please select 1 or 2:");
			route=sc.nextInt();
			
			if(route == 1)
			{
			    trees=loadedFile.DFS();
			    System.out.print("GENERATED!\n");
			}
			else if(route == 2) 
			{
			    trees=loadedFile.BFS();
			    System.out.print("GENERATED!\n");
			}
			else
			{
			    System.out.print("Please enter 1 or 2 only\n");
			}
		    break;
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		    case 8:
			System.out.print("Displaying route:\n");
			trees.display();
		    break;
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		    case 9:
			System.out.print("MENU OPTION HAS NOT YET BEEN IMPLEMENTED!\n");
			saveFile = sc.nextLine();
			System.out.print("New file name:");
			saveFile = sc.nextLine();
			load.writeFile(saveFile, trees);
		    break;		    
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		    case 10:
			stop = false;//when condition is false, the loop will stop
			System.out.print("Exiting. Goodbye!!\n");// exit message
		    break;
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		    default:
			System.out.print("\nERROR: Please enter an integer value from 1-9!!\n");//error message
		}//end of switch case		
	    }while(stop);//end of menu loop for interactive mode
	}//end of filename checking for interactive mode
	else
	{
	    System.out.print("\nERROR: Please check if you have entered all required fields\n");//error message
	}//end of else statement
	}//end of if statement
    }//end of main
}//end of class
