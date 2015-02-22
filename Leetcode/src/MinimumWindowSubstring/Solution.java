package MinimumWindowSubstring;

import java.util.HashMap;
import java.util.Map;

public class Solution {
	/*
	 * 类似 Longest Substring Without Repeating Characters
	 * 
	 * 这题T可以有重复字母，比如AAA，那S中必须包括3个A才行。不是包括A就行了。
	 * 自己的做法只能cover木有重复字母的情况。 思路： 先把T中的每个字母在S中的位置记录下来，生成一个Map<Char, Queue<Index>>。
	 * 
	 * ans: http://blog.csdn.net/fightforyourdream/article/details/17373203
	 * 
	 * 在处理字符串时候用数组比Hashtable要来的方便
	 * 
	 * 思路：
假设我们现在知道S[0..K]包含了T，
第一步，精简S[0..K]为S[I..K]，其中S[0..I-1]都与T无关或者与S[I..K]有所重复；
第二步，用S[I+1..L]取代S[I..K]，条件为S[K+1..L]包含了S[I]；(重复JIASHE)
第三步，精简S[I+1..L] (重复第一步的过程)。
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
