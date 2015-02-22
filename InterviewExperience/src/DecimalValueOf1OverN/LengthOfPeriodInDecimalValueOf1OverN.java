package DecimalValueOf1OverN;

import java.util.HashMap;
import java.util.Map;

/*
 * NOTE: 
 * 1. BIG FAULT: I used to use map<shang, pos> to denote, but this is wrong
 * 					3.1415926... two 1s in shang appears but they are not indicating loop!!!!!
 * 					Instead, SHOULD use <REMAINDER, pos> to denote!!!!! 
 * 
 * 
 * 2. Can avoid using hashmap or array (For a number n, there can be at most n distinct remainders. )
 * 
 * For a number n, there can be at most n distinct remainders. 
 * Also, the period may not begin from the first remainder as some initial remainders may be non-repetitive (not part of any period). 
 * So to make sure that a remainder from a period is picked, 
 * =>
 * start from the (n+1)th remainder and keep looking for its next occurrence. 
 * The distance between (n+1)¡¯th remainder and its next occurrence is the length of the period.
 * see part 2 in http://www.geeksforgeeks.org/find-length-period-decimal-value-1n/
 * => 
 * after finding n+1'th remainder, store that remainder
 * and continue to find (with count) until k'th remainder == stored remainder, return count
 * => save space, same big o in time

 * 
 */
public class LengthOfPeriodInDecimalValueOf1OverN {
	public int solveNoSpace(int n){
		int rem = 1;
		for(int i = 0; i < n; i++){
			rem = (rem * 10) % n;
		}
		int target = rem;
		int count = 0;
		do{
			count++;
			rem = (rem * 10) % n;
		}while(target != rem);
		return count;
		
	}
	public int solveUsingMap(int n){
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int d = 1;
		int pos = 1;
		while(d != 0){
			Integer prev = map.get(d); // d means remainder * 10
			if(prev != null){
				return pos - prev;
			}
			else{
				map.put(d, pos++);
			}
			d = (d % n) * 10;
		}
		return 0;
		
	}

	public static void main(String[] args) {
		LengthOfPeriodInDecimalValueOf1OverN sol = new LengthOfPeriodInDecimalValueOf1OverN();
		System.out.println( sol.solveNoSpace(3) );
		System.out.println( sol.solveNoSpace(7) );
		System.out.println( sol.solveNoSpace(210) );
	}

}
