package AddBinary;

public class Solution {
    public String addBinary(String a, String b) {
        
        int m = a.length();
        int n = b.length();   
        StringBuffer sb = m >= n ? 
        		new StringBuffer(a):new StringBuffer(b);
        int carry = 0;
        int i = m-1;
        int j = n-1;
        while(i >= 0 || j >= 0){
        	int temp = (i>=0 ? (int)(a.charAt(i)-'0'):0) 
        			 + (j>=0 ? (int)(b.charAt(j)-'0'):0) 
        			 + carry;
        	carry = temp / 2;
        	temp = temp % 2;
        	sb.setCharAt(Math.max(i,j), (char)(temp+'0'));
        	i--;
        	j--;
        }
        if(carry>0){
        	return String.valueOf(carry) + sb.toString();
        }
        else{
        	return sb.toString();
        }
    }
}
