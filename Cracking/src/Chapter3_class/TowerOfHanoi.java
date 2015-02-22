package Chapter3_class;
import java.util.Stack;
public class TowerOfHanoi {
	public void move(int numberOfDisks, Stack<Integer> s,Stack<Integer> e,Stack<Integer> v ){
		if(numberOfDisks==1){
			e.push(s.pop());
		}
		else{
		move(numberOfDisks-1,s,v,e);
		e.push(s.pop());
		
		move(numberOfDisks-1,v,e,s);
		}
	}
	public static void main(String[] args) {
		int n = 3;
		TowerOfHanoi t=new TowerOfHanoi();
		Stack<Integer> s1=new Stack<Integer>();
		for (int i=0;i<n;i++){
			s1.push(i);
		}
		Stack<Integer> s2=new Stack<Integer>();
		Stack<Integer> s3=new Stack<Integer>();
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		System.out.println();
		t.move(n, s1, s3, s2);
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
	}

}
