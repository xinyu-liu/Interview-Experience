package Enum;

public class DirectionTester {
/*
 * Direction�ж����˷���ʵ������foo()��UP�����{}����һ���̳���Direction�������ࡣ
 * ���ܹ�ʹ��new����ö�����͵Ķ�����Ϊö�����͵Ĺ���������Ϊ˽�С�
 * ���ʹ�÷�ʽ��Direction.UP.foo();
 */
	public static void main(String[] args) {
		// first call		
		Direction.UP.foo();
		
		// second call
		Direction d = Direction.DOWN;
		d.foo(); // parent method - do nothing  
	}
}
