package SingleNumber;

public class Solution {
	// I
    public int singleNumberI(int[] A) {
    	int ans = 0;
        for (int i = 0; i < A.length; i++){
        	ans ^= A[i];
        }
        return ans;
    }
    // II 
    // ����һ������Ϊ32������a��a[i]��ʾ����������iλ���ֵĴ���������a[i]��3��������������ԣ�����ͰѸ�λȡ������ɴ𰸡��ռ临�Ӷ�O(1).
    public int singleNumber(int[] A) {
        int[] count = new int[32];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < 32; j++) {
                count[j] += (A[i] & (1 << j)) == 0 ? 0 : 1;
            }
        }
        int res = 0;
        for (int i = 0; i < 32; i++) {
            if (count[i] % 3 != 0) {
                res |= 1 << i;
            }
        }
        return res;
    }

    // old ??????????
    public int singleNumberII(int[] A) {
    	int one = 0;
    	int two = 0;
        for (int i = 0; i < A.length; i++){
        	two ^= (A[i] & one); //  1 -> two+1
        	one ^= A[i];
        	int is3 = one & two;
        	one &= (~is3);
        	two &= (~is3);
        }
        return one;
    }
    
}
