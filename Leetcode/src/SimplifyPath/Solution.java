package SimplifyPath;

import java.util.Stack;

public class Solution {
	// can use
	// String[] strs = path.split("/");  
	// may give s: s.length()==0, ignore like '.'
	
    public String simplifyPath(String path) {
    	int start = 0;
    	int end = start;
    	Stack<String> stack = new Stack<String>();
    	while(start < path.length() && end < path.length()){
	    	while(start < path.length() && path.charAt(start) == '/'){
	    		start++;
	    	}
	    	end = start;
	    	while(end < path.length() && path.charAt(end) != '/'){
	    		end++;
	    	}
	    	if(start < end){
		    	String s = path.substring(start,end);
		    	if(s.equals("..") ){
		    		if( !stack.isEmpty() ){
		    			stack.pop();
		    		}
		    	}
		    	else if(!s.equals(".")){
		    		stack.push(s);
		    	}
	    	}
	    	start = end;
	    	
    	}
    	StringBuffer sb = new StringBuffer();
    	sb.append('/');
    	Stack<String> stack2 = new Stack<String>();
    	while(!stack.isEmpty()){
    		stack2.push( stack.pop() );
    	}
    	while(!stack2.isEmpty()){
    		sb.append(stack2.pop());
    		sb.append('/');
    	}
    	if(sb.length() > 1){
    		return sb.substring(0,sb.length()-1);
    	}
    	else{
    		return sb.toString();
    	}
    }
}
