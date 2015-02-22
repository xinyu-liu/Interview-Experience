package MinimumWindowSubstring;

import java.util.HashMap;
import java.util.Map;

public class Solution {
	/*
	 * ���� Longest Substring Without Repeating Characters
	 * 
	 * ����T�������ظ���ĸ������AAA����S�б������3��A���С����ǰ���A�����ˡ�
	 * �Լ�������ֻ��coverľ���ظ���ĸ������� ˼·�� �Ȱ�T�е�ÿ����ĸ��S�е�λ�ü�¼����������һ��Map<Char, Queue<Index>>��
	 * 
	 * ans: http://blog.csdn.net/fightforyourdream/article/details/17373203
	 * 
	 * �ڴ����ַ���ʱ���������HashtableҪ���ķ���
	 * 
	 * ˼·��
������������֪��S[0..K]������T��
��һ��������S[0..K]ΪS[I..K]������S[0..I-1]����T�޹ػ�����S[I..K]�����ظ���
�ڶ�������S[I+1..L]ȡ��S[I..K]������ΪS[K+1..L]������S[I]��(�ظ�JIASHE)
������������S[I+1..L] (�ظ���һ���Ĺ���)��
	 */
	public String minWindow(String S, String T) {
		int[] pattern = new int[256];
		// init 
		for(int i = 0; i <T.length(); i++){
			pattern[T.charAt(i)]++;
		}
		int[] hasFound = new int[256];
		
		int l = 0;
		int r = 0;
		int maxLen = Integer.MAX_VALUE;
		String ans = "";
		
		// find first
		int count = 0;
		while(r < S.length()){
			char c = S.charAt(r);
			if(pattern[c] > 0){
				hasFound[c]++;
				if(hasFound[c] <= pattern[c]) count++;
			}
			r++;
			if(count == T.length()){
				// compress window by move l
				// case 1: char not in pattern 
				// case 2: char num larger than needed
				while(l <= r){
					c = S.charAt(l);
					if(pattern[c] == 0){
						l++;
					}
					else if(hasFound[c] > pattern[c]){
						hasFound[c]--;
						l++;
					}
					else{
						hasFound[c]--;
						break;
					}
				}
				if(r-l < maxLen){
					maxLen = r-l;
					ans = S.substring(l,r);
				}
				l++;
				count--;
			}
		}
		return ans;
	}
	/*
	 * hash table, two pointer - Compile time limit exceeded.!!!!!
	 */
    public String minWindowWRONG(String S, String T) {
    	// construct has(>0) / want(<0) map
    	Map<Character, Integer> map = new HashMap<Character, Integer>();
    	constructMap(T, map);
    	// ans
    	int ansL = -1;
    	int ansR = -1;
    	int min = Integer.MAX_VALUE;
    	// two pointer
    	int l = -1;
    	int r = 0;
    	int len = T.length();
    	// find first
    	while(r < S.length() && len != 0){
    		Integer integer  = map.get(S.charAt(r));
    		if(integer != null){
    			map.put(S.charAt(r), integer - 1);
    			if(integer > 0) len--;
    			if(l == -1) l = r;
    		}
    		r++;
    	}
    	if(r == S.length()){
    		if(len > 0) return "";
    		else return S;
    	}
    	r--;
    	ansL = l;
    	ansR = r; // -1
    	min = r-l;
    	// find next
    	while(r < S.length() && l < r){
	    	char target = S.charAt(l++);
	    	while(r < S.length() && S.charAt(r)!=target){
	    		Integer integer  = map.get(S.charAt(r));
	    		if(integer != null){
	    			map.put(S.charAt(r), integer - 1);
	    			if(l == ansL+1) l = r;
	    		}
	    		r++;
	    	}
	    	if (r+1-l < min){
	        	ansL = l;
	        	ansR = r+1; // -1
	        	min = r+1-l;
	    	}
	    	// reduce len by l
	    	while(l < r){
	    		Integer integer  = map.get(S.charAt(l));
	    		if(integer != null){
	    			if(integer + 1 > 0) break;
	    			map.put(S.charAt(r), integer + 1);		
	    		}
	    		l++;
	    	}
    	}
    	return S.substring(ansL, ansR);
    	
    }
    private void constructMap(String T, Map<Character, Integer> map){
    	for(int i = 0; i < T.length(); i++){
    		char c = T.charAt(i);
    		Integer integer = map.get(c);
    		if(integer == null){
    			integer = 0;
    		}
    		map.put(c, integer+1);
    	}
    }
}
