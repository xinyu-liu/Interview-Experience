package MajorityElement;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* 
1. Runtime: O(n2) - Brute force solution: Check each element if it is the majority element.
2. Runtime: O(n), Space: O(n) - Hash table: Maintain a hash table of the counts of each element, then find the most common one.
3. Runtime: O(n log n) - Sorting: As we know more than half of the array are elements of the same value, we can sort the array and all majority elements will be grouped into one contiguous chunk. Therefore, the middle (n/2th) element must also be the majority element.
4. Average runtime: O(n), Worst case runtime: Infinity - Randomization: Randomly pick an element and check if it is the majority element. If it is not, do the random pick again until you find the majority element. As the probability to pick the majority element is greater than 1/2, the expected number of attempts is < 2.
5. Runtime: O(n log n) - Divide and conquer: Divide the array into two halves, then find the majority element A in the first half and the majority element B in the second half. The global majority element must either be A or B. If A == B, then it automatically becomes the global majority element. If not, then both A and B are the candidates for the majority element, and it is suffice to check the count of occurrences for at most two candidates. The runtime complexity, T(n) = T(n/2) + 2n = O(n log n).
6. Runtime: O(n) - Moore voting algorithm: We maintain a current candidate and a counter initialized to 0. As we iterate the array, we look at the current element x:
	If the counter is 0, we set the current candidate to x and the counter to 1.
	If the counter is not 0, we increment or decrement the counter based on whether x is the current candidate.
	After one pass, the current candidate is the majority element. Runtime complexity = O(n).
	http://xycoding.blogspot.com/2014/12/majority-vote-algorithm-linear-time.html?zx=396ddb4dcba9f206
fail 7
7. Runtime: O(n) - Bit manipulation: We would need 32 iterations, each calculating the number of 1's for the ith bit of all n numbers. Since a majority must exist, therefore, either count of 1's > count of 0's or vice versa (but can never be equal). The majority number¡¯s ith bit must be the one bit that has the greater count.
 */
public class Solution {
	/*
Input:	[-2147483648]
Output:	0
Expected:	-2147483648

	 */
	public int majorityElement7(int[] num) {
		int ans = 0;
		int mask = 1;
		for(int i = 0; i < 32; i++){
			int count1 = 0;
			for(int n:num){
				if((n & mask) > 0){
					count1++;
				}
			}
			if (count1 > num.length/2){
				ans += mask;
			}
			mask = mask<<1;
		}
		return ans;
	}
	public int majorityElement6(int[] num) {
		int maj = -1;
		int count = 0;
		for(int n:num){
			if(count > 0){
				if(maj == n){
					count++;
				}
				else{
					count--;
				}
			}
			else{
				maj = n;
				count = 1;				
			}
		}
		// if not must has maj, need to retraverse array to count maj
		return maj;
	}
	public int majorityElement3(int[] num) {
		Arrays.sort(num);
		// if not must has maj, need to retraverse array to count maj
		return num[num.length/2];
	}
    public int majorityElement2(int[] num) {
        int half = num.length;
        half /= 2;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int n:num){
            Integer i = map.get(n);
            if(i==null){
                i = 0;
            }
            map.put(n,i+1);
            if(i+1 > half) return n;
        }
        return -1;
    }
}
