/* FILE		:	DSABinarySearchTreeTest.java
   AUTHOR	:	Jasmine Aanstasha Chieng Kiu Ying
   USERNAME	:	jasmine_chieng
   UNIT		:	COMP1002 Data Structures and Algorithm
   PURPOSE	:	To test the methods from DSABinarySearchTree.java
   REFERENCE:	Curtin University of Technology. 2020."Lecture 5: TREES", 
				https://www.geeksforgeeks.org/binary-search-tree-set-1-search-and-insertion/
   LAST MOD	:	29/09/2021
   COMMENTS	:	-
*/

import java.util.*;

public class DSABinarySearchTreeTest
{
	public static void main(String args[])
	{
		DSABinarySearchTree trees = new DSABinarySearchTree();
		
		System.out.print("TESTING insert()\n");
		trees.insert("H", 30);
		trees.insert("E", 33);
		trees.insert("L", 36);
		trees.insert("P", 15);
		trees.insert("N", 18);
		trees.insert("O", 21);
		trees.insert("B", 24);
		trees.insert("Y", 27);
		trees.insert("E", 3);
		trees.insert("J", 6);
		trees.insert("A", 9);
		trees.insert("S", 12);
		trees.insert("M", 12);

		System.out.print("/----------------------------------");
		System.out.print("\nTESTING print2D()\n");
		trees.display();

		System.out.print("minimum key:"+trees.minKi()+"\n");
		System.out.print("maximum key:"+trees.maxKi()+"\n");

		System.out.print("/----------------------------------");
		System.out.print("\nTESTING printPostorder()\n");
		trees.printPostorder();
		
		System.out.print("\n/----------------------------------");
		System.out.print("\nTESTING printInorder()\n");
		trees.printInorder();
		
		System.out.print("\n/----------------------------------");
		System.out.print("\nTESTING printPreorder()\n");
		trees.printPreorder();

		System.out.print("\n/----------------------------------");
		System.out.print("\nTESTING find()\n");
		System.out.print("\nH with value: "+trees.find("H")+"\n");
		System.out.print("E with value: "+trees.find("E")+"\n");
		System.out.print("L with value: "+trees.find("L")+"\n");
		System.out.print("P with value: "+trees.find("P")+"\n");
		System.out.print("/----------------------------------");
		System.out.print("\nTESTING display()\n");
		System.out.print("KEYS:\n");
		trees.display();
		System.out.print("/----------------------------------");
		System.out.print("\nTESTING height()\n");
		System.out.print("Height of the tree is "+trees.height()+"\n");
		System.out.print("/----------------------------------");
		System.out.print("\nTESTING delete()\n");
		trees.delete("H");
		trees.delete("L");
		trees.delete("Y");
		System.out.print("/----------------------------------");
		System.out.print("\nREMAINING KEYS:\n");
		trees.display();
		System.out.print("minimum key:"+trees.minKi()+"\n");
		System.out.print("maximum key:"+trees.maxKi()+"\n");
		System.out.print("Height of the tree is "+trees.height()+"\n");
		
		//trees.display();
	}//end of main
}//end of class
