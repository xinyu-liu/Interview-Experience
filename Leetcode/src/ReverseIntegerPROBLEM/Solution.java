package ReverseIntegerPROBLEM;

public class Solution {
    public int reverse(int x) {
        int ans = 0;
        while(x != 0){
        	if(Integer.MAX_VALUE - 10*ans - x%10 <= 0){
        		return Integer.MAX_VALUE ;
        	}
        	if(Integer.MIN_VALUE - 10*ans - x%10 >= 0){
        		return Integer.MIN_VALUE ;
        	}
        	ans = 10 * ans + x % 10;
        	x /= 10;
        }
        return ans;
    }
}
