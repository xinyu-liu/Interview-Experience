package DP9_BinomialCoefficient;

import java.util.Arrays;

public class BinomialCoefficient {
/*
 * recursive method 
 * C(n, k) = C(n-1, k-1) + C(n-1, k)
 * C(n, 0) = C(n, n) = 1
 * 
 */
	public int recNaive(int n, int k){ // O(2^(n+k))
		if(n == k || k == 0) return 1;
		return recNaive(n-1, k-1) + recNaive(n-1, k);
	}
	
	
	public int dpTD(int n, int k){ // O(n*k)
		int[][] dp = new int[n+1][k+1];
		for(int[] row: dp){
			Arrays.fill(row, -1);
		}
		return recTD(n, k, dp);
			
	}
	public int recTD(int n, int k, int[][] dp){ 
		if(dp[n][k] != -1) return dp[n][k];
		int ans = 0;
		if(n == k || k == 0) ans = 1;
		else ans = recTD(n-1, k-1, dp) + recTD(n-1, k, dp);
		return ans;
	}
	
	
	public int dpBU(int n, int k){ // O(n*k)		
		int[][] dp = new int[n+1][k+1];

		for(int i = 0; i <= n; i++){
			for(int j = 0; j <= Math.min(i, k); j++){///// note the stop condition!!!!
				if(j == 0 || j == i) dp[i][j] = 1;//////// base case inside !!!!
				else dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
			}
		}
		return dp[n][k];
	}
	public int dpBU_space(int n, int k){ // O(n*k)		
		int[] dp = new int[k+1];
		dp[0] = 1;
		for(int i = 1; i <= n; i++){
			for(int j = Math.min(i, k); j > 0; j--){
				if(j == i) dp[j] = 1;
				else dp[j] = dp[j-1] + dp[j];
			}
		}
		return dp[k];
	}	
	public static void main (String[] args) throws java.lang.Exception
	{
		BinomialCoefficient sol = new BinomialCoefficient();
		int i = sol.dpBU_space(5,2);
		System.out.println(i);
		
	}
}
