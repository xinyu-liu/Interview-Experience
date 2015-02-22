package ThreeSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
	// 2sum的O(NlogN), 排序&head+tail- - compute n2 space 1 
	public List<List<Integer>> threeSum(int[] num) {
    	List<List<Integer>> ans = new ArrayList<List<Integer>>();
    	Arrays.sort(num);
    	for (int f = 0; f < num.length; f++){
        	int s = f + 1;
        	int t = num.length - 1;
    		int toSum = 0 - num[f];	
    		while(s < t){
    			if(num[s] + num[t] == toSum){
    				List<Integer> list = new ArrayList<Integer>();
    				list.add(0 - toSum);
    				list.add(num[s]);
    				list.add(num[t]);
    				ans.add(list);
    				while(s+1 < num.length && num[s] == num[s+1]){
    					s++;
    				}
    				while(t-1 > -1 && num[t] == num[t-1]){
    					t--;
    				}
    				s++;
    				t--;
    			}
    			else if(num[s] + num[t] < toSum){
    				s++;
    			}
    			else{
    				t--;
    			}
    		}
    		while(f+1 < num.length && num[f] == num[f+1]){
    			f++;
    		}
    	}
    	return ans;
    }
	
	// 2sum线性解法的upgrade - compute n2 space n
    public List<List<Integer>> threeSum1(int[] num) {
    	List<List<Integer>> ans = new ArrayList<List<Integer>>();
    	Arrays.sort(num);    	
    	for (int i = 0; i < num.length; i++){
    		int toSum = 0 - num[i];
    		
    		Set<Integer> set = new HashSet<Integer>();
    		Set<Integer> added = new HashSet<Integer>();
    		
    		for(int j = i+1; j < num.length; j++){
    			int temp = toSum- num[j];
    			if(!added.contains(temp)){
	    			if(set.contains(temp)){
	    				List<Integer> list = new ArrayList<Integer>();
	    				list.add(0 - toSum);
	    				list.add(temp);
	    				list.add(num[j]);
	    				ans.add(list);
	    				
	    				set.remove(temp);
	    				
	    				added.add(temp);
	    				added.add(num[j]);
	    			}
	    			else{
	    				set.add(num[j]);
	    			}
    			}
    		}
    		while(i+1 < num.length && num[i] == num[i+1]){
    			i++;
    		}
    	}

        return ans;
    }
}