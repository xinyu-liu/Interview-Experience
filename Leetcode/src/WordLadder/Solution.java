package WordLadder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Solution {
	/*
	 * ��ʵ��������ǧ�������У�ֻ���������������ɵ�ǰ����һ���������֮ǰ�ıȽ��˷��˺ܶ�
	 * ʱ���ڲ����ܵĵ����ϡ����϶Ը�����Ľ����һ���ⶼ�ǰ��������˼·������ǰ����ÿһ��
	 * �ַ��滻��a~z������һ���ַ���Ȼ���ж��Ƿ��ڴʵ��г��֡���ʱ�ĸ��Ӷ���
	 * O(26*word_length)�������ʱȽ϶�ʱ�����ַ��������ƾ����ֳ����ˡ�
	 * 
	 * v map queue(old)
	 * x set count arraylist (new) - accept but not really good
	 * 
	 * �����ǰ����г���ΪL���ַ�������һ�£����߰��ֵ��е��ַ�������һ�£�
	 * ������ΪL���ַ����ܹ���26^L������ʱ�临�Ӷ���O(min(26^L, size(dict))��
	 * �ռ�����Ҫ�洢���������Ҳ��O(min(26^L, size(dict))��
	 * 
	 * else Time Limit Exceeded, dict size n, O(n2)
   
	 */
	// I
    public int ladderLengthNEW(String start, String end, Set<String> dict) {
        if( start.length() == 0 || start.equals(end) ) return 1;
        if(dict.size() == 0) return 0;
        
        int count = 1;
        Set<String> used = new HashSet<String>();
        ArrayList<String> list = new ArrayList<String>();
        list.add(start);
        while( list.size() != 0 ){
            ArrayList<String> newList = new ArrayList<String>();
            for(int a = 0; a < list.size(); a++){ // all this level
                String cur = list.get(a);
                used.add(cur);
                for(int i = 0; i < cur.length(); i++){ // every position 
                    StringBuffer sb = new StringBuffer(cur);
                    for(int j = 0; j < 26; j++){ // every ab
                        char c = (char)( (int)'a'+ j );
                        sb.setCharAt(i, c);
                        String temp = new String(sb);
                        if( temp.equals(end) ) return count + 1;
                        if( dict.contains(temp) && !used.contains(temp) ){
                            newList.add(temp);
                            used.add(temp);//
                        }
                    }
                }
            }
            list = newList;
            count++;
        }
        return 0;
    }

	public int ladderLengthOLD(String start, String end, Set<String> dict) {
		if (start == null || end == null || start.length() != end.length()) { 
            return 0;  
		}
        if(start.equals(end)){
        	return 1;
        }
        if(isTransable(start,end)){
        	return 2;
        }
        int length = start.length();
        Map<String, Integer> map = new HashMap<String,Integer>();
        Queue<String> queue = new LinkedList<String>();
        map.put(start, 1);
        queue.add(start);
        while(!queue.isEmpty()){
			String cur = queue.remove();
			for (int i = 0; i < length; i++){
				for(int a = 0; a < 26; a++){
					StringBuffer sb = new StringBuffer();
					sb.append(cur);
					char c = (char) ('a' + a );
					sb.setCharAt(i,c);
					String s = sb.toString();
					if(map.get(s)==null && dict.contains(s)){
				        map.put(s, map.get(cur)+1);
				        queue.add(s);
				        if(s.equals(end)){
				        	return map.get(s);
				        }
					}
				}
			}	
		}
        return 0;
	}
    private boolean isTransable(String s1, String s2){
    	int notEqual= 0;
    	for(int i = 0; i < s1.length(); i++){
    		if(s1.charAt(i) != s2.charAt(i)){
    			notEqual++;
    		}
    	}
    	if(notEqual == 1){
    		return true;
    	}
    	return false;
    }
}
