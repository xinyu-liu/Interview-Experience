package CombinationsOfMappingToANumber;

import java.util.ArrayList;

public class CombinationsOfMappingToANumber {
	////////Count !!!!!!! ////////////
	// Count Possible Decodings of a given Digit Sequence
	// http://www.geeksforgeeks.org/count-possible-decodings-given-digit-sequence/
	public int countBU(char[] arr){
		int n = arr.length;
		if(n == 0) return 1;
		int[] dp = new int[n];
		for(int i = 0; i < n; i++){
			if( isValid(arr[i]-'0') ){
				if(i == 0)  dp[i] = 1;
				else		dp[i] += dp[i-1];
			}
			if(i >= 1 && isValid( (arr[i]-'0') + 10 * (arr[i-1]-'0') ) ){
				if(i == 1)  dp[i] += 1;
				else 		dp[i] += dp[i-2];
			}
			
		}
		return dp[n-1];
	}
	
	//////// Combinations !!!!!!! ////////////
	public void solveDP(String s){
		int n = s.length();
		ArrayList< ArrayList<String> > records = new ArrayList< ArrayList<String> > ();
		ArrayList<String> list = new ArrayList<String>();
		int d = Integer.parseInt(s.substring(0, 1));
		if(isValid(d)){
			list.add(String.valueOf(itoa(d)));
		}
		records.add(list);
		
		for(int i = 1; i < n; i++){
			list = new ArrayList<String>();
			d = Integer.parseInt(s.substring(i, i+1));
			if(isValid(d)){
				String c = String.valueOf(itoa(d));
				for(String p : records.get(i-1)){	
					list.add(p+c);
				}
				
			}

			d = Integer.parseInt(s.substring(i-1, i+1));
			if(isValid(d)){
				String c = String.valueOf(itoa(d));
				if(i == 1) list.add(c);
				else{
					for(String p : records.get(i-2)){	
						list.add(p+c);
					}
				}
			}
			records.add(list);
		}
		// print
		for(String p : records.get(n-1)){	
			System.out.println(p);
		}
	}
	// O(2^l)
	public void solveDFS(String s){
		dfs(s, 0, new StringBuffer() );
	}
	private void dfs(String s, int i, StringBuffer path){
		if(i == s.length()){
			System.out.println(path);
			return;
		}
		int d = Integer.parseInt(s.substring(i,i+1));
		if( isValid(d) ) {
			path.append( itoa(d) );
			dfs(s, i+1, path);
			path.deleteCharAt(path.length()-1);
		}
		if(i+1 < s.length()){
			d = Integer.parseInt(s.substring(i,i+2));
			if( isValid(d) ) {
				path.append( itoa(d) );
				dfs(s, i+2, path);
				path.deleteCharAt(path.length()-1);
			}
		}
	}
	private boolean isValid(int i){
		return i>0 && i < 27;
	}
	private char itoa(int i){
		return (char)(i-1+(int)'a');
	}
	public static void main (String[] args) throws java.lang.Exception
	{
		CombinationsOfMappingToANumber sol = new CombinationsOfMappingToANumber();

		// sol.solveDFS("121") ;
		// sol.solveDP("121") ;
		char[] arr = {'1', '2', '3', '4'};
		System.out.print( sol.countBU(arr) );
		
	}
}
