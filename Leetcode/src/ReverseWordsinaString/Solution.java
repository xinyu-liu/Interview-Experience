package ReverseWordsinaString;

import java.util.Stack;

public class Solution {
	/*
	 * One simple approach is a two-pass solution: First pass to split the string by spaces 
	 * into an array of words, then second pass to extract the words in reversed order.
	 * 
	 * We can do better in one-pass. While iterating the string in reverse order, we keep track 
	 * of a word¡¯s begin and end position. When we are at the beginning of a word, we append it.
	 */
    public String reverseWords(String s) {
        // output
        StringBuffer sb = new StringBuffer();
        s = s.trim();
        int i = s.length()-1;
        int end = i;
        while(i >= 0){
            while(i >= 0 && s.charAt(i) != ' '){
                i--;
            }
            sb.append(s.substring(i+1, end+1) + ' '); 
            while(i >= 0 && s.charAt(i) == ' '){
                i--;
            }
            end = i;
        }
        return sb.length() > 0 ? sb.substring(0, (sb.length()-1) ) : "";
    }
    public String reverseWords2P(String s) {
        // store words
        Stack<String> stack = new Stack<String>();
        s = s.trim();
        int i = 0;
        int start = i;
        while(i < s.length()){
            while(i < s.length() && s.charAt(i) != ' '){
                i++;
            }
            stack.push(s.substring(start, i));
            while(i < s.length() && s.charAt(i) == ' '){
                i++;
            }
            start = i;
        }
        // output
        StringBuffer sb = new StringBuffer();
        while( !stack.empty() ){
            sb.append(stack.pop()+ ' ');
        }
        return sb.length() > 0 ? sb.substring(0, (sb.length()-1) ) : "";
    }
    public String reverseWordsOLD(String s) {
        if(s==null){
            return s;
        }
        StringBuffer ans = new StringBuffer();
        int i = 0; 
        while(i<s.length() && s.charAt(i)==' '){
        	i++;
        }
        int wStart = i;

        while(i < s.length()){
        	if(s.charAt(i)==' '){

        		ans.insert(0, s.substring(wStart, i));
        		ans.insert(0, " ");
        		
                while(i<s.length() && s.charAt(i)==' '){
                	i++;
                }
                wStart = i;
        		
        	}
        	else{
        		i++;
        	}
        }
        if(s.substring(wStart)!="" && s.substring(wStart).charAt(0) !=' '){
    		ans.insert(0, s.substring(wStart));
        }
        int j = 0;
        while( j < ans.length()){
        	if(ans.charAt(j) !=' '){
        		break;
        	}
        	else{
        		j++;
        	}
        	
        }
        return ans.substring(j);
    }
}