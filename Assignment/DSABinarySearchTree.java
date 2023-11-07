/* FILE		:	DSABinarySearchTree.java
   AUTHOR	:	Jasmine Aanstasha Chieng Kiu Ying
   USERNAME	:	jasmine_chieng
   UNIT		:	COMP1002 Data Structures and Algorithm
   PURPOSE	:	Contains methods to perform Tree
   REFERENCE:		Curtin University of Technology. 2020."Lecture 5: TREES", 
			https://www.geeksforgeeks.org/binary-search-tree-set-1-search-and-insertion/
   LAST MOD	:	29/09/2021
   COMMENTS	:	-
*/

import java.util.*;

public class DSABinarySearchTree
{
    static final int COUNT = 10;
	
    private class DSATreeNode 
    { 
	private String key;
	private Object value;
	private DSATreeNode leftChild;
	private DSATreeNode rightChild;
		
	public DSATreeNode(String inKey, Object inVal) 
	{
	    if(inKey == null)
	    {
		System.out.print("Key cannot be null");
	    }

	    key = inKey;//consider “owning” the key
	    value = inVal;
	    rightChild = null;
	    leftChild = null;
	}
		
	public String getKey() 
	{ 
	    return key; 
	}
		
	public Object getValue() 
	{ 
	    return value; 
	}
		
	public DSATreeNode getLeft() 
    	{ 
	    return leftChild; 
	}
		
	public void setLeft(DSATreeNode newLeft) 
	{ 
	    leftChild = newLeft;
	}
		
	public DSATreeNode getRight() 
	{ 
	    return rightChild;
	}
		
	public void setRight(DSATreeNode newRight) 
	{ 
	    rightChild = newRight; 
	}
    }//end of private class

//--------------------------------------------------------------------------------------------------------------
    private DSATreeNode root;
    public void BinarySearchTree() 
    {
	root = null; // Start with an empty tree
    }
	
    //ASSERTION:find a specific tree node
    public Object find(String key)
    {
	Object value;
	return value = findRec(key, root);
    }
	
    private Object findRec(String key, DSATreeNode currNode)
    {
	Object value = null;
	if (currNode == null)
	{
	    // Base case: not found
	    System.out.print("Key " + key + " not found");
	}
	else if (key.equals(currNode.getKey()))
	{
	    value = currNode.getValue(); // Base case: found
	}
	else if (key.compareTo(currNode.getKey()) < 0)
	{
	    value = findRec(key, currNode.getLeft()); // Go left (recursive)
	}
	else
	{
	    value = findRec(key, currNode.getRight());
	}
	
	return value;
    }
	
    //ASSERTION: find a new place to insert a new tree node
    public void insert(String key, Object value)
    { 
	root = insertRec(key, value, root);
    }
	
    //MUTATOR insertRec IMPORTS key, data, curNode EXPORTS updateNode
    public DSATreeNode insertRec(String key, Object data, DSATreeNode currNd)
    {
	DSATreeNode updateNode = currNd;
		
	if(currNd == null)
	{
	    // base case - found
	    DSATreeNode newNd = new DSATreeNode(key, data);
	    // insertion point
	    updateNode = newNd;
	    //System.out.print("inserted1\n");
	}
	else if(key.equals(currNd.getKey()))
	{
	    // in the tree, if there is same key will give an error
	    //System.out.print("ERROR OCCURRED, SAME KEY NOT ALLOWED!!\n");
	    //FOR A CLEANER OUTPUT IN THIS ASSIGNMENT, JUST DO NOTHING
	}
	else if(key.compareTo(currNd.getKey()) < 0)
	{
	    currNd.setLeft(insertRec(key, data, currNd.getLeft()));//recurse left
	    //System.out.print("insertedLeft\n");
	}
	else
	{
	    //update current
	    currNd.setRight(insertRec(key, data, currNd.getRight())); //recurse right
	}
		
	return updateNode;
    }
		
    public void delete(String key) 
    {  
	root = deleteRec(key, root);
    }
		
    //MUTATOR deleteRec IMPORTS key, curNode EXPORTS updateNode
    public DSATreeNode deleteRec(String key, DSATreeNode currNd)
    {
	DSATreeNode updateNode = currNd;
		
	if(currNd == null)
	{
	    System.out.print("ERROR OCCURRED!");
	}
	else if(key.equals(currNd.getKey()))
	{
	    updateNode = deleteNode(key, currNd);
	}
	else if (key.compareTo(currNd.getKey()) < 0)
	{
	    currNd.setLeft(deleteRec(key, currNd.getLeft()));
	}
	else
	{
	    currNd.setRight(deleteRec(key, currNd.getRight()));
	}
	
	System.out.print("Deleted: "+currNd.getKey()+"\n");
	return updateNode;
    }
	
