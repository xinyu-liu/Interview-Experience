package RotateList;

public class Solution {
    public ListNode rotateRight(ListNode head, int n) {
    	if(head == null || n==0){
    		return head;
    	}
    	ListNode fast = head;
    	ListNode slow = head;
    	ListNode head2 = head;
    	int count = 0;
    	while (fast!=null && count < n){
    		fast = fast.next;
    		count++;
    	}
    	if(fast == null){
    		n = n % count;
        	if(n==0){
        		return head;
        	}
    		fast = head;
        	count = 0;
        	while (fast!=null && count < n){
        		fast = fast.next;
        		count++;
        	}
    	}
    	while (fast.next!=null){
    		fast = fast.next;
    		slow = slow.next;
    	}
    	head2 = slow.next;
    	fast.next = head;
    	slow.next = null;

    	return head2;
    }
}
