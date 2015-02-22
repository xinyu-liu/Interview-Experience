package GrayCode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> grayCode(int n) {
    	List<Integer> ans = new ArrayList<Integer>();    	
    	ans.add(0);
    	if(n == 0){
    		return ans;
    	}
    	// n == 1
    	ans.add(1);
    	dfs(n,2, ans);
    	return ans;
    }
    private void dfs(int n, int cur, List<Integer>ans ){
    	if(cur <= n){
	    	int size =  ans.size();
	    	for(int i = size - 1; i >= 0; i--){
	    		ans.add(ans.get(i) + size);
	    	}
	    	dfs(n,cur+1,ans);
    	}
    }
}
