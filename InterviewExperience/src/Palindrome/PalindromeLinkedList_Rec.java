package Palindrome;

public class PalindromeLinkedList_Rec {
	private class Res{
		boolean b;
		Node n;
	}
	public boolean isPalin_rec(Node head){
		Node n = head;
		int len = 0;
		while( n != null ){
			len++;
			n = n.next;
		}
		return rec(head, len).b;
	}
	public Res rec(Node head, int len){
		if(len == 1){
			Res res = new Res();
			res.b = true;
			res.n = head.next;
			return res;
		}
		if(len == 0){
			Res res = new Res();
			res.b = true;
			res.n = head;
			return res;
		}
		// general
		Res res = rec(head.next, len - 2);
		if(!res.b)	return res;
		else{
			res.b = (res.n.val == head.val);
			res.n = res.n.next;
			return res;
		}
		
	}
	// tester
	public static void main(String[] args){
		Node head = new Node(1);
		//head.next = new Node(2);
		PalindromeLinkedList_Rec sol = new PalindromeLinkedList_Rec();
		System.out.println( sol.isPalin_rec(head) );
	}
}
