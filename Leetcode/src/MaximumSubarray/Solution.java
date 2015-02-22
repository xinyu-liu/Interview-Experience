package MaximumSubarray;

public class Solution {
	/*
	 * 
如果之前SubArray的总体和大于0的话，我们可以认为其对后续数字是有贡献的。这种情况下我们选择加入之前的SubArray

如果之前SubArray的总体和为0或者小于0的话，我们可以认为其对后续数字是没有贡献，甚至是有害的（小于0时）。这种情况下我们只能选择以这个数字开始，另起一个SubArray

明白了这点，代码就很好写了, sum记录之前SubArray的和，max用来返回最大值，当sum的值大于max时，说明发现和更大的SubArray序列，此时更新max的值。
	 */
    public int maxSubArray(int[] A) {
        int prevSum = 0;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < A.length; i++){
        	prevSum = (prevSum<0 ? 0:prevSum) + A[i];
        	if(max < prevSum){
        		max = prevSum;
        	}
        }
        return max;
    }
}
