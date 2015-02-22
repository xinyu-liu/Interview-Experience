package MaxJISuchThatArrjGreaterThanArri;
/*
 * In an array of integers, 
 * find out maximum value of (j-i) such that A[j]>a[i] in O(N) time.
 * 
 * two optimum indexes of arr[]: left index i and right index j. 
 * For an element arr[i], we do not need to consider arr[i] for left index if there is an element smaller than arr[i] on left side of arr[i]. 
 * Similarly, if there is a greater element on right side of arr[j] then we do not need to consider this j for right index. 
 * So we construct two auxiliary arrays LMin[] and RMax[] such that LMin[i] holds the smallest element on left side of arr[i] including arr[i], 
 * and RMax[j] holds the greatest element on right side of arr[j] including arr[j]. 
 * 
 * After constructing these two auxiliary arrays, we traverse both of these arrays from left to right. 
 * While traversing LMin[] and RMax[] 
 * if we see that LMin[i] is greater than RMax[j], then we must move ahead in LMin[] (or do i++) because all elements on left of LMin[i] are greater than or equal to LMin[i]. 
 * Otherwise we must move ahead in RMax[j] to look for a greater j - i value.
 * 
 */
public class MaxJ_ISuchThatArrjGreaterThanArri {
	public int solve(int[] arr){
		int m = arr.length;
		if(m < 2) return 0;
		
		int dist = 0;
		
		int[] lmin = new int[m];
		int[] rmax = new int[m];
		/* Construct LMin[] such that LMin[i] stores the minimum value from (arr[0], arr[1], ... arr[i]) */
		lmin[0] = arr[0];
		for(int i = 1; i < m; i++){
			lmin[i] = Math.min(lmin[i-1], arr[i]);
		}
		/* Construct RMax[] such that RMax[j] stores the maximum value from (arr[j], arr[j+1], ..arr[n-1]) */
		rmax[m-1] = arr[m-1];
		for(int i = m-2; i >= 0; i--){
			rmax[i] = Math.max(rmax[i+1], arr[i]);
		}
		
		int l = 0;
		int r = 0;
		while(l < m && r < m){
			/*
			// move right
			while(r < m && lmin[l] < rmax[r]){
				r++;
			}
			dist = Math.max(dist, r-l-1);
			// move left
			l++;
			while(l < m && r < m && lmin[l] >= rmax[r]){
				l++;
			}
			*/
			if(lmin[l] < rmax[r]){
				dist = Math.max(dist, r-l);
				r++;
			}
			else{
				l++;
			}
		}
		return dist;
		
	}
	public static void main(String[] args) {
		MaxJ_ISuchThatArrjGreaterThanArri sol = new MaxJ_ISuchThatArrjGreaterThanArri();
		int[] arr1 = {34, 8, 10, 3, 2, 80, 30, 33, 1};
		System.out.println( sol.solve(arr1) );
		//  Output: 6  (j = 7, i = 1)

		int[] arr2 = {9, 2, 3, 4, 5, 6, 7, 8, 18, 0};
		System.out.println( sol.solve(arr2) );
		//  Output: 8 ( j = 8, i = 0)

		int[] arr3 = {1, 2, 3, 4, 5, 6};
		System.out.println( sol.solve(arr3) );
		//  Output: 5  (j = 5, i = 0)

		int[] arr4 = {6, 5, 4, 3, 2, 1};
		System.out.println( sol.solve(arr4) );
		//  Output: -1 

	}

}
