package Chapter8Recursion;

import java.util.ArrayList;

public class StringPermutation {
	public static void permutation(String s, int index, ArrayList<String> result) {
		if(index < 0){
			return;
		}
		if(index==s.length()-1){
			result.add (String.valueOf( (s.charAt(index)) ) );

		}
		else{
			ArrayList<String> prevResult = (ArrayList<String>) result.clone();  
			result.clear();
			for(int i = 0; i<prevResult.size();i++){
				String prevS = prevResult.get(i);
				int maxPosition = prevS.length();
				for (int j = 0; j <= maxPosition; j++){
					String curS = prevS.substring(0,j) + s.charAt(index) + prevS.substring(j);
					result.add(curS);
				}
			}
		}
		permutation(s,index-1,result);
	}
	public static void printArrayLists(ArrayList<String> result){
		for (int i = 0; i < result.size(); i++){
			System.out.println(result.get(i).toString());
		}
	}
	public static void main(String[] args) {
		String s = "abc";
		ArrayList<String> result = new  ArrayList<String>();
		permutation(s, s.length()-1, result);
		printArrayLists(result);
	}

}
