package LongestCommonPrefix;

public class Solution {
    public String longestCommonPrefix(String[] strs) {    	
    	if(strs == null || strs.length == 0){
    		return "";
    	}
        int c = 0;
        while(c<strs[0].length()){
        	for(int j = 0; j < strs.length-1;j++){
        		if(c < strs[j].length() && c < strs[j+1].length() 
        				&& strs[j].charAt(c) != strs[j+1].charAt(c)){
        			return strs[0].substring(0,c);
        		}
        	}
        	c++;
        }
        return strs[0];
    }
}
