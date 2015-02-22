package MergekSortedLists;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
/*
 * CHAPTER 4 PriorityQueue
PriorityQueue<MyThread> q = new PriorityQueue<MyThread>(10, new Comparator<MyThread>() {
 
    public int compare(MyThread o1, MyThread o2) {
        return o1.weight - o2.weight;
    }
     
});
q.offer(new MyThread(5));// q.add();
q.offer(new MyThread(7));
q.offer(new MyThread(2));
q.offer(new MyThread(6));
q.offer(new MyThread(8));
System.out.println(Arrays.toString(q.toArray()));

在多线程共享这个队列的情况下不能使用PriorityQueue，而应该使用PriorityBlockingQueue
默认的排序是升序

 */
public class Solution {
	class ListComparator implements Comparator<ListNode>{
		@Override
		public int compare(ListNode l1, ListNode l2) {
			return l1.val - l2.val;
		}
	}
    public ListNode mergeKLists(List<ListNode> lists) {
    	if(lists == null || lists.size() == 0){
    		return null;
    	}
    	ListNode dump = new ListNode(0);
    	ListNode cur = dump;
    	ListComparator comparator = new ListComparator();
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(lists.size(), comparator);
        for(ListNode n: lists){
        	if(n!=null)
        		pq.add(n);
        }
        while(!pq.isEmpty()){
	        ListNode min = pq.remove();
	        cur.next = min;
	        cur = min;
	        if(min.next!=null)
	        	pq.add(min.next);
        }
        cur.next = null;
        return dump.next;
    }
	
}