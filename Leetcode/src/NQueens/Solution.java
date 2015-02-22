package NQueens;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	// II
	private int ans; // 声明在totalNQueens外面
    public int totalNQueens(int n) {
    	ans = 0;
    	ArrayList<Integer> cur = new ArrayList<Integer>();
    	dfsII(cur, n);
    	return ans;
    }
    private void dfsII( ArrayList<Integer> cur, int n){
    	int index = cur.size();
    	if(index == n){
    		ans++;
    		return;
    	}
    	// general
    	
    	for(int i = 0; i < n; i++){
    		if(isValid(cur,i,index)){
    			cur.add(i);
    			dfsII(cur, n);
    			cur.remove(cur.size()-1);
    		}
    	} 
    }
	// I
    public List<String[]> solveNQueens(int n) {
    	List<String[]> ans = new ArrayList<String[]>();
    	ArrayList<Integer> cur = new ArrayList<Integer>();
    	dfs(ans, cur, n);
    	return ans;
    	
    }
    private void dfs(List<String[]> ans, ArrayList<Integer> cur, int n){
    	int index = cur.size();
    	if(index == n){
    		String[] sol= new String[n];
    		for(int i = 0; i < n; i++){
    			StringBuffer sb = new StringBuffer();
    			for(int j = 0; j < n; j++){
    				if(j == cur.get(i)){
    					sb.append("Q");
    				}
    				else sb.append(".");
    			}
    			sol[i] = sb.toString();
    		}
    		ans.add(sol);
    		return;
    	}
    	// general
    	
    	for(int i = 0; i < n; i++){
    		if(isValid(cur,i,index)){
    			cur.add(i);
    			dfs(ans, cur, n);
    			cur.remove(cur.size()-1);
    		}
    	}
    	
    }
    private boolean isValid(ArrayList<Integer> cur, int i, int row){
    	boolean b = true;
    	for(int c = 0; c < cur.size(); c++){
    		b = b && ( cur.get(c) != i && Math.abs(row-c) != Math.abs(i-cur.get(c)) );
    	}
    	return b;
    }
}
