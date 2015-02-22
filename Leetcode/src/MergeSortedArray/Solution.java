package MergeSortedArray;

public class Solution {
	// �ⷨһ����ǰ����С������ǰ��ÿ�β���һ��B��A��Ҫ������ơ�(��)
	// �ⷨ�����Ӻ���ǰ���������󡣲���Ҫ������ƶ���(����)
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
