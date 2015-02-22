package FindSumOfAllLeftLeaves;

public class FindSumOfAllLEFTLeaves {
	public int findSumOfAllLeftLeaves(TreeNode root){
		return rec(root, 0);
	}
	private int rec(TreeNode root, int i){
		if(root == null) return 0;
		if(root.left == null && root.right == null && i == 1) return root.val;
		return rec(root.left, 1) + rec(root.right, 0);
		
	}
	public static void main(String[] args) {
		// Let us construct the Binary Tree shown in the figure
		TreeNode root            = new TreeNode(20);
	    root.left                = new TreeNode(9);
	    root.right               = new TreeNode(49);
	    
	    root.right.left         = new TreeNode(23);
	    root.right.right        = new TreeNode(52);
	    root.right.right.left  = new TreeNode(50);
	    root.left.left          = new TreeNode(5);
	    root.left.right         = new TreeNode(12);
	    root.left.right.right  = new TreeNode(15);
	    FindSumOfAllLEFTLeaves sol = new FindSumOfAllLEFTLeaves();
	    System.out.print( "Sum of left leaves is " + sol.findSumOfAllLeftLeaves(root));
	}

}
