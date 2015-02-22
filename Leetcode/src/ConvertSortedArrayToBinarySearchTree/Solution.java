package ConvertSortedArrayToBinarySearchTree;

public class Solution {
    public TreeNode sortedArrayToBST(int[] num) {
    	if(num == null || num.length == 0){
    		return null;
    	}
        return transfer(num, 0, num.length-1);
    }
    private TreeNode transfer(int[] num, int start, int end){
    	if(start ==  end){
    		return new TreeNode(num[start]);
    	}
    	int mid = (start + end) / 2 ;
    	TreeNode root = new TreeNode(num[mid]);
    	if(mid-1-start>=0){
    		root.left = transfer(num, start, mid-1);
    	}
    	if(end-mid-1 >= 0){
    		root.right = transfer(num, mid+1,end);
    	}
    	return root;
    }
}
