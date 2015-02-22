package LongestPalindromicSubstring;

import java.util.Arrays;

public class Solution {
	/*
	 * 我们可以记录一些我们需要的东西，就可以在O（1）的时间判断出该子串是不是一个回文。这样就比暴力法节省了O（N）的时间复杂度
	 * P(i,j)为 1时代表字符串Si到Sj是一个回文，为0时代表字符串Si到Sj不是一个回文。
	 * P（i，j）= P（i+1，j-1）（如果S[i] = S[j]）。这是动态规划的状态转移方程。
	 * P（i，i）= 1，P（i，i+1）= if（S[i]= S[i+1]）
	 */
	String longestPalindromeDP(String s) { // Accepted! time: O(n2), space: O(n2)
		if(s == null){
			return null;
		}
		int length = s.length();
		int maxStart = 0;
		int maxLength = 1;
		boolean[][] isP = new boolean [length][length];
		
		for(int i = 0; i < length; i++){
			Arrays.fill(isP[i], false);
		}
		for(int i = 0; i < length; i++){
			isP[i][i] = true;
		}
		for(int i = 0; i < length-1; i++){
			if(s.charAt(i) == s.charAt(i+1)){
				maxStart = i;
				maxLength = 2;
				isP[i][i+1] = true;
			}
		}
		for (int len = 3; len <= length; len++){
			for(int i = 0; i < length+1-len; i++){
				if(s.charAt(i) == s.charAt(i+len-1) && isP[i+1][i+len-2]){
					maxLength = len;
					maxStart = i;
					isP[i][i+len-1] = true;
				}
			}		
		}
		return s.substring(maxStart, maxStart+maxLength);
	}
	
	String longestPalindromeExpandAroundCenter(String s) {
		if(s == null){
			return null;
		}
		int length = s.length();
		int maxStart = 0;
		int maxLength = 1;
		for(int i = 0; i< length; i++){
			// single center
			int expand = 1;
			while (i-expand>=0 && i+expand< length && s.charAt(i-expand)==s.charAt(i+expand)){
				expand++;
			}
			expand--; 
			if(expand*2+1 > maxLength){
				maxLength = expand*2+1;
				maxStart = i - expand;
			}
			// i & i+1 together as center
			if( i+1< length && s.charAt(i) == s.charAt(i+1) ){
				expand = 1;
				while (i-expand>=0 && i+1+expand< length && s.charAt(i-expand)==s.charAt(i+1+expand)){
					expand++;
				}
				expand--;
				if(expand*2+2 > maxLength){
					maxLength = expand*2+2;
					maxStart = i - expand;
				}
			}			
		}
		return s.substring(maxStart, maxStart+maxLength);
	}
}
