package DP6_MinCostPath;

public class MinCostPath {
/*
 * 1) Optimal Substructure
 * minCost(m, n) = min (minCost(m-1, n-1), minCost(m-1, n), minCost(m, n-1)) + cost[m][n]
 * 2) Overlapping Subproblems
 * Simple recursive implementation 
 */
	// simple rec - O(3^(m+n))
	public int minCostPathRec(int[][] costs){
		int m = costs.length;
		int n = costs[0].length;
		minCostPathRec2(costs, m-1, n-1 ); //// or return 
		return minCostPathRec(costs, m-1, n-1 );
	}
	private int minCostPathRec(int[][] costs, int i, int j){
		if( i == 0 && j == 0) return costs[i][j];
		if( i == 0 ){
			return minCostPathRec(costs, i, j-1) + costs[i][j];
		}
		if( j == 0 ){
			return minCostPathRec(costs, i-1, j) + costs[i][j];
		}
		return min3( minCostPathRec(costs, i-1, j) , 
					 minCostPathRec(costs, i, j-1)  ,
					 minCostPathRec(costs, i-1, j-1) )
				+ costs[i][j];
	}
	private int minCostPathRec2(int[][] costs, int i, int j){
		if(i < 0 || j < 0) return Integer.MAX_VALUE; //////////////////////
		if( i == 0 && j == 0) return costs[i][j];
		return min3( minCostPathRec(costs, i-1, j) , 
					 minCostPathRec(costs, i, j-1)  ,
					 minCostPathRec(costs, i-1, j-1) )
				+ costs[i][j];
	}	
	
	// DP bottom up -  O(mn)
	public int minCostPathBU(int[][] costs){
		int m = costs.length;
		int n = costs[0].length;
		int[][] dp = new int[m][n];
		// init
		dp[0][0] = costs[0][0];
		for(int i = 1; i < m; i++){
			dp[i][0] = dp[i-1][0] + costs[i][0];
		}
		for(int j = 1; j < n; j++){
			dp[0][j] = dp[0][j-1] + costs[0][j];
		}
		// general
		for(int i = 0; i < m; i++){
			for(int j = 0; j < n; j++){
				dp[i][j] = min3( dp[i-1][j-1], dp[i-1][j], dp[i][j-1] ) + costs[i][j];
			}
		}
		return dp[m-1][n-1];
	}
	
	
	
	
	
	
	private int min3(int i1, int i2, int i3){
		return Math.min( i1, Math.min(i2, i3) );
	}
}
