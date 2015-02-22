package TextJustification;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	/*
	 * 分析：这一题需要注意两个点，
	 * a、当该行只放一个单词时，空格全部在右边 
	 * b、最后一行中单词间只有一个空格，其余空格全部在右边。然后只要贪心选择，在一行中尽量放多的单词。
	 * http://blog.csdn.net/fightforyourdream/article/details/17461861
	 */
	/*
Input:	["Listen","to","many,","speak","to","a","few."], 6
Output:	["Listen","to","many,","speak","to a","few.  "]
Expected:	["Listen","to    ","many, ","speak ","to   a","few.  "]

	 */
	// mine
    public List<String> fullJustify(String[] words, int L) {
    	List<String> ans = new ArrayList<String>();
    	StringBuffer sb = new StringBuffer();
    	
    	int start = 0;
    	int left = L;
    	int i = 0;
    	while(i < words.length){
    		// first
	    	sb.append(words[start]);
	    	left -= words[start].length();
	    	// others
	    	i = start + 1;
	    	// find end
	    	while(i < words.length && left >= words[i].length()+1 ){
	    		left -= (words[i].length()+1);
	    		i++;
	    	}
	    	// write in 
	    	if(i >= words.length || start+1 == i){ // last      			///////// before else   ///  || start+1 == i for above test case
	    		for(start = start + 1; start < i; start++){
	    			sb.append(' ');
	    			sb.append(words[start]);
	    		}
	    		// last spaces
    			for(int j = 0; j < left; j++){
    				sb.append(' ');
    			}
	    		ans.add(sb.toString());
	    	}
	    	else if(left < words[i].length()+1){
	    		int numOfFollow = i - 1 - start;
	    		if(numOfFollow > 0){ 				// need this, else / by zero
		    		int avg = left / numOfFollow;
		    		int rem = left % numOfFollow;
		    		 		
		    		numOfFollow = 0;
		    		for(start = start + 1; start < i; start++){
		    			numOfFollow++;
		    			int numSpace = avg + (numOfFollow <= rem ? 1 : 0);
		    			for(int j = 0; j < numSpace; j++){	
		    				sb.append(' ');
		    			}
		    			sb.append(' ');
		    			sb.append(words[start]);
		    		}
	    		}
	    		ans.add(sb.toString());
	    	}
	    	
	    	start = i;
	    	left = L;
	    	sb = new StringBuffer();	////// need this
    	}
    	if(ans.size() == 0){
    		ans.add("");
    	}
    	return ans;
    }
}
