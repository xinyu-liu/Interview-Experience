package SortColors;

public class Solution {
	// sol 3: ∆Ω“∆≤Â»Î
    public void sortColors(int[] A) {
    	int p0 = 0;
    	int p1 = 0;
    	int p2 = 0;
    	int i = 0;
    	while (i < A.length && p2 < A.length){   		
    		if(A[i] == 0){
    			// ◊¢“‚À≥–Úfor p2 p1 p0 ==0
    			A[p2++] = 2;
    			A[p1++] = 1;
    			A[p0++] = 0;
    		}
    		else if(A[i] == 1){
    			A[p2++] = 2;
    			A[p1++] = 1;
    		}
    		else if(A[i] == 2){
    			A[p2++] = 2;
    		}
    		i++;
    	}
    }
	// sol 1: count number of 0,1,2 - two pass!
	// sol 2: swap & two pivot
    public void sortColors2(int[] A) {
    	if(A == null || A.length < 2){
    		return;
    	}
        int p1 = 0; // first 1 or next 0
        int p2 = A.length-1; // next 2
        int i = 0;
    	while ( i <= p2 ){
    		if(A[i] == 0){
    			swap(A, i, p1);
    			i++;
    			p1++;
    		}
    		else if(A[i] == 1){
    			i++;
    		}
    		else if(A[i] == 2){
    			swap( A, i, p2);
    			p2--;
    		}
    	}
    }
    private void swap(int[] A, int i, int j){
    	int temp = A[i];
    	A[i] = A[j];
    	A[j] = temp;
    }
}
