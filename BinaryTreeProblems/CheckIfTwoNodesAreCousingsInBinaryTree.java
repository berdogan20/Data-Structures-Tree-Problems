package BinaryTreeProblems;

public class CheckIfTwoNodesAreCousingsInBinaryTree {

	/*
	 * Given the binary Tree and the two nodes say ‘a’ and ‘b’, 
	 * determine whether the two nodes are cousins of each other or not.
     * Two nodes are cousins of each other if they are at same level and have different parents.
          		 6
			   /   \
			  3     5
			 / \   / \
			7   8 1   3
	 Say two node be 7 and 1, result is TRUE.
	 Say two nodes are 3 and 5, result is FALSE.
	 Say two nodes are 7 and 5, result is FALSE.
	 */

    //Driver program to test above functions
    public static void main(String args[])
    {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.left.right.right = new Node(15);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
        tree.root.right.left.right = new Node(8);
 
        Node Node1, Node2;
        Node1 = tree.root.left.left;
        Node2 = tree.root.right.right;
        if (tree.isCousin(tree.root, Node1, Node2))
            System.out.println("Yes");
        else
            System.out.println("No");
    }
    
	static class Node
	{
	    int data;
	    Node left, right;
	 
	    Node(int item)
	    {
	        data = item;
	        left = right = null;
	    }
	}
	
	static class BinaryTree
	{
	    Node root;
	    
	    // Recursive function to check if two Nodes are
	    // siblings
	    boolean isSibling(Node parent, Node a, Node b)
	    {
	    	if (parent == null)
	    	{
	    		return false;
	    	}
	    	
	    	else
	    	{
	    		return ((parent.left == a && parent.right == b) ||
	    				(parent.left == b && parent.right == a) ||
	    				 isSibling(parent.left, a, b) ||
	    				 isSibling(parent.right, a, b));
	    	}
	    }
	    
	    // Recursive function to find level of Node 'ptr' in
	    // a binary tree
	    int level(Node node, Node ptr, int level)
	    {
	    	if (node == null)
	    	{
	    		return 0;
	    	}
	    	
	    	if (node == ptr)
	    	{
	    		return level;
	    	}
	    	
	    	// Return level if Node is present in left subtree
	    	int left = level(node.left, ptr, level + 1);
	    	if (left != 0)
	    	{
	    		return left;
	    	}
	    		
	    	// Return level if Node is present in right subtree
	    	return level(node.right, ptr, level + 1);
	    }
	    
	    // Returns 1 if a and b are cousins, otherwise 0
	    boolean isCousin(Node node, Node a, Node b)
	    {
	    	// 1. The two Nodes should be on the same level
	        //       in the binary tree.
	        // 2. The two Nodes should not be siblings (means
	        //    that they should not have the same parent
	        //    Node).
	    	return ((level(node, a, 1) == level(node, b, 1)) &&
	    			!isSibling(node, a, b));
	    }
	}
}



