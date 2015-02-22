package NumberOfPossibleTriangles;

import java.util.Arrays;

/*
Given an array with lengths, you have to select 3 lengths (a, b and c) for a triangle such that it satisfies condition a+b>c,b+c>a, a+c>b. Find the number of possible triangles can be created from the given array.
ex: 3 5 6 9 10

(3,9,10), (3 5 6), (5 6 10), (5 9 10), (5 6 9), (6 9 10)
so number of possible triangles is 6

 */
public class NumberOfPossibleTriangles {
	// tricky way -> O(n2)
	/*
	 * we can use the previous value of ¡®k¡¯. The reason is simple, if we know that 
	 * the value of ¡®arr[i] + arr[j-1]¡¯ is greater than ¡®arr[k]¡¯, then we can say 
	 * ¡®arr[i] + arr[j]¡¯ will also be greater than ¡®arr[k]¡¯, because the array is
	 *  sorted in increasing order.
	 */
	public int numberOfPossibleTriangles(int[] arr){
		int ans = 0;
		Arrays.sort(arr);
		for(int i = 0; i < arr.length - 2; i++){
			int k = i+2;
			for(int j = i+1; j < arr.length - 1; j++){
				
				while( k < arr.length && arr[i] + arr[j] > arr[k]){
					// k will always be greater than j. If j becomes equal to k, then
		            // this loop will increment k, because arr[k] + arr[i] is always
		            // greater than arr[k]
					k++;	
				}
				// Total number of possible triangles that can be formed
	            // with the two fixed elements is k - j - 1.  
				ans += (k-j-1);
				
			}
		}
		return ans;
	}
	public static void main(String[] args) {
		int[] arr = {3,5,6,9,10};
		NumberOfPossibleTriangles sol = new NumberOfPossibleTriangles();
		System.out.print(sol.numberOfPossibleTriangles(arr));
	}

}
