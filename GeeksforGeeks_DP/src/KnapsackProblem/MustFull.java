package KnapsackProblem;

public class MustFull {
	
	// Can change this amount of money or not
	public boolean canExchange(int[] prices, int total){
		int n = prices.length;
		boolean[][] dp = new boolean[n+1][total+1];
		// init 
		for(int i = 0; i < n+1; i++){
			dp[i][0] = true;
		}	
		for(int t = 0; t < total+1; t++){
			dp[0][t] = false;	
		}
		// general 
		for(int i = 1; i < n+1; i++){
			for(int t = 1; t < total+1; t++){
				dp[i][t] = dp[i-1][t];
				if(t >= prices[i-1] )
					dp[i][t] = dp[i][t] || dp[i][t-prices[i-1]];
			}
		}		
		return dp[n][total];
	}
	
	// Number of ways to get the total value
	// above method, change OR to +
	public int numOfWaysExchange(int[] prices, int total){
		int n = prices.length;
		int[][] dp = new int[n+1][total+1];
		// init    没有物品放入容量为0的背包刚好放满的方案数为1。
		for(int i = 0; i < n+1; i++){
			dp[i][0] = 1;
		}
		// general 
		for(int i = 1; i < n+1; i++){
			for(int t = 1; t < total+1; t++){
				dp[i][t] = dp[i-1][t];
				if(t >= prices[i-1]) dp[i][t] += dp[i][t-prices[i-1]];
			}
		}
		return dp[n][total];
				
	}
	
	//The min num of coins to get the given total value
	// NOTE: when there is special relationship between prices,
	// we can use Greedy algorithm which is faster
	public int MinNumOfCoinsExchange(int[] prices, int total){
		int n = prices.length;
		int[] dp = new int[total+1];
		dp[0] = 0;
		for(int i = 1; i < n+1; i++){
			for(int t = prices[i-1]; t < total+1; t++){
				dp[t] = Math.min(dp[t], dp[t-prices[i-1]]+1);
			}
		}
		return dp[total];
	}
	
	
	public static void main(String[] args){
		int[] prices = {5, 2, 6, 11, 17};
		
		MustFull sol = new MustFull();
		boolean b = sol.canExchange(prices, 16);
		System.out.println( b );
		int numOfWays = sol.numOfWaysExchange(prices, 16);
		System.out.println( numOfWays );

	}
}
