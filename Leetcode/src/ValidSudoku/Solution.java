package ValidSudoku;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public boolean isValidSudoku(char[][] board) {
        int m = board.length;
        boolean[][] rowCheck = new boolean[m][m];
        boolean[][] columnCheck = new boolean[m][m];
        boolean[][] squareCheck = new boolean[m][m];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < m; j++){
                if(board[i][j] == '.') continue;
                int pos = atoi(board[i][j]);
                if( rowCheck[i][pos] || columnCheck[j][pos] || squareCheck[(i/3)*3+(j/3)][pos] ) {
                    return false;
                }
                else{
                    rowCheck[i][pos] = true;
                    columnCheck[j][pos] = true;
                    squareCheck[(i/3)*3+(j/3)][pos] = true;
                }
            }
        }
        return true;
    }
    private int atoi(char c){
        return (int)(c-'1');
        // 1-9 0-8
    }
    public boolean isValidSudoku2(char[][] board) {
        int len = board.length;
    	boolean r[][] = new boolean[9][10];
    	boolean c[][] = new boolean[9][10];
    	boolean sq[][] = new boolean[9][10];
        for(int i = 0; i < len; i++){
        	for(int j = 0; j < len; j++){
        		char ch = board[i][j];
        		if(ch != '.'){
        			if (r[i][ch-'0']) return false;
        			else r[i][ch-'0'] = true;
        			if (c[j][ch-'0']) return false;
        			else c[j][ch-'0'] = true;  
        			int m = i/3;
        			m = m*3 + (j/3);
        			if (sq[m][ch-'0']) return false;
        			else sq[m][ch-'0'] = true;        			
        		}
        	}
        }
        return true;
    }
    public boolean isValidSudoku1(char[][] board) {
        int len = board.length;
        Set<Character> set;
        // horizontal
        for(int i = 0; i < len; i++){
        	set = new HashSet<Character>();
        	for(int j = 0; j < len; j++){
        		char c = board[i][j];
        		if(c != '.'){
	        		if( set.contains(c) ){
	        			return false;
	        		}
	        		else{
	        			set.add(c);
	        		}
        		}
        	}
        }
        // vertical
        for(int j = 0; j < len; j++){
        	set = new HashSet<Character>();
        	for(int i = 0; i < len; i++){
        		char c = board[i][j];
        		if(c != '.'){
	        		if( set.contains(c) ){
	        			return false;
	        		}
	        		else{
	        			set.add(c);
	        		}
        		}
        	}
        }
        // 3x3 square
        for(int m = 0; m < len/3; m++){
        	for(int n = 0; n < len/3; n++){
        		// for each square
        		set = new HashSet<Character>();
                for(int i = 0; i < 3; i++){
                	for(int j = 0; j < 3; j++){
                		char c = board[3*m + i][3*n + j];	
                		if(c != '.'){
        	        		if( set.contains(c) ){
        	        			return false;
        	        		}
        	        		else{
        	        			set.add(c);
        	        		}
                		}
                	}
                }
                //
        	}
        }
        return true;
    }
}
