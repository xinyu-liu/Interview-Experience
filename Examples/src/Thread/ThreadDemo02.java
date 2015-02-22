package Thread;
class RunnableDemo implements Runnable{
	private String name;
	
	public RunnableDemo(String name){
		this.name = name;
	}
	
	@Override
	public void run() {
		for(int i = 0; i < 50; i++){
			/*
			try {
				Thread.sleep(1000); //////////////////////
			} 
			catch (InterruptedException e) {
				e.printStackTrace();
			} // one second
			*/
			
			System.out.println(name+":"+i); // A:45
			System.out.println("Current thread object('s name):"
					+Thread.currentThread().getName());// Thread-1
			
			
			////////////// yield()
			if(i == 10){
				System.out.println("礼让");
				Thread.yield();
			}
		}
		
	}
	
}
public class ThreadDemo02 {

	public static void main(String[] args) {
		RunnableDemo r1 = new RunnableDemo("A");
		RunnableDemo r2 = new RunnableDemo("B");
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		
		System.out.println(t1.isAlive());/////////////
		t1.start();
		t2.start();
		System.out.println(t1.isAlive());
		
		/*
		// 程序运行先执行主线程
		for(int i = 0; i < 50; i++){
			if(i > 10){				
				try {
					t1.join(); // 此时这个t线程强行执行
				} 
				catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println("main thread: "+ i);
		}
		*/
	}

}
