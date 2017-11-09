
package misc;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 
 * Note:
 * 
 * - The unlock statement is always called in the finally block to ensure that
 * the lock is released even if an exception is thrown in the method body(try
 * block).
 * 
 * - The constructor for ReentrantLock accepts an optional fairness parameter
 * (true or false). When set to true, locks favor granting access to the
 * longest-waiting thread. Otherwise this lock does not guarantee any particular
 * access order.
 * 
 * - It is recommended practice to always immediately follow a call to lock with
 * a try block, most typically in a before/after construction.
 * 
 * @author isadmlc
 *
 */
public class ReentrantLockWorker implements Runnable {

	private String name;

	private ReentrantLock re;

	public ReentrantLockWorker(String n, ReentrantLock r) {
		this.name = n;
		this.re = r;
	}

	@Override
	public void run() {
		boolean done = false;
		SimpleDateFormat sd = new SimpleDateFormat("hh:mm:ss");
		while (!done) {
			boolean isFree = re.tryLock();
			if (isFree) {
				try {
					System.out.println("*** Lock acquired by task: " + name + " at the time: "
							+ sd.format(Calendar.getInstance().getTimeInMillis()));
					Thread.sleep(200);
					System.out.println("Lock Hold Count:" + re.getHoldCount());
					done = true;
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					re.unlock();
					System.out.println("task: " + name + " work done, Releasing lock.");
					System.out.println("----------------------------------------------------");
				}
			} else {
				System.out.println("task name - " + name + " waiting for lock");
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
