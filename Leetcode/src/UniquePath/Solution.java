package UniquePath;

public class Solution {
	// II can用滚动数组 在滚动数组里我们要复用之前数组里的值，所以我们要处理每一个矩阵中的格子，我们不能跳过障碍物的格子了，所以要手动给它们赋值为0.
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
	                if (obstacleGrid[i][j]==0){ // 值为0的格; 其余的格子 会被dp矩阵初始化为0
	                    if (i==0 && j==0) dp[i][j] = 1;
	                    else dp[i][j] = (i>0 ? dp[i-1][j] : 0) + (j>0 ? dp[i][j-1] : 0);
	                    /*  等价于
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
    // NOTE:节省空间的方法:观察上面程序可以发现循环是从上到下扫描行的，
    // 在每一行里，我们又是从左到右来扫描的，可以用一个滚动数组来表示每一行，
    // 算下一行的时候，只需要更新这个数组里的值便可以了。
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
