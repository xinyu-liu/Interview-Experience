package PathSum;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	// II
	// new 
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if(root == null) return ans;
        
        List<Integer> list = new ArrayList<Integer>();
        dfs(root, sum, list, ans);
        return ans;
    }
    private void dfs(TreeNode root, int sum, List<Integer> list, List<List<Integer>> ans){
        list.add(root.val);
        if(root.left == null && root.right == null){
            if(sum == root.val) {
                ans.add( new ArrayList<Integer>(list) );
            }
        }
        if(root.left != null)  dfs(root.left, sum - root.val, list, ans);
        if(root.right != null)  dfs(root.right, sum - root.val, list, ans);
        list.remove(list.size()-1);
    }
    
    
    
	// old
    public List<List<Integer>> pathSumOLD(TreeNode root, int sum) {
      	if(root == null){
    		return new ArrayList<List<Integer>>();
    	}
        return calcII(root, 0, sum);
    }
    private List<List<Integer>> calcII(TreeNode root, int cur, int target){
    	if(root.left==null && root.right==null){
    		List<List<Integer>> result = new ArrayList<List<Integer>>();
    		
    		if(cur + root.val == target){
    			List<Integer> list = new ArrayList<Integer>();
    			list.add(root.val);
    			result.add(list);
    		}
    		
    		return result;
    	}
    	else{
    		List<List<Integer>> result = new ArrayList<List<Integer>>();
	    	if(root.left != null){
	    		List<List<Integer>> temp = calcII(root.left , cur + root.val, target);
	    		for(List<Integer> list : temp){
	    			list.add(0,root.val);
	    			result.add(list);
	    		}
	    	}
	    	if(root.right != null){
	    		List<List<Integer>> temp = calcII(root.right , cur + root.val, target);
	    		for(List<Integer> list : temp){
	    			list.add(0,root.val);
	    			result.add(list);
	    		}
	    	}
	    	return result;
    	}
    }

    
    
	// I
    public boolean hasPathSum(TreeNode root, int sum) {
    	if(root == null){
    		return false;
    	}
        return calc(root, 0, sum);
    }
    private boolean calc(TreeNode root, int cur, int target){
    	if(root.left==null && root.right==null){
    		return cur + root.val == target;
    	}
    	else{
	    	boolean b = false;
	    	if(root.left != null){
	    		b = b || calc(root.left , cur + root.val, target) ;
	    	}
	    	if(root.right != null){
	    		b = b || calc(root.right , cur + root.val, target) ;
	    	}
	    	return b;
    	}

    }

}
