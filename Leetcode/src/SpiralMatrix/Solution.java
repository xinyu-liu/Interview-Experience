package SpiralMatrix;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	// II
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        int layer = 0;
        int d = 1;
        while(d < n*n){
        	for(int i = layer; i < n - 1 - layer; i++)
        		ans[layer][i] = d++;
        	
        	for(int i = layer; i < n - 1 - layer; i++)
        		ans[i][n - 1 - layer] = d++;
        	
        	for(int i = n - 1 - layer; i > layer; i--)
        		ans[n - 1 - layer][i] = d++;
        
        	for(int i = n - 1 - layer; i > layer; i--)
        		ans[i][layer] = d++;
        	layer++;
        }
        if(n%2 == 1) ans[n/2][n/2] = d;
        return ans;
    }
    // web 四条边bound的方法
    public int[][] generateMatrixWeb(int n) {
        int[][] res = new int[n][n];
        int k = 1;
        int top = 0, bottom = n - 1, left = 0, right = n - 1;
        while (left < right && top < bottom) {
            for (int j = left; j < right; j++) {
                res[top][j] = k++;
            }
            for (int i = top; i < bottom; i++) {
                res[i][right] = k++;
            }
            for (int j = right; j > left; j--) {
                res[bottom][j] = k++;
            }
            for (int i = bottom; i > top; i--) {
                res[i][left] = k++;
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        if (n % 2 != 0)
            res[n / 2][n / 2] = k;
        return res;
    }
    // I
    public List<Integer> spiralOrder(int[][] matrix) {
    	List<Integer> ans = new ArrayList<Integer>();
    	if(matrix.length == 0 || matrix[0].length==0){
    		return ans;
    	}
        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0; 
        int right = matrix[0].length - 1;
        while(top < bottom && left < right){
        	for(int j = left; j < right; j++){
        		ans.add(matrix[top][j]);
        	}
        	for(int i = top; i < bottom; i++){
        		ans.add(matrix[i][right]);
        	}
        	for(int j = right; j > left; j--){
        		ans.add(matrix[bottom][j]);
        	}
        	for(int i = bottom; i > top; i--){
        		ans.add(matrix[i][left]);
        	}
    		top++;
    		bottom--;
    		left++;
    		right--;
        }
        if(top == bottom && left == right){
        	ans.add(matrix[top][left]);
        }
        else if(top == bottom){
        	for(int j = left; j <= right; j++){
        		ans.add(matrix[top][j]);
        	}
        }
        else if(left == right){
        	for(int i = top; i <= bottom; i++){
        		ans.add(matrix[i][left]);
        	}
        }
        return ans;
    }
}
