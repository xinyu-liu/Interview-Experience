package ScrambleString;

import java.util.Arrays;

public class Solution {
	/*
�Ը���������ķ����ǴӼ򵥵�������˼�����Ӷ��ҳ����ɡ�
�ȿ���������
�ַ�������Ϊ1�������ԣ������ַ���������ȫ��ͬ�ſ��ԡ�
�ַ�������Ϊ2����s1="ab", s2ֻ��"ab"����"ba"�ſ��ԡ�
�������ⳤ�ȵ��ַ��������ǿ��԰��ַ���s1��Ϊa1,b1�������֣�s2��Ϊa2,b2�������֣����㣨(a1~a2) && (b1~b2)������ ��(a1~b2) && (a1~b2)��
	 */
	
// 3D dp �����ʽ	
	// ������ʽ����ҪO(len)����Ϊlen-1����������
	// ��ʱ�临�Ӷ���Ϊ����ά��̬�滮����Ҫ����ѭ��������ÿһ����Ҫ����ʱ��������ʽ��������O(n^4)��
	// ��Ȼ�Ѿ��Ƚϸ��ˣ��������ٲ���ָ�������ģ���̬�滮�����кܴ����µģ��ռ临�Ӷ���O(n^3)��
	
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
	 // ��ö���з�λ��i�󣬲�Ҫֱ�Ӿ͵ݹ���ã�
	 // �����ַ��������Ƶıر������Ǻ�����ͬ���ַ������򵥵������ǰ������ַ������ַ������Ȼ��Ƚ��Ƿ���ͬ��
	 // ����������Ϳ��Դ��ļ��ٵݹ������

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
	 
// Brute force:ʱ�临�Ӷ���O(3n)????? Time Limit Exceeded
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
