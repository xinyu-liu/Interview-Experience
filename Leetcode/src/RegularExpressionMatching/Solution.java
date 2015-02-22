package RegularExpressionMatching;

public class Solution {
	// dp
    public boolean isMatchDP(String s, String p) { // source, pattern
    	boolean[][] dp = new boolean[s.length()+1][p.length()+1];
    	// base
    	dp[0][0] = true;
    	// dp[0][1] = false;
    	for(int j = 2; j <= p.length(); j++){
    		if(p.charAt(j-1) == '*'){
    			dp[0][j] = dp[0][j-2];
    		}
    	}
    	// all dp[i][0] = false;
    	
    	// general
    	for(int i = 1; i <= s.length(); i++){
    		for(int j = 1; j <= p.length(); j++){
    			char pat = p.charAt(j-1);
    			if( pat != '*' && (pat == '.' || pat == s.charAt(i-1)) && dp[i-1][j-1] ) 
    				dp[i][j] = true;
    			else if(pat == '*'){
    			    if( p.charAt(j-2) == '.' || p.charAt(j-2) == s.charAt(i-1) ){
    			        if(dp[i-1][j] || dp[i-1][j-2] || dp[i][j-2]){
    			            dp[i][j] = true;
    			        }
    			    }
    			    else if(dp[i][j-2])
    			        dp[i][j] = true;
    			} 
    		}
    	}
    	// find match
    	return dp[s.length()][p.length()];
    }
	// recursion
    /*    http://blog.csdn.net/fightforyourdream/article/details/17717873
�ж���һ���ַ��Ƿ���*��
�������*�����жϵ�ǰ�ַ��Ƿ�ƥ�䡣
�����*������Ϊ����ȷ��*���׻�ƥ�伸�����ڵ�ǰ�ַ�ƥ���ǰ���£�Ҫö�����е�������Ӽ���ƥ��0����1����2��������ֻҪ��һ������ɹ��ˣ�����Ҳ�ͳɹ��ˡ�
�����*�����ǵ�ǰ�ַ���ƥ�䣬�����������ݹ顣
     */
    public boolean isMatch(String s, String p) {
        return dfs(s,0,p,0);
    }
    public boolean dfs(String s, int ss, String p, int ps) {
    	if(ss == s.length() && ps == p.length()){
    		return true;
    	}
    	if(ps == p.length()) return false;
    	if(ss == s.length()){
    		if(ps+1 < p.length() && p.charAt(ps+1) == '*'){
    			return dfs(s,ss,p,ps+2);
    		}
    		return false;
    	}
    	char c = p.charAt(ps);
    	// must (c != '*')
	    if(ps+1 == p.length() || p.charAt(ps+1) != '*'){
	   		if( c == '.' || c == s.charAt(ss) ){
	   			return dfs(s,ss+1,p,ps+1);
	   		}
	   		return false;
    	}
	    else{// ps+1 < length && p.ps+1 == *
	   		if( dfs(s,ss,p,ps+2) ){
	   			return true;
	   		}
	   		if( c == '.' || c == s.charAt(ss) ){
    			return dfs(s,ss+1,p,ps+2) || dfs(s,ss+1,p,ps);
	   		}
	   		return false;
	   	}
    }
}
