package PrintPathArrayOfBST;

import java.util.ArrayList;

/*
You are given a Binary Search Tree. Write an algorithm to print the Path Array of a given key.
PATH ARRAY:
a) If the given key is not present in the tree than the Path Array is equal to ¡°-1¡±
b) If the given key is present in the BST, path array tells you the path 
   (in terms of left & right direction) that you take from root to reach the given key. 
   If you go towards right add ¡°0¡± to the path array and if you go towards left add ¡°1¡± to Path Array.
   
 */
public class PrintPathArrayOfBST {
	public void printPathArray(TreeNode root, int target){
		ArrayList<Integer> path = new ArrayList<Integer>();
		if(dfs(root, target, path)) printArr(path);
		else System.out.println(-1);
	}
	private boolean dfs(TreeNode root, int target, ArrayList<Integer> path){
		if(root == null) return false;////////// MUST
		if(target == root.val) return true;
		if(target < root.val){
			path.add(1);
			return dfs(root.left, target, path);
		}
		else{
			path.add(0);
			return dfs(root.right, target, path);
		}
		
	}
	private void printArr(ArrayList<Integer> path){
		for(Integer i : path){
			System.out.print(i + " ");
		}
	}
	public static void main(String[] args) {
		 /* Constructed binary tree is 
        10
      /   \
    5      13
  /  \       \
4     8       14
     / \	    \
    6   9       19
    		   / \
              17  21
             /  \
            15  18
*/
		int target = 9;
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(5);
		root.right = new TreeNode(13);
		
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(8);	
		root.right.right = new TreeNode(14);
		
		root.left.right.left = new TreeNode(6);	
		root.left.right.right = new TreeNode(9);
		root.right.right.right = new TreeNode(19);
		root.right.right.right.left = new TreeNode(17);
		root.right.right.right.right = new TreeNode(21);
		
		root.right.right.right.left.left = new TreeNode(15);
		root.right.right.right.left.right = new TreeNode(18);
		
		PrintPathArrayOfBST sol = new PrintPathArrayOfBST();
		sol.printPathArray(root, target);
	}

}
