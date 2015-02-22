package Chapter3_class;

import java.util.Stack;

public class SortStackN2Time2NSpaceFindMin {
	public Stack<Integer> sortStack(Stack<Integer> s){
		Stack<Integer> buffer = new Stack<Integer>();
		Stack<Integer> s2 = new Stack<Integer>();
		while(!s.isEmpty()){ 
			int max = findMax(s,buffer);
			pushMax(max,s,buffer,s2);
		}
		
		return s2;
	}
	private int findMax(Stack<Integer> s,Stack<Integer> buffer){
		//find max
		int max=Integer.MIN_VALUE;
		while(!s.isEmpty()){
			int val = s.pop();
			buffer.push(val);
			if(val>max){
				max=val;
			}
		}
		return max;
	}
	private void pushMax(int max,Stack<Integer> s,Stack<Integer> buffer,Stack<Integer> to){
		while(!buffer.isEmpty()){
			int val = buffer.pop();
			if(val==max){
				to.push(val);
			}
			else{
				s.push(val);
			}
		}
	}
	public static void main(String[] args){
		SortStackN2Time2NSpaceFindMin sort = new SortStackN2Time2NSpaceFindMin();
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
