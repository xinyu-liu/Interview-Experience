package DP8_MatrixChainMultiplication;

import java.util.Arrays;

public class MatrixChainMultiplication {
	// rec
	public int minNumOfMult_Rec(int[] p){
		return rec(p, 0, p.length - 1);
	}
	private int rec(int[] p, int i, int j){	
		if( i == j || i + 1 == j ) return 0;
		int min = Integer.MAX_VALUE;
		for(int k = i+1; k <= j-1; k++){
			int temp =  rec(p, i, k) + 
						rec(p, k, j) +
						p[i] * p[k] * p[j];
			min = Math.min(min, temp);
		}
		return min;
	}
	
	// DP top down       Time: O(n^3)  Space: O(n^2)
	public int minNumOfMult_TD(int[] p){
		int len = p.length;
		int[][] dp = new int[len][len];
		for(int[] row: dp){
			Arrays.fill(row, -1);
		}
		return recTD(p, 0, p.length - 1, dp);
	}
	private int recTD(int[] p, int i, int j, int[][] dp){	
		if(dp[i][j] != -1) return dp[i][j];
		if( i == j || i + 1 == j ) dp[i][j] = 0;
		else{
			int min = Integer.MAX_VALUE;
			for(int k = i+1; k <= j-1; k++){
				int temp =  recTD(p, i, k, dp) + 
							recTD(p, k, j, dp) +
							p[i] * p[k] * p[j];
				min = Math.min(min, temp);
			}
			dp[i][j] = min;
		}
		return dp[i][j];
	}
	
	// DP bottom up       Time: O(n^3)  Space: O(n^2)
	public int minNumOfMult_BU(int[] p){
		int len = p.length;
		int[][] dp = new int[len][len];
		for(int l = 1; l <= len; l++){
			for(int i = 0;  i+l-1 < len; i++){
				if(l == 1 || l == 2)  dp[i][i+l-1] = 0;
				else {
					int min = Integer.MAX_VALUE;
					for(int k = i+1; k < i+l-1; k++){
						int temp = dp[i][k] + dp[k][i+l-1] + p[i]*p[k]*p[i+l-1];
						min = Math.min(min, temp);
					}
					dp[i][i+l-1] = min;
				}
			}
		}
		return dp[0][len-1];
	}
}
