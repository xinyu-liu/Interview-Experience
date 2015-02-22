package ImmutableStackAndQueue;

import java.util.NoSuchElementException;
// http://blogs.msdn.com/b/ericlippert/archive/2007/12/10/immutability-in-c-part-four-an-immutable-queue.aspx
// (And let's make the empty queue a singleton, like we did with the empty stack.)

// keep two stacks around, one in ¡°forwards¡± order, ready to be dequeued, 
// and one in ¡°backwards¡± order, ready to be enqueued. 
// If we go to dequeue and find that the forward stack is empty, only then will we reverse the backwards stack.

/*
 * Efficient ?
 * every element (except the first one) is pushed on the backwards stack once, 
 * popped off the backwards stack once, pushed on the forwards stack once and 
 * popped off the forwards stack once. 
 * 
 * If you enqueue a thousand items and then dequeue two, yes, the second dequeue will be expensive as the backwards list is reversed, but the 998 dequeues following it will be cheap. 
 * That¡¯s unlike our earlier implementation, where every dequeue was potentially expensive. 
 * Dequeuing is on average O(1), though it is O(n) for a single case.
 * 
 * Amortized O(1)
 */


public class ImmutableQueue {
	private ImmutableStack in; // backwards
	private ImmutableStack out; // forwards
	
	// constructor
	public ImmutableQueue(){
		in = new ImmutableStack();
		out = new ImmutableStack();
	}
	public ImmutableQueue(ImmutableStack i, ImmutableStack o){
		in = i;
		out = o;
	}
	
	public ImmutableQueue enqueue(int value){
		return new ImmutableQueue (in.push(value), out);
	}
    
	public ImmutableQueue dequeue(){
		if( isEmpty() ) throw new NoSuchElementException();
		ImmutableStack newOut = out;
		ImmutableStack newIn = in;
		if(out.empty()){
			newOut = reverseStack(in);
			newIn = new ImmutableStack();
		}
		out.pop();
		return new ImmutableQueue (newIn, newOut);
	}
	
	public int peek(){
		if( isEmpty() ) throw new NoSuchElementException();
		if(out.empty()){
			out = reverseStack(in);
			in = new ImmutableStack();
		}
        return out.peek();
	}
	
	public boolean isEmpty(){
		return in.empty() && out.empty();
	}
	// O(n)
    static public ImmutableStack reverseStack(ImmutableStack stack){
    	ImmutableStack r = new ImmutableStack();
        for (ImmutableStack f = stack; !(f.empty()); f = f.pop())
        	r = r.push(f.peek());        
        return r;
    }
}
