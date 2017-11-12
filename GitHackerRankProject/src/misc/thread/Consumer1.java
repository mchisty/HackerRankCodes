
package misc.thread;

import java.util.concurrent.BlockingQueue;

public class Consumer1 implements Runnable {

	private BlockingQueue<Integer> sharedQue = null;

	public Consumer1(BlockingQueue<Integer> sharedQue) {
		this.sharedQue = sharedQue;
	}

	@Override
	public void run() {
		while (true) {
			try {
				Integer itemNumber = sharedQue.take();
				System.out.println(" <--- Consume " + itemNumber);
				// Exit loop when certain condition achieved
				if (itemNumber >= ProducerConsumerApp1.NO_OF_ITEMS - 1) {
					break;
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
