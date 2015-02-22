package LongestPalindromicSubstring;

import java.util.Arrays;

public class Solution {
	/*
	 * ���ǿ��Լ�¼һЩ������Ҫ�Ķ������Ϳ�����O��1����ʱ���жϳ����Ӵ��ǲ���һ�����ġ������ͱȱ�������ʡ��O��N����ʱ�临�Ӷ�
	 * P(i,j)Ϊ 1ʱ�����ַ���Si��Sj��һ�����ģ�Ϊ0ʱ�����ַ���Si��Sj����һ�����ġ�
	 * P��i��j��= P��i+1��j-1�������S[i] = S[j]�������Ƕ�̬�滮��״̬ת�Ʒ��̡�
	 * P��i��i��= 1��P��i��i+1��= if��S[i]= S[i+1]��
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
