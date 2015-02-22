package ImmutableStackAndQueue;
import java.util.Arrays;
import java.util.NoSuchElementException;

public class ImmutableQueueBruteForce {
/*  
 */
	// brute force 
	private int[] arr;
	 
	 public ImmutableQueueBruteForce() {
		 
	 }
	 
	 private ImmutableQueueBruteForce(int queueSize) {
		 arr = new int[queueSize];
	 }
	 
	 public ImmutableQueueBruteForce enqueue(int e) {
		 ImmutableQueueBruteForce queue = new ImmutableQueueBruteForce(size() + 1);
		 if (size() > 0) {
			 for (int i = 0; i < size(); i++) {
				 queue.arr[i] = arr[i];
			 }
		 }
		 queue.arr[size()] = e;
		 return queue;
	 }
	 
	 public ImmutableQueueBruteForce dequeue() {
		 if(isEmpty()) throw new NoSuchElementException();
		 ImmutableQueueBruteForce queue = new ImmutableQueueBruteForce(size() - 1);
		 for (int i = 1; i < size(); i++) {
			 queue.arr[i - 1] = arr[i];
		 }
	  return queue;
	 }
	 
	 public int peek() {
		 if(isEmpty()) throw new NoSuchElementException();
		 return arr[0];
	 }
	 
	 public int size() {
		 return (arr == null ? arr.length : 0);
	 }
	 
	 public boolean isEmpty() {
		 return size() == 0;  
	 }
	 
	 public String toString() {
		 return Arrays.toString(arr);
	 }
}

