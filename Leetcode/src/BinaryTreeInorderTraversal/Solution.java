package BinaryTreeInorderTraversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
	// first try
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> ans = new ArrayList<Integer>();
    	
    	Stack<TreeNode> stack = new Stack<TreeNode>();
    	TreeNode n = root;
    	
    	while(n!=null || !stack.isEmpty()){
	    	while(n != null){
	    		stack.push(n);
	    		n = n.left;
	    	}
	    	while(n == null && !stack.empty()){
	    		n = stack.pop();
	    		ans.add(n.val);
	    		n = n.right;
	    	}
    	}
    	return ans;
    }
    // second try
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<Integer>();
    	
    	Stack<TreeNode> stack = new Stack<TreeNode>();
    	TreeNode n = root;
    	
    	while(n!=null || !stack.isEmpty()){
	    	if(n != null){
	    		stack.push(n);
	    		n = n.left;
	    	}
	    	else if( !stack.empty() ){
	    		n = stack.pop();
	    		ans.add(n.val);
	    		n = n.right;
	    	}
    	}
    	return ans;
    }
}
