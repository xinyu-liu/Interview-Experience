package Chapter4;

public class CommonAncestor {
	/*
	 * All of these methods are valid alone only if p & q must in the tree 
	 * 2 solutions:
	 * 1. return both TreeNode and a flag indicating that return p means finding 2 nodes
	 * 2. finding 2 nodes all exist in tree first
	 */
	class Result{
		TreeNode node;
		boolean isAncestor;
		Result(TreeNode n, boolean is){
			node = n;
			isAncestor = is;
		}
	}
	/////////////// if this is a normal tree - solution version - no need covers method
	public TreeNode commonAncestor(TreeNode root, TreeNode p, TreeNode q){
		if(p == q) return p;
		Result r = dfs(root, p, q);
		if(r.isAncestor) return r.node;
		return null;
	}
	private Result dfs(TreeNode root, TreeNode p, TreeNode q){
		if(root == null) return new Result(null, false);
		
		// deal with subtree first
		Result a1 = dfs(root.left, p, q);
		if(a1.isAncestor) return a1; // already found 
		Result a2 = dfs(root.right, p, q);
		if(a2.isAncestor) return a2; // already found 
		
		if(a1.node != null && a2.node != null){
			return new Result( root, true);
		}
		else if(root == p || root == q){ 
				// deal with root later
				// if root is p or q,
				// and found one in subtree,     // - need to check node == null ! 
				// found two, return with true
			boolean is = (a1.node != null || a2.node != null);
			return new Result( root, is);
		}
		else{
			return a1.node != null ? a1: a2;
		}
	}
	
	
	/////////////// if this is a normal tree - my version 
	public TreeNode commonAncestorM(TreeNode root, TreeNode p, TreeNode q){
		if(p == q) return p;
		Result r = dfsM(root, p, q);
		if(r.isAncestor) return r.node;
		return null;
	}
	private Result dfsM(TreeNode root, TreeNode p, TreeNode q){
		if(root == null) return new Result(null, false);
		if(root == p){
			return new Result( p, covers(p, q) );
		}
		if(root == q){
			return new Result( q, covers(q, p) );
		}
		Result a1 = dfsM(root.left, p, q);
		Result a2 = dfsM(root.right, p, q);
		if(a1 == null) return a2;
		if(a2 == null) return a1;
		else //if(a1 == p && a2 == q) 
			return new Result(root, true);	
	}
	private boolean covers(TreeNode r, TreeNode c){
		if (r == null) return false;
		if (r == c) return true;
		return covers(r.left, c) || covers(r.right, c);
	}
	
	
	///////////// if this is a binary search tree - only valid 
	public TreeNode commonAncestorBST_iter(TreeNode root, TreeNode p, TreeNode q){
		// - only valid if p & q must in the tree 
		TreeNode r = root;
		while(r != null){
			if(p.val < r.val && q.val < r.val){
				r = r.left;
			}
			if(p.val > r.val && q.val > r.val){
				r = r.right;
			}
			else return r;
		}
		return null;
	}
	
	public TreeNode commonAncestorBST_rec(TreeNode root, TreeNode p, TreeNode q){
		// - only valid if p & q must in the tree 
		if(root == null) return null;
		if(p.val < root.val && q.val < root.val){
			return commonAncestorBST_rec(root.left,p,q);	
		}
		if(p.val > root.val && q.val > root.val){
			return commonAncestorBST_rec(root.right,p,q);
		}
		return root;		
		// if(root.val == p.val || root.val == q.val) 
		// if(root.val < p.val && root.val > q.val)
		// if(root.val < q.val && root.val > p.val)
		
	}
}
