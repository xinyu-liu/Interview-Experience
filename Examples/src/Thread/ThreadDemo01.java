package Thread;

public class ThreadDemo01 {

	public static void main(String[] args) {
		// use MyThread class
		MyThread mt1 = new MyThread("A");
		MyThread mt2 = new MyThread("B");
		mt1.start(); // not run()
		mt2.start();
		
		// use MyRunnable class
		MyRunnable mr1 = new MyRunnable("A"); 
		MyRunnable mr2 = new MyRunnable("B"); 
		// no other class function implemented
		// SO
		Thread t1 = new Thread(mr1);
		Thread t2 = new Thread(mr2);
		t1.start();
		t2.start();
		
	}

}
