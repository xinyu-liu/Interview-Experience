package ConstructBinaryTreeFromPreorderAndInorderTraversal;

public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
    	return build(preorder,0, inorder, 0, preorder.length);
    }
    private TreeNode build(int[] preorder, int startP, 
    		               int[] inorder, int startI, int treeLength) {
    	if(treeLength == 0){
    		return null;
    	}
    	int leftLength = 0;
    	
    	while(leftLength < treeLength && inorder[startI + leftLength] != preorder[startP]){
    		leftLength++;
    	}
    	TreeNode root = new TreeNode(preorder[startP]);
    	root.left = build (preorder, startP+1, inorder, startI, leftLength);
    	root.right = build (preorder, startP + leftLength + 1, 
    						inorder, startI + leftLength + 1, treeLength - leftLength -1);
    	return root;
    }
}
