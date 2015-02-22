package CheckIfBinaryTreeIsComplete;

// A complete binary tree is a binary tree whose 
// all levels except the last level are completely filled and 
// all the leaves in the last level are all to the left side.

public class UsingRecursion {
	/*
	 * if the parent node is assigned an index of ¡®i¡¯ and 
	 * left child gets assigned an index of ¡®2*i + 1¡¯ while the 
	 * right child is assigned an index of ¡®2*i + 2¡¯.
	 * 
	 * the assigned indices of a complete binary tree will strictly less be than the number of nodes 
	 * 
Calculate the number of nodes (count) in the binary tree.
Start recursion of the binary tree from the root node of the binary tree with index (i) being set as 0 and the number of nodes in the binary (count).
If the current node under examination is NULL, then the tree is a complete binary tree. Return true.
If index (i) of the current node is greater than or equal to the number of nodes in the binary tree (count) i.e. (i>= count), then the tree is not a complete binary. Return false.
Recursively check the left and right sub-trees of the binary tree for same condition. For the left sub-tree use the index as (2*i + 1) while for the right sub-tree use the index as (2*i + 2).
	 */
	public boolean isComplete(TreeNode root){
		int count = countNodes(root);
		return rec(root, 0, count);
	}
	private boolean rec(TreeNode root, int index, int count){
		if(root == null) return true;
		// self
		if(index >= count) return false;
		// children
		if( !rec(root.left, 2 * index + 1, count) ) return false;
		if( !rec(root.right, 2 * index + 2, count) ) return false;
		return true;
	}
	private int countNodes(TreeNode root){
		if(root == null) return 0;
		return countNodes(root.left) + countNodes(root.right) + 1;
	}
	
	public static void main(String[] args) {
		/*
		 * The following trees are examples of Complete Binary Trees
    1
  /   \
 2     3
  
       1
    /    \
   2       3
  /
 4

       1
    /    \
   2      3
  /  \    /
 4    5  6
The following trees are examples of Non-Complete Binary Trees
    1
      \
       3
  
       1
    /    \
   2       3
    \     /  \   
     4   5    6

       1
    /    \
   2      3
         /  \
        4    5

		 */
		
		TreeNode root = new TreeNode(1);
		
		// root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		
		
		// root.left.right = new TreeNode(5);	
		//root.right.left = new TreeNode(4);
		//root.right.right = new TreeNode(6);
	
		
		UsingRecursion sol = new UsingRecursion();
		System.out.println(sol.isComplete(root));
	}
}
