package SudokuSolver;

import java.util.ArrayList;

public class Solution {
	/*  http://blog.csdn.net/u011095253/article/details/9158497
	 * 首先这道题的思路的比较直观，我们先把空着的格子统计出来放到一个ArrayList<int> 里面, 然后开始运用dfs

首先每当填入一个数字的时候我们需要用isValid来验证，只有不冲突的情况下才能添加进格子里

dfs 函数返回值定义为boolean 

if(dfs(empty,board,cur+1,len))运行成功往上一层返回true，如果不成功, 把刚填入的数字抹去再去试下一个数字，如果这一层的数字都不成功，返回false, 跳回上一层进行修改，最后如果cur==len 的时候所有格子都填完返回true，一路返回true上去完成任务


	 */
    public void solveSudoku(char[][] board) {  
    	ArrayList<ArrayList<Integer>> empty= new ArrayList<ArrayList<Integer>>();
    	for(int i = 0; i < board.length; i++ ){
    		for(int j = 0; j < board.length; j++){
    			if(board[i][j] == '.'){
    				ArrayList<Integer> arr = new ArrayList<Integer>();
    				arr.add(i);
    				arr.add(j);
    				empty.add(arr);
    			}
    		}
    	}
    	dfs(empty, 0, board);
    }
    private boolean dfs(ArrayList<ArrayList<Integer>> empty, 
    					int i,char[][] board){
    	if(i == empty.size()){
    		return true;
    	}
    	int curI = empty.get(i).get(0);
    	int curJ = empty.get(i).get(1);
    	for(int d = 1; d < 10; d++){ ///////////////// NO ZERO !!! START FROM 1 !!!!!
    		if( check( (char)(d+'0'), curI, curJ, board) ){
    			board[curI][curJ] = (char)(d+'0');
    			if( dfs(empty,i+1,board) ){
    				return true;
    			}
    			board[curI][curJ] = '.'; // no need
    		}	
    	}
    	return false;  	
    }
    private boolean check(char c, int i, int j, char[][] board){
    	int len = board.length;
    	int m = i/3;
    	int n = j/3;
    	for(int p = 0; p < len; p++){
    		if(board[p][j] == c){
    			return false;
    		}
    		if(board[i][p] == c){
    			return false;
    		}
    		if(board[3*m + p/3][3*n+ p%3] == c){
        		return false;
        	}
    	}
    	return true;
    }
//	public void solveSudoku(char[][] board) {  
//		ArrayList
		// find empty 
//	}
	
	// WRONG TERMINAL
	// Input:	["..9748...","7........",".2.1.9...","..7...24.",".64.1.59.",".98...3..","...8.3.2.","........6","...2759.."]
	// 		  Output:	["019748632","735026184","426139057","357680241","264317598","198452360","940863725","572904816","681275903"]
	// 		Expected:	["519748632","783652419","426139875","357986241","264317598","198524367","975863124","832491756","641275983"]

    public void solveSudokuWRONG(char[][] board) {  
    	boolean r[][] = new boolean[9][10];
    	boolean c[][] = new boolean[9][10];
    	boolean sq[][] = new boolean[9][10];
    	// init
        init(r,c,sq,board);
        dfsWRONG(0,0,r,c,sq,board);
        
    }
    private boolean dfsWRONG(int startI, int startJ,
    		boolean r[][],boolean c[][],boolean sq[][],char[][] board){
    	int len = board.length;
    	int i= startI;
    	int j = startJ; 
    	boolean find = false;
        for(i= startI; !find && i < len;){
        	for(; !find && j < len; j++){///////////// CANNOT INITIATE j EACH TIME SINCE J= STARTJ==8 SOMETIMES
        		if(board[i][j] == '.'){
        			find = true;
        			break;
        		}
        	}
        	if(!find){
        		i++;
        		j=0;///////////// SET TO ZERO -> THIS FIND EMPTY IS NOOOOOOOOOOOOO GOOD
        	}
        }
        if(i == len){
        	return true; 
        }
        // find available
		int m = i/3;
		m = m*3 + (j/3);
		find = false;
        for(int d = 0; !find && d < 10; d++){
        	if(!r[i][d] && !c[j][d] && !sq[m][d]){
        		r[i][d] = true;
        		c[j][d] = true;
        		sq[m][d] = true;
        		board[i][j] = (char)(d+'0');
        		if(dfsWRONG(i,j,r,c,sq,board)){
        			find =  true;
        		}
        		else{
        			board[i][j] = '.';
        			r[i][d] = false;
        			c[j][d] = false;
        			sq[m][d] = false;
        		}
        	}
        }
        return find;   	
    }
    private void init(boolean r[][],boolean c[][],boolean sq[][],char[][] board){
    	int len = board.length;    	
        for(int i = 0; i < len; i++){
        	for(int j = 0; j < len; j++){
        		char ch = board[i][j];
        		if(ch != '.'){
        			r[i][ch-'0'] = true;
        			c[j][ch-'0'] = true;  
        			int m = i/3;
        			m = m*3 + (j/3);
        			sq[m][ch-'0'] = true;        			
        		}
        	}
        }
    }
}
