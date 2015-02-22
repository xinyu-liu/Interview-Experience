package SumRootToLeafNumbers;

public class Solution {
    public int sumNumbers(TreeNode root) {
    	return pre_order(root, 0) ;
    }
    public int pre_order(TreeNode root, int cur) {
        // pre-order traversal
       	if(root==null){
       		return 0;
       	}
       	int i = cur + root.val;
       	if(root.left == null && root.right == null){
       		return i;
       	}
       	return pre_order(root.left, i*10) + pre_order(root.right, i*10);
    }
}
