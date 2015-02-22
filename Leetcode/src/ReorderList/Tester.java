package ReorderList;

public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		// {1,2,3,4};
		ListNode n4 = new ListNode (4,null);
		ListNode n3 = new ListNode (3,n4);
		ListNode n2 = new ListNode (2,n3);
		ListNode n1 = new ListNode (1,n2);
		s.reorderList(n1);
		
	}

}
