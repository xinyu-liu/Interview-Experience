package Chapter3_class;

import java.util.Stack;

public class SortStackN2TimeNSpaceInsert {
	public Stack<Integer> sortStack(Stack<Integer> s){
		Stack<Integer> s2 = new Stack<Integer>();
		while(!s.isEmpty()){
			int val=s.pop();
			toInsert(val,s2,s);
		}
		
		return s2;
	}
	private void toInsert(int val,Stack<Integer> s2,Stack<Integer> s){
		if(s2.isEmpty()){
			s2.push(val);
			return;
		}
		int count =0;
		while(!s2.isEmpty()){
			count =0;
			if(s2.peek()<val){
				s.push(s2.pop());
				count++;
			}
			else{
				break;
			}
		}
		s2.push(val);
		for(int i=0;i<count;i++){
			s2.push(s.pop());
		}
	}
	public static void main(String[] args){
		SortStackN2TimeNSpaceInsert sort = new SortStackN2TimeNSpaceInsert();
		Stack<Integer> s = new Stack<Integer>();
		s.push(5);
		s.push(6);
		s.push(3);
		s.push(5);
		s.push(7);
		System.out.println(s);
		Stack<Integer> s2=sort.sortStack(s);
		System.out.println(s2);


	}
}
