package DecimalValueOf1OverN;

public class PrintFirstKDigitsOfDecimalValueOf1OverN {
	public void printFirstK(int n, int k){
		int rem = 1;
		for(int i = 0; i < k; i++){
			System.out.print( rem * 10 / n);
			rem = (rem * 10 ) %n;
		}
	}
	public static void main(String[] args) {
		PrintFirstKDigitsOfDecimalValueOf1OverN sol = new PrintFirstKDigitsOfDecimalValueOf1OverN();
		sol.printFirstK(50, 4);
	}
}

