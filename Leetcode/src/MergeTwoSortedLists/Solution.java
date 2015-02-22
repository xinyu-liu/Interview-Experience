package MergeTwoSortedLists;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(2, new Comparator<ListNode>(){
        			public int compare(ListNode n1, ListNode n2){
        				return n1.val - n2.val;
        			}
        } );
        if(l1 != null){
        	pq.add(l1);
        	
        }
        if(l2 != null){
        	pq.add(l2);
        	
        }
        ListNode dump = new ListNode(0);
        ListNode n = dump;
        while(!pq.isEmpty()){
	        ListNode cur = pq.remove();
	        n.next = cur;
	        n = n.next;
	        if(cur.next != null){
	        	pq.add(cur.next);
	        }
        }
        return dump.next;
    }
}
