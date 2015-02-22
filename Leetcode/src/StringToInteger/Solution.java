package StringToInteger;

public class Solution {
	/*
	 * 有必要解释一下题目的要求：

1. 首先需要丢弃字符串前面的空格；

2. 然后可能有正负号（注意只取一个，如果有多个正负号，那么说这个字符串是无法转换的，返回0。比如测试用例里就有个“+-2”）；

3. 字符串可以包含0~9以外的字符，如果遇到非数字字符，那么只取该字符之前的部分，如“-00123a66”返回为“-123”；

4. 如果超出int的范围，返回边界值（2147483647或-2147483648）。use long

http://blog.csdn.net/ljiabin/article/details/40508889
	 */
    public int atoi(String str) {
    	if(str == null || str.length() == 0){
    		return 0;
    	}
        int i = 0;
        long ans = 0; // long:   > Integer.MAX_VALUE
        boolean isNegative = false;
        while(i < str.length() && str.charAt(i) == ' ') i++;
        if(i < str.length() && (str.charAt(i) == '-' || str.charAt(i) == '+')) {
        	if(str.charAt(i) == '-')	isNegative = true;
        	i++;
        	if(i < str.length() && (str.charAt(i) > '9' || str.charAt(i)  < '0')){
        		return 0;
        	}
        }
        
        while(i < str.length() && (str.charAt(i) <= '9' && str.charAt(i)  >= '0')){
        	int d = (int)(str.charAt(i) - '0');
        	ans = ans * 10 + d;	
        	
        	if (!isNegative && ans >= Integer.MAX_VALUE )
        		return Integer.MAX_VALUE;
        	else if (isNegative && (-1)*ans <= Integer.MIN_VALUE )
        		return Integer.MIN_VALUE;
        	
        	i++;
        }
        ans = isNegative ? -1*ans : ans;

        return (int)ans ;
    }
}
