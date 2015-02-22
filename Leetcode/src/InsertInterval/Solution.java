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
     * concise��֮ǰд��merge�� ����ֱ���ã���newInterval���뵽��ȷ��intervals��sorted����λ�ã� ��merge
     * http://leetcodenotes.wordpress.com/2013/10/19/insert-interval/
     * O(n)�ķ�����binary search by start���ҵ�һ��Ҫinsert��λ��(start1<start<=start2)��ȡ�Ǹ����start2����Ϊ���϶��ᱻstart��replace����start1��һ������
     * ���������interval��Ȼ���ͷ��β���overlap��������������˭ǰ˭���������helper����������о�merge����������overlap�ġ�����д�����е㳤������˼·�ǳ�������
     * ���ÿ����κα߽�������ʲôa.start <= b.end����Щ���������ˣ���interview��ʱ�����д���֣���Ϊbinary search�Ƕο��ܶ�������д��

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
