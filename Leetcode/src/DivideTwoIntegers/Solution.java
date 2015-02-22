package DivideTwoIntegers;

public class Solution {
    public int divide(int dividend, int divisor) {
    	boolean neg =false;
    	if( !(dividend < 0 && divisor <0) && (dividend < 0 || divisor <0)){
    		neg = true;
    	}
    	// �����ĸ��ֿ�д ��Ϊ֮ǰ������ִ�� divide(-1010369383, -2147483648) ���ִ���
    	// ԭ������ ��ʼ�� dividend = (0 - dividend); �����ʾ�£�int���޾���ֵ�����޾���ֵ��1��
    	// dividend = -2147483648ʱ��0-dividend ���������2147483648��

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
