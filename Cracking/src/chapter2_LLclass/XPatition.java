package chapter2_LLclass;

import java.util.LinkedList;
import java.util.ListIterator;

public class XPatition {
	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		for(int i = 1;i<5;i++){
			list.add(i);
		}
		for(int i = 4;i>0;i--){
			list.add(i);
		}
		System.out.println(list);
		
		XPatition x = new XPatition();
		x.patition(list,3);
		System.out.println(list);
	}
	public void patition(LinkedList<Integer> list, int val){
		ListIterator<Integer> iter = list.listIterator();
		LinkedList<Integer> newList = new LinkedList<Integer>();
		ListIterator<Integer> newIter = newList.listIterator();
		while(iter.hasNext()){
			int i = iter.next();
			if ( i >= val){
				iter.remove();
				newIter.add(i);
				
			}
		}
		list.addAll(newList);
		list = newList;
		
	}
}
