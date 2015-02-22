package BoundaryTraversalOfBinaryTree;

/*
Perimeter of the binary tree in clockwise direction (All kind of possible approaches
and efficient approach were discussed)
Time complexity and space complexity were also discussed.

Another: http://www.geeksforgeeks.org/boundary-traversal-of-binary-tree/
We break the problem in 3 parts:
1. Print the left boundary in top-down manner. (no leaf)
2. Print all leaf nodes from left to right, which can again be sub-divided into two sub-parts:
¡­..2.1 Print all leaf nodes of left sub-tree from left to right.
¡­..2.2 Print all leaf nodes of right subtree from left to right.
3. Print the right boundary in bottom-up manner.(no leaf)
NOTE:
1.
printLeftBoundaryNoLeaf() is wrong  
Corner case:
           1
          / \
         2   3
            / \
           4   5
          /
         6
      
2. This is because this DEFINITION seems different from that of left view + bottom view + right view!
The definition give seems: not count 4 as a member of bottom boundary

3. only internal nodes shouldn¡¯t be printed
Definition of non-internal nodes:
A node is non-internal if it satisfies at least one of the following conditions-
1. it¡¯s a leaf.
2. the path from root to this node involves either all left branches or all right branches??? SEE MAIN()
 */
public class BoundaryTraversalOfBinaryTree {
	// Anti-Clockwise

	public void boundaryTraversal(TreeNode root){
		if(root == null) return;
		///////////////////// in order to not have DUPLICATED ROOT
		System.out.print(root.val + " ");///
		printLeftBoundaryNoLeaf(root.left); ///
		printAllLeaves(root);
		prinRightBoundaryNoLeaf(root.right); ///
	}

	private void printLeftBoundaryNoLeaf(TreeNode root){
		if(root.left == null && root.right == null) return;
		// not leaf
		System.out.print(root.val + " ");
		if(root.left != null){
			printLeftBoundaryNoLeaf(root.left);
		}
		else {
			printLeftBoundaryNoLeaf(root.right);
		}	
	}
	private void printAllLeaves(TreeNode root){
		if(root == null) return;
		if(root.left == null && root.right == null) System.out.print(root.val + " ");
		printAllLeaves(root.left);
		printAllLeaves(root.right);
			
	}
	private void prinRightBoundaryNoLeaf(TreeNode root){
		if(root.left == null && root.right == null) return;
		if(root.right != null){
			prinRightBoundaryNoLeaf(root.right);
		}
		else {
			prinRightBoundaryNoLeaf(root.left);
		}	
		// not leaf
		System.out.print(root.val + " ");
	}
	public static void main(String[] args) {
		 /* Constructed binary tree is 
        1
      /   \
    2      3
      \      \
        5     8
      /   \	    \
    6      7      9
    		    /   \
             10      11
            /   \
          12     13
*/
		TreeNode root = new TreeNode(1);
		
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		
		root.left.right = new TreeNode(5);	
		root.right.right = new TreeNode(8);
		
		root.left.right.left = new TreeNode(6);	
		root.left.right.right = new TreeNode(7);
		root.right.right.right = new TreeNode(9);
		root.right.right.right.left = new TreeNode(10);
		root.right.right.right.right = new TreeNode(11);
		
		root.right.right.right.left.left = new TreeNode(12);
		root.right.right.right.left.right = new TreeNode(13);
		
		BoundaryTraversalOfBinaryTree sol = new BoundaryTraversalOfBinaryTree();
		sol.boundaryTraversal(root);
		System.out.println();
	}

}
