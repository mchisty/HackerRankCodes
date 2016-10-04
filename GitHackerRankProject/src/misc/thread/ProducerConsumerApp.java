package misc.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;

public class ProducerConsumerApp {
	public static void main(String[] args) {
		ProducerConsumerApp app = new ProducerConsumerApp();
		// app.testWithLinkedBlockingQueue();
		// app.testWithArrayBlockingQueue();
		app.testWithSynchronousQueue();
	}

	private void testWithLinkedBlockingQueue() {
		System.out.println("-------------------------------");
		System.out.println("LinkedBlockingQueue test");
		System.out.println("-------------------------------");
		BlockingQueue<Integer> sharedQue = new LinkedBlockingQueue<>();
		Thread prodThread = new Thread(new Producer(sharedQue));
		Thread consThread = new Thread(new Consumer(sharedQue));
		prodThread.start();
		consThread.start();
	}

	private void testWithArrayBlockingQueue() {
		System.out.println("-------------------------------");
		System.out.println("ArrayBlockingQueue test");
		System.out.println("-------------------------------");
		BlockingQueue<Integer> sharedQue = new ArrayBlockingQueue<>(3);
		Thread prodThread = new Thread(new Producer(sharedQue));
		Thread consThread = new Thread(new Consumer(sharedQue));
		prodThread.start();
		consThread.start();
	}

	private void testWithSynchronousQueue() {
		System.out.println("-------------------------------");
		System.out.println("SynchronousQueue test");
		System.out.println("-------------------------------");
		BlockingQueue<Integer> sharedQue = new SynchronousQueue<>();
		Thread prodThread = new Thread(new Producer(sharedQue));
		Thread consThread = new Thread(new Consumer(sharedQue));
		prodThread.start();
		consThread.start();
	}
}
