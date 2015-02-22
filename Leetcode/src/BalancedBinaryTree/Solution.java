package BalancedBinaryTree;

public class Solution {
	// Note: Balanced Binary Tree: the depth of 
	// the TWO SUBTREES of EVERY NODE never differ by more than 1.
	
	// DIFFERENT with the minimum depth 
	// number of nodes along the shortest path from the root node  
	// down to the nearest leaf node.
	// root -> leaf node! One child note cannot return 0 !
	private boolean ans = true;  
    public boolean isBalanced(TreeNode root) {
    	if(root == null){
    		return true;
    	}
    	findNCheckDepth(root);	
        return ans;
    }
    private int findNCheckDepth(TreeNode root){
    	if(!ans){
    		return 0;
    	}
    	if(root == null){
    		return 0;
    	}
    	int left = findNCheckDepth(root.left);
    	int right = findNCheckDepth(root.right);
    	if(Math.abs(left-right)>1){
    		ans = false;
    	}
    	return Math.max(left, right)+1;
    }
}