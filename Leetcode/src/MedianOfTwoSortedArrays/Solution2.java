package MedianOfTwoSortedArrays;

public class Solution2 {
    public double findMedianSortedArrays(int A[], int B[]) {
        int m = A.length;
        int n = B.length;
        int t = m + n;
        if(t == 1) return m == 1 ? A[0]:B[0];
        if(t == 2) {
            if(m == 2) return ((double)A[0]+(double)A[1])/2.0;
            if(n == 2) return ((double)B[0]+(double)B[1])/2.0;
            if(m == 1) return ((double)A[0]+(double)B[0])/2.0;
        }
        if(t % 2 == 1){
            return findKth(A,0,m-1, B,0,n-1, t/2+1);
        }
        else{
            return ( findKth(A,0,m-1, B,0,n-1, t/2) + findKth(A,0,m-1, B,0,n-1, t/2+1) ) / 2.0;
        }
    }
    private double findKth(int A[],int l1,int r1, int B[],int l2,int r2, int k){
        int len1 = r1 - l1 + 1;
        int len2 = r2 - l2 + 1;
        if(len1 <= 0) return B[l2 + k - 1];/////////l2 + k - 1
        if(len2 <= 0) return A[l1 + k - 1];/////////l1 + k - 1
        if(k == 1) return Math.min(A[l1], B[l2]);
        
        int m1 = (l1+r1)/2;
        int m2 = (l2+r2)/2;
        if(A[m1] > B[m2]) return findKth(B,l2,r2, A,l1,r1, k);
        
        int t = (m1-l1) + (m2-l2) + 1;
        if(k > t) return findKth(A,m1+1,r1, B,l2,r2, k-(m1-l1)-1);
        else return findKth(A,l1,r1, B,l2,m2-1, k);
    }
}