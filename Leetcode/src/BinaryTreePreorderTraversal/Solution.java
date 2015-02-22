package BinaryTreePreorderTraversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class Solution {
	// WEB: ǰ��ĵ�����Լ򵥡�ֻ��Ҫstack֮���ұߵ�����ջ���ɡ�
    public List<Integer> preorderTraversal(TreeNode root) {
    	List<Integer> ans = new ArrayList<Integer>();
    	if(root == null)  return ans;
    	
    	Stack<TreeNode> stack = new Stack<TreeNode>();
    	stack.add(root);
    	
    	while(!stack.isEmpty()){
    		TreeNode n = stack.pop();
    		visit(n,ans);
    		if(n.right!=null){
    			stack.push(n.right);
    		}
    		if(n.left!=null){
    			stack.push(n.left);
    		}
    	}
    	return ans;
    }
    private void visit(TreeNode n,List<Integer> ans){
    	ans.add(n.val);
    }
    // similar
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> ans = new ArrayList<Integer>();
    	if(root == null)  return ans;
    	
    	    Stack<TreeNode> stack = new Stack<TreeNode>();
    	    TreeNode n = root;
    	while( n != null || !stack.empty() ){    
    	    ans.add(n.val);
    	    // if(n.left != null) ans.add(n.left.val);
    	    if(n.right != null) stack.push(n.right);
    	    n = n.left;
    	    if(n == null && !stack.empty()) n = stack.pop();
    	}
    	return ans;
    }
}
