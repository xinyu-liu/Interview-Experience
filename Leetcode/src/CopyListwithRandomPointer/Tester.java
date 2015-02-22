package CopyListwithRandomPointer;

public class Tester {

	public static void main(String[] args) {
		Solution s = new Solution();
		RandomListNode n1 = new RandomListNode(1);
		RandomListNode n2 = new RandomListNode(2);
		RandomListNode n3 = new RandomListNode(3);
		RandomListNode n4 = new RandomListNode(4);
		
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = null;
		
		n1.random = n3;
		n2.random = n3;
		n3.random = n3;
		n4.random = n3;
		
		RandomListNode newList = s. copyRandomList(n1);
		
		System.out.println(newList);

	}

}
