package KnapsackProblem;

import java.util.Arrays;
import java.util.LinkedList;

public class ZeroOneKnapsack_UnnecessarilyFull {
	//find the maximum value that can be put in a knapsack of capacity cap
	/*
	 * 目标：在不超过背包容量的情况下，最多能获得多少价值 
	 * 子问题状态:f[i][j]:表示前i件物品放入容量为j的背包得到的最大价值 
	 * 状态转移方程:f[i][j] = max{f[i - 1][j],f[i - 1][j - weight[i]] + value[i]} 
	 */
	
	/*
	 * Naive: The total number of subset is O(2^N). Validate one subset takes O(N),
	 * time complexity O(2^N * N)
	 * 
	 * Backtracking help reduce time.
	 * 
	 *  Rec / dp: choose to PUT or NOT PUT this item
	 */
	public static void main(String[] args){
		ZeroOneKnapsack_UnnecessarilyFull sol = new ZeroOneKnapsack_UnnecessarilyFull();
/*		int vals[] = {5, 6, 5, 1, 19, 7};
	    int  wts[] = {2, 3, 1, 4, 6, 5};
	    int w = 10;
*/		// sol.knapsackRec(w, vals.length, wts, vals);
		// int ans = sol.knapsackBU(w, vals.length, wts, vals);
	    // System.out.println(ans);
	    
		// sol.knapsackOnePath1(w, vals.length, wts, vals);
		// sol.knapsackOnePath2(w, vals.length, wts, vals);
		
		// int wts[] = {1,1,1,1,1,1};  
	    // int vals[] =  {2,2,2,2,2,2}; 
		// int w = 4;
		int vals[] = {5, 5, 10, 10, 10};
	    int  wts[] = {3, 2, 5, 4, 5};
	    int w = 10;
	    
	    sol.knapsackAllPath1(w, vals.length, wts, vals);
	    int ans = sol.knapsackNumCombinations(w, vals.length, wts, vals);
	    System.out.println(ans);
		//sol.knapsackAllPath2(w, vals.length, wts, vals);
		//ans = sol.knapsackNumCombinations_SaveSpace(w, vals.length, wts, vals);
		//System.out.println(ans);
		
		ans = sol.knapsackNumItemsORWeight1(w, vals.length, wts, vals);
		System.out.println(ans);
		ans = sol.knapsackMinWeight2(w, vals.length, wts, vals);
		System.out.println(ans);
		
		
	}
	
	////////////////////// Naive Rec     O(2^(w+n))
	public int knapsackRec(int w, int n, int[] wts, int[] vals){
		if(w == 0 || n == 0) return 0;
		
		if(w < wts[n-1]) 
			return knapsackRec(w, n-1, wts, vals); // not chosen
		
		else return Math.max( knapsackRec(w, n-1, wts, vals), // not chosen
							  knapsackRec(w-wts[n-1], n-1, wts, vals) + vals[n-1] // chosen
						);
	}
	
	
	
	////////////////////// DP bottom up   time O(w*n)  space O(w*n) 
	// where n is the number of items and W is the capacity of knapsack
	public int knapsackBU(int W, int N, int[] wts, int[] vals){
		int[][] dp = new int[N+1][W+1];
		for(int i = 1; i <= N; i++){
			for(int w = 1; w <= W; w++){
				dp[i][w] = dp[i-1][w]; // not taking ith item
				if(w >= wts[i-1]){
					dp[i][w] = Math.max(dp[i][w], dp[i-1][w - wts[i-1]] + vals[i-1]);
				}
			}
		}
		return dp[N][W];
	}
	
	
	
	////////////////////// DP bottom up   time O(w*n)  space O(w) 
	public int knapsackBUSaveSpace(int W, int N, int[] wts, int[] vals){
		int[] dp = new int[W+1];
		for(int i = 1; i <= N; i++){
			for(int w = W; w > 0; w --){
				if(w >= wts[w-1]){
					dp[w] = Math.max(dp[w], dp[w - wts[i-1]] + vals[i-1]);
				}
			}
			/*
			for (int w = W; w >= wts[i-1]; w--) //枚举背包容量,防越界，w下限为 wts[i-1]  
		    {  
				dp[w] = Math.max(dp[w], dp[w - wts[i-1]] + vals[i-1]);
		    } 
		    */ 
		}
		return dp[W];
	}

	
	
