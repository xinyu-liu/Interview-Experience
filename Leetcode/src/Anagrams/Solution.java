package Anagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
//'and' and 'dan' both are composed of 1 x a, 1 x n, 1 x d so they are anagram.
/*
 * Submission Result: Wrong Answer
first several 
ALL BECAUSE didn't put
	map. put (sorted, list); ///////MUST DO THIS FOR NEW LIST!!!		
    	
Input:	["tea","and","ate","eat","dan"]
Output:	["tea","ate","eat"]
Expected:	["and","dan","tea","ate","eat"]
ADD ALL size > 1 lists!!!
这道题目，要把所有重组字相同的组都给输出，而不是只输出一组。

also can 
没有对每个字符串排序，而是用了另一种方法。
由于我们知道每个单词都是由小写字母组成，所以我们可以统计'a'~'z'出现的次数。
之后的，就是重新组装了。
 */
	public List<String> anagrams(String[] strs) {
		List<String> ans = new ArrayList<String>();
		
		Map<String,List<String>> map = new HashMap<String,List<String>>();
    	
		for(int i = 0;  i < strs.length; i++){
    		String sorted = sortedString(strs[i]);
    		List<String> list = map.get(sorted);
	   		if(list == null){
	   			list = new ArrayList<String>();
	   		}
	   		list.add(strs[i]);
	    	map. put (sorted, list); ///////MUST DO THIS FOR NEW LIST!!!		
    	}
    	
    	for( String s: map.keySet() ){
    		List<String> list = map.get(s);
    		if(list.size() > 1){
    			ans.addAll( list );
    		}
    	}
    	return ans;
        
    }
	private String sortedString (String s){
		char[] arr = s.toCharArray();
		Arrays.sort(arr);
		return new String(arr); // WRONG: return arr.toString();
	}
}
