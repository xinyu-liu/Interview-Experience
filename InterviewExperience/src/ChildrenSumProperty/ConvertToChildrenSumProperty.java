package ChildrenSumProperty;
/*
 * Question: Given an arbitrary binary tree, convert it to a binary tree that holds Children Sum Property. 
 * You can only increment data values in any node (You cannot change structure of tree and 
 * cannot decrement value of any node).
 * 
 * Algorithm:
Traverse in post-order, i.e., first change left and right children to hold the children sum property then change the parent node.
     diff = node¡¯s children sum - node¡¯s data 
      
If diff is 0, then nothing needs to be done.

If diff > 0, increment the node¡¯s data by diff.

If diff < 0, then increment one child¡¯s data. 
We can choose to increment either left or right child if they both are not NULL. Let us always first increment the left child. Incrementing a child changes the subtree¡¯s children sum property so we need to change left subtree also. So we recursively increment the left child. If left child is empty then we recursively call increment() for right child.

Time Complexity: O(n^2), Worst case complexity is for a skewed tree such that nodes are in decreasing order from root to leaf.


 */
public class ConvertToChildrenSumProperty {
	public void convert(TreeNode root){
		if( root == null || (root.left == null && root.right == null) ) return;
		convert( root.left );
		convert( root.right );
		// self
		int l = 0;
		int r = 0;
		if(root.left != null) l = root.left.val;
		if(root.right != null) r = root.right.val;
		int diff = l+r-root.val;
		if(diff >= 0){
			root.val += diff;
		}
		else{
			if(root.left != null) increment(root.left, -diff);
			else increment(root.right, -diff);
		}
		
	}
	private void increment(TreeNode root, int diff){
		if(root == null) return;
		root.val += diff;
		if(root.left != null) increment(root.left, diff);
		else increment(root.right, diff);
	}
	public void print(TreeNode root){
		if(root == null) return;
		System.out.print(root.val + " ");
		print(root.left);
		print(root.right);
	}
	public static void main(String[] args) {
		 /* Constructed binary tree is 
        50
      /   \
    7      2
  /  \    /  \
3     5  1   30   
*/
		TreeNode root = new TreeNode(50);
		
		root.left = new TreeNode(7);
		root.right = new TreeNode(2);
		
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(5);	
		root.right.left = new TreeNode(1);
		root.right.right = new TreeNode(30);
		
		ConvertToChildrenSumProperty sol = new ConvertToChildrenSumProperty();
		sol.print(root);
		System.out.println();
		sol.convert(root);
		sol.print(root);
		System.out.println();
		/*
        50
      /   \
    8      31
  /  \    /  \
3     5  1   30   


        50
      /   \
    19      31
   /  \    /  \
 14    5  1   30   
		 */
	}

}
