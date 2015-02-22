package MinimumPathSum;

public class Solution {
	// ¹ö¶¯Êý×é
	public int minPathSum(int[][] grid) {
    	int m = grid.length; 
    	int n = grid[0].length;
    	if(m==0 || n==0){
    		return 0;
    	}
        int[] dp = new int[n];
        for(int i = 0; i < m; i++){
        	for(int j = 0; j < n; j++){
        		if(i == 0 && j == 0) dp[j] = grid[i][j];
        		else                 dp[j] =  grid[i][j] + Math.min(
        				i == 0 ? Integer.MAX_VALUE:dp[j] ,
        				j == 0 ? Integer.MAX_VALUE:dp[j-1]);
        	}
        }
        return dp[n-1];
	}
	// ¾ØÕó
    public int minPathSum2(int[][] grid) {
    	int m = grid.length; 
    	int n = grid[0].length;
    	if(m==0 || n==0){
    		return 0;
    	}
        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++){
        	for(int j = 0; j < n; j++){
        		if(i == 0 && j == 0) dp[i][j] = grid[i][j];
        		else                 dp[i][j] =  grid[i][j] + Math.min(
        				i == 0 ? Integer.MAX_VALUE:dp[i-1][j] ,
        				j == 0 ? Integer.MAX_VALUE:dp[i][j-1]);
        	}
        }
        return dp[m-1][n-1];
    }
}
