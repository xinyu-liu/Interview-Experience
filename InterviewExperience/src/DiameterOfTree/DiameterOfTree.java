package DiameterOfTree;
/*
Given a binary tree, find the diameter of the tree.
The diameter of a tree (sometimes called the width) is the number of nodes 
on the longest path between two leaves in the tree.
 *
 *below ²»»á×ö¡£¡£¡£
After solving the above one, he added a constraint on the above problem: (i.e) To find the diameter of the tree with atmost one turn
Examples of turns in tree:
In tree1-> start from 1 and there is a turn at root 2 towards right,
In tree2-> starts from 3 goes in left and there is a turn at 1 towards right ,
In tree3-> starts from 1 goes in right and there is a turn at 3 towards left,
     2                 3                 1
    / \               /                   \
   1   3             1                     3
                      \                    /
                       2                  2
 * 
 * 
 */
public class DiameterOfTree {
	private int max = 0; ////// this is the answer
	// O(n)
	public int diameter(TreeNode root){
		if(root == null) return 0;
		if(root.left == null && root.right == null) return 1;
		int l = diameter(root.left);
		int r = diameter(root.right);
		max = Math.max(max, l+r+1);
		return Math.max(l, r) + 1;
	}
	public static void main(String[] args) {
		
		 /* Constructed binary tree is 
        1
      /   \
    2      3
  /  \       \
4     5       8
     / \	   \
    6   7       9
    		   / \
              10  11
             /  \
            12  13
*/
		TreeNode root = new TreeNode(1);
		
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);	
		root.right.right = new TreeNode(8);
		
		root.left.right.left = new TreeNode(6);	
		root.left.right.right = new TreeNode(7);
		root.right.right.right = new TreeNode(9);
		root.right.right.right.left = new TreeNode(10);
		root.right.right.right.right = new TreeNode(11);
		
		root.right.right.right.left.left = new TreeNode(12);
		root.right.right.right.left.right = new TreeNode(13);
		DiameterOfTree sol = new DiameterOfTree();
		System.out.println(sol.diameter(root) );
		System.out.println(sol.max); // ans
	}

}
