package SymmetricTree;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
	/*
	 * Bonus points if you could solve it both recursively and iteratively.
	 */
	// iteratively
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        if(root.left == null && root.right == null) return true;
        
        Queue<TreeNode> parent = new LinkedList<TreeNode>();
        if( !check(root.left, root.right, parent) ) return false;
        // parent.add(root.left);
        // parent.add(root.right);
        
        while( !parent.isEmpty() ){
            Queue<TreeNode> child = new LinkedList<TreeNode>();
            while( !parent.isEmpty() ){
                TreeNode p1 = parent.remove();
                TreeNode p2 = parent.remove();
                if( !check(p1.left, p2.right, child) ) return false;
                if( !check(p1.right, p2.left, child) ) return false;
            }
            parent = child;
        }
        return true;
        
    }
    private boolean check(TreeNode c1, TreeNode c2, Queue<TreeNode> child){
        if(c1 == null && c2 == null) return true;
        if(c1 == null || c2 == null) return false;
        if(c1.val != c2.val) return false;
        child.add(c1);
        child.add(c2);
        return true;
    }
	
	
	// recursively
    public boolean isSymmetricRec(TreeNode root) {
        if(root==null){
        	return true;
        }
        return isTwoSymmetric(root.left, root.right);
    }
    private boolean isTwoSymmetric (TreeNode t1, TreeNode t2){
    	if(t1 == null && t2 == null){
    		return true;
    	}
    	if(t1 == null || t2 == null){
    		return false;
    	}
    	return t1.val == t2.val
    			&& isTwoSymmetric ( t1.left,  t2.right)
    			&& isTwoSymmetric ( t1.right, t2.left);
    }
}
