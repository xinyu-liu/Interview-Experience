package GenerateParentheses;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	// 如果左括号数还没有用完，那么我们能继续放置左括号 combine n & totalL
    public List<String> generateParenthesis(int n) {
    	List<String> ans = new ArrayList<String>();
    	String s = new String();
    	dfs(ans,s,0,0,n);
    	return ans;
    }
    private void dfs (List<String> ans, String cur, int numL,int totalL,int n){
    	if(cur.length() == 2*n){
    		if(numL == 0){
    			ans.add(cur);
    		}
    		return;
    	}
    	if(totalL < n){
    		String newS = cur +"(";
    		dfs(ans,newS,numL+1,totalL+1,n);
    	}
    	if(numL > 0){
    		String newS = cur +")";
    		dfs(ans,newS,numL-1,totalL,n);
    	}
    }
}
