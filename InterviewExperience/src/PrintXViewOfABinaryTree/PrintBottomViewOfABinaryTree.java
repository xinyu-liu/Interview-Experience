package PrintXViewOfABinaryTree;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

/*
Print the bottom view from left to right. A node x is there in output if x is the bottommost node at its horizontal distance. 
Horizontal distance of left child of a node x is equal to horizontal distance of x minus 1, 
and that of right child is horizontal distance of x plus 1.

Examples:
                      20
                    /    \
                  8       22
                /   \       \
              5       3      25
                     / \      
                 10      14
For the above tree the output should be 5, 10, 3, 14, 25.

If there are multiple bottom-most nodes for a horizontal distance from root, then print the later one in level traversal. 
For example, in the below diagram, 3 and 4 are both the bottom-most nodes at horizontal distance 0, we need to print 4.
                      20
                    /    \
                  8       22
                /   \    /   \
              5      3 4     25
                    /  \      
                 10       14 
For the above tree the output should be 5, 10, 4, 14, 25.




Solution 1:
using map + level traversal (NOTE: IF REQUERE FROM LEFT TO RIGHT, WE SHOULD USD TREEMAP!)
1. We put tree nodes in a queue for the level order traversal.
2. Start with the horizontal distance(hd) 0 of the root node, keep on adding left child to queue along with the horizontal distance as hd-1 and right child as hd+1.
3. Also, use a TREEMAP which stores key value pair sorted on key.
4. Every time, we encounter a N horizontal distance or an existing horizontal distance, put the node data to the map. 
	For the first time it will add to the map, next time it will replace the value. 
	This will make sure that the BOTTOM MOST element for that horizontal distance is present in the map 
	and if you see the tree from beneath that you will see that element.

Solution 2:
using map + in-order traversal(storing the level) (NOTE: IF REQUERE FROM LEFT TO RIGHT, WE SHOULD USD TREEMAP!)

Solution 3 WRONG! DONT SEE!( wrong for the the example in main() )
how about using map + post-order traversal(NOTE: IF REQUERE FROM LEFT TO RIGHT, WE SHOULD USD TREEMAP!)

 */
public class PrintBottomViewOfABinaryTree {

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
	
	///////////////////////// Solution 1: using set / map + level traversal (REQUERE FROM LEFT TO RIGHT, WE SHOULD USD TREEMAP!)   O(nlogn)
	public void solve1(TreeNode root){ 
		if(root == null) return;
		Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
		Queue<QItem> queue = new LinkedList<QItem>();		/////one queue is enough because we do not care what the level is
		queue.add( new QItem(root, 0) );
		
		while( !queue.isEmpty() ){
				// cur
				QItem item = queue.remove();
				TreeNode n = item.n;
				int hd = item.hd;
				map.put(hd, n.val);///// UPDATE EVERY TIME
				// child
				if(n.left != null){
					queue.add( new QItem(n.left, hd-1) );
				}
				if(n.right != null) {
					queue.add( new QItem(n.right, hd+1) );
				}
		}
		
		// print out
		for(int hd: map.keySet()){
			System.out.print(map.get(hd) + " ");
		}
		
	}

	///////////////////////// Solution 2: using map + in-order traversal(storing the level) (NOTE: IF REQUERE FROM LEFT TO RIGHT, WE SHOULD USD TREEMAP!)
	class MapItem{
		int val;
		int level;
		MapItem(int v, int l){
			val = v;
			level = l;
		}
	}
	public void solve3(TreeNode root){ 
		if(root == null) return;
		Map<Integer, MapItem> map = new TreeMap<Integer, MapItem>();
		dfs(root, map, 0, 0);
		// print
		for(int hd: map.keySet()){
			System.out.print(map.get(hd).val+" ");
		}
	}
	private void dfs(TreeNode root, Map<Integer, MapItem> map, int hd, int level){
		if(root == null) return;
		dfs(root.left, map, hd-1, level+1);
		dfs(root.right, map, hd+1, level+1);
		
		MapItem oldItem = map.get(hd);
		if( oldItem == null || oldItem.level < level){
			map.put( hd, new MapItem(root.val, level) );
		}
	}

	public static void main(String[] args) {
		 /* Constructed binary tree is 
        1
      /   \
    2      3
  /   \      \
4       5     8
      /   \	    \
    6      7      9
    		    /   \
             10      11
            /   \
          12     13
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
		
		PrintBottomViewOfABinaryTree sol = new PrintBottomViewOfABinaryTree();
		sol.solve1(root);
		System.out.println();
		sol.solve3(root);
	}

}
