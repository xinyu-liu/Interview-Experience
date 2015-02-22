package BinarySearchTreeIterator;

import java.util.Stack;

public class BSTIterator {
	// web
    private Stack<TreeNode> stackW = new Stack<TreeNode>();

    public BSTIterator(TreeNode root, int W) {
        pushAll(root);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNextW() {
        return !stackW.isEmpty();
    }

    /** @return the next smallest number */
    public int nextW() {
        TreeNode tmpNode = stackW.pop();
        pushAll(tmpNode.right);
        return tmpNode.val;
    }

    private void pushAll(TreeNode node) {
        for (; node != null; stackW.push(node), node = node.left);
    }
    
	// 非递归遍历BST变种
	// 用栈来保存从根到最左侧叶子节点的路径，栈最上面的结点是最小的结点，
	// 每次取next,都是取栈最上面的结点，然后把剩余结点到最左侧叶子节点的路径放入栈中。
	private Stack<TreeNode> stack;
	
    public BSTIterator(TreeNode root) {
        stack = new Stack<TreeNode>();
        
        TreeNode cur = root;
        while(cur != null){
        	stack.push(cur);
        	cur = cur.left;
        } 
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return ( !stack.empty() );
    }

    /** @return the next smallest number */
    public int next() {
    	TreeNode cur = stack.pop();
    	int ans = cur.val;
    	
    	if(cur.right != null){
    		cur = cur.right;
    		while(cur != null){
            	stack.push(cur);
            	cur = cur.left;
            }
    	}
        return ans;
    }
}