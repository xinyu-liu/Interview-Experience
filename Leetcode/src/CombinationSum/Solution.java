package CombinationSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
	// II
	// 1. 每个数字只能运用1次，所以再调用dfs的时候，传入的pos，应该是i + 1
	// 2. 利用同样的思路来防止有重复的Set
	public List<List<Integer>> combinationSum2(int[] num, int target) {
	   	List<List<Integer>> ans = new ArrayList<List<Integer>>();
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	Arrays.sort( num );
    	dfs(num, target, 0, list, ans);
    	return ans;    	
    }
    private void dfs(int[] candidates, int target, int start, ArrayList<Integer> list, List<List<Integer>> ans){
		if(target == 0){
			ans.add(new ArrayList<Integer>(list));
			return;
		}
    	for(int i = start; i < candidates.length; i++){
    		if( candidates[i] <= target){
    			list.add(candidates[i]);
    	    	dfs(candidates, target - candidates[i], i+1, list, ans);
    	    	list.remove(list.size()-1);
    		}
    		while(i+1 < candidates.length && candidates[i] == candidates[i+1]){
    			i++;
    		}
    	}
    }
	// I
	
	/* 0. 如果现在和为Target,此时取一个硬币，假设其值为v1，那么下一次，我们其实解决的是相同的子问题，
	 *    只不过和变成了Target - v1，因此是典型的递归。
	 * 1. 可合并target和curSum为一个参数， target-cand[i]
	 * 2.如果不用start，从数组开头往数组尾巴扫，会出现什么问题？ 
	 *   会出现重复集合的问题，这里的重复不是指顺序完全相同的Set，而是对于每一种组合，
	 *   我们输出一次就可以了 比如Sum = 3 不加start会出现 [1,2],[2,1]两种一样的解，我们加入一个start，
	 *   限制每次添加只能再添加和这个数字相等或者比这个数字大的数字（数组之前sort过升序排列）这样就会避免问题
	 */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
    	List<List<Integer>> ans = new ArrayList<List<Integer>>();
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	Arrays.sort( candidates );
    	dfsI(candidates, target, 0, 0, list, ans);
    	return ans;
        	
    }
    private void dfsI(int[] candidates, int target, int start,int curSum, ArrayList<Integer> list, List<List<Integer>> ans){
		if(curSum == target){
			ans.add(new ArrayList<Integer>(list));
			return;
		}
    	for(int i = start; i < candidates.length; i++){
    		if(curSum + candidates[i] <= target){
    			list.add(candidates[i]);
    	    	dfsI(candidates, target, i, curSum + candidates[i], list, ans);
    	    	list.remove(list.size()-1);
    		}
    	}
    }
}
