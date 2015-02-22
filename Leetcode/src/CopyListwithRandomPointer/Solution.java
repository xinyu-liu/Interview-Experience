package CopyListwithRandomPointer;

import java.util.HashMap;

public class Solution {
	// http://blog.csdn.net/fightforyourdream/article/details/16879561
	public RandomListNode copyRandomList(RandomListNode head) {
		if(head == null){
			return null;
		}
		// copy one to form A-A`-B-B`-C-C`... according to next
		RandomListNode n = head;
		RandomListNode temp;
		while (n != null){
			temp = n.next;
			n.next = new RandomListNode(n.label);
			n.next.next = temp;
			n = n.next.next;
		}
		// find A-random, set A`-random to A-random-next
		n = head;
		while (n != null){
			if(n.random == null){
				n.next.random = null;
			}
			else{
				n.next.random = n.random.next;
			}
			n = n.next.next;
		}
		// Recover original list and new list
		RandomListNode head2 = head.next;
		n = head;
		while (n != null){
			temp = n.next;
			n.next = temp.next;
			if(temp.next!=null){
				temp.next = temp.next.next;
			}
			n = n.next;
		}
		return head2;
	}
    public RandomListNode copyRandomListHASHMAP(RandomListNode head) {
        HashMap<RandomListNode,RandomListNode> map = new HashMap<RandomListNode,RandomListNode>();
        RandomListNode dumb = new RandomListNode(0);
        
        RandomListNode q = dumb;
        RandomListNode p = head;
        // create and copy next
        while(p != null){
            RandomListNode copy = new RandomListNode(p.label);
            map.put(p, copy);
            q.next = copy;
            q = q.next;
            p = p.next;
        }
        // copy random
        p = head;
        q = dumb.next;
        while(p != null){
            RandomListNode target = p.random;
            if(target != null){
                q.random = map.get(target);
            }
            
            q = q.next;
            p = p.next;
        }
        return dumb.next;
    }
}
