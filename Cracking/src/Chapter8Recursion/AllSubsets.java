package Chapter8Recursion;

import java.util.ArrayList;

public class AllSubsets {
	public static void printArrayLists(ArrayList<ArrayList<Integer>> result){
		for (int i = 0; i < result.size(); i++){
			System.out.println(result.get(i).toString());
		}
	}
	public static void getAllSubsets(int[] set, int index,ArrayList<ArrayList<Integer>> result){
		if(index>=set.length){
			return;
		}
		if(result.size() == 0){
			result.add(new ArrayList<Integer>());
		}
		
		int target = set[index];
		ArrayList<ArrayList<Integer>> arrs = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i<result.size(); i++){
			arrs.add(  (ArrayList<Integer>) result.get(i).clone()  );
			arrs.get(arrs.size()-1).add(target);
		}
		result.addAll(arrs);
		getAllSubsets(set, index+1, result);
		
	}
	public static void main(String[] args) {
		int[] set = {1,2,3,4,5};
		ArrayList<Integer> arr= new ArrayList<Integer>();
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		getAllSubsets(set, 0, result);
		printArrayLists(result);
		
	}

}
