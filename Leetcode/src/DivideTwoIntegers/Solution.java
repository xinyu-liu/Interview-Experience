package DivideTwoIntegers;

public class Solution {
    public int divide(int dividend, int divisor) {
    	boolean neg =false;
    	if( !(dividend < 0 && divisor <0) && (dividend < 0 || divisor <0)){
    		neg = true;
    	}
    	// 以下四个分开写 因为之前代码在执行 divide(-1010369383, -2147483648) 出现错误。
    	// 原因在于 开始的 dividend = (0 - dividend); 补码表示下，int下限绝对值比上限绝对值大1。
    	// dividend = -2147483648时，0-dividend 结果并非是2147483648。

    	long divisorL = divisor;
    	divisorL = Math.abs( divisorL );  
        long dividendL = dividend;
        dividendL = Math.abs( dividendL );  
        
        long ans = 0;
        
        while(dividendL >= divisorL){
	        long d = divisorL;
	        long count = 1;
	        while(d <= dividendL){
	        	count<<=1;
	        	d<<=1;
	        }
	        dividendL -= d>>1;
	        ans += count>>1;
        }
        return (int) (neg? (-1)*ans: ans);
    }
}
