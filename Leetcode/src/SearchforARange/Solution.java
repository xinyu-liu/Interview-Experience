package SearchforARange;

public class Solution {
    public int[] searchRange(int[] A, int target) {
        int[] ans = new int[2];
        ans[0] = findLeft(A, target);
        ans[1] = ans[0] == -1 ? -1: findRight(A, target);
        return ans;
    }
    private int findRight(int[] A, int target){
        int l = 0; 
        int r = A.length - 1;
        while(l < r){
            int mid = (l+r)/2;
            if(A[mid] == target){
                if(mid == A.length - 1 || A[mid+1] != target){
                    return mid;
                }
                else{ 
                    l = mid + 1;
                }
            }
            else if(A[mid] < target){
                l = mid + 1;
            }
            else r = mid - 1;
        }
        if( l == r && target == A[l]) return l;
        return -1;
    }
    private int findLeft(int[] A, int target){
        int l = 0; 
        int r = A.length - 1;
        while(l < r){
            int mid = (l+r)/2;
            if(A[mid] == target){
                if(mid == 0 || A[mid-1] != target){
                    return mid;
                }
                else{
                    r = mid - 1;
                }
            }
            else if(A[mid] < target){
                l = mid + 1;
            }
            else r = mid - 1;
        }
        if( l == r && target == A[l]) return l;
        return -1;
    }
}