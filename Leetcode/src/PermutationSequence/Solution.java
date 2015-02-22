package PermutationSequence;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Solution {
	// 2.1 数学，找规律
	// best one : http://blog.csdn.net/fightforyourdream/article/details/17483553
	public String getPermutation(int n, int k) {
		String ans = new String();
		Set<Integer> visited = new HashSet<Integer>();
		
		int numberOfPermNextLevel = 1;
		for(int cur =2; cur <= n; cur++){
			numberOfPermNextLevel *= cur;
		}
		k--; // 对k减一，因为现在index是从[0,n-1]而不是[1,n] 
		
		for(int cur = n; cur > 0; cur--){
			numberOfPermNextLevel = numberOfPermNextLevel / cur;
			
			int dth = k / numberOfPermNextLevel;
			int count = 0;
			int d = 0;
			while(count <= dth){
				d++;
				if(!visited.contains(d)){
					count++;
				}
			}
			ans += (char)(d + '0');
			visited.add(d);
			k = k % numberOfPermNextLevel;

		}
		return ans;
	}
	// refer to : http://blog.csdn.net/pickless/article/details/9938997
	public String getPermutation1(int n, int k) {
		String ans = new String();
		Set<Integer> visited = new HashSet<Integer>();
		int numberOfPermNextLevel = 1;
		for(int cur = n-1; cur > 0; cur--){
			numberOfPermNextLevel *= cur;
		}
		for(int cur = n; cur > 0; cur--){
			int d = n;
			int temp = 0;
			for(; d > 0; d--){
				if(!visited.contains(d)){
					// count how many before d
					int count = 0;
					for(int i = 1; i < d; i++){
						if(!visited.contains(i)){
							count ++;
						}
					}
					temp = count * numberOfPermNextLevel + 1;
					if( temp  <= k ){
						break;
					}
				}
			}
			ans += (char)(d + '0');
			visited.add(d);
			k = k - temp + 1;
			if(cur > 1){
				numberOfPermNextLevel /= (cur-1);
			}
			
		}
		return ans;
	}
	// 1.1 DFS解法。
	// 1.2 时间复杂度O(n^n),会TLS
    public String getPermutationWRONG(int n, int k) {
    	Set<Integer> visited = new HashSet<Integer>();
    	ArrayList<String> ans = new ArrayList<String>();
    	dfs(visited,new String(), ans, n, k);
    	return ans.get(k-1);
    }
    private boolean dfs(Set<Integer> visited, String cur,ArrayList<String> ans,
    				 int n, int k) {
    	if(cur.length() == n){
    		ans.add(cur);
    		if(ans.size() == k){
    			return true;
    		}
    		return false;
    	}
    	for(int i = 1; i <= n; i++ ){
    		if(!visited.contains(i)){
    			visited.add(i);
    			if(dfs(visited, cur+i,ans,n,k)) return true;
    			visited.remove(i);
    		}
    	}
    	return false;
    }
}
