package chapter1;

public class SolutionCompressRepeatChar {
	public static void main(String[] args){
		String s = "cab";
		String newS = solve(s);
		
		System.out.println(s);
		System.out.println(newS);
	}
	public static String solve(String s){
		///// check if longer /////
		if(isLonger(s)){
			return s;
		}
		
		///////normal/////
		StringBuilder b = new StringBuilder();
		
		char current = s.charAt(0);
		int count = 1;
		
		for(int i=1;i<s.length();i++){
			if(s.charAt(i)==current){
				count++;
			}
			else{
				b.append(current);//// separate
				b.append(count);  //// separate
				count=1;
				current = s.charAt(i);
			}
		}
		b.append(current); 	/////dont forget!!!!!
		b.append(count);	/////dont forget!!!!!
		
		return b.toString();
	}
	private static boolean isLonger(String s){
		int length =0;
		int count = 1;
		char current = s.charAt(0);
		
		for(int i=1;i<s.length();i++){
			if(s.charAt(i)==current){
				count++;
			}
			else{
				length += (1+String.valueOf(count).length());
				count = 1;
				current = s.charAt(i);
			}
		}
		length += (1+String.valueOf(count).length());
		
		if(length<=s.length()){
			return false;	
		}
		else{
			return true;
		}
	}
	
}
