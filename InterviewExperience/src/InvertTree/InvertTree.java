package InvertTree;

import java.util.ArrayList;

/*
 * Given a binary tree ,you have to invert the tree ,
 * i.e. the parents would become children and the children would become parents
for example
      Given:                  1
                          /       \
                         2         3
                                  /
                                4


output:                  4
                           \
                    2        3
                      \      /
                         1 

 */
public class InvertTree {
	public ArrayList<TreeNode> invertTree(TreeNode root){
		ArrayList<TreeNode> newRoots = new ArrayList<TreeNode>();
		dfs(root, newRoots);
		return newRoots;
	}
	private void dfs(TreeNode root, ArrayList<TreeNode> newRoots){
		if(root.left == null && root.right == null) {
			newRoots.add(root);
			return;
		}
		if(root.left != null) {
			dfs(root.left, newRoots);
			root.left.right = root;
			root.left = null; ////MUST, else infinite loop
		}
		if(root.right != null) {
			dfs(root.right, newRoots);
			root.right.left = root;
			root.right = null; ////MUST, else infinite loop
		}
		
	}
	private void printTree(TreeNode t){
		if(t == null) return;
		System.out.println(t.val);
		System.out.println("Left: ");
		printTree( t.left );
		System.out.println("Right: ");
		printTree( t.right );
	}
	
	public static void main(String[] args) {


		 /* Constructed binary tree is 
      Given:                  1
                          /       \
                         2         3
                                  /
                                4


output:                  4
                           \
                    2        3
                      \      /
                         1 
*/
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);	
		root.right.left = new TreeNode(4);

		InvertTree sol = new InvertTree();
		ArrayList<TreeNode> newRoots = sol.invertTree(root);
		for(TreeNode t: newRoots){
			sol.printTree(t);
		}
		
	}

}
