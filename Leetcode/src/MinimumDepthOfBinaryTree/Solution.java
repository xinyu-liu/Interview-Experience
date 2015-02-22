package MinimumDepthOfBinaryTree;

public class Solution {
	// Note: The minimum depth is the number of nodes 
	// along the shortest path from the root node down 
	// to the nearest leaf node.
	
	// root -> leaf node! One child note cannot return 0 !
	// DIFFERENT with Balanced Binary Tree: the depth of 
	// the TWO SUBTREES of EVERY NODE never differ by more than 1. 
	
    public int minDepth(TreeNode root) {
        if(root == null){
        	return 0;
        }
        if(root.left == null && root.right == null){
        	return 1;
        }
        if(root.left == null){
        	return minDepth(root.right) + 1;
        }        
        if(root.left == null && root.right == null){
        	return minDepth(root.left) + 1;
        }
        return Math.min(minDepth(root.left),minDepth(root.right)) + 1;
        
    }
}
