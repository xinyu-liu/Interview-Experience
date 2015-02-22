package NumberOfIslands;
/*
 * What is an island?
A group of connected 1s forms an island. For example, the below matrix contains 5 islands

	                    {1, 1, 0, 0, 0},
                        {0, 1, 0, 0, 1},
                        {1, 0, 0, 1, 1},
                        {0, 0, 0, 0, 0},
                        {1, 0, 1, 0, 1}
A cell in 2D matrix can be connected to 8 neighbors. So, unlike standard DFS(), where we recursively call for all adjacent vertices, here we can recursive call for 8 neighbors only. We keep track of the visited 1s so that they are not visited again.
 */
public class NumberOfIslands {
	public int numOfIslands(int[][] matrix){
		int count = 0;
		int m = matrix.length;
		int n = matrix[0].length;
		boolean[][] isVisited = new boolean[m][n];
		for(int i = 0; i < m; i++){
			for(int j = 0; j < n; j++){
				if( (matrix[i][j] == 1) && !isVisited[i][j] ){
					count++;
					dfs(i, j, matrix, isVisited);
					
				}
			}
		}
		return count;
	}
	private void dfs(int i, int j, int[][] matrix, boolean[][] isVisited){
		isVisited[i][j] = true;
		//  8 neighbors
		int[] p = {-1, -1, -1,  0, 0,  1, 1, 1};
	    int[] q = {-1,  0,  1, -1, 1, -1, 0, 1};
		for(int m = 0; m < 8; m++){
			if( isValid(i+p[m], j+q[m], matrix, isVisited) ){
				dfs(i+p[m], j+q[m], matrix, isVisited);
			}
			
		}
	}
	private boolean isValid(int i, int j, int[][] matrix, boolean[][] isVisited){
		return (i >= 0 && j >= 0 && i < matrix.length && j < matrix[0].length) 
				&& (matrix[i][j] == 1) && !isVisited[i][j];
	}
	public static void main(String[] args) {
		int matrix[][]= {   {1, 1, 0, 0, 0},
		        			{0, 1, 0, 0, 1},
		        			{1, 0, 0, 1, 1},
		        			{0, 0, 0, 0, 0},
		        			{1, 0, 1, 0, 1}
		    			};
		NumberOfIslands sol = new NumberOfIslands();
		System.out.print(sol.numOfIslands(matrix));
	}

}
