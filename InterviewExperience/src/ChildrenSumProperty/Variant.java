package ChildrenSumProperty;
/*
(Variant of Children-Sum Problem)
Given a tree, implement a function which replaces a node¡¯s value with the sum of all its childrens¡¯ value, 
considering only those children whose value is less than than the main node¡¯s value.
Eg: input = 60->50->80->40 , output = 90->40->40->0

 */
public class Variant {
	// O(n^2)
	public void transfer(TreeNode root){
		if(root == null) return;
		int replace = findSumLessThan(root.left, root.val) 
					+ findSumLessThan(root.right, root.val);
		transfer(root.left);
		transfer(root.right);
		root.val = replace;
		
	}
	private int findSumLessThan(TreeNode root, int target){
		if(root == null) return 0;
		int ans = 0;
		if(root.val < target) ans += root.val;
		ans += findSumLessThan(root.left, target);
		ans += findSumLessThan(root.right, target);
		return ans;
	}
	private static void printTree(TreeNode root){
		// inorder
		if(root == null) return;
		printTree(root.left);
		System.out.print(root.val+" ");
		printTree(root.right);
	}
	public static void main(String[] args) {
		
/* Constructed binary tree is 
 * input = 60->50->80->40 , output = 90->40->40->0
*/
		TreeNode root = new TreeNode(60);
		root.right = new TreeNode(50);
		root.right.right = new TreeNode(80);
		root.right.right.left = new TreeNode(40);
		Variant sol = new Variant();
		printTree(root);
		sol.transfer(root);
		printTree(root);
	}

}
