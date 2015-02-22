package MaximumGap;

import java.util.Arrays;

public class Solution {
	// 为了满足O(n)复杂度，尝试计数排序，但是{1,100000} -> not O(n)。
	// 用桶排序
	
    // 如果是平均分布，则桶的数目和元素的数目相同，则每个桶里有一个数，其排序的时间复杂度是0(n)
	// {1,3,5,7,9}  (9-1)/(5-1) = 2
	// 4 buckets:  [1,3) [3,5) [5,7) [7,+inf)
     
	// 而若某个桶里有两个以上的num时，这时必有至少一个是空桶，那么最大间隔可能就落在空桶的相邻两个桶存储的数之间，
	// 最大间隔不会落在同一个桶的数里，因此我们不需要对每个桶再排一次序，只需要记录同一个桶的最大值和最小值，
	// 算出前一个有最大值的桶和后一个有最小值的桶之差，则可能是最大间隔
	
    //步骤：
	// 1. 算好用的桶的个数，用最大元素和最小元素算出平均间隔，记录在平均间隔上的最大值和最小值，	
    // 2. 再算出前一个间隔里的最大值和后一个间隔里的最小值之差，取最大的一个，
    // 3. 再算出最小值和第二小的差（平均间隔最小值第一个），最大值和第二大（平均间隔最大值最后一个）的差，三个值相比，取最大的，就是最大间隔
	public int maximumGap(int[] num) {
        if(num.length < 2) return 0;
        // 1. 算出平均间隔用的桶数：用最大值和最小值之差除以桶数
        // 时间复杂度是0(n)        
        int min = num[0];
        int max = num[0];
        for(int i : num){
            min = Math.min(min,i);
            max = Math.max(max,i);
        }
        int numBucket = num.length - 1;
        int avgGap = (int)Math.ceil((double)(max - min)/numBucket);
        numBucket++; 			/////////////////// [1,10000000]
        // 2. 记录每个桶的最大值和最小值
        int[] bucketsMIN = new int[numBucket];
        int[] bucketsMAX = new int[numBucket];
        Arrays.fill(bucketsMIN, Integer.MAX_VALUE);
        Arrays.fill(bucketsMAX, Integer.MIN_VALUE);
        for(int i : num){
        	int bucketIndex = (i-min)/avgGap;
        	bucketsMIN[bucketIndex] = Math.min(i, bucketsMIN[bucketIndex]);
        	bucketsMAX[bucketIndex] = Math.min(i, bucketsMAX[bucketIndex]);
        }
        
        // 3. 算出最大间隔
        int maxGap = 0;
        int prev = Integer.MAX_VALUE;
        for(int i = 0; i < numBucket; i++){
        	if( bucketsMIN[i] != Integer.MAX_VALUE) {
        		maxGap = Math.max(maxGap, bucketsMIN[i] - prev);
        	}
        	if( bucketsMAX[i] != Integer.MIN_VALUE){
        		prev = bucketsMAX[i];
        	}
        }
        return maxGap;
	}
	
	
}
