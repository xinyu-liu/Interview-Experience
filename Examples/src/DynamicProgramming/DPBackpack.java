package DynamicProgramming;

import java.util.Arrays;

public class DPBackpack {
	public static int backpackMemoryRecursion(int[] w, int[] v, int i, int j,int[][] result){
		if(i==0 || j==0){
			return result[i][j];
		}
		if (result[i][j] < 0){
			if(j<w[i-1]){
				result[i][j] = backpackMemoryRecursion(w,  v, i-1, j,result);
			}
			else{
				result[i][j] = Math.max  ( backpackMemoryRecursion(w,  v, i-1, j,result),
						backpackMemoryRecursion(w,  v, i-1, j-w[i-1],result) + v[i-1]);
			}
		}
		return result[i][j];
	}
	public static void backpackIteration(int[] w, int[] v, int W, int[][] result){
		int n = w.length;
		// 初始条件：result[0][j] = 0;result[i][0] = 0;
        for (int i = 0; i <= W; i++)
            result[0][i] = 0;
        for (int i = 0; i <= n; i++)
            result[i][0] = 0;
        // 根据动态规划的状态转移方程填表:这个表格可以一行一行的填，也可以一列一列的填，这里采用一行一行的填
        // 注意填表方式是动态规划里面非常重要的一个东西，当你填某一个位置时，它需要用到的其他位置必须都已经填好
        // 所以填表的方式是跟状态转移方程相关滴，深层次来说，是跟动态规划构造解的生成过程相关的
        for (int i = 1; i <= n; i++) {// 行数从1到n
            for (int j = 1; j <= W; j++) {// 列数从1到W
            	 // 此时决定了一个i，j的位置要填：result[i][j]
                if (j - w[i - 1] < 0)
                    result[i][j] = result[i - 1][j];
                else
                    result[i][j] = Math.max(result[i - 1][j], v[i - 1] + result[i - 1][j - w[i - 1]]);
            }
        }

        
	}
	public static void outputWhich(int[][] result,int[] x,int[] w) { //找出对应的背包分别是哪几个
		int W = result[0].length-1;
		for (int i = result.length -1; i>0; i--){
			if(result[i][W] == result[i-1][W]){
				x[i-1]=0;
			}
			else{
				x[i-1]=1;
				W-=w[i-1];
			}
		}
	}

	
	public static void main(String[] args) {
		 int[] w = { 2, 1, 3, 2 }; // 重量数组
	     int[] v = { 12, 10, 20, 15 }; // 价值数组
	     int W = 5;
	     int [][] result = new int[w.length+1][W+1]; // 前i个物品（i从0到n），W从0到W
	    
	     backpackIteration(w, v, W,result);
/*		
	     // initiate
	     for (int i = 0; i < result.length; i++){
	    	 for (int j = 0; j < result[0].length; j++){
	    		 if(i==0 || j==0){
	    			  result[i][j] = 0;
	    		 }
	    		 else{
	    			 result[i][j] = -1;
	    		 }
	    	 }
	     }
	     backpackMemoryRecursion(w, v, w.length ,W,result);
*/	     int[] x = new int[w.length];
	     outputWhich(result, x, w);

	     for (int i = 0; i < result.length; i++){
	         for (int j = 0; j < result[0].length; j++)
	            System.out.print(result[i][j] + "     ");
	         System.out.println();
	     }
	     
	     for(int i = 0;i<x.length;i++){
	    	 System.out.print(x[i] + "     "); 
	     }
	}

}
