
package misc.thread;

import java.util.concurrent.BlockingQueue;

public class Producer1 implements Runnable {

	private BlockingQueue<Integer> sharedQue = null;

	public Producer1(BlockingQueue<Integer> sharedQue) {
		this.sharedQue = sharedQue;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; ++i) {
			System.out.println("Produce " + i);
			try {
				sharedQue.put(i);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
