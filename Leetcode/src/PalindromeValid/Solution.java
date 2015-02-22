package PalindromeValid;

public class Solution {
	// NOT use Character's function
    public boolean isPalindrome(String s) {
    	if(s==null){
    		return false;
    	}
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++){
        	char c = s.charAt(i);
        	if(  (c<='9' && c>='0') || (c<='z'&&c>='a') || (c>='A'&& c<='Z')  ){
        		if(c>='A'&& c<='Z'){
        			c = (char) (c-'A'+'a');
        		}
        		sb.append(c);
        	}
        }
        int mid = (int) Math.ceil( (float)sb.length() / 2.0);
        for(int i = 0; i < mid; i++){
        	if( sb.charAt(i) != sb.charAt(sb.length()-1-i) ){
        		return false;
        	}
        }
        return true;
    }
	// use Character's function
    public boolean isPalindrome2(String s) {
    	if(s==null){
    		return false;
    	}
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++){
        	char c = s.charAt(i);
        	if(Character.isDigit(c) || Character.isLetter(c)){
        		if(Character.isUpperCase(c)){
        			c = Character.toLowerCase(c);
        		}
        		sb.append(c);
        	}
        }
        int mid = (int) Math.ceil( (float)sb.length() / 2.0);
        for(int i = 0; i < mid; i++){
        	if( sb.charAt(i) != sb.charAt(sb.length()-1-i) ){
        		return false;
        	}
        }
        return true;
    }
}
