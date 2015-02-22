package chapter2_LLclass;

import java.util.LinkedList;
import java.util.ListIterator;

public class DeleteMiddle {

	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		for(int i = 1;i<5;i++){
			list.add(i);
		}
		for(int i = 4;i>0;i--){
			list.add(i);
		}
		System.out.println(list);
		
		DeleteMiddle d = new DeleteMiddle();
		d.delete(list,3);
		System.out.println(list);
	}
	public void delete(LinkedList<Integer> list, int val){
		ListIterator<Integer> iter = list.listIterator();
		while(iter.hasNext()){
			if (iter.next() == val){
				iter.remove();
			}
		}
	}

}
