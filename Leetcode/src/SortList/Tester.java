package SortList;

public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		// int[] arr = {1,2,3};
		 ListNode n3 = new ListNode (1,null);
		 ListNode n2 = new ListNode (2,n3);
		 // ListNode n1 = new ListNode (1,n2);
		 ListNode n = s.sortList(n2);
		
	}

}
