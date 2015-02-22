package RemoveDuplicatesFromSortedArray;

public class Solution {
	// II
	public int removeDuplicates(int[] A) {
        int len = A.length; // can return cur+1, no need len
        if(len < 3){
        	return len;
        }
        
        int cur = 0;
        int i = 2;
        while( i < A.length ){
        	if(A[cur] != A[i]){
        		cur++;
        		i++;
        	}
        	else{
        		while(i < A.length && A[cur]==A[i]){
        			i++;
        		}
        		if(i+1 < A.length){
	        		cur += 2;
	        		A[cur] = A[i];
	        		if(i+1 < A.length){
	        			A[cur+1] = A[++i];
	        		}
        		}
        		i++;       	
        	}
        }
        return cur+1;
    }
    // I
    public int removeDuplicatesI(int[] A) {
        int len = A.length; // can return cur+1, no need len
        int cur = 0;
        for(int i = 1; i < A.length; i++){
        	if(A[cur] == A[i]){
        		len--;
        	}
        	else{
        		A[cur++] = A[i];
        	}
        }
        return len;
    }
}
