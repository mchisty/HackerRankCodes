
package misc.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;

public class ProducerConsumerApp1 {

	public final static int NO_OF_ITEMS = 10;

	public static void main(String[] args) {
		ProducerConsumerApp1 app = new ProducerConsumerApp1();
		// app.testWithLinkedBlockingQueue();
		app.testWithArrayBlockingQueue();
		// app.testWithSynchronousQueue();
	}

	private void testWithLinkedBlockingQueue() {
		System.out.println("-------------------------------");
		System.out.println("LinkedBlockingQueue test");
		System.out.println("-------------------------------");
		BlockingQueue<Integer> sharedQue = new LinkedBlockingQueue<>();
		Thread prodThread = new Thread(new Producer1(sharedQue));
		Thread consThread = new Thread(new Consumer1(sharedQue));
		prodThread.start();
		consThread.start();
	}

	/**
	 * 
	 */
	private void testWithArrayBlockingQueue() {
		System.out.println("-------------------------------");
		System.out.println("ArrayBlockingQueue test");
		System.out.println("-------------------------------");
		BlockingQueue<Integer> sharedQue = new ArrayBlockingQueue<>(1);
		Thread prodThread = new Thread(new Producer1(sharedQue));
		Thread consThread = new Thread(new Consumer1(sharedQue));
		prodThread.start();
		consThread.start();
	}

	private void testWithSynchronousQueue() {
		System.out.println("-------------------------------");
		System.out.println("SynchronousQueue test");
		System.out.println("-------------------------------");
		BlockingQueue<Integer> sharedQue = new SynchronousQueue<>();
		Thread prodThread = new Thread(new Producer1(sharedQue));
		Thread consThread = new Thread(new Consumer1(sharedQue));
		prodThread.start();
		consThread.start();
	}
}
