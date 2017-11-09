package org.chisty.thread;

public class TestCounterThread {

	public static void main(String[] args) {
		TestCounterThread test = new TestCounterThread();
		// test.executeWithoutLambda();
		// -------------------------------------------
		test.executeWithLambda();
	}

	/**
	 * Using a {@link CounterThread}
	 */
	private void executeWithoutLambda() {
		System.out.println("======== Thread execute without Lambda =========");
		Countersync c = new Countersync();
		CounterThread ct1 = new CounterThread(c);
		CounterThread ct2 = new CounterThread(c);
		ct1.start();
		ct2.start();
	}

	/**
	 * A separate {@link CounterThread} class is not required
	 */
	private void executeWithLambda() {
		System.out.println("======== Thread execute with Lambda =========");
		// Countersync counter = new Countersync();
		AtomicCounter counter = new AtomicCounter();
		Runnable r0 = () -> {
			for (int i = 0; i < 5; ++i) {
				counter.add();
				System.out.println("Thread 0 (Lambda) ----> Count val: " + counter.getCount());
			}
		};
		Runnable r1 = () -> {
			for (int i = 0; i < 5; ++i) {
				counter.add();
				System.out.println("Thread 1 (Lambda) ----> Count val: " + counter.getCount());
			}
		};
		new Thread(r0).start();
		new Thread(r1).start();
	}

}
