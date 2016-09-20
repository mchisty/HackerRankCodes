package misc.thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ProducerConsumerApp {
	public static void main(String[] args) {
		BlockingQueue<Integer> sharedQue = new LinkedBlockingQueue();
		Thread prodThread = new Thread(new Producer(sharedQue));
		Thread consThread = new Thread(new Consumer(sharedQue));
		prodThread.start();
		consThread.start();
	}
}
