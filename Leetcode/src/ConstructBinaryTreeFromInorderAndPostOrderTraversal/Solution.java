package ConstructBinaryTreeFromInorderAndPostOrderTraversal;

public class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
         return build(inorder, inorder.length-1, postorder, inorder.length-1, inorder.length );
    }
    private TreeNode build(int[] inorder, int startI, 
    					 int[] postorder, int startP, int len) {
    	if(len <= 0) return null;
    	int rl;
    	for(rl = 0; rl < len; rl++){
    		if (postorder[startP] == inorder[startI - rl]){
    			break;
    		}
    	}
    	
    	TreeNode root = new TreeNode(postorder[startP]);
    	root.left = build(inorder, startI - rl - 1, postorder, startP - rl - 1, len - rl - 1 );
    	root.right = build(inorder, startI, postorder, startP-1, rl);
    	return root;
    }
    
}
