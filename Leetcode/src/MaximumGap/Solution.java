package MaximumGap;

import java.util.Arrays;

public class Solution {
	// Ϊ������O(n)���Ӷȣ����Լ������򣬵���{1,100000} -> not O(n)��
	// ��Ͱ����
	
    // �����ƽ���ֲ�����Ͱ����Ŀ��Ԫ�ص���Ŀ��ͬ����ÿ��Ͱ����һ�������������ʱ�临�Ӷ���0(n)
	// {1,3,5,7,9}  (9-1)/(5-1) = 2
	// 4 buckets:  [1,3) [3,5) [5,7) [7,+inf)
     
	// ����ĳ��Ͱ�����������ϵ�numʱ����ʱ��������һ���ǿ�Ͱ����ô��������ܾ����ڿ�Ͱ����������Ͱ�洢����֮�䣬
	// �������������ͬһ��Ͱ�����������ǲ���Ҫ��ÿ��Ͱ����һ����ֻ��Ҫ��¼ͬһ��Ͱ�����ֵ����Сֵ��
	// ���ǰһ�������ֵ��Ͱ�ͺ�һ������Сֵ��Ͱ֮�������������
	
    //���裺
	// 1. ����õ�Ͱ�ĸ����������Ԫ�غ���СԪ�����ƽ���������¼��ƽ������ϵ����ֵ����Сֵ��	
    // 2. �����ǰһ�����������ֵ�ͺ�һ����������Сֵ֮�ȡ����һ����
    // 3. �������Сֵ�͵ڶ�С�Ĳƽ�������Сֵ��һ���������ֵ�͵ڶ���ƽ��������ֵ���һ�����Ĳ����ֵ��ȣ�ȡ���ģ����������
	public int maximumGap(int[] num) {
        if(num.length < 2) return 0;
        // 1. ���ƽ������õ�Ͱ���������ֵ����Сֵ֮�����Ͱ��
        // ʱ�临�Ӷ���0(n)        
        int min = num[0];
        int max = num[0];
        for(int i : num){
            min = Math.min(min,i);
            max = Math.max(max,i);
        }
        int numBucket = num.length - 1;
        int avgGap = (int)Math.ceil((double)(max - min)/numBucket);
        numBucket++; 			/////////////////// [1,10000000]
        // 2. ��¼ÿ��Ͱ�����ֵ����Сֵ
        int[] bucketsMIN = new int[numBucket];
        int[] bucketsMAX = new int[numBucket];
        Arrays.fill(bucketsMIN, Integer.MAX_VALUE);
        Arrays.fill(bucketsMAX, Integer.MIN_VALUE);
        for(int i : num){
        	int bucketIndex = (i-min)/avgGap;
        	bucketsMIN[bucketIndex] = Math.min(i, bucketsMIN[bucketIndex]);
        	bucketsMAX[bucketIndex] = Math.min(i, bucketsMAX[bucketIndex]);
        }
        
        // 3. ��������
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
