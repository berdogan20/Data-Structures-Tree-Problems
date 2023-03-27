package BinarySearchTreeProblems;


public class CheckIfAnArrayRepresentsInorderOfBinarySearchTree {

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
		
	}
	
	/*
	 
	    Input : arr[] = { 19, 23, 25, 30, 45 }
		Output : Yes
		
		Input : arr[] = { 19, 23, 30, 25, 45 }
		Output : No
	 
	 */
	
	static boolean isInOrder(int[] arr, int length)
	{
		/*
		 * Time complexity: O(n) where n is the size of array
		 * Auxiliary Space: O(1)
		 */
		
		
		if (length == 0 || length == 1)
		{
			return true;
		}
		
		for (int i = 1; i < length; i++)
		{
			if(arr[i] < arr[i - 1])
			{
				return false;
			}
		}
		
		return true;
	}
	
	public static void main(String[] args) {
        
		int arr[] = {19, 23, 25, 30, 45};
        int n = arr.length;
       
        if (isInOrder(arr, n)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
