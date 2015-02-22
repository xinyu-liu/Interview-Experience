package FindPeakElement;
/*
 * Given an array of integers. Find a peak element in it. An array element is peak if it is NOT smaller than its neighbors. 
 * For corner elements, we need to consider only one neighbor. 
 * For example, for input array {5, 10, 20, 15}, 20 is the only peak element. 
 * For input array {10, 20, 15, 2, 23, 90, 67}, there are two peak elements: 20 and 90. 
 * Note that we need to return any one peak element.

Following corner cases give better idea about the problem.
1) If input array is sorted in strictly increasing order, the last element is always a peak element. 
	For example, 50 is peak element in {10, 20, 30, 40, 50}.
2) If input array is sorted in strictly decreasing order, the first element is always a peak element. 
	100 is the peak element in {100, 80, 60, 50, 20}.
3) If 3 elements of input array are same, any of them can be a peak element.

It is clear from above examples that there is always a peak element in input array in any input array.

Simple solution: linear scan - O(n)

Divide and Conquer - Binary Search - O(Logn) 
Compare middle element with its neighbors
If middle element is greater than both of its neighbors, then we return it. 
If the middle element is smaller than the its left neighbor, then there is always a peak in left half 
If the middle element is smaller than the its right neighbor, then there is always a peak in right half

 */
public class PeakInAnyArray {
	public int findMax(int[] arr){
		int l = 0;
		int r = arr.length - 1;
		while(l < r){
			int mid = (l+r)/2;
			if( (mid == arr.length - 1 || arr[mid] > arr[mid+1])  // >=
			 && (mid == 0 || arr[mid-1] < arr[mid]) ){ // <=
				return arr[mid];
			}
			else if(arr[mid] < arr[mid+1] ){
				l = mid + 1;
			}
			else r = mid - 1;
		}
		return arr[l];
	}
	public static void main(String[] args) {
		// int[] arr = {8, 10, 20, 80, 100, 200, 400, 500, 3, 2, 1};
		// Output: 500

		int[] arr = {1, 1, 1, 1, 1, 1, 2};
		// Output: 50

		//int[] arr = {10, 20, 30, 40, 50};
		// Output: 50
		// int[] arr = {120, 100, 80, 20, 0};
		// Output: 120
		PeakInAnyArray sol = new PeakInAnyArray();
		System.out.println( sol.findMax(arr) );
	}

}
