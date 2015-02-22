package KnapsackProblem;

import java.util.Arrays;
import java.util.LinkedList;

public class UnboundedKnapsack_UnnecessarilyFull {
	
	//Space:O(NW) Time: O(NW∑(w/wts[i]))
	public int knapsackBU1(int W, int N, int[] wts, int[] vals){
		int[][] v = new int[N+1][W+1];
		for(int i = 1; i <= N; i++){
			for(int w = 1; w <= W; w++){
				v[i][w] = Math.max( v[i-1][w], v[i][w]);
				for(int j = 0; j<= w/wts[i-1]; j++){
					if(w-j*wts[i-1] >= 0)
						v[i][w] = Math.max(v[i][w] ,
								v[i-1][w-j*wts[i-1]] + j*vals[i-1] ); 
				}
			}
		}
		return v[N][W];
	}
	//Space:O(NW) Time: O(NW)
	public int knapsackBU2(int W, int N, int[] wts, int[] vals){
		int[][] dp = new int[N+1][W+1];
		for(int i = 1; i <= N; i++){
			for(int w = 1; w <= W; w++){		
				if(w >= wts[i-1])
					 dp[i][w] = Math.max(dp[i-1][w], dp[i][w-wts[i-1]] + vals[i-1]);
				else dp[i][w] = dp[i-1][w];
			}
		}
		return dp[N][W];
	}
	//Space:O(W) Time: O(NW)
	public int knapsackBUSpace(int W, int N, int[] wts, int[] vals){
		int[] dp = new int[W+1];
		for(int i = 1; i <= N; i++){
			for(int w = wts[i-1]; w <= W; w++){		
				dp[w] = Math.max(dp[w], dp[w-wts[i-1]] + vals[i-1]);

			}
		}
		return dp[W];
	}
//////////////////////Output which items (one possibility) inside the optimal
	// solution 1: trace back O(m+n)
	public void knapsackOnePath1(int W, int N, int[] wts, int[] vals){
		int[][] dp = new int[N+1][W+1];
		for(int i = 1; i <= N; i++){
			for(int w = 1; w <= W; w++){
				if(w >= wts[i-1])
					 dp[i][w] = Math.max(dp[i-1][w], dp[i][w-wts[i-1]] + vals[i-1]);
				else dp[i][w] = dp[i-1][w];
			}
		}
		// trace back
		int i = N; 
		int w = W;		
		
		while(i > 0 && w > 0){
			if(w >= wts[i-1] && dp[i][w] == dp[i][w-wts[i-1]] + vals[i-1]){
				System.out.print(i + " ");
				w -= wts[i-1];
			}
			else i--;
		}
		System.out.println();
	}
	// solution 2: record in path[][] while calc dp[][] or dp[]
	/*
	 * 开辟数组，在求解最大收益时做标记位。求解完最大收益后，根据这个新数组倒着推结果 - 从Path[n][w]逆着走向Path[0][0]来获取背包内物品
	 * 注意：这种方法均适用存储状态数组不压缩 和 压缩两种情况
	 * path[][] O(nw)  O(nw)
	 * trace back O(m+n)
	 */
	public void knapsackOnePath2(int W, int N, int[] wts, int[] vals){
		int[][] dp = new int[N+1][W+1];
		boolean[][] path = new boolean[N+1][W+1]; // record path 1/0
		
		for(int i = 1; i <= N; i++){
			for(int w = 1; w <= W; w++){
				dp[i][w] = dp[i-1][w]; 
				if(w >= wts[i-1] && dp[i][w - wts[i-1]] + vals[i-1] > dp[i][w]){
					path[i][w] = true; // take
					dp[i][w] = dp[i][w - wts[i-1]] + vals[i-1];
				}
			}
		}
		// trace back O(m+n)
		int i = N; 
		int w = W;
		while(i > 0 && w > 0){
			if(path[i][w]){
				System.out.print(i + " ");
				w = w - wts[i-1];
			}
			else i--;
		}
		System.out.println();
	}
	
	
	//////////////////////Output which items (ALL possibilities) inside the optimal
	// backtracking, enumerate all combinations
	// solution 1: ONLY for dp[][], not for dp[]
	/*
	 *  F[i][j] != F[i][j-C[i]]+W[i] && F[i][j] == F[i-1][j]     =>     not take ith item;
        F[i][j] == F[i][j-C[i]]+W[i] && F[i][j] != F[i-1][j]     =>      take ith item
        F[i][j] == F[i][j-C[i]]+W[i] && F[i][j] == F[i-1][j]     =>      both ok
        
	 * backtracking - O(NA)         A: number of combination of ans
	 */
	
