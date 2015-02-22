package BinaryTreePostorderTraversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Solution {
	// normal way
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<Integer>();
        if(root == null) return ans;
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode lastVisited = null;
        
        TreeNode n = root;
        while(n != null){
            stack.push(n);
            n = n.left;
        }        
        while(n != null || !stack.empty()){
            if(stack.peek().right == null 
                    || stack.peek().right == lastVisited){
                lastVisited = stack.pop();
                ans.add(lastVisited.val);
            }
            else{
                n = stack.peek().right;
                while(n != null){
                    stack.push(n);
                    n = n.left;
                }
            }
        }
        return ans;
    }
    // tricky way
    public List<Integer> postorderTraversal2(TreeNode root) {
        LinkedList<Integer> ans = new LinkedList<Integer>();
        if(root == null) return ans;
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        
        while( !stack.empty() ){
            TreeNode n = stack.pop();
            ans.addFirst(n.val);
            if(n.left != null) stack.push(n.left);
            if(n.right != null) stack.push(n.right);
        }
        return ans;
    }

}
