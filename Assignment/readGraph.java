import java.util.*;
import java.io.*;

public class readGraph
{
	/*public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		DSAGraph newFile;

		newFile = readFile("gameofcatz.txt");
		newFile.displayAsList();
		//writeFile("test1.txt", newFile);
	}*/
		
	public static DSAGraph readFile(String fileName)
    {               
        FileInputStream filestream = null;
        InputStreamReader rdr;
        BufferedReader bufRdr;
        String line;
        //to store Ncode value
        int F=-1; 
        int D=100; 
        int T=1; //to store the values(weights)
        int DASH=0; 
        //end
        int standard=0; 
        String start, target;
        int dataCount=0;
       	String[] splittedData = null;
        int arrayRow = 0;
        int arrayColumn = 0;
        int startIndx, endIndx;
        String token;
        DSAGraph graph = new DSAGraph();
        Scanner sc = new Scanner(System.in);
        
        try
        {
            	
            filestream = new FileInputStream(fileName);//open file
            rdr = new InputStreamReader(filestream);//Create a reader to read the stream
            bufRdr = new BufferedReader(rdr);//To read the stream one line at a time
            line = bufRdr.readLine();
 
            while(line != null)
            {
            	if(line.charAt(0) != '#')
            	{
            		splittedData = line.split(" ");//splits the line
            		if(splittedData[0].equals("Node"))
            		{
            			if(splittedData[2].equals("F"))
            			{
            				graph.addVertex(splittedData[1],F);
            			}
            			else if(splittedData[2].equals("D"))
            			{
            				graph.addVertex(splittedData[1],D);
            			}
            			else if(splittedData[2].equals("T"))
            			{
            				graph.addVertex(splittedData[1],T);
            			}
            			else if(splittedData[2].equals("-"))
            			{
            				graph.addVertex(splittedData[1], DASH);
            			}
            		}
            		else if(splittedData[0].equals("Edge"))
            		{
            			graph.addEdge(splittedData[1], splittedData[2], splittedData[1]+splittedData[2], DASH);
            		}
            		else if(splittedData[0].equals("Start"))
            		{
            			start=splittedData[1];
            		}
            		else if(splittedData[0].equals("Target"))
            		{
            			target=splittedData[1];
            		}
            	}
               	arrayRow++;//to get the number of rows
               	line = bufRdr.readLine();//reads each line
            }filestream.close();
        }
        catch(FileNotFoundException e)
        {
            System.out.print("File not found\n");
        }
        catch(IOException ex)
        {
            System.out.print("error: IOException\n");
        }                 
        return graph;
    }

    public static void writeFile(String fileName, DSABinarySearchTree writeArray)
    {
    	try
    	{
     	  	FileOutputStream outStream = new FileOutputStream(fileName);//open file
        	BufferedWriter wtr = new BufferedWriter(new FileWriter(fileName));
        	int x=0;//for the loop
 		
              	 	wtr.write(writeArray+"\n");
                	System.out.print(writeArray+"\n");

        	wtr.close();
        	System.out.print("DONE!\n");
    	}
    	catch(FileNotFoundException e)
    	{
        	System.out.print("File not found\n");
    	}
   	 	catch(IOException ex)
    	{
        	System.out.print("error: IOException\n");
    	}
    	
    	
    }
}//END OF CLASS	
