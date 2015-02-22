package Enum;


public enum Direction{
	// Direction��java.lang.Enum�����࣬���ܹ��ټ̳��������ࡣ
	
    UP(5){ // UP(5)�����̬��ʼ����, UP.value = 5;
    	// UP�����{}����һ���̳���Direction��������
    	////////////////////////// UP class //////////////////////
    	@Override
    	void foo(){
    		System.out.println(UP);
    	}
    }, 
    	  DOWN,LEFT,RIGHT; // ö��ֵ����public static final
  
    
    ////////////////////////// Direction class //////////////////////
    void foo(){}
    
    static void test2(){
    	UP.foo();
    }

    
    static{
    	RIGHT.value = 10;
    }
    
    private int value; // �Լ������������Ա����
    
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
    	System.out.println(UP.name()    // String����"UP"
    			+ ":" + UP.ordinal()    // intֵ��Ĭ��Ϊ����0���������
    			+ " value" + UP.value); // �Լ������������Ա����
    	System.out.println(UP.compareTo(LEFT)); // ����ö��ֵordinal()֮��
    }
    public static void main(String[] args){
    	test();
    	test2();
    }
}