package BinaryTreeMaximumPathSum;

import java.util.ArrayList;

public class Solution {
    // WEB 
    int max;
    public int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;
        dfs(root);
        return max;
    }
    
    public int dfs(TreeNode root){
        if (root==null) return 0;
        int l = dfs(root.left);
        int r = dfs(root.right);
        int sum = root.val;
        if (l>0) sum += l;
        if (r>0) sum += r;
        max = Math.max(max,sum);
        return Math.max(r,l) > 0 ? (Math.max(r,l) + root.val)  : root.val;
    }
    // MINE
    public int maxPathSumMINE(TreeNode root) {
    	ArrayList<Integer> ans = new ArrayList<Integer>();
    	ans.add(Integer.MIN_VALUE); 
    	maxPath( root, ans);
    	return ans.get(0);
    }
    private int maxPath(TreeNode root, ArrayList<Integer> totalMax){
    	if(root == null){
    		return 0;
    	}
    	int max = 0;
    	int left = maxPath(root.left, totalMax);
    	int right = maxPath(root.right,totalMax);
    	if(left > max){
    		max = left;
    	}
    	if(right > max){
    		max = right;
    	}
    	max += root.val;
    	if(max > totalMax.get(0)){
    		totalMax.set(0,  max);
    	}
    	if(left + right + root.val > totalMax.get(0)){
    		totalMax.set(0, left + right + root.val);
    	}
    	return max;
    }
}
