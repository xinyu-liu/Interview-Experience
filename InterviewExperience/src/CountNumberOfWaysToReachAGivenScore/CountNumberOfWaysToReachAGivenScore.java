package CountNumberOfWaysToReachAGivenScore;
/*
 * Consider a game where a player can score 3 or 5 or 10 points in a move. Given a total score n, find number of ways to reach the given score.

Examples:

Input: n = 20
Output: 4
There are following 4 ways to reach 20
(10, 10)
(5, 5, 10)
(5, 5, 5, 5)
(3, 3, 3, 3, 3, 5)

Input: n = 13
Output: 2
There are following 2 ways to reach 13
(3, 5, 5)
(3, 10)
 */
public class CountNumberOfWaysToReachAGivenScore {
	public int countWays(int n, int[] scores){
		int s = scores.length;
		int[][] dp = new int[s+1][n+1];
		for(int i = 1; i <= s; i++){
			for(int m = 0; m <= n; m++){
				if(m == 0) dp[i][m] = 1;
				else{
					if(scores[i-1] > m){
						dp[i][m] = dp[i-1][m];
					}
					else{
						dp[i][m] = dp[i][ m-scores[i-1] ] + dp[i-1][m];
					}
				}
			}
		}
		return dp[s][n];
	}
	public static void main(String[] args) {
		int[] scores = {3,5,10};
		CountNumberOfWaysToReachAGivenScore sol = new CountNumberOfWaysToReachAGivenScore();
		System.out.println( sol.countWays(13, scores) );
	}

}
