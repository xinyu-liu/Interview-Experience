package WordLadder;

import java.util.HashSet;
import java.util.Set;

public class Tester {
	public static void main(String[] args) {
		Solution sol = new Solution();
		Set<String> dict = new HashSet<String>();
		dict.add("ted");
		dict.add("tex");
		dict.add("red");
		dict.add("tax");
		dict.add("tad");
		dict.add("den");
		dict.add("rex");
		dict.add("pee");

		
		System.out.print( sol.ladderLengthNEW("red", "tax", dict) );
	}
}
