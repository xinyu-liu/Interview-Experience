package Chapter8Recursion;

public class FibonacciNumber {
	public static int generateFibonacci(int n){
		if(n<0){
			return -1;
		}
		if(n==0){
			return 0;
		}
		if(n==1){
			return 1;
		}
		return generateFibonacci(n-1)+generateFibonacci(n-2);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(generateFibonacci (6) );
	}

}
