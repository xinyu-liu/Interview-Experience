package CombinationSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
	// II
	// 1. ÿ������ֻ������1�Σ������ٵ���dfs��ʱ�򣬴����pos��Ӧ����i + 1
	// 2. ����ͬ����˼·����ֹ���ظ���Set
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
	
	/* 0. ������ں�ΪTarget,��ʱȡһ��Ӳ�ң�������ֵΪv1����ô��һ�Σ�������ʵ���������ͬ�������⣬
	 *    ֻ�����ͱ����Target - v1������ǵ��͵ĵݹ顣
	 * 1. �ɺϲ�target��curSumΪһ�������� target-cand[i]
	 * 2.�������start�������鿪ͷ������β��ɨ�������ʲô���⣿ 
	 *   ������ظ����ϵ����⣬������ظ�����ָ˳����ȫ��ͬ��Set�����Ƕ���ÿһ����ϣ�
	 *   �������һ�ξͿ����� ����Sum = 3 ����start����� [1,2],[2,1]����һ���Ľ⣬���Ǽ���һ��start��
	 *   ����ÿ�����ֻ������Ӻ����������Ȼ��߱�������ִ�����֣�����֮ǰsort���������У������ͻ��������
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
