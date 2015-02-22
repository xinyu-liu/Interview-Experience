package Enum;


public enum Direction{
	// Direction是java.lang.Enum的子类，不能够再继承其他父类。
	
    UP(5){ // UP(5)替代静态初始化块, UP.value = 5;
    	// UP后面的{}产生一个继承于Direction的匿名类
    	////////////////////////// UP class //////////////////////
    	@Override
    	void foo(){
    		System.out.println(UP);
    	}
    }, 
    	  DOWN,LEFT,RIGHT; // 枚举值都是public static final
  
    
    ////////////////////////// Direction class //////////////////////
    void foo(){}
    
    static void test2(){
    	UP.foo();
    }

    
    static{
    	RIGHT.value = 10;
    }
    
    private int value; // 自己定义的其他成员变量
    
    private Direction(int value){
    	this.value = value;
    }
    private Direction(){ // needed!
      	this(0);
    }
    static void test(){
    	for(Direction d1: Direction.values()){
    		System.out.println(d1);
    	}
    	System.out.println(UP instanceof Direction);
    	System.out.println(UP instanceof Enum);
    	System.out.println(UP instanceof Comparable);
    	System.out.println(UP.name()    // String常量"UP"
    			+ ":" + UP.ordinal()    // int值，默认为基于0的排列序号
    			+ " value" + UP.value); // 自己定义的其他成员变量
    	System.out.println(UP.compareTo(LEFT)); // 计算枚举值ordinal()之差
    }
    public static void main(String[] args){
    	test();
    	test2();
    }
}