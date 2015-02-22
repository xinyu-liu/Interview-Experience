package SortListUsingInsertionSort;

public class Solution {
    public ListNode insertionSortList(ListNode head) {
    	if( head==null || head.next==null ){
    		return head;
    	}
    	ListNode p =head;
    	ListNode s = head;
    	ListNode tempS,nextP;
    	p = p.next;
    	s.next = null;
    	
    	while(p != null){
    		nextP = p.next;
    		s = head;
    		if(s.val > p.val){
    			p.next = s;
    			head = p;
    		}
    		else{
    			while(s.next!= null && s.next.val <= p.val){
    				s = s.next;
    			}
    			tempS = s.next;
    			s.next = p;
    			p.next = tempS;
    		}
    		p=nextP;
    	}
    	return head;
    }
}
