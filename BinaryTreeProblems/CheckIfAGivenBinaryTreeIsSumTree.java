package Problems;

import java.util.LinkedList;
import java.util.Queue;

public class CheckIfAGivenBinaryTreeIsSumTree {

	/*
		     	 26
		        /   \
		      10     3
		    /    \     \
		  4      6      3
		  
   */
	
    public static void main (String[] args)
    {
        BinaryTree tree=new BinaryTree();
        tree.insert(26);
        tree.insert(10);
        tree.insert(3);
        tree.insert(4);
        tree.insert(6);
        tree.insert(3);
        if(tree.isSumTree(tree.root) != 0)
        {
            System.out.println("The given tree is a SumTree");
        }
        else
        {
            System.out.println("The given tree is not a SumTree");
        }
    }
}


class BinaryTree {
	
	static class Node
	{
		 int data;
		 Node left;
		 Node right;
		 
		 
		 Node(int item)
		 {
		     data = item;
		     left = right = null;
		 }
	}
 
	public Node root;
	
	public void insert(int data)
	{
		Node newNode = new Node(data);
		
		if (root == null)
		{
			root = newNode;
			return;
		}
		
		Queue<Node> q = new LinkedList<Node>();
	    q.add(root);
	    
	    Node temp;
	    // Do level order traversal until we find
        // an empty place.
	    while (!q.isEmpty())
	    {
	    	temp = q.peek();
	    	q.remove();
	    	
	    	if (temp.left == null)
	    	{
	    		temp.left = newNode;
	    		break;
	    	}
	    	else
	    	{
	    		q.add(temp.left);
	    	}
	    	
	    	if (temp.right == null)
	    	{
	    		temp.right = newNode;
	    		break;
	    	}
	    	else
	    	{
	    		q.add(temp.right);
	    	}
	    }
	    
	}
	
	// a helper function
	// wgich gives the sum of a (sub)tree
	int sum(Node node)
	{
		if (node == null)
		{
			return 0;
		}
		
		else
		{
			return (node.data + sum(node.left) + sum(node.right));
		}
	}
	
	// Returns 1 if sum property holds for
    // the given node and both of its children
	int isSumTree(Node node)
	{
		// If node is NULL or it's a leaf
        // node then return true
		if (node == null || (node.left == null && node.right == null))
		{
			return 1;
		}
		
		int leftSum = sum(node.left);
		int rightSum = sum(node.right);
		
		// If the node and both of its
        // children satisfy the property
        // return 1 else 0
		if (node.data == leftSum + rightSum && isSumTree(node.left) != 0 && isSumTree(node.right) != 0)
		{
			return 1;	
		}
		
		return 0;
	}
}








