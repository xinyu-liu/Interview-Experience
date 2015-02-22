package Chapter4;

public class IsSubtree {
	public boolean isSubtree(TreeNode t1, TreeNode t2){
		if(t2 == null) return true;
		if(t1 == null) return false;
		
		if(t1.val == t2.val){
			if(isTreeMatch(t1,t2)) return true;
		}
		return isSubtree(t1.left, t2) || isSubtree(t1.right, t2);
	}
	private boolean isTreeMatch(TreeNode t1, TreeNode t2){
		if(t2 == null && t1 == null) return true;
		if(t2 == null || t1 == null) return false;
		return t2.val == t1.val 
				&& isTreeMatch(t1.left, t2.left) 
				&& isTreeMatch(t1.right, t2.right);
	}
}
