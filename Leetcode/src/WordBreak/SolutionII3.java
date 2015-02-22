package WordBreak;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SolutionII3 {
    public List<String> wordBreak(String s, Set<String> dict) {
    	if(s == null || dict == null || dict.size() < 1){
    		return null;
    	}
    	Map<Integer, ArrayList <String> > map = new HashMap<Integer, ArrayList <String>>();
    	
    	
        for (int i = 0; i < s.length(); i++){
        	ArrayList <String> list = new ArrayList <String>();
        	
        	for(int j = 0; j < i; j++){
        		ArrayList <String> prev = map.get(j);
        		if(prev != null){
        			String sub = s.substring(j+1, i+1);
        			// look up sub
        			if( dict.contains(sub) ){
        				for(int o = 0; o < prev.size(); o++){
        					list.add(prev.get(o) +' '+ sub);
        				}
        			}		
        		}
        	}
        	String sub = s.substring(0, i+1);
			// look up sub
			if( dict.contains(sub) ){	
				list.add(sub);
			}
			if(list.size()>0){
				map.put(i, list);
			}
        }
     return map.get(s.length()-1);
    }
}