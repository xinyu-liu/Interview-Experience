package InsertInterval;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	/*
	 *  3 cases
	 *  http://blog.csdn.net/fightforyourdream/article/details/16876485
	 */
    public List<Interval> insert1(List<Interval> intervals, Interval newInterval) {
    	List<Interval> ans = new ArrayList<Interval>();
    	Interval merged = newInterval;  
    	for(int i = 0; i < intervals.size(); i++){
    		Interval cur = intervals.get(i);
    		if( cur.end < merged.start ){ // this is not suit for merge intervals
    			ans.add(cur);
    		}
    		else if( merged.end < cur.start ){
    			ans.add(merged);
    			merged = cur;
    		}
    		else{
    			merged = new Interval(
    			Math.min(merged.start, cur.start),
    			Math.max(merged.end, cur.end) );
    		}
    	}
    	ans.add(merged);
    	return ans;
    }
    /*
     * concise：之前写过merge， 可以直接用：将newInterval插入到正确的intervals（sorted）的位置， 在merge
     * http://leetcodenotes.wordpress.com/2013/10/19/insert-interval/
     * O(n)的方法：binary search by start，找到一个要insert的位置(start1<start<=start2)，取那个大的start2（因为它肯定会被start给replace掉，start1则不一定）。
     * 插入这个新interval，然后从头到尾检查overlap（两个参数无论谁前谁后都能用这个helper查出来），有就merge，不断吞噬overlap的。代码写起来有点长，不过思路非常清晰，
     * 不用考虑任何边界条件（什么a.start <= b.end…那些都烦死人了）。interview的时候可以写这种，因为binary search那段可能都不让你写。

     */
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
    	int i = 0;
    	while( i < intervals.size() && intervals.get(i).start < newInterval.start ){
    		i++;
    	}
    	intervals.add(i, newInterval);
    	
    	return merge(intervals);
    }
    public List<Interval> merge(List<Interval> intervals) {    	
    	List<Interval> ans = new ArrayList<Interval>(); 
    	if(intervals.size() == 0) return ans;

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
