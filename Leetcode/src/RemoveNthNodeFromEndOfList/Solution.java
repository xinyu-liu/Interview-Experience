package RemoveNthNodeFromEndOfList;

public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dump = new ListNode(0);
        dump.next = head;
        
        ListNode slow = dump;
        ListNode fast = dump;
        for(int i = 0; i < n+1 && fast != null; i++){
        	fast = fast.next;
        }
        while(fast!=null){
        	fast = fast.next;
        	slow = slow.next;
        }
        slow.next = slow.next.next;
        return dump.next;
    }
    
}
