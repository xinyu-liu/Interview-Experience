package AddTwoNumbers;

public class Solution {
    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
    	int carry = 0;
    	ListNode dump = new ListNode(0);
        ListNode p = dump;
    	while(l1 != null && l2 != null){
    		int cur = l1.val+ l2.val + carry;
    		carry = cur / 10;
    		p.next = new ListNode( cur % 10);
    		p = p.next;
    		l1 = l1.next;
    		l2 = l2.next;
    	}
    	while(l1 != null){
    		int cur = l1.val + carry;
    		carry = cur / 10;
    		p.next = new ListNode( cur % 10);
    		p = p.next;
    		l1 = l1.next;
    	}
    	while( l2 != null){
    		int cur =  l2.val + carry;
    		carry = cur / 10;
    		p.next = new ListNode( cur % 10);
    		p = p.next;
    		l2 = l2.next;
    	}
    	if(carry>0){
    		p.next = new ListNode( carry );
    	}
    	return dump.next;
    }
    public ListNode addTwoNumbersNeat(ListNode l1, ListNode l2) {
    	int carry = 0;
    	ListNode dump = new ListNode(0);
        ListNode p = dump;
    	while(l1 != null || l2 != null){
    		int cur = carry;
    		if(l1 != null){
    			cur += l1.val;
    			l1 = l1.next;
    		}
    		if(l2 != null){
    			cur += l2.val;
    			l2 = l2.next;
    		}
    		carry = cur / 10;
    		p.next = new ListNode( cur % 10);
    		p = p.next;
		
    	}
    	if(carry>0){
    		p.next = new ListNode( carry );
    	}
    	return dump.next;
    }
}
