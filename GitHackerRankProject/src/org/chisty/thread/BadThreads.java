
package org.chisty.thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * The expected result: application should print out "Eat oats". Is it
 * guaranteed to always do this? If we do not use join, it prints null.
 * 
 */
public class BadThreads {

	static String message = null;

	static final AtomicInteger count = new AtomicInteger(0);

	private static class CorrectorThread extends Thread {

		@Override
		public void run() {
			count.incrementAndGet();
			message = "Eat oats";
		}
	}

	/**
	 * 
	 * There are two ways you can guarantee that all changes to message will be
	 * visible to the main thread:
	 * 
	 * 1. In the main thread, retain a reference to the CorrectorThread
	 * instance. Then invoke join on that instance before referring to message.
	 * <br/>
	 * 
	 * or,
	 * 
	 * 2. Encapsulate message in an object with synchronized methods. Never
	 * reference message except through those methods.
	 * 
	 * Note: I took the first approach
	 * 
	 */
	public static void main(String[] args) throws InterruptedException {
		CorrectorThread ct = new CorrectorThread();
		ct.start();
		// ------------------------------------------------------------------
		// Try with uncommenting this. This will show the expected result
		// ------------------------------------------------------------------
		// ct.join(); // Without this line, prints null
		System.out.println(count.get());
		System.out.println(message);
	}
}
