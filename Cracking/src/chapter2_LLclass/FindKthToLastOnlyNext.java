package chapter2_LLclass;

import java.util.LinkedList;
import java.util.ListIterator;

public class FindKthToLastOnlyNext {

	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		for(int i = 1;i<5;i++){
			list.add(i);
		}
		for(int i = 4;i>0;i--){
			list.add(i);
		}
		System.out.println(list);
		FindKthToLastOnlyNext f = new FindKthToLastOnlyNext();
		
		System.out.println(f.optimal(list,0));
	}
	// 1 <= k <= list.size()
	public int optimal(LinkedList<Integer> list,int k){
		// iter start from 1
		ListIterator<Integer> iter1 = list.listIterator();
		// iter start from k
		ListIterator<Integer> iterk = list.listIterator();
		for(int i = 0; i < k; i++){
			if(iterk.hasNext()){
				iterk.next();
			}
		}
		// move together
		while(iterk.hasNext()){
				iterk.next();
				iter1.next();
		}
		int ans = iter1.next();
		return ans;
	}


}
