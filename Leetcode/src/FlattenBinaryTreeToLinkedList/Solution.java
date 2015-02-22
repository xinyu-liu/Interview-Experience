package FlattenBinaryTreeToLinkedList;

import java.util.Stack;

public class Solution {
	// WEB rec:
	//������root����������ʱ���ǿ���ֱ�Ӳ����ģ�
	// ����������ôȥ�������������������أ�
	// Ӧ�����������������Ǹ�������������root���ӣ�
	// ����������Ҫȥ�ҵ������������(����)�Ǹ��ǿս�㡣
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
    // ��pre order��keepһ��prev reference�����ˡ������Ǹ�˳�ε�pattern��
    // ע������in place�ĸĶ��Һ��ӣ�ͬʱ������գ�����Ҫ���������ݴ�������
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
