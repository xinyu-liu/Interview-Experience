package ThreeSumClosest;

import java.util.Arrays;

public class Solution {
	// from 3Sum ( 2sumµÄO(NlogN), ÅÅÐò&head+tail- - compute n2 space 1 )
	public int threeSumClosest(int[] num, int target) {
		int closestDiff = Integer.MAX_VALUE;
		int closest = Integer.MAX_VALUE;
    	Arrays.sort(num);
    	for (int f = 0; f < num.length; f++){
        	int s = f + 1;
        	int t = num.length - 1;
    		while(s < t){
    			int sum = num[f] + num[s] + num[t];
    			if(Math.abs(target - sum) < closestDiff){
    				closestDiff = Math.abs(target - sum) ;
    				closest = sum;
    			}
    			
    			if(closestDiff == 0){
    				return target;
    			}
    			else if(sum < target){
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
    	return closest;
    }
}
