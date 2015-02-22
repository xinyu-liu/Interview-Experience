package PascalsTriangle;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	// II
    public List<Integer> getRow(int rowIndex) { // use only O(k) extra space     
    	List<Integer> ans = new ArrayList<Integer>();
        if(rowIndex < 0){
        	return ans;
        }  
        for(int i = 0; i < rowIndex+1; i++){        	
        	ans.add(1);
        	if(i>1){
        		for(int j = i-1; j > 0 ; j--){
        			ans.set(j, (ans.get(j)+ans.get(j-1)) );
        		}
        	}
        	if(i>0){
        		ans.set(0, 1);
        	}
        }
        return ans;
    }
    
	// I
    public List<List<Integer>> generate(int numRows) {
    	List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if(numRows <= 0){
        	return ans;
        }  
        for(int i = 0; i < numRows; i++){
        	List<Integer> list = new ArrayList<Integer>();
        	list.add(1);
        	if(i>1){
        		List<Integer> list2 = ans.get(i-1);
        		for(int j = 0; j < list2.size()-1; j++){
        			list.add(list2.get(j)+list2.get(j+1));
        		}
        	}
        	if(i>0){
        		list.add(1);
        	}
        	ans.add(list);
        }
        return ans;
    }
}
