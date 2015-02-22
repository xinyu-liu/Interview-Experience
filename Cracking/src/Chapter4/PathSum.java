package Chapter4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PathSum {
	public List<List<TreeNode>> findPath(TreeNode root, int target){
		List<List<TreeNode>> ans = new ArrayList<List<TreeNode>>();
		dfs(root, target, new LinkedList<TreeNode>(), ans);
		return ans;
	}
	// save List<Integer> sums -> get each sum = O(n); not save, also O(n)
	private void dfs(TreeNode root, int target, List<TreeNode> path, List<List<TreeNode>> ans){
		if(root == null){
			return;
		}
		
		path.add(root); // add
		
		// check cur sums
		int sum = 0;
		for(int i = path.size()-1; i >= 0; i++){
			sum += path.get(i).val;
			if(sum == target){
				addToAns(path, i, ans);
			}
		}
		
		dfs(root.left, target, path, ans);
		dfs(root.right, target, path, ans);
		
		path.remove(path.size()-1); // delete
	}
	private void addToAns(List<TreeNode> path, int start, List<List<TreeNode>> ans){
		List<TreeNode> list = new ArrayList<TreeNode>();
		for(int i = start; i < path.size(); i++){
			list.add(path.get(i));
		}
		ans.add(list);
	}
}
