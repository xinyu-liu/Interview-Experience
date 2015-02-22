package CopyListwithRandomPointer;

public class SolutionBruteForce {
    public RandomListNode copyRandomList(RandomListNode head) {
    	if(head == null){
    		return null;
    	}
    	RandomListNode head2 = new RandomListNode(head.label);
    	RandomListNode n = head;
    	RandomListNode n2 = head2;
    	
    	// copy node through next node
    	while(n.next != null){
    		n2.next = new RandomListNode(n.next.label);
    		n=n.next;
    		n2=n2.next;
    	}
    	n2.next = null;
    	// match random node
    	
    	RandomListNode cur = head;
    	RandomListNode cur2 = head2;
    	while (cur!=null){
	    	RandomListNode target = cur.random;
	    	if(target == null){
	    		cur2.random = null;
	    	}
	    	else{
	    		n = head;
	    		n2 = head2;
	    		while (n != null && target != n){
	    			n = n.next;
	    			n2 = n2.next;
	    		}
	    		cur.random = n2;
	    	}
	    	cur = head.next;
	    	cur2 = head2.next;
    	}
    	return head2;
    }
}
