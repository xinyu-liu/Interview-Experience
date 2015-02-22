package DecodeWays;

public class Solution {
	// dp
	// NOTE:为了程序简洁，建一个n+1的数组，我们在最前面放一个1..I did not..
    public int numDecodings(String s) {
        if(s == null || s.length() == 0){
        	return 0;
        }
        
        int[] digits = new int[s.length()];
        for (int i = 0; i < s.length(); i++){
        	digits[i] = (int)(s.charAt(i)-'0');
        }
        
        int[] dp = new int[s.length()];

        for (int i = 0; i < s.length(); i++){
        	dp[i] = 0;
        	int cur = digits[i];
            if( cur > 0 && cur < 10){
            	dp[i] += i==0 ? 1:dp[i-1];
            }
            if(i > 0){
                cur += digits[i-1] * 10;
                if( cur > 9 && cur < 27){
                	dp[i] += i==1 ? 1:dp[i-2];
                }
            }
        }
        return dp[s.length()-1];
    }
	// recursion -  Time Limit Exceeded
    public int numDecodingsNO(String s) {
        if(s == null || s.length() == 0){
        	return 0;
        }
        int ans = 0;
        int cur;
        cur = (int)(s.charAt(0)-'0');
        if( cur > 0 && cur < 10){
        	ans += numDecodings(s.substring(1));
        }
        if(s.length() > 1){
	        cur = cur * 10 + (int)(s.charAt(1)-'0');
	        if( cur > 9 && cur < 27){
	        	ans += numDecodings(s.substring(2));
	        }
        }
        return ans;
    }
}
