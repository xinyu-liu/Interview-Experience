package PalindromePartitioning;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
	// II new
	// http://blog.csdn.net/fightforyourdream/article/details/17601815
	// http://blog.csdn.net/u011095253/article/details/9177451
	// http://www.cnblogs.com/ganganloveu/p/3982561.html
    public int minCut(String s) {
        int len = s.length();
        if(len < 2) return 0;
        boolean[][] isPalin = new boolean[len][len];
        for(int i = 0; i < len; i++){
            for(int j = i; j< len; j++){
                isPalin[i][j] = isPalin(s, i, j);
            }
        }
        int[] opt = new int[len];
        opt[0] = 0;
        for(int e = 1; e < len; e++){
            int min = Integer.MAX_VALUE;
            for(int start = 0; start <= e; start++){
                if(isPalin[start][e] ) {
                    if(start == 0) {
                        min = 0;
                        break;
                    }
                    else{
                        min = Math.min( min, opt[start-1]+1 );
                    }
                }
            }
            opt[e] = min;
        }
        return opt[len-1];
    }
    private boolean isPalin(String s, int i, int j){
        while(i < j){
            if(s.charAt(i)!= s.charAt(j)) return false;
            i++; j--;
        }
        return true;
    }
	// II O(n^2)
    public int minCutOld(String s) {
        if (s==null){
        	return 0;
        }
        // prepare matrix
        int length = s.length();
        boolean[][] table = new boolean[length][length];
        for(int i = 0; i < length; i++){
        	table[i][i]=true;
        }
        for(int i = 0; i < length-1; i++){
        	if(s.charAt(i)==s.charAt(i+1)){
        		table[i][i+1]=true;
        	}
        }
        for(int l = 3; l<=length; l++){
        	for(int i = 0; i<length-l+1;i++){
            	if(table[i+1][i+l-2] && s.charAt(i)==s.charAt(i+l-1)){
            		table[i][i+l-1]=true;
            	}
        	}
        }
        // DP
        int[] opt = new int[length];
        opt[0] = 0;
        for(int i = 1; i < length; i++){
        	if(table[0][i]){
        		opt[i] = 0;
        	}
        	else{
        		int minCut = Integer.MAX_VALUE;
        		for(int j = 1; j <= i; j++){
        			if(table[j][i] && minCut > opt[j-1]+1){
        				minCut = opt[j-1]+1;
        			}
        		}
        		opt[i] = minCut;
        	}
        }
        return opt[length-1]; 
    }
    
    
    
    
    
    // I
    public List<List<String>> partition(String s) {
    	List<List<String>> ans = new ArrayList<List<String>>();
        if (s==null){
        	return ans;
        }
        // prepare matrix
        int length = s.length();
        boolean[][] table = new boolean[length][length];
        for(int i = 0; i < length; i++){
        	table[i][i]=true;
        }
        for(int i = 0; i < length-1; i++){
        	if(s.charAt(i)==s.charAt(i+1)){
        		table[i][i+1]=true;
        	}
        }
        for(int l = 3; l<=length; l++){
        	for(int i = 0; i<length-l+1;i++){
            	if(table[i+1][i+l-2] && s.charAt(i)==s.charAt(i+l-1)){
            		table[i][i+l-1]=true;
            	}
        	}
        }
        // calc
        Map<Integer,List<List<String>>> map = new HashMap<Integer,List<List<String>>>();
        
        List<List<String>> list = new ArrayList<List<String>>();
        List<String> l = new ArrayList<String>();
        l.add(String.valueOf(s.charAt(0)));
        list.add(l);
      
        map.put(0, list);
        for (int i = 1; i < length; i++){
        	list = new ArrayList<List<String>>();
        	for(int j = 0; j <= i; j++){
        		if(j == 0 && table[j][i]){
        			l = new ArrayList<String>();
        			l.add(s.substring(0,i+1));
        			list.add(l);
        		}
        		else if(table[j][i]){
        			List<List<String>> prev = map.get(j-1);
        			for(int p = 0; p < prev.size(); p++){
        				l = new ArrayList<String>();
        				for(int q = 0; q <prev.get(p).size(); q++ ){
        					l.add(prev.get(p).get(q));
        				}
        				l.add(s.substring(j,i+1)) ;
        				list.add(l);
        			}
        		}		
        	}
        	map.put(i, list);
        }
        return map.get(length-1);
    }
}
