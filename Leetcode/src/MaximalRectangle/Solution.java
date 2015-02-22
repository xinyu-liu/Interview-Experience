package MaximalRectangle;

import java.util.Stack;

public class Solution {
	// use Largest Rectangle in Histogram
	// this is one step further
    public int maximalRectangle(char[][] matrix) {
    	if(matrix.length == 0 || matrix[0].length == 0){
    		return 0;
    	}
    	int h = matrix.length;
    	int w = matrix[0].length;
    	int[] count = new int[w];
    	
        for(int j = 0; j < w; j++){
        	count[j] = matrix[0][j]=='0' ? 0 : 1;
        }
        int maxArea = 0;
        for(int i = 0; i < h; i++){
            Stack<Integer> valueStack = new Stack<Integer>();
            Stack<Integer> indexStack = new Stack<Integer>();
            int prevI = -1;
        	for(int j = 0; j < w; j++){
        		// deal with count[]
                if(i > 0){
                	count[j] = matrix[i][j] == '0' ? 0 : count[j] + 1;
                }
        		// 
                prevI = j;
        		if(valueStack.empty() || valueStack.peek() < count[j]){
        			valueStack.push(count[j]);
        			indexStack.push(j);
        		}
        		else if(valueStack.peek() > count[j]){
        			while(!valueStack.empty() && valueStack.peek() > count[j]){
        				prevI = indexStack.pop();
        				int ans = (j - prevI) * valueStack.pop();
        				maxArea = Math.max(maxArea, ans);
        			}
        			valueStack.push(count[j]);
        			indexStack.push(prevI);	
        		}
        	}
        	while(!valueStack.empty() ){
				int ans = (w - indexStack.pop()) * valueStack.pop();
				maxArea = Math.max(maxArea, ans);
			}
        }
        return maxArea;
    }
}
