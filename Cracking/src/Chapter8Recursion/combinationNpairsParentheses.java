package Chapter8Recursion;

import java.util.ArrayList;

public class combinationNpairsParentheses {
		public static void parentheses(int alreadyL,int alreadyR,String arr, int numOfPairs, ArrayList<String> result){

			if( (alreadyL+alreadyR) >= numOfPairs * 2){
				result.add(arr);
				return;
			}
			if(alreadyL==0){
				arr = "(" ;
				parentheses(alreadyL+1,alreadyR,arr,numOfPairs,result);
			}
			else{
				// add "("
				if(alreadyL < numOfPairs ){
				parentheses(alreadyL+1,alreadyR,( arr+"(" ),numOfPairs,result);
				}
				//add ")"
				if(alreadyR < alreadyL ){ 
					parentheses(alreadyL,alreadyR+1,( arr+")" ),numOfPairs,result);
				}		
			}
		}
		
		public static void printArrayLists(ArrayList<String> result){
			for (int i = 0; i < result.size(); i++){
				System.out.println(result.get(i).toString());
			}
		}
		public static void main(String[] args) {
			int numOfPairs = 4;
			ArrayList<String> result = new  ArrayList<String>();
			String arr = new String();
			parentheses(0,0,arr,numOfPairs, result);
			printArrayLists(result);
		}

}
