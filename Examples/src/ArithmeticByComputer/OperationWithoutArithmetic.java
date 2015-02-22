package ArithmeticByComputer;

public class OperationWithoutArithmetic {
	/*
	 * �Ѽ���ֳ�����:
	 * ��һ����λ��ӵ����ƽ�λ���õ��Ľ����10100�����һλ����������1����ӵĽ���Ƕ����Ƶ�10����һ�����ƽ�λ����˽����Ȼ��0����
	 * �ڶ������½�λ�������������ֻ�����һλ���ʱ����һ����λ������Ƕ����Ƶ�10��
	 * ��������ǰ�����Ľ����ӣ��õ��Ľ����10110��������22��
	 *   �������ǿ��Թ���һ���㷨�����õݹ��˼�룩����������λ��������㣨�൱�ڲ����ǽ�λ�ļӷ����������벢����һλ��ǰ��λ��
         ���Ͻ�λ�������õݹ飬��Ϊû��һ�ζ����ܲ�����λ����λΪ0��ֹͣ����
	 */
	private static int add(int num1, int num2) {
		if(num2 == 0) return num1;
		int ans = num1 ^ num2;
		int carry = (num1&num2) << 1;
		return add(ans, carry);
	}
/*
 * ���꣺
˳����һ�������ڲ������µı���������½�������int�ķ���������Ҫ����a��b��
�������㷨������Ƚ���Ϥ�ˡ�
a = a + b;
b = a - b;
a = a - b;
λ���㷨�������ã����Ǹ��򵥣�
a = a ^ b;
b = a ^ b;
a = a ^ b;
 */
/*
 * Subtract: Based on Two's Complement
 * Reference : http://en.wikipedia.org/wiki/Two's_complement 
 */
	public static int negative (int x) {
		return add(~x,1);
	}
	
	public static int subtract(int x, int y){
		return add(x, negative(y));
	}
	/*
	 * Multiply: Using Ethiopian Multiplication 
	 * Reference : http://rosettacode.org/wiki/Ethiopian_multiplication

��15(x)*13(y)��������15*13 Ϊ1111*1101
a.����y�����λΪ1(2^0)��x����0λ�õ�1111
b.Ȼ��y����͵ڶ�λΪ0��û��2^1���ڣ���˱���������(������Կ���Ϊ0)
c.Ȼ��y����͵���λΪ1(2^2)��x����2λ�õ�111100
d.Ȼ��y����͵���λΪ1(2^3)��x����3λ�õ�1111000
e.��a��b��c��d�Ľ�����1111+0+111100+1111000=11000011(195),�ý�����ǳ˷��Ľ��
	 */	
	public static boolean isEven (int x) {
		return (x & 1) == 0;
	}

	public static int multiply (int x, int y){
		if (x<0 && y<0){
			return multiply(negative(x),negative(y));
		}
		if (x<0 && y>=0){
			return multiply(y,x);
		}
		// below: same as what i wrote
		int ret = 0;
		while (x>0) {
			if (!isEven(x)){
				ret = add(ret,y);
			}
			x>>=1;
/*		 ��λ��������� (>>)
		 -14���������Ƶ� 11110010��������λ����� -4���������Ƶ� 11111100����
		 �޷�������λ����� (>>>)
		 -14�������Ʋ��� 11111111 11111111 11111111 11110010��������λ��ֵ���� 1073741820���������Ƶ� 00111111 11111111 11111111 11111100����
		 >>>���޷������ƣ��ڸ�λ���� 
		 >>�Ǵ����ŵ����ƣ�������������ڸ�λ���㣬������1
		 
		 ��λ��������� (<<) 
*/
		y<<=1;
		}
		return ret;
	}
	
	public static void main(String[] args){
		int ret = OperationWithoutArithmetic.add(-3,5);
		System.out.println(" -3 + 5    ---->" + ret);
		ret = OperationWithoutArithmetic.subtract(0,-1);
		System.out.println(" 0 - (-1)  ---->" + ret);
		ret = OperationWithoutArithmetic.subtract(0,5);
		System.out.println(" 0 - 5     ---->" + ret);
		ret = OperationWithoutArithmetic.multiply(0,0);
		System.out.println(" 0 * 0     ---->" + ret);
		ret = OperationWithoutArithmetic.multiply(0,-32);
		System.out.println(" 0 * (-32) ---->" + ret);
		ret = OperationWithoutArithmetic.multiply(8,0);
		System.out.println(" 8 * 0     ---->" + ret);
		ret = OperationWithoutArithmetic.multiply(-7,-3);
		System.out.println(" -7 * (-3) ---->" + ret);
		ret = OperationWithoutArithmetic.multiply(-7,2);
		System.out.println(" -7 * 2    ---->" + ret);
	}
}



