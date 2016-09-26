package misc.thread;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {
	private BlockingQueue<Integer> sharedQue = null;

	public Producer(BlockingQueue<Integer> sharedQue) {
		this.sharedQue = sharedQue;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; ++i) {
			System.out.println("Produce " + i);
			try {
				// sharedQue.add(i); // Cannot use add() with SynchronousQueue
				sharedQue.put(i);
				// Thread.sleep(50);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// --------------------------------------------
	}
}
