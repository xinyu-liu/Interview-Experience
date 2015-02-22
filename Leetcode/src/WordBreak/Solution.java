package WordBreak;

import java.util.Set;

public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for(int i = 0; i < s.length(); i++){
            for(int j = 0; j <= i; j++){
                String sub = s.substring(j,i+1);
                if( dict.contains(sub) && dp[j] ) {
                    dp[i+1] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}