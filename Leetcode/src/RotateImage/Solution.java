package RotateImage;

public class Solution {
	
	// MINE: 最简单的想法，两重循环。
	// 第一重循环是对于矩阵的层次（从外到内）第二重循环是对于每一层次的四元素轮换
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for(int layer = 0; layer < n/2; layer++){
        	for(int j = layer; j < n-1-layer; j++){
        		int temp = matrix[n-1-j][layer];
        		matrix[n-1-j][layer] = matrix[n-1-layer][n-1-j];
        		matrix[n-1-layer][n-1-j] = matrix[j][n-1-layer] ;
        		matrix[j][n-1-layer]  = matrix[layer][j];
        		matrix[layer][j] = temp;
        	}
        }
    }
}
