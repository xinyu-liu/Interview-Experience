package Chapter8Recursion;

import java.util.ArrayList;

public class CentRepresentations {
	// if want to print all representations
	public static void representCents(int moneyLeft,ArrayList<Integer> arr,int curType, int[] typeOfCents, ArrayList<ArrayList<Integer>>result){
		if(moneyLeft==0){
			result.add(arr);
			return;
		}		
		if(moneyLeft<0 || curType >= typeOfCents.length){
			return;
		}
		int times = moneyLeft / typeOfCents[curType];
		for (int i = 0; i<= times; i++){
			// i curType
			ArrayList<Integer> arr1 = (ArrayList<Integer>) arr.clone();
			arr1.add(i);
			representCents(moneyLeft-i*typeOfCents[curType],arr1,curType+1, typeOfCents, result);
		}	
	}
	public static void printArrayLists(ArrayList<ArrayList<Integer>> result){
		for (int i = 0; i < result.size(); i++){
			System.out.println(result.get(i).toString());
		}
	}
	public static void main(String[] args) {
		int money = 25;
		int[] typeOfCents = {25,10,5,1};
		ArrayList<ArrayList<Integer>> result = new  ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> arr = new ArrayList<Integer>();
		// if want to print all representations
		representCents(money,arr,0,typeOfCents, result);
		printArrayLists(result);	
	}

}
