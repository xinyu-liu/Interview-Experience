package Chapter5;

public class DecimalBinaryRepres {
	public static String printBinary(String s){
		int intPart = Integer.valueOf( s.substring(0, s.indexOf('.')), 10) ;
		double decPart = Double.valueOf( s.substring(s.indexOf('.')) ) ;
		
		String intResult="";
		while(intPart>0){
			int r = intPart % 2;
			intResult = r + intResult;
			intPart = intPart >> 1;
		}
		
		StringBuffer decResult=new StringBuffer();
		while(decPart!=0.0){
			if(decResult.length()>32){
				return "Error!";
			}
			decPart = decPart*2;
			if(decPart >= 1){
				decPart = decPart-1;
				decResult.append('1');
			}
			else{
				decResult.append('0');
			}
		}
		
		String result = intResult + '.' + decResult;
		return result;
	
	}
	public static void main(String[] args) {
		String s = "22.333";
		System.out.println("S:="+ s );
		
		System.out.println("O:="+ printBinary(s) );

	}
}
