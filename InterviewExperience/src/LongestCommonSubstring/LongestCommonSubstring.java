package LongestCommonSubstring;
/*
d[i][j] : A[0��i]��B[0��j]�� �������׺ �ĳ���
d[i][j] =
	A[i] == B[j] : d[i][j] = d[i - 1][j - 1] + 1 //������׺ ���˵�ǰ���char
	A[i] != B[j] : d[i][j] = 0//�Ͽ��ˣ��޹�����׺��
 */
public class LongestCommonSubstring {
	public int lcsubstring(String s1, String s2){
		int m = s1.length();
		int n = s2.length();
		int[][] dp = new int[m][n];
		int ans = 0;
		for(int i = 0; i < m; i++){
			for(int j = 0; j < n; j++){
				if( s1.charAt(i) == s2.charAt(j) ){
					if(i == 0 || j == 0) dp[i][j] = 1;
					else dp[i][j] = dp[i-1][j-1] + 1;
					// update
					if(dp[i][j] > ans) ans = dp[i][j]; 		
				}
				// else = 0
			}
		}
		return ans;
	}
}
