package ZigZagConversion;

import java.util.ArrayList;

public class Solution {
	// web
    public String convert(String s, int nRows) { 
    	if(nRows == 1){
    		return s;
    	}
    	int each = nRows * 2 - 2;
    	StringBuffer sb = new StringBuffer();
    	for(int r = 0; r < nRows; r++){
    		int j = r;
    		int i = each - r;
    		// r == 0
    		while(j < s.length()){
    			sb.append(s.charAt(j));
    			j += each;
    			if(r > 0 && r < nRows - 1 && i < s.length()){
    				sb.append(s.charAt(i));
    				i += each;
    			}
    		}
    	}
    	return sb.toString();
    }
	// my math
    public String convertMine(String s, int nRows) { 
    	if(nRows == 1){
    		return s;
    	}
    	ArrayList<StringBuffer> arr = new ArrayList<StringBuffer>(); 
    	int each = nRows * 2 - 2;
    	for(int r = 0; r < nRows; r++){
    		arr.add(new StringBuffer());
    	}
    	for(int i = 0; i < s.length(); i++){
    		int j = i % each;
    		if(j >= nRows) j = each - j;
    		arr.get(j).append(s.charAt(i));
    	}
    	
    	for(int r = 1; r < nRows; r++){
    		arr.get(0).append(arr.get(r));
    	}
    	return arr.get(0).toString();
    }
}
