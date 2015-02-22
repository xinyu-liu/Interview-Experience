package ChildrenSumProperty;

public class CheckForChildrenSumProperty {
	public boolean check(TreeNode root){
		////////////////// true if node is NULL 
		////////////////// or it's a leaf node then
		if(root == null ||
		  (root.left == null && root.right == null) ) return true;
		
		int l = 0;
		int r = 0;
		if(root.left != null)  l = root.left.val;
		if(root.right != null) r = root.right.val;
		if(root.val != l+r) return false;
		return check(root.left) && check(root.right);
		
	}
	public static void main(String[] args) {
		 /* Constructed binary tree is 
        10
      /   \
    8      2
  /  \    /
3     5  2   
*/
		TreeNode root = new TreeNode(10);
		
		root.left = new TreeNode(8);
		root.right = new TreeNode(2);
		
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(5);	
		root.right.left = new TreeNode(2);
		
		CheckForChildrenSumProperty sol = new CheckForChildrenSumProperty();
		System.out.print( sol.check(root) );
		
	}

}
