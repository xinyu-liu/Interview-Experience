package InterleavingString;

public class Solution {
    // Solution1: DP
	/*
	 * s1, s2ֻ�������ַ�������˿���չƽΪһ����ά��ͼ���ж��Ƿ��ܴ����Ͻ��ߵ����½ǡ�
	 * 
	 * dp[i][j]��ʾ��s1��ǰi���ַ���s2��ǰj���ַ��ܲ��ܰ��չ����ʾ��s3��ǰi+j���ַ�
	 * 
	 * http://leetcodenotes.wordpress.com/2013/07/19/interleaving-string/
	 * 
	 */
    public boolean isInterleaveDP(String s1, String s2, String s3) {
    	if(s1.length()+s2.length() != s3.length()){
    		return false;
    	}
    	boolean[][] table = new boolean[s1.length()+1][s2.length()+1];
    	// init
    	table[0][0] = true;
    	for(int j = 1; j < s2.length()+1; j++){
    		table[0][j] = table[0][j-1] && s2.charAt(j-1) == s3.charAt(j-1);
    	}
    	for(int i = 1; i < s1.length()+1; i++){
    		table[i][0] = table[i-1][0] && s1.charAt(i-1) == s3.charAt(i-1);
    	}
    	// general
    	for(int i = 1; i < s1.length()+1; i++){
    		for(int j = 1; j < s2.length()+1; j++){
    			table[i][j] = (table[i][j-1] && s2.charAt(j-1) == s3.charAt(i+j-1)) 
    					   || (table[i-1][j] && s1.charAt(i-1) == s3.charAt(i+j-1)) ;
    		}
    	}
    	return table[s1.length()][s2.length()];
    }
    // Solution2 : recursion - Time Limit Exceed
    public boolean isInterleave(String s1, String s2, String s3) {
    	if(s1.length()+s2.length() != s3.length()){
    		return false;
    	}
    	return  rec(s1, s2, s3, 0, 0, 0);
    }
    private boolean rec(String s1, String s2, String s3, int p1, int p2, int p3) {
    	if(p1 >= s1.length()){
    		return s2.substring(p2) == s3.substring(p3);
    	}
    	if(p2 >= s2.length()){
    		return s1.substring(p1) == s3.substring(p3);
    	}
    	if(s1.charAt(p1) == s3.charAt(p3) && s2.charAt(p2) == s3.charAt(p3)){
    		return rec(s1,s2,s3,p1+1,p2,p3+1) || rec(s1,s2,s3,p1,p2+1,p3+1);
    	}
    	if(s1.charAt(p1) == s3.charAt(p3)){
    		return rec(s1,s2,s3,p1+1,p2,p3+1);
    	}
    	if(s2.charAt(p2) == s3.charAt(p3)){
    		return rec(s1,s2,s3,p1,p2+1,p3+1);
    	}
    	return false;
    }
}
