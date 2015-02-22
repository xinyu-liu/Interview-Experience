package Pattern_StatePattern_FiniteStateMachine_WithEnum;

public class AirCon {
//两个按钮(更多的按钮奋斗在后面的例子中引入)，power/电源键和cool/制冷键

	State state = State.OFF; // 起始状态为Off 
	public void power(){
		state.power(this);
	}
	public void cool(){
		state.cool(this);
	}
	
	// test
	 public static void test(){  
		 AirCon ac = new AirCon();  
	     System.out.println("Current State:" + ac.state.name());  
	     ac.cool();  
	     ac.power();  
	     ac.cool();  
	     ac.cool();  
	     ac.power();  
	     ac.power();  
	     ac.power();  
	          
	 } 
	 public static void main(String[] args){
		 test();
	 }
}
