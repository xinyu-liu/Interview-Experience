package SumTree;

public class ConvertATreeToItsSumTree {
	// return sum of the left and right sub trees in the original tree
	public int convert(TreeNode root){
		int sum = 0;
		if(root.left == null && root.right == null){
			sum = root.val;
			root.val = 0;
		}
		else{
			if(root.left != null)  sum += convert(root.left);
			if(root.right != null) sum += convert(root.right);
			int t = root.val;
			root.val = sum;
			sum += t;
		}
		return sum;
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
                 10
               /      \
	     	 -2        6
           /   \      /  \ 
	 	  8     -4    7    5
should be changed to

                 20(4-2+12+6)
               /      \
	   		4(8-4)      12(7+5)
           /   \      /  \ 
	 	 0      0    0    0
*/
		TreeNode root = new TreeNode(10);
		
		root.left = new TreeNode(-2);
		root.right = new TreeNode(6);
		
		root.left.left = new TreeNode(8);
		root.left.right = new TreeNode(-4);	
		root.right.left = new TreeNode(7);
		root.right.right = new TreeNode(5);

		ConvertATreeToItsSumTree sol = new ConvertATreeToItsSumTree();
		printTree(root);
		System.out.println();
		sol.convert(root);
		printTree(root);
	}

}
