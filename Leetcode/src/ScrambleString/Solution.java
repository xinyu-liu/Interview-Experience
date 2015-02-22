package ScrambleString;

import java.util.Arrays;

public class Solution {
	/*
对付复杂问题的方法是从简单的特例来思考，从而找出规律。
先考察简单情况：
字符串长度为1：很明显，两个字符串必须完全相同才可以。
字符串长度为2：当s1="ab", s2只有"ab"或者"ba"才可以。
对于任意长度的字符串，我们可以把字符串s1分为a1,b1两个部分，s2分为a2,b2两个部分，满足（(a1~a2) && (b1~b2)）或者 （(a1~b2) && (a1~b2)）
	 */
	
// 3D dp 求递推式	
	// 求解递推式是需要O(len)（因为len-1种劈法）。
	// 总时间复杂度因为是三维动态规划，需要三层循环，加上每一步需要线行时间求解递推式，所以是O(n^4)。
	// 虽然已经比较高了，但是至少不是指数量级的，动态规划还是有很大有事的，空间复杂度是O(n^3)。
	
	// http://blog.csdn.net/pickless/article/details/11501443
	// http://www.blogjava.net/sandy/archive/2013/05/22/399605.html

	// more concise
	public boolean isScramble(String s1, String s2) {
		 if( s1.length() != s2.length() )	return false;
		 int len = s1.length();
		 boolean[][][] dp = new boolean[len][len][len];
		 // k = 0, one char
		 for(int i = 0; i < len; i++){
			 for(int j = 0; j < len; j++){
				 dp[i][j][0] = ( s1.charAt(i) == s2.charAt(j) );
			 }
		 }
		 for(int k = 1; k < len; k++){	// k, k+1 char k=2
			 for(int i = 0; i < len-k; i++){
				 for(int j = 0; j < len-k; j++){	
					 boolean r = false;
					 for(int st = 1; st <= k && !r; st++){
						  r = (dp[i][j][st-1] && dp[i+st][j+st][k-st]) || 
							 (dp[i+k-st+1][j][st-1] && dp[i][j+st][k-st] ); 
				
					 } 
					 dp[i][j][k] = r;
				 }
			 }
		 }		
		 return dp[0][0][len - 1];
	 }
	// my first
	 public boolean isScrambleOK(String s1, String s2) {
		 if( s1.length() != s2.length() )	return false;
		 int len = s1.length();
		 boolean[][][] dp = new boolean[len][len][len];
		 // k = 0, one char
		 for(int i = 0; i < len; i++){
			 for(int j = 0; j < len; j++){
				 dp[i][j][0] = ( s1.charAt(i) == s2.charAt(j) );
			 }
		 }
/*		 // k = 1, two char
		 for(int i = 0; i < len-1; i++){
			 for(int j = 0; j < len-1; j++){				 
				 dp[i][j][1] =(dp[i][j][0] && dp[i+1][j+1][0]) || (dp[i+1][j][0] && dp[i][j+1][0]);
			 }
		 }
*/		 for(int k = 1; k < len; k++){	// k, k+1 char k=2
			 for(int kb = k - 1; kb >= k/2; kb--){
				 int ks = k - 1 - kb; // small set
				 
				 for(int i = 0; i < len-k; i++){
					 for(int j = 0; j < len-k; j++){				 
						 dp[i][j][k] =dp[i][j][k] ||   // <- MUST INCLUDE THIS ! 
								                       // LAST K,[0][0], BUT MANY KB, CANNOT FUGAI
								 	  (dp[i][j][ks] && dp[i+ks+1][j+ks+1][kb]) || 
								 	  (dp[i][j+kb+1][ks] && dp[i+ks+1][j][kb]) ||
								 	  (dp[i][j][kb] && dp[i+kb+1][j+kb+1][ks]) || 
								 	  (dp[i][j+ks+1][kb] && dp[i+kb+1][j][ks]); 
						 // 4 cases !!!
					 } 
				 }
			 }
		 }		
		 return dp[0][0][len - 1];
	 }
	 
// Brute force TRICK: not general!!!!
	 // 在枚举切分位置i后，不要直接就递归调用，
	 // 两个字符串的相似的必备条件是含有相同的字符集。简单的做法是把两个字符串的字符排序后，然后比较是否相同。
	 // 加上这个检查就可以大大的减少递归次数。

	 // Time Limit Exceeded
	 // Last executed input:	"tqxpxeknttgwoppemjkivrulaflayn", "afaylnlurvikjmeppowgttnkexpxqt"
	 public boolean isScrambleBFtrick(String s1, String s2) {
		 // added !!!!!! also length & compare length = 1, else cannot pass
		if(s1.length() != s2.length()){  
			return false;  
		}  
		if(s1.length()==1 && s2.length()==1){  
			return s1.charAt(0) == s2.charAt(0);  
		}  		     
		if( !sortAndCompare(s1,s2)) return false;
			 
		 // my old recusion
	        for(int i = 1; i < s1.length(); i++){
	        	boolean b1 = isScrambleBF( s1.substring(0,i), s2.substring(0,i) ) 
	        			  && isScrambleBF( s1.substring(i), 	s2.substring(i) );
	        	if( b1 ) return true;
	        	boolean b2 = isScrambleBF( s1.substring(0,i), s2.substring(s2.length() - i) ) 
	      			  	  && isScrambleBF( s1.substring(i), 	s2.substring(0, s2.length() - i) );        			
	        	if( b2 ) return true;
	        }
	        return false;
	 }
	 private boolean sortAndCompare(String s1, String s2){
		 char[] arr = s1.toCharArray();
		 Arrays.sort(arr);
		 String sorted1 = new String(arr);
		 arr = s2.toCharArray();
		 Arrays.sort(arr);
		 return sorted1.equals( new String(arr) );
	 }
	 
// Brute force:时间复杂度是O(3n)????? Time Limit Exceeded
    public boolean isScrambleBF(String s1, String s2) {
        for(int i = 1; i < s1.length(); i++){
        	boolean b1 = isScrambleBF( s1.substring(0,i), s2.substring(0,i) ) 
        			  && isScrambleBF( s1.substring(i), 	s2.substring(i) );
        	boolean b2 = isScrambleBF( s1.substring(0,i), s2.substring(s2.length() - i) ) 
      			  	  && isScrambleBF( s1.substring(i), 	s2.substring(0, s2.length() - i) );        			
        	if( b1 || b2 ) return true;
        }
        return false;
    }
}
