package HamiltonCircuit_TravelingSalesman;
// http://blog.csdn.net/tianshuai1111/article/details/7535026

public class TravelingSalesmanProblem {
	// O(n!) 
	public int shortPath(int[][] d, int start, int end){
		int n = d.length;
		boolean[] visited = new boolean[n];
		visited[start] = true;
		return dfs(d, 0, 0, visited, 1);
		
	}
	
	private int dfs(int[][] d, int start, int end, boolean[] visited, int count){
		if(count == d.length){
			return d[start][end];
		}
		int n = d.length;
		
		int min = Integer.MAX_VALUE;
		for(int i = 0; i < n; i++){
			if( !visited[i] ){
				visited[i] = true;
				min = Math.min(min, dfs(d, i, 0, visited, count+1) + d[start][i]);
				visited[i] = false;
			}
		}
		
		return min;
	}
	
	public static void main(String[] args){
		int[][] d = {{0, 6, 7, 9},
					 {8, 0, 9, 7},
					 {5, 8, 0, 8},
					 {6, 5, 5, 0}};
		TravelingSalesmanProblem sol = new TravelingSalesmanProblem();
		System.out.print(sol.shortPath(d, 0, 0) );
	}
}
