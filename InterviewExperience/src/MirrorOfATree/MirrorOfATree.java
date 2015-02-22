package MirrorOfATree;

public class MirrorOfATree {
	/*
If iterative : can use level-order traversal of the tree. 
1. Check if root is NULL
2. If not NULL
swap left sub tree with right sub tree
en-queue both left sub tree and right sub tree. do not enqueue if NULL
now pop from the queue and make that element the root.
3. repeat from step 1
	 */

	
	/* Driver program to test mirror() */
	public static void main(String[] args){
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
	   
		MirrorOfATree sol = new MirrorOfATree();
		
	  /* Print inorder traversal of the input tree */
	  System.out.println(" Inorder traversal of the constructed tree is ");
	  sol.inOrder(root);
	  System.out.println();
	  
	  /* Convert tree to its mirror */
	  // sol.findMirrorRec(root);
	  TreeNode n = sol.findMirrorRec2(root);  
	  
	  /* Print inorder traversal of the mirror tree */
	  System.out.println(" Inorder traversal of the constructed tree is ");
	  // sol.inOrder(root);
	  sol.inOrder(n);
	}
	
	// for testing
	public void inOrder(TreeNode root){
		if(root == null) return;
		inOrder(root.left);
		System.out.print(root.val + " ");
		inOrder(root.right);
	}
	// create a new tree
	public TreeNode findMirrorRec2(TreeNode root){
		if(root == null) return null;
		
		TreeNode newRoot = new TreeNode(root.val);
		newRoot.left = findMirrorRec2(root.right);
		newRoot.right = findMirrorRec2(root.left);
		return newRoot;
	}
	
	
	
	// change the original tree
	public void findMirrorRec(TreeNode root){
		if(root == null) return;
		findMirrorRec(root.left);
		findMirrorRec(root.right);
		if(root.left != null || root.right != null){
			swap(root);
		}
	}
	private void swap(TreeNode p){
		TreeNode temp = p.left;
		p.left = p.right;
		p.right = temp;
	}
}