package PrintBinaryTreeInVerticalOrder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*
           1
        /    \
       2      3
      / \    / \
     4   5  6   7
             \   \
              8   9 	  
The output of print this tree vertically will be:
4
2
1 5 6
3 8
7
9 
Time complexity of (find min-max hd and iterate through) algorithm is O(w*n) where w is width of Binary Tree. 
In worst case, the value of w can be O(n) (consider a complete tree for example) and time complexity can become O(n2).
Below: O(n) with hashmap
 */
public class PrintBinaryTreeInVerticalOrder {
	Map<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
	// O(n) under the assumption that we have good hashing function that allows insertion and retrieval operations in O(1) time. 
	public void printVertical(TreeNode root){
		dfs(root, 0);
		for(int k: map.keySet()){
			System.out.println(map.get(k));
		}
	}
	public void dfs(TreeNode root, int pos){
		if(root == null) return;
		// self
		ArrayList<Integer> list = map.get(pos);
		if(list == null) list = new ArrayList<Integer>();
		list.add(root.val);
		map.put(pos, list);
		
		dfs(root.left, pos - 1);
		dfs(root.right, pos + 1);
	}
	public static void main(String[] args) { 
		TreeNode root = new TreeNode (1);
		root.left = new TreeNode (2);
		root.right = new TreeNode (3);	
		
		root.left.left = new TreeNode (4);
		root.left.right = new TreeNode (5);
		root.right.left = new TreeNode (6);
		root.right.right = new TreeNode (7);
		root.right.left.right = new TreeNode (8);
		root.right.right.right = new TreeNode (9);			  
		PrintBinaryTreeInVerticalOrder sol = new PrintBinaryTreeInVerticalOrder();
		sol.printVertical(root);
	}

}