    //MUTATOR deleteNode IMPORTS key, delNode EXPORTS updateNode
    public DSATreeNode deleteNode(String key, DSATreeNode delNode)
    {
	DSATreeNode updateNode = null;
		
	if(delNode.getLeft() == null && delNode.getRight() == null)
	{
	    updateNode = null;//no children
	}
	else if(delNode.getLeft() != null && delNode.getRight() == null)
	{	
	    updateNode = delNode.getLeft(); //one child – left
	}
	else if(delNode.getLeft() == null && delNode.getRight() != null)
	{
	    updateNode = delNode.getRight(); //one child – right
	}
	else
	{
	    updateNode = promoteSuccessor(delNode.getRight());
	    if(updateNode != delNode.getRight())
	    {
		//no cycles
		updateNode.setRight(delNode.getRight()); //update right
	    }
	    updateNode.setLeft(delNode.getLeft());//and left
	}
	
	return updateNode;
    }
	
    //MUTATOR promoteSuccessor IMPORTS currNd EXPORTS successor
    //Assertion: successor will be the left most child
    //of the right subtree
    public DSATreeNode promoteSuccessor(DSATreeNode currNd)
    {	
	DSATreeNode successor = currNd;
		
	if(currNd.getLeft() == null)
	{
	    successor = currNd;
	}
	else if(currNd.getLeft() != null)
	{
	    successor = promoteSuccessor(currNd.getLeft());
	    if(successor == currNd.getLeft())
	    {
		//parent of successor
		currNd.setLeft(successor.getRight());//needs to adopt right child
	    }
	}
	
	return successor;
    }
	
    public void display()
    {
	displayRec(root);
    }
	
    public void displayRec(DSATreeNode root) 
    {  
	if (root != null) 
	{
           	//displayRec(root.getLeft());
            System.out.println(root.getKey());
	    	displayRec(root.getRight());
        }
	}
	
    public void printPostorderRec(DSATreeNode currNd)
    {
	if (currNd == null)
	{
            return;//base case
	}
 	
	if (currNd != null)
	{
	    // first recur on left subtree
	    printPostorderRec(currNd.getLeft());
	
	    // then recur on right subtree
	    printPostorderRec(currNd.getRight());
 
	    // now deal with the node
	    System.out.print(currNd.key + " ");
	}
    }
 
    public void printInorderRec(DSATreeNode currNd)
    {
        if (currNd == null)
	{
            return;
	}
	
	// first recur on left child 
        printInorderRec(currNd.getLeft());
 
        // then print the data of node 
        System.out.print(currNd.key + " ");
 
        // now recur on right child 
        printInorderRec(currNd.getRight());
    }
 
    public void printPreorderRec(DSATreeNode currNd)
    {
        if (currNd == null)
            return;
 
        // first print data of node 
        System.out.print(currNd.key + " ");
 
        // then recur on left sutree 
        printPreorderRec(currNd.getLeft());
 
        // now recur on right subtree 
        printPreorderRec(currNd.getRight());
    }
 
    public void printPostorder() 
    { 
	printPostorderRec(root); 
    }
    public void printInorder() 
    { 
    	printInorderRec(root); 
    }
    public void printPreorder() 
    { 
    	printPreorderRec(root); 
    }
	
	
    public String minKi()
    {
	String min="";
	try
	{
	    if (root == null)
	    {
		throw new NullPointerException("ERROR!\n");
	    }
	    else if(root!=null)
	    {
		min = minRec(root);
	    }	
	}
	catch(NullPointerException e)
        {
            System.out.print(e.getMessage());
        }
        return min;	
    }
		
    //ASSERTION: finidiing the value of the minimum key in the tree 
    public String minRec(DSATreeNode currNd)
    {
	String minKey;
	if(currNd.getLeft() != null)
	{
	    minKey = minRec(currNd.getLeft());
	}
	else
	{
	    minKey = currNd.getKey();
	}
	return minKey;
    }
	
    public String maxKi()
    {
	String max="";
	try
	{
	    if (root == null)
	    {
		throw new NullPointerException("ERROR!\n");
	    }
	    else if(root!=null)
	    {
		max = maxRec(root);
	    }	
	}
	catch(NullPointerException e)
        {
	    System.out.print(e.getMessage());
        }
        return max;
    }
			
    //ASSERTION: finiding the value of the maximum key in the tree 
    public String maxRec(DSATreeNode currNd)
    {
	String maxKey;
	if(currNd.getRight() != null)
	{
	    maxKey = maxRec(currNd.getRight());
	}
	else
	{
	    maxKey = currNd.getKey();
	}
	return maxKey;
    }
	
    public int height() 
    {
	return heightRec(root);
    }

    public int heightRec(DSATreeNode curNode)
    {
	int htSoFar, iLeftHt, iRightHt;
	if (curNode == null)
	{	
	    htSoFar = -1;
	    // Base case – no more along this branch
	}
	else
	{
	    iLeftHt = heightRec(curNode.getLeft());// Calc left height from here
	    iRightHt = heightRec(curNode.getRight()); // Calc right height from here
	    // Get highest of left vs right branches
	    if (iLeftHt > iRightHt)
	    {
		htSoFar = iLeftHt + 1;
	    }
	    else
	    {
		htSoFar = iRightHt + 1;
	    }
	}
	return htSoFar;
    }
}//end of class	
