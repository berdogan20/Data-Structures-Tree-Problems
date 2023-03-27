package BinarySearchTreeProblems;

public class CheckIfBTIsBST {

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

		static boolean isBST(Node root)
		{
			return true;
		}
		
	    int maxValue(Node node)
		{
			
			if (node == null) 
			{
		      return Integer.MIN_VALUE;
		    }
			
		    int value = node.data;
		    int leftMax = maxValue(node.left);
		    int rightMax = maxValue(node.right);
		 
		    return Math.max(value, Math.max(leftMax, rightMax));
		}
		 
		  int minValue(Node node)
		  {
		    if (node == null) 
		    {
		      return Integer.MAX_VALUE;
		    }
		    
		    int value = node.data;
		    int leftMax = minValue(node.left);
		    int rightMax = minValue(node.right);
		 
		    return Math.min(value, Math.min(leftMax, rightMax));
		  }
		  
		  boolean isBSTNaive(Node node)
		  {
			  /*
			   * Time Complexity: O(N2)
			   * Auxiliary Space: O(H)
			   * */
			  
			  if (node == null)
			  {
				  return true;
			  }
			  
			  if (node.left != null && maxValue(node.left) > node.data)
			  {
				  return false;
			  }
			  
			  if (node.right != null && minValue(node.right) < node.data)
			  {
				  return false;
			  }
			  
			  if (!isBSTNaive(node.left) || !isBSTNaive(node.right))
			  {
				  return false;
			  }
		  
			  return true;
		  }
		  
		  boolean isBSTUtil(Node node, int min, int max)
		  {
			  /*
			   * Time Complexity: O(N)
			   * Auxiliary Space: O(1)
			   * */
			  
			  if (node == null)
			  {
				  return true;
			  }
			  
			  if (node.data < min || node.data > max)
			  {
				  return false;
			  }
			  
			  return isBSTUtil(node.left, min, node.data - 1)
					  && isBSTUtil(node.right, node.data + 1, max);
		  }
		  
		  boolean isBST()
		  {
		        return isBSTUtil(root, Integer.MIN_VALUE,
		                         Integer.MAX_VALUE);
		  }
	}



}








	