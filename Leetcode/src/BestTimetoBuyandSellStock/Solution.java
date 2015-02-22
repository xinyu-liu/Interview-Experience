package BestTimetoBuyandSellStock;

public class Solution {
	/* 看来以后碰到与2相关的问题，一定要想想能不能用二分法来做！
	既然买入第二次之前必须卖掉第一次买的，那么实际上问题就变成了我需要找到一个i，
	使得0到i天内那笔交易的最大收益与i到n-1天内那笔交易的最大收益之和最大。
	这样的话每个单独区间的最大收益在 I 中就已经解决了。
	
	接下来就需要考虑效率问题。 我第一遍的代码特别蛋疼，是O(n^2)的，而这个神奇的方法是O(n)。 
	这里需要扫三遍：
	第一遍从前往后扫，得出在第i天之前进行的那笔交易一共能赚多少
	第二遍从后往前扫，注意第i天到第n天最多能赚多少，反过来就是从第n天倒回去到第i天最多能亏多少
	第三遍扫之前存下的俩数组，得出最大利润

	NOTE: 我自己的思路 － 在II上改进（diff）是错的 因为不再连续 第二第三大的两个可结合 
	中间有负值的情况没考虑
	*/
	// III
	public int maxProfit(int[] prices) {
		if(prices==null || prices.length == 0){
    		return 0;
    	}
		int[] left  = new int[prices.length];
		int[] right = new int[prices.length];
		// left
		int minPrice = prices[0];
		int maxProfit = 0;
		left[0] = 0;
		for(int i = 1; i < prices.length; i++){
			if(prices[i] < minPrice){
				minPrice = prices[i];		
			}
			else {
				int cur = prices[i] - minPrice; 
				if(cur > maxProfit){
					maxProfit = cur;
				}
			}
			left[i] = maxProfit;
		}
		// right
		int maxPrice = prices[prices.length-1];
		maxProfit = 0;
		right[prices.length-1] = 0;
		for(int i = prices.length-2; i >= 0; i--){
			if(prices[i] > maxPrice){
				maxPrice = prices[i];
			}
			else {
				int cur = maxPrice - prices[i]; 
				if(cur > maxProfit){
					maxProfit = cur;
				}
			}
			right[i] = maxProfit;
		}
		// combine
		maxProfit = Math.max( right[0], left[prices.length-1] );
		for(int i = 0; i < prices.length - 1; i++){
			if(left[i] + right[i+1] > maxProfit){
				maxProfit = left[i] + right[i+1];
			}
		}
		return maxProfit;
	}
	
	// II 
	public int maxProfitII(int[] prices) {
		if(prices==null || prices.length == 0){
    		return 0;
    	}
        int[] diff = new int[prices.length];
        diff[0] = 0;
        for(int i = 1; i < prices.length; i++){
        	diff[i] = prices[i]-prices[i-1];
        	if(diff[i] < 0){
        		diff[i] = 0;
        	}
        }
        int sum = 0;
        for(int i = 1; i < prices.length; i++){
        	sum += diff[i];
        }
        return sum;
	}
	// Time Limit Exceeded O(n^2)
    public int maxProfitBAD(int[] prices) {
    	if(prices==null || prices.length == 0){
    		return 0;
    	}
    	int length = prices.length;
        int[] opt = new int[length];
        opt[0] = 0;
        for(int i = 1; i < length; i++){
        	int max = Integer.MIN_VALUE; 
        	for (int j = 0; j < i; j++){
        		int temp = opt[j] + prices[i]-prices[j+1];
        		if(max < temp){
        			max = temp;
        		}
        	}
        	opt[i] = max;
        }
        return opt[length-1];
    }
	// I
	public int maxProfitI(int[] prices) {
        if(prices == null || prices.length == 0){
            return 0;
        }
        
    	int profit = 0;
    	int prevMin = prices[0];
        for (int i = 0; i < prices.length; i++){
        	int cur = prices[i];
        	if(cur < prevMin){
        		prevMin = cur;
        	}
        	else{
        		if(cur - prevMin > profit){
        			profit = cur - prevMin;
        		}
        	}
        }
        return profit;
    }
}