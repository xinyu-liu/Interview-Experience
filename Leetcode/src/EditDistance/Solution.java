package EditDistance;

public class Solution {
	// NOTE:如果i所代表的的字符 == j所代表的字符，
	// No Operation: opt[i][j] = opt[i-1][j-1] !
    public int minDistance(String word1, String word2) {
        int[][] opt = new int[word1.length()+1][word2.length()+1];
        // init
        for(int i = 0; i < word1.length()+1; i++){
        	opt[i][0] = i;
        }
        for(int j = 0; j < word2.length()+1; j++){
        	opt[0][j] = j;
        }
        for(int i = 1; i < word1.length()+1; i++){
        	 for(int j = 1; j < word2.length()+1; j++){
        		 if(word1.charAt(i-1) == word2.charAt(j-1)){
        			 opt[i][j]=opt[i-1][j-1];
        		 }
        		 else{
        			 opt[i][j] = 1 + Math.min( Math.min(opt[i-1][j], opt[i][j-1]),opt[i-1][j-1] );
        		 }
        	 }
        }
        return opt[word1.length()][word2.length()];
    }
}
