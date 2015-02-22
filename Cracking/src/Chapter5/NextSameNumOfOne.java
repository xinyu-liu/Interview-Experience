package Chapter5;

public class NextSameNumOfOne {
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
		//int i = Integer.valueOf("1000", 2);
		//int j = Integer.valueOf("111", 2);
		int i = 31;
		int j = 14;
		int p = i^j;
		int count = 0;
		while(p>0){
			count+=(p&1);
			p= p>>1;
		}
		System.out.println(count );
		
		//System.out.println("O:="+ printBinary(s) );

	}
}
