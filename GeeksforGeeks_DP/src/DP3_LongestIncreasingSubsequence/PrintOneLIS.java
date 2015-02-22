package DP3_LongestIncreasingSubsequence;

import java.util.LinkedList;

public class PrintOneLIS {
	public void printOneLIS(int[] arr){
		if(arr == null || arr.length == 0) return;
		int m = arr.length;
		int[] dp = new int[m];
		int[] prev = new int[m]; /////////////use an array to store which digit is this digit's prev
		
		dp[0] = 1;
		prev[0] = -1;
		for(int i = 1; i < m; i++){
			int max = 1; ///////MUST
			int pos = -1;
			for(int j = 0; j < m; j++){
				if( arr[j] < arr[i] && max < (dp[j] + 1) ){
					max = dp[j] + 1;
					pos = j;
				}
			}
			dp[i] = max;
			prev[i] = pos;
		}
		// find max dp value 
		int max = 0;
		int end = -1;
		for(int i = 0; i < m; i++){
			if(max < dp[i]){
				max = dp[i];
				end = i;
			}
		}
		tracePrint(end, prev, arr);///////
		System.out.println();

		System.out.print(  
				traceStore(end, prev, arr)  //////////
				); 
		
	}

	private void tracePrint(int end, int[] prev, int[] arr) {
		if(end != -1){
			tracePrint(prev[end], prev, arr);
			System.out.print(arr[end] + " ");
		}
	}
	private LinkedList<Integer> traceStore(int end, int[] prev, int[] arr) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		for(int i = end; i != -1; i = prev[i]){
			list.addFirst(arr[i]);
		}
		return list;
	}
	public static void main(String[] args){
		PrintOneLIS sol = new PrintOneLIS();
		int[] arr = { 10, 22, 9, 33, 21, 50, 41, 60, 80 } ;
		sol.printOneLIS(arr);
	}
}
