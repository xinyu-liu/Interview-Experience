package DP35_LongestArithmeticProgression;

import java.util.Arrays;

/*
 * Given a set of numbers, find the Length of the Longest Arithmetic Progression (LLAP) in it.

Examples:
set[] = {1, 7, 10, 15, 27, 29}
	 1   0          
	 7
	10
	15
	27
	29
output = 3
The longest arithmetic progression is {1, 15, 29}

set[] = {5, 10, 15, 20, 25, 30}
             
output = 6
The whole set is in AP
Add a pre-processing step to first sort the set and then apply the below algorithms.

O(n2) time using Dynamic Programming.
To get idea of the DP solution, let us first discuss solution of following simpler problem.

 */
public class LongestArithmeticProgression {
	/*
	 * Given a sorted set, find if there exist three elements in Arithmetic Progression or not - true if there are 3 or more elements in AP
	 * 
To find the three elements, we first fix an element as middle element and search for other two (one smaller and one greater). 
We start from the second element and fix every element as middle element. 
For an element set[j] to be middle of AP, there must exist elements ¡®set[i]¡¯ and ¡®set[k]¡¯ such that set[i] + set[k] = 2*set[j] 
where 0 <= i < j and j < k <=n-1.
How to efficiently find i and k for a given j? We can find i and k in linear time using following simple algorithm.
1) Initialize i as j-1 and k as j+1
2) Do following while i >= 0 and j <= n-1
..........a) If set[i] + set[k] is equal to 2*set[j], then we are done.
¡­¡­..b) If set[i] + set[k] > 2*set[j], then decrement i (do i--).
¡­¡­..c) Else if set[i] + set[k] < 2*set[j], then increment k (do k++).

	 */
	// a simpler problem
	public boolean hasAP(int[] arr){
		Arrays.sort(arr);
		for(int j = 1; j < arr.length-1; j++){
			int i = j-1;
			int k = j+1;
			int target = 2*arr[j];
			while(i >= 0 && k < arr.length){
				if(arr[i] + arr[k] == target) return true;
				else if(arr[i] + arr[k] < target) k++;
				else i--;
			}
		}
		return false;
	}
	/*
	 * How to extend the above solution for the original problem?
	 * 
The required output of original problem is Length of the Longest Arithmetic Progression (LLAP) which is an integer value. 
If the given set has two or more elements, then the value of LLAP is at least 2 (Why?).

The idea is to create a 2D table L[n][n]. 
An entry L[i][j] in this table stores LLAP with set[i] and set[j] as first two elements of AP and j > i. 
The last column of the table is always 2 (Why - see the meaning of L[i][j]). 
Rest of the table is filled from bottom right to top left. To fill rest of the table, 
j (second element in AP) is first fixed. i and k are searched for a fixed j. 
If i and k are found such that i, j, k form an AP, then the value of L[i][j] is set as L[j][k] + 1. 
Note that the value of L[j][k] must have been filled before as the loop traverses from right 
to left columns.
	 */
	public int lengthOfLAP(int[] arr) {
		int n = arr.length;
		int[][] dp = new int[n][n]; // i < j
		for(int i = 0; i < n; i++){
			dp[i][n-1] = 2;
			dp[i][i] = 1;
		}
		for(int j = n-2; j > 0; j--){
			int i = j-1;
			int k = j+1;
			
			while(i >= 0 && k < n){
				if(arr[i] + arr[k] == 2* arr[j]){
					dp[i][j] = dp[j][k] + 1;
					i--;
					k++;
				}
				else if(arr[i] + arr[k] < 2* arr[j]){
					k++;
				}
				else i--;
			}
		}
		int max = 0;
		for(int i = 0; i < n; i++){
			max = Math.max(max, dp[0][i]);
		}
		return max;
		
		
/*
 *    {1, 7, 10, 15, 27, 29}
 *  1  1		  3		  2		
 *  7	  1				  2
 * 10		  1	      	  2
 * 15  			  1	  0	  2
 * 27				  1   2
 * 29 				      1
 * 		
 *    {5, 10, 15, 20, 25, 30}
 *  5  1				  2		
 * 10	  1				  2
 * 15		  1			  2
 * 20  			  1	  	  2
 * 25				   1  2
 * 30 					  1
 * 		
 */
	}
	public static void main(String[] args) {
		LongestArithmeticProgression sol = new LongestArithmeticProgression();
		int[] arr = {1, 7, 10, 15, 27, 29};
		System.out.println( sol.hasAP(arr) );
		System.out.println( sol.lengthOfLAP(arr) );
		// output = 3
		int[] arr2 = {5, 10, 15, 20, 25, 30};
		System.out.println( sol.lengthOfLAP(arr2) );
		// output = 6
		
	}

}
