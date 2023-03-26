package Problems;

public class CheckIfRemovingAnEdgeCanDivideABinaryTreeInTwoHalves {

	/*
	 
		    Input : root of following tree
				           5
				         /   \
				       1      6    
				      /      /  \
				     3      7    4
			Output : true
			Removing edge 5-6 creates two trees of equal size
			
			
			Input : root of following tree
				           5
				         /   \
				       1      6    
				            /  \
				           7    4
				         /  \    \
				        3    2    8
			Output : false
			There is no edge whose removal creates two trees
			of equal size.
	 */
	
	// Driver code
    public static void main(String[] args)
    {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(5);
        tree.root.left = new Node(1);
        tree.root.right = new Node(6);
        tree.root.left.left = new Node(3);
        tree.root.right.left = new Node(7);
        tree.root.right.right = new Node(4);
        
        // method 1 
        if(tree.check(tree.root)==true)
            System.out.println("YES");
        else
            System.out.println("NO");
        
        // method 2 
        if(tree.check2(tree.root)==true)
            System.out.println("YES");
        else
            System.out.println("NO");
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
	    
	    // to calculate the size of the tree
		int size(Node node)
		{
			if (node == null)
			{
				return 0;
			}
			
			else
			{
				return size(node.left) + size(node.right) + 1;
			}
		}
		
		// This function returns true if there is an edge
	    // whose removal can divide the tree in two halves
	    // n is size of tree
		boolean checkRecursive(Node node, int n)
		{
			if (node == null)
			{
				return false;
			}
			
			if (size(node) == n - size(node))
			{
				return true;
			}
			
			else
			{
				return checkRecursive(node.left, n) || checkRecursive(node.right, n);
			}
		}
		
		
	    // This function mainly uses checkRec()
		boolean check(Node node)
		{
			int size = size(node);
			return checkRecursive(node, size);
			
			/*
			 * Time complexity: O(n2) where n is number of nodes in given Binary Tree.
			 * Auxiliary Space: O(n) for call stack since using recursion, where n is no of nodes in binary tree
			 */
		}
		
		

	    // This function returns size of tree rooted with given
	    // root. It also set "res" as true if there is an edge
	    // whose removal divides tree in two halves.
	    // n is size of tree
	    int checkRec2(Node root, int n, Res res)
	    {
	    	if (root == null)
	    	{
	    		return 0;
	    	}
	    	
	    	// Compute sizes of left and right children
	    	int c = checkRec2(root.left, n, res) + 1 + checkRec2(root.right, n, res);
	    	
	    	// If required property is true for current node
	        // set "res" as true
	    	if (c == n - c)
	    	{
	    		res.res = true;
	    	}
	    	
	    	// return size
	    	return c;
	    }
	    
	    // This function mainly uses checkRec2()
	    boolean check2(Node root)
	    {
	    	// Count total nodes in given tree
	        int n = size(root);
	 
	        // Initialize result and recursively check all nodes
	        Res res = new Res();
	        checkRec2(root, n, res);
	 
	        return res.res;
	        
	        /*
	         * Time Complexity: O(n)
			 * Auxiliary Space:  O(n)
	         */
	    }
	    
	    
	} 
	
	static class Res
	{
	    boolean res = false;
	}
	
	
	
}







