package DP4_LongestCommonSubsequence;

public class LongestCommonIncreasingSubsequence {
	//  时间复杂度 O(n^2), 空间复杂度 O(n^2)
	public int lcis(String s1, String s2){
		char[] a = s1.toCharArray();
		char[] b = s2.toCharArray();
		int m = a.length;
		int n = b.length;
		
		int[][] dp = new int[m+1][n+1];
		
		for(int i = 0; i < m; i++){
			int max = 0;
			for(int j = 0; j < n; j++){
				if(a[i] == b[j]){
					dp[i+1][j+1] = max+1;
				}
				else{
					dp[i+1][j+1] = dp[i][j+1];
					if(a[i] > b[j] && max < dp[i][j+1]) max = dp[i][j+1];
				}
			}
		}
		// find max
		int max = 0;
		for(int j = 1; j <= n; j++){
			if(max < dp[m][j]) max = dp[m][j];
		}
		return max;
	}
	public static void main(String[] args){
		LongestCommonIncreasingSubsequence sol = new LongestCommonIncreasingSubsequence();
		System.out.print( sol.lcis("15241","1924") );
	}
	
	
	
}
