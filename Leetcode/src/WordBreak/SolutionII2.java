package WordBreak;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class SolutionII2 {
    public List<String> wordBreak(String s, Set<String> dict) {
    	if(s == null || dict == null || dict.size() < 1){
    		return new ArrayList <String>();
    	}
    	ArrayList<ArrayList <String>> opt = new ArrayList<ArrayList <String>>(s.length());
        for (int i = 0; i < s.length(); i++){
        	ArrayList <String> list = new ArrayList <String>();
        	opt.add(list);
        	for(int j = 0; j < i; j++){
        		if(opt.get(j).size() > 0){
        			String sub = s.substring(j+1, i+1);
        			// look up sub
        			if( dict.contains(sub) ){
        				for(int o = 0; o < opt.get(j).size(); o++){
        					opt.get(i).add(opt.get(j).get(o) +' '+ sub);
        				}
        			}		
        		}
        	}
        	String sub = s.substring(0, i+1);
			// look up sub
			if( dict.contains(sub) ){
				if(opt.get(i).size()>0){
					opt.get(i).add(" ");
				}
				else{
					opt.get(i).add(sub);
				}
			}
        }
        ArrayList <String> ans = opt.get(s.length()-1);
        for(int i = 0; i< ans.size(); i++){
        	ans.set(i, ans.get(i).trim());
        }
        return ans;
    }
}