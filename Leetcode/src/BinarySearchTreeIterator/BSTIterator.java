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
    
	// �ǵݹ����BST����
	// ��ջ������Ӹ��������Ҷ�ӽڵ��·����ջ������Ľ������С�Ľ�㣬
	// ÿ��ȡnext,����ȡջ������Ľ�㣬Ȼ���ʣ���㵽�����Ҷ�ӽڵ��·������ջ�С�
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