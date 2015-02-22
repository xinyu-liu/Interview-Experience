package ReversePolishNotation;

import java.util.Stack;

public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>();
        int v1,v2;
        for (int i = 0;i < tokens.length; i++){
        	if( isOperator(tokens[i]) ){
        		v2 = stack.pop();
        		v1 = stack.pop();
        		if(tokens[i].compareTo("+") == 0){
        			stack.push(v1+v2);
        		}
        		else if(tokens[i].compareTo("-") == 0){
        			stack.push(v1-v2);
        		}
        		else if(tokens[i].compareTo("*") == 0){
        			stack.push(v1*v2);
        		}
        		else {
        			stack.push(v1/v2);
        		}
        	}
        	else{
        		stack.push( Integer.parseInt(tokens[i]) );
        	}
        }
        return stack.pop();
    }
 
    private boolean isOperator(String s){
    	if(s.compareTo("+") == 0){
    		return true;
    	}
    	if(s.compareTo("-") == 0){
    		return true;
    	}
    	if(s.compareTo("*") == 0){
    		return true;
    	}
    	if(s.compareTo("/") == 0){
    		return true;
    	}
    	return false;
    }
}
