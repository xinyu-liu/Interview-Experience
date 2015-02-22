package PalindromeNumber;

public class Solution {
    public boolean isPalindrome(int x) {
    	if(x < 0){
    		return false;
    	}
    	int length = 1;
        while(x / length > 9){
        	length *= 10;
        }
        while(x!=0){
        	int l = x/length;
        	int r = x%10;
        	if(l != r){
        		return false;
        	}
        	x = (x % length) / 10;
        	length /= 100;
        }
        return true;
    }
}

