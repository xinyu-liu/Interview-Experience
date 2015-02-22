package MaximumSubarray;

public class Solution {
	/*
	 * 
���֮ǰSubArray������ʹ���0�Ļ������ǿ�����Ϊ��Ժ����������й��׵ġ��������������ѡ�����֮ǰ��SubArray

���֮ǰSubArray�������Ϊ0����С��0�Ļ������ǿ�����Ϊ��Ժ���������û�й��ף��������к��ģ�С��0ʱ�����������������ֻ��ѡ����������ֿ�ʼ������һ��SubArray

��������㣬����ͺܺ�д��, sum��¼֮ǰSubArray�ĺͣ�max�����������ֵ����sum��ֵ����maxʱ��˵�����ֺ͸����SubArray���У���ʱ����max��ֵ��
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
