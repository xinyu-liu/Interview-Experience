package InvertBitsOfANumber;
/*
 *  Given a number n>0, find the number formed by just inverting the bits of the number.
 *  
 *  for example: binary of 5 is 101 ,inverting the bits we get 010 =2
 *  so input=5 output=2
 *  PS : ~n wouldn¡¯t work

 */
public class InvertBitsOfANumber {
	public static int invertBits(int n){
		int start = 31;
		while(start >= 0 && (n & (1 << start)) == 0 ){
			start--;
		}
		int i = start;
		while(i >= 0){
			if((n & (1<<i)) == 0){ // 0
				n = n | (1<<i);
			}
			else{ // 1
				int maskR = (1<<i) - 1;
				int maskL = 0xFFFFFFFF << (i+1);
				int mask = maskR | maskL;
				n = n & mask;
			}
			i--;
		}
		return n;
	}
	public static void main(String[] args){
		int n = 5;
		System.out.println(n);
		System.out.println(invertBits(n));
	}
}
