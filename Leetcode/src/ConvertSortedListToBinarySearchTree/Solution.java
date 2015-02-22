package ConvertSortedListToBinarySearchTree;

public class Solution {
	// sample
    public static TreeNode sortedListToBST(ListNode head) {  
        return rec(head, null);  
    }  
    // ������[start, end)��ݹ飬�����end�ǰ������ڵģ��������Ա���Ҫ����һ��ָ������¼midǰ�Ľڵ�  
    public static TreeNode rec(ListNode start, ListNode end){  
        if(start == end){  
            return null;  
        }  
        // һ�α����ҵ��е�ķ���������ָ��  
        ListNode mid = start;           // ��ָ�����ջ�ָ���е�  
        ListNode probe = start;         // ̽�����ջᵽ��end  
        while(probe!=end && probe.next!=end){
        	/////////////////// ̽�����������ע��ֹͣ�����Ǻ�end�Ƚ϶����Ǻ�null�ȣ�  
            mid = mid.next;  
            probe = probe.next.next;  
        }          
        TreeNode root = new TreeNode(mid.val);  
        root.left = rec(start, mid);  
        root.right = rec(mid.next, end);  
        return root;  
    }  
   
	// mine
    public TreeNode sortedListToBST_MINE(ListNode head) {
        return transfer(head,null);     
    }
    public TreeNode transfer(ListNode start, ListNode end) {
    	if(start == end){
    		return null;
    	}
    	// find mid
    	ListNode mid = start;
    	ListNode fast = start;
    	while(fast!= end && fast.next!= end){
    		fast = fast.next.next;
    		mid = mid.next;
    	}
    	
        TreeNode root = new TreeNode(mid.val);
        root.left = transfer(start, mid);
        root.right = transfer(mid.next, end);
        return root;   
    }
}
