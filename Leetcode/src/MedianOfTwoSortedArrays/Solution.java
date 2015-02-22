package MedianOfTwoSortedArrays;

public class Solution {
	// method 2 hard to write, directly go to method 1!!!!!!!!	
	
	// below is web code ...
	// http://blog.csdn.net/fightforyourdream/article/details/17351395
	
    // method 2: find the medians i of one array, the other j = k - i 
	public double findMedianSortedArrays(int A[], int B[]) {
        int len = A.length + B.length;
        if(len%2 == 1){
        	return findKth( (len+1)/2, A, 0, A.length, B);
        }
        else{
        	double d1 = findKth(len/2, A, 0, A.length, B); 
        	double d2 = findKth(len/2+1, A, 0, A.length, B);
	       
        	return (d1+d2) / 2.0 ;
        }
    }
 
    // NOTE: ENDA ENDB NOT INCLUDED!!!
    private int findKth(int k, int A[], int startA, int endA, int B[]){
    	// kth in A
    	// If A[i] is the k-th smallest element of the total (m + n) elements 
    	// (A[i] >= k-1 elements in A+B and <= all other elements in A+B), 
    	// it must be greater than or equal to (k - 1 - i)elements in B 
    	// and less than or equal to all the remaining elements in B 
    	// (A[i] >= B[k - 1 - i - 1]  && A[i] <= B[k - 1 - i]). 
    	
    	int lenA = endA - startA; 
    	if(lenA <= 0) return findKth( (A.length+B.length +1)/2, B, 0, B.length, A);
     	int midA = (startA + endA) / 2; // i
    	
    	int big = k - (midA+1);
    	int small = big - 1;
    	
    	if(big < 0)  endA = midA;
    	
    	else if(big >= B.length) {
    		startA = midA + 1;
    		k = k - lenA / 2 -1;
    	}
    	else{ // if(big >=0 && big < B.length)
	    	if(A[midA] <= B[big] && A[midA]>=B[small]){
	    		return A[midA];
	    	}
	    	else if(A[midA] > B[big]){
	    		// A[i] is greater than more than k elements in both A and B. 
	    		// The k-th smallest element must be in the lower part of A (A[0..i-1]); 
	    		endA = midA;
	    	}
	    	else{   // the k-th smallest element must be in the higher part of A (A[i+1..m-1]).
	    		startA = midA + 1;
	    		k = k - lenA / 2 -1;
	    	}
    	}
    	return findKth(k, A, startA, endA, B);
    }
    // method 1: find the medians of each of the two array each time
    public double findMedianSortedArrays1(int A[], int B[]) {
        int len = A.length + B.length;
        if(len%2 == 1){
        	return findKth( (len+1)/2, A, 0, A.length, B, 0, B.length);
        }
        else{
        	double d1 = findKth(len/2, A, 0, A.length, B, 0, B.length); 
        	double d2 = findKth(len/2+1, A, 0, A.length, B, 0, B.length);
	       
        	return (d1+d2) / 2.0 ;
        }
    }
    // NOTE: ENDA ENDB NOT INCLUDED!!!
    private int findKth(int k, int A[], int startA, int endA, 
    						   int B[], int startB, int endB){
    	int lenA = endA - startA; 
    	int lenB = endB - startB; 
    	if(lenA <= 0) return B[startB + k - 1];
    	if(lenB <= 0) return A[startA + k - 1];
    	if(k == 1) return Math.min( A[startA],B[startB]); //// 
    	int midA = (startA + endA) / 2;
    	int midB = (startB + endB) / 2;
    	
    	int j = lenA/2 + lenB/2 + 1;
    	
    	if(A[midA] <= B[midB]){	
    		if(j < k)  {            /////////////j<=k CANNOT
    			startA = midA + 1;
    			k = k - lenA/2 -1;  ///////
    		}
    		else 		endB = midB;
    	}
    	else{
    		if(j < k)  {
    			startB = midB + 1;
    			k = k - lenB/2 -1;  ///////
    		}
    		else 		endA = midA;
    	}
    	
    	return findKth(k, A, startA, endA, B, startB, endB);
    	
    }
}
