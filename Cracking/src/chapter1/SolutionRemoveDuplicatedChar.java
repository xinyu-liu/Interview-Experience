package chapter1;

public class SolutionRemoveDuplicatedChar {

	public static void main(String[] args) {
		String s="kkkbbb";
		System.out.println(s);
		SolutionRemoveDuplicatedChar solution = new SolutionRemoveDuplicatedChar();
		//String newS = solution.solveNoLargeSpaceBruteForce(s);
		//System.out.println(newS);
		String newS2 = solution.solveConstantSpace(s);
		System.out.println(newS2);

	}
	public String solveNoLargeSpaceBruteForce(String s){ //use SB
		if(s==null){
			return null;
		}
		if(s.length()<2){
			return s;
		}
		int length = s.length();
		StringBuilder sb = new StringBuilder(s);
		for(int i =0;i<length;i++){
			for (int j = i+1;j<length;){
				if(sb.charAt(i)==sb.charAt(j)){
					sb.deleteCharAt(j);
					length -=1;
				}
				else{
					j++;
				}
			}
		}
		return sb.toString();
	}
	public String solveConstantSpace(String s){ // use char[]
		char[] arr = s.toCharArray();
		boolean[] tf = new boolean[256];
		java.util.Arrays.fill(tf, false);
		int curIndex=0;
		for(int i = 0; i<arr.length;i++){
			
			if(! tf[ arr[i] ] ){
				tf[ arr[i] ] = true;
				arr[curIndex]=arr[i];
				curIndex ++;
			}
		}
		return new String(arr).substring(0, curIndex);
	}
}
