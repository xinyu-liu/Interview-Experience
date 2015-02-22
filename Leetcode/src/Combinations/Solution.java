package Combinations;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	////////START!!!!
    public List<List<Integer>> combine(int n, int k) {
    	 List<List<Integer>> ans = new ArrayList<List<Integer>>();
    	 List<Integer> list = new ArrayList<Integer>();
    	 dfs(n,k,1,list,ans);
    	 return ans;
    }
    private void dfs(int n, int k, int start, List<Integer> list, List<List<Integer>> ans){
    	for(int i = start; i <= n-k+1; i++){    		
    		list.add(i);
    		if(k == 1){		
    			ans.add(new ArrayList<Integer>(list));   				
    		}
    		else{
    			dfs(n,k-1,i+1,list,ans);
    		}
    		list.remove(list.size()-1);
    	}
    }
    // similar web dfs!
    private void dfsW(int n, int k, int start, ArrayList<Integer> item, ArrayList<ArrayList<Integer>> res){
        if(item.size()==k){
            res.add(new ArrayList<Integer>(item));//because item is ArrayList<T> so it will not disappear from stack to stack
            return;
        }
        for(int i=start;i<=n;i++){
            item.add(i);
            dfsW(n,k,i+1,item,res);
            item.remove(item.size()-1);
        }
    }
}
