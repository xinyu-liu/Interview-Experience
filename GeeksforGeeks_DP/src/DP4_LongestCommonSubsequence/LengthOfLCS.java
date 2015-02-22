package DP4_LongestCommonSubsequence;

import java.util.Arrays;

public class LengthOfLCS {
	// naive: A string of length n has 2^n different possible subsequences. 
	// check each subsequences of s1 exist in s2 or not. (m+n)*2^n
	
	// A Naive recursive implementation   
	// O(2^n) in worst case: when all characters of X and Y mismatch i.e., length of LCS is 0.
	public int lcs_Naive(String s1, String s2){
		if(s1 == null || s2 == null) return 0;
		int m = s1.length();
		int n = s2.length();
		if( m == 0 || n == 0 ) return 0;
		return dfs_N(s1, m-1, s2, n-1);
	}
	private int dfs_N(String s1,int i, String s2, int j){
		if (i == 0 || j == 0)   return 0;
		else if( s1.charAt(i) == s2.charAt(j) ) {
			return dfs_N(s1, i-1, s2, j-1) + 1;
		}
		else{
			return Math.max(dfs_N(s1, i, s2, j-1), dfs_N(s1, i-1, s2, j));
		}
	}
	
	// bottom-up   O(mn)
	public int lcs_Tabulation(String s1, String s2){
		if(s1 == null || s2 == null) return 0;
		int m = s1.length();
		int n = s2.length();
		if( m == 0 || n == 0 ) return 0;
		
		int[][] dp = new int[m+1][n+1];
		for(int j = 0; j < n; j++){
			for(int i = 0; i < m; i++){
				if( s1.charAt(i) == s2.charAt(j) ) dp[i+1][j+1] = dp[i][j] + 1;
				dp[i+1][j+1] = Math.max( dp[i+1][j+1], Math.max(dp[i][j+1],dp[i+1][j]) );		
			}
		}
		return dp[m][n];
	}
	// top-down   O(mn)
	public int lcs_Memoized(String s1, String s2){
		if(s1 == null || s2 == null) return 0;
		int m = s1.length();
		int n = s2.length();
		if( m == 0 || n == 0 ) return 0;
		
		int[][] dp = new int[m+1][n+1];
		for(int[] row : dp){
			Arrays.fill(row, -1);
		}
		return dfs_M(s1, m-1, s2, n-1, dp);
	}
	private int dfs_M(String s1,int i, String s2, int j, int[][] dp){
		if (i == 0 || j == 0)   return 0;
		if(dp[i+1][j+1] != -1){
			return dp[i+1][j+1];
		}
		int res = 0;
		if( s1.charAt(i) == s2.charAt(j) ) {
			res = dfs_M(s1, i-1, s2, j-1, dp) + 1;
		}
		else{
			res = Math.max(dfs_M(s1, i, s2, j-1, dp), dfs_M(s1, i-1, s2, j, dp));
		}
		dp[i+1][j+1] = res;
		return res;
	}
}
