package OptimalReadListGivenNumberOfDays;
/*
 * A person is determined to finish the book in ¡®k¡¯ days, but he never wants to stop a chapter in between. 
 * Find the optimal assignment of chapters, such that the person doesn¡¯t read too many extra/less pages overall.

Example 1:
Input:  Number of Days to Finish book = 2
        Number of pages in chapters = {10, 5, 5}
Output: Day 1:  Chapter 1
        Day 2:  Chapters 2 and 3

Example 2:
Input:  Number of Days to Finish book = 3
        Number of pages in chapters = {8, 5, 6, 12}
Output: Day 1:  Chapter 1
        Day 2:  Chapters 2 and 3 
        Day 2:  Chapter 4
The target is to minimize the sum of differences between the pages read on each day and average number of pages. 
If the average number of pages is a non-integer, then it should be rounded to closest integer.

In above example 2, average number of pages is (8 + 5 + 6 + 12)/3 = 31/3 which is rounded to 10. 
So the difference between average and number of pages on each day for the output shown above is ¡°abs(8-10) + abs(5+6-10) + abs(12-10)¡± which is 5. 
The value 5 is the optimal value of sum of differences.
 */
public class OptimalReadListGivenNumberOfDays_DP {
	// DP
	public void assignChapters(int[] pagesInChapter, int days){ // O(c^3)
		int numOfChapters = pagesInChapter.length;
		
		int sum = 0;
		for(int p : pagesInChapter) sum += p;	
		int avg = (int) (((float)sum + 0.5) / days);
		
		// cost if read from chapter i to j in the one day
		int[][] cost = new int[numOfChapters][numOfChapters];
		for(int i = 0; i < numOfChapters; i++){
			int temp = 0;
			for(int j = i; j < numOfChapters; j++){
				temp += pagesInChapter[j];
				cost[i][j] = Math.abs(temp-avg);
			}
		}
		
		int[][] yesterdayFinish = new int[days][numOfChapters];
		
		// min cost to use d days finish reading 1-c chapters
		int[][] dp = new int[days][numOfChapters]; 
		for(int d = 0; d < days; d++){
			dp[d][0] = cost[0][0];
			for(int c = 1; c < numOfChapters; c++){
				if(d == 0){
					dp[d][c] = cost[0][c];
					yesterdayFinish[d][c] = -1;
				}
				else{
					dp[d][c] = Integer.MAX_VALUE;
					for(int i = 0; i < c; i++){
						if(dp[d][c] > dp[d-1][i] + cost[i+1][c]){
							dp[d][c] = dp[d-1][i] + cost[i+1][c];
							yesterdayFinish[d][c] = i;
						}
							
					}
				}
			}
		}
		
		int endDay = 0;
		int chapter = numOfChapters-1;
		int min = dp[0][chapter];
		for(int d = 1; d < days; d++){
			if(dp[d][chapter] < min){
				min = dp[d][chapter];
				endDay = d;
			}
		}	
		// find path 1: using 2D array to record
/*
		while(chapter >= 0 && endDay >= 0){
			System.out.println(endDay + " th day finish chapter " + chapter);
			chapter = yesterdayFinish[endDay--][chapter];
		}		
*/		
		// find path 2: calculate 
		System.out.println(endDay + " th day finish chapter " + chapter);
		for(int d = endDay; d > 0; d--){
			for(int i = 0; i < chapter; i++){
				if(dp[d][chapter] == dp[d-1][i] + cost[i+1][chapter]){
					System.out.println(d-1 + " th day finish chapter " + i);
					chapter = i;
					break;
				}
			}
		}
	}
	public static void main(String[] args) {
		OptimalReadListGivenNumberOfDays_DP sol = new OptimalReadListGivenNumberOfDays_DP();
		int[] pages = {8, 5, 6, 12};
		int days = 3;
		sol.assignChapters(pages, days);
/*		
		Output: Day 1:  Chapter 1
		        Day 2:  Chapters 2 and 3 
		        Day 2:  Chapter 4
*/
/*
		int[] pages = {10, 5, 5};
		int days = 2;
		sol.assignChapters(pages, days);

		Output: Day 1:  Chapter 1
		        Day 2:  Chapters 2 and 3
*/
	}

}
