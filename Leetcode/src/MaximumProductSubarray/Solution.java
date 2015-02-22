package MaximumProductSubarray;

public class Solution {
    public static int maxProduct(int[] A) {// [0,2]
        int[] max = new int[A.length];
        int[] min = new int[A.length];
        max[0] = A[0];
        min[0] = A[0];
        for (int i = 1; i < A.length ; i++){
        	if(A[i] == 0){
        		max[i] = A[i];
    			min[i] = A[i];
        	}
        	else if(A[i]>0){
        		if(max[i-1] > 0){
        			max[i] = A[i] * max[i-1];
        		}
        		else{
        			max[i] = A[i];
        		}
        		if(min[i-1] <= 0){
        			min[i] = A[i] * min[i-1];
        		}
        		else{
        			min[i] = A[i];
        		}
        	}
        	else{
        		if(max[i-1] > 0){
        			min[i] = A[i] * max[i-1];
        		}
        		else{
        			min[i] = A[i];
        		}
        		if(min[i-1] <= 0){
        			max[i] = A[i] * min[i-1];
        		}
        		else{
        			max[i] = A[i];
        		}
        	}
        }
        int ans = max[0];
        for (int i = 1; i<max.length; i++){
        	if(ans < max[i]){
        		ans = max[i];
        	}
        }
        return ans;
    }
    public static void main(String[] args ){
    	int[] A = {-4,-3,-2};
    	int ans = maxProduct( A);
    	System.out.println(ans);
    }
}