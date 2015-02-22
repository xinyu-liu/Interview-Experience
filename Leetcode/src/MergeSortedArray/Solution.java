package MergeSortedArray;

public class Solution {
	// 解法一：从前往后，小的排最前。每次插入一个B，A需要整体后移。(略)
	// 解法二：从后往前，大的排最后。不需要多余的移动。(见下)
    public void merge(int A[], int m, int B[], int n) {
        int a = m - 1;
        int b = n - 1;
        m = m + n;
        int c = m + n - 1;
        while(a>=0 && b>=0){
        	if(A[a] > B[b]) A[c--] = A[a--];       
        	else A[c--] = B[b--];
        }
        while(a>=0){
        	A[c--] = A[a--];  
        }
        while(b>=0){
        	A[c--] = B[b--];  
        }
    }
}
