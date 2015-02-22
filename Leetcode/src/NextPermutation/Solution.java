package NextPermutation;

public class Solution {
	// my idea the same as 
	// http://blog.csdn.net/fightforyourdream/article/details/16859757
	/*
34722641
A. Split the sequence of digits in two, so that the right part is as long as possible while remaining in decreasing order:
34722 641
B. Take the last digit of the first sequence, and swap it with the smallest digit in the second that is bigger than it:
3472(2) 6(4)1
->
34724 621
C. Sort the second sequence into increasing order:
34724 126
D. Done!
34724126

	 */
	
	/* GEEKSFORGEEKS
I) Traverse the given number from rightmost digit, keep traversing till you find a digit which is smaller than the previously traversed digit. 
For example, if the input number is ¡°534976¡±, we stop at 4 because 4 is smaller than next digit 9. If we do not find such a digit, then output is ¡°Not Possible¡±.

II) Now search the right side of above found digit ¡®d¡¯ for the smallest digit greater than ¡®d¡¯. 
For ¡°534976¡å, the right side of 4 contains ¡°976¡±. The smallest digit greater than 4 is 6.

III) Swap the above found two digits, we get 536974 in above example.

IV) Now sort all digits from position next to ¡®d¡¯ to the end of number. The number that we get after sorting is the output. 
For above example, we sort digits in bold 536974. We get ¡°536479¡± which is the next greater number for input 534976.

*****
The above implementation can be optimized in following ways.
1) We can use binary search in step II instead of linear search.
2) In step IV, instead of doing simple sort, we can apply some clever technique to do it in linear time. 
Hint: We know that all digits are linearly sorted in reverse order except one digit which was swapped.
	 */
    public void nextPermutation(int[] num) {
    	int i = num.length - 2;
        while(i >= 0 && num[i] >= num[i+1]){ // >= because [5,1,1]

        	i--;
        }
        if(i < 0){
            // others 
            i = 0;
            int j = num.length - 1;       	
            while(i < j){
            	swap(num, i++,j--);
            }
        }
        else{
        	int j;
        	for(j = num.length - 1; j > i; j--){
        		if(num[j] > num[i]) break;
        	}
        	swap(num,i,j);
            // others 
            i = i+1;
            j = num.length - 1;       	
            while(i < j){
            	swap(num, i++,j--);
            }
        }
    }
    private void swap(int[] num, int i, int j){
    	int temp = num[i];
    	num[i] = num[j];
    	num[j] = temp;
    }
}
