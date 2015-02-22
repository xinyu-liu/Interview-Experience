package FlattenBinaryTreeToLinkedList;

import java.util.Stack;

public class Solution {
	// WEB rec:
	//在链接root和左子树的时候是可以直接操作的，
	// 但是我们这么去链接左子树和右子树呢？
	// 应该是左子树中最后的那个结点跟右子树的root链接，
	// 所以我们需要去找到左子树的最后(最右)那个非空结点。
    public void flatten(TreeNode root) {
    	if(root == null){
    		return;
    	}
    	flatten(root.left);
    	flatten(root.right);
    	
    	
    	TreeNode r = root.right;
    	root.right = root.left;
    	root.left = null;
    	
    	TreeNode n = root;
    	while(n.right!=null){
    		n=n.right;
    	}
    	n.right = r;       
    }
    
    // WEB rec: 
    // 按pre order，keep一个prev reference就行了。还是那个顺次的pattern。
    // 注意这是in place的改动右孩子，同时左孩子清空，所以要把他们先暂存下来。
	public void flattenR1(TreeNode root) {
		flatten(root, new TreeNode[1]);
	}
	private void flatten(TreeNode root, TreeNode[] prev) {
		if (root == null)
			return;
		
		if (prev[0] == null) {
			prev[0] = root;
		} else {
			prev[0].right = root;
			prev[0] = root;
		}
		TreeNode leftBeforeModification = root.left;
		TreeNode rightBeforeModification = root.right;
		root.left = null;
		flatten(leftBeforeModification, prev);
		flatten(rightBeforeModification, prev);
	}
	
    // iterative
    public void flattenI(TreeNode root) {
        if(root == null) return;
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        TreeNode cur = new TreeNode(0);
        while( !stack.empty() ){
            TreeNode n = stack.pop();
            
            cur.left = null;
            cur.right = n;
            cur = n;
            
            if(n.right != null) stack.push(n.right);
            if(n.left != null) stack.push(n.left);
        }
    }
}
