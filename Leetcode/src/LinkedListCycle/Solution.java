package LinkedListCycle;

public class Solution {
	// I
    public boolean hasCycle(ListNode head) {
        if(head == null) return false;
        ListNode walker = head;
        ListNode runner = head;
        while(runner.next != null && runner.next.next != null){
            runner = runner.next.next;
            walker = walker.next;
            if(runner == walker) return true;
        }
        return false;
    }
    // II
    public ListNode detectCycle(ListNode head) {
        if(head == null) return null;
        ListNode runner = head;
        ListNode walker = head;
        while(runner.next != null && runner.next.next != null){
            runner = runner.next.next;
            walker = walker.next;
            if(runner == walker){
                walker = head;
                while(walker != runner){
                    walker = walker.next;
                    runner = runner.next;
                }
                return walker;
            }
        }
        return null;
    }
}
