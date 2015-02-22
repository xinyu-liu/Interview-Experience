package Triangle;

import java.util.ArrayList;
import java.util.List;

public class Tester {

	public static void main(String[] args) {
		Solution sol = new Solution();
		List<List<Integer>> triangle = new ArrayList<List<Integer>>();
		List<Integer> list = new ArrayList<Integer>();
		list.add(-1);
		triangle.add(list);
		
		list = new ArrayList<Integer>();
		list.add(2);
		list.add(3);
		triangle.add(list);
		
		list = new ArrayList<Integer>();
		list.add(1);
		list.add(-1);
		list.add(-3);
		triangle.add(list);
		System.out.print( sol.minimumTotal(triangle) );
		

	}

}
