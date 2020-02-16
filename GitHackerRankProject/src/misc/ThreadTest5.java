
package misc;

public class ThreadTest5 extends Thread {

	int code = 9;

	@Override
	public void run() {
		this.code = 7;
	}

	public static void main(String[] args) {
		ThreadTest5 thread = new ThreadTest5();
		thread.start();
		for (int i = 0; i < 10; i++) {
			System.out.println(thread.code);
		}
	}
}
