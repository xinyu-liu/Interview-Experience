package WordSearch;

public class Solution {
	// I use visited[][]
	// Web: 匹配一个字符，我们将它临时变为空，如果之后匹配失败返回，我们再将空字符改写回原来的字符
    public boolean exist(char[][] board, String word) {
    	boolean b = false;
    	boolean[][] visited = new boolean[board.length][board[0].length];
    	for(int i = 0; i < board.length;i++){
    		for(int j = 0; j < board[0].length; j++){
    	    	if(board[i][j]==word.charAt(0)){
    	    		visited[i][j] = true; // board[i][j] = ' ';  
    	    		b = b || dfs(board, word, 1, i,j,visited);
    	    		visited[i][j] = false; // board[i][j] = c;    
    	    	}
    		}
    	}
    	return b;
    }
    private boolean dfs(char[][] board, String word, int cur, int i, int j,boolean[][] visited){
    	if(cur == word.length()){
    		return true;
    	}
    	boolean b = false;
    	if(i-1 >= 0 && !visited[i-1][j] && board[i-1][j]==word.charAt(cur)){
    		visited[i-1][j] = true;
    		b = b || dfs(board, word, cur+1, i-1,j,visited);
    		visited[i-1][j] = false;
    	}
    	if(i+1 < board.length && !visited[i+1][j] && board[i+1][j]==word.charAt(cur)){
    		visited[i+1][j] = true;
    		b = b || dfs(board, word, cur+1, i+1,j,visited);
    		visited[i+1][j] = false;
    	}
    	if(j-1 >= 0 && !visited[i][j-1] && board[i][j-1]==word.charAt(cur)){
    		visited[i][j-1] = true;
    		b = b || dfs(board, word, cur+1, i,j-1,visited);
    		visited[i][j-1] = false;
    	}
    	if(j+1 < board[0].length && !visited[i][j+1] && board[i][j+1]==word.charAt(cur)){
    		visited[i][j+1] = true;
    		b = b || dfs(board, word, cur+1, i,j+1,visited);
    		visited[i][j+1] = false;
    	}
    	return b;
    }
}
