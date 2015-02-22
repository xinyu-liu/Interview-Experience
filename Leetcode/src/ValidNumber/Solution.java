package ValidNumber;

public class Solution {
	/*
	 * https://leetcodenotes.wordpress.com/2013/11/23/leetcode-valid-number/
	 */
	public boolean isNumber(String s) {
		s = s.toLowerCase().trim();
		if(s.length() == 0) return false;
		if(s.charAt(s.length()-1) == 'e') return false; // split(): Trailing empty strings are therefore not included in the resulting array.
		
		String[] arr = s.split("[e]");// "3e"=> arr: "3","", arr.length = 2
		if(arr.length == 0 || arr.length > 2) return false;
		
		boolean ans = isNumber(arr[0], true);
		if(arr.length == 2){
			ans = ans && isNumber(arr[1], false);
		}
		return ans;
	}
	private boolean isNumber(String s, boolean canHaveDot){
		if(s.length() == 0) return false;
		int l = 0;
		if(s.charAt(l) == '+' || s.charAt(l) == '-'){
			l++;
			if (s.length() == 1) return false;
		}
		
		for(int i = l; i < s.length(); i++){
			if(s.charAt(i) == '.'){
				if( !canHaveDot ) return false;
				if( (i-1 >= 0 && isDigit( s.charAt(i-1))) 
						|| (i+1 < s.length() && isDigit( s.charAt(i+1))) )					
					canHaveDot = false;
				else return false;
			}
			else if( !isDigit(s.charAt(i)) ) return false;
		}
		return true;		
	}
	private boolean isDigit(char c){
		int i = (int)(c - '0');
		return i >= 0 && i <= 9;
	}
}
