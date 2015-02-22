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
�����Ŀ��Ҫ��������������ͬ���鶼�������������ֻ���һ�顣

also can 
û�ж�ÿ���ַ������򣬶���������һ�ַ�����
��������֪��ÿ�����ʶ�����Сд��ĸ��ɣ��������ǿ���ͳ��'a'~'z'���ֵĴ�����
֮��ģ�����������װ�ˡ�
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
