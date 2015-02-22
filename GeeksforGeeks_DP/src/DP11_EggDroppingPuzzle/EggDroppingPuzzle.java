package DP11_EggDroppingPuzzle;

public class EggDroppingPuzzle {
	// NAIVE REC
	public int numOfDrop_DEC(int n, int k){
		if( n == 1 ) return k;
		if( k == 0 ) return 0;
		int min = Integer.MAX_VALUE;
		for(int x = 1; x <= k; x++){
			int t = Math.max( numOfDrop_DEC(n, k-x), 
					          numOfDrop_DEC(n-1, x-1) ) + 1;
			if(t < min) min = t;
		}
		return min;
	}
	// DP bottom up
	// Time Complexity: O(nk^2)    Space: O(nk)
	public int numOfDrop_BU(int N, int K){
		int[][] dp = new int[N+1][K+1];
		for(int n = 0; n <= N; n++){
			for(int k = 0; k <= K; k++){
				if(n == 1) dp[n][k] = k;
				else if( k == 0 || n == 0) dp[n][k] = 0;
				else{
					int min = Integer.MAX_VALUE;
					for(int x = 1; x <= k; x++){
						min = Math.min( min, Math.max(dp[n][k-x],dp[n-1][x-1]) );
					}
					dp[n][k] = min+1;
				}
			}
		}
		printArr(dp);
		int n = N;
		int k = K;
		System.out.println(n+" 's egg: "+ k +" layer");
		while(n >= 0 && k >= 0){
			for(int x = 1; x <= k; x++){
				if( Math.max(dp[n][k-x],dp[n-1][x-1]) + 1 == dp[n][k]){
					if( dp[n][k-x] > dp[n-1][x-1]){
						k = k-x;
					}
					else{
						k = x-1;
						n -= 1;
					}
					System.out.println(n+" 's egg: "+ k +" layer");
					break;
				}
			}
		}
		return dp[N][K];
	}
	private void printArr(int[][] dp){
		for(int[] row: dp){
			for(int i: row){
				System.out.print(i+" ");
			}
			System.out.println();
		}
	}
	/*!!!!!!!!!!
	 * try modifying the above DP solution to print all intermediate floors 
	 * (The floors used for minimum trail solution)
	 */
	public static void main(String[] args){
		EggDroppingPuzzle sol = new EggDroppingPuzzle();
		int ans = sol.numOfDrop_BU(2, 36);
		System.out.print(ans);
	}



}
