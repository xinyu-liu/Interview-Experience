package Chapter3_class;

import java.util.ArrayList;
import java.util.Stack;

public class SetOfStacks {
	ArrayList<Stack<Integer>> arr;
	int threshold;
	int sizeOfCurrent;
	
	public SetOfStacks(int thres){
		 arr = new ArrayList<Stack<Integer>>();
		Stack<Integer> stack = new Stack<Integer>();
		arr.add(stack);
		 threshold = thres;
	}
	
	public void push(int val){
		Stack<Integer> last = arr.get(arr.size()-1);
		if(last.size()>=threshold){
			Stack<Integer> stack = new Stack<Integer>();
			arr.add(stack);
			stack.push(val);
		}
		else{
			last.push(val);
		}
	}
	
	public Integer pop(){
		if(arr.size()<1){
			return null;
		}
		Stack<Integer> last = arr.get(arr.size()-1);
		int val = last.pop();
		if(last.size()<=0){
			arr.remove(arr.size()-1);
		}
		return val;
	}
	public Integer peek(){
		if(arr.size()>1){
			return arr.get(arr.size()-1).peek();
		}
		else{
			return null;
		}
	}
	public void debug(){
		for(int i=0;i<arr.size();i++){
			System.out.println(arr.get(i));
		}
		System.out.println();
	}
	public Integer popAt(int index){	// 0 <= index < arr.size()
		if(arr.size()<1){
			return null;
		}
		Stack<Integer> stack = arr.get(index);
		int val = stack.pop();
		
		if( index!=(arr.size()-1) ) { // delete not last stack, move all after
			for(int i=index+1;i<arr.size(); i++){
				
				Stack<Integer> temp = new Stack<Integer>();
				Stack<Integer> thisStack = arr.get(i);
				
				while(!thisStack.isEmpty()){
					temp.push( thisStack.pop() );
				}
				
				arr.get(i-1).push(temp.pop());
				while(!temp.isEmpty()){
					thisStack.push(temp.pop());
				}
				
			}
			if( arr.get(arr.size()-1).isEmpty() ){
				arr.remove(arr.size()-1);
			}
			//System.out.println(arr.size());
		}
		return val;
		
	}
	public static void main(String[] args) {
		SetOfStacks s = new SetOfStacks(2);
		s.peek();
/*		
		s.push(5);
		s.debug();
		s.push(6);
		s.debug();
		s.push(3);
		s.debug();
		s.push(7);
		s.debug();
		s.pop();
		s.debug();
		s.pop();
		s.debug();
*/		

		s.push(5);
		s.push(6);
		s.push(3);
		s.push(7);
		s.debug();

		s.popAt(1);
		s.debug();
	}

}
