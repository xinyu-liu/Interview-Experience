package ContainerWithMostWater;

public class Solution {
	// O(n) 双指针计算面积，短板效应

	// 因为短板效应，所以只要有一块短板，其他再长也没用，  
    // 所以对于短板指针，要寻找下一块板  
	
	/*
	 * 1 题目很容易理解错误，特别是做了大量这类题目之后。
2 理解清楚题目之后，明白任意个水桶只和 1. 这两个元素的最小的那个 2. 这两个元素的坐标差值有关。
3 假设元素同样大小，那么最多的时候，是选取最远的两个坐标。
4 当不相同的时候，可以慢慢把坐标接近，替换最小的那个边。看看是不是有可能产生一个更大更高的水桶。
5 从两边同时向中间移动，只有在遇到更高的杆的时候在进行计算，因为即使相同的杆长，距离缩短容积也会减少。
	 */
    public int maxArea(int[] height) {
        int s = 0;
        int e = height.length-1;
        int max = 0;
        int prevH = 0;
        while(s < e){
        	int h = Math.min(height[s], height[e]);
        	if(h > prevH)
        		max = Math.max(max, h*(e-s));
        	prevH = h;
        	if(height[s] < height[e])
        		s++;
        	else e--;
        }
        return max;
    }
}
