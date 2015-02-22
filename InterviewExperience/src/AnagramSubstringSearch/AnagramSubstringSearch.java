package AnagramSubstringSearch;
/*
 * Given a text txt[0..n-1] and a pattern pat[0..m-1], 
 * write a function search(char pat[], char txt[]) that 
 * prints all occurrences of pat[] and its permutations (or anagrams) in txt[]. 
 * You may assume that n > m. 
Expected time complexity is O(n)

Examples:

1) Input:  txt[] = "BACDGABCDA"  pat[] = "ABCD"
   Output:   Found at Index 0
             Found at Index 5
             Found at Index 6
2) Input: txt[] =  "AAABABAA" pat[] = "AABA"
   Output:   Found at Index 0
             Found at Index 1
             Found at Index 4
             
http://www.geeksforgeeks.org/anagram-substring-search-search-permutations/
 */
public class AnagramSubstringSearch {
	// O(n)
	public void searchMine(String pat, String txt){
		// pattern
		int plen = pat.length();
		int[] pattern = new int[256];
		for(int i = 0; i < plen; i++){
			pattern[pat.charAt(i)]++;
		}
		// hasFound
		int[] hasFound = new int[256];
		int l = 0;
		int r = 0;
		int flen = 0;
		while(r < plen){
			char c = txt.charAt(r);
			if(pattern[c] > 0){
				hasFound[c]++;
				if(hasFound[c] <= pattern[c]) flen++;
			}
			r++;
		}
		if(flen == plen) System.out.println(l);
		
		while(r < txt.length()){
			char cl = txt.charAt(l++);
			if(hasFound[cl] > 0){
				hasFound[cl]--;
				if(hasFound[cl] < pattern[cl]) flen--;////////////
			}
			char cr = txt.charAt(r);
			if(pattern[cr] > 0){
				hasFound[cr]++;
				if(hasFound[cr] <= pattern[cr]) flen++;
			}
			if(flen == plen) System.out.println(l);
			r++;
		}
	}
	// 256n
	public void searchWeb(String pat, String txt){
		int plen = pat.length();
		int[] hasFound = new int[256];
		int[] pattern = new int[256];
		for(int i = 0; i < plen; i++){
			pattern[pat.charAt(i)]++;
			hasFound[txt.charAt(i)]++;
		}
		int l = 0;
		int r = plen;

		if( check(pattern, hasFound) ) System.out.println(l);
		
		while(r < txt.length()){
			hasFound[txt.charAt(l)]--;
			l++;
			hasFound[txt.charAt(r)]++;
			r++;
			if(check(pattern, hasFound)) System.out.println(l);
			
		}
	}
	private boolean check(int[] pattern, int[] hasfound){
		for(int i = 0; i < 256; i++){
			if(pattern[i] != hasfound[i]){
				return false;
			}
		}
		return true;
		
	}
	public static void main(String[] args) {
		AnagramSubstringSearch sol = new AnagramSubstringSearch();
		//String pat = "AABA";
		//String txt = "AAABABAA";		
		String pat = "ABCD";
		String txt = "BACDGABCDA";
		sol.searchWeb(pat, txt);
		sol.searchMine(pat, txt);
	}

}
