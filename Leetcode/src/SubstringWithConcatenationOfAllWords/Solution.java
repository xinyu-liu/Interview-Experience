package SubstringWithConcatenationOfAllWords;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
	/*
	 * http://blog.csdn.net/linhuanmars/article/details/20342851
	 * O(n)
	 * same as above:
	 * http://leetcodenotes.wordpress.com/2013/11/10/leetcode-substring-with-concatenation-of-all-words-foobar%E9%A2%98/
	 */
    public List<Integer> findSubstring(String S, String[] L) {
    	List<Integer> ans = new ArrayList<Integer>();
    	if(L.length == 0){
    		ans.add(-1);
    		return ans;
    	}
    	// initiate
    	Map<String, Integer> pattern = new HashMap<String, Integer>();   	
    	for(int i = 0; i < L.length; i++){
    		pattern.put( L[i], pattern.containsKey(L[i]) ? pattern.get(L[i])+1:1 );
    	}
    	//
    	int wordLen = L[0].length();
    	for(int o = 0; o < wordLen; o++){ // offset
    		Map<String, Integer> hasFound = new HashMap<String, Integer>();
    		int count = 0;
    		int start = o;
    		for(int i = o; i < S.length()-wordLen+1; i = i+wordLen){
    			String s = S.substring(i, i+wordLen);
    			if( !pattern.containsKey(s) ){
    				// move start
    				start = i + wordLen;
    				hasFound.clear();
    				count = 0;
    			}
    			else{
    				hasFound.put(s, hasFound.containsKey(s) ? hasFound.get(s)+1 : 1);			
    				if( hasFound.get(s) <= pattern.get(s) ){
    					count++;
    				}
    				//////////////////////////new/////////////////////////
    				else{
    					// move start
    					while( hasFound.get(s) > pattern.get(s) ){
    						String temp = S.substring(start, start+wordLen);
    						hasFound.put(temp, hasFound.get(temp)-1);
    						if( hasFound.get(temp) < pattern.get(temp) ) count--;
    						start += wordLen;
    					}
    				}
    				
    			}
	    		if(count == L.length){ 
	    			ans.add(start);
	    			//
	    			String temp = S.substring(start, start+wordLen);
	    			hasFound.put(temp, hasFound.get(temp)-1);
	    			start += wordLen;
	    			count--;		
	    		}
    		}
    	}
    	return ans;
    }
    /*
     * brute force 
     */
    public List<Integer> findSubstringBF(String S, String[] L) {
    	List<Integer> ans = new ArrayList<Integer>();
    	if(L.length == 0){
    		ans.add(-1);
    		return ans;
    	}
    	// initiate
    	Map<String, Integer> pattern = new HashMap<String, Integer>();   	
    	for(int i = 0; i < L.length; i++){
    		pattern.put( L[i], pattern.containsKey(L[i]) ? pattern.get(L[i])+1:1 );
    	}
    	// 
    	int wordLen = L[0].length();
    	for(int i = 0; i < S.length() - wordLen*L.length + 1; i++){
    		int count = 0;
    		Map<String, Integer> hasFound = new HashMap<String, Integer>();   
    		for(int j = i; j < i + wordLen*L.length; j += wordLen){
    			String s = S.substring(j, j+wordLen);
    			if( !pattern.containsKey(s) ) break;
    			hasFound.put(s, hasFound.containsKey(s) ? hasFound.get(s)+1 : 1);
    			if(hasFound.get(s) > pattern.get(s)) break;
    			count ++;
    		}
    		if(count == L.length) ans.add(i);
    	}
    	return ans;
    }
}
