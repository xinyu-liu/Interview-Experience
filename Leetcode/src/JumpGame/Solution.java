package JumpGame;

import java.util.Arrays;

public class Solution {
	// II 
	public int jump(int[] A) {
	    if(A.length < 2) return 0;
	    int count = 0;
	    int localMax = 0;
	    int i = 0;
	    while(i < A.length){
	        int temp = 0;
	        while(i < A.length && i <= localMax){
	            temp = Math.max(temp,i+A[i]);
	            i++;
	        }
	        localMax = temp;
	        count++;
	        if(localMax >= (A.length - 1)) return count;
	    }
	    return Integer.MAX_VALUE;
	}
	// ��һ��������DP����ʱ�����⣡��ȻDP����ʱ����ôֻ����һ����greedy�ˡ�
	// ̰�ĵ�˼�����þ������ٵò������꣬һ����Ҫ˼���ǲ��ϸ���targetλ�ã�ʹ��target������ǰ�ƶ�
	
	// MINE greedy -TLE O(n^2)
	public int jumpw(int[] A) {
		int[] jump = new int[A.length];  
		Arrays.fill(jump, Integer.MAX_VALUE);
		jump[0] = 0;
		for(int i = 1; i < jump.length; i++){
			for(int j = i+1; j< jump.length && j <= i + A[i]; j++){
				A[j] = Math.min(A[j], A[i]+1);
				if(j == A.length-1){
					return A[j];
				}
			}
		}
		return A[A.length-1];
	}
	
	// WEB dp - TLE O(n^2) - 1D
	public int jumpDP_W(int[] A) {
		int[] jump = new int[A.length];  
		jump[0] = 0;
		for(int i = 1; i < A.length; i++){
			jump[i] = Integer.MAX_VALUE;
			for(int j = 0; j < i; j++){
				jump[i] = Math.min(jump[i], jump[j]+1);
			}
		}
		return jump[A.length-1];
	}
	// Mine dp - TLE O(n^2) - 2D 
    public int jumpDP_M(int[] A) {
        int[][] dp = new int[A.length][A.length];
        for(int[] temp: dp){
        	Arrays.fill(temp,Integer.MAX_VALUE);
        }
        dp[0][0] = 0;
        for(int i = 0; i < A.length; i++){
        	int reach = A[i]; 
        	for(int j = i; j <= i+reach && j < A.length; j++){
        		dp[i][j] = 1;
        	}
        }
        for(int i = 1; i < A.length; i++){
        	for(int j = 1; j < i; j++){
        		int temp = dp[0][j] + dp[j][i];
        		dp[0][i] = Math.min(temp, dp[0][i]);
        	}
        }
        return dp[0][A.length-1];
    }
	// I
	// WEB
	// ��̰�Ĳ��ԣ��տ�ʼstep = A[0]������һ��step--, 
	// ����ȡstep = max(step, A[1])������stepһֱ�Ǳ����������ƶ�������
	// �ֲ�����Ҳ��ȫ�����š�
	public boolean canJump(int[] A) { 
		int n = A.length;
	 
	    int maxstep=A[0];  
	    for(int i = 1; i < n; i++){  
	    	if(maxstep == 0) return false;  
	        maxstep--;  
	        if(maxstep < A[i]){  
	            maxstep = A[i];  
	        }  
	        if(maxstep+i >= n-1){  
	        	return true;  
	        }  
	    }  
	    return true;
	}  
	// MINE
	// A[0]������A[0+jump1]������A[0+jump1+jump2]��Ȼ����㷵�ؽ��
	// �ĳɣ�0+jump1+jump2+��Ȼ����n-1���бȽ�
	// ������ѵ�ǰ���cover��Χmax��Ϊforѭ������ֹ�����������ϸ���max
    public boolean canJumpIMine(int[] A) {
       int i = 0;
       int max = Integer.MIN_VALUE;
       while(i < A.length-1){
    	   
    	   if(A[i] == 0){
    		   return false;
    	   }
    	   for( int j = i; j < A.length && j <= (i+A[i]); j++){
	    	   max = Math.max(max, A[j]+j );
	       }
	       i = max;
       }
       return true;
    }
}
