package MinCostToMakeHElemEqual;

import java.util.Arrays;

/*
Given an array of elements. We can perform following operation only- Increase an array element. 
Cost of operation is the amount of increment made per array element. 
Find the minimum cost to make any one H ( not necessarily consecutive ) elements of array equal.

E.g.
N=6, H=4
2 3 5 6 4 4
changes to -> 4 4 5 6 4 4
Cost is ( 4-2 + 4-3 = 3 )

N=6, H=3
2 3 5 6 4 4
changes to -> 2 4 5 6 4 4
Cost is ( 4-3 = 1 )
Optimal complexity- O(N) assuming input array is sorted.   else O(nlogn)

Hint:
input in sorted order
use Sliding Window approach with window size of H. 
Use some preprocessing to get O(1) cost for each window. Solution-minimal cost amongst all windows.

E.g.: 
N=6, H=4

2 3 5 6 4 4
assuming already sorted so i/p changes to
2 3 4 4 5 6

window 1- ( 2 3 4 4 )
minimum cost for ( 4 4 4 4 ) is ( 4-2 + 4-3 = 3 )

window 2- ( 3 4 4 5 )
minimum cost for ( 5 5 5 5 ) is ( 5-3 + 5-4 + 5-4 = 4 )

window 3- ( 4 4 5 6 )
minimum cost for ( 6 6 6 6 ) is ( 6-4 + 6-4 + 6-5 = 5 )

So minimum cost of operation is for window ( 2 3 4 4 ) with cost = 3

This processing needs to be done in O(N)
 */
public class MinCostToMakeHElemEqual {
	public int minCost(int[] arr, int H){
		if(H < 2) return 0;
		Arrays.sort(arr);
		int minCost = Integer.MAX_VALUE;
		int r = arr.length - 1;
		
		int prevT = arr[r];
		int prevSum = 0;
		// init
		for(int i = 0; i < H; i++){
			prevSum += (prevT - arr[r-i]);
		}
		minCost = Math.min(minCost, prevSum);
		
		int l = r - H;
		for(r = r - 1; l >= 0;l--, r--){
			// calc currrent
			int target = arr[r];
			int sum = prevSum - (prevT - target) * (H-1) + (target - arr[l]);
			// update 
			prevT = target;
			prevSum = sum;
			minCost = Math.min(minCost, prevSum);
		}
		return minCost;
	}
	public static void main(String[] args) {
		MinCostToMakeHElemEqual sol = new MinCostToMakeHElemEqual();
		int[] arr = {2, 3, 5, 6, 4, 4};
		System.out.println( sol.minCost(arr, 3) );
	}
}
