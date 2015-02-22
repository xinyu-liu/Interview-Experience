package DP5_EditDistance;

import java.util.Arrays;

public class EditDistance {
	// rec - too slow O(3^(m+n))
	public int minDistanceRec(String s1, String s2){
		return minDRec(s1, s1.length(), s2, s2.length()); 
	}
	private int minDRec(String s1, int i, String s2, int j){
		if(i == 0) return j;
		if(j == 0) return i;
		int left = minDRec(s1, i-1, s2, j) + 1;
		int up = minDRec(s1, i, s2, j-1) + 1; 
		int ul = minDRec(s1, i-1, s2, j-1) + s1.charAt(i-1) == s2.charAt(j-1) ? 0:1 ;
		return min3(left, up, ul);
	 // return Math.min(  Math.min(left, up) , ul  ) ;
	}
	
	
	
	// DP top-down - O(mn)  添加数组，保存状态，用空间换时间 
	public int minDistanceTD(String s1, String s2){
		int m = s1.length();
		int n = s2.length();
		int[][] dp = new int[m+1][n+1];
		Arrays.fill(dp, -1);
		return minDTD(s1, s1.length(), s2, s2.length(), dp); 
	}
	private int minDTD(String s1, int i, String s2, int j, int[][] dp){
		if(dp[i][j] != -1){
			return dp[i][j];
		}
		int ans = -1;
		if(i == 0) ans = j;
		else if(j == 0) ans = i;
		else{
			int left = minDTD(s1, i-1, s2, j, dp) + 1;
			int up = minDTD(s1, i, s2, j-1, dp) + 1; 
			int ul = minDTD(s1, i-1, s2, j-1, dp) + s1.charAt(i-1) == s2.charAt(j-1) ? 0:1 ;
			ans = min3(left, up, ul);
		}
		dp[i][j] = ans;
		return ans;
	}
	
	
	
	// dp bottom up - O(mn)
	public int minDistanceBU(String s1, String s2){
		int m = s1.length();
		int n = s2.length();
		int[][] dp = new int[m+1][n+1];
		// init
		for(int i = 0; i <= m; i++){
			dp[i][0] = i;
		}
		for(int j = 0; j <= n; j++){
			dp[0][j] = j;
		}
		// general
		for(int i = 1; i <= m; i++){
			for(int j = 1; j <= n; j++){
				dp[i][j] = min3(dp[i-1][j] + 1, 
						        dp[i][j-1] + 1,
						        (s1.charAt(i-1) == s2.charAt(j-1) ? 0 : 1) + dp[i-1][j-1] );
				/*
				dp[i][j] = Math.min(  Math.min(dp[i-1][j] + 1, dp[i][j-1] + 1), 
						              (s1.charAt(i-1) == s2.charAt(j-1) ? 0 : 1) + dp[i-1][j-1]
						            );
				*/
			}
		}
		return dp[m][n];
	}
	private int min3(int d1, int d2, int d3){
		 return Math.min(  Math.min(d1, d2),  d3 );
	}
}
