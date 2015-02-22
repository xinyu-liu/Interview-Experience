package Palindrome;

import java.util.ArrayList;

public class PalindromeNumber {
	public boolean isPalin(int num){
		/*
		String s = String.valueOf(num);   ///// ok?
		for(int i = 0; i < s.length() / 2; i++){
			if(s.charAt(i) != s.charAt(s.length() - 1 -i)){
				return false;
			}
		}
		return true;
		*/
		// similar if store in arr
		if(num < 0) return false;
		ArrayList<Integer> arr = new ArrayList<Integer>();
		while(num != 0){
			arr.add(num % 10);
			num = num / 10;
		}
		for(int i = 0; i < arr.size() / 2; i++){
			if(arr.get(i) != arr.get(arr.size() - 1 - i)){
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		PalindromeNumber sol = new PalindromeNumber();
		System.out.println( sol.isPalin(1) );
	}

}
