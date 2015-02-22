package MaxOfAllSubarraysSizeK;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/* 
 * http://www.geeksforgeeks.org/maximum-of-all-subarrays-of-size-k/
 * 
Q: Maximum of all subarrays of size k (Expected Time Complexity O(N).
Input :
arr[] = {1, 2, 3, 1, 4, 5, 2, 3, 6}
k = 3
Output :
3 3 4 5 5 5 6

 */

public class MaxOfAllSubarraysSizeK {
	/*
	 *  Dequeue (Double ended queue)
	 *  http://dlc-cdn.sun.com/jdk/jdk-api-localizations/jdk-api-zh-cn/publish/1.6.0/html/zh_CN/api/java/util/Deque.html
	 *  (顶级接口)Collection接口-->Queue接口-->Deque接口-->LinkedList(实现类)
	 *  
	 *  Time: O(n)  Space: O(k)
	 *  Every element of array is added and removed at most once. So there are total 2n operations.
	 *  
	 */
	
	public ArrayList<Integer> solve(int[] arr, int k){
		int n = arr.length;
		ArrayList<Integer> ans = new ArrayList<Integer>();
		if(n < k) return ans;
		
		Deque<Integer> queue = new LinkedList<Integer>();
		
		// Process first k (or first window) elements of array
		for (int i = 0; i < k; i++){
			while(!queue.isEmpty() && arr[i] > queue.peekLast()){ 
				queue.removeLast();
			}
			queue.add(arr[i]);		
		}
		ans.add(queue.peek());

		// Process rest of the elements, i.e., from arr[k] to arr[n-1]
		int l = 0;
		int r = l+k-1;	
		while( (++r) < n ){
			if(arr[l++] == queue.peekFirst()) queue.removeFirst();
			
			while(!queue.isEmpty() && arr[r] > queue.peekLast()){ 
				queue.removeLast();
			}
			queue.add(arr[r]);
			
			ans.add(queue.peek());		
		}
		return ans;
	}

	
	public static void main(String[] args){
		int[] arr = {8, 5, 10, 7, 9, 4, 15, 12, 90, 13};
		MaxOfAllSubarraysSizeK sol = new MaxOfAllSubarraysSizeK();
		ArrayList<Integer> ans = sol.solve( arr, 4);
		System.out.print(ans);
	}
 
}

