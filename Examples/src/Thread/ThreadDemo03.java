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
		// �п����ܹ�����̵߳��״�ִ���ٶȣ�����cpu��Դ������һ��һ��������
		t1.start();
		t2.start();
		t3.start();
	}

}
