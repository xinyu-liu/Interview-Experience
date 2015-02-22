package Base;

import java.util.Stack;
public class Base {
	/**
	 * 将 10进制数 转为 任意进制
	 * @param num
	 * @param base
	 * @return
	 */
	public static String baseString(int num,int base){
		if(base > 16){
			throw new RuntimeException("进制数超出范围，base<=16");
		}
		StringBuffer str = new StringBuffer("");
		String digths = "0123456789ABCDEF";
		Stack<Character> s = new Stack<Character>();
		while(num != 0){
			s.push(digths.charAt(num % base));
			num /= base;
		}
		while(!s.isEmpty()){
			str.append(s.pop());
		}
		return str.toString();
	}
	/**
	 * 16进制内任意进制转换
	 * @param num
	 * @param srcBase
	 * @param destBase
	 * @return
	 */
	public static String baseNum(String num,int srcBase,int destBase){
		if(srcBase == destBase){
			return num;
		}
		String digths = "0123456789ABCDEF";
		char[] chars = num.toCharArray();
		int len = chars.length;
		if(destBase != 10){ // 目标进制不是十进制 先转化为十进制
			num = baseNum(num,srcBase,10);
		}else{
			int n = 0;
			for(int i = len - 1; i >=0; i--){
				n +=  digths.indexOf(chars[i]) * Math.pow(srcBase, len - i - 1);
			}
			return n + "";
		}
		return baseString(Integer.valueOf(num),destBase);
	}
}

