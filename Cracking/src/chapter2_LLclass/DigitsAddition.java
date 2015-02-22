package chapter2_LLclass;

import java.util.LinkedList;
import java.util.ListIterator;

public class DigitsAddition {
	public static void main(String[] args) {
		LinkedList<Integer> list1 = new LinkedList<Integer>();
		LinkedList<Integer> list2 = new LinkedList<Integer>();
		list1.add(7);
		list1.add(1);
		list1.add(7);
		
		list2.add(5);
		list2.add(9);
		list2.add(2);
		
		System.out.println(list1);
		System.out.println(list2);
		
		DigitsAddition d = new DigitsAddition();
		LinkedList<Integer> list3 = d.additionOfReverse(list1,list2);
		System.out.println(list3);
	}
	public LinkedList<Integer> additionOfReverse(LinkedList<Integer> l1, LinkedList<Integer> l2){
		LinkedList<Integer> ans = new LinkedList<Integer>();
		ListIterator<Integer> iter1 = l1.listIterator();
		ListIterator<Integer> iter2 = l2.listIterator();
		int carry=0;
		while(iter1.hasNext() || iter2.hasNext() || carry==1){
			int i = 0;
			if(iter1.hasNext()){
				i += iter1.next();
			}
			if(iter2.hasNext()){
				i+= iter2.next();
			}
			
			i+=carry;
			carry = 0;
			if(i>9){
				i-=10;
				carry=1;
			}
			ans.add(i);
				
		}
		
		return ans;
		
	}
}
