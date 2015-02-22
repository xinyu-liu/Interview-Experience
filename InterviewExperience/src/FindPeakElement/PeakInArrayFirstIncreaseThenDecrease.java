package FindPeakElement;
/*
 * Given an array of integers which is initially increasing and then decreasing, 
 * find the maximum value in the array.

Input: arr[] = {8, 10, 20, 80, 100, 200, 400, 500, 3, 2, 1}
Output: 500

Input: arr[] = {1, 3, 50, 10, 9, 7, 6}
Output: 50

Corner case (No decreasing part)
Input: arr[] = {10, 20, 30, 40, 50}
Output: 50

Corner case (No increasing part)
Input: arr[] = {120, 100, 80, 20, 0}
Output: 120

Method 1 (Linear Search)    	O(n)
Traverse the array and keep track of maximum and element. And finally return the maximum element.

***** Method 2 (Binary Search)  O(Logn)
i)   If the mid element is greater than both of its adjacent elements, then mid is the maximum.
ii)  If mid element is greater than its next element and smaller than the previous element 
     then maximum lies on left side of mid. Example array: {3, 50, 10, 9, 7, 6}
iii) If mid element is smaller than its next element and greater than the previous element 
     then maximum lies on right side of mid. Example array: {2, 4, 6, 8, 10, 3, 1}

This method works only for distinct numbers. For example, it will 
not work for an array like {0, 1, 1, 2, 2, 2, 2, 2, 3, 4, 4, 5, 3, 3, 2, 2, 1, 1}.
 */

public class PeakInArrayFirstIncreaseThenDecrease {
	public int findMax(int[] arr){
		int l = 0;
		int r = arr.length - 1;
		while(l < r){
			int mid = (l+r)/2;
			if( (mid == arr.length - 1 || arr[mid] > arr[mid+1]) 
			 && (mid == 0 || arr[mid-1] < arr[mid]) ){
				return arr[mid];
			}
			else if(arr[mid-1] < arr[mid] && arr[mid] < arr[mid+1] ){
				l = mid + 1;
			}
			else r = mid - 1;
		}
		return arr[l];
	}
	public static void main(String[] args) {
		// int[] arr = {8, 10, 20, 80, 100, 200, 400, 500, 3, 2, 1};
		// Output: 500

		int[] arr = {1, 3, 50, 10, 9, 7, 6};
		// Output: 50

		// int[] arr = {10, 20, 30, 40, 50};
		// Output: 50
		// int[] arr = {120, 100, 80, 20, 0};
		// Output: 120
		PeakInArrayFirstIncreaseThenDecrease sol = new PeakInArrayFirstIncreaseThenDecrease();
		System.out.println( sol.findMax(arr) );
	}

}
