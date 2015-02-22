package LeastCommonAncestorForBinaryTree;

public class LeastCommonAncestorForBinaryTree {
	class Result{
		TreeNode ancestor;
		boolean isFindTwo;

		Result(TreeNode n, boolean is){
			ancestor = n;
			isFindTwo = is;
		}
	}
	public TreeNode findLCA(TreeNode root, TreeNode a, TreeNode b){
		Result r = find(root, a, b);
		if(r.isFindTwo) return r.ancestor;
		else return null;
	}
	public Result find(TreeNode root, TreeNode a, TreeNode b){
		if(root == null) return new Result(null, false);
		
		if(root == a && root == b){
			return new Result(root,true); 
		}
		
		Result r1 = find(root.left, a, b);
		if(r1.isFindTwo) return r1;
		Result r2 = find(root.right, a, b);
		if(r2.isFindTwo) return r2;
		
		if(r1.ancestor != null && r2.ancestor != null) {
			return new Result(root, true);
		}
		
		if(root == a){		
			Result r = new Result(root, (r1.ancestor == b || r2.ancestor == b));
			return r;  			
		}
		if(root == b){			
			Result r = new Result(root, (r1.ancestor == a || r2.ancestor == a) );
			return r;  	
		}		
	
		if(r1.ancestor != null) return r1;
		if(r2.ancestor != null) return r2;
		return new Result(null, false);
		
	}

}
