package ImmutableStackAndQueue;
/*
 * http://blog.csdn.net/shoulinjun/article/details/31760103?utm_source=tuicool
 * 
��Ȥ�ĺ���ʽ���ݽṹ��һ��----���ɱ�ջ
ʲô�ǲ��ɱ䣿��ջ�в���һ��Ԫ�أ�ԭ����ջ���ֲ��䣬����һ���µ�ջ���Ѳ����µ�Ԫ�أ���
push, pop��getMax �Ȳ�����Ҫ���� ����ʱ������ɡ�

���ܶ��߻�����ɻ󣬼�ȻҪ����һ���µ�ջ���ǲ��Ǿͱ����ȿ���һ��ԭ����ջ��Ȼ�����µ�ջ�в���Ԫ�ء�
�����������ӶȾ������Եģ�����ܹ��ڳ���ʱ��������أ���
�������immutable DATA STRUCTRUE ��ǿ�󡣡�

���ĸ���һ��C++ ��ʵ�ְ汾�����������������ڴ湲���Լ���̯ʱ���˼�롣
��ͼ������ʵ�ֵĺ���˼�롣
��������[1,2,3], [1,2,4], [1,2,5]���ýڵ�1,2
������Ϊһ���ڵ�����ж��ǰ���ڵ�ָ������������ջ�����ԣ������������ͷ������ɾ�������ʱ�֤�˽ڵ�Ĺ���
 */
public class ImmutableStack{
	final Node head;
	final int count;
	public ImmutableStack(){ // new empty stack
		head = null;
		count = 0;
	}
	private ImmutableStack(Node h, int c){
		head = h;
		count = c;
	}
	public ImmutableStack push(int x){
		Node newHead = new Node(x);
		newHead.next = this.head;
		return new ImmutableStack(newHead, count+1);	
	}
	
	public ImmutableStack pop(){
		assert(!empty());
		Node newHead = head.next;
		return new ImmutableStack(newHead, count-1);	
	}
	
	public int peek(){
		assert(!empty());
		return (int) head.k;
	}
	
	public int size(){
		return count;
	}
	
	public boolean empty() { 
		return head == null;
	}
	public String toString(){
		StringBuffer sb = new StringBuffer();
		Node t = head;
		while(t != null){
			sb.append(t.k + " ");
			t = t.next;
		}
		return sb.toString();
	}
	
	
	// tester
	public static void main(String[] args){
		ImmutableStack[] stacks = new ImmutableStack[10];
		stacks[0] = new ImmutableStack();
		
		for(int i = 1; i < 10; ++i)   stacks[i] = stacks[i-1].push(i);
		stacks[9] = stacks[9].pop();
		//print
		for(int i = 0; i < 10; ++i)   System.out.println( stacks[i].toString() ); 
	}
	
	
}