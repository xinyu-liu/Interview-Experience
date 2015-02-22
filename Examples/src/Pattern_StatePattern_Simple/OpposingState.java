package Pattern_StatePattern_Simple;

public class OpposingState implements State{
	@Override 
	public String sayHello() {
	    return "好";
	}
	public String sayGoodbye() {
	    return  "再见，再也不见";      
	}
}
