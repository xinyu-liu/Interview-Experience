package SwapNodesInPairs;

public class Solution {
    public ListNode swapPairs(ListNode head) {
    	ListNode dump = new ListNode(0);
    	dump.next = head;
    	ListNode p = dump;
    	
    	while(p.next!=null && p.next.next!=null){
    		ListNode f = p.next;
    		ListNode s = f.next;
    		p.next = s;
    		f.next = s.next;
    		s.next = f;
    		p = f;   //NOTE: not p = s; because now the 2nd one is the f
    	}
    	return dump.next;
    }
}
