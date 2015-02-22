package TrappingRainWater;

public class Solution {
	/*
	 * ��������ĳ��ֵA[i]��˵����trapped������waterȡ������i֮ǰ��ߵ�ֵleftMostHeight[i]����i�ұߵ�
	 * ��ߵ�ֵrightMostHeight[i]����������������
	 * ���min(left,right) > A[i]����ô��i���λ������trapped��water����min(left,right) - A[i]��
	 * ��һ������Ҽ�������leftMostHeight���ڶ�����ҵ������rightMostHeight��ʱ�临�Ӷ���O(n)��
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
