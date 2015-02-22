package ReverseLinkedListWithRecursion;

public class ReverseLinkedListWithRecursion {
	private class Node{
		int val;
		Node next;
		Node(int v){
			val = v;
		}
	}
	private class Res{
		Node newHead;
		Node last;
	}
	public Node solve(Node head){
		if(head == null) return head;
		Res ans = dfs(head);
		ans.last.next = null; ////// important!!
		return ans.newHead;
	}
	private Res dfs( Node head ){
		if(head.next == null){
			Res ans = new Res();
			ans.newHead = head;
			ans.last = head;
			return ans;
		}
		Res ans = dfs(head.next);
		ans.last.next = head;
		ans.last = head;
		return ans;
	}
	private void printList(Node n){
		while( n != null){
			System.out.print(n.val + " ");
			n = n.next;
		}
		System.out.println();
	}
	public void run(){
		/*
		Node n1 = null;
		 * 
		Node n1 = new Node(1);
		n1.next = null;
		 */
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = null;
		printList(solve(n1));
	}
	public static void main (String[] args) throws java.lang.Exception
	{
		ReverseLinkedListWithRecursion sol = new ReverseLinkedListWithRecursion();
		sol.run();
	}
}