	////////////////////// DP2 bottom up   time O(C*n)  space O(C)
	public int knapsackBUSaveSpace2(int W, int N, int[] wts, int[] vals){
		int[] dp = new int[W+1];
		// compute total value
		int C = 0;
		for(int i = 0; i < N; i++){
			C += vals[i];
		}
		
		for(int i = 1; i <= N; i++){
			for(int v = C; v >= vals[i] ; v --){
				dp[v] = Math.min(dp[v], dp[v - vals[i-1]] + wts[i-1]);
	
			}
		}
		int v = C;
		while(dp[v] > W) v--;
		return v;
	}
	
	
	
	////////////////////// Output which items (one possibility) inside the optimal
	// solution 1: 
	/*  X  O(w)的空间复杂度的方法 不能利用关系式F [j]==F [j-C[i]]+W[i], 因为一维数组并不能提供足够的信息来寻找二维路径。
	 *                   而只能利用Path[][]进行标记.
	 * O(nw)  O(nw)
	 * trace back O(m+n)
	 */
	public void knapsackOnePath1(int W, int N, int[] wts, int[] vals){
		int[][] dp = new int[N+1][W+1];
		for(int i = 1; i <= N; i++){
			for(int w = 1; w <= W; w++){
				dp[i][w] = dp[i-1][w]; // not taking ith item
				if(w >= wts[i-1]){
					dp[i][w] = Math.max(dp[i][w], dp[i-1][w - wts[i-1]] + vals[i-1]);
				}
			}
		}
		// trace back
		int i = N; 
		int w = W;
		while(i > 0 && w > 0){
			if( dp[i][w] == dp[i-1][w-wts[i-1]] + vals[i-1] ){
				System.out.print(i + " ");
				w = w-wts[i-1];
				i--;
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
				if(w >= wts[i-1]){
					if(dp[i-1][w - wts[i-1]] + vals[i-1] > dp[i][w]){
						path[i][w] = true; // take
						dp[i][w] = dp[i-1][w - wts[i-1]] + vals[i-1];
					}
				}
			}
		}
		// trace back O(m+n)
		int i = N; 
		int w = W;
		while(i > 0 && w > 0){
			if(path[i][w]){
				System.out.print(i + " ");
				i--;
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
	 *  F[i][j] != F[i-1][j-C[i]]+W[i] && F[i][j] == F[i-1][j]     =>     not take ith item;
        F[i][j] == F[i-1][j-C[i]]+W[i] && F[i][j] != F[i-1][j]     =>      take ith item
        F[i][j] == F[i-1][j-C[i]]+W[i] && F[i][j] == F[i-1][j]     =>      both ok
        
	 * backtracking - O(NA)         A: number of combination of ans
	 */
	
	public void knapsackAllPath1(int W, int N, int[] wts, int[] vals){
		int[][] dp = new int[N+1][W+1];
		for(int i = 1; i <= N; i++){
			for(int w = 1; w <= W; w++){
				dp[i][w] = dp[i-1][w]; 
				if(w >= wts[i-1]){
					if(dp[i-1][w - wts[i-1]] + vals[i-1] > dp[i][w]){
						dp[i][w] = dp[i-1][w - wts[i-1]] + vals[i-1];
					}
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
				&& (w-wts[i-1] < 0 || dp[i][w] != dp[i-1][w-wts[i-1]] + vals[i-1]) ){
			// not take
			findAllPath1_backtrack(dp, w, i-1, wts, vals, ans);
		}
		else if(dp[i][w] != dp[i-1][w]
				&& (w-wts[i-1] >= 0 && dp[i][w] == dp[i-1][w-wts[i-1]] + vals[i-1]) ){
			// take
			ans.addFirst(i);
			findAllPath1_backtrack(dp, w-wts[i-1], i-1, wts, vals, ans);
			ans.remove(0); /////DON'T FORGET
		}
		else if(dp[i][w] == dp[i-1][w] 
				&& (w-wts[i-1] >= 0 && dp[i][w] == dp[i-1][w-wts[i-1]] + vals[i-1]) ){
			// take
			ans.addFirst(i);
			findAllPath1_backtrack(dp, w-wts[i-1], i-1, wts, vals, ans);
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
					if(dp[i-1][w - wts[i-1]] + vals[i-1] == dp[i][w]){ // == dp[i-1][w]
						path[i][w] = 2; // take
						// dp[i][w] = dp[i-1][w - wts[i-1]] + vals[i-1]; no need, equal
					}
					if(dp[i-1][w - wts[i-1]] + vals[i-1] > dp[i][w]){
						path[i][w] = 1; // take
						dp[i][w] = dp[i-1][w - wts[i-1]] + vals[i-1];
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
			findAllPath2_backtrack(path, w-wts[i-1], i-1, wts, ans);
			ans.remove(0); /////DON'T FORGET 
		}
		else if(path[i][w] == 2){
			// take
			ans.addFirst(i);
			findAllPath2_backtrack(path, w-wts[i-1], i-1, wts, ans);
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
     
        F[i][j] == F[i-1][j] && F[i][j] != F[i-1][j-C[i]]+W[i]  =>   not take ith item  G[i][j] = G[i-1][j]
        F[i][j] == F[i-1][j-C[i]]+W[i] && F[i][j] != F[i-1][j]  =>   take ith item      G[i][j] = G[i-1][j-C[i]]
        F[i][j] == F[i-1][j-C[i]]+W[i] && F[i][j] == F[i-1][j]  =>   both ok            G[i][j] = G[i-1][j-C[i]]+G[i-1][j]	 
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
					if(dp[i-1][w-wts[i-1]] + vals[i-1] > dp[i][w]){
						dp[i][w]   = dp[i-1][w-wts[i-1]] + vals[i-1];
						nums[i][w] = nums[i-1][w-wts[i-1]];
						
					}
					else if(dp[i-1][w-wts[i-1]] + vals[i-1] == dp[i][w]){
						nums[i][w] = nums[i-1][w] + nums[i-1][w-wts[i-1]];
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
			for(int w = W; w > 0; w--){
				if(w >= wts[i-1]){  ///////////////DONT' FORGET
					if(dp[w-wts[i-1]] + vals[i-1] > dp[w]){
						dp[w]   = dp[w-wts[i-1]] + vals[i-1];
						nums[w] = nums[w-wts[i-1]];		
					}
					else if(dp[w-wts[i-1]] + vals[i-1] == dp[w]){
						nums[w] += nums[w-wts[i-1]];
					}
				}
			}
		}
		return nums[W];
	}
	
	
	//////////////////////Output the min/max number of items to achieve the max total value
	//////////////////////Output the min/max weight to achieve the max total value
	/* O(nw)  O(w)  
	 * When compute dp[], record the number of items at the same time
	 * When taking or not taking makes no difference, using the number of items to decide to take or not -- min or max
	 */
	public int knapsackNumItemsORWeight1(int W, int N, int[] wts, int[] vals){
		int[] dp = new int[W+1];
		int[] nums = new int[W+1];
		int[] weights = new int[W+1];
		
				
		for(int i = 1; i <= N; i++){
			for(int w = W; w > 0; w--){
				if(w >= wts[i-1]){  ///////////////DONT' FORGET
					if(dp[w-wts[i-1]] + vals[i-1] > dp[w]){
						dp[w]   = dp[w-wts[i-1]] + vals[i-1];
						nums[w] = nums[w-wts[i-1]] + 1;	
						weights[w] = weights[w-wts[i-1]] + wts[i-1];
					}
					else if(dp[w-wts[i-1]] + vals[i-1] == dp[w]){
						nums[w] = Math.min(  nums[w], nums[w-wts[i-1]]+1  ); // min num items
						weights[w] = Math.max(  weights[w], weights[w-wts[i-1]] + wts[i-1]  );
					}
				}
			}
		}
		return weights[W];
	}
	//////////////////////Output the min weight to achieve the max total value
	/* trace back the table =>  O(w)  
	 * find all best total value, with the smallest total weight
	 * while(w - 1 >= 0 && dp[w] == dp[w-1]) w--;
	 */
	public int knapsackMinWeight2(int W, int N, int[] wts, int[] vals){
		int[] dp = new int[W+1];
				
		for(int i = 1; i <= N; i++){
			for(int w = W; w > 0; w--){
				if(w >= wts[i-1]){  ///////////////DONT' FORGET
					if(dp[w-wts[i-1]] + vals[i-1] > dp[w]){
						dp[w] = dp[w-wts[i-1]] + vals[i-1];
					}
				}
			}
		}
		int w = W;
		while(w - 1 >= 0 && dp[w] == dp[w-1]) w--;
		return w;
	} 
}
