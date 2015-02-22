package EgyptianFraction;
/*
 *  http://www.geeksforgeeks.org/greedy-algorithm-egyptian-fraction/
 *  

 */
public class EgyptianFraction {
	public void printEgyptian_Rec(int t, int b){
		if(t == 0 || b == 0) return;
		if(t / b > 0){
			System.out.println(t/b);
	    	t = t -(t/b)*b;
		}
		if(b % t == 0){
			System.out.println("1/"+ b/t );
	    	return;
		}
		int n = b/t + 1;
		System.out.println("1/"+ n );
		printEgyptian_Rec(n*t-b, b*n);
	}
	
	// mine 
	public void printEgyptian_Iter(int t, int b){
		// If either numerator or denominator is 0
	    if(t/b > 0){
	    	System.out.println(t/b);
	    	t = t -(t/b)*b;
	    }
	    if (t == 0 || b == 0)
	        return;
	    
		while(t != 1){
			int e = b / t + 1;
			System.out.println("1/"+e);
			int t1 = t * e - b;
			int b1 = b * e;
			if(b1 % t1 == 0){ ///////// important
				b1 /= t1;
				t1 = 1;
			}
			b = b1;
			t = t1;
		}
		System.out.println("1/"+b);
	}
	public static void main(String[] args) {
		EgyptianFraction sol = new EgyptianFraction();
		sol.printEgyptian_Rec(20, 14);
	}

}
