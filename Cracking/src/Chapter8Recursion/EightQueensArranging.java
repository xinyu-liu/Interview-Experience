package Chapter8Recursion;

import java.util.ArrayList;

public class  EightQueensArranging {
	private static boolean isColumnOK(int target,ArrayList<Integer> arr){
		for(int i = 0; i<arr.size(); i++){
			if(arr.get(i)==target || Math.abs(arr.get(i)-target)==(arr.size()-i)){
				return false;
			}
		}
		return true;
	}
	
	public static void arrange( ArrayList<Integer> arr,ArrayList<ArrayList<Integer>> result) {
		if(arr.size() >= 8){
			result.add(arr);
			return;
		}
// same if remove 
/*		if(arr.size() == 0){
			for(int i = 0; i < 8;i++ ){ 
				ArrayList<Integer> arr1 = (ArrayList<Integer>) arr.clone();
				arr1.add(i);
				arrange(arr1, result);
			}
		}
		else{
*/			for(int i = 0; i < 8;i++ ){ 
				if(isColumnOK(i, arr)){
					ArrayList<Integer> arr1 = (ArrayList<Integer>) arr.clone();
					arr1.add(i);
					arrange(arr1, result);
				}
			}
//		}

	}
	public static void printArrayLists(ArrayList<ArrayList<Integer>> result){
		for (int i = 0; i < result.size(); i++){
			System.out.println(result.get(i).toString());
		}
	}
	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		arrange( arr, result);
		printArrayLists(result);	
	}

}
