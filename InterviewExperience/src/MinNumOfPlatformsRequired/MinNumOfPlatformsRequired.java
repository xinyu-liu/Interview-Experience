package MinNumOfPlatformsRequired;

import java.util.Arrays;
/*
 * http://www.geeksforgeeks.org/minimum-number-platforms-required-railwaybus-station/
 * 
Given arrival and departure times of ALL trains that reach A railway station, 
find the minimum number of platforms required for the railway station so that no train waits.
We are given two arrays which represent arrival and departure times of trains that stop

First array contains the arrival time of various trains on A particular station. 
Second array contains the departure time of those trains. 

Examples:

Input:  arr[]  = {9:00,  9:40, 9:50,  11:00, 15:00, 18:00}
        dep[]  = {9:10, 12:00, 11:20, 11:30, 19:00, 20:00}
Output: 3
There are at-most three trains at a time (time between 11:00 to 11:20)
*/

public class MinNumOfPlatformsRequired {
	/*
	Solution 1: BF 
	A Simple Solution is to take every interval one by one and find the number of intervals that overlap with it. 
	Keep track of maximum number of intervals that overlap with an interval. Finally return the maximum value. 
	Time Complexity of this solution is O(n2).
	*/
	public int findPlatformBF(int[] arr, int[] dep){
		int n = arr.length;
		int ans = 1;
		for(int i = 0; i < n; i++){ // fix one
			int count = 1;
			for(int j = 0; j < n; j++){
				if(i != j){
					if( !(dep[j] <= arr[i] || dep[i] <= arr[j]) ){
						count++;
					}
				}
			}
			ans = Math.max(ans, count);
		}
		return ans;
	}
	/*
	Solution 2: O(nLogn)
	consider all evens in sorted order. 
	Once we have all events in sorted order, we can trace the number of trains at any time keeping track of trains that have arrived, but not departed.

	For example consider the above example.

	    arr[]  = {9:00,  9:40, 9:50,  11:00, 15:00, 18:00}
	    dep[]  = {9:10, 12:00, 11:20, 11:30, 19:00, 20:00}

	All events sorted by time!
	Total platforms at any time can be obtained by subtracting total departures from total arrivals by that time.
	 Time     Event Type     Total Platforms Needed at this Time                               
	 9:00       Arrival                  1
	 9:10       Departure                0
	 9:40       Arrival                  1
	 9:50       Arrival                  2
	 11:00      Arrival                  3 
	 11:20      Departure                2
	 11:30      Departure                1
	 12:00      Departure                0
	 15:00      Arrival                  1
	 18:00      Arrival                  2 
	 19:00      Departure                1
	 20:00      Departure                0
	Minimum Platforms needed on railway station = Maximum platforms needed at any time  = 3  
	Note that the implementation doesn¡¯t create a single sorted list of all events, 
	Rather it individually sorts arr[] and dep[] arrays, and then uses merge process of merge sort to process them together as a single sorted array.
	
	Sort 2 arrays separately, dont care about their relationships. 
	Come one +1, leave one -1!
	
	 */
	public int findPlatform(int[] arr, int[] dep){
		int n = arr.length;
		int ans = 0;
		
		Arrays.sort(arr);
		Arrays.sort(dep);
		int a = 0;
		int d = 0;
		int cur = 0;
		while(a < n && d < n){
			if(arr[a] < dep[d]){
				cur++;
				a++;
				ans = Math.max(ans, cur);
			}
			else{ // arr[a] >= dep[d]
				cur--;
				d++;
			}
		}
		return ans;
	}
	public static void main(String[] args) {
	    int arr[] = {900, 940, 950, 1100, 1500, 1800};
	    int dep[] = {910, 1200, 1120, 1130, 1900, 2000};
	    MinNumOfPlatformsRequired sol = new MinNumOfPlatformsRequired();
	    System.out.println( sol.findPlatformBF(arr, dep) );
	    System.out.println( sol.findPlatform(arr, dep) );
	}
/*
Solution 3: use a hash a[0....2460] 
which is initially all zeros.
Now:
for 9:00 to 9:10
we can increment for a[900] to a[910]
similarly a[940] to a[1200]....

Ans: MAX (A)
 */
}
