package Palindrome;

import java.util.Stack;

public class PalindromeLinkedList_Iter {
	public boolean isPalin_stack(Node head){
		Node mid = findMid(head);
		Stack<Node> stack = new Stack<Node>();
		while(mid != null){
			stack.add(mid);
			mid = mid.next;
		}
		Node n = head;
		while(!stack.empty()){
			Node c = stack.pop();
			if(c.val != n.val){
				return false;
			}
			n = n.next;
		}
		return true;
	}	
	private Node findMid(Node head){
		Node f = head;
		Node s = head;
		while(f != null && f.next != null){
			f = f.next.next;
			s = s.next;
		}
		return s;
	}
	
	// tester
	public static void main(String[] args){
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(1);
		PalindromeLinkedList_Iter sol = new PalindromeLinkedList_Iter();
		System.out.println( sol.isPalin_stack(head) );
	}
}
