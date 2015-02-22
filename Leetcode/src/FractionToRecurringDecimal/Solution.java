package FractionToRecurringDecimal;

import java.util.HashMap;
import java.util.Map;

public class Solution {
/*
 * 
Input:	-50, 8
Output:	"-6.-2-5"
Expected:	"-6.25"
 *
 *
Input:	-1, -2147483648
Output:	"-0.0000000000000000000000000000001"
Expected:	"0.0000000004656612873077392578125"
=> long

 */
    public String fractionToDecimal(int numerator, int denominator) {
        long n = numerator;
        long d = denominator;
        // integer part
        StringBuffer in = new StringBuffer();
        if(n * d < 0){
            in.append("-");
        }
        n = Math.abs(n);
        d = Math.abs(d);
       
        in.append(n / d);
        
        // fractional part
        StringBuffer fr = new StringBuffer();
        fr.append('.');
        Map<Long,Integer> rems = new HashMap<Long,Integer>();
        int pos = 1;
        long rem = n % d;
        while(rem != 0){
            Integer i = rems.get(rem);
            if(i == null){
                rems.put(rem,pos++);
            }
            else{
               in.append( fr.substring(0,i) ) ;
               in.append("("+ fr.substring(i) +")");
               break;
            }
            fr.append((long)10 * rem / d);
            rem = ((long)10 * rem) % d;
        }
        if(rem == 0 && fr.length()>1){
            in.append( fr.toString() ) ;
        }
    
        return in.toString();
    }
}
