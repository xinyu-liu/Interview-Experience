package RotateImage;

public class Solution {
	
	// MINE: ��򵥵��뷨������ѭ����
	// ��һ��ѭ���Ƕ��ھ���Ĳ�Σ����⵽�ڣ��ڶ���ѭ���Ƕ���ÿһ��ε���Ԫ���ֻ�
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
