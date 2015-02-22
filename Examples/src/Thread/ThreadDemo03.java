package Thread;

class ThRun implements Runnable{

	@Override
	public void run() {
		for(int i = 0; i < 5; i++){
			try {
				Thread.sleep(1000);
				System.out.println(Thread.currentThread().getName() + ":" + i );
			} 
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
}



public class ThreadDemo03 {

	public static void main(String[] args) {
		Thread t1 = new Thread(new ThRun(), "A");
		Thread t2 = new Thread(new ThRun(), "B");
		Thread t3 = new Thread(new ThRun(), "C");
		t1.setPriority(Thread.MIN_PRIORITY);
		t2.setPriority(Thread.NORM_PRIORITY);
		t3.setPriority(Thread.MAX_PRIORITY);
		// 有可能能够提高线程的首次执行速度（抢到cpu资源），不一定一定能抢到
		t1.start();
		t2.start();
		t3.start();
	}

}
