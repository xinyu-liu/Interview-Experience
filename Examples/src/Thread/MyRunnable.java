package Thread;

public class MyRunnable implements Runnable{
	
	private String name;
	
	public MyRunnable(String name){
		this.name = name;
	}
	
	@Override
	public void run() {
		for(int i = 0; i < 50; i++){
			try {
				Thread.sleep(1000); //////////////////////
			} 
			catch (InterruptedException e) {
				e.printStackTrace();
			} // one second
			System.out.println(name+":"+i); // A:45
			System.out.println("Current thread object('s name):"
					+Thread.currentThread().getName());// Thread-1
			
		}
		
	}
	
}
