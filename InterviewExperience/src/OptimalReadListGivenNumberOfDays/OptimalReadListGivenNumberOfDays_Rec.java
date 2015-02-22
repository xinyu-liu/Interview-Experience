package OptimalReadListGivenNumberOfDays;

import java.util.ArrayList;

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
public class OptimalReadListGivenNumberOfDays_Rec {
	public void assignChapters(int[] pagesInChapter, int days){ // rec - O(c^d)
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
		// backtrack
		backtrack(-1, 0, 0, cost, new ArrayList<Integer>(), days);
		// print
		System.out.print(minPath);
	}
	int minCost = Integer.MAX_VALUE;
	ArrayList<Integer> minPath;
	private void backtrack(int finishedChapter, int curDay, int curCost, int[][] cost, ArrayList<Integer> path, int days){
		if(curDay == days - 1){
			if(finishedChapter+1 < cost.length && curCost + cost[finishedChapter+1][cost.length - 1]< minCost){
				minCost = curCost + cost[finishedChapter+1][cost.length - 1];
				path.add(cost.length - 1);
				minPath = new ArrayList<Integer>(path); 
				path.remove(path.size() - 1);
			}
			return;
		}
		
		for(int c = finishedChapter + 1; c < cost.length; c++){
			path.add(c);
			backtrack(c, curDay+1, curCost + cost[finishedChapter+1][c], cost, path, days);
			path.remove(path.size() - 1);
		}
		
		
	}
	public static void main(String[] args) {
		OptimalReadListGivenNumberOfDays_Rec sol = new OptimalReadListGivenNumberOfDays_Rec();
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
