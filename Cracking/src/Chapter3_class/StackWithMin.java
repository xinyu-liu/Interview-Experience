package Chapter3_class;
import java.util.Stack;
public class StackWithMin extends Stack<Integer>{
	Stack<Integer> sMin;
	
	public StackWithMin(){
		sMin = new Stack<Integer>();
	}
	
	public void push(int val){
		if( val<= peekMin() ){
			sMin.push(val);
		}
		super.push(val);
	}
	
	public Integer pop(){
		if(peek()==peekMin()){
			sMin.pop();
		}
		return super.pop();
	}
	
	public Integer peek(){
		return super.peek();
	}
	
	public Integer peekMin(){
		if(sMin.empty()){
			return Integer.MAX_VALUE;
		}
		else{
			return (Integer) sMin.peek();
		}
	}
	
	public String toString(){
		return super.toString();
	}
	public static void main(String[] args) {
		StackWithMin s = new StackWithMin();
		s.push(5);
		System.out.println(s);System.out.println(s.peekMin());
		s.push(6);
		System.out.println(s);System.out.println(s.peekMin());
		s.push(3);
		System.out.println(s);System.out.println(s.peekMin());
		s.push(7);
		System.out.println(s);System.out.println(s.peekMin());
		s.pop();
		System.out.println(s);System.out.println(s.peekMin());
		s.pop();
		System.out.println(s);System.out.println(s.peekMin());
		
	}

}
