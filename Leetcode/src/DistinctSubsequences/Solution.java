package DistinctSubsequences;

public class Solution {
	// Solution1: DP
	// dp[i][j]表示：T的前j个字符在S的前i个字符中出现的次数。
	public int numDistinct(String S, String T) {
		int m = S.length();
		int n = T.length();
		int[][] dp = new int[m+1][n+1];

		for(int j = 0; j < n; j++){
			dp[0][j] = 0;
		}
		for(int i = 0; i < m; i++){
			dp[i][0] = 1;
		}
		for(int i = 1; i < m+1; i++){
			for(int j = 1; j < n+1; j++){
				if(S.charAt(i-1) == S.charAt(j-1)){
					dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
				} 
				else{
					dp[i][j] = dp[i-1][j];
				}
				
			}
		}
		return dp[m][n];
		
	}
	// Solution2: recursion - Time Limit Exceeded
    public int numDistinctREC(String S, String T) {
    	if(S.length()< T.length()){
    		return 0;
    	}
        return numDistinct( S, T,0, 0) ;
    }
    public int numDistinct(String S, String T,int ps, int pt) {
    	if(ps >= S.length()){
    		return 0;
    	}
    	if(pt >= T.length()){
    		return 1;
    	}
        if(S.charAt(ps) == T.charAt(pt)){
        	return numDistinct( S,  T, ps+1,  pt+1) + numDistinct( S,  T, ps+1,  pt);
        }
        else{
        	return numDistinct( S,  T, ps+1,  pt);
        }
    }
}
