package DP3_LongestIncreasingSubsequence;

import java.util.Arrays;

public class LengthOfLIS {
	// O(n^2) 
	public int lis(int[] arr){
		int n = arr.length;
		if(arr == null || n == 0) return 0;
		int[] dp = new int[n];
		Arrays.fill(dp, 1); //////////////MUST
		
		/* Compute optimized LIS values in bottom up manner */
		for(int i = 1; i < n; i++){
			int max = 1;//////////////MUST
			for(int j = 0; j < i; j++){
				if(arr[j] < arr[i] && max < dp[j] + 1){
					max = dp[j] + 1;
				}
			}
			dp[i] = max;
		}
		/* Pick maximum of all LIS values */
		int ans = dp[0];
		for(int i = 1; i < n; i++){
			ans = Math.max( ans, dp[i] );
		}
		return ans;
	}
	public static void main(String[] args) {
		int[] arr = {6, 3, 2, 4, 1, 6, 3, 2, 5, 0 } ;
		LengthOfLIS sol = new LengthOfLIS();
		System.out.println( sol.lis(arr) );
	}

}
