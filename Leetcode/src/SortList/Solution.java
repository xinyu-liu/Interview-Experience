package SortList;

public class Solution {
    public ListNode sortList(ListNode head) {
        return sort(head);
    }
    // return new head;
    public ListNode sort(ListNode head){
        if(head==null || head.next == null){
            return head;
        }
        
        ListNode mid = findMid(head); // 1: head,mid    2: mid.next
        ListNode second = mid.next;
        mid.next = null;
        ListNode h1 = sort(head);
        ListNode h2 = sort(second);
        if(h1==null){
            return h2;
        }
        if(h2==null){
            return h1;
        }
        ListNode h;
        if(h1.val<=h2.val){
            h = h1;
            h1 = h1.next;
        }
        else{
            h = h2;
            h2 = h2.next;
        }
        ListNode finalH = h;
        while (h1!=null && h2!=null){
             if(h1.val<=h2.val){
                h.next = h1;
                h1 = h1.next;
             }
            else{
                h.next = h2;
                h2 = h2.next;
            }
            h = h.next;
        }
        if(h1!=null){
            h.next = h1;
        }
        if(h2!=null){
            h.next = h2;
        }
        return finalH;
    }
    private ListNode findMid(ListNode head){ 
    	
        if(head==null || head.next == null){
            return head;
        }
        ListNode perOne = head;
        ListNode perTwo = head;
        while(perTwo.next!=null && perTwo.next.next!=null){
            perOne = perOne.next;
            perTwo = perTwo.next.next;
        }
        return perOne;
    }
}