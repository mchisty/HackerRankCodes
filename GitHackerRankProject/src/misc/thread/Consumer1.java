
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
				if (itemNumber >= 9) { // Exit loop
					break;
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
