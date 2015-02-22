package PrintXViewOfABinaryTree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/*
 * Top view of a binary tree is the set of nodes visible when the tree is viewed from the top. 
 * The output nodes can be printed in any order. Expected time complexity is O(n)
 * 
 * A node x is there in output if x is the topmost node at its horizontal distance. 
 * Horizontal distance of left child of a node x is equal to horizontal distance of x minus 1, 
 * and that of right child is horizontal distance of x plus 1.
 * 
       1
    /     \
   2       3
  /  \    / \
 4    5  6   7
Top view of the above binary tree is
4 2 1 3 7

        1
      /   \
    2       3
      \   
        4  
          \
            5
             \
               6
Top view of the above binary tree is
2 1 3 6

Solution 1:
using set / map
Do a level order traversal so that the topmost node at a horizontal node is visited 
before any other node of same horizontal distance below it. 
Hashing is used to check if a node at given horizontal distance is seen or not.

Solution 2:
using maxDist, minDist
Print a node if its distance is less than minDist or greater than maxDist. 
 */
public class PrintTopViewOfABinaryTree {

	// can use one queue<QItem>
	// QItem class stores both TreeNode n & int hd !!!!  better than using two queues!!! 
	class QItem{
		TreeNode n;
		int hd;
		QItem(TreeNode n,int hd){
			this.n = n;
			this.hd = hd;
		}
	}
	
	///////////////////////// Solution 1: using set / map
	public void solve1(TreeNode root){ 
		if(root == null) return;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		Queue<QItem> queue = new LinkedList<QItem>();
		queue.add( new QItem(root, 0) );
		
		while( !queue.isEmpty() ){
			Queue<QItem> queue2 = new LinkedList<QItem>();
			while( !queue.isEmpty() ){
				// cur
				QItem item = queue.remove();
				TreeNode n = item.n;
				int hd = item.hd;
				if( !map.containsKey(hd) ){
					map.put(hd, n.val); // use set to store hd, and System.out.print(n.val + " ");
				}
				// child
				if(n.left != null){
					queue2.add( new QItem(n.left, hd-1) );
				}
				if(n.right != null) {
					queue2.add( new QItem(n.right, hd+1) );
				}
			}
			queue = queue2;
		}
		
		// print out
		for(int hd: map.keySet()){
			System.out.print(map.get(hd) + " ");
		}
		
	}

	///////////////////////// Solution 2: using maxDist, minDist
	public void solve2(TreeNode root){ 
		if(root == null) return;
		Queue<QItem> queue = new LinkedList<QItem>();
		queue.add( new QItem(root, 0) );
		int max = -1;
		int min = 0;
		
		while( !queue.isEmpty() ){
			Queue<QItem> queue2 = new LinkedList<QItem>();
			while( !queue.isEmpty() ){
				// cur
				QItem item = queue.remove();
				TreeNode n = item.n;
				int hd = item.hd;
				if( hd < min ){
					min = hd;
					System.out.print(n.val + " ");
				}
				else if(hd > max){
					max = hd;
					System.out.print(n.val + " ");
				}
				// child
				if(n.left != null){
					queue2.add( new QItem(n.left, hd-1) );
				}
				if(n.right != null) {
					queue2.add( new QItem(n.right, hd+1) );
				}
			}
			queue = queue2;
		}
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
		
		PrintTopViewOfABinaryTree sol = new PrintTopViewOfABinaryTree();
		sol.solve1(root);
		System.out.println();
		sol.solve2(root);
	}

}
