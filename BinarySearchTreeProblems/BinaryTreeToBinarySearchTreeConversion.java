package BinarySearchTreeProblems;

import java.util.Arrays;

public class BinaryTreeToBinarySearchTreeConversion {

	static class BinarySearchTree
	{
		Node root;
		
		static class Node
		{
			int data;
			Node left, right;
			
			public Node(int data)
			{
				this.data = data;
			}
		}
		
		
		/*
		 
		 Example 
					Input:
					          10
					         /  \
					        2    7
					       / \
					      8   4
					Output:
					          8
					         /  \
					        4    10
					       / \
					      2   7
		 
		 */
		
		// index pointer to pointer to the array index
	    static int index;
	    
	    void storeInOrder(Node node, int inorder[])
	    {
	    	if (node == null)
	    	{
	    		return;
	    	}
	    	
	    	/* store the left subtree */
	    	storeInOrder(node.left, inorder);
	    	
	    	/* store the root's data */
	    	inorder[index] = node.data;
	    	index++;
	    	
	    	/* store the right subtree */
	    	storeInOrder(node.right, inorder);
	    }
	    
	    int countNodes(Node node)
	    {
	    	if (node == null)
	    	{
	    		return 0;
	    	}
	    	
	    	return countNodes(node.left) + countNodes(node.right) + 1;
	    }
	    
	    // A helper function that copies contents of arr[] to Binary Tree.
	    // This function basically does Inorder traversal of Binary Tree and
	    // one by one copy arr[] elements to Binary Tree nodes 
	    void arrayToBST(int[] arr, Node root)
	    {
	    	if (root == null)
	    	{
	    		return;
	    	}
	    
	    	/*update the left subtree*/
	    	arrayToBST(arr, root.left);
	    	
	    	/*update the root's data*/
	    	root.data = arr[index];
	    	index++;
	    	
	    	/*update the right subtree*/
	    	arrayToBST(arr, root.right);
	    	
	    }
	    
	    // This function converts a given Binary Tree to BST
	    void binaryTreeToBST(Node root)
	    {
	    	/*
	    	 * Time Complexity: O(nlogn)
	    	 * Auxiliary Space: O(n)
	    	 * */
	    	
	    	
	    	if (root == null)
	    	{
	    		return;
	    	}
	    	
	    	int n = countNodes(root);
	    	
	    	// Create a temp array arr[] and store inorder traversal of tree in arr[]
	    	int arr[] = new int[n];
	    	
	    	storeInOrder(root, arr);
	    	
	    	 // Sort the array using library function for quick sort
	    	Arrays.sort(arr);
	    	
	    	 // Copy array elements back to Binary Tree
	    	index = 0;
	    	arrayToBST(arr, root);
	    }
	    
	    void printInorder(Node node)
	    {
	        if (node == null)
	            return;
	 
	        /* first recur on left child */
	        printInorder(node.left);
	 
	        /* then print the data of node */
	        System.out.print(node.data + " ");
	 
	        /* now recur on right child */
	        printInorder(node.right);
	    }
	}

	
	
}
