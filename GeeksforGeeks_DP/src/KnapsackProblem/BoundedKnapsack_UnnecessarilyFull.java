package KnapsackProblem;

public class BoundedKnapsack_UnnecessarilyFull {
	public int knapsack(int N, int W, int[] number, int wts[], int vals){
		int[] dp = new int[W+1];
		for(int i = 0; i <= N; i++){
			for(int w = 0; w <= W; w++){
				int num = number[i-1];
				for(int k = 1; num > 0; k *= 2){
					num -= k; //k 是满足Num[i] - 2^k >= 0 的最大整数。
					
				} 
			}
		}
		return dp[W];
	}
}

/*
		（1）最后一个物品的件数的求法和前面不同，其直接等于 该物品的最大件数 - 前面已经分配之和。
		（2）分成的这几件物品的系数和为Num[i]，表明第i种物品取的件数不能多于Num[i]。
		举例：某物品为13件，则其可以分成四件物品，其系数为1,2,4,6.这里k = 3。
*/
        int num = min(number[i], w / weight[i]);
        for (int k = 1; num > 0; k *= 2)
        {
            if (k > num) k = num;
            num -= k;
            for (int j = w; j >= weight[i] * k; --j)
                c[j] = max(c[j], c[j - weight[i] * k] + cost[i] * k);
        }
}