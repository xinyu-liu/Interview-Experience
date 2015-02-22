package Enum;

public class DirectionTester {
/*
 * Direction中定义了方法实例方法foo()，UP后面的{}产生一个继承于Direction的匿名类。
 * 不能够使用new创建枚举类型的对象，因为枚举类型的构造器都视为私有。
 * 外界使用方式：Direction.UP.foo();
 */
	public static void main(String[] args) {
		// first call		
		Direction.UP.foo();
		
		// second call
		Direction d = Direction.DOWN;
		d.foo(); // parent method - do nothing  
	}
}
