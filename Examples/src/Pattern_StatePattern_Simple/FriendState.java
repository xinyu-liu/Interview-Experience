package Pattern_StatePattern_Simple;

public class FriendState implements State{
	@Override 
	public String sayHello() {
	    return "你好，我的朋友";
	}
	public String sayGoodbye() {
	    return  "再抱抱！";      
	}
}
