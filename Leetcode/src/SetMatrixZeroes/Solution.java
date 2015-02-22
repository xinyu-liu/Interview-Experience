package SetMatrixZeroes;

public class Solution {
	// ���������Ҫ�������뵽�ľ���O(m+n)�Ŀռ䣬���Ǽ�һ��һ�����������������0��
	// O(1)�ռ䣬�������һ��һ�У����õ�һ�к͵�һ�����洢����������0��
	// ��Ȼ���������Ƚ��鷳���ǵ�һ�е�һ�е�ԭʼ��Ϣ����Ҫ�ȱ���������
	// д��ʱ�򣬵�һ��&��һ�д����
	// web: http://blog.csdn.net/ljiabin/article/details/40423045
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int i, j;
        
        //�ȱ�ǵ�һ�к͵�һ���Ƿ���0
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
         
        //�ӵڶ��еڶ��л��Ǳ������������0������������к��еĵ�һ��ֵ��Ϊ0   
        for (i = 1; i < m; i++) {
            for (j = 1; j < n; j++) {
                if (0 == matrix[i][j]) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        
        //�ѵ�һ�е�0�����ж���Ϊ0���ѵ�һ�е�0�����ж���Ϊ0
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
        
        //���ݱ�Ǿ�����һ�к͵�һ���Ƿ�ȫ��Ϊ0
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
