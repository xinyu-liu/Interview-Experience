package ContainerWithMostWater;

public class Solution {
	// O(n) ˫ָ�����������̰�ЧӦ

	// ��Ϊ�̰�ЧӦ������ֻҪ��һ��̰壬�����ٳ�Ҳû�ã�  
    // ���Զ��ڶ̰�ָ�룬ҪѰ����һ���  
	
	/*
	 * 1 ��Ŀ�������������ر������˴���������Ŀ֮��
2 ��������Ŀ֮�����������ˮͰֻ�� 1. ������Ԫ�ص���С���Ǹ� 2. ������Ԫ�ص������ֵ�йء�
3 ����Ԫ��ͬ����С����ô����ʱ����ѡȡ��Զ���������ꡣ
4 ������ͬ��ʱ�򣬿�������������ӽ����滻��С���Ǹ��ߡ������ǲ����п��ܲ���һ��������ߵ�ˮͰ��
5 ������ͬʱ���м��ƶ���ֻ�����������ߵĸ˵�ʱ���ڽ��м��㣬��Ϊ��ʹ��ͬ�ĸ˳������������ݻ�Ҳ����١�
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
