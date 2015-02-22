package SumTree;
/*
 * A SumTree is a Binary Tree where the value of a node is equal to sum of the nodes present in its left subtree and right subtree. 
 * An empty tree is SumTree and sum of an empty tree can be considered as 0. A leaf node is also considered as SumTree.

Following is an example of SumTree.
          26
        /   \
      10     3
    /    \     \
  4      6      3
 */
public class CheckIfBinaryTreeIsSumTree {
	public boolean check(TreeNode root){
		if( root == null || isLeaf(root) ) return true;
		if( (!check(root.left)) || (!check(root.right)) ) return false;
		
		int childrenSum = 0;
		if(root.left != null){
			if( isLeaf(root.left) ) childrenSum += root.left.val;
			else childrenSum += (root.left.val*2);
		}
		if(root.right != null){
			if( isLeaf(root.right) ) childrenSum += root.right.val;
			else childrenSum += (root.right.val*2);
		}
		return childrenSum == root.val;
	}
	private boolean isLeaf(TreeNode n){
		return n.left == null && n.right == null;
	}
	public static void main(String[] args) {
		 /* Constructed binary tree is 
          26
        /   \
      10     3
    /    \     \
  4      6      3
*/
		TreeNode root = new TreeNode(26);
		
		root.left = new TreeNode(10);
		root.right = new TreeNode(3);
		
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(6);	
		root.right.right = new TreeNode(3);
		
		CheckIfBinaryTreeIsSumTree sol = new CheckIfBinaryTreeIsSumTree();
		System.out.print( sol.check(root) );
	}

}
