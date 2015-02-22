package Base;

import java.util.Stack;
public class Base {
	/**
	 * �� 10������ תΪ �������
	 * @param num
	 * @param base
	 * @return
	 */
	public static String baseString(int num,int base){
		if(base > 16){
			throw new RuntimeException("������������Χ��base<=16");
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
	 * 16�������������ת��
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
		if(destBase != 10){ // Ŀ����Ʋ���ʮ���� ��ת��Ϊʮ����
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

