package StrStr;

public class Solution {
    public int strStrBF(String haystack, String needle) {
    	if(needle == null || needle.length() == 0){
    		return 0;
    	}	
    	for(int i = 0; i < haystack.length()-needle.length()+1; i++){  		
    		int j = 0;
    		for(; j < needle.length(); j++){
    			if(haystack.charAt(i+j) != needle.charAt(j)){
    				break;
    			}
    		}
    		if(j == needle.length()) return i;
    	}
    	return -1;	
    }
    public int strStrKMP(String haystack, String needle) {
    	if(needle == null || needle.length() == 0){
    		return 0;
    	}
    	int[] next = getNext(needle);
    	int i = 0;
    	int j = 0;

    	while(i < haystack.length() && j < needle.length()){
    		if(j == -1 || haystack.charAt(i) == needle.charAt(j)){
    			i++;
    			j++;
    		}
    		else{
    			j = next[j];
    		}
    	}
		if(j == needle.length()){
			return i - j;
		}
    	return -1;
    }
    
    private int[] getNext(String needle){
    	int[] next = new int[needle.length()];
    	next[0] = -1;
    	
    	int k = -1;
    	int j = 0;
    	while(j < needle.length() - 1 ){
    		if(k == -1 || needle.charAt(k) == needle.charAt(j)){	
    			next[++j] = ++k;	
    		
    			/* instead of above one line, do this => reduce complexity for needle like ABABABABABAB
    			if (needle.charAt(++j) == needle.charAt(++k)) { // 当两个字符相等时要跳过
    				next[j] = next[k];
    	        } 
    			else {
    				next[j] = k;
    			}
    	        */  	           
    		}
    		else{
    			k = next[k];	
    		}    		
    	}
    	return next;
    }
}
