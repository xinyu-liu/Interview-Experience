package chapter2_LLclass;

import java.util.LinkedList;
import java.util.ListIterator;

public class RemoveDuplicatesUnsorted {

	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		for(int i = 1;i<5;i++){
			list.add(i);
		}
		for(int i = 4;i>0;i--){
			list.add(i);
		}
		System.out.println(list);
		RemoveDuplicatesUnsorted r = new RemoveDuplicatesUnsorted();
		r.solveNoTemp(list);
		System.out.println(list);
	}
	
	public void solveNoTemp(LinkedList<Integer> list){
		// special cases
		if(list==null || list.size()<2){
			return;
		}
		
		
		ListIterator<Integer> iter;
		ListIterator<Integer> tIter = list.listIterator();
		
		int startSearch = 1;
		while(tIter.hasNext()){
			
			tIter = list.listIterator(startSearch-1);
			int t = tIter.next();
			
			
			iter = list.listIterator();
			for(int i=0;i<startSearch;i++){
				if(iter.hasNext()){
					iter.next();
				}
				else{
					return;
				}
			}
			startSearch++;
			
			while(iter.hasNext()){
				int c = iter.next();
				if(c==t){
					iter.remove();
				}
			}
		}
		
	}

}
