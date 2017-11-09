package misc;

public class ThreadTest2 {

	static Runnable t1 = new Runnable() {
		@Override
		public void run() {
			try {
				System.out.print("t1before");
				Thread.sleep(100);
				System.out.print("t1after");
			} catch (InterruptedException e) {
			}
		}
	};

	static Thread t2 = new Thread() {
		@Override
		public void run() {
			try {
				System.out.print("t2before");
				synchronized (this) {
					wait();
				}
				System.out.print("t2after");
			} catch (InterruptedException e) {
			}
		}
	};

	public static void main(String[] args) {
		new Thread(t1).start();
		t2.start();
	}

}
