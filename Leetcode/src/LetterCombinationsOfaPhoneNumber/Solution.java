package LetterCombinationsOfaPhoneNumber;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	// sol2: recursion   O(4^n) 
	// http://www.geeksforgeeks.org/find-possible-words-phone-digits/
	public List<String> letterCombinations(String digits) {  
		String[][] table = { {""},{"a","b","c"},{"d","e","f"},
				{"g","h","i"},{"j","k","l"},{"m","n","o"},
				{"p","q","r","s"},{"t","u","v"},{"w","x","y","z"} };
		List<String> ans = new ArrayList<String> ();
		rec(digits, "", table, ans);
		return ans;
	}
	private void rec(String digits, String prev, String[][] table, List<String> ans){		
		if(digits == null || digits.length() == 0){
			ans.add(prev);
		}
		else{
			String[] arr = table[(int)(digits.charAt(0)-'2')+1];
			for(String s: arr){
				rec(digits.substring(1),prev+s, table, ans );
			}
		}
	}
	// sol1: iteration
    public List<String> letterCombinations1(String digits) {   	
    	List<String> prev= new ArrayList<String>() ;
    	prev.add("");
    	List<String> cur ;
    	if(digits == null || digits.length() < 1){
    		return prev;
    	}
		
        for(int i = 0; i < digits.length(); i++){
        	StringBuffer ab = mapping(digits.charAt(i));
        	cur = new ArrayList<String>();
        	for( String s : prev){
        		for(int j = 0; j < ab.length(); j++){
        			cur.add( s + String.valueOf(ab.charAt(j)) );
        		}
        	}
        	prev = cur;
        }
        return prev;
    }
    private StringBuffer mapping(char d){
    	StringBuffer ans = new StringBuffer();
    	int digit = (int) (d - '2') ; 
    	if(digit + 2 < 7){
        	for(int i = 0; i < 3; i++){
        		char start = (char) (digit*3 + i + (int)'a');
        		ans.append(start);
        	}
    	}
    	else if(digit + 2 == 7){
	    	for(int i = 0; i < 4; i++){
	    		char start = (char) ( i + (int)'p');
	    		ans.append(start);
	    	}
    	}
    	else if(digit + 2 == 8){
	    	for(int i = 0; i < 3; i++){
	    		char start = (char) ( i + (int)'t');
	    		ans.append(start);
	    	}
    	}
    	else if(digit + 2 == 9){
	    	for(int i = 0; i < 4; i++){
	    		char start = (char) ( i + (int)'w');
	    		ans.append(start);
	    	}
    	}
    	return ans;
    }
}
