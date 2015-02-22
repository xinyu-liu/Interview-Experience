package FourSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Solution {
	//4sum��hash�㷨��
	/*
	 * O(N^2)������pair����hash������ÿ��hashֵ������Ը�һ��list����map��
	 * map[hashvalue] = list��ÿ��list�е�Ԫ�ؾ���һ��pair, ���pair�ĺ;������
	 * hashֵ����ô��������4sum�ͱ���������е�pair value���� 2sum������ͳ��������㷨�ˣ�
	 * ע������������������pair����(N^2)�����ԣ���������������㷨��O(N^2)��������Ϊ��
	 * �ǹ���list, ����ֻҪ����4sum�����Ƕ������ҵ���Ӧ�������ĸ����֡�
	 */
	public List<List<Integer>> fourSum(int[] num, int target) {
		List<List<Integer>> ans = new ArrayList<List<Integer>> ();
		Map<Integer, ArrayList<ArrayList<Integer>>> map = new HashMap<Integer,ArrayList<ArrayList<Integer>>>();
		Arrays.sort(num);
		for(int i = 0; i < num.length-1; i++){
			for (int j = i+1; j < num.length; j++){
				ArrayList<Integer> pair = new ArrayList<Integer>();
				pair.add(num[i]);
				pair.add(num[j]);
				
				int sum = num[i]+num[j];
				ArrayList<ArrayList<Integer>> list = map.get(sum);
				if(list == null){
					list = new ArrayList<ArrayList<Integer>>();
					list.add(pair);
					map.put(sum, list);
				}
				else{
					list.add(pair);
				}
			}
		}
		for(Integer i:map.keySet()){
			ArrayList<ArrayList<Integer>> list1 = map.get(target - i);
			if(list1 != null){
				ArrayList<ArrayList<Integer>> list2 = map.get(i);
				
			}
		}
		////.....wrong??? 0011 0+2  - 1+1 the same result?
		
		
		
		return ans;
	}
	// same as 3sum
    public List<List<Integer>> fourSum1(int[] num, int target) {
    	List<List<Integer>> ans = new ArrayList<List<Integer>> ();
    	Arrays.sort(num);
    	for(int f = 0; f < num.length-3; f++){
    		for (int s = f+1; s < num.length-2; s++){
    			// 2sum
    			int t = s+1;
    			int l = num.length-1;
    			while(t < l){
    				int sum = num[f] + num[s] + num[t] + num[l];
    				if(sum == target){
    					List<Integer> list = new ArrayList<Integer>();
    					list.add(num[f]);
    					list.add(num[s]);
    					list.add(num[t]);
    					list.add(num[l]);
    					ans.add(list); 
    					while(t+1 < l && num[t]==num[t+1]) t++;
    					t++;
    					l--;
    				}
    				else if(sum > target) l--;
    				else t++;
    			}
    			while(s+1 < num.length-2 && num[s]==num[s+1]) s++;
    		}
    		while(f+1 < num.length-3 && num[f]==num[f+1]) f++;
    	}
    	return ans;
    }
}
