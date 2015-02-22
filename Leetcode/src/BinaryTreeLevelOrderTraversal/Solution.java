package BinaryTreeLevelOrderTraversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class Solution {
	// Binary Tree Zigzag Level Order Traversal
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    	int level = 1;
      	List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null){
        	return result;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();

        queue.add(root);
        queue.add(null);
        List<Integer> list = new ArrayList<Integer>();
        
        while(!queue.isEmpty()){
        	TreeNode cur = queue.remove();
        	if(cur!=null){
        		if(level % 2 == 1){
        			list.add(cur.val); 
        		}
        		else{
        			list.add(0,cur.val);
        		}
        		if(cur.left != null){
	        		queue.add(cur.left);
	        	}
	        	if(cur.right!=null){
	        		queue.add(cur.right);
	        	}
        	}
        	else{
        		result.add(list);
        		level++;
        		list = new LinkedList<Integer>();
        		if(queue.isEmpty()){
        			break;
        		}
        		queue.add(null);
        	}
        }
        return result;
    }
	// II use Stack or LinkedList
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
       	List<List<Integer>> result = new LinkedList<List<Integer>>();
        if(root == null){
        	return result;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();

        queue.add(root);
        queue.add(null);
        List<Integer> list = new ArrayList<Integer>();
        
        while(!queue.isEmpty()){
        	TreeNode cur = queue.remove();
        	if(cur!=null){
        		list.add(cur.val); 
	        	
        		if(cur.left != null){
	        		queue.add(cur.left);
	        	}
	        	if(cur.right!=null){
	        		queue.add(cur.right);
	        	}
        	}
        	else{
        		result.add(0, list);
        		list = new ArrayList<Integer>();
        		if(queue.isEmpty()){
        			break;
        		}
        		queue.add(null);
        	}
        }
        return result;
    }
	// I 
    // better
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if(root == null) return ans;
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while( !queue.isEmpty() ){
            Queue<TreeNode> queue2 = new LinkedList<TreeNode>();
            List<Integer> list = new ArrayList<Integer>();
            while( !queue.isEmpty() ){
                TreeNode cur = queue.remove();
                list.add(cur.val);
                if(cur.left != null)  queue2.add(cur.left);
                if(cur.right != null)  queue2.add(cur.right);
            }
            ans.add(list);
            queue = queue2;
        }
        return ans;
    }
    // worse
    public List<List<Integer>> levelOrderX(TreeNode root) {
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null){
        	return result;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        queue.add(null);
        List<Integer> list = new ArrayList<Integer>();
        
        while(!queue.isEmpty()){
        	TreeNode cur = queue.remove();
        	if(cur!=null){
        		list.add(cur.val); 
	        	
        		if(cur.left != null){
	        		queue.add(cur.left);
	        	}
	        	if(cur.right!=null){
	        		queue.add(cur.right);
	        	}
        	}
        	else{
        		result.add(list);
        		list = new ArrayList<Integer>();
        		if(queue.isEmpty()){
        			break;
        		}
        		queue.add(null);
        	}
        }
        return result;
    }
}
