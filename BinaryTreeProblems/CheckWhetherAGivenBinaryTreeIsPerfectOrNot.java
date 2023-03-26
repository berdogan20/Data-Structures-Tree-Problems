package Problems;

import Problems.CheckIfRemovingAnEdgeCanDivideABinaryTreeInTwoHalves.Node;

public class CheckWhetherAGivenBinaryTreeIsPerfectOrNot {

	/*
	 
	  Given a Binary Tree, write a function to check 
	  whether the given Binary Tree is a perfect Binary Tree or not.
	  A Binary tree is Perfect Binary Tree in which all internal
	  nodes have two children and all leaves are at same level.
	  
			           10
		           /       \  
		         20         30  
		        /  \        /  \
		      40    50    60   70
		
		
		               18
		           /       \  
		         15         30  
	 */
	
	// Driver Program
	public static void main(String args[])
	{
	    Node root = null;
	    root = new Node(10);
	    root.left = new Node(20);
	    root.right = new Node(30);
	 
	    root.left.left = new Node(40);
	    root.left.right = new Node(50);
	    root.right.left = new Node(60);
	    root.right.right = new Node(70);
	 
	    if (isPerfect(root) == true)
	        System.out.println("Yes");
	    else
	        System.out.println("No");
	    
	    if (isPerfect2(root))
	        System.out.println("Yes");
	    else
	        System.out.println("No");
	}
	
	static class Node
	{
	    int key;
	    Node left, right;
	 
	    public Node(int key)
	    {
	        this.key = key;
	        left = right = null;
	    }
	}
	 
	static class BinaryTree
	{
	    Node root;
	}
	
	// Returns depth of leftmost leaf.
	static int findADepth(Node node)
	{
		int depth = 0;
		while (node != null)
		{
			depth++;
			node = node.left;
		}
		return depth;
	}
	
	
	/* This function tests if a binary tree is perfect
	or not. It basically checks for two things :
	1) All leaves are at same level
	2) All internal nodes have two children */
	static boolean isPerfectRec(Node root, int depth, int level)
	{
		/*
		 * Time complexity: O(n) 
		 * Space Complexity: O(n)
		 */
		
		
		// an empty tree is perfect
		if (root == null)
		{
			return true;
		}
		
		// If leaf node, then its depth must be same as
	    // depth of all other leaves.
		if (root.left == null && root.right == null)
		{
			return depth == level + 1;
		}
		
		// If internal node and one child is empty
	    if (root.left == null || root.right == null)
	    {
	    	return false;
	    }
	    
	    // Left and right subtrees must be perfect.
	    return isPerfectRec(root.left, depth, level + 1) &&
	    		isPerfectRec(root.right, depth, level + 1);
	}
	
	// Wrapper over isPerfectRec()
	static boolean isPerfect(Node root)
	{
		int d = findADepth(root);
		return isPerfectRec(root, d, 0);
	}
	
	// This functions gets the size of binary tree
	// Basically, the number of nodes this binary tree has
	static int getLength(Node node)
	{
		if (node == null)
		{
			return 0;
		}
		
		return getLength(node.left) + getLength(node.right) + 1;
	}
	
	// Returns True if length of binary tree is a power of 2 else False
	static boolean isPerfect2(Node root)
	{
		/*
		 * Time Complexity: O(n)
		 * Space Complexity:O(n)
		 */
		
	    int length = getLength(root);
	    return (length & (length+1))== 0;
	}
}
