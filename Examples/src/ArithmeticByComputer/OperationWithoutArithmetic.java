package ArithmeticByComputer;

public class OperationWithoutArithmetic {
	/*
	 * 把计算分成三步:
	 * 第一步各位相加但不计进位，得到的结果是10100（最后一位两个数都是1，相加的结果是二进制的10。这一步不计进位，因此结果仍然是0）；
	 * 第二步记下进位。在这个例子中只在最后一位相加时产生一个进位，结果是二进制的10；
	 * 第三步把前两步的结果相加，得到的结果是10110，正好是22。
	 *   于是我们可以构造一个算法（运用递归的思想）：两个数按位做异或运算（相当于不考虑进位的加法），再相与并左移一位向前进位，
         加上进位（可以用递归，因为没加一次都可能产生进位，进位为0就停止）。
	 */
	private static int add(int num1, int num2) {
		if(num2 == 0) return num1;
		int ans = num1 ^ num2;
		int carry = (num1&num2) << 1;
		return add(ans, carry);
	}
/*
 * 引申：
顺便提一提怎样在不定义新的变量的情况下交换两个int的方法。假设要交换a和b。
四则运算法，这个比较熟悉了。
a = a + b;
b = a - b;
a = a - b;
位运算法，不常用，但是更简单：
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

用15(x)*13(y)来举例，15*13 为1111*1101
a.首先y的最低位为1(2^0)，x左移0位得到1111
b.然后y的最低第二位为0，没有2^1存在，因此本次无运算(结果可以看作为0)
c.然后y的最低第三位为1(2^2)，x左移2位得到111100
d.然后y的最低第四位为1(2^3)，x左移3位得到1111000
e.把a、b、c、d的结果相加1111+0+111100+1111000=11000011(195),该结果就是乘法的结果
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
/*		 按位右移运算符 (>>)
		 -14（即二进制的 11110010）右移两位后等于 -4（即二进制的 11111100）。
		 无符号右移位运算符 (>>>)
		 -14（二进制补码 11111111 11111111 11111111 11110010）右移两位后，值等于 1073741820（即二进制的 00111111 11111111 11111111 11111100）。
		 >>>是无符号右移，在高位补零 
		 >>是带符号的右移，如果是正数则在高位补零，负数则补1
		 
		 按位左移运算符 (<<) 
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



