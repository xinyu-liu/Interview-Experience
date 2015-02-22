package SurroundedRegions;

public class Tester {
	public static void main(String[] args){
		Solution sol = new Solution();
		char[][] board = {{'O','O','O'},{'O','O','O'},{'O','O','O'}};
		
		sol.solve(board);
        for(int i = 0; i < board.length; i++){
        	for (int j = 0; j < board[0].length; j++){
        		System.out.print(board[i][j] + " ");
        	}
        	System.out.println();
        }
	}
}
