package SearchInsertPosition;

public class Solution {
	// web & mine both use binary search
	// web better
    public int searchInsert(int[] A, int target) {
        int low = 0;
        int high = A.length - 1;
        int mid = (low+high) / 2;
        
        while(low <= high){
            if(A[mid] == target)    return mid;
            else if(A[mid] > target){
                high = mid-1;
                mid = (low+high)/2;
            }
            else{
                low = mid+1;
                mid = (low+high)/2;
            }
        }
        return low;
    }
	// mine
    public int searchInsert1(int[] A, int target) {
        int start = 0;
        int end = A.length-1;
        while(end - start > 1){
        	int mid = (start+end) / 2;
	        if(target == A[mid]){
	        	return mid;
	        }
	        else if(target < A[mid]){
	        	end = mid;
	        }
	        else{
	        	start = mid;
	        }
        }        
        if(target <= A[start]){
        	return start;
        }
        else if(target <= A[end]){
        	return end;
        }
        else{
        	return end+1;
        }
        
    }
}
