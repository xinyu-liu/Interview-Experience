package PrintXViewOfABinaryTree;

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

The idea is to traverse the tree once and get the minimum and maximum horizontal distance with respect to root. 
For the tree shown above, minimum distance is -2 (for node with value 4) and maximum distance is 3 (For node with value 9).
Once we have maximum and minimum distances from root, we iterate for each vertical line at distance minimum to maximum from root, 
and for each vertical line traverse the tree and print the nodes which lie on that vertical line.

Algorithm:

// min --> Minimum horizontal distance from root
// max --> Maximum horizontal distance from root
// hd  --> Horizontal distance of current node from root 
findMinMax(tree, min, max, hd)
     if tree is NULL then return;
 
     if hd is less than min then
           min = hd;
     else if hd is greater than max then
          *max = hd;
 
     findMinMax(tree->left, min, max, hd-1);
     findMinMax(tree->right, min, max, hd+1);

 
printVerticalLine(tree, line_no, hd)
     if tree is NULL then return;
 
     if hd is equal to line_no, then
           print(tree->data);
     printVerticalLine(tree->left, line_no, hd-1);
     printVerticalLine(tree->right, line_no, hd+1); 
 */
public class PrintVerticalOrderOfABinaryTree {
	////////////////////////////////BF Print All O(n2)///////////////////////////////////////////
	// Time: O(w*n) where w is width of Binary Tree
	// In worst case O(n2)
	private int min = 1;
	private int max = -1;
	public void solveBF(TreeNode root){
		min = 1;
		max = -1;
		findMinMax(root, 0);
		for(int hd = min; hd <= max; hd++){
			printEachHd(root, 0, hd);
			System.out.println();
		}
	}
	private void printEachHd(TreeNode root, int hd, int target){ // O(n)
		if(root == null) return;
		if(hd == target) System.out.print(root.val+" ");
		printEachHd(root.left, hd-1, target);
		printEachHd(root.right, hd+1, target);		
	}
	private void findMinMax(TreeNode root, int hd){ // O(n)
		if(root == null) return;
		if(hd > max) 		max = hd;
		else if(hd < min)   min = hd;
		
		findMinMax(root.left, hd-1);
		findMinMax(root.right, hd+1);
	}
	////////////////////////// Vertical Sum in a given Binary Tree O(n)//////////////////////////////
	public void findSum(TreeNode root){
		// base case
        if (root == null) return; 
        
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		recFindSum(root, 0, map);
		for(Integer hd: map.keySet()){
			// System.out.println(map.entrySet());
			System.out.println(hd + " => " + map.get(hd));
		}
	}
	private void recFindSum(TreeNode root, int hd, Map<Integer, Integer> map){
		if(root == null) return;
		
		Integer prevSum = map.get(hd);
		if(prevSum == null) prevSum = 0;
		map.put(hd, prevSum + root.val);
		recFindSum(root.left, hd-1, map);
		recFindSum(root.right, hd+1, map);
		
	}
	////////////////////////////////Hashmap based Print All O(n)///////////////////////////////////////////
	public void solveHashmap(TreeNode root){
		if(root == null) return;
		HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
		dfs(root, 0, map);
		System.out.print(map.entrySet());
	}
	private void dfs(TreeNode root, int hd, HashMap<Integer, ArrayList<Integer>> map){
		if(root == null) return;
		ArrayList<Integer> list = map.get(hd);
		if(list == null) list = new ArrayList<Integer>();
		list.add(root.val);
		map.put(hd, list);
		
		dfs(root.left, hd-1, map);
		dfs(root.right, hd+1, map);
		
	}
	
	
	
	
	
	// tester
	public static void main(String[] args){
		 /* Constructed binary tree is 
        1
      /   \
     2     3
  /    \     \
4       5     8
      /   \	    \
     6     7     9
    		   /   \
              10    11
            /    \
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
		
		PrintVerticalOrderOfABinaryTree sol = new PrintVerticalOrderOfABinaryTree();
		sol.solveBF(root);
		// sol. findSum(root);
		sol.solveHashmap(root);
	}
}
