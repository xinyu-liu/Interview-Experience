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
		// ��ʼ������result[0][j] = 0;result[i][0] = 0;
        for (int i = 0; i <= W; i++)
            result[0][i] = 0;
        for (int i = 0; i <= n; i++)
            result[i][0] = 0;
        // ���ݶ�̬�滮��״̬ת�Ʒ������:���������һ��һ�е��Ҳ����һ��һ�е���������һ��һ�е���
        // ע�����ʽ�Ƕ�̬�滮����ǳ���Ҫ��һ��������������ĳһ��λ��ʱ������Ҫ�õ�������λ�ñ��붼�Ѿ����
        // �������ķ�ʽ�Ǹ�״̬ת�Ʒ�����صΣ�������˵���Ǹ���̬�滮���������ɹ�����ص�
        for (int i = 1; i <= n; i++) {// ������1��n
            for (int j = 1; j <= W; j++) {// ������1��W
            	 // ��ʱ������һ��i��j��λ��Ҫ�result[i][j]
                if (j - w[i - 1] < 0)
                    result[i][j] = result[i - 1][j];
                else
                    result[i][j] = Math.max(result[i - 1][j], v[i - 1] + result[i - 1][j - w[i - 1]]);
            }
        }

        
	}
	public static void outputWhich(int[][] result,int[] x,int[] w) { //�ҳ���Ӧ�ı����ֱ����ļ���
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
		 int[] w = { 2, 1, 3, 2 }; // ��������
	     int[] v = { 12, 10, 20, 15 }; // ��ֵ����
	     int W = 5;
	     int [][] result = new int[w.length+1][W+1]; // ǰi����Ʒ��i��0��n����W��0��W
	    
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
