package Chapter3_class;
import java.util.Stack;

public class QueueUsing2Stacks {
	Stack<Integer> head;
	Stack<Integer> tail;
	
	public QueueUsing2Stacks(){
		head=new Stack<Integer>();
		tail=new Stack<Integer>();
	}
	public void enqueue(int val){
		tail.push(val);
	}
	public Integer dequeue(){
		if (head.empty()){
			while (!tail.empty()){
				head.push( tail.pop() );
			}
		}
		return head.pop();
	}
	public Integer peek(){
		if (head.empty()){
			while (!tail.empty()){
				head.push( tail.pop() );
			}
		}
		return head.peek();
			
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
