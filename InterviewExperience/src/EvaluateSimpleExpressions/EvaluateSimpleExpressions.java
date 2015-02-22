package EvaluateSimpleExpressions;

public class EvaluateSimpleExpressions {
	/*
	Q1.of digits and operands. Eg. 1+2*3 , 1-2+4. 
	If the expression is of incorrect syntax return -1.
Test cases :
a) 1+2*3 will be evaluated to 9.
b) 4-2+6*3 will be evaluated to 24.
c) 1++2 will be evaluated to -1(INVALID).
Also, in the string spaces can occur. For that case we need to ignore the spaces. Like : 1*2 -1 is equals to 1.

*/
	public int solve(String s){
		StringBuffer sb = new StringBuffer(s);
		int len = 0;
		for(int i = 0; i < sb.length(); i++){
			char c = sb.charAt(i);
			if(isD(c) || isOp(c)) sb.setCharAt(len++, c);
			else if(c != ' ') return -1;
		}
		///////
		return solveNoSpace(sb.toString());
	}
	public int solveNoSpace(String s){
		String[] arr = s.split("[+*/-]");
		for(String str: arr) System.out.println(str);
		return 1;
	}
	
	private int calc(int d1, int d2, char c){
		if( c == '+' ) return d1 + d2;
		else if( c == '-' ) return d1 - d2;
		else if( c == '*' ) return d1 * d2;
		else return d1 / d2; 
	}
	private boolean isD(char c){
		return c <= '9' && c >= '0' ;
	}
	private boolean isOp(char c){
		return c == '+' || c == '-' || c == '*' || c == '/' ;
	}
	
	public static void main (String[] args) throws java.lang.Exception
	{
		EvaluateSimpleExpressions sol = new EvaluateSimpleExpressions();
		System.out.println( sol.solve(" 4-2+6*3 ") );
	}
}
