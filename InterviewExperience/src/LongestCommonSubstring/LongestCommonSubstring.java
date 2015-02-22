package LongestCommonSubstring;
/*
d[i][j] : A[0…i]和B[0…j]的 最长公共后缀 的长度
d[i][j] =
	A[i] == B[j] : d[i][j] = d[i - 1][j - 1] + 1 //公共后缀 多了当前这个char
	A[i] != B[j] : d[i][j] = 0//断开了，无公共后缀了
 */
public class LongestCommonSubstring {
	public int lcsubstring(String s1, String s2){
		int m = s1.length();
		int n = s2.length();
		int[][] dp = new int[m][n];
		int ans = 0;
		for(int i = 0; i < m; i++){
			for(int j = 0; j < n; j++){
				if( s1.charAt(i) == s2.charAt(j) ){
					if(i == 0 || j == 0) dp[i][j] = 1;
					else dp[i][j] = dp[i-1][j-1] + 1;
					// update
					if(dp[i][j] > ans) ans = dp[i][j]; 		
				}
				// else = 0
			}
		}
		return ans;
	}
}
