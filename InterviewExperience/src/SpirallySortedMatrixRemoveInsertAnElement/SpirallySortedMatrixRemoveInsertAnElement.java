package SpirallySortedMatrixRemoveInsertAnElement;

public class SpirallySortedMatrixRemoveInsertAnElement {
	boolean removeFirst = false;
	
	boolean isFindRemove = false;
	boolean isFindInsert = false;
	int prev = 0;
	private void dealWithSingle(int[][] matrix, int i,int j, int remove, int insert){
		if(!isFindRemove && matrix[i][j] == remove) isFindRemove = true;
		if(!isFindInsert && matrix[i][j] == insert) isFindInsert = true;
		
		if(removeFirst){
			
		}
		else{
			
		}
	}

	public void removeAndInsert(int[][] matrix, int remove, int insert){
		if(remove == insert) return;
		int t = 0; int b = matrix.length - 1;
		int l = 0; int r = matrix[0].length - 1;
		removeFirst = remove < insert;
		
		while(l < r && t < b){
			for(int j = l; j < r; j++){
				dealWithSingle(matrix, i, j, remove, insert);
				System.out.print( matrix[t][j] +" ");
			}
			for(int i = t; i < b; i++){
				System.out.print( matrix[i][r] +" ");
			}
			for(int j = r; j > l; j--){
				System.out.print( matrix[b][j] +" ");
			}
			for(int i = b; i > t; i--){
				System.out.print( matrix[i][l] +" ");
			}
			l++; r--; t++; b--;
		}
		if(l == r && t == b){
			System.out.print( matrix[t][l] +" ");
		}
		else if (l == r){
			for(int i = t; i < b; i++){
				System.out.print( matrix[i][r] +" ");
			}
		}
		else if( t == b){
			for(int j = l; j < r; j++){
				System.out.print( matrix[t][j] +" ");
			}
		}
	}
	boolean hasRemove = false;
	boolean hasInsert = false;
	int insertAt = 0;
	public void printMatrix(int[][] matrix,int remove, int insert){
		int t = 0; int b = matrix.length - 1;
		int l = 0; int r = matrix[0].length - 1;
		
		while(l < r && t < b){
			for(int j = l; j < r; j++){
				if( !hasRemove && matrix[t][j] == remove) hasRemove = true;
				if( !hasInsert && matrix[t][j] >= insert) {
					hasInsert = true;
					insertAt()
				}
				
				System.out.print( matrix[t][j] +" ");
			}
			for(int i = t; i < b; i++){
				System.out.print( matrix[i][r] +" ");
			}
			for(int j = r; j > l; j--){
				System.out.print( matrix[b][j] +" ");
			}
			for(int i = b; i > t; i--){
				System.out.print( matrix[i][l] +" ");
			}
			l++; r--; t++; b--;
		}
		if(l == r && t == b){
			System.out.print( matrix[t][l] +" ");
		}
		else if (l == r){
			for(int i = t; i < b; i++){
				System.out.print( matrix[i][r] +" ");
			}
		}
		else if( t == b){
			for(int j = l; j < r; j++){
				System.out.print( matrix[t][j] +" ");
			}
		}
	}
	public static void main(String[] args) {
		int[][] matrix = {{ 1, 2, 6, 8,10},
						  {35,36,38,41,13},
						  {32,49,50,43,14},
						  {30,47,46,44,17},
						  {29,26,25,21,19}
						  };
		SpirallySortedMatrixRemoveInsertAnElement sol = new SpirallySortedMatrixRemoveInsertAnElement();
		sol.printMatrix(matrix);
		sol.removeAndInsert(matrix, 6, 12);
		sol.printMatrix(matrix);
	}

}
