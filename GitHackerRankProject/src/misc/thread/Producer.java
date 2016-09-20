package misc.thread;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {
	private BlockingQueue<Integer> sharedQue;

	public Producer(BlockingQueue<Integer> sharedQue) {
		this.sharedQue = sharedQue;
	}

	@Override
	public void run() {
		for (int i = 0; i < 5; ++i) {
			System.out.println("Produce " + i);
			try {
				sharedQue.put(i);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
