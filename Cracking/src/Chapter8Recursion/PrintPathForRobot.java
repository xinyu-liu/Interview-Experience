package Chapter8Recursion;

import java.awt.Point;
import java.util.ArrayList;

public class PrintPathForRobot {
	public static void printPath(int down,int right,
			ArrayList <Point> arr, 
			ArrayList < ArrayList<Point> > result){
		
		if(down == 1 && right == 1 ){
			arr.add(new Point(1,1));
			result.add(arr);
			return;
		}
		
		if(down == 2 && right == 2){ // cannot move to, abort
			return;
		}
		arr.add(new Point(right,down));
		ArrayList <Point> arr1 = (ArrayList<Point>) arr.clone();
		ArrayList <Point> arr2 = (ArrayList<Point>) arr.clone();
				
		
		if (down ==1){
			printPath(down,right-1,arr,result);
		}
		else if (right ==1){
			printPath(down-1,right,arr,result);
		}
		else{
			printPath(down-1,right,arr1,result);
			printPath(down,right-1,arr2,result);
		}
	}
	public static void main(String[] args) {
		int n = 4;
		ArrayList <Point> arr = new ArrayList <Point>();
		ArrayList < ArrayList<Point> > result = new ArrayList < ArrayList<Point> >();
		printPath(n,n,arr,result);
		System.out.println(result.size());
	}

}
