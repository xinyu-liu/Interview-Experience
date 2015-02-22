package CommonElementInAllRowsGivenRowwiseSortedMatrix;

import java.util.Arrays;

/*
Given a matrix where every row is sorted in increasing order. 
Write a function that finds and returns a common element in all rows. 
If there is no common element, then returns -1.

Example:

Input: mat[4][5] = { {1, 2, 3, 4, 5},
                    {2, 4, 5, 8, 10},
                    {3, 5, 7, 9, 11},
                    {1, 3, 5, 7, 9},
                  };
Output: 5
 */
public class CommonElementInAllRowsGivenRowwiseSortedMatrix {
	public int oneCommonElement(int[][] matrix){
		int m = matrix.length;
		int n = matrix[0].length;
		
		int[] index = new int[m];
		Arrays.fill(index, 0);
		for(; index[0] < n; index[0]++){
			int target = matrix[0][index[0]];
			for(int i = 1; i < m; i++){
				while(index[i] < n && matrix[i][index[i]] < target){
					index[i]++;
				}
				if(index[i] == n){
					return -1;
				}
				else if(matrix[i][index[i]] > target){
					break;
				}
				else if( i == m-1){
					return target;
				}
			}
		}
		return -1;
		
	}
	public static void main(String[] args) {
		int[][] matrix = { {1, 2, 3, 4, 5},
                {2, 4, 5, 8, 10},
                {3, 5, 7, 9, 11},
                {1, 3, 5, 7, 9},
              };
		 CommonElementInAllRowsGivenRowwiseSortedMatrix sol = new CommonElementInAllRowsGivenRowwiseSortedMatrix();
		 System.out.println(sol.oneCommonElement(matrix));
	}

}
