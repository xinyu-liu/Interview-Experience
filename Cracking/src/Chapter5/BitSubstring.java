package Chapter5;

public class BitSubstring {
	public static int setSubstring(int n, int m, int i,int j){
		//// clear n from i to j
		int allOne = ~0;// 11111111111111111111111111111111
		int left = allOne<<(j+1);
		int right = (1<<i)-1;
		int mask = left | right;
		int result = n & mask | (m<<i);
		return result;
	}
	public static void main(String[] args) {
		int n = Integer.valueOf("10000000000",2);
		int m = Integer.valueOf("10101",2);
		System.out.println("N:="+ Integer.toBinaryString(n) );
		System.out.println("M:="+ Integer.toBinaryString(m) );
		System.out.println("O:="+ Integer.toBinaryString( setSubstring(n, m, 2, 6) ) );

	}

}
