package MergeIntervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution {
	/*
	 * 2 cases
	 * http://blog.csdn.net/linhuanmars/article/details/21857617
	 */
	public List<Interval> merge2(ArrayList<Interval> intervals) {  
		List<Interval> ans = new ArrayList<Interval>(); 
		if(intervals.size() == 0) return ans;
		
		Collections.sort(intervals, new Comparator<Interval>(){
			@Override
			public int compare(Interval o1, Interval o2) {
				return o1.start - o2.start;
			}
		});
		ans.add(intervals.get(0));
		for(int i = 1; i < intervals.size(); i++){
			Interval cur = intervals.get(i);
			Interval prev = ans.get(ans.size()-1);
			if(prev.end < cur.start) ans.add(cur);
			else prev.end = Math.max(prev.end, cur.end);
		}
		return ans;
	}
	
	
	
	/*
	 * my first
	 */
    class MyComparator implements Comparator<Interval>{
        public int compare(Interval a, Interval b){
             return a.start - b.start;
         }
    }
    public List<Interval> mergeMine(List<Interval> intervals) {    	
    	List<Interval> ans = new ArrayList<Interval>(); 
    	if(intervals.size() == 0) return ans;
    	
    	Collections.sort(intervals, new MyComparator());

    	ans.add(intervals.get(0));
    	for(int i = 1; i < intervals.size(); i++){
    		Interval prev = ans.get(ans.size()-1);
    		Interval cur = intervals.get(i);
    		
    		if(prev.end < cur.end){
    			if(prev.end < cur.start){ // separate
    				ans.add(cur);
    			}
    			else{ // combine
    				prev.end = cur.end;
    			}
    		}
    	}
    	return ans;
    }
}
