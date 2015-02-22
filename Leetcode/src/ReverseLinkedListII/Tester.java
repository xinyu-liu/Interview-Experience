package ReverseLinkedListII;

public class Tester {

	public static void main(String[] args) {

		Solution sol = new Solution();
		ListNode head = new ListNode(3);
		ListNode n2 = new ListNode(5);
		head.next = n2;
		ListNode ans = sol.reverseBetween(head, 1, 2);
		System.out.print(ans);
	}

}
