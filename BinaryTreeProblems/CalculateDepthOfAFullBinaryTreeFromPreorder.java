package BinaryTreeProblems;

public class CalculateDepthOfAFullBinaryTreeFromPreorder {

	/*
	 * Given preorder of a binary tree, calculate its depth(or height) 
	 * [starting from depth 0]. The preorder is given as a string 
	 * with two possible characters. 
		‘l’ denotes the leaf
		‘n’ denotes internal node
	 */
	
	public static void main(String[] args)
	{
		String tree = "nlnnlll";
        System.out.println(findDepth(tree));
        
//        Time Complexity: O(N)
//        Auxiliary Space: O(1)


    }
	
	
	
	
	// function to return max
    	// of left subtree height
    	// or right subtree height
	public static int findDepthRecursive(String tree, int index)
	{
		if (index >= tree.length() || tree.charAt(index) == 'l')
		{
			return 0;
		}
		
		// calc height of left subtree
		int left = findDepthRecursive(tree, ++index);
		
		// calc height of left subtree
		int right = findDepthRecursive(tree, ++index);
		
		return Math.max(left, right) + 1;
	}
	
	// Wrapper over findDepthRec()
	public static int findDepth(String tree)
	{
		int depth = findDepthRecursive(tree, 0);
		return depth;
	}
	
}
