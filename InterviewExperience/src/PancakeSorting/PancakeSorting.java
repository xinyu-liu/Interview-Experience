package PancakeSorting;
/*
 * http://www.geeksforgeeks.org/pancake-sorting/
 * 
 * Unlike a traditional sorting algorithm, which attempts to sort with the fewest comparisons possible,
 * the goal is to sort the sequence in as few reversals as possible.
 * 
 * Total O(n) flip operations are performed in above code. The overall time complexity is O(n^2).
 * 
 * NOTE: Instead of finding max element and then calling flip two times, 
 *       find min element and call flip only once and It will work !
 */
public class PancakeSorting {
	// Reverse array from 0 to i 
	private void flip(int[] arr, int e){
		int l = 0;
		while(l < e){
			int t = arr[e];
			arr[e] = arr[l];
			arr[l] = t;
			l++; e--;
		}
	}
	// find max index of the arr from 0 to e (inclusive)
	private int findMax(int[] arr, int e){
		int index = 0;
		int value = arr[0];
		for(int i = 1; i <= e; i++){
			if(arr[i] > value) {
				value = arr[i];
				index = i;
			}
		}
		return index;
	}
	public void sort(int[] arr){
		for(int i = arr.length - 1; i > 0; i--){
			int maxPos = findMax(arr, i);
			
			if(maxPos != i){ /////////optimal - if the max is at the end of current arr, no need to flip twice
				flip(arr, maxPos);
				flip(arr, i);
			}
			
		}
	}
	public static void main(String[] args) {
		int[] arr = {23, 10, 20, 11, 12, 6, 7};
		PancakeSorting sol = new PancakeSorting();
		printArr(arr);
		sol.sort(arr);
		printArr(arr);
	}
	private static void printArr(int[] arr){
		for(int i : arr){
			System.out.print(i + " ");
		}
		System.out.println();
	}

}
