package NextGreaterElement;

import java.util.Stack;

/*
 * Given an array, print the Next Greater Element (NGE) for every element. The Next greater Element for an element x is 
the first greater element on the right side of x in array. 
Elements for which no greater element exist, consider next greater element as -1.

Examples:
a) For any array, rightmost element always has next greater element as -1.

b) For an array which is sorted in decreasing order, all elements have next greater element as -1.

c) For the input array [4, 5, 2, 25}, the next greater elements for each element are as follows.
Element       NGE
   4      -->   5
   5      -->   25
   2      -->   25
   25     -->   -1
d) For the input array [13, 7, 6, 12}, the next greater elements for each element are as follows.
  Element        NGE
   13      -->    -1
   7       -->     12
   6       -->     12
   12     -->     -1
 */
public class NextGreaterElement {
	public void printNextGreaterElem(int[] arr){
		if(arr == null || arr.length == 0) return;
		
		Stack<Integer> stack = new Stack<Integer>();
		for(int d : arr){
			while(!stack.empty() && stack.peek() < d){
				System.out.println(stack.pop() + " --> " + d);
			}
			stack.push(d);
		}
		while(!stack.empty() ){
			System.out.println(stack.pop() + " --> -1");
		}
	}
	public static void main(String[] arg){
		NextGreaterElement sol = new NextGreaterElement();
		//int[] arr = {4, 5, 2, 25};
		int[] arr = {13, 7, 6, 12};
		sol.printNextGreaterElem(arr);
	
	}
}
