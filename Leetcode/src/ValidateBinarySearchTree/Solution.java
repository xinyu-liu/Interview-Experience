package ValidateBinarySearchTree;

public class Solution {
	// Solution 2: narrow range
    public boolean isValidBST2(TreeNode root) {
        if(root == null){
        	return true;
        }        
        return rec(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
        
    }
    private boolean rec(TreeNode root,int min, int max) {
        if(root == null){
        	return true;
        }
        return root.val < max 
        	&& root.val > min 
        	&&rec( root.left, min, Math.min(max,root.val) ) 
        	&& rec( root.right, Math.max(min,root.val), max );
    }
    
    // Solution 1: in-order traversal 
    // without array to store
    // just compare the cur and prev
    long prevVal = (long)Integer.MIN_VALUE - 1;
    public boolean isValidBST(TreeNode root) {
    	return isValid(root);
    	
    }
    private boolean isValid(TreeNode root){
    	if(root == null){
    		return true;
    	}
    	if( !isValid(root.left) ) return false;
    	
    	long cur =  root.val;
    	if(cur <= prevVal) return false;
    	prevVal = cur;
    	
    	if( !isValid(root.right) ) return false;
    	
    	return true;
    }
    
    
    
    // wrong case:
	// NOTE: 需要跟全部祖先比 只比一层父子关系不可以 wrong case
	//		     10
	//		  5    15
	//	   	＃ ＃  6 20
public boolean isValidBST_WRONG(TreeNode root) {
    boolean b = true;
    if(root == null){
    	return b;
    }        
    if(root.left!=null){
    	b = b && root.val > root.left.val;
    }
    if(root.right!=null){
    	b = b && root.val < root.right.val;
    }
    return b && isValidBST(root.left) && isValidBST(root.right);
}
}
