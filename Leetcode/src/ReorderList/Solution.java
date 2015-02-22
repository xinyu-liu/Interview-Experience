package ReorderList;

import java.util.Stack;

public class Solution {
	// NEW O(1) space
    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) return;
        ListNode mid = findMid(head);
        // deal with right: reverse
        reverse(mid);
        // weave
        ListNode p = head;
        while(p != mid && mid.next != null){ //////////////p != mid important!!!!!! (p != null can substitute)
            ListNode target = mid.next;
            mid.next = target.next;
            target.next = p.next;
            p.next = target;
            p = p.next.next;
        }
    }
    private void reverse(ListNode pre){
        ListNode last = pre.next;
        while(last.next != null){
            ListNode cur = last.next;
            last.next = cur.next;
            cur.next = pre.next;
            pre.next = cur;
        }
    }
    private ListNode findMid(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    
    
    // OLD using stack, O(n) space
    public void reorderListStack(ListNode head) {
    	int length = 0;
    	int end = 0;
    	ListNode p = head;
    	ListNode temp;
    	Stack<ListNode> stack = new Stack<ListNode>();
    	// find mid
        while(p!=null){
        	length++;
        	p = p.next;
        }
        if(length<3){
        	return;
        }
        end = (int) Math.ceil((double)length / 2.0);
        // push end half
        p =head;
   		for (length = 1; length < end; length++){
   			p = p.next;
   		}
   		temp = p.next;
   		p.next = null;
   		p = temp; // now p is fist one to push
   		while(p!=null){
   			stack.push(p);
   			p = p.next;
   		}
   		// insert into list
   		p = head;
   		while (!stack.isEmpty()){
   			ListNode popOut;
   			temp = p.next;
   			popOut = stack.pop();
   			p.next = popOut;
   			popOut.next = temp;
   			p = p.next.next;
   			
   		}
   		return;
    }
}
