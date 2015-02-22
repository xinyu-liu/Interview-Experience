package Pattern_StatePattern_FiniteStateMachine_WithEnum;

public class AirCon {
//������ť(����İ�ť�ܶ��ں��������������)��power/��Դ����cool/�����

	State state = State.OFF; // ��ʼ״̬ΪOff 
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
