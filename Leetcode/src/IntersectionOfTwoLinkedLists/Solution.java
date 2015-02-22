package IntersectionOfTwoLinkedLists;
/*
 * Status: Time Limit Exceeded
Submitted: 0 minutes ago
Last executed input:	No intersection: {1,3,5,7,9,11,13,15,17,19,21}, {2}

 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int len1 = findLen(headA);
        int diff21 = findLen(headB) - len1;
        ListNode n1 = headA;
        ListNode n2 = headB;
        while (diff21 > 0){
        	n2 = n2.next;
        	diff21--;
        }
        while (diff21 < 0){
        	n1 = n1.next;
        	diff21++;
        }
        while(n1 != null){
        	if(n1 == n2) return n1;
        	n1 = n1.next;
        	n2 = n2.next;
        }
        return n1;        
    }   
    private int findLen(ListNode head){
    	int count = 0;
    	ListNode n = head;
    	while(n != null){
    		count++;
    		n = n.next;
    	}
    	return count;
    }
}
