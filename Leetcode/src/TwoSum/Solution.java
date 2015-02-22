package TwoSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
	// 1. brute force O(n^2)
	// 2. use hash table,  O(n) time, O(n) space
    public int[] twoSum2(int[] numbers, int target) {
        int[] ans = new int[2];
    	if(numbers == null || numbers.length == 0){
    		return ans;
    	}
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        map.put(numbers[0],0+1);
        for(int i = 1; i < numbers.length; i++){
        	int rem = target - numbers[i];
        	if(map.get(rem)!= null){
        		ans[0] = map.get(rem)+1;
        		ans[1] = i+1;
        	}
        	else{
        		map.put(numbers[i], i);
        	}
        }
        return ans;
    }
	// 3. Copy the numbers and sort first,  O(NlogN) time, O(n) space
    public int[] twoSum(int[] numbers, int target) {
        int[] ans = new int[2];
    	if(numbers == null || numbers.length == 0){
    		return ans;
    	}
        ArrayList<Integer> backup = new ArrayList<Integer>();
        for(int number: numbers) backup.add(number);
    	Arrays.sort(numbers);
    	// find 2 numbers
    	int s = 0; 
    	int e = numbers.length-1;
    	while(s!=e && numbers[s] + numbers[e] != target){
    		if(numbers[s] + numbers[e] < target){
    			s++;
    		}
    		else if(numbers[s] + numbers[e] > target){
    			e--;
    		}
    	}
    	if(numbers[s] + numbers[e] == target){
    		boolean findFirst = false;
    		for( int i = 0; i < backup.size(); i++){
    			if(backup.get(i) == numbers[s] || backup.get(i) == numbers[e]){
    				if(!findFirst){
    					ans[0] = i+1;
    					findFirst = true;
    				}
    				else ans[1] = i+1;
    			}
    		}
    	}
    	return ans;
    }
}
