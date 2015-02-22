package UniquePath;

public class Solution {
	// II can�ù������� �ڹ�������������Ҫ����֮ǰ�������ֵ����������Ҫ����ÿһ�������еĸ��ӣ����ǲ��������ϰ���ĸ����ˣ�����Ҫ�ֶ������Ǹ�ֵΪ0.
	 public int uniquePathsWithObstacles(int[][] obstacleGrid) {  
		 int m = obstacleGrid.length;
	     int n = obstacleGrid[0].length;
	     if (m==0||n==0) return 0;
	     if (obstacleGrid[0][0] == 1) return 0;////// good thinking!!!
	     
	     int[] dp = new int[n];
	     dp[0] = 1;
	     for(int i=1;i<m;i++){
	         for(int j=0;j<n;j++){
	        	 if(obstacleGrid[i][j] == 1){
	        		 dp[j] = 0;
	        	 }
	        	 else{
	        		 if(i == 0 && j == 0){
	        			 dp[j] = 1;
	        		 }
	        		 else  // dp[j] = (i>0 ? dp[j] : 0) + (j>0 ? dp[j-1] : 0);  
	        		 if(j != 0){	        		 
		        		 if(i == 0){
		        			 dp[j] = dp[j-1];
		        		 }
		        		 else{
		        			 dp[j] += dp[j-1];
		        		 }
	        		 }
	        	 }
	         }
	     }
	     return dp[n-1];
	 }
	// web
	    public int uniquePathsWithObstaclesWEB(int[][] obstacleGrid) {
	        int m = obstacleGrid.length;
	        int n = obstacleGrid[0].length;
	        if (m==0||n==0) return 0;
	        if (obstacleGrid[0][0] == 1) return 0;////// good thinking!!!
	        int[][] dp = new int[m][n];
	        for(int i=0;i<m;i++){
	            for(int j=0;j<n;j++){
	                if (obstacleGrid[i][j]==0){ // ֵΪ0�ĸ�; ����ĸ��� �ᱻdp�����ʼ��Ϊ0
	                    if (i==0 && j==0) dp[i][j] = 1;
	                    else dp[i][j] = (i>0 ? dp[i-1][j] : 0) + (j>0 ? dp[i][j-1] : 0);
	                    /*  �ȼ���
	                     *  i = 0 dp[i][j] = dp[i][j-1];
	                    	j = 0 dp[i][j] = dp[i-1][j];
	                    	i >0 j>0 dp[i][j] = dp[i][j-1] + dp[i-1][j]
	                    */
	                }
	            }
	        }
	        return dp[m-1][n-1];
	    }

	//mine
    public int uniquePathsWithObstaclesMINE(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if(m==0 ||n==0){
    		return 0;
    	}
        int[][] dp = new int [m][n];
        dp[0][0] = obstacleGrid[0][0] == 0 ? 1:0;
        for (int i = 1; i < m; i++){
        	if(obstacleGrid[i][0] == 1 || dp[i-1][0] ==0){
    			dp[i][0] = 0;
    		}
    		else{
    			dp[i][0] = 1;
    		}
        }        
        for (int j = 1; j < n;j++){
        	if(obstacleGrid[0][j] == 1 || dp[0][j-1] ==0){
    			dp[0][j] = 0;
    		}
    		else{
    			dp[0][j] = 1;
    		}
        }
        for (int i = 1; i < m; i++){
        	for (int j = 1; j < n;j++){
        		if(obstacleGrid[i][j] == 1){
        			dp[i][j] = 0;
        		}
        		else{
        			dp[i][j] = dp[i-1][j] + dp[i][j-1];
        		}
        	}
        }
        return dp[m-1][n-1];
       
    }
	// I
    // NOTE:��ʡ�ռ�ķ���:�۲����������Է���ѭ���Ǵ��ϵ���ɨ���еģ�
    // ��ÿһ����������Ǵ�������ɨ��ģ�������һ��������������ʾÿһ�У�
    // ����һ�е�ʱ��ֻ��Ҫ��������������ֵ������ˡ�
    public int uniquePaths(int m, int n) {
    	if(m==0 ||n==0){
    		return 0;
    	}
        int[][] dp = new int [m][n];
        for (int i = 0; i < m; i++){
        	dp[i][0] = 1;
        }        
        for (int j = 0; j < n;j++){
        	dp[0][j] = 1;
        }
        for (int i = 1; i < m; i++){
        	for (int j = 1; j < n;j++){
        		dp[i][j] = dp[i-1][j] + dp[i][j-1];
        	}
        }
        return dp[m-1][n-1];
    }
}
