package DP1_nthFibonacciNumber;

import java.util.Arrays;

public class Fib {
	// bottom-up
	public int fibTabulation(int n){
		if( n == 0 || n == 1 ) return n;
		int[] table = new int[n+1];
		table[0] = 0;
		table[1] = 1;
		for(int i = 2; i <= n; i++){
			table[i] = table[i-1]+table[i-2];
		}
		return table[n];
	}
	
	
	// top-down
	public int fibMemoized(int n){
		if(n == 0 || n == 1) return n;		
		int[] table2 = new int[n+1];
		Arrays.fill(table2, -1);
		
		rec(n, table2);
		return table2[n];
	}
	private int rec(int n, int[] table){
		
		if( table[n] == -1 ) {
			if(n <= 1) table[n] = n;
			else table[n] = rec(n-1, table) + rec(n-2, table);
		}
		return table[n];
	}
}