	public void knapsackAllPath1(int W, int N, int[] wts, int[] vals){
		int[][] dp = new int[N+1][W+1];
		for(int i = 1; i <= N; i++){
			for(int w = 1; w <= W; w++){
				dp[i][w] = dp[i-1][w]; 
				if(w >= wts[i-1] && dp[i][w - wts[i-1]] + vals[i-1] > dp[i][w]){
					dp[i][w] = dp[i][w - wts[i-1]] + vals[i-1];
				}
			}
		}
		// backtracking - O(NA)         A: number of combination of ans
		findAllPath1_backtrack(dp, W, N, wts, vals, new LinkedList<Integer>());
	}
	private void findAllPath1_backtrack(int[][] dp,int w, int i, int[] wts, int[] vals, LinkedList<Integer> ans){
		if(i == 0 || w == 0){
			for(int a: ans){
				System.out.print(a + " ");
			}
			System.out.println();
			return;
		}
		if(dp[i][w] == dp[i-1][w] 
				&& (w-wts[i-1] < 0 || dp[i][w] != dp[i][w-wts[i-1]] + vals[i-1]) ){
			// not take
			findAllPath1_backtrack(dp, w, i-1, wts, vals, ans);
		}
		else if(dp[i][w] != dp[i-1][w]
				&& (w-wts[i-1] >= 0 && dp[i][w] == dp[i][w-wts[i-1]] + vals[i-1]) ){
			// take
			ans.addFirst(i);
			findAllPath1_backtrack(dp, w-wts[i-1], i, wts, vals, ans);
			ans.remove(0); /////DON'T FORGET
		}
		else if(dp[i][w] == dp[i-1][w] 
				&& (w-wts[i-1] >= 0 && dp[i][w] == dp[i][w-wts[i-1]] + vals[i-1]) ){
			// take
			ans.addFirst(i);
			findAllPath1_backtrack(dp, w-wts[i-1], i, wts, vals, ans);
			ans.remove(0); /////DON'T FORGET
			// not take
			findAllPath1_backtrack(dp, w, i-1, wts, vals, ans);
		}
	}
	// solution 2: record in path[][] while calc dp[][] or dp[]
	/*
	 * int path[][]  =>  0 for not taken, 1 for taken, 2 for both ok
	 * 
	 * 注意：这种方法均适用存储状态数组不压缩 和 压缩两种情况
	 * 
	 * path[][] O(nw)  O(nw)
	 * backtracking - O(NA)         A: number of combination of ans
	 */
	public void knapsackAllPath2(int W, int N, int[] wts, int[] vals){
		int[][] dp = new int[N+1][W+1];
		int[][] path = new int[N+1][W+1]; // 0 for not taken, 1 for taken, 2 for both ok
		
		for(int i = 1; i <= N; i++){
			for(int w = 1; w <= W; w++){
				dp[i][w] = dp[i-1][w]; 
				if(w >= wts[i-1]){
					if(dp[i][w - wts[i-1]] + vals[i-1] == dp[i][w]){ 
						path[i][w] = 2; // ok
					}
					else if(dp[i][w - wts[i-1]] + vals[i-1] > dp[i][w]){
						path[i][w] = 1; // take
						dp[i][w] = dp[i][w - wts[i-1]] + vals[i-1];
					}
				}
			}
		}
		// backtracking - O(NA)          A: number of combination of ans
		findAllPath2_backtrack(path, W, N, wts, new LinkedList<Integer>());
	}
	private void findAllPath2_backtrack(int[][] path,int w, int i, int[] wts, LinkedList<Integer> ans){
		if(i == 0){
			for(int a: ans){
				System.out.print(a + " ");
			}
			System.out.println();
			return;
		}
		if(path[i][w] == 0){
			// not take
			findAllPath2_backtrack(path, w, i-1, wts, ans);
		}
		else if(path[i][w] == 1){
			// take
			ans.addFirst(i);
			findAllPath2_backtrack(path, w-wts[i-1], i, wts, ans);
			ans.remove(0); /////DON'T FORGET 
		}
		else if(path[i][w] == 2){
			// take
			ans.addFirst(i);
			findAllPath2_backtrack(path, w-wts[i-1], i, wts, ans);
			ans.remove(0); /////DON'T FORGET
			// not take
			findAllPath2_backtrack(path, w, i-1, wts, ans);
		}
	}
	
	
	//////////////////////Output the number of possibilities / combinations to achieve the max total value
	/* O(nw)  O(nw) 
	 * 
	 * Let G[i][j] be the total number of combinations to achieve F[i][j].
	 * Initialize G[][] as 1s -- for F[][], at least one combination. 

F[i][j] == F[i][j] && F[i][j] != F[i-1][j-C[i]]+W[i]  =>   not take ith item  G[i][j] = G[i-1][j]
F[i][j] == F[i][j-C[i]]+W[i] && F[i][j] != F[i-1][j]  =>   take ith item      G[i][j] = G[i][j-C[i]]
F[i][j] == F[i][j-C[i]]+W[i] && F[i][j] == F[i-1][j]  =>   both ok            G[i][j] = G[i][j-C[i]]+G[i-1][j]	 
	 */
	public int knapsackNumCombinations(int W, int N, int[] wts, int[] vals){
		int[][] dp = new int[N+1][W+1];
		int[][] nums = new int[N+1][W+1];
		for(int[] row: nums){
			Arrays.fill(row, 1);
		}

		for(int i = 1; i <= N; i++){
			for(int w = 1; w <= W; w++){
				dp[i][w] = dp[i-1][w];
				nums[i][w] = nums[i-1][w];
				if(w >= wts[i-1]){  ///////////////DONT' FORGET
					if(dp[i][w-wts[i-1]] + vals[i-1] > dp[i][w]){
						dp[i][w]   = dp[i][w-wts[i-1]] + vals[i-1];
						nums[i][w] = nums[i][w-wts[i-1]];
		
					}
					else if(dp[i][w-wts[i-1]] + vals[i-1] == dp[i][w]){
						nums[i][w] = nums[i-1][w] + nums[i][w-wts[i-1]];
					}
				}
			}
		}
		return nums[N][W];
	}
	public int knapsackNumCombinations_SaveSpace(int W, int N, int[] wts, int[] vals){
		int[] dp = new int[W+1];
		int[] nums = new int[W+1];
		Arrays.fill(nums, 1);

		for(int i = 1; i <= N; i++){
			for(int w = wts[i-1]; w <= W; w++){	
				if(dp[w-wts[i-1]] + vals[i-1] > dp[w]){
					dp[w]   = dp[w-wts[i-1]] + vals[i-1];
					nums[w] = nums[w-wts[i-1]];		
				}
				else if(dp[w-wts[i-1]] + vals[i-1] == dp[w]){
					nums[w] += nums[w-wts[i-1]];
				}
			}
		}
		return nums[W];
	}


	public static void main(String[] args){
		UnboundedKnapsack_UnnecessarilyFull sol = new UnboundedKnapsack_UnnecessarilyFull();
/*		int vals[] = {6, 5, 10, 2, 16, 8};
	    int  wts[] = {3, 2, 6, 1, 6, 4};
	    int w = 10;

		int ans = sol.knapsackBU1(w, vals.length, wts, vals);
	    System.out.println(ans);
	    
		sol.knapsackOnePath1(w, vals.length, wts, vals);
		sol.knapsackOnePath2(w, vals.length, wts, vals);
*/		
		// int wts[] = {1,1,1,1,1,1};  
	    // int vals[] =  {2,2,2,2,2,2}; 
		// int w = 4;
		int vals[] = {5, 5, 10, 10, 10};
	    int  wts[] = {3, 2, 5, 4, 5};
	    int w = 10;
	    
	    sol.knapsackAllPath1(w, vals.length, wts, vals);
	    int ans = sol.knapsackNumCombinations(w, vals.length, wts, vals);
	    System.out.println(ans);
		sol.knapsackAllPath2(w, vals.length, wts, vals);
		ans = sol.knapsackNumCombinations_SaveSpace(w, vals.length, wts, vals);
		System.out.println(ans);

		
	}
}
