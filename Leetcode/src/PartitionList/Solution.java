package PartitionList;

public class Solution {
    public ListNode partitionNEW(ListNode head, int x) {
        if(head == null || head.next == null) return head;
        ListNode dumb = new ListNode(0);
        dumb.next = head;
        
        ListNode p1 = dumb;
        ListNode p2 = dumb;
        while(p2.next != null){
            if(p2.next.val >= x) p2 = p2.next;
            else{
                ListNode target = p2.next;
                p2.next = target.next;
                target.next = p1.next;
                p1.next = target;
                if(p1 == p2) p2 = p2.next;////////// hard to find, better create two lists as OLD
                p1 = p1.next;
                
            }
        }
        return dumb.next;
    }
    public ListNode partitionOLD(ListNode head, int x) {
    	ListNode dump = new ListNode(0);
    	dump.next = head;    	
    	ListNode p = dump;
    	ListNode largeDump = new ListNode(0);
    	ListNode q = largeDump;
    	while(p.next != null){
    		if(p.next.val < x){
    			p = p.next;
    		}  		
    		else{
    			q.next = p.next;
    			q = q.next;
    			p.next = p.next.next;
    		}
    	}
    	q.next = null;
    	p.next = largeDump.next;
    	return dump.next;
    }
}
