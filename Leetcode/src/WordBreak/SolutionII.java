package WordBreak;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SolutionII {
    public List<String> wordBreak(String s, Set<String> dict) {
    	if(s == null || dict == null || dict.size() < 1){
    		return new ArrayList<String>();
    	}
    	Map<Integer, ArrayList <String> > map = new HashMap<Integer, ArrayList <String>>();
    	
    	
        for (int i = s.length()-1; i >= 0; i--){
        	ArrayList <String> list = new ArrayList <String>();
        	
        	for(int j = s.length()-1; j > i; j--){
        		ArrayList <String> prev = map.get(j);
        		if(prev != null){
        			String sub = s.substring(i, j);
        			// look up sub
        			if( dict.contains(sub) ){
        				for(int o = 0; o < prev.size(); o++){
        					list.add(sub+' '+ prev.get(o));
        				}
        			}		
        		}
        	}
        	String sub = s.substring(i);
			// look up sub
			if( dict.contains(sub) ){	
				list.add(sub);
			}
			if(list.size()>0){
				map.put(i, list);
			}
        }
        List<String> ans = map.get(0);
        if(ans == null){
        	ans = new ArrayList<String>();
        }
     return ans;
    }
}