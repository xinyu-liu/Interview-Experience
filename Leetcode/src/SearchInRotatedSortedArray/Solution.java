package SearchInRotatedSortedArray;

public class Solution {
	// II
	// WEB
	public boolean searchIIW(int[] A, int target) {
		int n = A.length;
	    int l = 0, r = n - 1;
	    while (l <= r) {
	        int m = l + (r - l)/2;
	        if (A[m] == target) return true; //return m in Search in Rotated Array I
	        if (A[l] < A[m]) { //left half is sorted
	            if (A[l] <= target && target < A[m])
	                r = m - 1;
	            else
	                l = m + 1;
	        } else if (A[l] > A[m]) { //right half is sorted
	            if (A[m] < target && target <= A[r])
	                l = m + 1;
	            else
	                r = m - 1;
	        } else l++;
	    }
	    return false;
	}
	// MINE
    public boolean searchIIM(int[] A, int target) {
        int l = 0; 
        int r = A.length - 1;
        while(l < r){
            int mid = (l+r) / 2;
            if(A[mid] == target) return true;
            if(A[l] == A[mid] && A[r] == A[mid]){
                while(++l < A.length && A[l]==A[r]){}
            }
            else if(  
            (A[l] < A[mid]  && target < A[mid] && target >= A[l])
               ||
            (A[l] > A[mid] && (target < A[mid] || target >= A[l]))){
                    r = mid - 1; 
            }
            else l = mid + 1;
        }
        if(l==r &&A[l] == target) return true;
        return false;
    }
	// I
    public int searchIM(int[] A, int target) {
        int l = 0;
        int r = A.length - 1;
        while(l < r){
            int mid = (l+r)/2;
            if(A[mid] == target) return mid;
            if(  
            (A[l] < A[mid]  && target < A[mid] && target >= A[l])
               ||
            (A[l] > A[mid] && (target < A[mid] || target >= A[l]))){
                    r = mid - 1; 
            }
            else l = mid + 1;
        }
        if(l == r && A[l] == target) return l;
        return -1;
    }
}
