package ReverseLinkedListII;

public class Solution {
	/*
	 Input:	{1,2,3,4}, 1, 4
	 Output:	{4,2,3,1}
	 Expected:	{4,3,2,1}
	 */
    public ListNode reverseBetween(ListNode head, int m, int n) {
    	if(head == null || m == n){
    		return head;
    	}
    	ListNode dump = new ListNode(0);
    	dump.next = head;
    	
    	ListNode prevSub = dump;
    	ListNode postSub = dump;
    	
    	for(int i = 1; i < m; i++){
    		prevSub = prevSub.next;
    	}
    	for(int i = -1; i < n; i++){
    		postSub = postSub.next;
    	}
    	   	
    	ListNode prev = prevSub.next;   	
    	ListNode cur = prev.next;
    	ListNode post = cur.next;
    	prev.next = postSub;   	   	
    	while( cur != postSub){ 
    		post = cur.next;
    		cur.next = prev;
    		prev = cur;
    		cur = post;
    	}
    	prevSub.next = prev;
    	
    	return dump.next;
    }
}