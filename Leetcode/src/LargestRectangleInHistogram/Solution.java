package LargestRectangleInHistogram;

import java.util.Stack;

public class Solution {
	/*
	 * O(n) O(n)
	 * 
	 *  Wrong Answer
	 * Input:	[2,1,2]
	 * Output:	2
	 * Expected:	3
	 * After pop val 2, push val 1, the index to push should be 0
	 * 
	 * NEED var iToPush
	 */
	
	/*
很巧妙的用了两个stack，一个stack保存高度，另一个保存index
遍历height数组，
1 如果stack为空或者当前元素的高度大于height stack顶元素（前一个元素）的高度 => 把当前高度额index分别添加到两个stack顶
2 如果当前元素的高度等于height stack顶元素的高度 => 什么都不做
3 如果当前元素的高度小于height stack顶元素的高度 => 持续弹栈直到当前元素的高度大于栈顶元素，并每次都计算面积（height * （current index - popped index）），保存最大面积。最后把当前高度和最后一个弹出的index（非当前index） 重新压入栈中
4 处理完height数组，如果stack非空，则一一弹栈并计算面积。


如果一会儿高，一会儿低，没有规则。但是如果从左到右高度递增，
那么只要计算以计算(n-j)*height[j]就可以，一共n次就可以完成。
那么怎么样使左到右递增呢？碰到右边X比左边小了，就让左边比他高的长方形面积都计算出来，
然后把这些高的给去掉，再把X那个放进去就又是递增的数组了。

	 */
	public int largestRectangleArea(int[] height) {
		int maxArea = 0;
		Stack<Integer> sValue = new Stack<Integer>();
		Stack<Integer> sIndex = new Stack<Integer>();
		for(int i = 0; i < height.length; i++){
			int val = height[i];
			int sVal = sValue.empty()? -1 : sValue.peek();
			
			int iToPush = i;///////////////////////////
			while(sVal > val){
				iToPush = sIndex.pop() ;/////////////////
				maxArea = Math.max(maxArea, ( i-iToPush) *  sValue.pop());
				sVal = sValue.empty()? -1 : sValue.peek();
			}
			
			if(sVal < val){
				sValue.push(val);
				sIndex.push(iToPush);
			}
		}
		while(!sValue.empty()){
			maxArea = Math.max(maxArea, 
					( height.length-sIndex.pop() ) * sValue.pop() 
					);
			
		}
		return maxArea;
	}
	/*
	 * O(vn) O(vn)
	 * Submission Result: Time Limit Exceeded
	 * Last executed input:	[0,0,0,0,0,0,0,0,2147483647]
	 */
    public int largestRectangleAreaW1(int[] height) {
        int ans = 0;
        int maxH = 0;
        for(int i = 0; i < height.length; i++){
        	maxH = Math.max(maxH, height[i]);
        }

        for(int h = 1; h <= maxH; h++){
            int count = 0;
            int maxCount = 0;
        	for(int i = 0; i < height.length; i++){
        		if(height[i] >= h) count++;
        		else{
        			maxCount = Math.max(maxCount, count);
        			count = 0;
        		}
        	}
        	ans = Math.max(ans, maxCount * h);
        }
        return ans;
    }
}
