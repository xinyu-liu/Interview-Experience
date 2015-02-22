package LongestValidParentheses;

import java.util.Stack;

public class Solution {
    public int longestValidParentheses(String s) {
        int max = 0;
        int start = -1;
        Stack<Integer> stack = new Stack<Integer>();
        
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '('){
                stack.push(i);
            }
            else{
                if(!stack.empty()){
                    stack.pop();
                    if(!stack.empty()){
                        max = Math.max( max, i - stack.peek() );
                    }
                    else{
                        max = Math.max(max, i - start);
                    }
                }
                else{
                    start = i;
                }
            }
        }
        return max;
    }
}
