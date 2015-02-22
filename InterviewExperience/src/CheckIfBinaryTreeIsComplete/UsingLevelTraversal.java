package CheckIfBinaryTreeIsComplete;

import java.util.LinkedList;
import java.util.Queue;

/*
 * A complete binary tree is a binary tree in which 
 * every level, except possibly the last, is completely filled, and all nodes are as far left as possible.
 */
public class UsingLevelTraversal {
	public boolean isComplete(TreeNode root){
		boolean startNoChild = false;
		if(root == null) return true;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		while( !queue.isEmpty() ){
			TreeNode n = queue.remove();
			if(!startNoChild){
				if(n.left == null && n.right != null) return false;
				if(n.right == null) startNoChild = true;
				
				if(n.left != null) queue.add(n.left);
				if(n.right != null) queue.add(n.right);
			}
			else{
				if(n.left != null || n.right != null) return false;
			}
		}
		return true;
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
		
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		
		
		root.left.left = new TreeNode(5);	
		//root.right.left = new TreeNode(4);
		//root.right.right = new TreeNode(6);
	
		
		UsingLevelTraversal sol = new UsingLevelTraversal();
		System.out.println(sol.isComplete(root));
	}

}
