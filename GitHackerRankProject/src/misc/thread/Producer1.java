
package misc.thread;

import java.util.concurrent.BlockingQueue;

public class Producer1 implements Runnable {

	private BlockingQueue<Integer> sharedQue = null;

	public Producer1(BlockingQueue<Integer> sharedQue) {
		this.sharedQue = sharedQue;
	}

	@Override
	public void run() {
		for (int i = 0; i < ProducerConsumerApp1.NO_OF_ITEMS; ++i) {
			try {
				sharedQue.put(i);
				System.out.print("Produced item: " + i + "...");
				// Thread.sleep(100); // Try with commenting this
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
