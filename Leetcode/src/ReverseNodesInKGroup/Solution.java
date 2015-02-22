package ReverseNodesInKGroup;

public class Solution {
    public ListNode reverseKGroupNew(ListNode head, int k) {
        if(head == null || k == 1) return head;
        ListNode dumb = new ListNode(0);
        dumb.next = head;
        // check whether k enough
        ListNode insert = dumb;
        
        while(true){
            ListNode end = insert;
            int count = 0;
            while(end != null && count<= k){
                end = end.next;
                count++;
            }
            if(count <= k){
                break;
            }
            ListNode p = insert.next;
            while(p.next != end){
                ListNode target = p.next;
                p.next = target.next;
                target.next = insert.next;
                insert.next = target;
            }
            insert = p;
        } 
        return dumb.next;
    }
    public ListNode reverseKGroupOld(ListNode head, int k) {
    	ListNode dump = new ListNode(0);
    	dump.next = head;   	   	
    	
    	ListNode to = dump;
    	ListNode from = to.next;
    	
    	boolean isContinue = true;
    	while(isContinue){
    		ListNode temp = to;
	    	for(int i = 0; i < k && isContinue; i++){
	    		temp = temp.next;
	    		if(temp == null){
	    			isContinue = false;
	    		}
	    	}
	    	for(int i = 1; i < k && isContinue; i++){    	
		    	temp = to.next;
		    	to.next = from.next;
		   		from.next = from.next.next;
		   		to.next.next = temp;
	    	}
	    	if(isContinue){ //NOTE: this if is necessary,
	    		// without, the assignment from = to.next 
	    		// create java.lang.NullPointerException
	    		to = from;
	    		from = to.next;
	    	}
    	}
    	return dump.next;
    }
}
