package AlternatePosNeg;

import java.util.Arrays; 

public class AlternatePosNeg {
	// in O(n) time and O(1) extra space
	
	// CASE 1 : ORDER MATTERS   http://www.geeksforgeeks.org/rearrange-array-alternating-positive-negative-items-o1-extra-space/
	// CASE 2 : ORDER NOT MATTERS  http://www.geeksforgeeks.org/rearrange-positive-and-negative-numbers-publish/
	public void noOrder(int[] arr){
		int w = 0;
		while(w < arr.length){
			if(isValid(arr[w], w)){
				w++;
			}
			else{
				boolean findNeg = false;
				if(arr[w] >= 0) findNeg = true;
				int r;
				for(r = w+1; r < arr.length; r++){ ////////////////w r cannot go back !!!! r = w+1 make r back -> O(n2) WRONG
					if(findNeg){
						if(arr[r] < 0) break;
					}
					else{
						if(arr[r] >= 0) break;
					}
				}
				if(r == arr.length) w = arr.length;
				else swap(arr, w, r);
				
				w += 2;
 			}
		}
	}
	private boolean isValid(int num, int i){
		if ( (num >= 0 && i % 2 == 0) || (num < 0 && i % 2 == 1) ) return true;
		else return false;
	}
	private void swap(int[] arr, int i, int j){
		int t = arr[i];
		arr[i] = arr[j];
		arr[j] = t;
	}

	public static void main (String[] args) {
		AlternatePosNeg sol = new AlternatePosNeg();
		int[] p = {-2, 3, 4, 5, -1, -6, 7, 9, 1};
		System.out.println(	Arrays.toString(p) );
		// result - 3 -2 4 -1 5 -6 7 9 1.
		sol.noOrder(p);
		System.out.println(	Arrays.toString(p) );
		// System.out.println(i);
		
	}
}
