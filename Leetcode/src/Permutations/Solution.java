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
	
	// mine: ÿ��dfsѭ�� �������Ѿ�ѭ��������ֵ������ֵһ���������
	// web: ����������sort����remove��ֱ���ҵ���һ���������Ӳ��ظ�������
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
	 * 1. ��ӽ�res��ʱ�䣬����Ҫ�������������У�������Ҫ��tmp.size()�������г��ȵ�ʱ������res�������

	   2. ÿ�β��ܴ�pos��ʼ������β��ɨ�ˣ���Ϊ����Ҫ��Ĳ���Subset�����������У�����Ҫ�ӵ�һ�����ֿ�ʼ������β��ɨ��
	      ���������ˣ�������ô֪��ȡûȡ�����Ԫ���أ���ô���Ǿʹ���һ��boolean[] visit ÿ����ӵ�ʱ������Ӧλ����True��ɾȥ��ʱ����False
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
