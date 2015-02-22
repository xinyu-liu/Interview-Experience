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
    // 创建一个长度为32的数组a，a[i]表示所有数字在i位出现的次数。假如a[i]是3的整数倍，则忽略；否则就把该位取出来组成答案。空间复杂度O(1).
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
