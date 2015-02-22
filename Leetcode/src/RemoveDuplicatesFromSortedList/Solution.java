package RemoveDuplicatesFromSortedList;

public class Solution {
	// II
	public ListNode deleteDuplicates(ListNode head) {		
		ListNode p = head;
    	if(p == null || p.next == null){
    		return head;
    	}
    	
		ListNode dump = new ListNode(0);		
		dump.next = head;
		ListNode prev = dump;
		
		while(p!=null && p.next != null){
			if(p.val == p.next.val){
	    		while(p.next != null && p.val == p.next.val){
	    			p = p.next;
	    		}
	    		prev.next = p.next;
	    		p = p.next;
			}
    		else{
    			prev = p;
    			p = p.next;
    		}
    	}
		return dump.next;
	}
	// I
    public ListNode deleteDuplicatesI(ListNode head) {
    	ListNode p = head;
    	if(p == null || p.next == null){
    		return head;
    	}
    	while(p.next != null){
    		if(p.val == p.next.val){
    			p.next = p.next.next;
    		}
    		else{
    			p = p.next;
    		}
    	}
    	return head;
    }
}
