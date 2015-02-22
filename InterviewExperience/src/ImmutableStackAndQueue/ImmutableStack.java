package ImmutableStackAndQueue;
/*
 * http://blog.csdn.net/shoulinjun/article/details/31760103?utm_source=tuicool
 * 
有趣的函数式数据结构《一》----不可变栈
什么是不可变？往栈中插入一个元素，原来的栈保持不变，返回一个新的栈（已插入新的元素）。
push, pop，getMax 等操作都要求在 常数时间内完成。

可能读者会产生疑惑，既然要返回一个新的栈，是不是就必须先拷贝一份原来的栈，然后在新的栈中插入元素。
但是这样复杂度就是线性的，如何能够在常数时间内完成呢？？
这里，就是immutable DATA STRUCTRUE 的强大。。

本文给出一个C++ 的实现版本，基本理想是利用内存共享，以及均摊时间的思想。
下图给出了实现的核心思想。
三个链表[1,2,3], [1,2,4], [1,2,5]共用节点1,2
这是因为一个节点可以有多个前驱节点指向它本身。。而栈的特性：仅仅在链表的头部插入删除的性质保证了节点的共享。
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