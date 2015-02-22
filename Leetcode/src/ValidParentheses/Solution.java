package ValidParentheses;

import java.util.Stack;

public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for(int i = 0; i < s.length(); i++){
        	char c = s.charAt(i);
        	if(c=='(' || c=='{' || c=='['){
        		stack.push(c);
        	}
        	else{
        		if(stack.isEmpty()){
        			return false;
        		}
        		char out = stack.pop();
        		if(!( (out=='(' && c==')' )
        		 || (out=='{' && c=='}' )
        		 || (out=='[' && c==']' )  )){
        			return false;
        		}
        	}
        }
		if(!stack.isEmpty()){
			return false;
		}
        return true;
    }
}
