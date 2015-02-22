package SetMatrixZeroes;

public class Solution {
	// 看了下面的要求，最先想到的就是O(m+n)的空间，就是加一行一列来标记哪行哪列有0。
	// O(1)空间，不额外加一行一列，就用第一行和第一列来存储哪行哪列有0。
	// 当然，这样做比较麻烦的是第一行第一列的原始信息，需要先保存下来。
	// 写的时候，第一行&第一列处理好
	// web: http://blog.csdn.net/ljiabin/article/details/40423045
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int i, j;
        
        //先标记第一行和第一列是否有0
        boolean firstRow = false, firstCol = false;
        for (j = 0; j < n; j++) {
            if (0 == matrix[0][j]) {
                firstRow = true;
                break;
            }
        }
        for (i = 0; i < m; i++) {
            if (0 == matrix[i][0]) {
                firstCol = true;
                break;
            }
        }
         
        //从第二行第二列还是遍历，如果遇到0，则把它所在行和列的第一个值设为0   
        for (i = 1; i < m; i++) {
            for (j = 1; j < n; j++) {
                if (0 == matrix[i][j]) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        
        //把第一列的0所在行都设为0，把第一行的0所在列都设为0
        for (i = 1; i < m; i++) {
            if (0 == matrix[i][0]) {
                for (j = 1; j < n; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (j = 1; j < n; j++) {
            if (0 == matrix[0][j]) {
                for (i = 1; i < m; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
        
        //根据标记决定第一行和第一列是否全设为0
        if (firstRow) {
            for (j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }
        if (firstCol) {
            for (i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }
	// mine
    public void setZeroesM(int[][] matrix) {
    	if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
    		return;
    	}
    	int h = matrix.length;
    	int w = matrix[0].length;
        int fc = 1;
        
        // each row
        for(int i = 0; i < h; i++){
        	if(matrix[i][0] == 0){
        		fc = 0;
        	}
        	for(int j = 0; j < w; j++){
        		if(matrix[i][j] == 0){
        			matrix[i][0] = 0;
        			break;
        		}
        	}
        }
        // each column
        for(int j = 1; j < w; j++){
        	for(int i = 0; i < h; i++){
        		if(matrix[i][j] == 0){
        			matrix[0][j] = 0;
        			break;
        		}
        	}
        }
        for(int i = 1; i < h; i++){ //////////////CANNOT from 0 -> change next for loop
        	if(matrix[i][0] == 0){
        		for(int j = 0; j < w; j++){
        			matrix[i][j] = 0;
        		}
        	}
        }
        for(int j = 1; j < w; j++){
        	if(  matrix[0][j] == 0 ){        
        		for(int i = 0; i < h; i++){	
        			matrix[i][j] = 0;
        		}
        	}
        }
        if(matrix[0][0] == 0){ ///// for i == 0, recover what left 
    		for(int j = 0; j < w; j++){
    			matrix[0][j] = 0;
    		}
    	}
    	if( fc == 0 ){        
    		for(int i = 0; i < h; i++){	
    			matrix[i][0] = 0;
    		}
    	}
    }
}
