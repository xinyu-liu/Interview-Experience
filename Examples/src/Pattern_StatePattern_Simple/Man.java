package Pattern_StatePattern_Simple;
/*
 * 当一个类A的某个成员变量的值变化时，可能导致多个行为表现得不同。将该成员变量封装成类型的模式，即为状态模式（state pattern）。
   编程技巧：以多态来重构分支结构。 => 增加新的状态值，在分支结构下违反OCP。
   设计思路：解决状态添加、状态转换、状态对行为的影响问题。
   重构的要点：
   1.以状态类State替代boolean、int、枚举类型或类型(注意这种情况)的分支判断参数，显然有多少分支，State将对应有多少子类。
   2.状态类State将所有具有上述分支判断的方法，提取为自己的接口，State的子类分别给出配套的实现。

 */
public class Man {
	private State state;
	
	public Man(State s){
		state = s;
	}
	public String sayHello() {
        return state.sayHello();
    }
    public String sayGoodbye() {
        return state.sayGoodbye();      
    }
    
    public static void main(String[] args) {
		Man one = new Man( new FriendState() );// 设置 State的对象类型 改变其状态
		System.out.println(one.sayHello());
		System.out.println(one.sayGoodbye());
	}
}