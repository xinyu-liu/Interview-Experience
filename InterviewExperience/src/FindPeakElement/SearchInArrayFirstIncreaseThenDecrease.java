package FindPeakElement;
/*
 * You are given an array as an input. The array is organized in such a way that its element are arranged 
 * in increasing order up till a certain index and in decreasing order after that.
 * Write an algorithm to search an element in such a array.
 */
public class SearchInArrayFirstIncreaseThenDecrease {
	public int search(int[] arr, int target){
		int peak = findMax(arr);
		int ans = searchInRange(arr, target, 0, peak, true);
		if(ans != -1) return ans;
		else return searchInRange(arr, target, peak + 1, arr.length - 1, false);
	}
	private int searchInRange(int[] arr, int target, int l, int r, boolean isIncreasing){
		if(l >= arr.length || r >= arr.length || l < 0 || r < 0) return -1;
		
		while(l < r){
			int mid = (l+r)/2;
			if(arr[mid] == target) return mid;
			if(isIncreasing){
				if(arr[mid] < target) l = mid + 1;
				else r = mid - 1;
			}
			else{
				if(arr[mid] < target) r = mid - 1;
				else l = mid + 1;
			}
			
		}
		return arr[l] == target ? l : -1;
	}
	private int findMax(int[] arr){
		int l = 0;
		int r = arr.length - 1;
		while(l < r){
			int mid = (l+r)/2;
			if( (mid == arr.length - 1 || arr[mid] > arr[mid+1]) 
			 && (mid == 0 || arr[mid-1] < arr[mid]) ){
				return mid;
			}
			else if(arr[mid-1] < arr[mid] && arr[mid] < arr[mid+1] ){
				l = mid + 1;
			}
			else r = mid - 1;
		}
		return l;
	}
	public static void main(String[] args) {
		// int[] arr = {8, 10, 20, 80, 100, 200, 400, 500, 3, 2, 1};
		// Output: 500

		// int[] arr = {1, 3, 50, 10, 9, 7, 6};
		// Output: 50

		// int[] arr = {10, 20, 30, 40, 50};
		// Output: 50
		 int[] arr = {120, 100, 80, 20, 0};
		// Output: 120
		SearchInArrayFirstIncreaseThenDecrease sol = new SearchInArrayFirstIncreaseThenDecrease();
		System.out.println( sol.search(arr, -4) );
	}

}
