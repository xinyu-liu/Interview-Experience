package FindMinimumInRotatedSortedArray;

public class Solution {
	// II
	// ans from : http://blog.csdn.net/ljiabin/article/details/40983299	
    public int findMinIIW(int[] num) {
        int L = 0;
        int R = num.length - 1;
        while(L < R && num[L] >= num[R]){
        	int M = (L + R) / 2;
            if (num[M] > num[R]) {
                L = M + 1;
            } 
            else if (num[M] < num[L]){
                R = M; // be careful, not mid-1
            }
            else {   // A[L] == A[M] == A[R]  
                L = L + 1; 
            }
        }
        return num[L];
    }
	// I
    // web ans
    public int findMinIW(int[] num) {
        int L = 0, R = num.length-1;
        while (num[L] > num[R]) {
            int M = (L + R) / 2;
            if (num[M] > num[R]) {
                L = M + 1;
            } else {
                R = M; // be careful, not mid-1
            }
        }
        return num[L];
    }
    // mine - no good
    public int findMinI(int[] num) {
        if (num == null){
        	return -1;
        }
        int start = 0;
        int end = num.length-1;
        // special case
        if(num[0] < num[end]){
        	return num[0];
        }
        // general
	    while(start <= end){  
	    	if(start == end){
	    		return num[start];
	    	}
	    	if(end - start == 1){
	    		return Math.min(num[start], num[end]);
	    	}
	    	
	    	int mid = (start + end) / 2;
	    	if(num[start] > num[mid]){
	    		end = mid;
	    	}
	    	else{
	    		start = mid;
	    	}
	    }
	    return num[start];
    }
	    		

     
}
