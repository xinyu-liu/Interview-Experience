package PalindromicLongestSubstring;

public class Solution {
    public String longestPalindrome(String s) {
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
