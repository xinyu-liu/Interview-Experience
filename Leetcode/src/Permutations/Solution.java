package Permutations;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

public class Solution {
	// II
	
	// mine: 每次dfs循环 存下来已经循环过的数值，若数值一样，则忽略
	// web: 在主函数里sort，在remove后直接找到下一个和这次添加不重复的数字
	//      while(i+1 < num.length && num[i] == num[i+1]) i++;
	
    public List<List<Integer>> permuteUnique(int[] num) {
    	List<List<Integer>> ans = new ArrayList<List<Integer>>();
    	List<Integer> list = new ArrayList<Integer>();
    	boolean[] visited = new boolean[num.length];
    	dfs(num, visited, list, ans);
    	return ans;
    }
	private void dfs(int[] num, boolean[] visited, List<Integer> list, List<List<Integer>> ans){
		if(list.size()==num.length){
			ans.add(new ArrayList<Integer>(list));
			return;///////////////////////////////
		}
		Set<Integer> set = new HashSet<Integer>();
		for(int i = 0; i < num.length; i++){
			if(!visited[i] && !set.contains(num[i])){
				set.add(num[i]);
				list.add(num[i]);
				visited[i] = true;
				dfs(num, visited, list, ans);
				list.remove(list.size()-1);
				visited[i] = false;
			}
		}
	}
	
	/* I
	 * 
	 * 1. 添加进res的时间，我们要生成完整的序列，所以需要当tmp.size()＝＝序列长度的时候再往res里面添加

	   2. 每次不能从pos开始往数组尾巴扫了，因为我们要求的不是Subset而是完整序列，所以要从第一个数字开始往数组尾巴扫，
	      问题又来了，我们怎么知道取没取过这个元素呢，那么我们就创建一个boolean[] visit 每此添加的时候给相对应位置置True，删去的时候置False
	 */
	public List<List<Integer>> permute(int[] num) {
    	List<List<Integer>> ans = new ArrayList<List<Integer>>();
    	List<Integer> list = new ArrayList<Integer>();
    	boolean[] visited = new boolean[num.length];
    	dfs(num, visited, list, ans);
    	return ans;
    }
	private void dfsI(int[] num, boolean[] visited, List<Integer> list, List<List<Integer>> ans){
		if(list.size()==num.length){
			ans.add(new ArrayList<Integer>(list));
			return;
		}
		for(int i = 0; i < num.length; i++){
			if(!visited[i]){
				list.add(num[i]);
				visited[i] = true;
				dfs(num, visited, list, ans);
				list.remove(list.size()-1);
				visited[i] = false;
			}
		}
	}
}
