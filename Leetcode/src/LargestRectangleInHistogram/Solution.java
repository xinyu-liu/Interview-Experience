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
���������������stack��һ��stack����߶ȣ���һ������index
����height���飬
1 ���stackΪ�ջ��ߵ�ǰԪ�صĸ߶ȴ���height stack��Ԫ�أ�ǰһ��Ԫ�أ��ĸ߶� => �ѵ�ǰ�߶ȶ�index�ֱ���ӵ�����stack��
2 �����ǰԪ�صĸ߶ȵ���height stack��Ԫ�صĸ߶� => ʲô������
3 �����ǰԪ�صĸ߶�С��height stack��Ԫ�صĸ߶� => ������ջֱ����ǰԪ�صĸ߶ȴ���ջ��Ԫ�أ���ÿ�ζ����������height * ��current index - popped index���������������������ѵ�ǰ�߶Ⱥ����һ��������index���ǵ�ǰindex�� ����ѹ��ջ��
4 ������height���飬���stack�ǿգ���һһ��ջ�����������


���һ����ߣ�һ����ͣ�û�й��򡣵�����������Ҹ߶ȵ�����
��ôֻҪ�����Լ���(n-j)*height[j]�Ϳ��ԣ�һ��n�ξͿ�����ɡ�
��ô��ô��ʹ���ҵ����أ������ұ�X�����С�ˣ�������߱����ߵĳ�������������������
Ȼ�����Щ�ߵĸ�ȥ�����ٰ�X�Ǹ��Ž�ȥ�����ǵ����������ˡ�

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
