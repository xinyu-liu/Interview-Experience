package HamiltonCircuit_TravelingSalesman;

import java.util.Arrays;


public class HamiltonCircuit {
	int N;
	boolean[][] adj;
	boolean[] isVisited;
	int start;
	int[] solution;
	// O(n!)  -   // http://www.csie.ntnu.edu.tw/~u91029/Circuit.html
	
	public void hamiltonCircuit(){
		isVisited[start] = true; // Hamilton Circuit can start from any point
		solution[0] = start;     // (undirected graph), ok to start with 0th
		backtrack(1);			 // teen backtrack from 1's position
	}
	private boolean backtrack(int n){
		if(n == N){
			int s = solution[n-1];
			if(adj[s][start]) {
				// find out one solution
				System.out.println(Arrays.toString(solution));
				return true;
			}
			return false;
		}
		boolean b = false;
		for(int i = 0; i < N; i++){
			int s = solution[n-1];
			if( !isVisited[i] && adj[s][i] ){
				isVisited[i] = true;
				solution[n] = i;
				b = b || backtrack(n+1);
				isVisited[i] = false;
			}
		}
		return b;
	}
}
