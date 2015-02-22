package DP4_LongestCommonSubsequence;

public class PrintOneLCS {
	// find one Longest Common Subsequence
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
		
		
		//////////////////// Following code is used to print LCS
		int len = dp[m][n];
		char[] ans = new char[len];
		int i = m-1;
		int j = n-1;
		int a = len - 1;
		while(i >= 0 && j >= 0){
			if(s1.charAt(i) == s2.charAt(j)){
				ans[a--] =  s1.charAt(i);
				i--;j--;
			}
			else{
				if( dp[i+1][j] > dp[i][j+1] ){
					j--;
				}
				else i--;
			}
		}
		System.out.print(new String(ans));
		
		//////////////////// Above code is used to print LCS
		return dp[m][n];
	}
	public static void main(String[] args){
		PrintOneLCS sol = new PrintOneLCS();
		sol.lcs_Tabulation("AGGTAB", "GXTXAYB");
	}
}
