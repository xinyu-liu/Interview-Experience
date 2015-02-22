package PrintXViewOfABinaryTree;

import java.util.LinkedList;
import java.util.Queue;

/*
 * Left view of a Binary Tree is set of nodes visible when tree is visited from left side. 
 * Left view of following tree is 12, 10, 25.

          12
       /     \
     10       30
            /    \
          25      40 
The left view contains all nodes that are first nodes in their levels. 

Solution 1: O(n)
A simple solution is to do level order traversal and print the first node in every level.

Solution 2: O(n)
The problem can also be solved using simple recursive traversal. 
We can keep track of level of a node by passing a parameter to all recursive calls. 
The idea is to keep track of maximum level also. 
Whenever we see a node whose level is more than maximum level so far, 
we print the node because this is the first node in its level 
(Note that we traverse the left subtree before right subtree). 

 */
public class PrintLeftViewOfABinaryTree {
	// Solution 1: level traversal
	public void solve1(TreeNode root){ 
		if(root == null) return;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		while( !queue.isEmpty() ){
			Queue<TreeNode> queue2 = new LinkedList<TreeNode>();
			boolean first = true;
			while( !queue.isEmpty() ){
				TreeNode n = queue.remove();
				if(first){
					System.out.println(n.val);
					first = false;
				}
				if(n.left != null) queue2.add(n.left);
				if(n.right != null) queue2.add(n.right);
			}
			queue = queue2;
		}
		
	}
	// Solution 2: recursion
	public void solve2(TreeNode root){ // recursion
		if(root == null) return;
		dfs(root, 0);
	}
	private int maxLevel = -1;
	private void dfs(TreeNode root, int level){
		if(root == null) return;
		if(level > maxLevel){
			System.out.println(root.val);
			maxLevel = level; 
		}
		dfs(root.left, level+1);
		dfs(root.right,level+1);
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
		
		PrintLeftViewOfABinaryTree sol = new PrintLeftViewOfABinaryTree();
		sol.solve1(root);
		System.out.println();
		sol.solve2(root);
	}

}
