package Chapter4;

public class InorderSuccessorWithParentLink {
	public TreeNode findNext(TreeNode cur){
		if(cur == null) return null;/////////////////
		
		if(cur.right != null){
			return findMostLeft(cur.right);
		}
		else if(cur.parent == null || cur.parent.left == cur) {///
			return cur.parent;
		}
		else{/// can combine
			while(cur.parent != null && cur.parent.right == cur){
				cur = cur.parent;
			}
			return cur.parent;
		}
	}
	private TreeNode findMostLeft(TreeNode par){
		while(par != null && par.left != null){
			par = par.left;
		}
		return par;
	}
}
