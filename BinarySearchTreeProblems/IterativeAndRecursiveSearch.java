package BinarySearchTreeProblems;

public class IterativeAndRecursiveSearch {


}

class BinarySearchTree
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
	
	
	public Node searchRecursive(Node root, int key)
	{
		if (root == null || root.data == key)
		{
			return root;
		}
		else if (key < root.data)
		{
			return searchRecursive(root.left, key);
		}
		else
		{
			return searchRecursive(root.right, key);
		}
		
		/*
		 * Time complexity: O(h), where h is the height of the BST.
		 * Space complexity: O(h), where h is the height of the BST.
		 */
	}
	
	public Node searchIterative(Node root, int key)
	{
		// Traverse until root reaches to dead end
		while (root != null)
		{
			if (key < root.data)
			{
				root = root.left;
			}
			else if (key > root.data)
			{
				root = root.right;
			}
			else
			{
				return root;
			}
		}
		
		return null;
		
		/*
		 * Time Complexity: O(h), here h is the height of the BST.
		 * Auxiliary Space: O(1), as constant extra space is used.
		 */
	}
}
