package DP4_LongestCommonSubsequence;

import java.util.ArrayList;
import java.util.Collections;

public class LCS_Using_2D_LIS {
	private class Point implements Comparable<Point>{
		int i;
		int j;
		Point(int x, int y){
			i = x;
			j = y;
		}
		public int compareTo(Point p2) {
			int diff1 = this.i - p2.i; // small first
			if( diff1 == 0 ) {
				diff1 = p2.j - this.j;     // big first
			}
			return diff1;
		}
	}
	// O(n^2) for finding the same char in s1 and s2
	// O(klogk) for sorting
	public int lcs_using_lis(String s1, String s2){
		int m = s1.length();
		int n = s2.length();
		ArrayList<Point> arr = new ArrayList<Point>();
		for(int i = 0; i < m; i++){
			for(int j = 0; j < n; j++){
				if(s1.charAt(i) == s2.charAt(j)){
					arr.add(new Point(i,j));
				}
			}
		}
		Collections.sort(arr);
		
		return lis(arr);
	}
	// O(k^2) k is the number of same chars in s1 and s2
	private int lis(ArrayList<Point> arr){
		int m = arr.size();
		int[] dp = new int[m];
		dp[0] = 1;
		for(int i = 1; i < m; i++){
			int max = 1;//////////////MUST
			for(int j = 0; j < i; j++){
				if(arr.get(j).j < arr.get(i).j && max < dp[j] + 1 ){
					max = dp[j] + 1;
				}
			}
			dp[i] = max;		
		}
		int ans = 0; 
		for(int i = 0; i < m; i++){
			ans = Math.max(ans, dp[i]);
		}
		return ans;
	}
	public static void main(String[] args){
		LCS_Using_2D_LIS sol = new LCS_Using_2D_LIS();
		System.out.print(  sol.lcs_using_lis("abacd", "dbaabca")  );
	}
}
