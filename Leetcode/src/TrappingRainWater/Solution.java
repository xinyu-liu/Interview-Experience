package TrappingRainWater;

public class Solution {
	/*
	 * 分析：对某个值A[i]来说，能trapped的最多的water取决于在i之前最高的值leftMostHeight[i]和在i右边的
	 * 最高的值rightMostHeight[i]（均不包含自身）。
	 * 如果min(left,right) > A[i]，那么在i这个位置上能trapped的water就是min(left,right) - A[i]。
	 * 第一遍从左到右计算数组leftMostHeight，第二遍从右到左计算rightMostHeight。时间复杂度是O(n)。
	 */
    public int trap(int[] A) {
    	if(A.length< 3){
    		return 0;
    	}
    	int sum = 0;
    	
    	int max = Integer.MIN_VALUE;
    	int[] maxleft = new int[A.length];
    	for(int i = 0; i < A.length; i++){
    		max = Math.max(max, A[i]);
    		maxleft[i] = max;
    	}
    	max = Integer.MIN_VALUE;
    	for(int i = A.length - 1; i >= 0; i--){
    		max = Math.max(max, A[i]);
    		maxleft[i] = Math.min(maxleft[i], max);
    	}   		
    	for(int i = 0; i < A.length; i++){
    		sum += (maxleft[i] - A[i]);
    	}
    	return sum;
    }
}
