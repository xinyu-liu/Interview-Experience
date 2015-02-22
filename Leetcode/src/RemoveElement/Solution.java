package RemoveElement;

public class Solution {
	// 解法四：最优美的解法，当遍历过程中遇到elem，就用末尾的元素来填补。这样甚至遍历不到一次。(not implemented)
	// 解法三：最naive的做法，设置一个新A数组的下标。遍历过程中遇到elem就跳过，否则就赋给新A数组下标对应元素。缺点是有多余的赋值。(see below)
    public int removeElement(int[] A, int elem) {
        int r = 0;
        for(int i = 0; i < A.length; i++){
        	if(A[i] != elem){
        		A[r++] = A[i];
        	}
        }
        return r;
    }
}
