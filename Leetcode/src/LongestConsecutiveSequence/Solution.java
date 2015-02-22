package LongestConsecutiveSequence;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int longestConsecutive(int[] num) {
    	if(num == null){
    		return 0;
    	}
    	int maxNum = 0;
        Set<Integer> set = new HashSet<Integer> ();
        for(int i = 0 ; i < num.length; i++){
        	set.add(num[i]);
        }
        for(int i = 0 ; i < num.length; i++){
        	int count = 1;
        	set.remove(num[i]);
        	
        	int j = 1;
        	while(  set.contains( num[i]+j )  ){
        		set.remove(num[i]+j);
        		count++;
        		j++;
        	}
        	j = 1;
        	while(  set.contains( num[i]-j )  ){
        		set.remove(num[i]-j);
        		count++;
        		j++;
        	}
        	if(count>maxNum){
        		maxNum = count;
        	}
        }
        return maxNum;
    }
}
