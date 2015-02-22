package Triangle;

import java.util.List;

public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
    	if(triangle== null || triangle.size() == 0 || triangle.get(0).size() == 0){
    		return 0;
    	}
    	int length = triangle.size();
        int[] arr = new int[length];
        arr[0] = triangle.get(0).get(0);
        for(int i = 1; i < length; i++){
        	List<Integer> list = triangle.get(i);
        	
        	arr[i] = list.get(i) + arr[i-1];
        	
        	for(int j = i-1; j > 0; j--){
        		arr[j] = list.get(j) + Math.min(arr[j], arr[j-1]); 
        	}
        	
        	arr[0] = list.get(0) + arr[0];
        }
        int min = arr[0]; 
        for(int i = 1; i < length; i++){
        	if(arr[i] < min){
        		min = arr[i];
        	}
        }
        return min;
    }
}
