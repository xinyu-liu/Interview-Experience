package StringToInteger;

public class Solution {
	/*
	 * �б�Ҫ����һ����Ŀ��Ҫ��

1. ������Ҫ�����ַ���ǰ��Ŀո�

2. Ȼ������������ţ�ע��ֻȡһ��������ж�������ţ���ô˵����ַ������޷�ת���ģ�����0�����������������и���+-2������

3. �ַ������԰���0~9������ַ�����������������ַ�����ôֻȡ���ַ�֮ǰ�Ĳ��֣��硰-00123a66������Ϊ��-123����

4. �������int�ķ�Χ�����ر߽�ֵ��2147483647��-2147483648����use long

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
