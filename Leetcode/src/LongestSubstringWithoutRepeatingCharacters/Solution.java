package LongestSubstringWithoutRepeatingCharacters;

import java.util.HashMap;
import java.util.Map;

public class Solution {
	// substring => continuous!
	public int lengthOfLongestSubstring(String s) {
        int start = 0;
        int prevMax = 0;
        if(s == null || s.length() == 0){
    		return 0;
    	}
        
        Map<Character,Integer> map = new HashMap<Character,Integer>();

        for(int i = 0; i < s.length(); i++){
        	char c = s.charAt(i);
        	Integer integer = map.get(c);
        	if(integer == null || integer < start){       		
        		map.put(c, i);
        	}
        	else{
        		prevMax = Math.max(prevMax, i-start); // i not included
        		start = integer+1;
        		map.put(c, i);
        	}
        }
        prevMax = Math.max(prevMax, s.length() - start);// length not included
        return prevMax;
    }
}
