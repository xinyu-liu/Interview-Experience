package SurroundedRegions;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
	class Point{
		int i;
		int j;
		Point(int i,int j){
			this.i = i;
			this.j = j;
		}
	}
    public void solve(char[][] board) {    	
    	int h = board.length;
    	if (h < 3) return;
        int w = board[0].length;
        if( w < 3) return;
        
    	Queue<Point> queue = new LinkedList<Point>();
        for(int i = 0; i < w; i++){
        	if(board[0][i]=='O'){
        		queue.add(new Point(0,i));
        	}
        	if(board[h-1][i]=='O'){
        		queue.add(new Point(h-1,i));
        	}
        }
        for(int i = 0; i < h; i++){
        	if(board[i][0]=='O'){
        		queue.add(new Point(i,0));
        	}
        	if(board[i][w-1]=='O'){
        		queue.add(new Point(i,w-1));
        	}
        }
        while(!queue.isEmpty()){
        	Point cur = queue.remove();
        	board[cur.i][cur.j]='Y';
        	if (cur.i-1 >= 0 && board[cur.i-1][cur.j]=='O'){
        		queue.add( new Point(cur.i-1,cur.j) );
        	}
        	if (cur.i+1 < h && board[cur.i+1][cur.j]=='O'){
        		queue.add( new Point(cur.i+1,cur.j) );
        	}
        	if (cur.j-1 >= 0 && board[cur.i][cur.j-1]=='O'){
        		queue.add( new Point(cur.i,cur.j-1) );
        	}
        	if (cur.j+1 < w && board[cur.i][cur.j+1]=='O'){
        		queue.add( new Point(cur.i,cur.j+1) );
        	}
        }
        for(int i = 0; i < h; i++){
        	for (int j = 0; j < w; j++){
        		if(board[i][j] =='O'){
        			board[i][j] ='X';
        		}
        		if(board[i][j] =='Y'){
        			board[i][j] ='O';
        		}
        	}
        }
    }
	// java.lang.StackOverflowError
    public void solve2(char[][] board) {
    	if(board == null){
    		return;
    	}
    	int h = board.length;
    	if (h < 3) return;
        int w = board[0].length;
        if( w < 3) return;
    
        for(int i = 0; i < w; i++){
        	if(board[0][i]=='O'){
        		board[0][i]='Y';
        		check(0,i,board);
        	}
        	if(board[h-1][i]=='O'){
        		board[h-1][i]='Y';
        		check(h-1,i,board);
        	}
        }
        for(int i = 0; i < h; i++){
        	if(board[i][0]=='O'){
        		board[i][0]='Y';
        		check(i,0,board);
        	}
        	if(board[i][w-1]=='O'){
        		board[i][w-1]='Y';
        		check(i,w-1,board);
        	}
        }
    }
    private void check(int i, int j,char[][] board){
    	if (i-1 >= 0 && board[i-1][j]=='O'){
    		board[i-1][j] ='Y';
    		check(i-1, j, board);
    	}
    	if (i+1 < board.length && board[i+1][j]=='O'){
    		board[i+1][j] ='Y';
    		check(i+1, j, board);
    	}
    	if (j-1 >= 0 && board[i][j-1]=='O'){
    		board[i][j-1] ='Y';
    		check(i, j-1, board);
    	}
    	if (j+1 < board[0].length && board[i][j+1]=='O'){
    		board[i][j+1] ='Y';
    		check(i, j+1, board);
    	}
    }
}
