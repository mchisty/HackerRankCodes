
package org.chisty.thread;

import java.util.concurrent.CountDownLatch;

/**
 * The Class RaceConditionTest. A good example to understand how CountDownLatch
 * works to prohibit Read-Write-Update race condition. A CountDownLatch is
 * initialized with a given count. The await methods block until the current
 * count reaches zero due to invocations of the countDown() method, after which
 * all waiting threads are released and any subsequent invocations of await
 * return immediately.
 * 
 * Expected outcome: <br/>
 * Step 1: Wait message shown <br/>
 * Step 2: Progress count shown with dots like ..1..2..3 etc <br/>
 * Step 3: Finish message displayed
 * 
 * 
 * Note: This is a one-shot phenomenon -- the count cannot be reset. If you need
 * a version that resets the count, consider using a
 * {@link java.util.concurrent.CyclicBarrier}
 * 
 */
public class RaceConditionTest {

	/** The Constant count. */
	final static int count = 20;

	/**
	 * The main method. Test one method at a time.
	 *
	 * 
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		System.out.println("------------------------------------------------- ");
		System.out.println("Race Condition with read-write-update approach");
		System.out.println("------------------------------------------------- ");
		RaceConditionTest rc = new RaceConditionTest();
		// -------------------------------------------------
		// Test one at a time by commenting/uncommenting
		// -------------------------------------------------
		rc.unsafeRWUApproach();
		// rc.safeRWUApproach();
	}

	/**
	 * Unsafe rwu approach.
	 */
	private void unsafeRWUApproach() {
		System.out.println("###### Unsafe approach ######## ");
		Runnable waiter = () -> {
			System.out.println("Step1: Wait progress bar ...");
			System.out.println("\nStep 3: Wait finished. Unsafe approach completed.");
		};
		Runnable decrementar = () -> {
			for (int i = 0; i < count; ++i) {
				try {
					System.out.print(".." + i);
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		new Thread(waiter).start();
		new Thread(decrementar).start();
	}

	/**
	 * Safe rwu approach.
	 * 
	 * @throws InterruptedException
	 */
	private void safeRWUApproach() {
		System.out.println("###### Safe approach ######## ");
		CountDownLatch ct = new CountDownLatch(count);
		Runnable waiter = () -> {
			try {
				System.out.println("Step1: Wait progress bar ...");
				ct.await();
				// After printing, it waits at this point
				System.out.println("\nStep 3: Wait finished. Safe approach completed.");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		};
		Runnable decrementar = () -> {
			for (int i = 0; i < count; ++i) {
				ct.countDown(); // Count down and releases shared mode
				try {
					System.out.print(i + "..");
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		new Thread(waiter).start();
		new Thread(decrementar).start();
	}
}
