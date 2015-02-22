package WordLadderII;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Solution {
    class Node{
        String prev;
        int level;
        Node(String pre, int l){
            prev = pre;
            level = l;
        }
    }
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
    	List<List<String>> ans = new ArrayList<List<String>>();
    	
    	Queue<String> queue = new LinkedList<String>();
    	Map<String, Node> map = new HashMap<String, Node>();
    	
    	queue.add(start);
    	map.put( start, new Node(null, 1) );
    	
    	while( !queue.isEmpty() ){
    		String cur = queue.remove();
    		
    	}
    	
    	return ans;
    }
}
