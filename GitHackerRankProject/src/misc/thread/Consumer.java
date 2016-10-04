package misc.thread;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {
	private BlockingQueue<Integer> sharedQue = null;

	public Consumer(BlockingQueue<Integer> sharedQue) {
		this.sharedQue = sharedQue;
	}

	@Override
	public void run() {
		while (true) {
			try {
				System.out.println(" <--- Consume " + sharedQue.take());

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
