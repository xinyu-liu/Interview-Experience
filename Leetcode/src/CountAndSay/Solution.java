package CountAndSay;

public class Solution {
    public String countAndSay(int n) {
    	if(n<0){
    		return new String();
    	}
    	String prev = "1";
    	for(int i = 1; i < n; i++){
    		int j = 0;
    		StringBuffer sb = new StringBuffer();
    		int count = 1;
    		while(j < prev.length()){
	    		count = 1;    		
	    		while (j+1 < prev.length() && prev.charAt(j) == prev.charAt(j+1)){
	    			j++;
	    			count++;
	    		}
	    		sb.append(count);
	    		sb.append(prev.charAt(j));
	    		j++;
    		}
    		prev = sb.toString();
    	}
    	return prev;
    }
}
