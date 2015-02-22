package Thread;
class MyThreadDemo implements Runnable{
	private int ticket = 5;
	/* 
	 * no synchronized
	
	@Override
	public void run() {
		for(int i = 0; i < 10; i++){
			if(ticket > 0){
				try {
					Thread.sleep(500); // 有买票等待的时间
				} 
				catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("ticket: " + ticket--);
			}
		}
	}
	*/
	/*
	 *  synchronized block

	public void run() {
		for(int i = 0; i < 10; i++){
			synchronized(this){
				if(ticket > 0){
					try {
						Thread.sleep(500); // 有买票等待的时间
					} 
					catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("ticket: " + ticket--);
				}				
			}
		}
		
	}
	*/
	/*
	 * synchronized method
	 */
	public void run() {
		for(int i = 0; i < 10; i++){
			tell();
		}
		
	}
	public synchronized void tell(){
		if(ticket > 0){
			try {
				Thread.sleep(500); // 有买票等待的时间
			} 
			catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("ticket: " + ticket--);
		}
	}
}
public class ThreadDemo04 {
/*
 * 五张车票 三个窗口在卖 一辆车
 * 有买票等待的时间
 */
	public static void main(String[] args) {
		MyThreadDemo m = new MyThreadDemo();
		Thread t1 = new Thread(m);
		Thread t2 = new Thread(m);
		Thread t3 = new Thread(m);
		t1.start();
		t2.start();
		t3.start();
	}

}
