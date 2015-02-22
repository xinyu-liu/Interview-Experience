package FindAllDistinctPalindromicSubstrings;

import java.util.HashSet;
import java.util.Iterator;

/*
Given a string of lowercase ASCII characters, find all DISTINCT continuous palindromic sub-strings of it.

Examples:

Input: str = "abaaa"
Output:  Below are 5 palindrome sub-strings
a
aa
aaa
aba
b


Input: str = "geek"
Output:  Below are 4 palindrome sub-strings
e
ee
g
k

Step 1: Finding all palindromes: O(n^2)

Step 2: Inserting all the found palindromes in a HashMap:
Insert all the palindromes found from the previous step into a HashMap.  
Time complexity of this step is O(n^3) assuming that the hash insert search takes O(1) time，新版本的subString时间复杂度将有O(1)变为O(n). 


The algorithm could do better (nlogn) if use suffix-tree.
 */
public class FindAllDistinctPalindromicSubstrings {
	public void find(String s){
		int n = s.length();
		boolean[][] isPalin = new boolean[n][n];
		for(int i = 0; i < n; i++){
			isPalin[i][i] = true;
			if(i+1 < n && s.charAt(i) == s.charAt(i+1)) isPalin[i][i+1] = true;
		}
		for(int l = 3; l <= n; l++){
			for(int i = 0; i+l-1 < n; i++){
				if(isPalin[i+1][i+l-2] && s.charAt(i) == s.charAt(i+l-1)) isPalin[i][i+l-1] = true;
			}
		}
		HashSet<String> set = new HashSet<String>();
		
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				if(isPalin[i][j]) set.add(s.substring(i,j+1));
			}
		}
		Iterator<String> iter = set.iterator();
		while(iter.hasNext()){
			System.out.println(iter.next());
		}
	}
	public static void main(String[] args) {
		FindAllDistinctPalindromicSubstrings sol = new FindAllDistinctPalindromicSubstrings();
		sol.find("geek");
	}
}

