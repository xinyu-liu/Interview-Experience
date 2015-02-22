package WordBreak;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SolutionII s = new SolutionII();
		String string = "aaaaaaaaaaa";
		Set<String> dict = new HashSet<String>();
		dict.add("a");
		dict.add("aa");

	

		List<String> list  = s.wordBreak(string,  dict);
		System.out.print(list);
		
	}

}
